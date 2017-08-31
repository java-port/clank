/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.clank.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author vkvashin
 */
public class ClankDiff {

  private static final String ENV_SPUTNIK = "SPUTNIK";
  private static final String ENV_LLVM_SRC = "LLVM_SRC";
  private static final String ENV_CLANK_DIFF_DST = "CLANK_DIFF_DST";
  private static final String ENV_CLANK_DIFF_REVISION = "clank.diff.revision";

  private final ClankDiffParams params;

  public static void main(String[] args) {
    new ClankDiff(args).main();
  }

  private enum MessageLevel {
    TRACE,
    WARNING,
    ERROR
  }

  private static enum OS {
    Linux,
    Solaris,
    Unsupported
  }

  private static OS getOS() {
    String os = System.getProperty("os.name");
    switch (os) {
      case "SunOS": return OS.Solaris;
      case "Linux": return OS.Linux;
      default: return OS.Unsupported;
    }
  }

  private static void abend(Object... errors) {
    for (Object e : errors) {
      if (e instanceof String) {
        error((String) e);
      } else if (e instanceof Throwable) {
        error((Throwable) e);
      } else {
        error("Unexpected error: %s", e);
      }
    }
    System.exit(4);
  }

  public ClankDiff() {
    this.params = null;
  }

  private static void trace(MessageLevel level, String format, Object...args) {
    switch (level) {
      case TRACE:
        trace(format, args);
        break;
      case WARNING:
        warning(format, args);
        break;
      case ERROR:
        error(format, args);
        break;
      default:
        throw new AssertionError(level.name());
    }
  }

  private static void trace(String format, Object...args) {
    System.out.println(String.format(format, args));
  }

  private static void warning(String format, Object...args) {
    System.err.println(String.format(format, args));
  }

  private static void error(String format, Object...args) {
    System.err.println(String.format(format, args));
  }

  private static void error(Throwable ex) {
    ex.printStackTrace(System.err);
  }

  private static CharSequence strTime(long time) {
    long sec = time / 1000;
    long min = sec / 60;
    sec = sec % 60;
    long hr = min / 60;
    StringBuilder sb = new StringBuilder();
    if (hr > 0) {
      min = min % 60;
      sb.append(hr).append(" hour").append(hr == 1 ? " " : "s ");
    }
    if (min > 0) {
      sb.append(min).append(" minute").append(min == 1 ? " " : "s ");
    }
    sb.append(sec).append(" second").append(sec == 1 ? " " : "s ");
    return sb;
  }

  private static CharSequence join(boolean quoteIfSpaces, String... words) {
    StringBuilder sb = new StringBuilder();
    for (String w : words) {
      if (quoteIfSpaces && w.contains(" ")) {
        w = "\"" + w + "\"";
      }
      sb.append(w).append(' ');
    }
    return sb;
  }

  private static String[] augment(List<String> tail, String... head) {
    String[] res = new String[tail.size() + head.length];
    for (int i = 0; i < head.length; i++) {
      res[i] = head[i];
    }
    for (int i = 0; i < tail.size(); i++) {
      res[i + head.length] = tail.get(i);
    }
    return res;
  }

  private static File checkDirOrDie(File dir) {
    if (!dir.exists()) {
      abend("Directory " + dir.getAbsolutePath() + " does not exist");
    }
    if (!dir.isDirectory()) {
      abend("File " + dir.getAbsolutePath() + " is not a directory");
    }
    return dir;
  }

  private static File checkSubirOrDie(File base, String subdir) {
    File dir = new File(base, subdir);
    return checkDirOrDie(dir);
  }

  private static File checkDirOrDie(String envVar) {
    String path = System.getenv(envVar);
    if (path == null) {
      abend("Environment variable " + envVar + " is not set");
    }
    return checkDirOrDie(new File(path));
  }

  private static String getEnv(String env, String defaultValue) {
    String res = System.getenv(env);
    return (res == null) ? defaultValue : res;
  }

