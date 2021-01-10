package rokobasi;

import robocode.*;
import java.awt.Color;
import robocode.util.Utils;
import static robocode.util.Utils.normalRelativeAngleDegrees;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html
// https://robocode.sourceforge.io/docs/robocode/robocode/AdvancedRobot.html
// Banzeroday - a robot by (Pedro Davi Dantas da Silva)
public class BanzerodayRobot extends AdvancedRobot {

    private byte direcaoMovimento = 1;
    private double rolamentoInimigo;
    private double ultimaPosicaoInimigo;
  
    public void run() {

        setAdjustGunForRobotTurn(true);
        setAdjustRadarForGunTurn(true);
        setAdjustRadarForRobotTurn(true);

        setBodyColor(Color.black);
        setGunColor(Color.white);
        setRadarColor(Color.green);
        setScanColor(Color.yellow);
        setBulletColor(Color.white);
        
        while (true) {
            if (getEnergy() > 20) { // se a energia for maior que 20 adote atacar
                atacar();
            } else { // se não adote defensivo
                defensivo();
            }
            setTurnRadarRight(360); // radar roda 360 graus pra direita
            execute();
        }
    }

    // quando localizar outro robô
    public void onScannedRobot(ScannedRobotEvent e) {
         // Rolamento absoluto para o alvo
        // Subtrair o rumo atual do radar para se tornar necessário
        double giroRadar = getHeadingRadians() + e.getBearingRadians() - getRadarHeadingRadians();
        setTurnRadarRightRadians(Utils.normalRelativeAngle(giroRadar));
        double giroArma = getHeadingRadians() + e.getBearingRadians() - getGunHeadingRadians();
        setTurnGunRightRadians(Utils.normalRelativeAngle(giroArma));

        if (getGunHeat() == 0) { // pegar temperatura do canhão
            if (e.getDistance() > 150) { // se a distancia do inimigo for maior que 150 dispare mais fraco pois tem mais chance de errar
                setFire(1f);
            } else if (e.getDistance() <= 150) { // se for menor que 150 a distancia dispare mais forte
                setFire(3);
            }
        }
        execute();

        if (getEnergy() < 20) {
            setTurnRight(e.getBearing() + 90 - 30 * 1);
            // Se o robot tem uma pequena descida de vida, assume que ele disparou
            double changeInEnergy = 100 - e.getEnergy();
            if (changeInEnergy > 0 && changeInEnergy <= 3) {
                // Esquiva-se
                int movementDirection = 0;
                setAhead((e.getDistance() / 4 + 25) * movementDirection);
            }
        }
    }

    // O que fazer quando você é atingido por uma bala
    public void onHitByBullet(HitByBulletEvent e) {
        turnLeft(90 - e.getBearing());
        back(200);
    }

    // O que fazer quando você bate em uma parede
    public void onHitWall(HitWallEvent e) {
        double giroDoCanhao = normalRelativeAngleDegrees(e.getBearing() + getHeading() - getGunHeading());
        turnGunRight(giroDoCanhao);
        turnLeft(90 - e.getBearing());
        back(200);
    }

    // quando colidir com outro robô
    public void onHitRobot(HitRobotEvent e) {
        // pegar giro do canhão em direção do inimigo
        double giroDoCanhao = normalRelativeAngleDegrees(e.getBearing() + getHeading() - getGunHeading());
        turnGunRight(giroDoCanhao);
        // dispara com força total
        if (getEnergy() > 30) {
            setFire(5);
        } else if (getEnergy() < 10) {
            setFire(2);
        }
        execute();
    }

    // quando a bala acerta outra
    public void onBulletHitBullet(BulletHitBulletEvent event) {
        setBack(150);
        setTurnRight(90);
    }

    // quando a bala falha - bate na parede
    public void onBulletMissed(BulletMissedEvent event) {
        double giroDoCanhao = normalRelativeAngleDegrees(ultimaPosicaoInimigo + getHeading() - getGunHeading());
        turnGunRight(giroDoCanhao);
        turnLeft(90); // roda o corpo do robô
        ahead(150);
    }

    double normalizarRolamento(double angulo) {
        // normalizar a rotação do canhão
        while (angulo > 180) {
            angulo -= 360;
        }
        while (angulo < -180) {
            angulo += 360;
        }
        return angulo;
    }

    public void atacar() {
        setAhead(100 * direcaoMovimento);
        setTurnRight(normalizarRolamento(rolamentoInimigo + 90 - (10 * direcaoMovimento)));
        if (getTime() % 2 == 0) {
            direcaoMovimento *= -1;
            setAhead(150 * direcaoMovimento);
        }
    }

    // ao vencer
    public void onWin(WinEvent e) {
        int kkk = 1;
        while (true) {
            turnRight(180 * kkk);
            kkk = kkk * -1;
        }
    }

    public void defensivo() {
        setAhead(300 * direcaoMovimento);
        setTurnRight(normalizarRolamento(rolamentoInimigo + 90 - (10 * direcaoMovimento)));
        if (getTime() % 2 == 0) {
            direcaoMovimento *= -1;
            setAhead(150 * direcaoMovimento);
        }
        execute();
    }

}
