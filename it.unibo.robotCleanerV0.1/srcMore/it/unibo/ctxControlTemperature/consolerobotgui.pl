%====================================================================================
% Context ctxControlTemperature  SYSTEM-configuration: file it.unibo.ctxControlTemperature.consoleRobotGui.pl 
%====================================================================================
context(ctxrobotcleaner, "localhost",  "TCP", "8032" ).  		 
context(ctxconsolerobotgui, "localhost",  "TCP", "8034" ).  		 
context(ctxcontroltemperature, "localhost",  "TCP", "8033" ).  		 
%%% -------------------------------------------
qactor( console , ctxconsolerobotgui, "it.unibo.console.MsgHandle_Console"   ). %%store msgs 
qactor( console_ctrl , ctxconsolerobotgui, "it.unibo.console.Console"   ). %%control-driven 
qactor( tester , ctxconsolerobotgui, "it.unibo.tester.MsgHandle_Tester"   ). %%store msgs 
qactor( tester_ctrl , ctxconsolerobotgui, "it.unibo.tester.Tester"   ). %%control-driven 
%%% -------------------------------------------
eventhandler(evh5,ctxcontroltemperature,"it.unibo.ctxControlTemperature.Evh5","usercmd").  
%%% -------------------------------------------

