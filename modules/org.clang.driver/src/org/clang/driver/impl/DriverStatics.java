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
package org.clang.driver.impl;

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
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.tools.impl.*;
;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.driver.impl.DriverStatics.*;
import org.clank.support.JavaDifferentiators.JD$T$C$P_T2$C$R;
import org.llvm.support.sys.Process;


//<editor-fold defaultstate="collapsed" desc="static type DriverStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.driver.impl.DriverStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=Tpl__ZL24collapseOffloadingActionRPN5clang6driver6ActionE;_ZL12MakeInputArgRN4llvm3opt14DerivedArgListEPNS0_8OptTableENS_9StringRefE;_ZL12printArgListRN4llvm11raw_ostreamERKNS_3opt7ArgListE;_ZL13PrintActions1RKN5clang6driver11CompilationEPNS0_6ActionERSt3mapIS5_jSt4lessIS5_ESaISt4pairIKS5_jEEE;_ZL16buildCudaActionsRN5clang6driver11CompilationERN4llvm3opt14DerivedArgListEPKNS4_3ArgEPNS0_6ActionERNS3_11SmallVectorISB_Lj3EEE;_ZL16selectToolForJobRN5clang6driver11CompilationEbbPKNS0_9ToolChainEPKNS0_9JobActionERPKN4llvm11SmallVectorIPNS0_6ActionELj3EEERSD_;_ZL19computeTargetTripleRKN5clang6driver6DriverEN4llvm9StringRefERKNS4_3opt7ArgListES5_;_ZL20MakeCLOutputFilenameRKN4llvm3opt7ArgListENS_9StringRefES4_N5clang6driver5types2IDE;_ZL20ScanDirForExecutableRN4llvm11SmallStringILj128EEENS_8ArrayRefINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEEE;_ZL22DiagnoseInputExistenceRKN5clang6driver6DriverERKN4llvm3opt14DerivedArgListENS4_9StringRefENS0_5types2IDE;_ZL25PrintDiagnosticCategoriesRN4llvm11raw_ostreamE;_ZL31ContainsCompileOrAssembleActionPKN5clang6driver6ActionE; -static-type=DriverStatics -package=org.clang.driver.impl")
//</editor-fold>
public final class DriverStatics {

//<editor-fold defaultstate="collapsed" desc="MakeInputArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 203,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 199,
 FQN="MakeInputArg", NM="_ZL12MakeInputArgRN4llvm3opt14DerivedArgListEPNS0_8OptTableENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZL12MakeInputArgRN4llvm3opt14DerivedArgListEPNS0_8OptTableENS_9StringRefE")
//</editor-fold>
public static Arg /*P*/ MakeInputArg(final DerivedArgList /*&*/ Args, OptTable /*P*/ Opts, 
            StringRef Value) {
  Arg /*P*/ A = new Arg(Opts.getOption(new OptSpecifier(options.ID.OPT_INPUT.getValue())), /*NO_COPY*/Value, 
      Args.getBaseArgs().MakeIndex(/*NO_COPY*/Value), Value.data());
  Args.AddSynthesizedArg(A);
  A.claim();
  return A;
}


/// \brief Compute target triple from args.
///
/// This routine provides the logic to compute a target triple from various
/// args passed to the driver and the default triple string.
//<editor-fold defaultstate="collapsed" desc="computeTargetTriple">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 305,
 FQN="computeTargetTriple", NM="_ZL19computeTargetTripleRKN5clang6driver6DriverEN4llvm9StringRefERKNS4_3opt7ArgListES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZL19computeTargetTripleRKN5clang6driver6DriverEN4llvm9StringRefERKNS4_3opt7ArgListES5_")