  private static class ParamParser {
    private enum Flag {
      NONE(' '),
      REVISION('r'),
      MODULE('m');
      public final char letter;
      private Flag(char letter) {
        this.letter = letter;
      }
      public static Flag fromChar(char c) {
        for (Flag f : Flag.values()) {
          if( f.letter == c) {
            return f;
          }
        }
        return null;
      }
    }
    public static ClankDiffParams parseArgs(String[] args) {
      ClankDiffParams res = new ClankDiffParams();
      res.dirSputnik = checkDirOrDie(ENV_SPUTNIK);
      res.dirLlvmSrc = checkDirOrDie(ENV_LLVM_SRC);
      res.revision = getEnv(ENV_CLANK_DIFF_REVISION, "tip");
      Flag flag = Flag.NONE;
      for (String arg : args) {
        if (arg.startsWith("-")) {
          if (flag != Flag.NONE) {
            abend("Flag -" + flag.letter + " should be followed by value");
          } else if (arg.length() != 2) {
            abend("Incorrect flag: " + arg);
          }
          flag = Flag.fromChar(arg.charAt(1));
          if (flag == null) {
            abend("Incorrect flag: " + arg);
          }
        } else {
          switch(flag) {
            case NONE:
              res.dirDst = checkDirOrDie(new File(arg));
              break;
            case REVISION:
              res.revision = arg;
              break;
            case MODULE:
              res.modules.add(arg);
              break;
            default:
              throw new AssertionError(flag.name());
          }
          flag = Flag.NONE;
        }
      }
      if (res.modules.isEmpty()) {
        File modulesDir = checkSubirOrDie(res.dirSputnik, "modules");
        for (File dir : modulesDir.listFiles()) {
          String name = dir.getName();
          if (name.startsWith("org.llvm.") || name.startsWith("org.clang.") || name.startsWith("org.clang.")) {
            if (moduleCommandsFile(modulesDir, name).exists()) {
              res.modules.add(name);
            }
          }
        }
      }
      if (res.dirDst == null) {
        try {
          String dst = System.getenv(ENV_CLANK_DIFF_DST);
          if (dst == null) {
            res.dirDst = File.createTempFile("ClankDiff", "");
            res.dirDst.delete();
            res.dirDst.mkdirs();
          } else {
            res.dirDst = checkDirOrDie(new File(dst));
          }
        } catch (IOException ex) {
          abend(ex);
          return null;
        }
      }
      Collections.sort(res.modules);
      return res;
    }
  }

  private ClankDiff(String[] args) {
    params = ParamParser.parseArgs(args);
  }

  private static class /*struct*/ ProcRes {
    public static final int NOT_LAUNCHED = -2;
    public static final int EXCEPTIONS = -1;
    private final String[] cmdAndArgs;
    public List<String> out = new ArrayList<>();
    public List<String> error = new ArrayList<>();
    public int rc = NOT_LAUNCHED;
    public List<Exception> exceptions = new ArrayList<>();

    public ProcRes(String[] cmdAndArgs) {
      this.cmdAndArgs = cmdAndArgs;
    }

    public boolean isOk() {
      return rc == 0;
    }

    public boolean isFailed() {
      return !isOk();
    }

    @Override
    public String toString() {
      return "ProcRes{" + "out=" + out + ", error=" + error + ", rc=" + rc + ", exceptions=" + exceptions + '}';
    }
    private void printErrors() {
      if(isFailed()) {
        StringBuilder sb = new StringBuilder("Command ");
        for (String cmd : cmdAndArgs) {
          sb.append(cmd).append(' ');
        }
        sb.append('\n');
        switch (rc) {
          case NOT_LAUNCHED:
            sb.append("has not been launched");
            break;
          case EXCEPTIONS:
            sb.append("finished with exceptions");
            break;
          default:
            sb.append("finished with rc=").append(rc);
            break;
        }
        error(sb.toString());
        for (Exception ex : exceptions) {
          error(ex);
        }
        for (String errLine : error) {
          error(errLine);
        }
      }
    }
  }

