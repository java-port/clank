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
package org.clang.driver.tools.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
;
import org.llvm.support.sys.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.driver.impl.ToolsStatics.*;
import static org.clang.driver.java.JavaDriverSupport.*;


//<editor-fold defaultstate="collapsed" desc="static type DarwinStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin11VerifyDebugE;_ZN5clang6driver5tools6darwin27getArchTypeForMachOArchNameEN4llvm9StringRefE;_ZN5clang6driver5tools6darwin29setTripleTypeForMachOArchNameERN4llvm6TripleENS3_9StringRefE;_ZN5clang6driver5tools6darwin4LipoE;_ZN5clang6driver5tools6darwin6LinkerE;_ZN5clang6driver5tools6darwin8DsymutilE;_ZN5clang6driver5tools6darwin9AssemblerE;_ZN5clang6driver5tools6darwin9MachOToolE; -static-type=DarwinStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class DarwinStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::getArchTypeForMachOArchName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7363,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6741,
 FQN="clang::driver::tools::darwin::getArchTypeForMachOArchName", NM="_ZN5clang6driver5tools6darwin27getArchTypeForMachOArchNameEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin27getArchTypeForMachOArchNameEN4llvm9StringRefE")
//</editor-fold>
public static Triple.ArchType getArchTypeForMachOArchName(StringRef Str) {
  // See arch(3) and llvm-gcc's driver-driver.c. We don't implement support for
  // archs which Darwin doesn't use.
  
  // The matching this routine does is fairly pointless, since it is neither the
  // complete architecture list, nor a reasonable subset. The problem is that
  // historically the driver driver accepts this and also ties its -march=
  // handling to the architecture name, so we need to be careful before removing
  // support for it.
  
  // This code must be kept in sync with Clang's Darwin specific argument
  // translation.
  return new StringSwitch<Triple.ArchType>(/*NO_COPY*/Str).
      Cases(/*KEEP_STR*/"ppc", /*KEEP_STR*/"ppc601", /*KEEP_STR*/"ppc603", /*KEEP_STR*/"ppc604", /*KEEP_STR*/"ppc604e", Triple.ArchType.ppc).
      Cases(/*KEEP_STR*/"ppc750", /*KEEP_STR*/"ppc7400", /*KEEP_STR*/"ppc7450", /*KEEP_STR*/"ppc970", Triple.ArchType.ppc).
      Case(/*KEEP_STR*/"ppc64", Triple.ArchType.ppc64).
      Cases(/*KEEP_STR*/"i386", /*KEEP_STR*/"i486", /*KEEP_STR*/"i486SX", /*KEEP_STR*/"i586", /*KEEP_STR*/"i686", Triple.ArchType.x86).
      Cases(/*KEEP_STR*/"pentium", /*KEEP_STR*/"pentpro", /*KEEP_STR*/"pentIIm3", /*KEEP_STR*/"pentIIm5", /*KEEP_STR*/"pentium4", 
      Triple.ArchType.x86).
      Cases(/*KEEP_STR*/"x86_64", /*KEEP_STR*/"x86_64h", Triple.ArchType.x86_64).
      // This is derived from the driver driver.
      Cases(/*KEEP_STR*/"arm", /*KEEP_STR*/"armv4t", /*KEEP_STR*/"armv5", /*KEEP_STR*/"armv6", /*KEEP_STR*/"armv6m", Triple.ArchType.arm).
      Cases(/*KEEP_STR*/"armv7", /*KEEP_STR*/"armv7em", /*KEEP_STR*/"armv7k", /*KEEP_STR*/"armv7m", Triple.ArchType.arm).
      Cases(/*KEEP_STR*/"armv7s", /*KEEP_STR*/"xscale", Triple.ArchType.arm).
      Case(/*KEEP_STR*/"arm64", Triple.ArchType.aarch64).
      Case(/*KEEP_STR*/"r600", Triple.ArchType.r600).
      Case(/*KEEP_STR*/"amdgcn", Triple.ArchType.amdgcn).
      Case(/*KEEP_STR*/"nvptx", Triple.ArchType.nvptx).
      Case(/*KEEP_STR*/"nvptx64", Triple.ArchType.nvptx64).
      Case(/*KEEP_STR*/"amdil", Triple.ArchType.amdil).
      Case(/*KEEP_STR*/"spir", Triple.ArchType.spir).
      Default(Triple.ArchType.UnknownArch);
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::setTripleTypeForMachOArchName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7398,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6776,
 FQN="clang::driver::tools::darwin::setTripleTypeForMachOArchName", NM="_ZN5clang6driver5tools6darwin29setTripleTypeForMachOArchNameERN4llvm6TripleENS3_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin29setTripleTypeForMachOArchNameERN4llvm6TripleENS3_9StringRefE")