//</editor-fold>
public static Triple computeTargetTriple(final /*const*/ Driver /*&*/ D, 
                   StringRef DefaultTargetTriple, 
                   final /*const*/ ArgList /*&*/ Args) {
  return computeTargetTriple(D, 
                   DefaultTargetTriple, 
                   Args, 
                   new StringRef(/*KEEP_STR*/$EMPTY));
}
public static Triple computeTargetTriple(final /*const*/ Driver /*&*/ D, 
                   StringRef DefaultTargetTriple, 
                   final /*const*/ ArgList /*&*/ Args, 
                   StringRef DarwinArchName/*= ""*/) {
  {
    // FIXME: Already done in Compilation *Driver::BuildCompilation
    /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_target.getValue()));
    if ((A != null)) {
      DefaultTargetTriple.$assignMove(/*STRINGREF_STR*/A.getValue());
    }
  }
  
  Triple Target/*J*/= new Triple(new Twine(Triple.normalize(new StringRef(DefaultTargetTriple))));
  
  // Handle Apple-specific options available here.
  if (Target.isOSBinFormatMachO()) {
    // If an explict Darwin arch name is given, that trumps all.
    if (!DarwinArchName.empty()) {
      DarwinStatics.setTripleTypeForMachOArchName(Target, new StringRef(DarwinArchName));
      return Target;
    }
    {
      
      // Handle the Darwin '-arch' flag.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_arch.getValue()));
      if ((A != null)) {
        StringRef ArchName = new StringRef(A.getValue());
        DarwinStatics.setTripleTypeForMachOArchName(Target, new StringRef(ArchName));
      }
    }
  }
  {
    
    // Handle pseudo-target flags '-mlittle-endian'/'-EL' and
    // '-mbig-endian'/'-EB'.
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mlittle_endian.getValue()), 
        new OptSpecifier(options.ID.OPT_mbig_endian.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mlittle_endian.getValue()))) {
        Triple LE = Target.getLittleEndianArchVariant();
        if (LE.getArch() != Triple.ArchType.UnknownArch) {
          Target.$assignMove(std.move(LE));
        }
      } else {
        Triple BE = Target.getBigEndianArchVariant();
        if (BE.getArch() != Triple.ArchType.UnknownArch) {
          Target.$assignMove(std.move(BE));
        }
      }
    }
  }
  
  // Skip further flag support on OSes which don't support '-m32' or '-m64'.
  if (Target.getArch() == Triple.ArchType.tce
     || Target.getOS() == Triple.OSType.Minix) {
    return Target;
  }
  
  // Handle pseudo-target flags '-m64', '-mx32', '-m32' and '-m16'.
  Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_m64.getValue()), new OptSpecifier(options.ID.OPT_mx32.getValue()), 
      new OptSpecifier(options.ID.OPT_m32.getValue()), new OptSpecifier(options.ID.OPT_m16.getValue()));
  if ((A != null)) {
    Triple.ArchType AT = Triple.ArchType.UnknownArch;
    if (A.getOption().matches(new OptSpecifier(options.ID.OPT_m64.getValue()))) {
      AT = Target.get64BitArchVariant().getArch();
      if (Target.getEnvironment() == Triple.EnvironmentType.GNUX32) {
        Target.setEnvironment(Triple.EnvironmentType.GNU);
      }
    } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mx32.getValue()))
       && Target.get64BitArchVariant().getArch() == Triple.ArchType.x86_64) {
      AT = Triple.ArchType.x86_64;
      Target.setEnvironment(Triple.EnvironmentType.GNUX32);
    } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_m32.getValue()))) {
      AT = Target.get32BitArchVariant().getArch();
      if (Target.getEnvironment() == Triple.EnvironmentType.GNUX32) {
        Target.setEnvironment(Triple.EnvironmentType.GNU);
      }
    } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_m16.getValue()))
       && Target.get32BitArchVariant().getArch() == Triple.ArchType.x86) {
      AT = Triple.ArchType.x86;
      Target.setEnvironment(Triple.EnvironmentType.CODE16);
    }
    if (AT != Triple.ArchType.UnknownArch && AT != Target.getArch()) {
      Target.setArch(AT);
    }
  }
  
  // Handle -miamcu flag.
  if (Args.hasFlag(new OptSpecifier(options.ID.OPT_miamcu.getValue()), new OptSpecifier(options.ID.OPT_mno_iamcu.getValue()), false)) {
    if (Target.get32BitArchVariant().getArch() != Triple.ArchType.x86) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_unsupported_opt_for_target)), /*KEEP_STR*/"-miamcu"), 
            new StringRef(Target.str())));
      } finally {
        $c$.$destroy();
      }
    }
    if ((A != null) && !A.getOption().matches(new OptSpecifier(options.ID.OPT_m32.getValue()))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
                /*KEEP_STR*/"-miamcu"), new StringRef(A.getBaseArg().getAsString(Args))));
      } finally {
        $c$.$destroy();
      }
    }
    
    Target.setArch(Triple.ArchType.x86);
    Target.setArchName(new StringRef(/*KEEP_STR*/"i586"));
    Target.setEnvironment(Triple.EnvironmentType.UnknownEnvironment);
    Target.setEnvironmentName(new StringRef(/*KEEP_STR*/$EMPTY));
    Target.setOS(Triple.OSType.ELFIAMCU);
    Target.setVendor(Triple.VendorType.UnknownVendor);
    Target.setVendorName(new StringRef(/*KEEP_STR*/"intel"));
  }
  
  return Target;
}

//<editor-fold defaultstate="collapsed" desc="printArgList">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 600,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 524,
 FQN="printArgList", NM="_ZL12printArgListRN4llvm11raw_ostreamERKNS_3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZL12printArgListRN4llvm11raw_ostreamERKNS_3opt7ArgListE")
//</editor-fold>
public static void printArgList(final raw_ostream /*&*/ OS, final /*const*/ ArgList /*&*/ Args) {
  ArgStringList ASL/*J*/= new ArgStringList(16);
  for (/*const*/ Arg /*P*/ A : Args)  {
    A.render(Args, ASL);
  }
  
  for (/*const*/type$ptr<char$ptr> /*char PP*/ I = $tryClone(ASL.begin()), /*P*/ /*P*/ E = $tryClone(ASL.end()); $noteq_ptr(I, E); I.$preInc()) {
    if ($noteq_ptr(I, ASL.begin())) {
      OS.$out_char($$SPACE);
    }
    Command.printArg(OS, I.$star(), true);
  }
  OS.$out_char($$LF);
}