  private static boolean write(File file, List<String> out) {
    try (FileWriter wr = new FileWriter(file)) {
      for (String line : out) {
        wr.write(line);
        wr.write("\n");
      }
      return true;
    } catch (IOException ex) {
      ex.printStackTrace();
      return false;
    }
  }

  private static void read(InputStream is, List<String> out, List<Exception> exceptions) {
    read(is, out, exceptions, null);
  }

  private static void read(InputStream is, List<String> out, List<Exception> exceptions, PrintStream echo) {
    try (BufferedReader rdr = new BufferedReader(new InputStreamReader(is))) {
      String line;
      while ((line = rdr.readLine()) != null) {
        if (echo != null) {
          echo.println(line);
        }
        out.add(line);
      }
    } catch (IOException ex) {
      exceptions.add(ex);
    }
  }

  private static ProcRes execOrDie(File dir, final boolean printOut, final boolean printErr, String... cmdAndArgs) {
    ProcRes res = execAndPrintErrors(dir, printOut, printErr, cmdAndArgs);
    if (res.isFailed()) {
      abend("Command " + join(true, cmdAndArgs) + " in " + dir.getAbsolutePath() + " failed");
    }
    return res;
  }

  private static ProcRes execAndPrintErrors(File dir, final boolean printOut, final boolean printErr, String... cmdAndArgs) {
    ProcRes res = exec(dir, printOut, printErr, cmdAndArgs);
    if (res.isFailed() && !printErr) {
      res.printErrors();
    }
    return res;
  }

  private static ProcRes exec(File dir, final boolean printOut, final boolean printErr, String... cmdAndArgs) {
    ProcessBuilder pb = new ProcessBuilder();
    pb.command(cmdAndArgs);
    if (dir != null) {
      pb.directory(dir);
    }
    final ProcRes res = new ProcRes(cmdAndArgs);
    final Process proc;
    try {
      proc = pb.start();
      new Thread(new Runnable() {
        public @Override
        void run() {
          read(proc.getErrorStream(), res.error, res.exceptions, printErr ? System.err : null);
        }
      }).start();
      new Thread(new Runnable() {
        public @Override
        void run() {
          read(proc.getInputStream(), res.out, res.exceptions, printOut ? System.err : null);
        }
      }).start();
      try {
        res.rc = proc.waitFor();
      } catch (InterruptedException ex) {
        res.exceptions.add(ex);
      }
    } catch (IOException ex) {
      res.exceptions.add(ex);
    }
    if (res.rc > 0 && !res.exceptions.isEmpty()) {
      res.rc = ProcRes.EXCEPTIONS;
    }
    return res;
  }

  private static int threadCount() {
    return Runtime.getRuntime().availableProcessors();
  }

  private static CharSequence mem2str(long memory) {
    long kb = memory/1024;
    if (kb > 1024*1024) {
      return "" + kb/1024 + "M";
    } else {
      return "" + memory/1024 + "K";
    }
  }

  private void stepPullSputnik() {
    trace("Pulling sputnik into (%s)", params.dirSputnik.getAbsolutePath());
    ProcRes res;
    res = execOrDie(params.dirSputnik, false, true, "hg", "st");
    if (!res.out.isEmpty()) {
      MessageLevel lvl = params.allowSputnikLocalChanges.value ? MessageLevel.WARNING : MessageLevel.ERROR;
      List<String> toRemove = new ArrayList<>();
      trace(lvl, "Local changes in %s:", params.dirSputnik.getAbsolutePath());
      for (String line : res.out) {
        trace(lvl, "  %s", line);
        if (line.startsWith("? ")) {
          if (toRemove.isEmpty()) {
            toRemove.add("rm");
          }
          toRemove.add(line.substring(2));
        }
      }
      if (!params.allowSputnikLocalChanges.value) {
        abend();
      }
    }
    res = execOrDie(params.dirSputnik, true, true, "hg", "pull");
    trace("Updating Sputnik (%s) to %s", params.dirSputnik.getAbsolutePath(), params.revision);
    res = execOrDie(params.dirSputnik, true, true, "hg", "up", params.revision);
    trace("Updating Sputnik (%s) to %s completed", params.dirSputnik.getAbsolutePath(), params.revision);
  }

