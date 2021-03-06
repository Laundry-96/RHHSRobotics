/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Victor;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class IntegratedCode2013 extends IterativeRobot {
    RobotDrive drive;
    Joystick leftStick,rightStick,turretStick;
    double leftValue,rightValue;
    Relay turretMotor;
    Jaguar shooter, shooter2;
    Relay angler, angler2;
    Victor feeder;
    
    final double SECONDS_FOR_180 = 3.4;
    double secondsPerDegree = SECONDS_FOR_180 / 180;
    int degreeCounterClock = 0;    
    int degreeCounterCounterClock = 0;    
    double secCounterClock = 0;    
    double secCounterCounterClock = 0;    
    
    public void rotateClock180() {
        /*if (degreeCounterClock <= 180) {
            turretMotor.set(Relay.Value.kForward);
            Timer.delay(secondsPerDegree);
            degreeCounterClock++;
            System.out.println("rotateClock180: We're counting @ "+degreeCounterClock);
        }*/
        if (secCounterClock <= SECONDS_FOR_180) {
            turretMotor.set(Relay.Value.kForward);
            Timer.delay(0.1);
            secCounterClock += 0.1;
            System.out.println("rotateClock180: We're counting @ "+secCounterClock);
        }
    }
    public void rotateCounterClock180() {
        /*turretMotor.set(Relay.Value.kReverse);
        Timer.delay(3.4);
        turretMotor.set(Relay.Value.kOff);*/
        /*if (degreeCounterCounterClock <= 180) {
            turretMotor.set(Relay.Value.kForward);
            Timer.delay(secondsPerDegree);
            degreeCounterCounterClock++;
            System.out.println("rotateCounterClock180: We're counting @ "+degreeCounterCounterClock);
        }*/
        if (secCounterCounterClock <= SECONDS_FOR_180) {
            turretMotor.set(Relay.Value.kReverse);
            Timer.delay(0.1);
            secCounterCounterClock += 0.1;
            System.out.println("rotateCounterClock180: We're counting @ "+secCounterCounterClock);
        }
    }
    
    public void robotInit() 
    {
        // RobotDrive uses PWM 1, 2, 3, and 4
        drive = new RobotDrive(1,2,3,4); // j/k
        
        // turretMotor uses Relay output 1
        turretMotor = new Relay(1);
        
        angler = new Relay(2);
        angler = new Relay(3);
        
        feeder = new Victor(7);
       
        // Joystick: leftStick uses Joystick 1
        leftStick = new Joystick(1);
        
        // Joystick: rightStick uses Joystick 2
        rightStick = new Joystick(2);
        
        // Joystick: turretStick uses Joystick 3
        turretStick = new Joystick(3);
        
        shooter = new Jaguar(5);
        shooter2 = new Jaguar(6);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        
        if (leftStick.getTrigger())
            // Just pass leftStick.getY() to both arguments so that both sides get
            // the same value, hence forward/backward with one stick.
            // Technically, you could do:
            // drive.tankDrive(leftStick, leftStick);
            // ...but this makes more sense. :P DEAL WITH IT!!!!1!
            drive.tankDrive(leftStick.getY(), leftStick.getY());
        else
            drive.tankDrive(leftStick.getY(), rightStick.getY());
        
        shooter.set(Math.abs(turretStick.getY()));
        shooter2.set(Math.abs(turretStick.getY()));
        
        if(turretStick.getRawButton(2))
        {
            angler.set(Relay.Value.kForward);
            angler2.set(Relay.Value.kForward);
        }
        if(turretStick.getRawButton(3))
        {
            angler.set(Relay.Value.kReverse);
            angler2.set(Relay.Value.kReverse);
        }
        else
    {
            angler.set(Relay.Value.kOff);
            angler2.set(Relay.Value.kOff);
            
    }
       /* if (turretStick.getTrigger())
        {
            Victormotor.set(-1.0,1.0);
        }*/
            
       
    }
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
        
        /*if (turretStick.getRawButton(4))
            
        {
            System.out.println("Going forward!");
            turretMotor.set(Relay.Value.kOn);
            turretMotor.set(Relay.Value.kForward);
        } 
        
        else if (turretStick.getRawButton(5))
        {
            System.out.println("Going backward!");
            turretMotor.set(Relay.Value.kOn);
            turretMotor.set(Relay.Value.kReverse); 
        }
        
        else  
        {
            System.out.println("Stopped!");
            turretMotor.set(Relay.Value.kOff);
        }*/
        
        if (leftStick.getTrigger())
            // Just pass leftStick.getY() to both arguments so that both sides get
            // the same value, hence forward/backward with one stick.
            // Technically, you could do:
            // drive.tankDrive(leftStick, leftStick);
            // ...but this makes more sense. :P DEAL WITH IT!!!!1!
            drive.tankDrive(leftStick.getY(), leftStick.getY());
        else
            drive.tankDrive(leftStick.getY(), rightStick.getY());
        
        if (turretStick.getRawButton(4))
            rotateClock180();
        else {
            //degreeCounterClock = 0;
            secCounterClock = 0;
            turretMotor.set(Relay.Value.kOff);
        }
        if (turretStick.getRawButton(5))
            rotateCounterClock180();
        else {
            //degreeCounterCounterClock = 0;
            secCounterCounterClock = 0;
            turretMotor.set(Relay.Value.kOff);
        }
    }
    
}