/// PrintDiagnosticCategories - Implement the --print-diagnostic-categories
/// option.
//<editor-fold defaultstate="collapsed" desc="PrintDiagnosticCategories">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 890,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 814,
 FQN="PrintDiagnosticCategories", NM="_ZL25PrintDiagnosticCategoriesRN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZL25PrintDiagnosticCategoriesRN4llvm11raw_ostreamE")
//</editor-fold>
public static void PrintDiagnosticCategories(final raw_ostream /*&*/ OS) {
  // Skip the empty category.
  for (/*uint*/int i = 1, max = DiagnosticIDs.getNumberOfCategories(); i != max;
       ++i)  {
    OS.$out_uint(i).$out_char($$COMMA).$out(DiagnosticIDs.getCategoryNameFromID(i)).$out_char($$LF);
  }
}


// Display an action graph human-readably.  Action A is the "sink" node
// and latest-occuring action. Traversal is in pre-order, visiting the
// inputs to each action before printing the action itself.
//<editor-fold defaultstate="collapsed" desc="PrintActions1">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION/*fixes for use in lambda*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 1013,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 937,
 FQN="PrintActions1", NM="_ZL13PrintActions1RKN5clang6driver11CompilationEPNS0_6ActionERSt3mapIS5_jSt4lessIS5_ESaISt4pairIKS5_jEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZL13PrintActions1RKN5clang6driver11CompilationEPNS0_6ActionERSt3mapIS5_jSt4lessIS5_ESaISt4pairIKS5_jEEE")
//</editor-fold>
public static /*uint*/int PrintActions1(/*const*/ Compilation /*&*/ C, Action /*P*/ A, 
             final std.mapPtrUInt<Action /*P*/>/*&*/ Ids) {
  if ((Ids.count(A))) { // A was already visited.
    return Ids.$at(A);
  }

  std.string str/*J*/= new std.string();
  // JAVA: fix for use in lamda
  raw_string_ostream os/*J*/= new raw_string_ostream(str);
  try {
    os.$out(Action.getClassName(A.getKind())).$out(/*KEEP_STR*/$COMMA_SPACE);
    {
      InputAction /*P*/ IA = dyn_cast(InputAction.class, A);
      if ((IA != null)) {
        os.$out(/*KEEP_STR*/$DBL_QUOTE).$out(IA.getInputArg().getValue()).$out(/*KEEP_STR*/$DBL_QUOTE);
      } else {
        BindArchAction /*P*/ BIA = dyn_cast(BindArchAction.class, A);
        if ((BIA != null)) {
          os.$out_char($$DBL_QUOTE).$out(BIA.getArchName()).$out_char($$DBL_QUOTE).$out(/*KEEP_STR*/", {").$out_uint(
                  PrintActions1(C, BIA.input_begin().$star(), Ids)
          ).$out(/*KEEP_STR*/$RCURLY);
        } else {
          OffloadAction /*P*/ OA = dyn_cast(OffloadAction.class, A);
          if ((OA != null)) {
            // JAVA: fix for use in lamda
            final boolean IsFirst[] = new boolean[] {true};
            OA.doOnEachDependence(/*FuncArg*//*[&, &IsFirst, &os, &C, &Ids]*/ (Action /*P*/ A$1, /*const*/ ToolChain /*P*/ TC, /*const*/char$ptr/*char P*/ BoundArch) -> {
                        // E.g. for two CUDA device dependences whose bound arch is sm_20 and
                        // sm_35 this will generate:
                        // "cuda-device" (nvptx64-nvidia-cuda:sm_20) {#ID}, "cuda-device"
                        // (nvptx64-nvidia-cuda:sm_35) {#ID}
                      if (!IsFirst[0]) {
                        os.$out(/*KEEP_STR*/$COMMA_SPACE);
                      }
                      os.$out_char($$DBL_QUOTE);
                      if ((TC != null)) {
                        os.$out(A$1.getOffloadingKindPrefix());
                      } else {
                        os.$out(/*KEEP_STR*/"host");
                      }
                      os.$out(/*KEEP_STR*/" (");
                      os.$out(TC.getTriple().normalize());
                      if ((BoundArch != null)) {
                        os.$out(/*KEEP_STR*/$COLON).$out(BoundArch);
                      }
                      os.$out(/*KEEP_STR*/$RPAREN);
                      os.$out_char($$DBL_QUOTE);
                      os.$out(/*KEEP_STR*/" {").$out_uint(PrintActions1(C, A$1, Ids)).$out(/*KEEP_STR*/$RCURLY);
                      IsFirst[0] = false;
                    });
          } else {
            /*const*//*ActionList*/SmallVector<Action /*P*/>/*P*/ AL = $AddrOf(A.getInputs());
            if ((AL.size() != 0)) {
              /*const*/char$ptr/*char P*/ Prefix = $LCURLY;
              for (Action /*P*/ PreRequisite : $Deref(AL)) {
                os.$out(Prefix).$out_uint(PrintActions1(C, PreRequisite, Ids));
                Prefix = $COMMA_SPACE;
              }
              os.$out(/*KEEP_STR*/$RCURLY);
            } else {
              os.$out(/*KEEP_STR*/"{}");
            }
          }
        }
      }
    }
    
    // Append offload info for all options other than the offloading action
    // itself (e.g. (cuda-device, sm_20) or (cuda-host)).
    std.string offload_str/*J*/= new std.string();
    // JAVA: fix for use in lamda
    raw_string_ostream offload_os/*J*/= new raw_string_ostream(offload_str);
    try {
      if (!isa(OffloadAction.class, A)) {
        std.string S = A.getOffloadingKindPrefix();
        if (!S.empty()) {
          offload_os.$out(/*KEEP_STR*/", (").$out(S);
          if ((A.getOffloadingArch() != null)) {
            offload_os.$out(/*KEEP_STR*/$COMMA_SPACE).$out(A.getOffloadingArch());
          }
          offload_os.$out(/*KEEP_STR*/$RPAREN);
        }
      }

      /*uint*/int Id = Ids.size();
      Ids.$set(A, Id);
      llvm.errs().$out_uint(Id).$out(/*KEEP_STR*/": ").$out(os.str()).$out(/*KEEP_STR*/$COMMA_SPACE).$out(
              types.getTypeName(A.getType())
      ).$out(offload_os.str()).$out(/*KEEP_STR*/$LF);

      return Id;
    } finally {
      offload_os.$destroy();
    }
  } finally {
    os.$destroy();
  }
}


