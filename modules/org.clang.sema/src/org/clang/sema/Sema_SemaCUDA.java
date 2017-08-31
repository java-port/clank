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
package org.clang.sema;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.type$ptr;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.sema.impl.SemaCUDAStatics.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.sema.impl.SemaCUDAStatics;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaCUDA">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.sema.Sema_SemaCUDA",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaAttr ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp -nm=_ZN5clang4Sema18IdentifyCUDATargetEPKNS_12FunctionDeclE;_ZN5clang4Sema21isEmptyCudaDestructorENS_14SourceLocationEPNS_17CXXDestructorDeclE;_ZN5clang4Sema22IdentifyCUDAPreferenceEPKNS_12FunctionDeclES3_;_ZN5clang4Sema22isEmptyCudaConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclE;_ZN5clang4Sema23ActOnCUDAExecConfigExprEPNS_5ScopeENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES3_;_ZN5clang4Sema24EraseUnwantedCUDAMatchesEPKNS_12FunctionDeclERN4llvm15SmallVectorImplINS_14DeclAccessPairEEE;_ZN5clang4Sema24EraseUnwantedCUDAMatchesEPKNS_12FunctionDeclERN4llvm15SmallVectorImplIPS1_EE;_ZN5clang4Sema24EraseUnwantedCUDAMatchesEPKNS_12FunctionDeclERN4llvm15SmallVectorImplISt4pairINS_14DeclAccessPairEPS1_EEE;_ZN5clang4Sema27maybeAddCUDAHostDeviceAttrsEPNS_5ScopeEPNS_12FunctionDeclERKNS_12LookupResultE;_ZN5clang4Sema39inferCUDATargetForImplicitSpecialMemberEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEPNS_13CXXMethodDeclEbb; -static-type=Sema_SemaCUDA -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaCUDA extends Sema_SemaAttr {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCUDAExecConfigExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp", line = 26,
 FQN="clang::Sema::ActOnCUDAExecConfigExpr", NM="_ZN5clang4Sema23ActOnCUDAExecConfigExprEPNS_5ScopeENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp -nm=_ZN5clang4Sema23ActOnCUDAExecConfigExprEPNS_5ScopeENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES3_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCUDAExecConfigExpr(Scope /*P*/ S, SourceLocation LLLLoc, 
                       MutableArrayRef<Expr /*P*/ > ExecConfig, 
                       SourceLocation GGGLoc) {
  FunctionDecl /*P*/ ConfigDecl = $this().Context.getcudaConfigureCallDecl();
  if (!(ConfigDecl != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LLLLoc), diag.err_undeclared_var_use)), 
              /*KEEP_STR*/"cudaConfigureCall")));
    } finally {
      $c$.$destroy();
    }
  }
  QualType ConfigQTy = ConfigDecl.getType();
  
  DeclRefExpr /*P*/ ConfigDR = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new DeclRefExpr(ConfigDecl, false, new QualType(ConfigQTy), ExprValueKind.VK_LValue, new SourceLocation(LLLLoc));
  });
  $this().MarkFunctionReferenced(new SourceLocation(LLLLoc), ConfigDecl);
  
  return $this().ActOnCallExpr(S, ConfigDR, new SourceLocation(LLLLoc), new MutableArrayRef<Expr /*P*/ >(ExecConfig), new SourceLocation(GGGLoc), (Expr /*P*/ )null, 
      /*IsExecConfig=*/ true);
}


/// IdentifyCUDATarget - Determine the CUDA compilation target for this function
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IdentifyCUDATarget">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp", line = 44,
 FQN="clang::Sema::IdentifyCUDATarget", NM="_ZN5clang4Sema18IdentifyCUDATargetEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp -nm=_ZN5clang4Sema18IdentifyCUDATargetEPKNS_12FunctionDeclE")
