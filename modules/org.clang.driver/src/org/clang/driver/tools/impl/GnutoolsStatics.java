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
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.clang.driver.tools.impl.*;
import org.clang.driver.toolchains.impl.*;;
import org.llvm.support.sys.*;;
import static org.clang.driver.impl.ToolsStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type GnutoolsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools8gnutools6LinkerE;_ZN5clang6driver5tools8gnutools9AssemblerE; -static-type=GnutoolsStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class GnutoolsStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gnutools::Assembler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 546,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 543,
 FQN="clang::driver::tools::gnutools::Assembler", NM="_ZN5clang6driver5tools8gnutools9AssemblerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools8gnutools9AssemblerE")
//</editor-fold>
public static class Assembler extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gnutools::Assembler::Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 548,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 545,
   FQN="clang::driver::tools::gnutools::Assembler::Assembler", NM="_ZN5clang6driver5tools8gnutools9AssemblerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools8gnutools9AssemblerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Assembler(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("GNU::Assembler", "assembler", TC)*/ 
    //START JInit
    super($("GNU::Assembler"), $("assembler"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gnutools::Assembler::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 550,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 547,
   FQN="clang::driver::tools::gnutools::Assembler::hasIntegratedCPP", NM="_ZNK5clang6driver5tools8gnutools9Assembler16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools8gnutools9Assembler16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gnutools::Assembler::ConstructJob">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 9011,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 8374,
   FQN="clang::driver::tools::gnutools::Assembler::ConstructJob", NM="_ZNK5clang6driver5tools8gnutools9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools8gnutools9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      claimNoWarnArgs(Args);
      
      std.string TripleStr = getToolChain().ComputeEffectiveClangTriple(Args);
      Triple _Triple = new Triple(new Twine(TripleStr));
      
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      
      Reloc.Model RelocationModel;
      /*uint*/int PICLevel;
      boolean IsPIE;
//      std.tie(RelocationModel, PICLevel, IsPIE).$assign(ParsePICArgs(getToolChain(), Triple, Args));
      tuple ParsedPICArgs = ParsePICArgs(getToolChain(), _Triple, Args);
      RelocationModel = (Reloc.Model) ParsedPICArgs.$getAt(0);
      PICLevel = (int) ParsedPICArgs.$getAt(1);
      IsPIE = (boolean) ParsedPICArgs.$getAt(2);      
      switch (getToolChain().getArch()) {
       default:
        break;
       case x86:
        // Add --32/--64 to make sure we get the format we want.
        // This is incomplete
        CmdArgs.push_back($("--32"));
        break;
       case x86_64:
        if (getToolChain().getTriple().getEnvironment() == Triple.EnvironmentType.GNUX32) {
          CmdArgs.push_back($("--x32"));
        } else {
          CmdArgs.push_back($("--64"));
        }
        break;
       case ppc:
        CmdArgs.push_back($("-a32"));
        CmdArgs.push_back($("-mppc"));
        CmdArgs.push_back($("-many"));
        break;
       case ppc64:
        CmdArgs.push_back($("-a64"));
        CmdArgs.push_back($("-mppc64"));
        CmdArgs.push_back($("-many"));
        break;
       case ppc64le:
        CmdArgs.push_back($("-a64"));
        CmdArgs.push_back($("-mppc64"));
        CmdArgs.push_back($("-many"));
        CmdArgs.push_back($("-mlittle-endian"));
        break;
       case sparc:
       case sparcel:
        {
          CmdArgs.push_back($("-32"));
          std.string CPU = getCPUName(Args, getToolChain().getTriple());
          CmdArgs.push_back(getSparcAsmModeForCPU(new StringRef(CPU), getToolChain().getTriple()));
          AddAssemblerKPIC(getToolChain(), Args, CmdArgs);
          break;
        }
       case sparcv9:
        {
          CmdArgs.push_back($("-64"));
          std.string CPU = getCPUName(Args, getToolChain().getTriple());
          CmdArgs.push_back(getSparcAsmModeForCPU(new StringRef(CPU), getToolChain().getTriple()));
          AddAssemblerKPIC(getToolChain(), Args, CmdArgs);
          break;
        }
       case arm:
       case armeb:
       case thumb:
       case thumbeb:
        {
          /*const*/ Triple /*&*/ Triple2 = getToolChain().getTriple();
          switch (Triple2.getSubArch()) {
           case ARMSubArch_v7:
            CmdArgs.push_back($("-mfpu=neon"));
            break;
           case ARMSubArch_v8:
            CmdArgs.push_back($("-mfpu=crypto-neon-fp-armv8"));
            break;
           default:
            break;
          }
          switch (ArmStatics.getARMFloatABI(getToolChain(), Args)) {
           case Invalid:
            throw new llvm_unreachable("must have an ABI!");
           case Soft:
            CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-mfloat-abi=soft")));
            break;
           case SoftFP:
            CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-mfloat-abi=softfp")));
            break;
           case Hard:
            CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-mfloat-abi=hard")));
            break;
          }
          
          Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_march_EQ.getValue()));
          
          // FIXME: remove krait check when GNU tools support krait cpu
          // for now replace it with -mcpu=cortex-a15 to avoid a lower
          // march from being picked in the absence of a cpu flag.
          Arg /*P*/ A;
          if (((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()))) != null)
             && $eq_string$C_T(new StringRef(A.getValue()).lower(), /*KEEP_STR*/"krait")) {
            CmdArgs.push_back($("-mcpu=cortex-a15"));
          } else {
            Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()));
          }
          Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_mfpu_EQ.getValue()));
          break;
        }
       case mips:
       case mipsel:
       case mips64:
       case mips64el:
        {
          StringRef CPUName/*J*/= new StringRef();
          StringRef ABIName/*J*/= new StringRef();
          MipsStatics.getMipsCPUAndABI(Args, getToolChain().getTriple(), CPUName, ABIName);
          ABIName.$assignMove(getGnuCompatibleMipsABIName(/*NO_COPY*/ABIName));
          
          CmdArgs.push_back($("-march"));
          CmdArgs.push_back(CPUName.data());
          
          CmdArgs.push_back($("-mabi"));
          CmdArgs.push_back(ABIName.data());
          
          // -mno-shared should be emitted unless -fpic, -fpie, -fPIC, -fPIE,
          // or -mshared (not implemented) is in effect.
          if (RelocationModel == Reloc.Model.Static) {
            CmdArgs.push_back($("-mno-shared"));
          }
          
          // LLVM doesn't support -mplt yet and acts as if it is always given.
          // However, -mplt has no effect with the N64 ABI.
          CmdArgs.push_back($eq_StringRef(/*NO_COPY*/ABIName, /*STRINGREF_STR*/"64") ? $("-KPIC") : $("-call_nonpic"));
          if (getToolChain().getArch() == Triple.ArchType.mips
             || getToolChain().getArch() == Triple.ArchType.mips64) {
            CmdArgs.push_back($("-EB"));
          } else {
            CmdArgs.push_back($("-EL"));
          }
          {
            
            Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mnan_EQ.getValue()));
            if ((A != null)) {
              if ($eq_StringRef(/*STRINGREF_STR*/A.getValue(), /*STRINGREF_STR*/"2008")) {
                CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-mnan=2008")));
              }
            }
          }
          {
            
            // Add the last -mfp32/-mfpxx/-mfp64 or -mfpxx if it is enabled by default.
            Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mfp32.getValue()), new OptSpecifier(options.ID.OPT_mfpxx.getValue()), 
                new OptSpecifier(options.ID.OPT_mfp64.getValue()));
            if ((A != null)) {
              A.claim();
              A.render(Args, CmdArgs);
            } else if (MipsStatics.shouldUseFPXX(Args, getToolChain().getTriple(), new StringRef(CPUName), new StringRef(ABIName), 
                getMipsFloatABI(getToolChain().getDriver(), Args))) {
              CmdArgs.push_back($("-mfpxx"));
            }
          }
          {
            
            // Pass on -mmips16 or -mno-mips16. However, the assembler equivalent of
            // -mno-mips16 is actually -no-mips16.
            Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mips16.getValue()), new OptSpecifier(options.ID.OPT_mno_mips16.getValue()));
            if ((A != null)) {
              if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mips16.getValue()))) {
                A.claim();
                A.render(Args, CmdArgs);
              } else {
                A.claim();
                CmdArgs.push_back($("-no-mips16"));
              }
            }
          }
          
          Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_mmicromips.getValue()), 
              new OptSpecifier(options.ID.OPT_mno_micromips.getValue()));
          Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_mdsp.getValue()), new OptSpecifier(options.ID.OPT_mno_dsp.getValue()));
          Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_mdspr2.getValue()), new OptSpecifier(options.ID.OPT_mno_dspr2.getValue()));
          {
            
            Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mmsa.getValue()), new OptSpecifier(options.ID.OPT_mno_msa.getValue()));
            if ((A != null)) {
              // Do not use AddLastArg because not all versions of MIPS assembler
              // support -mmsa / -mno-msa options.
              if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mmsa.getValue()))) {
                CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-mmsa")));
              }
            }
          }
          
          Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_mhard_float.getValue()), 
              new OptSpecifier(options.ID.OPT_msoft_float.getValue()));
          
          Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_mdouble_float.getValue()), 
              new OptSpecifier(options.ID.OPT_msingle_float.getValue()));
          
          Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_modd_spreg.getValue()), 
              new OptSpecifier(options.ID.OPT_mno_odd_spreg.getValue()));
          
          AddAssemblerKPIC(getToolChain(), Args, CmdArgs);
          break;
        }
       case systemz:
        {
          // Always pass an -march option, since our default of z10 is later
          // than the GNU assembler's default.
          StringRef CPUName = new StringRef(getSystemZTargetCPU(Args));
          CmdArgs.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/"-march=", CPUName)));
          break;
        }
      }
      
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_I.getValue()));
      Args.AddAllArgValues(CmdArgs, new OptSpecifier(options.ID.OPT_Wa_COMMA.getValue()), new OptSpecifier(options.ID.OPT_Xassembler.getValue()));
      
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
      
      for (/*const*/ InputInfo /*&*/ II : Inputs)  {
        CmdArgs.push_back(II.getFilename());
      }
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(getToolChain().GetProgramPath($("as")))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
      
      // Handle the debug info splitting at object creation time if we're
      // creating an object.
      // TODO: Currently only works on linux with newer objcopy.
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_gsplit_dwarf.getValue()))
         && getToolChain().getTriple().isOSLinux()) {
        SplitDebugInfo(getToolChain(), C, /*Deref*/this, JA, Args, Output, 
            SplitDebugName(Args, Inputs.$at(0)));
      }
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gnutools::Assembler::~Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 546,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 543,
   FQN="clang::driver::tools::gnutools::Assembler::~Assembler", NM="_ZN5clang6driver5tools8gnutools9AssemblerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools8gnutools9AssemblerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gnutools::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 558,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 555,
 FQN="clang::driver::tools::gnutools::Linker", NM="_ZN5clang6driver5tools8gnutools6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools8gnutools6LinkerE")