/// \brief Check whether the given input tree contains any compilation or
/// assembly actions.
//<editor-fold defaultstate="collapsed" desc="ContainsCompileOrAssembleAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 1098,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 992,
 FQN="ContainsCompileOrAssembleAction", NM="_ZL31ContainsCompileOrAssembleActionPKN5clang6driver6ActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZL31ContainsCompileOrAssembleActionPKN5clang6driver6ActionE")
//</editor-fold>
public static boolean ContainsCompileOrAssembleAction(/*const*/Action/*P*/ A) {
  if (isa(CompileJobAction.class, A) || isa(BackendJobAction.class, A)
     || isa(AssembleJobAction.class, A)) {
    return true;
  }
  
  for (/*const*/ Action /*P*/ Input : A.inputs$Const())  {
    if (ContainsCompileOrAssembleAction(Input)) {
      return true;
    }
  }
  
  return false;
}


/// \brief Check that the file referenced by Value exists. If it doesn't,
/// issue a diagnostic and return false.
//<editor-fold defaultstate="collapsed" desc="DiagnoseInputExistence">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 1199,
 FQN="DiagnoseInputExistence", NM="_ZL22DiagnoseInputExistenceRKN5clang6driver6DriverERKN4llvm3opt14DerivedArgListENS4_9StringRefENS0_5types2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZL22DiagnoseInputExistenceRKN5clang6driver6DriverERKN4llvm3opt14DerivedArgListENS4_9StringRefENS0_5types2IDE")
//</editor-fold>
public static boolean DiagnoseInputExistence(final /*const*/ Driver /*&*/ D, final /*const*/ DerivedArgList /*&*/ Args, 
                      StringRef Value, types.ID Ty) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!D.getCheckInputsExist()) {
      return true;
    }
    
    // stdin always exists.
    if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"-")) {
      return true;
    }
    
    SmallString/*<64>*/ Path/*J*/= new SmallString/*<64>*/(64, new StringRef(Value));
    {
      Arg /*P*/ WorkDir = Args.getLastArg(new OptSpecifier(options.ID.OPT_working_directory.getValue()));
      if ((WorkDir != null)) {
        if (!path.is_absolute(new Twine(Path))) {
          SmallString/*<64>*/ Directory/*J*/= new SmallString/*<64>*/(64, new StringRef(WorkDir.getValue()));
          path.append(Directory, new Twine(Value));
          Path.assign(Directory);
        }
      }
    }
    if (fs.exists(new Twine(Path))) {
      return true;
    }
    if (D.IsCLMode()) {
      if (!path.is_absolute(new Twine(Path))
         && Process.FindInEnvPath(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"LIB"), Value.$string()).$bool()) {
        return true;
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_link.getValue())) && Ty == types.ID.TY_Object) {
        // Arguments to the /link flag might cause the linker to search for object
        // and library files in paths we don't know about. Don't error in such
        // cases.
        return true;
      }
    }
    
    $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_no_such_file)), Path.$StringRef()));
    return false;
  } finally {
    $c$.$destroy();
  }
}


// For each unique --cuda-gpu-arch= argument creates a TY_CUDA_DEVICE
// input action and then wraps each in CudaDeviceAction paired with
// appropriate GPU arch name. In case of partial (i.e preprocessing
// only) or device-only compilation, each device action is added to /p
// Actions and /p Current is released. Otherwise the function creates
// and returns a new CudaHostAction which wraps /p Current and device
// side actions.
//<editor-fold defaultstate="collapsed" desc="buildCudaActions">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 1398,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 1283,
 FQN="buildCudaActions", NM="_ZL16buildCudaActionsRN5clang6driver11CompilationERN4llvm3opt14DerivedArgListEPKNS4_3ArgEPNS0_6ActionERNS3_11SmallVectorISB_Lj3EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZL16buildCudaActionsRN5clang6driver11CompilationERN4llvm3opt14DerivedArgListEPKNS4_3ArgEPNS0_6ActionERNS3_11SmallVectorISB_Lj3EEE")