//</editor-fold>
public static void setTripleTypeForMachOArchName(Triple /*&*/ T, StringRef Str) {
  /*const*/ Triple.ArchType Arch = getArchTypeForMachOArchName(new StringRef(Str));
  T.setArch(Arch);
  if ($eq_StringRef(/*NO_COPY*/Str, /*STRINGREF_STR*/"x86_64h")) {
    T.setArchName(new StringRef(Str));
  } else if ($eq_StringRef(/*NO_COPY*/Str, /*STRINGREF_STR*/"armv6m") || $eq_StringRef(/*NO_COPY*/Str, /*STRINGREF_STR*/"armv7m") || $eq_StringRef(/*NO_COPY*/Str, /*STRINGREF_STR*/"armv7em")) {
    T.setOS(Triple.OSType.UnknownOS);
    T.setObjectFormat(Triple.ObjectFormatType.MachO);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::MachOTool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 334,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 331,
 FQN="clang::driver::tools::darwin::MachOTool", NM="_ZN5clang6driver5tools6darwin9MachOToolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin9MachOToolE")
//</editor-fold>
public abstract static class MachOTool extends /*public*/ Tool implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::MachOTool::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7577,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6947,
   FQN="clang::driver::tools::darwin::MachOTool::anchor", NM="_ZN5clang6driver5tools6darwin9MachOTool6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin9MachOTool6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::MachOTool::AddMachOArch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7579,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6949,
   FQN="clang::driver::tools::darwin::MachOTool::AddMachOArch", NM="_ZNK5clang6driver5tools6darwin9MachOTool12AddMachOArchERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin9MachOTool12AddMachOArchERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  protected void AddMachOArch(/*const*/ ArgList /*&*/ Args, 
              ArgStringList/*&*/ CmdArgs) /*const*/ {
    StringRef ArchName = getMachOToolChain().getMachOArchName(Args);
    
    // Derived from darwin_arch spec.
    CmdArgs.push_back($("-arch"));
    CmdArgs.push_back(Args.MakeArgString(new Twine(ArchName)));
    
    // FIXME: Is this needed anymore?
    if ($eq_StringRef(/*NO_COPY*/ArchName, /*STRINGREF_STR*/"arm")) {
      CmdArgs.push_back($("-force_cpusubtype_ALL"));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::MachOTool::getMachOToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 341,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 338,
   FQN="clang::driver::tools::darwin::MachOTool::getMachOToolChain", NM="_ZNK5clang6driver5tools6darwin9MachOTool17getMachOToolChainEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin9MachOTool17getMachOToolChainEv")
  //</editor-fold>
  protected /*const*/ org.clang.driver.toolchains.impl.MachO /*&*/ getMachOToolChain() /*const*/ {
    ToolChain toolChain = getToolChain();
    if (toolChain instanceof org.clang.driver.toolchains.impl.MachO) {
      return (org.clang.driver.toolchains.impl.MachO) toolChain;
    }
    return new org.clang.driver.toolchains.impl.MachO(toolChain.getDriver(), toolChain.getTriple(), toolChain.Args);
    //return reinterpret_cast(/*const*/ org.clang.driver.toolchains.impl.MachO /*&*/ .class, getToolChain());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::MachOTool::MachOTool">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 346,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 343,
   FQN="clang::driver::tools::darwin::MachOTool::MachOTool", NM="_ZN5clang6driver5tools6darwin9MachOToolC1EPKcS5_RKNS0_9ToolChainENS0_4Tool19ResponseFileSupportEN4llvm3sys21WindowsEncodingMethodES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin9MachOToolC1EPKcS5_RKNS0_9ToolChainENS0_4Tool19ResponseFileSupportEN4llvm3sys21WindowsEncodingMethodES5_")
  //</editor-fold>
  public MachOTool(/*const*/char$ptr/*char P*/ Name, /*const*/char$ptr/*char P*/ ShortName, /*const*/ ToolChain /*&*/ TC) {
    this(Name, ShortName, TC, 
      ResponseFileSupport.RF_None, 
      WindowsEncodingMethod.WEM_UTF8, 
      $AT);
  }
  public MachOTool(/*const*/char$ptr/*char P*/ Name, /*const*/char$ptr/*char P*/ ShortName, /*const*/ ToolChain /*&*/ TC, 
      ResponseFileSupport ResponseSupport/*= RF_None*/) {
    this(Name, ShortName, TC, 
      ResponseSupport, 
      WindowsEncodingMethod.WEM_UTF8, 
      $AT);
  }
  public MachOTool(/*const*/char$ptr/*char P*/ Name, /*const*/char$ptr/*char P*/ ShortName, /*const*/ ToolChain /*&*/ TC, 
      ResponseFileSupport ResponseSupport/*= RF_None*/, 
      WindowsEncodingMethod ResponseEncoding/*= sys::WEM_UTF8*/) {
    this(Name, ShortName, TC, 
      ResponseSupport, 
      ResponseEncoding, 
      $AT);
  }
  public MachOTool(/*const*/char$ptr/*char P*/ Name, /*const*/char$ptr/*char P*/ ShortName, /*const*/ ToolChain /*&*/ TC, 
      ResponseFileSupport ResponseSupport/*= RF_None*/, 
      WindowsEncodingMethod ResponseEncoding/*= sys::WEM_UTF8*/, 
      /*const*/char$ptr/*char P*/ ResponseFlag/*= "@"*/) {
    /* : Tool(Name, ShortName, TC, ResponseSupport, ResponseEncoding, ResponseFlag)*/ 
    //START JInit
    super(Name, ShortName, TC, ResponseSupport, ResponseEncoding, 
        ResponseFlag);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::MachOTool::~MachOTool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 334,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 331,
   FQN="clang::driver::tools::darwin::MachOTool::~MachOTool", NM="_ZN5clang6driver5tools6darwin9MachOToolD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin9MachOToolD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Assembler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 355,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 352,
 FQN="clang::driver::tools::darwin::Assembler", NM="_ZN5clang6driver5tools6darwin9AssemblerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin9AssemblerE")
//</editor-fold>
public static class Assembler extends /*public*/ MachOTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Assembler::Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 357,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 354,
   FQN="clang::driver::tools::darwin::Assembler::Assembler", NM="_ZN5clang6driver5tools6darwin9AssemblerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin9AssemblerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Assembler(/*const*/ ToolChain /*&*/ TC) {
    /* : MachOTool("darwin::Assembler", "assembler", TC)*/ 
    //START JInit
    super($("darwin::Assembler"), $("assembler"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Assembler::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 360,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 357,
   FQN="clang::driver::tools::darwin::Assembler::hasIntegratedCPP", NM="_ZNK5clang6driver5tools6darwin9Assembler16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin9Assembler16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Assembler::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7509,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6879,
   FQN="clang::driver::tools::darwin::Assembler::ConstructJob", NM="_ZNK5clang6driver5tools6darwin9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      assert (Inputs.size() == 1) : "Unexpected number of inputs.";
      /*const*/ InputInfo /*&*/ Input = Inputs.$at(0);
      
      // Determine the original source input.
      /*const*/Action/*P*/ SourceAction = /*AddrOf*/JA;
      while (SourceAction.getKind() != Action.ActionClass.InputClass) {
        assert (!SourceAction.getInputs().empty()) : "unexpected root action!";
        SourceAction = SourceAction.getInputs().$at(0);
      }
      
      // If -fno-integrated-as is used add -Q to the darwin assember driver to make
      // sure it runs its system assembler not clang's integrated assembler.
      // Applicable to darwin11+ and Xcode 4+.  darwin<10 lacked integrated-as.
      // FIXME: at run-time detect assembler capabilities or rely on version
      // information forwarded by -target-assembler-version.
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_fno_integrated_as.getValue()))) {
        /*const*/ Triple /*&*/ T/*J*/= getToolChain().getTriple();
        if (!(T.isMacOSX() && T.isMacOSXVersionLT(10, 7))) {
          CmdArgs.push_back($("-Q"));
        }
      }
      
      // Forward -g, assuming we are dealing with an actual assembly file.
      if (SourceAction.getType() == types.ID.TY_Asm
         || SourceAction.getType() == types.ID.TY_PP_Asm) {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_gstabs.getValue()))) {
          CmdArgs.push_back($("--gstabs"));
        } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_g_Group.getValue()))) {
          CmdArgs.push_back($("-g"));
        }
      }
      
      // Derived from asm spec.
      AddMachOArch(Args, CmdArgs);
      
      // Use -force_cpusubtype_ALL on x86 by default.
      if (getToolChain().getArch() == Triple.ArchType.x86
         || getToolChain().getArch() == Triple.ArchType.x86_64
         || Args.hasArg(new OptSpecifier(options.ID.OPT_force__cpusubtype__ALL.getValue()))) {
        CmdArgs.push_back($("-force_cpusubtype_ALL"));
      }
      if (getToolChain().getArch() != Triple.ArchType.x86_64
         && (((Args.hasArg(new OptSpecifier(options.ID.OPT_mkernel.getValue()))
         || Args.hasArg(new OptSpecifier(options.ID.OPT_fapple_kext.getValue())))
         && getMachOToolChain().isKernelStatic())
         || Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue())))) {
        CmdArgs.push_back($("-static"));
      }
      
      Args.AddAllArgValues(CmdArgs, new OptSpecifier(options.ID.OPT_Wa_COMMA.getValue()), new OptSpecifier(options.ID.OPT_Xassembler.getValue()));
      assert (Output.isFilename()) : "Unexpected lipo output.";
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
      assert (Input.isFilename()) : "Invalid input.";
      CmdArgs.push_back(Input.getFilename());
      
      // asm_final spec is empty.
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(getToolChain().GetProgramPath($("as")))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Assembler::~Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 355,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 352,
   FQN="clang::driver::tools::darwin::Assembler::~Assembler", NM="_ZN5clang6driver5tools6darwin9AssemblerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin9AssemblerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 368,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 365,
 FQN="clang::driver::tools::darwin::Linker", NM="_ZN5clang6driver5tools6darwin6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin6LinkerE")
