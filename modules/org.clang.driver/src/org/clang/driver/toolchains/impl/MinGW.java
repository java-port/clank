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


package org.clang.driver.toolchains.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.llvm.support.sys.*;;
import static org.clang.driver.ToolChain.*;
import org.clang.driver.tools.impl.GccStatics;
import org.clang.driver.tools.impl.MinGWStatics;
import static org.clang.driver.impl.MinGWToolChainStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MinGW">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 664,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 636,
 FQN="clang::driver::toolchains::MinGW", NM="_ZN5clang6driver10toolchains5MinGWE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZN5clang6driver10toolchains5MinGWE")
//</editor-fold>
public class MinGW extends /*public*/ ToolChain implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MinGW::MinGW">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp", line = 65,
   FQN="clang::driver::toolchains::MinGW::MinGW", NM="_ZN5clang6driver10toolchains5MinGWC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZN5clang6driver10toolchains5MinGWC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public MinGW(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple, /*const*/ ArgList /*&*/ Args) {
    /* : ToolChain(D, Triple, Args), Base(), GccLibDir(), Ver(), Arch(), Preprocessor(), Compiler()*/
    //START JInit
    super(D, Triple, Args);
    this.Base = new std.string();
    this.GccLibDir = new std.string();
    this.Ver = new std.string();
    this.Arch = new std.string();
    this.Preprocessor = new std.unique_ptr<GccStatics.Preprocessor>();
    this.Compiler = new std.unique_ptr<GccStatics.Compiler>();
    //END JInit
    getProgramPaths().push_back(new std.string(getDriver().getInstalledDir()));
    if ((getDriver().SysRoot.size() != 0)) {
      Base.$assign(getDriver().SysRoot);
    } else {
      Base.$assign(/*KEEP_STR*/"/usr");
    }

    $addassign_str_StringRef(Base, path.get_separator());
    findGccLibDir();
    // GccLibDir must precede Base/lib so that the
    // correct crtbegin.o ,cetend.o would be found.
    getFilePaths().push_back(GccLibDir);
    getFilePaths().push_back(($add_Twine($add_Twine(new Twine($add_str$C(Base, Arch)), new Twine(path.get_separator())), new Twine(/*KEEP_STR*/"lib"))).str());
    getFilePaths().push_back($add_str$C_T(Base, /*KEEP_STR*/"lib"));
    // openSUSE
    getFilePaths().push_back($add_str_T($add_str$C(Base, Arch), /*KEEP_STR*/"/sys-root/mingw/lib"));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MinGW::IsIntegratedAssemblerDefault">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp", line = 99,
   FQN="clang::driver::toolchains::MinGW::IsIntegratedAssemblerDefault", NM="_ZNK5clang6driver10toolchains5MinGW28IsIntegratedAssemblerDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MinGW28IsIntegratedAssemblerDefaultEv")
  //</editor-fold>
  @Override public boolean IsIntegratedAssemblerDefault() /*const*//* override*/ {
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MinGW::IsUnwindTablesDefault">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp", line = 122,
   FQN="clang::driver::toolchains::MinGW::IsUnwindTablesDefault", NM="_ZNK5clang6driver10toolchains5MinGW21IsUnwindTablesDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MinGW21IsUnwindTablesDefaultEv")
  //</editor-fold>
  @Override public boolean IsUnwindTablesDefault() /*const*//* override*/ {
    return getArch() == Triple.ArchType.x86_64;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MinGW::isPICDefault">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp", line = 126,
   FQN="clang::driver::toolchains::MinGW::isPICDefault", NM="_ZNK5clang6driver10toolchains5MinGW12isPICDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MinGW12isPICDefaultEv")
  //</editor-fold>
  @Override public boolean isPICDefault() /*const*//* override*/ {
    return getArch() == Triple.ArchType.x86_64;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MinGW::isPIEDefault">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp", line = 128,
   FQN="clang::driver::toolchains::MinGW::isPIEDefault", NM="_ZNK5clang6driver10toolchains5MinGW12isPIEDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MinGW12isPIEDefaultEv")
  //</editor-fold>
  @Override public boolean isPIEDefault() /*const*//* override*/ {
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MinGW::isPICDefaultForced">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp", line = 130,
   FQN="clang::driver::toolchains::MinGW::isPICDefaultForced", NM="_ZNK5clang6driver10toolchains5MinGW18isPICDefaultForcedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MinGW18isPICDefaultForcedEv")
  //</editor-fold>
  @Override public boolean isPICDefaultForced() /*const*//* override*/ {
    return getArch() == Triple.ArchType.x86_64;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MinGW::UseSEHExceptions">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp", line = 134,
   FQN="clang::driver::toolchains::MinGW::UseSEHExceptions", NM="_ZNK5clang6driver10toolchains5MinGW16UseSEHExceptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MinGW16UseSEHExceptionsEv")
  //</editor-fold>
  public boolean UseSEHExceptions() /*const*/ {
    return getArch() == Triple.ArchType.x86_64;
  }



  // Include directories for various hosts:

  // Windows, mingw.org
  // c:\mingw\lib\gcc\mingw32\4.8.1\include\c++
  // c:\mingw\lib\gcc\mingw32\4.8.1\include\c++\mingw32
  // c:\mingw\lib\gcc\mingw32\4.8.1\include\c++\backward
  // c:\mingw\lib\gcc\mingw32\4.8.1\include
  // c:\mingw\include
  // c:\mingw\lib\gcc\mingw32\4.8.1\include-fixed
  // c:\mingw\mingw32\include

  // Windows, mingw-w64 mingw-builds
  // c:\mingw32\lib\gcc\i686-w64-mingw32\4.9.1\include
  // c:\mingw32\lib\gcc\i686-w64-mingw32\4.9.1\include-fixed
  // c:\mingw32\i686-w64-mingw32\include
  // c:\mingw32\i686-w64-mingw32\include\c++
  // c:\mingw32\i686-w64-mingw32\include\c++\i686-w64-mingw32
  // c:\mingw32\i686-w64-mingw32\include\c++\backward

  // Windows, mingw-w64 msys2
  // c:\msys64\mingw32\lib\gcc\i686-w64-mingw32\4.9.2\include
  // c:\msys64\mingw32\include
  // c:\msys64\mingw32\lib\gcc\i686-w64-mingw32\4.9.2\include-fixed
  // c:\msys64\mingw32\i686-w64-mingw32\include
  // c:\msys64\mingw32\include\c++\4.9.2
  // c:\msys64\mingw32\include\c++\4.9.2\i686-w64-mingw32
  // c:\msys64\mingw32\include\c++\4.9.2\backward

  // openSUSE
  // /usr/lib64/gcc/x86_64-w64-mingw32/5.1.0/include/c++
  // /usr/lib64/gcc/x86_64-w64-mingw32/5.1.0/include/c++/x86_64-w64-mingw32
  // /usr/lib64/gcc/x86_64-w64-mingw32/5.1.0/include/c++/backward
  // /usr/lib64/gcc/x86_64-w64-mingw32/5.1.0/include
  // /usr/lib64/gcc/x86_64-w64-mingw32/5.1.0/include-fixed
  // /usr/x86_64-w64-mingw32/sys-root/mingw/include

  // Arch Linux
  // /usr/i686-w64-mingw32/include/c++/5.1.0
  // /usr/i686-w64-mingw32/include/c++/5.1.0/i686-w64-mingw32
  // /usr/i686-w64-mingw32/include/c++/5.1.0/backward
  // /usr/lib/gcc/i686-w64-mingw32/5.1.0/include
  // /usr/lib/gcc/i686-w64-mingw32/5.1.0/include-fixed
  // /usr/i686-w64-mingw32/include

  // Ubuntu
  // /usr/include/c++/4.8
  // /usr/include/c++/4.8/x86_64-w64-mingw32
  // /usr/include/c++/4.8/backward
  // /usr/lib/gcc/x86_64-w64-mingw32/4.8/include
  // /usr/lib/gcc/x86_64-w64-mingw32/4.8/include-fixed
  // /usr/x86_64-w64-mingw32/include
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MinGW::AddClangSystemIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp", line = 190,
   FQN="clang::driver::toolchains::MinGW::AddClangSystemIncludeArgs", NM="_ZNK5clang6driver10toolchains5MinGW25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MinGW25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangSystemIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs,
                           ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdinc.getValue()))) {
      return;
    }
    if (!DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nobuiltininc.getValue()))) {
      SmallString/*1024*/ P/*J*/= new SmallString/*1024*/(new StringRef(getDriver().ResourceDir), 1024);
      path.append(P, new Twine(/*KEEP_STR*/$include));
      addSystemInclude(DriverArgs, CC1Args, new Twine(P.str()));
    }
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))) {
      return;
    }
    if (GetRuntimeLibType(DriverArgs) == ToolChain.RuntimeLibType.RLT_Libgcc) {
      SmallString/*1024*/ IncludeDir/*J*/= new SmallString/*1024*/(new StringRef(GccLibDir), 1024);
      path.append(IncludeDir, new Twine(/*KEEP_STR*/$include));
      addSystemInclude(DriverArgs, CC1Args, new Twine(IncludeDir.c_str()));
      IncludeDir.$addassign(/*STRINGREF_STR*/"-fixed");
      // openSUSE
      addSystemInclude(DriverArgs, CC1Args,
          new Twine($add_str_T($add_str$C(Base, Arch), /*KEEP_STR*/"/sys-root/mingw/include")));
      addSystemInclude(DriverArgs, CC1Args, new Twine(IncludeDir.c_str()));
    }
    addSystemInclude(DriverArgs, CC1Args,
        $add_Twine($add_Twine(new Twine($add_str$C(Base, Arch)), new Twine(path.get_separator())), new Twine(/*KEEP_STR*/$include)));
    addSystemInclude(DriverArgs, CC1Args, new Twine($add_str$C_T(Base, /*KEEP_STR*/"include")));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MinGW::AddClangCXXStdlibIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp", line = 219,
   FQN="clang::driver::toolchains::MinGW::AddClangCXXStdlibIncludeArgs", NM="_ZNK5clang6driver10toolchains5MinGW28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MinGW28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangCXXStdlibIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs,
                              ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))
       || DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdincxx.getValue()))) {
      return;
    }
    switch (GetCXXStdlibType(DriverArgs)) {
     case CST_Libcxx:
      addSystemInclude(DriverArgs, CC1Args,
          $add_Twine($add_Twine($add_Twine($add_Twine(new Twine($add_str$C_T(Base, /*KEEP_STR*/"include")), new Twine(path.get_separator())),
                      new Twine(/*KEEP_STR*/"c++")), new Twine(path.get_separator())), new Twine(/*KEEP_STR*/"v1")));
      break;
     case CST_Libstdcxx:
      SmallVector<SmallString> CppIncludeBases/*J*/= new SmallVector<SmallString>(4);
      CppIncludeBases.emplace_back(new SmallString(Base));
      path.append(CppIncludeBases.$at(0), new Twine(Arch), new Twine(/*KEEP_STR*/$include), new Twine(/*KEEP_STR*/"c++"));
      CppIncludeBases.emplace_back(new SmallString(Base));
      path.append(CppIncludeBases.$at(1), new Twine(Arch), new Twine(/*KEEP_STR*/$include), new Twine(/*KEEP_STR*/"c++"), new Twine(Ver));
      CppIncludeBases.emplace_back(new SmallString(Base));
      path.append(CppIncludeBases.$at(2), new Twine(/*KEEP_STR*/$include), new Twine(/*KEEP_STR*/"c++"), new Twine(Ver));
      CppIncludeBases.emplace_back(new SmallString(GccLibDir));
      path.append(CppIncludeBases.$at(3), new Twine(/*KEEP_STR*/$include), new Twine(/*KEEP_STR*/"c++"));
      for (SmallString /*&*/ CppIncludeBase : CppIncludeBases) {
        addSystemInclude(DriverArgs, CC1Args, new Twine(CppIncludeBase));
        CppIncludeBase.$addassign(path.get_separator());
        addSystemInclude(DriverArgs, CC1Args, $add_Twine(new Twine(CppIncludeBase), new Twine(Arch)));
        addSystemInclude(DriverArgs, CC1Args, $add_StringRef_char$ptr$C(CppIncludeBase.$StringRef(), /*KEEP_STR*/"backward"));
      }
      break;
    }
  }