  private void stepBuildClankGenerator() {
    execOrDie(new File(params.dirSputnik, "contrib/ClankGenerator"), false, true, "ant", "-Dnb.internal.action.name=rebuild", "clean", "jar");
  }

  private void stepBuildJConvert() {
    File wd = new File(params.dirSputnik, "contrib/JConvert");
    if (!wd.exists()) {
      abend(wd.getAbsolutePath() + " does not exist");
    }
    trace("Building JConvert in %s", wd.getAbsolutePath());
    String makeCommand = "make";
    String makeConf = "Linux_Release";
    if (getOS() == OS.Solaris) {
      makeCommand = "gmake";
      makeConf = "Solaris_Release";
    }
    if (!params.skipCleaningJConvert.value) {
      execOrDie(wd, true, true, makeCommand, "-j", ""+threadCount(), "-f", "Makefile", "CONF=" + makeConf, "clean");
    }
    execOrDie(wd, true, true, makeCommand, "-j", ""+threadCount(), "-f", "Makefile", "CONF=" + makeConf);
  }

  private void stepGenerateModule(String moduleName) {
    File modulesDir = checkSubirOrDie(params.dirSputnik, "modules");
    Module module = new Module(modulesDir, moduleName);
    module.convert();
  }

  private void stepCommitGenerated(String moduleName) {

    ProcRes res = execOrDie(params.dirSputnik, false, true, "hg", "log", "-r", params.revision);
    File tip = new File(params.dirDst, "tip.txt");
    write(tip, res.out);

    res = execOrDie(params.dirSputnik, false, true, "hg", "log", "-r", params.revision,
            "--template", "{rev}:{node|short} {desc|strip|firstline}\\n");
    String fullRevision = res.out.isEmpty() ? params.revision : res.out.get(0);

    res = execOrDie(params.dirDst, false, true, "hg", "st");
    List<String> added = new ArrayList<>();
    List<String> removed = new ArrayList<>();
    for (String line : res.out) {
      // here is the example:
      // M tip.txt
      // ! modules/org.llvm.ir/src/org/llvm/ir/impl/PointerStripKind.java
      // ? new_file.txt
      if (!line.isEmpty()) {
        if (line.startsWith("! ")) {
          removed.add(line.substring(2));
        } else if (line.startsWith("? ")) {
          added.add(line.substring(2));
        }
      }
    }
    if (!added.isEmpty()) {
      execOrDie(params.dirDst, true, true, augment(added, "hg", "add"));
    }
    if (!removed.isEmpty()) {
      execOrDie(params.dirDst, true, true, augment(removed, "hg", "rm"));
    }

    res = exec(params.dirDst, true, true, "hg", "ci", "-m",
            "Generated module " + moduleName + " from revision " + fullRevision);
    if (!res.isOk()) {
      if (res.rc == 1 && !res.out.isEmpty() && res.out.get(0).trim().equals("nothing changed")) {
        warning("Not committing module %s: nothing changed", moduleName);
      } else {
        abend("Command hg ci in " + params.dirDst.getAbsolutePath() + " failed");
      }
    }
  }

  private void stepPushGenerated() {
    ProcRes res = exec(params.dirDst, true, true, "hg", "push");
    if (!res.isOk()) {
      if (res.rc == 1 && res.out.size() >= 3 && res.out.get(2).trim().equals("no changes found")) {
        warning("Not pushing: nothing changed");
      } else {
        abend("Command hg push in " + params.dirDst.getAbsolutePath() + " failed");
      }
    }
  }