//</editor-fold>
public static class Linker extends /*public*/ MachOTool implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Linker::NeedsTempPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7592,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6962,
   FQN="clang::driver::tools::darwin::Linker::NeedsTempPath", NM="_ZNK5clang6driver5tools6darwin6Linker13NeedsTempPathERKN4llvm11SmallVectorINS0_9InputInfoELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin6Linker13NeedsTempPathERKN4llvm11SmallVectorINS0_9InputInfoELj4EEE")
  //</editor-fold>
  private boolean NeedsTempPath(/*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs) /*const*/ {
    // We only need to generate a temp path for LTO if we aren't compiling object
    // files. When compiling source files, we run 'dsymutil' after linking. We
    // don't run 'dsymutil' when compiling object files.
    for (/*const*/ InputInfo /*&*/ Input : Inputs)  {
      if (Input.getType() != types.ID.TY_Object) {
        return true;
      }
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Linker::AddLinkArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7603,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6973,
   FQN="clang::driver::tools::darwin::Linker::AddLinkArgs", NM="_ZNK5clang6driver5tools6darwin6Linker11AddLinkArgsERNS0_11CompilationERKN4llvm3opt7ArgListERNS6_11SmallVectorIPKcLj16EEERKNSB_INS0_9InputInfoELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin6Linker11AddLinkArgsERNS0_11CompilationERKN4llvm3opt7ArgListERNS6_11SmallVectorIPKcLj16EEERKNSB_INS0_9InputInfoELj4EEE")
  //</editor-fold>
  private void AddLinkArgs(Compilation /*&*/ C, /*const*/ ArgList /*&*/ Args, 
             ArgStringList/*&*/ CmdArgs, 
             /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs) /*const*/ {
    /*const*/ Driver /*&*/ D = getToolChain().getDriver();
    /*const*/ org.clang.driver.toolchains.impl.MachO /*&*/ MachOTC = getMachOToolChain();
    
    /*uint*/int Version[/*5*/] = new /*uint*/int [/*5*/] {0, 0, 0, 0, 0};
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mlinker_version_EQ.getValue()));
      if ((A != null)) {
        if (!Driver.GetReleaseVersion(A.getValue(), new MutableArrayRefUInt(Version))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_invalid_version_number)), new StringRef(A.getAsString(Args))));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // Newer linkers support -demangle. Pass it if supported and not disabled by
    // the user.
    if ($greatereq_uint(Version[0], 100) && !Args.hasArg(new OptSpecifier(options.ID.OPT_Z_Xlinker__no_demangle.getValue()))) {
      CmdArgs.push_back($("-demangle"));
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_rdynamic.getValue())) && $greatereq_uint(Version[0], 137)) {
      CmdArgs.push_back($("-export_dynamic"));
    }
    
    // If we are using App Extension restrictions, pass a flag to the linker
    // telling it that the compiled code has been audited.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fapplication_extension.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_application_extension.getValue()), false)) {
      CmdArgs.push_back($("-application_extension"));
    }
    if (D.isUsingLTO()) {
      // If we are using LTO, then automatically create a temporary file path for
      // the linker to use, so that it's lifetime will extend past a possible
      // dsymutil step.
      if ($greatereq_uint(Version[0], 116) && NeedsTempPath(Inputs)) {
        /*const*/char$ptr/*char P*/ TmpPath = $tryClone(C.getArgs().MakeArgString(new Twine(D.GetTemporaryPath(new StringRef(/*KEEP_STR*/"cc"), types.getTypeTempSuffix(types.ID.TY_Object)))));
        C.addTempFile(TmpPath);
        CmdArgs.push_back($("-object_path_lto"));
        CmdArgs.push_back(TmpPath);
      }
      
      // Use -lto_library option to specify the libLTO.dylib path. Try to find
      // it in clang installed libraries. If not found, the option is not used
      // and 'ld' will use its default mechanism to search for libLTO.dylib.
      if ($greatereq_uint(Version[0], 133)) {
        // Search for libLTO in <InstalledDir>/../lib/libLTO.dylib
        StringRef P = path.parent_path(new StringRef(D.getInstalledDir()));
        SmallString/*128*/ LibLTOPath/*J*/= new SmallString/*128*/(new StringRef(P), 128);
        path.append(LibLTOPath, new Twine(/*KEEP_STR*/"lib"));
        path.append(LibLTOPath, new Twine(/*KEEP_STR*/"libLTO.dylib"));
        if (fs.exists(new Twine(LibLTOPath))) {
          CmdArgs.push_back($("-lto_library"));
          CmdArgs.push_back(C.getArgs().MakeArgString(new Twine(LibLTOPath)));
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(D.Diag(diag.warn_drv_lto_libpath)));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // Derived from the "link" spec.
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_static.getValue()));
    if (!Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
      CmdArgs.push_back($("-dynamic"));
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_fgnu_runtime.getValue()))) {
      // FIXME: gcc replaces -lobjc in forward args with -lobjc-gnu
      // here. How do we wish to handle such things?
    }
    if (!Args.hasArg(new OptSpecifier(options.ID.OPT_dynamiclib.getValue()))) {
      AddMachOArch(Args, CmdArgs);
      // FIXME: Why do this only on this path?
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_force__cpusubtype__ALL.getValue()));
      
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_bundle.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_bundle__loader.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_client__name.getValue()));
      
      Arg /*P*/ A;
      if (((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_compatibility__version.getValue()))) != null)
         || ((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_current__version.getValue()))) != null)
         || ((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_install__name.getValue()))) != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_only_allowed_with)), new StringRef(A.getAsString(Args))), 
              /*KEEP_STR*/"-dynamiclib"));
        } finally {
          $c$.$destroy();
        }
      }
      
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_force__flat__namespace.getValue()));
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_keep__private__externs.getValue()));
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_private__bundle.getValue()));
    } else {
      CmdArgs.push_back($("-dylib"));
      
      Arg /*P*/ A;
      if (((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_bundle.getValue()))) != null)
         || ((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_bundle__loader.getValue()))) != null)
         || ((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_client__name.getValue()))) != null)
         || ((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_force__flat__namespace.getValue()))) != null)
         || ((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_keep__private__externs.getValue()))) != null)
         || ((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_private__bundle.getValue()))) != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), new StringRef(A.getAsString(Args))), 
              /*KEEP_STR*/"-dynamiclib"));
        } finally {
          $c$.$destroy();
        }
      }
      
      Args.AddAllArgsTranslated(CmdArgs, new OptSpecifier(options.ID.OPT_compatibility__version.getValue()), 
          $("-dylib_compatibility_version"));
      Args.AddAllArgsTranslated(CmdArgs, new OptSpecifier(options.ID.OPT_current__version.getValue()), 
          $("-dylib_current_version"));
      
      AddMachOArch(Args, CmdArgs);
      
      Args.AddAllArgsTranslated(CmdArgs, new OptSpecifier(options.ID.OPT_install__name.getValue()), 
          $("-dylib_install_name"));
    }
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_all__load.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_allowable__client.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_bind__at__load.getValue()));
    if (MachOTC.isTargetIOSBased()) {
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_arch__errors__fatal.getValue()));
    }
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_dead__strip.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_no__dead__strip__inits__and__terms.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_dylib__file.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_dynamic.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_exported__symbols__list.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_flat__namespace.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_force__load.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_headerpad__max__install__names.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_image__base.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_init.getValue()));
    
    // Add the deployment target.
    MachOTC.addMinVersionArgs(Args, CmdArgs);
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_nomultidefs.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_multi__module.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_single__module.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_multiply__defined.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_multiply__defined__unused.getValue()));
    {
      
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fpie.getValue()), new OptSpecifier(options.ID.OPT_fPIE.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_pie.getValue()), new OptSpecifier(options.ID.OPT_fno_PIE.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_fpie.getValue()))
           || A.getOption().matches(new OptSpecifier(options.ID.OPT_fPIE.getValue()))) {
          CmdArgs.push_back($("-pie"));
        } else {
          CmdArgs.push_back($("-no_pie"));
        }
      }
    }
    // for embed-bitcode, use -bitcode_bundle in linker command
    if (C.getDriver().embedBitcodeEnabled()
       || C.getDriver().embedBitcodeMarkerOnly()) {
      // Check if the toolchain supports bitcode build flow.
      if (MachOTC.SupportsEmbeddedBitcode()) {
        CmdArgs.push_back($("-bitcode_bundle"));
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(D.Diag(diag.err_drv_bitcode_unsupported_on_toolchain)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_prebind.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_noprebind.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_nofixprebinding.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_prebind__all__twolevel__modules.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_read__only__relocs.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_sectcreate.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_sectorder.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_seg1addr.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_segprot.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_segaddr.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_segs__read__only__addr.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_segs__read__write__addr.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_seg__addr__table.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_seg__addr__table__filename.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_sub__library.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_sub__umbrella.getValue()));
    
    // Give --sysroot= preference, over the Apple specific behavior to also use
    // --isysroot as the syslibroot.
    StringRef sysroot = C.getSysRoot();
    if ($noteq_StringRef(/*NO_COPY*/sysroot, /*STRINGREF_STR*/"")) {
      CmdArgs.push_back($("-syslibroot"));
      CmdArgs.push_back(C.getArgs().MakeArgString(new Twine(sysroot)));
    } else {
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_isysroot.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-syslibroot"));
        CmdArgs.push_back(A.getValue());
      }
    }
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_twolevel__namespace.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_twolevel__namespace__hints.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_umbrella.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_undefined.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_unexported__symbols__list.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_weak__reference__mismatches.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_X_Flag.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_y.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_w.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_pagezero__size.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_segs__read__.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_seglinkedit.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_noseglinkedit.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_sectalign.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_sectobjectsymbols.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_segcreate.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_whyload.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_whatsloaded.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_dylinker__install__name.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_dylinker.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_Mach.getValue()));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Linker::Linker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 375,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 372,
   FQN="clang::driver::tools::darwin::Linker::Linker", NM="_ZN5clang6driver5tools6darwin6LinkerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin6LinkerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Linker(/*const*/ ToolChain /*&*/ TC) {
    /* : MachOTool("darwin::Linker", "linker", TC, RF_FileList, sys::WEM_UTF8, "-filelist")*/ 
    //START JInit
    super($("darwin::Linker"), $("linker"), TC, ResponseFileSupport.RF_FileList, 
        WindowsEncodingMethod.WEM_UTF8, $("-filelist"));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Linker::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 379,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 376,
   FQN="clang::driver::tools::darwin::Linker::hasIntegratedCPP", NM="_ZNK5clang6driver5tools6darwin6Linker16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin6Linker16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Linker::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 380,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 377,
   FQN="clang::driver::tools::darwin::Linker::isLinkJob", NM="_ZNK5clang6driver5tools6darwin6Linker9isLinkJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin6Linker9isLinkJobEv")
  //</editor-fold>
  @Override public boolean isLinkJob() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Linker::ConstructJob">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7806,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 7170,
   FQN="clang::driver::tools::darwin::Linker::ConstructJob", NM="_ZNK5clang6driver5tools6darwin6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    std.unique_ptr<Command> Cmd = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (Output.getType() == types.ID.TY_Image) : "Invalid linker output type.";
      
      // If the number of arguments surpasses the system limits, we will encode the
      // input files in a separate file, shortening the command line. To this end,
      // build a list of input file names that can be passed via a file with the
      // -filelist linker option.
      ArgStringList InputFileList/*J*/= new ArgStringList();
      
      // The logic here is derived from gcc's behavior; most of which
      // comes from specs (starting with link_command). Consult gcc for
      // more information.
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      
      /// Hack(tm) to ignore linking errors when we are doing ARC migration.
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_ccc_arcmt_check.getValue()), 
          new OptSpecifier(options.ID.OPT_ccc_arcmt_migrate.getValue()))) {
        for (Arg /*P*/ /*const*/ /*&*/ Arg : Args)  {
          Arg.claim();
        }
        /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(getToolChain().GetProgramPath($("touch")))));
        CmdArgs.push_back(Output.getFilename());
        C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, ArrayRef.None())))); $c$.clean();
        return;
      }
      
      // I'm not sure why this particular decomposition exists in gcc, but
      // we follow suite for ease of comparison.
      AddLinkArgs(C, Args, CmdArgs, Inputs);
      
      // It seems that the 'e' option is completely ignored for dynamic executables
      // (the default), and with static executables, the last one wins, as expected.
      Args.AddAllArgs(CmdArgs, /*{ */new ArrayRef<OptSpecifier>($IDsToOptSpecifiers(new /*const*/ options.ID [/*7*/] {
                options.ID.OPT_d_Flag, options.ID.OPT_s, options.ID.OPT_t, 
                options.ID.OPT_Z_Flag, options.ID.OPT_u_Group, 
                options.ID.OPT_e, options.ID.OPT_r}))/* }*/);
      
      // Forward -ObjC when either -ObjC or -ObjC++ is used, to force loading
      // members of static archive libraries which implement Objective-C classes or
      // categories.
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_ObjC.getValue())) || Args.hasArg(new OptSpecifier(options.ID.OPT_ObjCXX.getValue()))) {
        CmdArgs.push_back($("-ObjC"));
      }
      
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
        getMachOToolChain().addStartObjectFileArgs(Args, CmdArgs);
      }
      
      // SafeStack requires its own runtime libraries
      // These libraries should be linked first, to make sure the
      // __safestack_init constructor executes before everything else
      if (getToolChain().getSanitizerArgs().needsSafeStackRt()) {
        getMachOToolChain().AddLinkRuntimeLib(Args, CmdArgs, 
            new StringRef(/*KEEP_STR*/"libclang_rt.safestack_osx.a"), 
            /*AlwaysLink=*/ true);
      }
      
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_L.getValue()));
      
      AddLinkerInputs(getToolChain(), Inputs, Args, CmdArgs);
      // Build the input file for -filelist (list of linker input files) in case we
      // need it later
      for (/*const*/ InputInfo /*&*/ II : Inputs) {
        if (!II.isFilename()) {
          // This is a linker input argument.
          // We cannot mix input arguments and file names in a -filelist input, thus
          // we prematurely stop our list (remaining files shall be passed as
          // arguments).
          if ($greater_uint(InputFileList.size(), 0)) {
            break;
          }
          
          continue;
        }
        
        InputFileList.push_back(II.getFilename());
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
        addOpenMPRuntime(CmdArgs, getToolChain(), Args);
      }
      if (isObjCRuntimeLinked(Args)
         && !Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
        // We use arclite library for both ARC and subscripting support.
        getMachOToolChain().AddLinkARCArgs(Args, CmdArgs);
        
        CmdArgs.push_back($("-framework"));
        CmdArgs.push_back($("Foundation"));
        // Link libobj.
        CmdArgs.push_back($("-lobjc"));
      }
      if ((LinkingOutput != null)) {
        CmdArgs.push_back($("-arch_multiple"));
        CmdArgs.push_back($("-final_output"));
        CmdArgs.push_back(LinkingOutput);
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_fnested_functions.getValue()))) {
        CmdArgs.push_back($("-allow_stack_execute"));
      }
      
      getMachOToolChain().addProfileRTLibs(Args, CmdArgs);
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
        if (getToolChain().getDriver().CCCIsCXX()) {
          getToolChain().AddCXXStdlibLibArgs(Args, CmdArgs);
        }
        
        // link_ssp spec is empty.
        
        // Let the tool chain choose which runtime library to link.
        getMachOToolChain().AddLinkRuntimeLibArgs(Args, CmdArgs);
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
        // endfile_spec is empty.
      }
      
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_T_Group.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_F.getValue()));
      
      // -iframework should be forwarded as -F.
      for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_iframework.getValue())))  {
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_string_T(new std.string(/*KEEP_STR*/"-F"), A.getValue()))));
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
        {
          Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fveclib.getValue()));
          if ((A != null)) {
            if ($eq_StringRef(/*STRINGREF_STR*/A.getValue(), /*STRINGREF_STR*/"Accelerate")) {
              CmdArgs.push_back($("-framework"));
              CmdArgs.push_back($("Accelerate"));
            }
          }
        }
      }
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(getToolChain().GetLinkerPath())));
      Cmd = llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs));
      Cmd.$arrow().setInputFileList(new ArgStringList(JD$Move.INSTANCE, std.move(InputFileList)));
      C.addCommand($c$.track(new std.unique_ptr<Command>(JD$Move.INSTANCE, std.move(Cmd)))); $c$.clean();
    } finally {
      if (Cmd != null) { Cmd.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 368,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 365,
   FQN="clang::driver::tools::darwin::Linker::~Linker", NM="_ZN5clang6driver5tools6darwin6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin6LinkerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Lipo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 388,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 385,
 FQN="clang::driver::tools::darwin::Lipo", NM="_ZN5clang6driver5tools6darwin4LipoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin4LipoE")
//</editor-fold>
public static class Lipo extends /*public*/ MachOTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Lipo::Lipo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 390,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 387,
   FQN="clang::driver::tools::darwin::Lipo::Lipo", NM="_ZN5clang6driver5tools6darwin4LipoC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin4LipoC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Lipo(/*const*/ ToolChain /*&*/ TC) {
    /* : MachOTool("darwin::Lipo", "lipo", TC)*/ 
    //START JInit
    super($("darwin::Lipo"), $("lipo"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Lipo::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 392,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 389,
   FQN="clang::driver::tools::darwin::Lipo::hasIntegratedCPP", NM="_ZNK5clang6driver5tools6darwin4Lipo16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin4Lipo16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Lipo::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7949,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 7313,
   FQN="clang::driver::tools::darwin::Lipo::ConstructJob", NM="_ZNK5clang6driver5tools6darwin4Lipo12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin4Lipo12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      
      CmdArgs.push_back($("-create"));
      assert (Output.isFilename()) : "Unexpected lipo output.";
      
      CmdArgs.push_back($("-output"));
      CmdArgs.push_back(Output.getFilename());
      
      for (/*const*/ InputInfo /*&*/ II : Inputs) {
        assert (II.isFilename()) : "Unexpected lipo input.";
        CmdArgs.push_back(II.getFilename());
      }
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(getToolChain().GetProgramPath($("lipo")))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Lipo::~Lipo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 388,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 385,
   FQN="clang::driver::tools::darwin::Lipo::~Lipo", NM="_ZN5clang6driver5tools6darwin4LipoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin4LipoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Dsymutil">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 400,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 397,
 FQN="clang::driver::tools::darwin::Dsymutil", NM="_ZN5clang6driver5tools6darwin8DsymutilE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin8DsymutilE")
//</editor-fold>
public static class Dsymutil extends /*public*/ MachOTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Dsymutil::Dsymutil">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 402,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 399,
   FQN="clang::driver::tools::darwin::Dsymutil::Dsymutil", NM="_ZN5clang6driver5tools6darwin8DsymutilC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin8DsymutilC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Dsymutil(/*const*/ ToolChain /*&*/ TC) {
    /* : MachOTool("darwin::Dsymutil", "dsymutil", TC)*/ 
    //START JInit
    super($("darwin::Dsymutil"), $("dsymutil"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Dsymutil::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 405,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 402,
   FQN="clang::driver::tools::darwin::Dsymutil::hasIntegratedCPP", NM="_ZNK5clang6driver5tools6darwin8Dsymutil16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin8Dsymutil16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Dsymutil::isDsymutilJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 406,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 403,
   FQN="clang::driver::tools::darwin::Dsymutil::isDsymutilJob", NM="_ZNK5clang6driver5tools6darwin8Dsymutil13isDsymutilJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin8Dsymutil13isDsymutilJobEv")
  //</editor-fold>
  @Override public boolean isDsymutilJob() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Dsymutil::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7971,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 7335,
   FQN="clang::driver::tools::darwin::Dsymutil::ConstructJob", NM="_ZNK5clang6driver5tools6darwin8Dsymutil12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin8Dsymutil12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
      assert (Inputs.size() == 1) : "Unable to handle multiple inputs.";
      /*const*/ InputInfo /*&*/ Input = Inputs.$at(0);
      assert (Input.isFilename()) : "Unexpected dsymutil input.";
      CmdArgs.push_back(Input.getFilename());
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(getToolChain().GetProgramPath($("dsymutil")))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::Dsymutil::~Dsymutil">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 400,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 397,
   FQN="clang::driver::tools::darwin::Dsymutil::~Dsymutil", NM="_ZN5clang6driver5tools6darwin8DsymutilD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin8DsymutilD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::VerifyDebug">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 414,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 411,
 FQN="clang::driver::tools::darwin::VerifyDebug", NM="_ZN5clang6driver5tools6darwin11VerifyDebugE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin11VerifyDebugE")
//</editor-fold>
public static class VerifyDebug extends /*public*/ MachOTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::VerifyDebug::VerifyDebug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 416,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 413,
   FQN="clang::driver::tools::darwin::VerifyDebug::VerifyDebug", NM="_ZN5clang6driver5tools6darwin11VerifyDebugC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin11VerifyDebugC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public VerifyDebug(/*const*/ ToolChain /*&*/ TC) {
    /* : MachOTool("darwin::VerifyDebug", "dwarfdump", TC)*/ 
    //START JInit
    super($("darwin::VerifyDebug"), $("dwarfdump"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::VerifyDebug::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 419,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 416,
   FQN="clang::driver::tools::darwin::VerifyDebug::hasIntegratedCPP", NM="_ZNK5clang6driver5tools6darwin11VerifyDebug16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin11VerifyDebug16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::VerifyDebug::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7991,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 7355,
   FQN="clang::driver::tools::darwin::VerifyDebug::ConstructJob", NM="_ZNK5clang6driver5tools6darwin11VerifyDebug12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6darwin11VerifyDebug12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      CmdArgs.push_back($("--verify"));
      CmdArgs.push_back($("--debug-info"));
      CmdArgs.push_back($("--eh-frame"));
      CmdArgs.push_back($("--quiet"));
      assert (Inputs.size() == 1) : "Unable to handle multiple inputs.";
      /*const*/ InputInfo /*&*/ Input = Inputs.$at(0);
      assert (Input.isFilename()) : "Unexpected verify input";
      
      // Grabbing the output of the earlier dsymutil run.
      CmdArgs.push_back(Input.getFilename());
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(getToolChain().GetProgramPath($("dwarfdump")))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::darwin::VerifyDebug::~VerifyDebug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 414,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 411,
   FQN="clang::driver::tools::darwin::VerifyDebug::~VerifyDebug", NM="_ZN5clang6driver5tools6darwin11VerifyDebugD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6darwin11VerifyDebugD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class DarwinStatics