//</editor-fold>
public final Sema.CUDAFunctionTarget IdentifyCUDATarget(/*const*/ FunctionDecl /*P*/ D) {
  if (D.hasAttr(CUDAInvalidTargetAttr.class)) {
    return CUDAFunctionTarget.CFT_InvalidTarget;
  }
  if (D.hasAttr(CUDAGlobalAttr.class)) {
    return CUDAFunctionTarget.CFT_Global;
  }
  if (D.hasAttr(CUDADeviceAttr.class)) {
    if (D.hasAttr(CUDAHostAttr.class)) {
      return CUDAFunctionTarget.CFT_HostDevice;
    }
    return CUDAFunctionTarget.CFT_Device;
  } else if (D.hasAttr(CUDAHostAttr.class)) {
    return CUDAFunctionTarget.CFT_Host;
  } else if (D.isImplicit()) {
    // Some implicit declarations (like intrinsic functions) are not marked.
    // Set the most lenient target on them for maximal flexibility.
    return CUDAFunctionTarget.CFT_HostDevice;
  }
  
  return CUDAFunctionTarget.CFT_Host;
}


/// Identifies relative preference of a given Caller/Callee
/// combination, based on their host/device attributes.
/// \param Caller function which needs address of \p Callee.
///               nullptr in case of global context.
/// \param Callee target function
///
/// \returns preference value for particular Caller/Callee combination.

// * CUDA Call preference table
//
// F - from,
// T - to
// Ph - preference in host mode
// Pd - preference in device mode
// H  - handled in (x)
// Preferences: N:native, SS:same side, HD:host-device, WS:wrong side, --:never.
//
// | F  | T  | Ph  | Pd  |  H  |
// |----+----+-----+-----+-----+
// | d  | d  | N   | N   | (c) |
// | d  | g  | --  | --  | (a) |
// | d  | h  | --  | --  | (e) |
// | d  | hd | HD  | HD  | (b) |
// | g  | d  | N   | N   | (c) |
// | g  | g  | --  | --  | (a) |
// | g  | h  | --  | --  | (e) |
// | g  | hd | HD  | HD  | (b) |
// | h  | d  | --  | --  | (e) |
// | h  | g  | N   | N   | (c) |
// | h  | h  | N   | N   | (c) |
// | h  | hd | HD  | HD  | (b) |
// | hd | d  | WS  | SS  | (d) |
// | hd | g  | SS  | --  |(d/a)|
// | hd | h  | SS  | WS  | (d) |
// | hd | hd | HD  | HD  | (b) |
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IdentifyCUDAPreference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp", line = 94,
 FQN="clang::Sema::IdentifyCUDAPreference", NM="_ZN5clang4Sema22IdentifyCUDAPreferenceEPKNS_12FunctionDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp -nm=_ZN5clang4Sema22IdentifyCUDAPreferenceEPKNS_12FunctionDeclES3_")