//</editor-fold>
public static Action /*P*/ buildCudaActions(final Compilation /*&*/ C, final DerivedArgList /*&*/ Args, 
                /*const*/ Arg /*P*/ InputArg, Action /*P*/ HostAction, 
                final /*ActionList*/SmallVector<Action /*P*/>/*&*/ Actions) {
  SmallSet<CudaArch> GpuArchs = null;
  OffloadAction.DeviceDependences DDep = null;
  try {
    Arg /*P*/ PartialCompilationArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_cuda_host_only.getValue()), new OptSpecifier(options.ID.OPT_cuda_device_only.getValue()), 
        new OptSpecifier(options.ID.OPT_cuda_compile_host_device.getValue()));
    boolean CompileHostOnly = (PartialCompilationArg != null)
       && PartialCompilationArg.getOption().matches(new OptSpecifier(options.ID.OPT_cuda_host_only.getValue()));
    boolean CompileDeviceOnly = (PartialCompilationArg != null)
       && PartialCompilationArg.getOption().matches(new OptSpecifier(options.ID.OPT_cuda_device_only.getValue()));
    if (CompileHostOnly) {
      OffloadAction.HostDependence HDep/*J*/= new OffloadAction.HostDependence($Deref(HostAction), $Deref(C./*<Action.OffloadKind.OFK_Host>*/getSingleOffloadToolChain(Action.OffloadKind.OFK_Host)), 
          /*BoundArch=*/ (/*const*/char$ptr/*char P*/ )null, Action.OffloadKind.OFK_Cuda);
      return C.MakeAction(new OffloadAction(HDep));
    }
    
    // Collect all cuda_gpu_arch parameters, removing duplicates.
    SmallVector<CudaArch> GpuArchList/*J*/= new SmallVector<CudaArch>(4, null);
    GpuArchs/*J*/= new SmallSet<CudaArch>(4, CudaArch.valueOf(0), CUDA_ARCH_COMPARATOR);
    for (Arg /*P*/ A : Args) {
      if (!A.getOption().matches(new OptSpecifier(options.ID.OPT_cuda_gpu_arch_EQ.getValue()))) {
        continue;
      }
      A.claim();
      
      final /*const*/char$ptr/*char P*//*const*/ /*&*/ ArchStr = $tryClone(A.getValue());
      CudaArch Arch = StringToCudaArch(new StringRef(ArchStr));
      if (Arch == CudaArch.UNKNOWN) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(C.getDriver().Diag(diag.err_drv_cuda_bad_gpu_arch)), ArchStr));
        } finally {
          $c$.$destroy();
        }
      } else if (GpuArchs.insert(Arch)) {
        GpuArchList.push_back(Arch);
      }
    }
    
    // Default to sm_20 which is the lowest common denominator for supported GPUs.
    // sm_20 code should work correctly, if suboptimally, on all newer GPUs.
    if (GpuArchList.empty()) {
      GpuArchList.push_back(CudaArch.SM_20);
    }
    
    // Replicate inputs for each GPU architecture.
    SmallVector<std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >> CudaDeviceInputs/*J*/= new SmallVector<std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >>(16, new std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >(types.ID.TY_INVALID, null));
    for (/*uint*/int I = 0, E = GpuArchList.size(); I != E; ++I)  {
      CudaDeviceInputs.push_back(std.make_pair_E_Ptr(types.ID.TY_CUDA_DEVICE, InputArg));
    }
    
    // Build actions for all device inputs.
    /*ActionList*/SmallVector<Action /*P*/> CudaDeviceActions/*J*/= new /*ActionList*/SmallVector<Action /*P*/>(3, (Action/*P*/)null);
    C.getDriver().BuildActions(C, Args, CudaDeviceInputs, CudaDeviceActions);
    assert (GpuArchList.size() == CudaDeviceActions.size()) : "Failed to create actions for all devices";
    
    // Check whether any of device actions stopped before they could generate PTX.
    boolean PartialCompilation = llvm.any_of(CudaDeviceActions, /*[]*/ (/*const*/ Action /*P*/ a) -> {
            return a.getKind() != Action.ActionClass.AssembleJobClass;
            });
    
    /*const*/ ToolChain /*P*/ CudaTC = C./*<Action.OffloadKind.OFK_Cuda>*/getSingleOffloadToolChain(Action.OffloadKind.OFK_Cuda);
    
    // Figure out what to do with device actions -- pass them as inputs to the
    // host action or run each of them independently.
    if (PartialCompilation || CompileDeviceOnly) {
      // In case of partial or device-only compilation results of device actions
      // are not consumed by the host action device actions have to be added to
      // top-level actions list with AtTopLevel=true and run independently.
      
      // -o is ambiguous if we have more than one top-level action.
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_o.getValue()))
         && (!CompileDeviceOnly || $greater_uint(GpuArchList.size(), 1))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(C.getDriver().Diag(diag.err_drv_output_argument_with_multiple_files)));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      for (/*uint*/int I = 0, E = GpuArchList.size(); I != E; ++I) {
        OffloadAction.DeviceDependences DDep$1 = null;
        try {
          DDep$1/*J*/= new OffloadAction.DeviceDependences();
          DDep$1.add($Deref(CudaDeviceActions.$at(I)), $Deref(CudaTC), CudaArchToString(GpuArchList.$at(I)), 
              Action.OffloadKind.OFK_Cuda);
          Actions.push_back(C.MakeAction(new OffloadAction(DDep$1, CudaDeviceActions.$at(I).getType())));
        } finally {
          if (DDep$1 != null) { DDep$1.$destroy(); }
        }
      }
      // Kill host action in case of device-only compilation.
      if (CompileDeviceOnly) {
        return null;
      }
      return HostAction;
    }
    
    // If we're not a partial or device-only compilation, we compile each arch to
    // ptx and assemble to cubin, then feed the cubin *and* the ptx into a device
    // "link" action, which uses fatbinary to combine these cubins into one
    // fatbin.  The fatbin is then an input to the host compilation.
    /*ActionList*/SmallVector<Action /*P*/> DeviceActions/*J*/= new /*ActionList*/SmallVector<Action /*P*/>(3, (Action/*P*/)null);
    for (/*uint*/int I = 0, E = GpuArchList.size(); I != E; ++I) {
      Action /*P*/ AssembleAction = CudaDeviceActions.$at(I);
      assert (AssembleAction.getType() == types.ID.TY_Object);
      assert (AssembleAction.getInputs().size() == 1);
      
      Action /*P*/ BackendAction = AssembleAction.getInputs().$at(0);
      assert (BackendAction.getType() == types.ID.TY_PP_Asm);
      
      for (final Action /*P*/ /*const*/ /*&*/ A : new Action /*P*/ /*const*/ [/*2*/] {AssembleAction, BackendAction}) {
        OffloadAction.DeviceDependences DDep$1 = null;
        try {
          DDep$1/*J*/= new OffloadAction.DeviceDependences();
          DDep$1.add($Deref(A), $Deref(CudaTC), CudaArchToString(GpuArchList.$at(I)), Action.OffloadKind.OFK_Cuda);
          DeviceActions.push_back(C.MakeAction(new OffloadAction(DDep$1, A.getType())));
        } finally {
          if (DDep$1 != null) { DDep$1.$destroy(); }
        }
      }
    }
    LinkJobAction /*P*/ FatbinAction = C.MakeAction(new LinkJobAction(DeviceActions, types.ID.TY_CUDA_FATBIN));
    
    // Return a new host action that incorporates original host action and all
    // device actions.
    OffloadAction.HostDependence HDep/*J*/= new OffloadAction.HostDependence($Deref(HostAction), $Deref(C./*<Action.OffloadKind.OFK_Host>*/getSingleOffloadToolChain(Action.OffloadKind.OFK_Host)), 
        /*BoundArch=*/ (/*const*/char$ptr/*char P*/ )null, Action.OffloadKind.OFK_Cuda);
    DDep/*J*/= new OffloadAction.DeviceDependences();
    DDep.add($Deref(FatbinAction), $Deref(CudaTC), /*BoundArch=*/ (/*const*/char$ptr/*char P*/ )null, Action.OffloadKind.OFK_Cuda);
    return C.MakeAction(new OffloadAction(HDep, DDep));
  } finally {
    if (DDep != null) { DDep.$destroy(); }
    if (GpuArchs != null) { GpuArchs.$destroy(); }
  }
}

