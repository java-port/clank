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

package org.clang.driver;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
;
import org.llvm.support.sys.*;;
import static org.llvm.support.sys.sys.*;
import static org.clang.driver.impl.JobStatics.*;

/// Command - An executable path/name and argument vector to
/// execute.
//<editor-fold defaultstate="collapsed" desc="clang::driver::Command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 43,
 FQN="clang::driver::Command", NM="_ZN5clang6driver7CommandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver7CommandE")
//</editor-fold>
public class Command implements Destructors.ClassWithDestructor {
  /// Source - The action which caused the creation of this job.
  private /*const*/ Action /*&*/ Source;
  
  /// Tool - The tool which caused the creation of this job.
  private /*const*/ Tool /*&*/ Creator;
  
  /// The executable to run.
  private /*const*/char$ptr/*char P*/ Executable;
  
  /// The list of program arguments (not including the implicit first
  /// argument, which will be the executable).
  private ArgStringList Arguments;
  
  /// The list of program arguments which are inputs.
  private ArgStringList InputFilenames;
  
  /// Response file name, if this command is set to use one, or nullptr
  /// otherwise
  private /*const*/char$ptr/*char P*/ ResponseFile;
  
  /// The input file list in case we need to emit a file list instead of a
  /// proper response file
  private ArgStringList InputFileList;
  
  /// String storage if we need to create a new argument to specify a response
  /// file
  private std.string ResponseFileFlag;
  
  /// When a response file is needed, we try to put most arguments in an
  /// exclusive file, while others remains as regular command line arguments.
  /// This functions fills a vector with the regular command line arguments,
  /// argv, excluding the ones passed in a response file.
  
