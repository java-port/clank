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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.tools.impl.*;
import org.clang.driver.toolchains.impl.*;;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.driver.impl.ToolChainsStatics.*;


/// MyriadToolChain - A tool chain using either clang or the external compiler
/// installed by the Movidius SDK to perform all subcommands.
//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MyriadToolChain">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1138,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1067,
 FQN="clang::driver::toolchains::MyriadToolChain", NM="_ZN5clang6driver10toolchains15MyriadToolChainE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains15MyriadToolChainE")
//</editor-fold>
public class MyriadToolChain extends /*public*/ Generic_ELF implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MyriadToolChain::MyriadToolChain">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4861,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4342,
   FQN="clang::driver::toolchains::MyriadToolChain::MyriadToolChain", NM="_ZN5clang6driver10toolchains15MyriadToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains15MyriadToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public MyriadToolChain(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ _Triple, 
      /*const*/ ArgList /*&*/ Args) {
    /* : Generic_ELF(D, Triple, Args), Compiler(), Assembler()*/ 
    //START JInit
    super(D, _Triple, Args);
    this.Compiler = new std.unique_ptr<Tool>();
    this.Assembler = new std.unique_ptr<Tool>();
    //END JInit
    // If a target of 'sparc-myriad-elf' is specified to clang, it wants to use
    // 'sparc-myriad--elf' (note the unknown OS) as the canonical triple.
    // This won't work to find gcc. Instead we give the installation detector an
    // extra triple, which is preferable to further hacks of the logic that at
    // present is based solely on getArch(). In particular, it would be wrong to
    // choose the myriad installation when targeting a non-myriad sparc install.
    switch (_Triple.getArch()) {
     default:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_target_unsupported_arch)), _Triple.getArchName()), 
              /*KEEP_STR*/"myriad"));
        } finally {
          $c$.$destroy();
        }
      }
     case sparc:
     case sparcel:
     case shave:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          GCCInstallation.init(_Triple, Args, /*{ */new ArrayRef<std.string>($c$.track(new /*const*/std.string [/*1*/] {new std.string("sparc-myriad-elf")}))/* }*/); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (GCCInstallation.isValid()) {
      // The contents of LibDir are independent of the version of gcc.
      // This contains libc, libg (a superset of libc), libm, libstdc++, libssp.
      SmallString/*128*/ LibDir/*J*/= new SmallString/*128*/(GCCInstallation.getParentLibPath(), 128);
      if (_Triple.getArch() == Triple.ArchType.sparcel) {
        path.append(LibDir, new Twine(/*KEEP_STR*/"../sparc-myriad-elf/lib/le"));
      } else {
        path.append(LibDir, new Twine(/*KEEP_STR*/"../sparc-myriad-elf/lib"));
      }
      addPathIfExists(D, new Twine(LibDir), getFilePaths());
      
      // This directory contains crt{i,n,begin,end}.o as well as libgcc.
      // These files are tied to a particular version of gcc.
      SmallString/*128*/ CompilerSupportDir/*J*/= new SmallString/*128*/(GCCInstallation.getInstallPath(), 128);
      // There are actually 4 choices: {le,be} x {fpu,nofpu}
      // but as this toolchain is for LEON sparc, it can assume FPU.
      if (_Triple.getArch() == Triple.ArchType.sparcel) {
        path.append(CompilerSupportDir, new Twine(/*KEEP_STR*/"le"));
      }
      addPathIfExists(D, new Twine(CompilerSupportDir), getFilePaths());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MyriadToolChain::~MyriadToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4901,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4382,
   FQN="clang::driver::toolchains::MyriadToolChain::~MyriadToolChain", NM="_ZN5clang6driver10toolchains15MyriadToolChainD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains15MyriadToolChainD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    Assembler.$destroy();
    Compiler.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MyriadToolChain::AddClangSystemIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4903,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4384,
   FQN="clang::driver::toolchains::MyriadToolChain::AddClangSystemIncludeArgs", NM="_ZNK5clang6driver10toolchains15MyriadToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains15MyriadToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangSystemIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                           ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (!DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdinc.getValue()))) {
      addSystemInclude(DriverArgs, CC1Args, new Twine($add_string$C_T(getDriver().SysRoot, /*KEEP_STR*/"/include")));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MyriadToolChain::AddClangCXXStdlibIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4909,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4390,
   FQN="clang::driver::toolchains::MyriadToolChain::AddClangCXXStdlibIncludeArgs", NM="_ZNK5clang6driver10toolchains15MyriadToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains15MyriadToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangCXXStdlibIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))
       || DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdincxx.getValue()))) {
      return;
    }
    
    // Only libstdc++, for now.
    StringRef LibDir = GCCInstallation.getParentLibPath();
    /*const*/ GCCVersion /*&*/ Version = GCCInstallation.getVersion();
    StringRef TripleStr = new StringRef(GCCInstallation.getTriple().str());
    /*const*/ Multilib /*&*/ Multilib = GCCInstallation.getMultilib();
    
    addLibStdCXXIncludePaths(new Twine($add_string_string$C($add_string_T($add_string($add_string_T(LibDir.str(), /*KEEP_STR*/"/../"), TripleStr.str()), /*KEEP_STR*/"/include/c++/"), Version.Text)), 
        new Twine(/*KEEP_STR*/$EMPTY), new StringRef(TripleStr), new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(/*KEEP_STR*/$EMPTY), new Twine(Multilib.includeSuffix()), DriverArgs, CC1Args);
  }

  
  // MyriadToolChain handles several triples:
  //  {shave,sparc{,el}}-myriad-{rtems,unknown}-elf
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MyriadToolChain::SelectTool">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4928,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4409,
   FQN="clang::driver::toolchains::MyriadToolChain::SelectTool", NM="_ZNK5clang6driver10toolchains15MyriadToolChain10SelectToolERKNS0_9JobActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains15MyriadToolChain10SelectToolERKNS0_9JobActionE")
  //</editor-fold>
  @Override public Tool /*P*/ SelectTool(/*const*/ JobAction /*&*/ JA) /*const*//* override*/ {
    // The inherited method works fine if not targeting the SHAVE.
    if (!isShaveCompilation(getTriple())) {
      return super.SelectTool(JA);
    }
    switch (JA.getKind()) {
     case PreprocessJobClass:
     case CompileJobClass:
      if (!Compiler.$bool()) {
        Compiler.reset(new SHAVEStatics.Compiler(/*Deref*/this));
      }
      return Compiler.get();
     case AssembleJobClass:
      if (!Assembler.$bool()) {
        Assembler.reset(new SHAVEStatics.Assembler(/*Deref*/this));
      }
      return Assembler.get();
     default:
      return super.getTool(JA.getKind());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MyriadToolChain::GetDefaultDwarfVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1151,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1080,
   FQN="clang::driver::toolchains::MyriadToolChain::GetDefaultDwarfVersion", NM="_ZNK5clang6driver10toolchains15MyriadToolChain22GetDefaultDwarfVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains15MyriadToolChain22GetDefaultDwarfVersionEv")
  //</editor-fold>
  @Override public /*uint*/int GetDefaultDwarfVersion() /*const*//* override*/ {
    return 2;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MyriadToolChain::buildLinker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4947,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4428,
   FQN="clang::driver::toolchains::MyriadToolChain::buildLinker", NM="_ZNK5clang6driver10toolchains15MyriadToolChain11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains15MyriadToolChain11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new MyriadStatics.Linker(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MyriadToolChain::isShaveCompilation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1155,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1084,
   FQN="clang::driver::toolchains::MyriadToolChain::isShaveCompilation", NM="_ZNK5clang6driver10toolchains15MyriadToolChain18isShaveCompilationERKN4llvm6TripleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains15MyriadToolChain18isShaveCompilationERKN4llvm6TripleE")
  //</editor-fold>
  protected boolean isShaveCompilation(/*const*/ Triple /*&*/ T) /*const*/ {
    return T.getArch() == Triple.ArchType.shave;
  }

/*private:*/
  private /*mutable */std.unique_ptr<Tool> Compiler;
  private /*mutable */std.unique_ptr<Tool> Assembler;
  
  public String toString() {
    return "" + "Compiler=" + Compiler // NOI18N
              + ", Assembler=" + Assembler // NOI18N
              + super.toString(); // NOI18N
  }
}