  private static void wrapAndMeasure(Runnable r, String title) {
    trace("%s...", title);
    long time = System.currentTimeMillis();
    try {
      r.run();
    } finally {
      time = System.currentTimeMillis() - time;
      trace("%s took %s", title, strTime(time));
    }
  }

  private void main() {
    trace("----------------------------------------");
    trace("ClankDiff v 1.4");
    params.prettyPrint();
    trace("Memory: Max: %s   Total: %s  Free: %s",
            mem2str(Runtime.getRuntime().maxMemory()),
            mem2str(Runtime.getRuntime().totalMemory()), 
            mem2str(Runtime.getRuntime().freeMemory()));
    trace("----------------------------------------");

    if (params.skipPullingSputnik.value) {
      warning("Pulling sputnik is skipped");
    } else {
      wrapAndMeasure(() -> stepPullSputnik(), "Pulling sputnik");
    }
    if (params.skipBuildingJConvert.value) {
      warning("Building jconvert is skipped");
    } else {
      wrapAndMeasure(() -> stepBuildJConvert(), "Building JConvert");
    }
    //On some systems I have trouble with building clank generator. Skip it for a while.
    //if (!params.skipGeneratingModules.value) {
    //  stepBuildClankGenerator();
    //}
    for (String moduleName : params.modules) {
      if (params.skipGeneratingModules.value) {
        warning("Generating module " + moduleName + " is skipped");
      } else {
        wrapAndMeasure(() -> stepGenerateModule(moduleName), "Generating module " + moduleName);
        if (params.skipCommitGenerated.value) {
          warning("Committing generated code is skipped");
        } else {
          wrapAndMeasure(() -> stepCommitGenerated(moduleName), "Committing generated code");
        }
        if (params.skipPushGenerated.value) {
          warning("Pushing generated code is skipped");
        } else {
          wrapAndMeasure(() -> stepPushGenerated(), "Pushing generated code");
        }
      }
    }
  }

  private static File moduleCommandsFile(File modulesDir, String name) {
    return new File(new File(modulesDir, name), "commands_" + name + ".sh");
  }

  private class Module {

    private final File baseDir;
    private final String name;
    private final File commandsFile;

    public Module(File base, String name) {
      this.name = name;
      this.baseDir = new File(base, name);
      this.commandsFile = moduleCommandsFile(base, name);
    }

    private String expandEnv(String cmd) {
      int pos = cmd.lastIndexOf('>');
      if (pos < 0) {
        if (cmd.trim().startsWith("mkdir ")) {
          cmd = cmd.replace("${SPUTNIK}", params.dirDst.getAbsolutePath());
        } else {
          cmd = cmd.replace("${SPUTNIK}", params.dirSputnik.getAbsolutePath());
        }
      } else {
        String left = cmd.substring(0, pos);
        String right = cmd.substring(pos + 1);
        cmd = left.replace("${SPUTNIK}", params.dirSputnik.getAbsolutePath()) + '>' + right.replace("${SPUTNIK}", params.dirDst.getAbsolutePath());
      }
      return cmd;
    }

    public boolean convert() {
      final int threadCount = threadCount();
      long time = System.currentTimeMillis();
      try {
        return convertImpl(threadCount);
      } finally {
        time = System.currentTimeMillis() - time;
        trace("Converting %s took %s", name, strTime(time));
      }
    }