/// Collapse an offloading action looking for a job of the given type. The input
/// action is changed to the input of the collapsed sequence. If we effectively
/// had a collapse return the corresponding offloading action, otherwise return
/// null.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="collapseOffloadingAction">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 1949,
 FQN="collapseOffloadingAction", NM="Tpl__ZL24collapseOffloadingActionRPN5clang6driver6ActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=Tpl__ZL24collapseOffloadingActionRPN5clang6driver6ActionE")
//</editor-fold>
public static </*typename*/ T extends Action> OffloadAction /*P*/ collapseOffloadingAction(Class<T> clz, final type$ref<Action /*P*/ /*&*/> CurAction) {
  assert CurAction != null;
  if (!(CurAction.$deref()!= null)) {
    return null;
  }
  {
    OffloadAction /*P*/ OA = dyn_cast(OffloadAction.class, CurAction.$deref());
    if ((OA != null)) {
      if (OA.hasHostDependence()) {
        {
          T /*P*/ HDep = dyn_cast(clz, OA.getHostDependence());
          if (HDep != null) {
            CurAction.$set(HDep);
            return OA;
          }
        }
      }
      if (OA.hasSingleDeviceDependence()) {
        {
          T /*P*/ DDep = dyn_cast(clz, OA.getSingleDeviceDependence());
          if (DDep != null) {
            CurAction.$set(DDep);
            return OA;
          }
        }
      }
    }
  }
  return null;
}