//</editor-fold>
public static class Linker extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gnutools::Linker::Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 560,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 557,
   FQN="clang::driver::tools::gnutools::Linker::Linker", NM="_ZN5clang6driver5tools8gnutools6LinkerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools8gnutools6LinkerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Linker(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("GNU::Linker", "linker", TC)*/ 
    //START JInit
    super($("GNU::Linker"), $("linker"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gnutools::Linker::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 562,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 559,
   FQN="clang::driver::tools::gnutools::Linker::hasIntegratedCPP", NM="_ZNK5clang6driver5tools8gnutools6Linker16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools8gnutools6Linker16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gnutools::Linker::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 563,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 560,
   FQN="clang::driver::tools::gnutools::Linker::isLinkJob", NM="_ZNK5clang6driver5tools8gnutools6Linker9isLinkJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools8gnutools6Linker9isLinkJobEv")
  //</editor-fold>
  @Override public boolean isLinkJob() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gnutools::Linker::ConstructJob">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 9345,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 8762,
   FQN="clang::driver::tools::gnutools::Linker::ConstructJob", NM="_ZNK5clang6driver5tools8gnutools6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools8gnutools6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ Linux /*&*/ ToolChain = ((/*static_cast*//*const*/ Linux /*&*/ )(getToolChain()));
      /*const*/ Driver /*&*/ D = ToolChain.getDriver();
      
      std.string TripleStr = getToolChain().ComputeEffectiveClangTriple(Args);
      Triple _Triple = new Triple(new Twine(TripleStr));
      
      /*const*/ Triple.ArchType Arch = ToolChain.getArch();
      /*const*/boolean isAndroid = ToolChain.getTriple().isAndroid();
      /*const*/boolean IsIAMCU = ToolChain.getTriple().isOSIAMCU();
      /*const*/boolean IsPIE = !Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue())) && !Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))
         && (Args.hasArg(new OptSpecifier(options.ID.OPT_pie.getValue())) || ToolChain.isPIEDefault());
      /*const*/boolean HasCRTBeginEndFiles = ToolChain.getTriple().hasEnvironment()
         || (ToolChain.getTriple().getVendor() != Triple.VendorType.MipsTechnologies);
      
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      
      // Silence warning for "clang -g foo.o -o foo"
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_g_Group.getValue()));
      // and "clang -emit-llvm foo.o -o foo"
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_emit_llvm.getValue()));
      // and for "clang -w foo.o -o foo". Other warning options are already
      // handled somewhere else.
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_w.getValue()));
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(ToolChain.GetLinkerPath())));
      if ($eq_StringRef(path.filename(new StringRef(Exec)), /*STRINGREF_STR*/"lld")) {
        CmdArgs.push_back($("-flavor"));
        CmdArgs.push_back($("old-gnu"));
        CmdArgs.push_back($("-target"));
        CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().getTripleString())));
      }
      if (!D.SysRoot.empty()) {
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string$C(/*KEEP_STR*/"--sysroot=", D.SysRoot))));
      }
      if (IsPIE) {
        CmdArgs.push_back($("-pie"));
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_rdynamic.getValue()))) {
        CmdArgs.push_back($("-export-dynamic"));
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_s.getValue()))) {
        CmdArgs.push_back($("-s"));
      }
      if (Arch == Triple.ArchType.armeb || Arch == Triple.ArchType.thumbeb) {
        ArmStatics.appendEBLinkFlags(Args, CmdArgs, _Triple);
      }
      
      for (/*const*/std.string/*&*/ Opt : ToolChain.ExtraOpts)  {
        CmdArgs.push_back(Opt.c_str());
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
        CmdArgs.push_back($("--eh-frame-hdr"));
      }
      
      CmdArgs.push_back($("-m"));
      CmdArgs.push_back(getLDMOption(ToolChain.getTriple(), Args));
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
        if (Arch == Triple.ArchType.arm || Arch == Triple.ArchType.armeb
           || Arch == Triple.ArchType.thumb || Arch == Triple.ArchType.thumbeb) {
          CmdArgs.push_back($("-Bstatic"));
        } else {
          CmdArgs.push_back($("-static"));
        }
      } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
        CmdArgs.push_back($("-shared"));
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_rdynamic.getValue()))) {
          CmdArgs.push_back($("-export-dynamic"));
        }
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
          /*const*/std.string Loader = $add_string$C_string(D.DyldPrefix, ToolChain.getDynamicLinker(Args));
          CmdArgs.push_back($("-dynamic-linker"));
          CmdArgs.push_back(Args.MakeArgString(new Twine(Loader)));
        }
      }
      
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
        if (!isAndroid && !IsIAMCU) {
          /*const*/char$ptr/*char P*/ crt1 = null;
          if (!Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
            if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
              crt1 = $tryClone($("gcrt1.o"));
            } else if (IsPIE) {
              crt1 = $tryClone($("Scrt1.o"));
            } else {
              crt1 = $tryClone($("crt1.o"));
            }
          }
          if ((crt1 != null)) {
            CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath(crt1))));
          }
          
          CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath($("crti.o")))));
        }
        if (IsIAMCU) {
          CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath($("crt0.o")))));
        } else {
          /*const*/char$ptr/*char P*/ crtbegin;
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
            crtbegin = $tryClone(isAndroid ? $("crtbegin_static.o") : $("crtbeginT.o"));
          } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
            crtbegin = $tryClone(isAndroid ? $("crtbegin_so.o") : $("crtbeginS.o"));
          } else if (IsPIE) {
            crtbegin = $tryClone(isAndroid ? $("crtbegin_dynamic.o") : $("crtbeginS.o"));
          } else {
            crtbegin = $tryClone(isAndroid ? $("crtbegin_dynamic.o") : $("crtbegin.o"));
          }
          if (HasCRTBeginEndFiles) {
            CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath(crtbegin))));
          }
        }
        
        // Add crtfastmath.o if available and fast math is enabled.
        ToolChain.AddFastMathRuntimeIfAvailable(Args, CmdArgs);
      }
      
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_L.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_u.getValue()));
      
      ToolChain.AddFilePathLibArgs(Args, CmdArgs);
      if (D.isUsingLTO()) {
        AddGoldPlugin(ToolChain, Args, CmdArgs, D.getLTOMode() == LTOKind.LTOK_Thin);
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_Z_Xlinker__no_demangle.getValue()))) {
        CmdArgs.push_back($("--no-demangle"));
      }
      
      boolean NeedsSanitizerDeps = addSanitizerRuntimes(ToolChain, Args, CmdArgs);
      boolean NeedsXRayDeps = addXRayRuntime(ToolChain, Args, CmdArgs);
      AddLinkerInputs(ToolChain, Inputs, Args, CmdArgs);
      // The profile runtime also needs access to system libraries.
      getToolChain().addProfileRTLibs(Args, CmdArgs);
      if (D.CCCIsCXX()
         && !Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
        boolean OnlyLibstdcxxStatic = Args.hasArg(new OptSpecifier(options.ID.OPT_static_libstdcxx.getValue()))
           && !Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()));
        if (OnlyLibstdcxxStatic) {
          CmdArgs.push_back($("-Bstatic"));
        }
        ToolChain.AddCXXStdlibLibArgs(Args, CmdArgs);
        if (OnlyLibstdcxxStatic) {
          CmdArgs.push_back($("-Bdynamic"));
        }
        CmdArgs.push_back($("-lm"));
      }
      // Silence warnings when linking C code with a C++ '-stdlib' argument.
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_stdlib_EQ.getValue()));
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()))) {
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
            CmdArgs.push_back($("--start-group"));
          }
          if (NeedsSanitizerDeps) {
            linkSanitizerRuntimeDeps(ToolChain, CmdArgs);
          }
          if (NeedsXRayDeps) {
            linkXRayRuntimeDeps(ToolChain, Args, CmdArgs);
          }
          
          boolean WantPthread = Args.hasArg(new OptSpecifier(options.ID.OPT_pthread.getValue()))
             || Args.hasArg(new OptSpecifier(options.ID.OPT_pthreads.getValue()));
          if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fopenmp.getValue()), new OptSpecifier(options.ID.OPT_fopenmp_EQ.getValue()), 
              new OptSpecifier(options.ID.OPT_fno_openmp.getValue()), false)) {
            // OpenMP runtimes implies pthreads when using the GNU toolchain.
            // FIXME: Does this really make sense for all GNU toolchains?
            WantPthread = true;
            
            // Also link the particular OpenMP runtimes.
            switch (getOpenMPRuntime(ToolChain, Args)) {
             case OMPRT_OMP:
              CmdArgs.push_back($("-lomp"));
              break;
             case OMPRT_GOMP:
              CmdArgs.push_back($("-lgomp"));
              
              // FIXME: Exclude this for platforms with libgomp that don't require
              // librt. Most modern Linux platforms require it, but some may not.
              CmdArgs.push_back($("-lrt"));
              break;
             case OMPRT_IOMP5:
              CmdArgs.push_back($("-liomp5"));
              break;
             case OMPRT_Unknown:
              // Already diagnosed.
              break;
            }
          }
          
          AddRunTimeLibs(ToolChain, D, CmdArgs, Args);
          if (WantPthread && !isAndroid) {
            CmdArgs.push_back($("-lpthread"));
          }
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_fsplit_stack.getValue()))) {
            CmdArgs.push_back($("--wrap=pthread_create"));
          }
          
          CmdArgs.push_back($("-lc"));
          
          // Add IAMCU specific libs, if needed.
          if (IsIAMCU) {
            CmdArgs.push_back($("-lgloss"));
          }
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
            CmdArgs.push_back($("--end-group"));
          } else {
            AddRunTimeLibs(ToolChain, D, CmdArgs, Args);
          }
          
          // Add IAMCU specific libs (outside the group), if needed.
          if (IsIAMCU) {
            CmdArgs.push_back($("--as-needed"));
            CmdArgs.push_back($("-lsoftfp"));
            CmdArgs.push_back($("--no-as-needed"));
          }
        }
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostartfiles.getValue())) && !IsIAMCU) {
          /*const*/char$ptr/*char P*/ crtend;
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
            crtend = $tryClone(isAndroid ? $("crtend_so.o") : $("crtendS.o"));
          } else if (IsPIE) {
            crtend = $tryClone(isAndroid ? $("crtend_android.o") : $("crtendS.o"));
          } else {
            crtend = $tryClone(isAndroid ? $("crtend_android.o") : $("crtend.o"));
          }
          if (HasCRTBeginEndFiles) {
            CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath(crtend))));
          }
          if (!isAndroid) {
            CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath($("crtn.o")))));
          }
        }
      }
      
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gnutools::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 558,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 555,
   FQN="clang::driver::tools::gnutools::Linker::~Linker", NM="_ZN5clang6driver5tools8gnutools6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools8gnutools6LinkerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class GnutoolsStatics