/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MinGW::getTool">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp", line = 101,
   FQN="clang::driver::toolchains::MinGW::getTool", NM="_ZNK5clang6driver10toolchains5MinGW7getToolENS0_6Action11ActionClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MinGW7getToolENS0_6Action11ActionClassE")
  //</editor-fold>
  @Override protected Tool /*P*/ getTool(Action.ActionClass AC) /*const*//* override*/ {
    switch (AC) {
     case PreprocessJobClass:
      if (!Preprocessor.$bool()) {
        Preprocessor.reset(new GccStatics.Preprocessor(/*Deref*/this));
      }
      return Preprocessor.get();
     case CompileJobClass:
      if (!Compiler.$bool()) {
        Compiler.reset(new GccStatics.Compiler(/*Deref*/this));
      }
      return Compiler.get();
     default:
      return super.getTool(AC);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MinGW::buildLinker">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp", line = 120,
   FQN="clang::driver::toolchains::MinGW::buildLinker", NM="_ZNK5clang6driver10toolchains5MinGW11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MinGW11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new MinGWStatics.Linker(/*Deref*/this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MinGW::buildAssembler">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp", line = 116,
   FQN="clang::driver::toolchains::MinGW::buildAssembler", NM="_ZNK5clang6driver10toolchains5MinGW14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MinGW14buildAssemblerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildAssembler() /*const*//* override*/ {
    return new MinGWStatics.Assembler(/*Deref*/this);
  }


/*private:*/
  private std.string Base;
  private std.string GccLibDir;
  private std.string Ver;
  private std.string Arch;
  private /*mutable */std.unique_ptr<GccStatics.Preprocessor> Preprocessor;
  private /*mutable */std.unique_ptr<GccStatics.Compiler> Compiler;
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MinGW::findGccLibDir">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp", line = 45,
   FQN="clang::driver::toolchains::MinGW::findGccLibDir", NM="_ZN5clang6driver10toolchains5MinGW13findGccLibDirEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZN5clang6driver10toolchains5MinGW13findGccLibDirEv")
  //</editor-fold>
  private void findGccLibDir() {
    SmallVector<SmallString/*<32, 2*/> Archs/*J*/= new SmallVector<SmallString/*32, 2*/>(2);
    Archs.emplace_back(new SmallString(getTriple().getArchName().str()));
    Archs.$at(0).$addassign(/*STRINGREF_STR*/"-w64-mingw32");
    Archs.emplace_back(new SmallString("mingw32"));
    Arch.$assignMove(Archs.$at(0).str().$string());
    // lib: Arch Linux, Ubuntu, Windows
    // lib64: openSUSE Linux
    for (StringRef CandidateLib : new /*const*/StringRef/*char P*//*const*/ [/*2*/] {new StringRef("lib"), new StringRef("lib64")}) {
      for (SmallString A : Archs) {
        StringRef CandidateArch = A.$StringRef();
        SmallString/*1024*/ LibDir/*J*/= new SmallString/*1024*/(new StringRef(Base), 1024);
        path.append(LibDir, new Twine(CandidateLib), new Twine(/*KEEP_STR*/"gcc"), new Twine(CandidateArch));
        if (findGccVersion(LibDir.$StringRef(), GccLibDir, Ver)) {
          Arch.$assignMove(CandidateArch.$string());
          return;
        }
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MinGW::~MinGW">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 664,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 636,
   FQN="clang::driver::toolchains::MinGW::~MinGW", NM="_ZN5clang6driver10toolchains5MinGWD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MinGWToolChain.cpp -nm=_ZN5clang6driver10toolchains5MinGWD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Compiler.$destroy();
    Preprocessor.$destroy();
    Arch.$destroy();
    Ver.$destroy();
    GccLibDir.$destroy();
    Base.$destroy();
    super.$destroy();
    //END JDestroy
  }



  public String toString() {
    return "" + "Base=" + Base // NOI18N
              + ", GccLibDir=" + GccLibDir // NOI18N
              + ", Ver=" + Ver // NOI18N
              + ", Arch=" + Arch // NOI18N
              + ", Preprocessor=" + Preprocessor // NOI18N
              + ", Compiler=" + Compiler // NOI18N
              + super.toString(); // NOI18N
  }
}