// Returns a Tool for a given JobAction.  In case the action and its
// predecessors can be combined, updates Inputs with the inputs of the
// first combined action. If one of the collapsed actions is a
// CudaHostAction, updates CollapsedCHA with the pointer to it so the
// caller can deal with extra handling such action requires.
//<editor-fold defaultstate="collapsed" desc="selectToolForJob">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 1971,
 FQN="selectToolForJob", NM="_ZL16selectToolForJobRN5clang6driver11CompilationEbbPKNS0_9ToolChainEPKNS0_9JobActionERPKN4llvm11SmallVectorIPNS0_6ActionELj3EEERSD_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZL16selectToolForJobRN5clang6driver11CompilationEbbPKNS0_9ToolChainEPKNS0_9JobActionERPKN4llvm11SmallVectorIPNS0_6ActionELj3EEERSD_")
//</editor-fold>
public static /*const*/ Tool /*P*/ selectToolForJob(final Compilation /*&*/ C, boolean SaveTemps, 
                boolean EmbedBitcode, /*const*/ ToolChain /*P*/ TC, 
                /*const*/ JobAction /*P*/ JA, 
                final /*const*/type$ref</*ActionList*/SmallVector<Action /*P*/>>/*&*/ Inputs, 
                final /*ActionList*/SmallVector<Action /*P*/>/*&*/ CollapsedOffloadAction) {
  /*const*/ Tool /*P*/ ToolForJob = null;
  CollapsedOffloadAction.clear();
  
  // See if we should look for a compiler with an integrated assembler. We match
  // bottom up, so what we are actually looking for is an assembler job with a
  // compiler input.
  
  // Look through offload actions between assembler and backend actions.
  type$ref<Action /*P*/ > BackendJA = create_type$ref((isa(AssembleJobAction.class, JA) && Inputs.$deref().size() == 1) ? Inputs.$deref().begin$Const().$star() : null);
  OffloadAction /*P*/ BackendOA = collapseOffloadingAction(BackendJobAction.class, BackendJA);
  if (TC.useIntegratedAs() && !SaveTemps
     && !C.getArgs().hasArg(new OptSpecifier(options.ID.OPT_via_file_asm.getValue()))
     && !C.getArgs().hasArg(new OptSpecifier(options.ID.OPT__SLASH_FA.getValue()))
     && !C.getArgs().hasArg(new OptSpecifier(options.ID.OPT__SLASH_Fa.getValue())) && (BackendJA.$deref() != null)
     && isa(BackendJobAction.class, BackendJA.$deref())) {
    // A BackendJob is always preceded by a CompileJob, and without -save-temps
    // or -fembed-bitcode, they will always get combined together, so instead of
    // checking the backend tool, check if the tool for the CompileJob has an
    // integrated assembler. For -fembed-bitcode, CompileJob is still used to
    // look up tools for BackendJob, but they need to match before we can split
    // them.
    
    // Look through offload actions between backend and compile actions.
    type$ref<Action /*P*/ > CompileJA = create_type$ref(BackendJA.$deref().getInputs().begin().$star());
    OffloadAction /*P*/ CompileOA = collapseOffloadingAction(CompileJobAction.class, CompileJA);
    assert ((CompileJA.$deref() != null) && isa(CompileJobAction.class, CompileJA.$deref())) : "Backend job is not preceeded by compile job.";
    /*const*/ Tool /*P*/ Compiler = TC.SelectTool($Deref(cast(CompileJobAction.class, CompileJA.$deref())));
    if (!(Compiler != null)) {
      return null;
    }
    // When using -fembed-bitcode, it is required to have the same tool (clang)
    // for both CompilerJA and BackendJA. Otherwise, combine two stages.
    if (EmbedBitcode) {
      JobAction /*P*/ InputJA = cast(JobAction.class, Inputs.$deref().begin$Const().$star());
      /*const*/ Tool /*P*/ BackendTool = TC.SelectTool($Deref(InputJA));
      if (BackendTool == Compiler) {
        CompileJA.$set(InputJA);
      }
    }
    if (Compiler.hasIntegratedAssembler()) {
      Inputs.$set($AddrOf(CompileJA.$deref().getInputs()));
      ToolForJob = Compiler;
      // Save the collapsed offload actions because they may still contain
      // device actions.
      if ((CompileOA != null)) {
        CollapsedOffloadAction.push_back(CompileOA);
      }
      if ((BackendOA != null)) {
        CollapsedOffloadAction.push_back(BackendOA);
      }
    }
  }
  
  // A backend job should always be combined with the preceding compile job
  // unless OPT_save_temps or OPT_fembed_bitcode is enabled and the compiler is
  // capable of emitting LLVM IR as an intermediate output.
  if (isa(BackendJobAction.class, JA)) {
    // Check if the compiler supports emitting LLVM IR.
    assert (Inputs.$deref().size() == 1);
    
    // Look through offload actions between backend and compile actions.
    type$ref<Action /*P*/ > CompileJA = create_type$ref(JA.getInputs$Const().begin$Const().$star());
    OffloadAction /*P*/ CompileOA = collapseOffloadingAction(CompileJobAction.class, CompileJA);
    assert ((CompileJA.$deref() != null) && isa(CompileJobAction.class, CompileJA.$deref())) : "Backend job is not preceeded by compile job.";
    /*const*/ Tool /*P*/ Compiler = TC.SelectTool($Deref(cast(CompileJobAction.class, CompileJA.$deref())));
    if (!(Compiler != null)) {
      return null;
    }
    if (!Compiler.canEmitIR()
       || (!SaveTemps && !EmbedBitcode)) {
      Inputs.$set($AddrOf(CompileJA.$deref().getInputs()));
      ToolForJob = Compiler;
      if ((CompileOA != null)) {
        CollapsedOffloadAction.push_back(CompileOA);
      }
    }
  }
  
  // Otherwise use the tool for the current job.
  if (!(ToolForJob != null)) {
    ToolForJob = TC.SelectTool($Deref(JA));
  }
  
  // See if we should use an integrated preprocessor. We do so when we have
  // exactly one input, since this is the only use case we care about
  // (irrelevant since we don't support combine yet).
  
  // Look through offload actions after preprocessing.
  type$ref<Action /*P*/ > PreprocessJA = create_type$ref((Inputs.$deref().size() == 1) ? Inputs.$deref().begin$Const().$star() : null);
  OffloadAction /*P*/ PreprocessOA = collapseOffloadingAction(PreprocessJobAction.class, PreprocessJA);
  if ((PreprocessJA.$deref() != null) && isa(PreprocessJobAction.class, PreprocessJA.$deref())
     && !C.getArgs().hasArg(new OptSpecifier(options.ID.OPT_no_integrated_cpp.getValue()))
     && !C.getArgs().hasArg(new OptSpecifier(options.ID.OPT_traditional_cpp.getValue())) && !SaveTemps
     && !C.getArgs().hasArg(new OptSpecifier(options.ID.OPT_rewrite_objc.getValue()))
     && ToolForJob.hasIntegratedCPP()) {
    Inputs.$set($AddrOf(PreprocessJA.$deref().getInputs()));
    if ((PreprocessOA != null)) {
      CollapsedOffloadAction.push_back(PreprocessOA);
    }
  }
  
  return ToolForJob;
}


