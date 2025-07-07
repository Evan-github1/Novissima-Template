package org.firstinspires.ftc.teamcode.RobotFunctions;

import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.LinkedList;
import java.util.Queue;

public class MacroManager {
    protected Queue<Macro> queue = new LinkedList<>();
    private Gamepad gamepad;
    private boolean running = false;

    public MacroManager(Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    public void start() {
        if (!running) {
            queue.clear();
            defineMacro();
            running = true;
        }
    }

    public void cancel() {
        queue.clear();
        running = false;
    }

    public boolean isRunning() {
        return running;
    }


    public void runNext() {
        if (running && gamepad.atRest() && !queue.isEmpty()) {
            Macro current = queue.poll();
            if (current != null) {
                try {
                    current.activate();
                } catch (InterruptedException e) {
                    cancel();
                }
            }
        }

        if (running && queue.isEmpty()) {
            running = false;  // finished all macros
        }
    }

    public void defineMacro() {} // use anymonous classes to define
}