  /// When a response file is needed, we try to put most arguments in an
  /// exclusive file, while others remains as regular command line arguments.
  /// This functions fills a vector with the regular command line arguments,
  /// argv, excluding the ones passed in a response file.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Command::buildArgvForResponseFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", line = 126,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", old_line = 125,
   FQN="clang::driver::Command::buildArgvForResponseFile", NM="_ZNK5clang6driver7Command24buildArgvForResponseFileERN4llvm15SmallVectorImplIPKcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZNK5clang6driver7Command24buildArgvForResponseFileERN4llvm15SmallVectorImplIPKcEE")
  //</editor-fold>
  private void buildArgvForResponseFile(SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ Out) /*const*/ {
    StringSet/*<MallocAllocator>*/ Inputs = null;
    try {
      // When not a file list, all arguments are sent to the response file.
      // This leaves us to set the argv to a single parameter, requesting the tool
      // to read the response file.
      if (Creator.getResponseFilesSupport() != Tool.ResponseFileSupport.RF_FileList) {
        Out.push_back(Executable);
        Out.push_back(ResponseFileFlag.c_str());
        return;
      }
      
      Inputs/*J*/= new StringSet/*<MallocAllocator>*/();
      for (/*const*/char$ptr/*char P*/ InputName : InputFileList)  {
        Inputs.insert(new StringRef(InputName));
      }
      Out.push_back(Executable);
      // In a file list, build args vector ignoring parameters that will go in the
      // response file (elements of the InputFileList vector)
      boolean FirstInput = true;
      for (/*const*/char$ptr/*char P*/ Arg : Arguments) {
        if (Inputs.count(new StringRef(Arg)) == 0) {
          Out.push_back(Arg);
        } else if (FirstInput) {
          FirstInput = false;
          Out.push_back(Creator.getResponseFileFlag());
          Out.push_back(ResponseFile);
        }
      }
    } finally {
      if (Inputs != null) { Inputs.$destroy(); }
    }
  }


  
  /// Encodes an array of C strings into a single string separated by whitespace.
  /// This function will also put in quotes arguments that have whitespaces and
  /// will escape the regular backslashes (used in Windows paths) and quotes.
  /// The results are the contents of a response file, written into a raw_ostream.
  
  /// Encodes an array of C strings into a single string separated by whitespace.
  /// This function will also put in quotes arguments that have whitespaces and
  /// will escape the regular backslashes (used in Windows paths) and quotes.
  /// The results are the contents of a response file, written into a raw_ostream.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Command::writeResponseFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", line = 100,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", old_line = 99,
   FQN="clang::driver::Command::writeResponseFile", NM="_ZNK5clang6driver7Command17writeResponseFileERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZNK5clang6driver7Command17writeResponseFileERN4llvm11raw_ostreamE")
  //</editor-fold>
  private void writeResponseFile(raw_ostream /*&*/ OS) /*const*/ {
    // In a file list, we only write the set of inputs to the response file
    if (Creator.getResponseFilesSupport() == Tool.ResponseFileSupport.RF_FileList) {
      for (/*const*/char$ptr/*char P*/ Arg : InputFileList) {
        OS.$out(Arg).$out_char($$LF);
      }
      return;
    }
    
    // In regular response files, we send all arguments to the response file.
    // Wrapping all arguments in double quotes ensures that both Unix tools and
    // Windows tools understand the response file.
    for (/*const*/char$ptr/*char P*/ Arg : Arguments) {
      OS.$out_char($$DBL_QUOTE);
      
      for (; Arg.$star() != $$TERM; Arg.$postInc()) {
        if (Arg.$star() == $$DBL_QUOTE || Arg.$star() == $$BACK_SLASH) {
          OS.$out_char($$BACK_SLASH);
        }
        OS.$out_char(Arg.$star());
      }
      
      OS.$out(/*KEEP_STR*/"\" ");
    }
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Command::Command">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", line = 30,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", old_line = 29,
   FQN="clang::driver::Command::Command", NM="_ZN5clang6driver7CommandC1ERKNS0_6ActionERKNS0_4ToolEPKcRKN4llvm11SmallVectorIS9_Lj16EEENSA_8ArrayRefINS0_9InputInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZN5clang6driver7CommandC1ERKNS0_6ActionERKNS0_4ToolEPKcRKN4llvm11SmallVectorIS9_Lj16EEENSA_8ArrayRefINS0_9InputInfoEEE")
  //</editor-fold>
  public Command(/*const*/ Action /*&*/ Source, /*const*/ Tool /*&*/ Creator, 
      /*const*/char$ptr/*char P*/ Executable, /*const*/ArgStringList/*&*/ Arguments, 
      ArrayRef<InputInfo> Inputs) {
    /* : Source(Source), Creator(Creator), Executable(Executable), Arguments(Arguments), InputFilenames(), ResponseFile(null), InputFileList(), ResponseFileFlag()*/ 
    //START JInit
    this./*&*/Source=/*&*/Source;
    this./*&*/Creator=/*&*/Creator;
    this.Executable = $tryClone(Executable);
    this.Arguments = new ArgStringList(Arguments);
    this.InputFilenames = new ArgStringList();
    this.ResponseFile = null;
    this.InputFileList = new ArgStringList();
    this.ResponseFileFlag = new std.string();
    //END JInit
    for (/*const*/ InputInfo /*&*/ II : Inputs)  {
      if (II.isFilename()) {
        InputFilenames.push_back(II.getFilename());
      }
    }
  }

  // JAVA: in C++ SmallVector<InputInfo> would be automaticlly comvertyed to ArrayRef<InputInfo>
  // we need to ad an "overload" ctor instead
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public Command(/*const*/ Action /*&*/ Source, /*const*/ Tool /*&*/ Creator, 
      /*const*/char$ptr/*char P*/ Executable, /*const*/ArgStringList/*&*/ Arguments, 
      SmallVector<InputInfo> Inputs) {
    this(Source, Creator, Executable, Arguments, new ArrayRef(Inputs));
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public Command(/*const*/ Action /*&*/ Source, /*const*/ Tool /*&*/ Creator, 
      /*const*/char$ptr/*char P*/ Executable, /*const*/ArgStringList/*&*/ Arguments, 
      InputInfo Input) {
    this(Source, Creator, Executable, Arguments, new ArrayRef(Input));
  }

  // FIXME: This really shouldn't be copyable, but is currently copied in some
  // error handling in Driver::generateCompilationDiagnostics.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Command::Command">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 90,
   FQN="clang::driver::Command::Command", NM="_ZN5clang6driver7CommandC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver7CommandC1ERKS1_")
  //</editor-fold>
  public Command(/*const*/ Command /*&*/ $Prm0) {
    /* : Source(.Source), Creator(.Creator), Executable(.Executable), Arguments(.Arguments), InputFilenames(.InputFilenames), ResponseFile(.ResponseFile), InputFileList(.InputFileList), ResponseFileFlag(.ResponseFileFlag)*//* = default*/ 
    //START JInit
    this./*&*/Source=/*&*/$Prm0.Source;
    this./*&*/Creator=/*&*/$Prm0.Creator;
    this.Executable = $tryClone($Prm0.Executable);
    this.Arguments = new ArgStringList($Prm0.Arguments);
    this.InputFilenames = new ArgStringList($Prm0.InputFilenames);
    this.ResponseFile = $tryClone($Prm0.ResponseFile);
    this.InputFileList = new ArgStringList($Prm0.InputFileList);
    this.ResponseFileFlag = new std.string($Prm0.ResponseFileFlag);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Command::~Command">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 91,
   FQN="clang::driver::Command::~Command", NM="_ZN5clang6driver7CommandD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver7CommandD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    //START JDestroy
    ResponseFileFlag.$destroy();
    InputFileList.$destroy();
    InputFilenames.$destroy();
    Arguments.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Command::Print">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", line = 155,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", old_line = 154,
   FQN="clang::driver::Command::Print", NM="_ZNK5clang6driver7Command5PrintERN4llvm11raw_ostreamEPKcbPNS0_15CrashReportInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZNK5clang6driver7Command5PrintERN4llvm11raw_ostreamEPKcbPNS0_15CrashReportInfoE")
  //</editor-fold>
  public void Print(raw_ostream /*&*/ OS, /*const*/char$ptr/*char P*/ Terminator, boolean Quote) /*const*/ {
    Print(OS, Terminator, Quote, 
       (CrashReportInfo /*P*/ )null);
  }
  public void Print(raw_ostream /*&*/ OS, /*const*/char$ptr/*char P*/ Terminator, boolean Quote, 
       CrashReportInfo /*P*/ CrashInfo/*= null*/) /*const*/ {
    // Always quote the exe.
    OS.$out_char($$SPACE);
    printArg(OS, Executable, /*Quote=*/ true);
    
    ArrayRef</*const*/char$ptr/*char P*/ > Args = new ArrayRef</*const*/char$ptr/*char P*/ >(Arguments);
    SmallVector</*const*/char$ptr/*char P*//*,  128*/> ArgsRespFile/*J*/= new SmallVector</*const*/char$ptr/*char P*//*,  128*/>(128, null);
    if ($noteq_ptr(ResponseFile, null)) {
      buildArgvForResponseFile(ArgsRespFile);
      Args.$assignMove(new ArrayRef</*const*/char$ptr/*char P*/ >(ArgsRespFile).slice(1)); // no executable name
    }
    
    boolean HaveCrashVFS = (CrashInfo != null) && !CrashInfo.VFSPath.empty();
    for (/*size_t*/int i = 0, e = Args.size(); $less_uint(i, e); ++i) {
      /*const*/char$ptr/*char P*//*const*/ Arg = $tryClone(Args.$at(i));
      if ((CrashInfo != null)) {
        {
          int Skip = skipArgs(Arg, HaveCrashVFS);
          if ((Skip != 0)) {
            i += Skip - 1;
            continue;
          }
        }
        /*const*/type$ptr<char$ptr> /*char P const P*/ Found = $tryClone(std.find_if(InputFilenames.begin(), InputFilenames.end(), 
             (IF) -> 
              {
                return $eq_ptr(/*NO_COPY*/IF, /*STRINGREF_STR*/Arg);
              }
  ));
        if ($noteq_ptr(Found, InputFilenames.end())
           && (i == 0 || $noteq_StringRef(/*STRINGREF_STR*/Args.$at(i - 1), /*STRINGREF_STR*/"-main-file-name"))) {
          // Replace the input file name with the crashinfo's file name.
          OS.$out_char($$SPACE);
          StringRef ShortName = path.filename(/*NO_COPY*/CrashInfo.Filename);
          printArg(OS, ShortName.str().c_str(), Quote);
          continue;
        }
      }
      
      OS.$out_char($$SPACE);
      printArg(OS, Arg, Quote);
    }
    if ((CrashInfo != null) && HaveCrashVFS) {
      OS.$out_char($$SPACE);
      printArg(OS, $("-ivfsoverlay"), Quote);
      OS.$out_char($$SPACE);
      printArg(OS, CrashInfo.VFSPath.str().c_str(), Quote);
      
      // Insert -fmodules-cache-path and use the relative module directory
      // <name>.cache/vfs/modules where we already dumped the modules.
      SmallString/*128*/ RelModCacheDir = new SmallString/*128*/(128, path.parent_path(path.parent_path(/*NO_COPY*/CrashInfo.VFSPath)));
      path.append(RelModCacheDir, new Twine(/*KEEP_STR*/"modules"));
      
      std.string ModCachePath = new std.string(/*KEEP_STR*/"-fmodules-cache-path=");
      ModCachePath.append(RelModCacheDir.c_str());
      
      OS.$out_char($$SPACE);
      printArg(OS, ModCachePath.c_str(), Quote);
    }
    if ($noteq_ptr(ResponseFile, null)) {
      OS.$out(/*KEEP_STR*/"\n Arguments passed via response file:\n");
      writeResponseFile(OS);
      // Avoiding duplicated newline terminator, since FileLists are
      // newline-separated.
      if (Creator.getResponseFilesSupport() != Tool.ResponseFileSupport.RF_FileList) {
        OS.$out(/*KEEP_STR*/$LF);
      }
      OS.$out(/*KEEP_STR*/" (end of response file)");
    }
    
    OS.$out(Terminator);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::Command::Execute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", line = 231,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", old_line = 218,
   FQN="clang::driver::Command::Execute", NM="_ZNK5clang6driver7Command7ExecuteEPPKN4llvm9StringRefEPSsPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZNK5clang6driver7Command7ExecuteEPPKN4llvm9StringRefEPSsPb")
  //</editor-fold>
  public int Execute(/*const*/type$ptr<StringRef> Redirects, std.string/*P*/ ErrMsg, 
         bool$ptr/*bool P*/ ExecutionFailed) /*const*/ {
    raw_string_ostream SS = null;
    try {
      SmallVector</*const*/char$ptr/*char P*//*,  128*/> Argv/*J*/= new SmallVector</*const*/char$ptr/*char P*//*,  128*/>(128, null);
      if ($eq_ptr(ResponseFile, null)) {
        Argv.push_back(Executable);
        Argv.append_T(Arguments.begin(), Arguments.end());
        Argv.push_back((/*const*/char$ptr/*char P*//*const*/)null);
        
        return sys.ExecuteAndWait(new StringRef(Executable), Argv.data(), /*env*/ (/*const*/type$ptr<char$ptr>/*char PP*/ )null, 
            Redirects, /*secondsToWait*/ 0, 
            /*memoryLimit*/ 0, ErrMsg, 
            ExecutionFailed);
      }
      
      // We need to put arguments in a response file (command is too large)
      // Open stream to store the response file contents
      std.string RespContents/*J*/= new std.string();
      SS/*J*/= new raw_string_ostream(RespContents);
      
      // Write file contents and build the Argv vector
      writeResponseFile(SS);
      buildArgvForResponseFile(Argv);
      Argv.push_back((/*const*/char$ptr/*char P*//*const*/)null);
      SS.flush();
      {
        
        // Save the response file in the appropriate encoding
        std.error_code EC = writeFileWithEncoding(new StringRef(ResponseFile), new StringRef(RespContents), Creator.getResponseFileEncoding());
        if (EC.$bool()) {
          if ((ErrMsg != null)) {
            /*Deref*/ErrMsg.$assignMove(EC.message());
          }
          if ((ExecutionFailed != null)) {
            ExecutionFailed.$set(true);
          }
          return -1;
        }
      }
      
      return sys.ExecuteAndWait(new StringRef(Executable), Argv.data(), /*env*/ (/*const*/type$ptr<char$ptr>/*char PP*/ )null, 
          Redirects, /*secondsToWait*/ 0, 
          /*memoryLimit*/ 0, ErrMsg, ExecutionFailed);
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }


  
  /// getSource - Return the Action which caused the creation of this job.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Command::getSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 100,
   FQN="clang::driver::Command::getSource", NM="_ZNK5clang6driver7Command9getSourceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver7Command9getSourceEv")
  //</editor-fold>
  public /*const*/ Action /*&*/ getSource() /*const*/ {
    return Source;
  }

  
  /// getCreator - Return the Tool which caused the creation of this job.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Command::getCreator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 103,
   FQN="clang::driver::Command::getCreator", NM="_ZNK5clang6driver7Command10getCreatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver7Command10getCreatorEv")
  //</editor-fold>
  public /*const*/ Tool /*&*/ getCreator() /*const*/ {
    return Creator;
  }

  
  /// Set to pass arguments via a response file when launching the command
  
  /// Set to pass arguments via a response file when launching the command
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Command::setResponseFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", line = 225,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", old_line = 212,
   FQN="clang::driver::Command::setResponseFile", NM="_ZN5clang6driver7Command15setResponseFileEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZN5clang6driver7Command15setResponseFileEPKc")
  //</editor-fold>
  public void setResponseFile(/*const*/char$ptr/*char P*/ FileName) {
    ResponseFile = $tryClone(FileName);
    ResponseFileFlag.$assign(Creator.getResponseFileFlag());
    ResponseFileFlag.$addassign(FileName);
  }


  
  /// Set an input file list, necessary if we need to use a response file but
  /// the tool being called only supports input files lists.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Command::setInputFileList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 110,
   FQN="clang::driver::Command::setInputFileList", NM="_ZN5clang6driver7Command16setInputFileListEN4llvm11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver7Command16setInputFileListEN4llvm11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public void setInputFileList(ArgStringList List) {
    InputFileList.$assignMove(std.move(List));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Command::getExecutable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 114,
   FQN="clang::driver::Command::getExecutable", NM="_ZNK5clang6driver7Command13getExecutableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver7Command13getExecutableEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getExecutable() /*const*/ {
    return Executable;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Command::getArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 116,
   FQN="clang::driver::Command::getArguments", NM="_ZNK5clang6driver7Command12getArgumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK5clang6driver7Command12getArgumentsEv")
  //</editor-fold>
  public /*const*/ArgStringList/*&*/ getArguments() /*const*/ {
    return Arguments;
  }

  
  /// Print a command argument, and optionally quote it.
  
  /// Print a command argument, and optionally quote it.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Command::printArg">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*clone Arg*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", line = 82,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", old_line = 81,
   FQN="clang::driver::Command::printArg", NM="_ZN5clang6driver7Command8printArgERN4llvm11raw_ostreamEPKcb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZN5clang6driver7Command8printArgERN4llvm11raw_ostreamEPKcb")
  //</editor-fold>
  public static void printArg(raw_ostream /*&*/ OS, /*const*/char$ptr/*char P*/ Arg, boolean Quote) {
    /*const*/boolean Escape = $tryClone((std.strpbrk(Arg, $("\"\\$")) != null));
    if (!Quote && !Escape) {
      OS.$out(Arg);
      return;
    }
    
    // Quote and escape. This isn't really complete, but good enough.
    OS.$out_char($$DBL_QUOTE);
    {
      /*const*//*char*/byte c;
      Arg = $tryClone(Arg);
      while (((c = Arg.$postInc().$star()) != $$TERM)) {
        if (c == $$DBL_QUOTE || c == $$BACK_SLASH || c == $$DOLLAR) {
          OS.$out_char($$BACK_SLASH);
        }
        OS.$out_char(c);
      }
    }
    OS.$out_char($$DBL_QUOTE);
  }


  
  public String toString() {
    StringBuilder out = new StringBuilder();
    out.append("Executable = [").append(Casts.toJavaString(Executable)).append(":\n");
    int idx = 1;
    for (char$ptr Argument : Arguments) {
      out.append("[").append(idx++).append("] [").append(Casts.toJavaString(Argument)).append("]\n");
    }
    out.append("ResponseFile = [").append(Casts.toJavaString(ResponseFile)).append("]\n");
    out.append("ResponseFileFlag = [").append(ResponseFileFlag.toJavaString()).append("]\n");
    
    return out.toString() + "Source=" + NativeTrace.getIdentityStr(Source) // NOI18N
              + ", Creator=" + NativeTrace.getIdentityStr(Creator) // NOI18N
              + ",\nInputFilenames=" + InputFilenames // NOI18N
              + ",\nInputFileList=" + InputFileList; // NOI18N
  }
}
