%====================================================================================
% Context ctxControlTemperature  SYSTEM-configuration: file it.unibo.ctxControlTemperature.consoleRobotGui.pl 
%====================================================================================
context(ctxrobotcleaner, "localhost",  "TCP", "8032" ).  		 
context(ctxconsolerobotgui, "localhost",  "TCP", "8034" ).  		 
context(ctxcontroltemperature, "localhost",  "TCP", "8033" ).  		 
%%% -------------------------------------------
qactor( console , ctxconsolerobotgui, "it.unibo.console.MsgHandle_Console"   ). %%store msgs 
qactor( console_ctrl , ctxconsolerobotgui, "it.unibo.console.Console"   ). %%control-driven 
%%% -------------------------------------------
eventhandler(evh4,ctxcontroltemperature,"it.unibo.ctxControlTemperature.Evh4","usercmd").  
%%% -------------------------------------------

