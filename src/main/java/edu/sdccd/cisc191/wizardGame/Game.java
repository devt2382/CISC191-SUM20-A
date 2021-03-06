package edu.sdccd.cisc191.wizardGame;

import edu.sdccd.cisc191.wizardGame.gui.screen.Window;
import edu.sdccd.cisc191.wizardGame.gui.sound.SoundEffect;

/**
 * Controller class controls GameObject properties and behaviors.
 *
 * @author Jordan Tobin
 * @author Mark Lucernas
 * @auther Tamer Elsawaf
 * Date: 2020-07-24
 */
public class Game {

    /** Class references */
    private Window frame;

    /** Variables that are critical for controlling the Game */
    private int ammo, hp, lives, levelNumber;

    /** Game states */
    private boolean wizardDead = false;
    private boolean gamePaused = false;
    private boolean gameMuted = false;
    private boolean gameOver = false;

    /**
     * Game constructor.
     * Creates new instance of {@code Window} class to set up the view.
     */
    public Game() { this.frame = new Window(this, 1920, 1080, "Wizard Game"); }

    /** Initialize game */
    public void init() {

        // Initialize Wizard stats
        this.ammo = 50;
        this.hp = 100;
        this.lives = 3;
        this.levelNumber = 1;
        // Initialize frame
        this.frame.init();
    }

    /** Accessors methods */
    public Window getFrame()                       { return this.frame; }
    public int getLevelNumber()                    { return this.levelNumber; }
    public int getAmmo()                           { return this.ammo; }
    public int getLives()                          { return this.lives; }
    public int getHp()                             { return this.hp; }
    public boolean isWizardDead()                  { return this.wizardDead; }
    public boolean isGamePaused()                  { return this.gamePaused; }
    public boolean isGameOver()                    { return this.gameOver; }
    public boolean isGameSoundMuted()              { return this.gameMuted; }

    /** Modifiers methods */
    public void setHp(int hp)                      { if (hp >= 0) this.hp = hp; else this.hp = 0; }
    public void setAmmo(int ammo)                  { if (ammo >= 0) this.ammo = ammo; else this.ammo = 0; }
    public void setLives(int lives)                { if (lives >= 0) this.lives = lives; else this.lives = 0; }
    public void setLevelNumber(int level)          { this.levelNumber = level; }
    public void setGameOver(boolean gameOver)      { this.gameOver = gameOver; }
    public void incLevelNumber()                   { this.levelNumber += 1; }
    public void incAmmo(int inc)                   { this.ammo += inc; }
    public void decAmmo()                          { this.ammo-= 1; }
    public void decHp()                            { this.hp--; }
    public void decLives()                         { this.lives--; SoundEffect.LOSE.play(); }
    public void wizardDied()                       { this.wizardDead = true; }
    public void wizardRespawn()                    { this.wizardDead = false; }
    public void pauseGame()                        { this.gamePaused = true;}
    public void resumeGame()                       { this.gamePaused = false;}

    public void muteGame() {
        // Toggles game muted on and off.
        if (gameMuted) {
            gameMuted = false;
        }
        else {
            gameMuted = true;
        }
    }

    /**
     * Main method to instantiate and initialize this Game class.
     */
    public static void main(String[] args) {
        new Game().init();
    }
}