//</editor-fold>
public final Sema.CUDAFunctionPreference IdentifyCUDAPreference(/*const*/ FunctionDecl /*P*/ Caller, 
                      /*const*/ FunctionDecl /*P*/ Callee) {
  assert ((Callee != null)) : "Callee must be valid.";
  CUDAFunctionTarget CalleeTarget = $this().IdentifyCUDATarget(Callee);
  CUDAFunctionTarget CallerTarget = (Caller != null) ? $this().IdentifyCUDATarget(Caller) : Sema.CUDAFunctionTarget.CFT_Host;
  
  // If one of the targets is invalid, the check always fails, no matter what
  // the other target is.
  if (CallerTarget == CUDAFunctionTarget.CFT_InvalidTarget || CalleeTarget == CUDAFunctionTarget.CFT_InvalidTarget) {
    return CUDAFunctionPreference.CFP_Never;
  }
  
  // (a) Can't call global from some contexts until we support CUDA's
  // dynamic parallelism.
  if (CalleeTarget == CUDAFunctionTarget.CFT_Global
     && (CallerTarget == CUDAFunctionTarget.CFT_Global || CallerTarget == CUDAFunctionTarget.CFT_Device
     || (CallerTarget == CUDAFunctionTarget.CFT_HostDevice && $this().getLangOpts().CUDAIsDevice))) {
    return CUDAFunctionPreference.CFP_Never;
  }
  
  // (b) Calling HostDevice is OK for everyone.
  if (CalleeTarget == CUDAFunctionTarget.CFT_HostDevice) {
    return CUDAFunctionPreference.CFP_HostDevice;
  }
  
  // (c) Best case scenarios
  if (CalleeTarget == CallerTarget
     || (CallerTarget == CUDAFunctionTarget.CFT_Host && CalleeTarget == CUDAFunctionTarget.CFT_Global)
     || (CallerTarget == CUDAFunctionTarget.CFT_Global && CalleeTarget == CUDAFunctionTarget.CFT_Device)) {
    return CUDAFunctionPreference.CFP_Native;
  }
  
  // (d) HostDevice behavior depends on compilation mode.
  if (CallerTarget == CUDAFunctionTarget.CFT_HostDevice) {
    // It's OK to call a compilation-mode matching function from an HD one.
    if (($this().getLangOpts().CUDAIsDevice && CalleeTarget == CUDAFunctionTarget.CFT_Device)
       || (!$this().getLangOpts().CUDAIsDevice
       && (CalleeTarget == CUDAFunctionTarget.CFT_Host || CalleeTarget == CUDAFunctionTarget.CFT_Global))) {
      return CUDAFunctionPreference.CFP_SameSide;
    }
    
    // Calls from HD to non-mode-matching functions (i.e., to host functions
    // when compiling in device mode or to device functions when compiling in
    // host mode) are allowed at the sema level, but eventually rejected if
    // they're ever codegened.  TODO: Reject said calls earlier.
    return CUDAFunctionPreference.CFP_WrongSide;
  }
  
  // (e) Calling across device/host boundary is not something you should do.
  if ((CallerTarget == CUDAFunctionTarget.CFT_Host && CalleeTarget == CUDAFunctionTarget.CFT_Device)
     || (CallerTarget == CUDAFunctionTarget.CFT_Device && CalleeTarget == CUDAFunctionTarget.CFT_Host)
     || (CallerTarget == CUDAFunctionTarget.CFT_Global && CalleeTarget == CUDAFunctionTarget.CFT_Host)) {
    return CUDAFunctionPreference.CFP_Never;
  }
  throw new llvm_unreachable("All cases should've been handled by now.");
}


/// May add implicit CUDAHostAttr and CUDADeviceAttr attributes to FD,
/// depending on FD and the current compilation settings.

// With -fcuda-host-device-constexpr, an unattributed constexpr function is
// treated as implicitly __host__ __device__, unless:
//  * it is a variadic function (device-side variadic functions are not
//    allowed), or
//  * a __device__ function with this signature was already declared, in which
//    case in which case we output an error, unless the __device__ decl is in a
//    system header, in which case we leave the constexpr function unattributed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::maybeAddCUDAHostDeviceAttrs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp", line = 444,
 FQN="clang::Sema::maybeAddCUDAHostDeviceAttrs", NM="_ZN5clang4Sema27maybeAddCUDAHostDeviceAttrsEPNS_5ScopeEPNS_12FunctionDeclERKNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp -nm=_ZN5clang4Sema27maybeAddCUDAHostDeviceAttrsEPNS_5ScopeEPNS_12FunctionDeclERKNS_12LookupResultE")
