%====================================================================================
% Context ctxRobotCleaner  SYSTEM-configuration: file it.unibo.ctxRobotCleaner.robotCleaner.pl 
%====================================================================================
context(ctxrobotcleaner, "localhost",  "TCP", "8032" ).  		 
%%% -------------------------------------------
qactor( mbotcleanercontroller , ctxrobotcleaner, "it.unibo.mbotcleanercontroller.MsgHandle_Mbotcleanercontroller"   ). %%store msgs 
qactor( mbotcleanercontroller_ctrl , ctxrobotcleaner, "it.unibo.mbotcleanercontroller.Mbotcleanercontroller"   ). %%control-driven 
qactor( ledonmbot , ctxrobotcleaner, "it.unibo.ledonmbot.MsgHandle_Ledonmbot"   ). %%store msgs 
qactor( ledonmbot_ctrl , ctxrobotcleaner, "it.unibo.ledonmbot.Ledonmbot"   ). %%control-driven 
qactor( tester , ctxrobotcleaner, "it.unibo.tester.MsgHandle_Tester"   ). %%store msgs 
qactor( tester_ctrl , ctxrobotcleaner, "it.unibo.tester.Tester"   ). %%control-driven 
%%% -------------------------------------------
eventhandler(evh,ctxrobotcleaner,"it.unibo.ctxRobotCleaner.Evh","tempSensor").  
eventhandler(evh2,ctxrobotcleaner,"it.unibo.ctxRobotCleaner.Evh2","usercmd").  
%%% -------------------------------------------

