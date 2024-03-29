// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.ADIS16448_IMU;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;

import javax.sound.sampled.Port;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static enum ControllerType{
    PS4,         
    XBOX
  }
  public static ControllerType driver1_type = ControllerType.XBOX;
  public static ControllerType driver2_type = ControllerType.XBOX;

  public static class ControllerXbox{
    public static XboxController driver1 = new XboxController(0);
    public static XboxController driver2 = new XboxController(1);
  }

  public static class ControllerPS4{
    public static PS4Controller driver1 = new PS4Controller(0);
    public static PS4Controller driver2 = new PS4Controller(1);
  }
  




 

  public static class SwerveDriveChassis{
    public static void setMaxSpeed(double _speed){
      kMaxSpeed = _speed;
    }
    public static  double kMaxSpeed = 3; // 3 meters per second MAX=5
    public static final double kMaxAngularSpeed = 2 * Math.PI * 0.6; // 1/2 rotation per second

    public static final Translation2d m_frontLeftLocation = new Translation2d(0.381, 0.381);
    public static final Translation2d m_frontRightLocation = new Translation2d(0.381, -0.381);
    public static final Translation2d m_backLeftLocation = new Translation2d(-0.381, 0.381);
    public static final Translation2d m_backRightLocation = new Translation2d(-0.381, -0.381);
    public static final SwerveDriveKinematics m_kinematics = new SwerveDriveKinematics( m_frontLeftLocation, m_frontRightLocation, m_backLeftLocation, m_backRightLocation);

  }
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

   
  public static enum InitializeWheels{
    LATERAL,         
    VERTICAL;
  }



  public static class AutonomousConstants{
    public static final double kMaxSpeedMetersPerSecond = 1;
    public static final double kMaxAccelerationMetersPerSecondSquared = 1;
    public static final double kMaxAngularSpeedRadiansPerSecond = SwerveDriveChassis.kMaxAngularSpeed / 10; //10
    public static final double kMaxAngularAccelerationRadiansPerSecondSquared =  Math.PI / 4;
    public static final TrapezoidProfile.Constraints kThetaControllerConstraints = 
      new TrapezoidProfile.Constraints(
        kMaxAngularSpeedRadiansPerSecond,
        kMaxAngularAccelerationRadiansPerSecondSquared
      );
  }

  
  public static enum ChassisMode{
    MANUAL,         
    DRIVEDISTANCE,  
    CENTEROBJECT;   
  }
  

  

  public static class IMURobot{
    private static final ADIS16448_IMU imu = new ADIS16448_IMU();

    public IMURobot(){
      imu.calibrate();
    }
    public static double getPitch(){
      return -imu.getGyroAngleX();
    }
    public static double getRoll(){ //This is the new Pitch
      return imu.getGyroAngleY();
    }
    public static double getYaw(){
      return imu.getGyroAngleZ();
    }
    public static void reset(){
      imu.reset();
    }
    
  }

  
  public static class IMUElevator{
    private static final AHRS ahrs = new AHRS(SerialPort.Port.kUSB);

    public IMUElevator(){
      ahrs.calibrate();
    }
    public static double getPitch(){
      // System.out.println("Displacement: "+ahrs.getDisplacementY());
      return ahrs.getPitch();
    }
    public static double getRoll(){
      return ahrs.getRoll();
    }
    public static double getYaw(){
      return ahrs.getYaw();
    }
    
  }
  
}