//</editor-fold>
public final void maybeAddCUDAHostDeviceAttrs(Scope /*P*/ S, FunctionDecl /*P*/ NewD, 
                           final /*const*/ LookupResult /*&*/ Previous) {
  assert ($this().getLangOpts().CUDA) : "May be called only for CUDA compilations.";
  if (!$this().getLangOpts().CUDAHostDeviceConstexpr || !NewD.isConstexpr()
     || NewD.isVariadic() || NewD.hasAttr(CUDAHostAttr.class)
     || NewD.hasAttr(CUDADeviceAttr.class) || NewD.hasAttr(CUDAGlobalAttr.class)) {
    return;
  }
  
  // Is D a __device__ function with the same signature as NewD, ignoring CUDA
  // attributes?
  BoolPredicate<NamedDecl/*P*/> IsMatchingDeviceFn = /*[&, this, &NewD]*/ (NamedDecl /*P*/ D) -> {
        {
          UsingShadowDecl /*P*/ Using = dyn_cast_UsingShadowDecl(D);
          if ((Using != null)) {
            D = Using.getTargetDecl();
          }
        }
        FunctionDecl /*P*/ OldD = D.getAsFunction();
        return (OldD != null) && OldD.hasAttr(CUDADeviceAttr.class)
           && !OldD.hasAttr(CUDAHostAttr.class)
           && !$this().IsOverload(NewD, OldD, /* UseMemberUsingDeclRules = */ false, 
            /* ConsiderCudaAttrs = */ false);
      };
  UnresolvedSetIterator It = llvm.find_if(Previous, IsMatchingDeviceFn);
  if (It.$noteq(Previous.end())) {
    // We found a __device__ function with the same name and signature as NewD
    // (ignoring CUDA attrs).  This is an error unless that function is defined
    // in a system header, in which case we simply return without making NewD
    // host+device.
    NamedDecl /*P*/ Match = It.$star();
    if (!$this().getSourceManager().isInSystemHeader(Match.getLocation())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_StringRef($c$.track($this().Diag(NewD.getLocation(), 
                diag.err_cuda_unattributed_constexpr_cannot_overload_device)), 
            NewD.getName()));
        $c$.clean($c$.track($this().Diag(Match.getLocation(), 
            diag.note_cuda_conflicting_device_function_declared_here)));
      } finally {
        $c$.$destroy();
      }
    }
    return;
  }
  
  NewD.addAttr(CUDAHostAttr.CreateImplicit($this().Context));
  NewD.addAttr(CUDADeviceAttr.CreateImplicit($this().Context));
}


/// Finds a function in \p Matches with highest calling priority
/// from \p Caller context and erases all functions with lower
/// calling priority.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::EraseUnwantedCUDAMatches">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp", line = 172,
 FQN="clang::Sema::EraseUnwantedCUDAMatches", NM="_ZN5clang4Sema24EraseUnwantedCUDAMatchesEPKNS_12FunctionDeclERN4llvm15SmallVectorImplIPS1_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp -nm=_ZN5clang4Sema24EraseUnwantedCUDAMatchesEPKNS_12FunctionDeclERN4llvm15SmallVectorImplIPS1_EE")
//</editor-fold>
public final void EraseUnwantedCUDAMatches_FunctionDecl$C$P_SmallVectorImpl$FunctionDecl$P(/*const*/ FunctionDecl /*P*/ Caller, 
                                                                        final SmallVectorImpl<FunctionDecl /*P*/ > /*&*/ Matches) {
  SemaCUDAStatics.<FunctionDecl /*P*/ >EraseUnwantedCUDAMatchesImpl(/*Deref*/$this(), Caller, Matches, /*FuncArg*//*[]*/ (/*const*/ FunctionDecl /*P*/ item) -> {
            return item;
          });
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::EraseUnwantedCUDAMatches">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp", line = 178,
 FQN="clang::Sema::EraseUnwantedCUDAMatches", NM="_ZN5clang4Sema24EraseUnwantedCUDAMatchesEPKNS_12FunctionDeclERN4llvm15SmallVectorImplINS_14DeclAccessPairEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp -nm=_ZN5clang4Sema24EraseUnwantedCUDAMatchesEPKNS_12FunctionDeclERN4llvm15SmallVectorImplINS_14DeclAccessPairEEE")
//</editor-fold>
public final void EraseUnwantedCUDAMatches_FunctionDecl$C$P_SmallVectorImpl$DeclAccessPair(/*const*/ FunctionDecl /*P*/ Caller, 
                                                                        final SmallVectorImpl<DeclAccessPair> /*&*/ Matches) {
  SemaCUDAStatics.<DeclAccessPair>EraseUnwantedCUDAMatchesImpl(/*Deref*/$this(), Caller, Matches, /*FuncArg*//*[]*/ (final /*const*/ DeclAccessPair /*&*/ item) -> {
            return dyn_cast_FunctionDecl(item.getDecl());
          });
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::EraseUnwantedCUDAMatches">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp", line = 186,
 FQN="clang::Sema::EraseUnwantedCUDAMatches", NM="_ZN5clang4Sema24EraseUnwantedCUDAMatchesEPKNS_12FunctionDeclERN4llvm15SmallVectorImplISt4pairINS_14DeclAccessPairEPS1_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp -nm=_ZN5clang4Sema24EraseUnwantedCUDAMatchesEPKNS_12FunctionDeclERN4llvm15SmallVectorImplISt4pairINS_14DeclAccessPairEPS1_EEE")