    private boolean convertImpl(final int threadCount) {
      trace("Converting %s in parallel in  %d threads", name, threadCount);
      // creating directories and putting all other commandds lines into the linked list
      LinkedList<String> commands = new LinkedList<>();
      try (BufferedReader rdr = new BufferedReader(new FileReader(commandsFile))) {
        String cmd;
        while ((cmd = rdr.readLine()) != null) {
          cmd = cmd.trim();
          if (cmd.isEmpty() || cmd.startsWith("#")) {
            continue;
          } 
          cmd = expandEnv(cmd);
          if (cmd.contains(">")) {
            commands.addFirst(cmd);
          } else if (cmd.startsWith("java ") && cmd.contains("ClankGenerator")) {
            // skip this for a while
          } else {
            if (!cmd.startsWith("mkdir") && ! cmd.startsWith("java ")) {
              warning("Unexpected command: %s", cmd);
            }
            trace("  %s", cmd);
            ProcRes res = execAndPrintErrors(baseDir, false, true, "/bin/sh", "-c", cmd);
            if (res.isFailed()) {
              return false;
            }
          }
        }
      } catch (IOException ex) {
        ex.printStackTrace();
        return false;
      }

      AtomicBoolean success = new AtomicBoolean(true);
      final Object lock = new Object();
      Thread threads[] = new Thread[threadCount];
      final int total = commands.size();
      final AtomicInteger done = new AtomicInteger(0);
      for (int i = 0; i < threads.length; i++) {
        threads[i] = new Thread(new Runnable() {
          @Override
          public void run() {
            String cmd;
            while (true) {
              synchronized (lock) {
                cmd = commands.pollFirst();
                if (cmd == null) {
                  break;
                }
                trace("  %3d of %3d: %s", done.incrementAndGet(), total, cmd);
              }
              ProcRes res = execAndPrintErrors(baseDir, false, false, "/bin/sh", "-c", cmd);
              if (res.isFailed()) {
                success.set(false);
              }
            }
          }
        });
      }
      for (int i = 0; i < threads.length; i++) {
        threads[i].start();
      }
      for (int i = 0; i < threads.length; i++) {
        try {
          threads[i].join();
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
      }
      return success.get();
    }

    @Override
    public String toString() {
      return getClass().getSimpleName() + ' ' + name + " [" + commandsFile.getName() + ']';
    }
  }

  private static class Option {
    public final String description;
    //public final String propertyName;
    public final boolean value;
    public Option(String propertyName) {
      this(propertyName, propertyName);
    }
    public Option(String propertyName, String description) {
      this.description = description;
      //this.propertyName = propertyName;
      this.value = Boolean.getBoolean(propertyName);
    }
  }

  private static class /*struct*/ ClankDiffParams {
    public File dirSputnik;
    public File dirLlvmSrc;
    public File dirDst;
    public String revision = "tip";
    public List<String> modules = new ArrayList<>();
    // options
    public Option allowSputnikLocalChanges = new Option("allow.sputnik.local.changes");
    // options that allow skipping stages
    public Option skipPullingSputnik = new Option("skip.pulling.sputnik");
    public Option skipBuildingJConvert = new Option("skip.building.jconvert");
    public Option skipGeneratingModules = new Option("skip.generating.modules");
    public Option skipCommitGenerated = new Option("skip.commit.generated");
    public Option skipPushGenerated = new Option("skip.push.generated");
    public Option skipCleaningJConvert = new Option("skip.cleaning.jconvert");

    private void prettyPrint() {
      trace("  SPUTNIK=%s", dirSputnik.getAbsolutePath());
      trace("  revision=%s", revision);
      trace("  LLVM_SRC=%s", dirLlvmSrc.getAbsolutePath());
      trace("  DESTINATION=%s", dirDst.getAbsolutePath());
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < modules.size(); i++) {
        if (i % 5 == 0) {
          sb.append("\n    ");
        }
        sb.append(modules.get(i)).append(i + 1 == modules.size() ? "" : ", ");
      }
      trace("  Modules:%s", sb);
      trace("  Options:");
      Option[] options = new Option[] {
        skipPullingSputnik, allowSputnikLocalChanges,
        skipBuildingJConvert, skipCleaningJConvert, skipGeneratingModules,
        skipCommitGenerated, skipPushGenerated };
      for (Option opt : options) {
        trace("    %-32s %b", opt.description, opt.value);
      }
    }
  }
}
