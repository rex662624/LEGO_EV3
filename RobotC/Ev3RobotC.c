#pragma config(StandardModel, "EV3_REMBOT")
#include "JoystickDriver.c"     // Tells ROBOTC to include the driver file for the joystick.

task main()
{
 while(true)
  {
    getJoystickSettings(joystick);  // Update Buttons and Joysticks

     motor[motorB] = joystick.joy1_y1-joystick.joy1_x1;
     motor[motorC] = joystick.joy1_y1+joystick.joy1_x1;
  }
}