//</editor-fold>
public final void EraseUnwantedCUDAMatches_FunctionDecl$C$P_SmallVectorImpl$pair$P(/*const*/ FunctionDecl /*P*/ Caller, 
                                                                final SmallVectorImpl<std.pair<DeclAccessPair, FunctionDecl /*P*/ > > /*&*/ Matches) {
  EraseUnwantedCUDAMatchesImpl(/*Deref*/$this(), Caller, Matches, 
      /*FuncArg*//*[]*/ (final /*const*/ std.pair<DeclAccessPair, FunctionDecl /*P*/ > /*&*/ item) -> {
            return dyn_cast_FunctionDecl(item.second);
          });
}


/// Given a implicit special member, infer its CUDA target from the
/// calls it needs to make to underlying base/field special members.
/// \param ClassDecl the class for which the member is being created.
/// \param CSM the kind of special member.
/// \param MemberDecl the special member itself.
/// \param ConstRHS true if this is a copy operation with a const object on
///        its RHS.
/// \param Diagnose true if this call should emit diagnostics.
/// \return true if there was an error inferring.
/// The result of this call is implicit CUDA target attribute(s) attached to
/// the member declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::inferCUDATargetForImplicitSpecialMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp", line = 225,
 FQN="clang::Sema::inferCUDATargetForImplicitSpecialMember", NM="_ZN5clang4Sema39inferCUDATargetForImplicitSpecialMemberEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEPNS_13CXXMethodDeclEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp -nm=_ZN5clang4Sema39inferCUDATargetForImplicitSpecialMemberEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEPNS_13CXXMethodDeclEbb")