/// \brief Create output filename based on ArgValue, which could either be a
/// full filename, filename without extension, or a directory. If ArgValue
/// does not provide a filename, then use BaseName, and use the extension
/// suitable for FileType.
//<editor-fold defaultstate="collapsed" desc="MakeCLOutputFilename">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2285,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 1915,
 FQN="MakeCLOutputFilename", NM="_ZL20MakeCLOutputFilenameRKN4llvm3opt7ArgListENS_9StringRefES4_N5clang6driver5types2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZL20MakeCLOutputFilenameRKN4llvm3opt7ArgListENS_9StringRefES4_N5clang6driver5types2IDE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ MakeCLOutputFilename(final /*const*/ ArgList /*&*/ Args, StringRef ArgValue, 
                    StringRef BaseName, 
                    types.ID FileType) {
  SmallString/*<128>*/ Filename = new SmallString/*<128>*/(128, new StringRef(ArgValue));
  if (ArgValue.empty()) {
    // If the argument is empty, output to BaseName in the current dir.
    Filename.$assign(/*NO_COPY*/BaseName);
  } else if (path.is_separator(Filename.back())) {
    // If the argument is a directory, output to BaseName in that dir.
    path.append(Filename, new Twine(BaseName));
  }
  if (!path.has_extension(new Twine(ArgValue))) {
    // If the argument didn't provide an extension, then set it.
    /*const*/char$ptr/*char P*/ Extension = $tryClone(types.getTypeTempSuffix(FileType, true));
    if (FileType == types.ID.TY_Image
       && Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_LD.getValue()), new OptSpecifier(options.ID.OPT__SLASH_LDd.getValue()))) {
      // The output file is a dll.
      Extension = $("dll");
    }
    
    path.replace_extension(Filename, new Twine(Extension));
  }
  
  return Args.MakeArgString(new Twine(Filename.c_str()));
}

//<editor-fold defaultstate="collapsed" desc="ScanDirForExecutable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", line = 2521,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp", old_line = 2145,
 FQN="ScanDirForExecutable", NM="_ZL20ScanDirForExecutableRN4llvm11SmallStringILj128EEENS_8ArrayRefISsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZL20ScanDirForExecutableRN4llvm11SmallStringILj128EEENS_8ArrayRefISsEE")
//</editor-fold>
public static boolean ScanDirForExecutable(final SmallString/*<128>*/ /*&*/ Dir, 
                    ArrayRef<std.string> Names) {
  for (final /*const*/std.string/*&*/ Name : Names) {
    path.append(Dir, new Twine(Name));
    if (fs.can_execute(new Twine(Dir))) {
      return true;
    }
    path.remove_filename(Dir);
  }
  return false;
}

} // END OF class DriverStatics