//</editor-fold>
public final boolean inferCUDATargetForImplicitSpecialMember(CXXRecordDecl /*P*/ ClassDecl, 
                                       CXXSpecialMember CSM, 
                                       CXXMethodDecl /*P*/ MemberDecl, 
                                       boolean ConstRHS, 
                                       boolean Diagnose) {
  ContextRAII MethodContext = null;
  try {
    Optional<CUDAFunctionTarget> InferredTarget/*J*/= new Optional<CUDAFunctionTarget>();
    
    // We're going to invoke special member lookup; mark that these special
    // members are called from this one, and not from its caller.
    MethodContext/*J*/= new ContextRAII(/*Deref*/$this(), MemberDecl);
    
    // Look for special members in base classes that should be invoked from here.
    // Infer the target of this member base on the ones it should call.
    // Skip direct and indirect virtual bases for abstract classes.
    SmallVector</*const*/ CXXBaseSpecifier /*P*/ > Bases/*J*/= new SmallVector</*const*/ CXXBaseSpecifier /*P*/ >(16, (/*const*/ CXXBaseSpecifier /*P*/ )null);
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : ClassDecl.bases()) {
      if (!B.isVirtual()) {
        Bases.push_back($AddrOf(B));
      }
    }
    if (!ClassDecl.isAbstract()) {
      for (final /*const*/ CXXBaseSpecifier /*&*/ VB : ClassDecl.vbases()) {
        Bases.push_back($AddrOf(VB));
      }
    }
    
    for (/*const*/ CXXBaseSpecifier /*P*/ B : Bases) {
      /*const*/ RecordType /*P*/ BaseType = B.getType().$arrow().getAs$RecordType();
      if (!(BaseType != null)) {
        continue;
      }
      
      CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(BaseType.getDecl());
      Sema.SpecialMemberOverloadResult /*P*/ SMOR = $this().LookupSpecialMember(BaseClassDecl, CSM, 
          /* ConstArg */ ConstRHS, 
          /* VolatileArg */ false, 
          /* RValueThis */ false, 
          /* ConstThis */ false, 
          /* VolatileThis */ false);
      if (!(SMOR != null) || !(SMOR.getMethod() != null)) {
        continue;
      }
      
      CUDAFunctionTarget BaseMethodTarget = $this().IdentifyCUDATarget(SMOR.getMethod());
      if (!InferredTarget.hasValue()) {
        InferredTarget.$assign_T$C$R(/*KEEP_ENUM*/BaseMethodTarget);
      } else {
        boolean ResolutionError = SemaCUDAStatics.resolveCalleeCUDATargetConflict(InferredTarget.getValue(), BaseMethodTarget, 
            InferredTarget.getPointer$Ref());
        if (ResolutionError) {
          if (Diagnose) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint($c$.track($this().Diag(ClassDecl.getLocation(), 
                              diag.note_implicit_member_target_infer_collision)), 
                          (/*uint*/int)CSM.getValue()), InferredTarget.getValue()), BaseMethodTarget));
            } finally {
              $c$.$destroy();
            }
          }
          MemberDecl.addAttr(CUDAInvalidTargetAttr.CreateImplicit($this().Context));
          return true;
        }
      }
    }
    
    // Same as for bases, but now for special members of fields.
    for (/*const*/ FieldDecl /*P*/ F : ClassDecl.fields()) {
      if (F.isInvalidDecl()) {
        continue;
      }
      
      /*const*/ RecordType /*P*/ FieldType = $this().Context.getBaseElementType(F.getType()).$arrow().getAs$RecordType();
      if (!(FieldType != null)) {
        continue;
      }
      
      CXXRecordDecl /*P*/ FieldRecDecl = cast_CXXRecordDecl(FieldType.getDecl());
      Sema.SpecialMemberOverloadResult /*P*/ SMOR = $this().LookupSpecialMember(FieldRecDecl, CSM, 
          /* ConstArg */ ConstRHS && !F.isMutable(), 
          /* VolatileArg */ false, 
          /* RValueThis */ false, 
          /* ConstThis */ false, 
          /* VolatileThis */ false);
      if (!(SMOR != null) || !(SMOR.getMethod() != null)) {
        continue;
      }
      
      CUDAFunctionTarget FieldMethodTarget = $this().IdentifyCUDATarget(SMOR.getMethod());
      if (!InferredTarget.hasValue()) {
        InferredTarget.$assign_T$C$R(/*KEEP_ENUM*/FieldMethodTarget);
      } else {
        boolean ResolutionError = SemaCUDAStatics.resolveCalleeCUDATargetConflict(InferredTarget.getValue(), FieldMethodTarget, 
            InferredTarget.getPointer$Ref());
        if (ResolutionError) {
          if (Diagnose) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint($c$.track($this().Diag(ClassDecl.getLocation(), 
                              diag.note_implicit_member_target_infer_collision)), 
                          (/*uint*/int)CSM.getValue()), InferredTarget.getValue()), 
                  FieldMethodTarget));
            } finally {
              $c$.$destroy();
            }
          }
          MemberDecl.addAttr(CUDAInvalidTargetAttr.CreateImplicit($this().Context));
          return true;
        }
      }
    }
    if (InferredTarget.hasValue()) {
      if (InferredTarget.getValue() == CUDAFunctionTarget.CFT_Device) {
        MemberDecl.addAttr(CUDADeviceAttr.CreateImplicit($this().Context));
      } else if (InferredTarget.getValue() == CUDAFunctionTarget.CFT_Host) {
        MemberDecl.addAttr(CUDAHostAttr.CreateImplicit($this().Context));
      } else {
        MemberDecl.addAttr(CUDADeviceAttr.CreateImplicit($this().Context));
        MemberDecl.addAttr(CUDAHostAttr.CreateImplicit($this().Context));
      }
    } else {
      // If no target was inferred, mark this member as __host__ __device__;
      // it's the least restrictive option that can be invoked from any target.
      MemberDecl.addAttr(CUDADeviceAttr.CreateImplicit($this().Context));
      MemberDecl.addAttr(CUDAHostAttr.CreateImplicit($this().Context));
    }
    
    return false;
  } finally {
    if (MethodContext != null) { MethodContext.$destroy(); }
  }
}


/// \return true if \p CD can be considered empty according to CUDA
/// (E.2.3.1 in CUDA 7.5 Programming guide).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isEmptyCudaConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp", line = 355,
 FQN="clang::Sema::isEmptyCudaConstructor", NM="_ZN5clang4Sema22isEmptyCudaConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp -nm=_ZN5clang4Sema22isEmptyCudaConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclE")
//</editor-fold>
public final boolean isEmptyCudaConstructor(SourceLocation Loc, CXXConstructorDecl /*P*/ CD) {
  if (!CD.isDefined() && CD.isTemplateInstantiation()) {
    $this().InstantiateFunctionDefinition(new SourceLocation(Loc), CD.getFirstDecl());
  }
  
  // (E.2.3.1, CUDA 7.5) A constructor for a class type is considered
  // empty at a point in the translation unit, if it is either a
  // trivial constructor
  if (CD.isTrivial()) {
    return true;
  }
  
  // ... or it satisfies all of the following conditions:
  // The constructor function has been defined.
  // The constructor function has no parameters,
  // and the function body is an empty compound statement.
  if (!(CD.hasTrivialBody() && CD.getNumParams() == 0)) {
    return false;
  }
  
  // Its class has no virtual functions and no virtual base classes.
  if (CD.getParent().isDynamicClass()) {
    return false;
  }
  
  // The only form of initializer allowed is an empty constructor.
  // This will recursively check all base classes and member initializers
  if (!llvm.all_of(CD.inits(), /*[&, this, &Loc]*/ (/*const*/ CXXCtorInitializer /*P*/ CI) -> {
            {
              /*const*/ CXXConstructExpr /*P*/ CE = dyn_cast_CXXConstructExpr(CI.getInit());
              if ((CE != null)) {
                return $this().isEmptyCudaConstructor(new SourceLocation(Loc), CE.getConstructor());
              }
            }
            return false;
          })) {
    return false;
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::isEmptyCudaDestructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp", line = 389,
 FQN="clang::Sema::isEmptyCudaDestructor", NM="_ZN5clang4Sema21isEmptyCudaDestructorENS_14SourceLocationEPNS_17CXXDestructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp -nm=_ZN5clang4Sema21isEmptyCudaDestructorENS_14SourceLocationEPNS_17CXXDestructorDeclE")
//</editor-fold>
public final boolean isEmptyCudaDestructor(SourceLocation Loc, CXXDestructorDecl /*P*/ DD) {
  // No destructor -> no problem.
  if (!(DD != null)) {
    return true;
  }
  if (!DD.isDefined() && DD.isTemplateInstantiation()) {
    $this().InstantiateFunctionDefinition(new SourceLocation(Loc), DD.getFirstDecl());
  }
  
  // (E.2.3.1, CUDA 7.5) A destructor for a class type is considered
  // empty at a point in the translation unit, if it is either a
  // trivial constructor
  if (DD.isTrivial()) {
    return true;
  }
  
  // ... or it satisfies all of the following conditions:
  // The destructor function has been defined.
  // and the function body is an empty compound statement.
  if (!DD.hasTrivialBody()) {
    return false;
  }
  
  /*const*/ CXXRecordDecl /*P*/ ClassDecl = DD.getParent();
  
  // Its class has no virtual functions and no virtual base classes.
  if (ClassDecl.isDynamicClass()) {
    return false;
  }
  
  // Only empty destructors are allowed. This will recursively check
  // destructors for all base classes...
  if (!llvm.all_of(ClassDecl.bases$Const(), /*[&, this, &Loc]*/ (final /*const*/ CXXBaseSpecifier /*&*/ BS) -> {
            {
              CXXRecordDecl /*P*/ RD = BS.getType().$arrow().getAsCXXRecordDecl();
              if ((RD != null)) {
                return $this().isEmptyCudaDestructor(new SourceLocation(Loc), RD.getDestructor());
              }
            }
            return true;
          })) {
    return false;
  }
  
  // ... and member fields.
  if (!llvm.all_of(ClassDecl.fields(), /*[&, this, &Loc]*/ (/*const*/ FieldDecl /*P*/ Field) -> {
            {
              CXXRecordDecl /*P*/ RD = Field.getType().$arrow().
                  getBaseElementTypeUnsafe().
                  getAsCXXRecordDecl();
              if ((RD != null)) {
                return $this().isEmptyCudaDestructor(new SourceLocation(Loc), RD.getDestructor());
              }
            }
            return true;
          })) {
    return false;
  }
  
  return true;
}

} // END OF class Sema_SemaCUDA
