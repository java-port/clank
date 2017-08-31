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

package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.llvm.ir.FunctionType;
import org.llvm.ir.Type;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// \brief Implements C++ ABI-specific code generation functions.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 43,
 FQN="clang::CodeGen::CGCXXABI", NM="_ZN5clang7CodeGen8CGCXXABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABIE")
//</editor-fold>
public abstract class CGCXXABI implements Destructors.ClassWithDestructor {
/*protected:*/
  /*friend*/public/*protected*/ final CodeGenModule /*&*/ CGM;
  protected std.unique_ptr<MangleContext> MangleCtx;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::CGCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 48,
   FQN="clang::CodeGen::CGCXXABI::CGCXXABI", NM="_ZN5clang7CodeGen8CGCXXABIC1ERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABIC1ERNS0_13CodeGenModuleE")
  //</editor-fold>
  protected CGCXXABI(final CodeGenModule /*&*/ CGM) {
    // : CGM(CGM), MangleCtx(CGM.getContext().createMangleContext()) 
    //START JInit
    this./*&*/CGM=/*&*/CGM;
    this.MangleCtx = new std.unique_ptr<MangleContext>(CGM.getContext().createMangleContext());
    //END JInit
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getThisDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 52,
   FQN="clang::CodeGen::CGCXXABI::getThisDecl", NM="_ZN5clang7CodeGen8CGCXXABI11getThisDeclERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI11getThisDeclERNS0_15CodeGenFunctionE")
  //</editor-fold>
  protected ImplicitParamDecl /*P*/ getThisDecl(final CodeGenFunction /*&*/ CGF) {
    return CGF.CXXABIThisDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getThisValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 55,
   FQN="clang::CodeGen::CGCXXABI::getThisValue", NM="_ZN5clang7CodeGen8CGCXXABI12getThisValueERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI12getThisValueERNS0_15CodeGenFunctionE")
  //</editor-fold>
  protected Value /*P*/ getThisValue(final CodeGenFunction /*&*/ CGF) {
    return CGF.CXXABIThisValue;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getThisAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 58,
   FQN="clang::CodeGen::CGCXXABI::getThisAddress", NM="_ZN5clang7CodeGen8CGCXXABI14getThisAddressERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI14getThisAddressERNS0_15CodeGenFunctionE")
  //</editor-fold>
  protected Address getThisAddress(final CodeGenFunction /*&*/ CGF) {
    return new Address(CGF.CXXABIThisValue, new CharUnits(CGF.CXXABIThisAlignment));
  }

  
  /// Issue a diagnostic about unsupported features in the ABI.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::ErrorUnsupportedABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 23,
   FQN="clang::CodeGen::CGCXXABI::ErrorUnsupportedABI", NM="_ZN5clang7CodeGen8CGCXXABI19ErrorUnsupportedABIERNS0_15CodeGenFunctionEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI19ErrorUnsupportedABIERNS0_15CodeGenFunctionEN4llvm9StringRefE")
  //</editor-fold>
  protected void ErrorUnsupportedABI(final CodeGenFunction /*&*/ CGF, StringRef S) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final DiagnosticsEngine /*&*/ Diags = CGF.CGM.getDiags();
      /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
          /*KEEP_STR*/"cannot yet compile %0 in this ABI");
      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/CGF.getContext().getFullLoc(CGF.CurCodeDecl.getLocation()), 
              DiagID)), 
          /*NO_COPY*/S));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Get a null value for unsupported member pointers.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::GetBogusMemberPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 67,
   FQN="clang::CodeGen::CGCXXABI::GetBogusMemberPointer", NM="_ZN5clang7CodeGen8CGCXXABI21GetBogusMemberPointerENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI21GetBogusMemberPointerENS_8QualTypeE")
  //</editor-fold>
  protected Constant /*P*/ GetBogusMemberPointer(QualType T) {
    return Constant.getNullValue(CGM.getTypes().ConvertType(new QualType(T)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getStructorImplicitParamDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 68,
   FQN="clang::CodeGen::CGCXXABI::getStructorImplicitParamDecl", NM="_ZN5clang7CodeGen8CGCXXABI28getStructorImplicitParamDeclERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI28getStructorImplicitParamDeclERNS0_15CodeGenFunctionE")
  //</editor-fold>
  protected type$ref<ImplicitParamDecl /*P*/ /*&*/> getStructorImplicitParamDecl(final CodeGenFunction /*&*/ CGF) {
    return CGF.CXXStructorImplicitParamDecl_ref;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getStructorImplicitParamValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 71,
   FQN="clang::CodeGen::CGCXXABI::getStructorImplicitParamValue", NM="_ZN5clang7CodeGen8CGCXXABI29getStructorImplicitParamValueERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI29getStructorImplicitParamValueERNS0_15CodeGenFunctionE")
  //</editor-fold>
  protected type$ref<Value /*P*/ /*&*/> getStructorImplicitParamValue(final CodeGenFunction /*&*/ CGF) {
    return CGF.CXXStructorImplicitParamValue_ref;
  }

  
  /// Perform prolog initialization of the parameter variable suitable
  /// for 'this' emitted by buildThisParam.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitThisParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 180,
   FQN="clang::CodeGen::CGCXXABI::EmitThisParam", NM="_ZN5clang7CodeGen8CGCXXABI13EmitThisParamERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI13EmitThisParamERNS0_15CodeGenFunctionE")
  //</editor-fold>
  protected void EmitThisParam(final CodeGenFunction /*&*/ CGF) {
    /// Initialize the 'this' slot.
    assert ((getThisDecl(CGF) != null)) : "no 'this' variable for function";
    CGF.CXXABIThisValue
       = CGF.Builder.CreateLoad(CGF.GetAddrOfLocalVar(getThisDecl(CGF)), 
        $this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 79,
   FQN="clang::CodeGen::CGCXXABI::getContext", NM="_ZNK5clang7CodeGen8CGCXXABI10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZNK5clang7CodeGen8CGCXXABI10getContextEv")
  //</editor-fold>
  protected ASTContext /*&*/ getContext() /*const*/ {
    return CGM.getContext();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::requiresArrayCookie">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 214,
   FQN="clang::CodeGen::CGCXXABI::requiresArrayCookie", NM="_ZN5clang7CodeGen8CGCXXABI19requiresArrayCookieEPKNS_13CXXDeleteExprENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI19requiresArrayCookieEPKNS_13CXXDeleteExprENS_8QualTypeE")
  //</editor-fold>
  protected boolean requiresArrayCookie(/*const*/ CXXDeleteExpr /*P*/ expr, 
                     QualType elementType) {
    // If the class's usual deallocation function takes two arguments,
    // it needs a cookie.
    if (expr.doesUsualArrayDeleteWantSize()) {
      return true;
    }
    
    return (elementType.isDestructedType().getValue() != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::requiresArrayCookie">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 224,
   FQN="clang::CodeGen::CGCXXABI::requiresArrayCookie", NM="_ZN5clang7CodeGen8CGCXXABI19requiresArrayCookieEPKNS_10CXXNewExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI19requiresArrayCookieEPKNS_10CXXNewExprE")
  //</editor-fold>
  protected boolean requiresArrayCookie(/*const*/ CXXNewExpr /*P*/ expr) {
    // If the class's usual deallocation function takes two arguments,
    // it needs a cookie.
    if (expr.doesUsualArrayDeleteWantSize()) {
      return true;
    }
    
    return (expr.getAllocatedType().isDestructedType().getValue() != 0);
  }

  
  /// Determine whether there's something special about the rules of
  /// the ABI tell us that 'this' is a complete object within the
  /// given function.  Obvious common logic like being defined on a
  /// final class will have been taken care of by the caller.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::isThisCompleteObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 88,
   FQN="clang::CodeGen::CGCXXABI::isThisCompleteObject", NM="_ZNK5clang7CodeGen8CGCXXABI20isThisCompleteObjectENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZNK5clang7CodeGen8CGCXXABI20isThisCompleteObjectENS_10GlobalDeclE")
  //</editor-fold>
  protected abstract /*virtual*/ boolean isThisCompleteObject(GlobalDecl GD) /*const*//* = 0*/;

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::~CGCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 21,
   FQN="clang::CodeGen::CGCXXABI::~CGCXXABI", NM="_ZN5clang7CodeGen8CGCXXABID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABID0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    MangleCtx.$destroy();
    //END JDestroy
  }

  
  /// Gets the mangle context.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getMangleContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 95,
   FQN="clang::CodeGen::CGCXXABI::getMangleContext", NM="_ZN5clang7CodeGen8CGCXXABI16getMangleContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI16getMangleContextEv")
  //</editor-fold>
  public MangleContext /*&*/ getMangleContext() {
    return MangleCtx.$star();
  }

  
  /// Returns true if the given constructor or destructor is one of the
  /// kinds that the ABI says returns 'this' (only applies when called
  /// non-virtually for destructors).
  ///
  /// There currently is no way to indicate if a destructor returns 'this'
  /// when called virtually, and code generation does not support the case.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::HasThisReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 105,
   FQN="clang::CodeGen::CGCXXABI::HasThisReturn", NM="_ZNK5clang7CodeGen8CGCXXABI13HasThisReturnENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZNK5clang7CodeGen8CGCXXABI13HasThisReturnENS_10GlobalDeclE")
  //</editor-fold>
  public /*virtual*/ boolean HasThisReturn(GlobalDecl GD) /*const*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::hasMostDerivedReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 107,
   FQN="clang::CodeGen::CGCXXABI::hasMostDerivedReturn", NM="_ZNK5clang7CodeGen8CGCXXABI20hasMostDerivedReturnENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZNK5clang7CodeGen8CGCXXABI20hasMostDerivedReturnENS_10GlobalDeclE")
  //</editor-fold>
  public /*virtual*/ boolean hasMostDerivedReturn(GlobalDecl GD) /*const*/ {
    return false;
  }

  
  /// Returns true if the target allows calling a function through a pointer
  /// with a different signature than the actual function (or equivalently,
  /// bitcasting a function or function pointer to a different function type).
  /// In principle in the most general case this could depend on the target, the
  /// calling convention, and the actual types of the arguments and return
  /// value. Here it just means whether the signature mismatch could *ever* be
  /// allowed; in other words, does the target do strict checking of signatures
  /// for all calls.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::canCallMismatchedFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 117,
   FQN="clang::CodeGen::CGCXXABI::canCallMismatchedFunctionType", NM="_ZNK5clang7CodeGen8CGCXXABI29canCallMismatchedFunctionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZNK5clang7CodeGen8CGCXXABI29canCallMismatchedFunctionTypeEv")
  //</editor-fold>
  public /*virtual*/ boolean canCallMismatchedFunctionType() /*const*/ {
    return true;
  }

  
  /// If the C++ ABI requires the given type be returned in a particular way,
  /// this method sets RetAI and returns true.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::classifyReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 121,
   FQN="clang::CodeGen::CGCXXABI::classifyReturnType", NM="_ZNK5clang7CodeGen8CGCXXABI18classifyReturnTypeERNS0_14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZNK5clang7CodeGen8CGCXXABI18classifyReturnTypeERNS0_14CGFunctionInfoE")
  //</editor-fold>
  public abstract /*virtual*/ boolean classifyReturnType(final CGFunctionInfo /*&*/ FI) /*const*//* = 0*/;

  
  /// Specify how one should pass an argument of a record type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::RecordArgABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 124,
   FQN="clang::CodeGen::CGCXXABI::RecordArgABI", NM="_ZN5clang7CodeGen8CGCXXABI12RecordArgABIE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI12RecordArgABIE")
  //</editor-fold>
  public enum RecordArgABI implements Native.NativeUIntEnum {
    /// Pass it using the normal C aggregate rules for the ABI, potentially
    /// introducing extra copies and passing some or all of it in registers.
    RAA_Default(0),
    
    /// Pass it on the stack using its defined layout.  The argument must be
    /// evaluated directly into the correct stack position in the arguments area,
    /// and the call machinery must not move it or introduce extra copies.
    RAA_DirectInMemory(RAA_Default.getValue() + 1),
    
    /// Pass it as a pointer to temporary memory.
    RAA_Indirect(RAA_DirectInMemory.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static RecordArgABI valueOf(int val) {
      RecordArgABI out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final RecordArgABI[] VALUES;
      private static final RecordArgABI[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (RecordArgABI kind : RecordArgABI.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new RecordArgABI[min < 0 ? (1-min) : 0];
        VALUES = new RecordArgABI[max >= 0 ? (1+max) : 0];
        for (RecordArgABI kind : RecordArgABI.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private RecordArgABI(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// Returns true if C++ allows us to copy the memory of an object of type RD
  /// when it is passed as an argument.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::canCopyArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 32,
   FQN="clang::CodeGen::CGCXXABI::canCopyArgument", NM="_ZNK5clang7CodeGen8CGCXXABI15canCopyArgumentEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZNK5clang7CodeGen8CGCXXABI15canCopyArgumentEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public boolean canCopyArgument(/*const*/ CXXRecordDecl /*P*/ RD) /*const*/ {
    // If RD has a non-trivial move or copy constructor, we cannot copy the
    // argument.
    if (RD.hasNonTrivialCopyConstructor() || RD.hasNonTrivialMoveConstructor()) {
      return false;
    }
    
    // If RD has a non-trivial destructor, we cannot copy the argument.
    if (RD.hasNonTrivialDestructor()) {
      return false;
    }
    
    // We can only copy the argument if there exists at least one trivial,
    // non-deleted copy or move constructor.
    // FIXME: This assumes that all lazily declared copy and move constructors are
    // not deleted.  This assumption might not be true in some corner cases.
    boolean CopyDeleted = false;
    boolean MoveDeleted = false;
    for (/*const*/ CXXConstructorDecl /*P*/ CD : RD.ctors()) {
      if (CD.isCopyConstructor() || CD.isMoveConstructor()) {
        assert (CD.isTrivial());
        // We had at least one undeleted trivial copy or move ctor.  Return
        // directly.
        if (!CD.isDeleted()) {
          return true;
        }
        if (CD.isCopyConstructor()) {
          CopyDeleted = true;
        } else {
          MoveDeleted = true;
        }
      }
    }
    
    // If all trivial copy and move constructors are deleted, we cannot copy the
    // argument.
    return !(CopyDeleted && MoveDeleted);
  }

  
  /// Returns how an argument of the given record type should be passed.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getRecordArgABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 143,
   FQN="clang::CodeGen::CGCXXABI::getRecordArgABI", NM="_ZNK5clang7CodeGen8CGCXXABI15getRecordArgABIEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZNK5clang7CodeGen8CGCXXABI15getRecordArgABIEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public abstract /*virtual*/ RecordArgABI getRecordArgABI(/*const*/ CXXRecordDecl /*P*/ RD) /*const*//* = 0*/;

  
  /// Returns true if the implicit 'sret' parameter comes after the implicit
  /// 'this' parameter of C++ instance methods.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::isSRetParameterAfterThis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 147,
   FQN="clang::CodeGen::CGCXXABI::isSRetParameterAfterThis", NM="_ZNK5clang7CodeGen8CGCXXABI24isSRetParameterAfterThisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZNK5clang7CodeGen8CGCXXABI24isSRetParameterAfterThisEv")
  //</editor-fold>
  public /*virtual*/ boolean isSRetParameterAfterThis() /*const*/ {
    return false;
  }

  
  /// Find the LLVM type used to represent the given member pointer
  /// type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::ConvertMemberPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 71,
   FQN="clang::CodeGen::CGCXXABI::ConvertMemberPointerType", NM="_ZN5clang7CodeGen8CGCXXABI24ConvertMemberPointerTypeEPKNS_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI24ConvertMemberPointerTypeEPKNS_17MemberPointerTypeE")
  //</editor-fold>
  public org.llvm.ir.Type /*P*/ ConvertMemberPointerType(/*const*/ MemberPointerType /*P*/ MPT) {
    return CGM.getTypes().ConvertType(CGM.getContext().getPointerDiffType());
  }

  
  /// Load a member function from an object and a member function
  /// pointer.  Apply the this-adjustment and set 'This' to the
  /// adjusted value.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitLoadOfMemberFunctionPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 76,
   FQN="clang::CodeGen::CGCXXABI::EmitLoadOfMemberFunctionPointer", NM="_ZN5clang7CodeGen8CGCXXABI31EmitLoadOfMemberFunctionPointerERNS0_15CodeGenFunctionEPKNS_4ExprENS0_7AddressERPN4llvm5ValueESA_PKNS_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI31EmitLoadOfMemberFunctionPointerERNS0_15CodeGenFunctionEPKNS_4ExprENS0_7AddressERPN4llvm5ValueESA_PKNS_17MemberPointerTypeE")
  //</editor-fold>
  public Value /*P*/ EmitLoadOfMemberFunctionPointer(final CodeGenFunction /*&*/ CGF, /*const*/ Expr /*P*/ E, Address This, 
                                 final type$ref<Value /*P*/ /*&*/> ThisPtrForCall, 
                                 Value /*P*/ MemPtr, /*const*/ MemberPointerType /*P*/ MPT) {
    ErrorUnsupportedABI(CGF, new StringRef(/*KEEP_STR*/"calls through member pointers"));
    
    ThisPtrForCall.$set(This.getPointer());
    /*const*/ FunctionProtoType /*P*/ FPT = MPT.getPointeeType().$arrow().getAs(FunctionProtoType.class);
    /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(MPT.__getClass().getAs$RecordType().getDecl());
    org.llvm.ir.FunctionType /*P*/ FTy = CGM.getTypes().GetFunctionType(CGM.getTypes().arrangeCXXMethodType(RD, FPT, /*FD=*/ (/*const*/ CXXMethodDecl /*P*/ )null));
    return Constant.getNullValue(FTy.getPointerTo());
  }

  
  /// Calculate an l-value from an object and a data member pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitMemberDataPointerAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 92,
   FQN="clang::CodeGen::CGCXXABI::EmitMemberDataPointerAddress", NM="_ZN5clang7CodeGen8CGCXXABI28EmitMemberDataPointerAddressERNS0_15CodeGenFunctionEPKNS_4ExprENS0_7AddressEPN4llvm5ValueEPKNS_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI28EmitMemberDataPointerAddressERNS0_15CodeGenFunctionEPKNS_4ExprENS0_7AddressEPN4llvm5ValueEPKNS_17MemberPointerTypeE")
  //</editor-fold>
  public Value /*P*/ EmitMemberDataPointerAddress(final CodeGenFunction /*&*/ CGF, /*const*/ Expr /*P*/ E, 
                              Address Base, Value /*P*/ MemPtr, 
                              /*const*/ MemberPointerType /*P*/ MPT) {
    ErrorUnsupportedABI(CGF, new StringRef(/*KEEP_STR*/"loads of member pointers"));
    org.llvm.ir.Type /*P*/ Ty = CGF.ConvertType(MPT.getPointeeType()).
        getPointerTo(Base.getAddressSpace());
    return Constant.getNullValue(Ty);
  }

  
  /// Perform a derived-to-base, base-to-derived, or bitcast member
  /// pointer conversion.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitMemberPointerConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 102,
   FQN="clang::CodeGen::CGCXXABI::EmitMemberPointerConversion", NM="_ZN5clang7CodeGen8CGCXXABI27EmitMemberPointerConversionERNS0_15CodeGenFunctionEPKNS_8CastExprEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI27EmitMemberPointerConversionERNS0_15CodeGenFunctionEPKNS_8CastExprEPN4llvm5ValueE")
  //</editor-fold>
  public Value /*P*/ EmitMemberPointerConversion(final CodeGenFunction /*&*/ CGF, 
                             /*const*/ CastExpr /*P*/ E, 
                             Value /*P*/ Src) {
    ErrorUnsupportedABI(CGF, new StringRef(/*KEEP_STR*/"member function pointer conversions"));
    return GetBogusMemberPointer(E.getType());
  }

  
  /// Perform a derived-to-base, base-to-derived, or bitcast member
  /// pointer conversion on a constant value.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitMemberPointerConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 109,
   FQN="clang::CodeGen::CGCXXABI::EmitMemberPointerConversion", NM="_ZN5clang7CodeGen8CGCXXABI27EmitMemberPointerConversionEPKNS_8CastExprEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI27EmitMemberPointerConversionEPKNS_8CastExprEPN4llvm8ConstantE")
  //</editor-fold>
  public Constant /*P*/ EmitMemberPointerConversion(/*const*/ CastExpr /*P*/ E, 
                             Constant /*P*/ Src) {
    return GetBogusMemberPointer(E.getType());
  }

  
  /// Return true if the given member pointer can be zero-initialized
  /// (in the C++ sense) with an LLVM zeroinitializer.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::isZeroInitializable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 151,
   FQN="clang::CodeGen::CGCXXABI::isZeroInitializable", NM="_ZN5clang7CodeGen8CGCXXABI19isZeroInitializableEPKNS_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI19isZeroInitializableEPKNS_17MemberPointerTypeE")
  //</editor-fold>
  public boolean isZeroInitializable(/*const*/ MemberPointerType /*P*/ MPT) {
    // Fake answer.
    return true;
  }

  
  /// Return whether or not a member pointers type is convertible to an IR type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::isMemberPointerConvertible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 184,
   FQN="clang::CodeGen::CGCXXABI::isMemberPointerConvertible", NM="_ZNK5clang7CodeGen8CGCXXABI26isMemberPointerConvertibleEPKNS_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZNK5clang7CodeGen8CGCXXABI26isMemberPointerConvertibleEPKNS_17MemberPointerTypeE")
  //</editor-fold>
  public /*virtual*/ boolean isMemberPointerConvertible(/*const*/ MemberPointerType /*P*/ MPT) /*const*/ {
    return true;
  }

  
  /// Create a null member pointer of the given type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitNullMemberPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 132,
   FQN="clang::CodeGen::CGCXXABI::EmitNullMemberPointer", NM="_ZN5clang7CodeGen8CGCXXABI21EmitNullMemberPointerEPKNS_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI21EmitNullMemberPointerEPKNS_17MemberPointerTypeE")
  //</editor-fold>
  public Constant /*P*/ EmitNullMemberPointer(/*const*/ MemberPointerType /*P*/ MPT) {
    return GetBogusMemberPointer(new QualType(MPT, 0));
  }

  
  /// Create a member pointer for the given method.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitMemberFunctionPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 137,
   FQN="clang::CodeGen::CGCXXABI::EmitMemberFunctionPointer", NM="_ZN5clang7CodeGen8CGCXXABI25EmitMemberFunctionPointerEPKNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI25EmitMemberFunctionPointerEPKNS_13CXXMethodDeclE")
  //</editor-fold>
  public Constant /*P*/ EmitMemberFunctionPointer(/*const*/ CXXMethodDecl /*P*/ MD) {
    return GetBogusMemberPointer(CGM.getContext().getMemberPointerType(MD.getType(), MD.getParent$Const().getTypeForDecl()));
  }

  
  /// Create a member pointer for the given field.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitMemberDataPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 142,
   FQN="clang::CodeGen::CGCXXABI::EmitMemberDataPointer", NM="_ZN5clang7CodeGen8CGCXXABI21EmitMemberDataPointerEPKNS_17MemberPointerTypeENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI21EmitMemberDataPointerEPKNS_17MemberPointerTypeENS_9CharUnitsE")
  //</editor-fold>
  public Constant /*P*/ EmitMemberDataPointer(/*const*/ MemberPointerType /*P*/ MPT, 
                       CharUnits offset) {
    return GetBogusMemberPointer(new QualType(MPT, 0));
  }

  
  /// Create a member pointer for the given member pointer constant.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitMemberPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 147,
   FQN="clang::CodeGen::CGCXXABI::EmitMemberPointer", NM="_ZN5clang7CodeGen8CGCXXABI17EmitMemberPointerERKNS_7APValueENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI17EmitMemberPointerERKNS_7APValueENS_8QualTypeE")
  //</editor-fold>
  public Constant /*P*/ EmitMemberPointer(final /*const*/ APValue /*&*/ MP, QualType MPT) {
    return GetBogusMemberPointer(new QualType(MPT));
  }

  
  /// Emit a comparison between two member pointers.  Returns an i1.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitMemberPointerComparison">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 114,
   FQN="clang::CodeGen::CGCXXABI::EmitMemberPointerComparison", NM="_ZN5clang7CodeGen8CGCXXABI27EmitMemberPointerComparisonERNS0_15CodeGenFunctionEPN4llvm5ValueES6_PKNS_17MemberPointerTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI27EmitMemberPointerComparisonERNS0_15CodeGenFunctionEPN4llvm5ValueES6_PKNS_17MemberPointerTypeEb")
  //</editor-fold>
  public Value /*P*/ EmitMemberPointerComparison(final CodeGenFunction /*&*/ CGF, 
                             Value /*P*/ L, 
                             Value /*P*/ R, 
                             /*const*/ MemberPointerType /*P*/ MPT, 
                             boolean Inequality) {
    ErrorUnsupportedABI(CGF, new StringRef(/*KEEP_STR*/"member function pointer comparison"));
    return CGF.Builder.getFalse();
  }

  
  /// Determine if a member pointer is non-null.  Returns an i1.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitMemberPointerIsNotNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 124,
   FQN="clang::CodeGen::CGCXXABI::EmitMemberPointerIsNotNull", NM="_ZN5clang7CodeGen8CGCXXABI26EmitMemberPointerIsNotNullERNS0_15CodeGenFunctionEPN4llvm5ValueEPKNS_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI26EmitMemberPointerIsNotNullERNS0_15CodeGenFunctionEPN4llvm5ValueEPKNS_17MemberPointerTypeE")
  //</editor-fold>
  public Value /*P*/ EmitMemberPointerIsNotNull(final CodeGenFunction /*&*/ CGF, 
                            Value /*P*/ MemPtr, 
                            /*const*/ MemberPointerType /*P*/ MPT) {
    ErrorUnsupportedABI(CGF, new StringRef(/*KEEP_STR*/"member function pointer null testing"));
    return CGF.Builder.getFalse();
  }

/*protected:*/
  /// A utility method for computing the offset required for the given
  /// base-to-derived or derived-to-base member-pointer conversion.
  /// Does not handle virtual conversions (in case we ever fully
  /// support an ABI that allows this).  Returns null if no adjustment
  /// is required.
  
  /// Returns the adjustment, in bytes, required for the given
  /// member-pointer operation.  Returns null if no adjustment is
  /// required.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getMemberPointerAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 265,
   FQN="clang::CodeGen::CGCXXABI::getMemberPointerAdjustment", NM="_ZN5clang7CodeGen8CGCXXABI26getMemberPointerAdjustmentEPKNS_8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI26getMemberPointerAdjustmentEPKNS_8CastExprE")
  //</editor-fold>
  protected Constant /*P*/ getMemberPointerAdjustment(/*const*/ CastExpr /*P*/ E) {
    assert (E.getCastKind() == CastKind.CK_DerivedToBaseMemberPointer || E.getCastKind() == CastKind.CK_BaseToDerivedMemberPointer);
    
    QualType derivedType/*J*/= new QualType();
    if (E.getCastKind() == CastKind.CK_DerivedToBaseMemberPointer) {
      derivedType.$assignMove(E.getSubExpr$Const().getType());
    } else {
      derivedType.$assignMove(E.getType());
    }
    
    /*const*/ CXXRecordDecl /*P*/ derivedClass = derivedType.$arrow().castAs(MemberPointerType.class).__getClass().getAsCXXRecordDecl();
    
    return CGM.GetNonVirtualBaseClassOffset(derivedClass, 
        E.path_begin$Const(), 
        E.path_end$Const());
  }

  
  /// \brief Computes the non-virtual adjustment needed for a member pointer
  /// conversion along an inheritance path stored in an APValue.  Unlike
  /// getMemberPointerAdjustment(), the adjustment can be negative if the path
  /// is from a derived type to a base type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getMemberPointerPathAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 283,
   FQN="clang::CodeGen::CGCXXABI::getMemberPointerPathAdjustment", NM="_ZN5clang7CodeGen8CGCXXABI30getMemberPointerPathAdjustmentERKNS_7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI30getMemberPointerPathAdjustmentERKNS_7APValueE")
  //</editor-fold>
  protected CharUnits getMemberPointerPathAdjustment(final /*const*/ APValue /*&*/ MP) {
    // TODO: Store base specifiers in APValue member pointer paths so we can
    // easily reuse CGM.GetNonVirtualBaseClassOffset().
    /*const*/ ValueDecl /*P*/ MPD = MP.getMemberPointerDecl();
    CharUnits ThisAdjustment = CharUnits.Zero();
    ArrayRef</*const*/ CXXRecordDecl /*P*/ > Path = MP.getMemberPointerPath();
    boolean DerivedMember = MP.isMemberPointerToDerivedMember();
    /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(MPD.getDeclContext$Const());
    for (/*uint*/int I = 0, N = Path.size(); I != N; ++I) {
      type$ref</*const*/ CXXRecordDecl /*P*/ > Base = create_type$ref(RD);
      type$ref</*const*/ CXXRecordDecl /*P*/ > Derived = create_type$ref(Path.$at(I));
      if (DerivedMember) {
        std.swap(Base, Derived);
      }
      ThisAdjustment.$addassign(
          getContext().getASTRecordLayout(Derived.$deref()).getBaseClassOffset(Base.$deref())
      );
      RD = Path.$at(I);
    }
    if (DerivedMember) {
      ThisAdjustment.$assignMove(ThisAdjustment.$sub());
    }
    return ThisAdjustment;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::emitVirtualObjectDelete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 230,
   FQN="clang::CodeGen::CGCXXABI::emitVirtualObjectDelete", NM="_ZN5clang7CodeGen8CGCXXABI23emitVirtualObjectDeleteERNS0_15CodeGenFunctionEPKNS_13CXXDeleteExprENS0_7AddressENS_8QualTypeEPKNS_17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI23emitVirtualObjectDeleteERNS0_15CodeGenFunctionEPKNS_13CXXDeleteExprENS0_7AddressENS_8QualTypeEPKNS_17CXXDestructorDeclE")
  //</editor-fold>
  public abstract /*virtual*/ void emitVirtualObjectDelete(final CodeGenFunction /*&*/ CGF, 
                         /*const*/ CXXDeleteExpr /*P*/ DE, 
                         Address Ptr, QualType ElementType, 
                         /*const*/ CXXDestructorDecl /*P*/ Dtor)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::emitRethrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 234,
   FQN="clang::CodeGen::CGCXXABI::emitRethrow", NM="_ZN5clang7CodeGen8CGCXXABI11emitRethrowERNS0_15CodeGenFunctionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI11emitRethrowERNS0_15CodeGenFunctionEb")
  //</editor-fold>
  public abstract /*virtual*/ void emitRethrow(final CodeGenFunction /*&*/ CGF, boolean isNoReturn)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::emitThrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 235,
   FQN="clang::CodeGen::CGCXXABI::emitThrow", NM="_ZN5clang7CodeGen8CGCXXABI9emitThrowERNS0_15CodeGenFunctionEPKNS_12CXXThrowExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI9emitThrowERNS0_15CodeGenFunctionEPKNS_12CXXThrowExprE")
  //</editor-fold>
  public abstract /*virtual*/ void emitThrow(final CodeGenFunction /*&*/ CGF, /*const*/ CXXThrowExpr /*P*/ E)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getThrowInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 236,
   FQN="clang::CodeGen::CGCXXABI::getThrowInfo", NM="_ZN5clang7CodeGen8CGCXXABI12getThrowInfoENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI12getThrowInfoENS_8QualTypeE")
  //</editor-fold>
  public /*virtual*/ GlobalVariable /*P*/ getThrowInfo(QualType T) {
    return null;
  }

  
  /// \brief Determine whether it's possible to emit a vtable for \p RD, even
  /// though we do not know that the vtable has been marked as used by semantic
  /// analysis.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::canSpeculativelyEmitVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 241,
   FQN="clang::CodeGen::CGCXXABI::canSpeculativelyEmitVTable", NM="_ZNK5clang7CodeGen8CGCXXABI26canSpeculativelyEmitVTableEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZNK5clang7CodeGen8CGCXXABI26canSpeculativelyEmitVTableEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public abstract /*virtual*/ boolean canSpeculativelyEmitVTable(/*const*/ CXXRecordDecl /*P*/ RD) /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::emitBeginCatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 243,
   FQN="clang::CodeGen::CGCXXABI::emitBeginCatch", NM="_ZN5clang7CodeGen8CGCXXABI14emitBeginCatchERNS0_15CodeGenFunctionEPKNS_12CXXCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI14emitBeginCatchERNS0_15CodeGenFunctionEPKNS_12CXXCatchStmtE")
  //</editor-fold>
  public abstract /*virtual*/ void emitBeginCatch(final CodeGenFunction /*&*/ CGF, /*const*/ CXXCatchStmt /*P*/ C)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::emitTerminateForUnexpectedException">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 319,
   FQN="clang::CodeGen::CGCXXABI::emitTerminateForUnexpectedException", NM="_ZN5clang7CodeGen8CGCXXABI35emitTerminateForUnexpectedExceptionERNS0_15CodeGenFunctionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI35emitTerminateForUnexpectedExceptionERNS0_15CodeGenFunctionEPN4llvm5ValueE")
  //</editor-fold>
  public CallInst /*P*/ emitTerminateForUnexpectedException(final CodeGenFunction /*&*/ CGF, 
                                     Value /*P*/ Exn) {
    // Just call std::terminate and ignore the violating exception.
    return CGF.EmitNounwindRuntimeCall(CGF.CGM.getTerminateFn());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getAddrOfRTTIDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 249,
   FQN="clang::CodeGen::CGCXXABI::getAddrOfRTTIDescriptor", NM="_ZN5clang7CodeGen8CGCXXABI23getAddrOfRTTIDescriptorENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI23getAddrOfRTTIDescriptorENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ getAddrOfRTTIDescriptor(QualType Ty)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getAddrOfCXXCatchHandlerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 250,
   FQN="clang::CodeGen::CGCXXABI::getAddrOfCXXCatchHandlerType", NM="_ZN5clang7CodeGen8CGCXXABI28getAddrOfCXXCatchHandlerTypeENS_8QualTypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI28getAddrOfCXXCatchHandlerTypeENS_8QualTypeES2_")
  //</editor-fold>
  public abstract /*virtual*/ CatchTypeInfo getAddrOfCXXCatchHandlerType(QualType Ty, QualType CatchHandlerType)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getCatchAllTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 326,
   FQN="clang::CodeGen::CGCXXABI::getCatchAllTypeInfo", NM="_ZN5clang7CodeGen8CGCXXABI19getCatchAllTypeInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI19getCatchAllTypeInfoEv")
  //</editor-fold>
  public CatchTypeInfo getCatchAllTypeInfo() {
    return ((CatchTypeInfo)(new CatchTypeInfo(null, 0)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::shouldTypeidBeNullChecked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 254,
   FQN="clang::CodeGen::CGCXXABI::shouldTypeidBeNullChecked", NM="_ZN5clang7CodeGen8CGCXXABI25shouldTypeidBeNullCheckedEbNS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI25shouldTypeidBeNullCheckedEbNS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ boolean shouldTypeidBeNullChecked(boolean IsDeref, 
                           QualType SrcRecordTy)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitBadTypeidCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 256,
   FQN="clang::CodeGen::CGCXXABI::EmitBadTypeidCall", NM="_ZN5clang7CodeGen8CGCXXABI17EmitBadTypeidCallERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI17EmitBadTypeidCallERNS0_15CodeGenFunctionE")
  //</editor-fold>
  public abstract /*virtual*/ void EmitBadTypeidCall(final CodeGenFunction /*&*/ CGF)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitTypeid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 257,
   FQN="clang::CodeGen::CGCXXABI::EmitTypeid", NM="_ZN5clang7CodeGen8CGCXXABI10EmitTypeidERNS0_15CodeGenFunctionENS_8QualTypeENS0_7AddressEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI10EmitTypeidERNS0_15CodeGenFunctionENS_8QualTypeENS0_7AddressEPN4llvm4TypeE")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ EmitTypeid(final CodeGenFunction /*&*/ CGF, QualType SrcRecordTy, 
            Address ThisPtr, 
            org.llvm.ir.Type /*P*/ StdTypeInfoPtrTy)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::shouldDynamicCastCallBeNullChecked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 261,
   FQN="clang::CodeGen::CGCXXABI::shouldDynamicCastCallBeNullChecked", NM="_ZN5clang7CodeGen8CGCXXABI34shouldDynamicCastCallBeNullCheckedEbNS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI34shouldDynamicCastCallBeNullCheckedEbNS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ boolean shouldDynamicCastCallBeNullChecked(boolean SrcIsPtr, 
                                    QualType SrcRecordTy)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitDynamicCastCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 264,
   FQN="clang::CodeGen::CGCXXABI::EmitDynamicCastCall", NM="_ZN5clang7CodeGen8CGCXXABI19EmitDynamicCastCallERNS0_15CodeGenFunctionENS0_7AddressENS_8QualTypeES5_S5_PN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI19EmitDynamicCastCallERNS0_15CodeGenFunctionENS0_7AddressENS_8QualTypeES5_S5_PN4llvm10BasicBlockE")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ EmitDynamicCastCall(final CodeGenFunction /*&*/ CGF, Address Value, 
                     QualType SrcRecordTy, QualType DestTy, 
                     QualType DestRecordTy, BasicBlock /*P*/ CastEnd)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitDynamicCastToVoid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 269,
   FQN="clang::CodeGen::CGCXXABI::EmitDynamicCastToVoid", NM="_ZN5clang7CodeGen8CGCXXABI21EmitDynamicCastToVoidERNS0_15CodeGenFunctionENS0_7AddressENS_8QualTypeES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI21EmitDynamicCastToVoidERNS0_15CodeGenFunctionENS0_7AddressENS_8QualTypeES5_")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ EmitDynamicCastToVoid(final CodeGenFunction /*&*/ CGF, 
                       Address Value, 
                       QualType SrcRecordTy, 
                       QualType DestTy)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitBadCastCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 274,
   FQN="clang::CodeGen::CGCXXABI::EmitBadCastCall", NM="_ZN5clang7CodeGen8CGCXXABI15EmitBadCastCallERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI15EmitBadCastCallERNS0_15CodeGenFunctionE")
  //</editor-fold>
  public abstract /*virtual*/ boolean EmitBadCastCall(final CodeGenFunction /*&*/ CGF)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::GetVirtualBaseClassOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 276,
   FQN="clang::CodeGen::CGCXXABI::GetVirtualBaseClassOffset", NM="_ZN5clang7CodeGen8CGCXXABI25GetVirtualBaseClassOffsetERNS0_15CodeGenFunctionENS0_7AddressEPKNS_13CXXRecordDeclES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI25GetVirtualBaseClassOffsetERNS0_15CodeGenFunctionENS0_7AddressEPKNS_13CXXRecordDeclES7_")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ GetVirtualBaseClassOffset(final CodeGenFunction /*&*/ CGF, 
                           Address This, 
                           /*const*/ CXXRecordDecl /*P*/ ClassDecl, 
                           /*const*/ CXXRecordDecl /*P*/ BaseClassDecl)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitCtorCompleteObjectHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 305,
   FQN="clang::CodeGen::CGCXXABI::EmitCtorCompleteObjectHandler", NM="_ZN5clang7CodeGen8CGCXXABI29EmitCtorCompleteObjectHandlerERNS0_15CodeGenFunctionEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI29EmitCtorCompleteObjectHandlerERNS0_15CodeGenFunctionEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public BasicBlock /*P*/ EmitCtorCompleteObjectHandler(final CodeGenFunction /*&*/ CGF, 
                               /*const*/ CXXRecordDecl /*P*/ RD) {
    if (CGM.getTarget().getCXXABI().hasConstructorVariants()) {
      throw new llvm_unreachable("shouldn't be called in this ABI");
    }
    
    ErrorUnsupportedABI(CGF, new StringRef(/*KEEP_STR*/"complete object detection in ctor"));
    return null;
  }

  
  /// Emit the code to initialize hidden members required
  /// to handle virtual inheritance, if needed by the ABI.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::initializeHiddenVirtualInheritanceMembers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 286,
   FQN="clang::CodeGen::CGCXXABI::initializeHiddenVirtualInheritanceMembers", NM="_ZN5clang7CodeGen8CGCXXABI41initializeHiddenVirtualInheritanceMembersERNS0_15CodeGenFunctionEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI41initializeHiddenVirtualInheritanceMembersERNS0_15CodeGenFunctionEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public /*virtual*/ void initializeHiddenVirtualInheritanceMembers(final CodeGenFunction /*&*/ CGF, 
                                           /*const*/ CXXRecordDecl /*P*/ RD) {
  }

  
  /// Emit constructor variants required by this ABI.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitCXXConstructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 291,
   FQN="clang::CodeGen::CGCXXABI::EmitCXXConstructors", NM="_ZN5clang7CodeGen8CGCXXABI19EmitCXXConstructorsEPKNS_18CXXConstructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI19EmitCXXConstructorsEPKNS_18CXXConstructorDeclE")
  //</editor-fold>
  public abstract /*virtual*/ void EmitCXXConstructors(/*const*/ CXXConstructorDecl /*P*/ D)/* = 0*/;

  
  /// Build the signature of the given constructor or destructor variant by
  /// adding any required parameters.  For convenience, ArgTys has been
  /// initialized with the type of 'this'.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::buildStructorSignature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 296,
   FQN="clang::CodeGen::CGCXXABI::buildStructorSignature", NM="_ZN5clang7CodeGen8CGCXXABI22buildStructorSignatureEPKNS_13CXXMethodDeclENS0_12StructorTypeERN4llvm15SmallVectorImplINS_7CanQualINS_4TypeEEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI22buildStructorSignatureEPKNS_13CXXMethodDeclENS0_12StructorTypeERN4llvm15SmallVectorImplINS_7CanQualINS_4TypeEEEEE")
  //</editor-fold>
  public abstract /*virtual*/ void buildStructorSignature(/*const*/ CXXMethodDecl /*P*/ MD, StructorType T, 
                        final SmallVectorImpl<CanQual<org.clang.ast.Type> > /*&*/ ArgTys)/* = 0*/;

  
  /// Returns true if the given destructor type should be emitted as a linkonce
  /// delegating thunk, regardless of whether the dtor is defined in this TU or
  /// not.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::useThunkForDtorVariant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 302,
   FQN="clang::CodeGen::CGCXXABI::useThunkForDtorVariant", NM="_ZNK5clang7CodeGen8CGCXXABI22useThunkForDtorVariantEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZNK5clang7CodeGen8CGCXXABI22useThunkForDtorVariantEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeE")
  //</editor-fold>
  public abstract /*virtual*/ boolean useThunkForDtorVariant(/*const*/ CXXDestructorDecl /*P*/ Dtor, 
                        CXXDtorType DT) /*const*//* = 0*/;

  
  /// Emit destructor variants required by this ABI.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitCXXDestructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 306,
   FQN="clang::CodeGen::CGCXXABI::EmitCXXDestructors", NM="_ZN5clang7CodeGen8CGCXXABI18EmitCXXDestructorsEPKNS_17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI18EmitCXXDestructorsEPKNS_17CXXDestructorDeclE")
  //</editor-fold>
  public abstract /*virtual*/ void EmitCXXDestructors(/*const*/ CXXDestructorDecl /*P*/ D)/* = 0*/;

  
  /// Get the type of the implicit "this" parameter used by a method. May return
  /// zero if no specific type is applicable, e.g. if the ABI expects the "this"
  /// parameter to point to some artificial offset in a complete object due to
  /// vbases being reordered.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getThisArgumentTypeForMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 312,
   FQN="clang::CodeGen::CGCXXABI::getThisArgumentTypeForMethod", NM="_ZN5clang7CodeGen8CGCXXABI28getThisArgumentTypeForMethodEPKNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI28getThisArgumentTypeForMethodEPKNS_13CXXMethodDeclE")
  //</editor-fold>
  public /*virtual*/ /*const*/ CXXRecordDecl /*P*/ getThisArgumentTypeForMethod(/*const*/ CXXMethodDecl /*P*/ MD) {
    return MD.getParent$Const();
  }

  
  /// Perform ABI-specific "this" argument adjustment required prior to
  /// a call of a virtual function.
  /// The "VirtualCall" argument is true iff the call itself is virtual.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::adjustThisArgumentForVirtualFunctionCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 320,
   FQN="clang::CodeGen::CGCXXABI::adjustThisArgumentForVirtualFunctionCall", NM="_ZN5clang7CodeGen8CGCXXABI40adjustThisArgumentForVirtualFunctionCallERNS0_15CodeGenFunctionENS_10GlobalDeclENS0_7AddressEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI40adjustThisArgumentForVirtualFunctionCallERNS0_15CodeGenFunctionENS_10GlobalDeclENS0_7AddressEb")
  //</editor-fold>
  public /*virtual*/ Address adjustThisArgumentForVirtualFunctionCall(final CodeGenFunction /*&*/ CGF, GlobalDecl GD, 
                                          Address This, boolean VirtualCall) {
    return new Address(JD$Move.INSTANCE, This);
  }

  
  /// Build a parameter variable suitable for 'this'.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::buildThisParam">
  @Converted(kind = Converted.Kind.MANUAL,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 156,
   FQN="clang::CodeGen::CGCXXABI::buildThisParam", NM="_ZN5clang7CodeGen8CGCXXABI14buildThisParamERNS0_15CodeGenFunctionERNS0_15FunctionArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI14buildThisParamERNS0_15CodeGenFunctionERNS0_15FunctionArgListE")
  //</editor-fold>
  public void buildThisParam(final CodeGenFunction /*&*/ CGF, final FunctionArgList /*&*/ params) {
    /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(CGF.CurGD.getDecl());
    
    // FIXME: I'm not entirely sure I like using a fake decl just for code
    // generation. Maybe we can come up with a better way?
    ImplicitParamDecl /*P*/ ThisDecl = ImplicitParamDecl.Create(CGM.getContext(), (DeclContext /*P*/ )null, MD.getLocation(), 
        $AddrOf(CGM.getContext().Idents.get($this.$array(), $this.$index(), std.strlen($this))), 
        MD.getThisType(CGM.getContext()));
    params.push_back(ThisDecl);
    CGF.CXXABIThisDecl = ThisDecl;
    
    // Compute the presumed alignment of 'this', which basically comes
    // down to whether we know it's a complete object or not.
    final /*const*/ ASTRecordLayout /*&*/ Layout = CGF.getContext().getASTRecordLayout(MD.getParent$Const());
    if (MD.getParent$Const().getNumVBases() == 0 // avoid vcall in common case
       || MD.getParent$Const().hasAttr(FinalAttr.class)
       || !isThisCompleteObject(new GlobalDecl(CGF.CurGD))) {
      CGF.CXXABIThisAlignment.$assignMove(Layout.getAlignment());
    } else {
      CGF.CXXABIThisAlignment.$assignMove(Layout.getNonVirtualAlignment());
    }
  }

  
  /// Insert any ABI-specific implicit parameters into the parameter list for a
  /// function.  This generally involves extra data for constructors and
  /// destructors.
  ///
  /// ABIs may also choose to override the return type, which has been
  /// initialized with the type of 'this' if HasThisReturn(CGF.CurGD) is true or
  /// the formal return type of the function otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::addImplicitStructorParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 336,
   FQN="clang::CodeGen::CGCXXABI::addImplicitStructorParams", NM="_ZN5clang7CodeGen8CGCXXABI25addImplicitStructorParamsERNS0_15CodeGenFunctionERNS_8QualTypeERNS0_15FunctionArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI25addImplicitStructorParamsERNS0_15CodeGenFunctionERNS_8QualTypeERNS0_15FunctionArgListE")
  //</editor-fold>
  public abstract /*virtual*/ void addImplicitStructorParams(final CodeGenFunction /*&*/ CGF, final QualType /*&*/ ResTy, 
                           final FunctionArgList /*&*/ Params)/* = 0*/;

  
  /// Get the ABI-specific "this" parameter adjustment to apply in the prologue
  /// of a virtual function.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getVirtualFunctionPrologueThisAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 341,
   FQN="clang::CodeGen::CGCXXABI::getVirtualFunctionPrologueThisAdjustment", NM="_ZN5clang7CodeGen8CGCXXABI40getVirtualFunctionPrologueThisAdjustmentENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI40getVirtualFunctionPrologueThisAdjustmentENS_10GlobalDeclE")
  //</editor-fold>
  public /*virtual*/ CharUnits getVirtualFunctionPrologueThisAdjustment(GlobalDecl GD) {
    return CharUnits.Zero();
  }

  
  /// Perform ABI-specific "this" parameter adjustment in a virtual function
  /// prologue.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::adjustThisParameterInVirtualFunctionPrologue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 347,
   FQN="clang::CodeGen::CGCXXABI::adjustThisParameterInVirtualFunctionPrologue", NM="_ZN5clang7CodeGen8CGCXXABI44adjustThisParameterInVirtualFunctionPrologueERNS0_15CodeGenFunctionENS_10GlobalDeclEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI44adjustThisParameterInVirtualFunctionPrologueERNS0_15CodeGenFunctionENS_10GlobalDeclEPN4llvm5ValueE")
  //</editor-fold>
  public /*virtual*/ Value /*P*/ adjustThisParameterInVirtualFunctionPrologue(final CodeGenFunction /*&*/ CGF, GlobalDecl GD, Value /*P*/ This) {
    return This;
  }

  
  /// Emit the ABI-specific prolog for the function.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitInstanceFunctionProlog">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 353,
   FQN="clang::CodeGen::CGCXXABI::EmitInstanceFunctionProlog", NM="_ZN5clang7CodeGen8CGCXXABI26EmitInstanceFunctionPrologERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI26EmitInstanceFunctionPrologERNS0_15CodeGenFunctionE")
  //</editor-fold>
  public abstract /*virtual*/ void EmitInstanceFunctionProlog(final CodeGenFunction /*&*/ CGF)/* = 0*/;

  
  /// Add any ABI-specific implicit arguments needed to call a constructor.
  ///
  /// \return The number of args added to the call, which is typically zero or
  /// one.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::addImplicitConstructorArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 359,
   FQN="clang::CodeGen::CGCXXABI::addImplicitConstructorArgs", NM="_ZN5clang7CodeGen8CGCXXABI26addImplicitConstructorArgsERNS0_15CodeGenFunctionEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEbbRNS0_11CallArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI26addImplicitConstructorArgsERNS0_15CodeGenFunctionEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEbbRNS0_11CallArgListE")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int addImplicitConstructorArgs(final CodeGenFunction /*&*/ CGF, /*const*/ CXXConstructorDecl /*P*/ D, 
                            CXXCtorType Type, boolean ForVirtualBase, 
                            boolean Delegating, final CallArgList /*&*/ Args)/* = 0*/;

  
  /// Emit the destructor call.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitDestructorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 365,
   FQN="clang::CodeGen::CGCXXABI::EmitDestructorCall", NM="_ZN5clang7CodeGen8CGCXXABI18EmitDestructorCallERNS0_15CodeGenFunctionEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeEbbNS0_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI18EmitDestructorCallERNS0_15CodeGenFunctionEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeEbbNS0_7AddressE")
  //</editor-fold>
  public abstract /*virtual*/ void EmitDestructorCall(final CodeGenFunction /*&*/ CGF, 
                    /*const*/ CXXDestructorDecl /*P*/ DD, CXXDtorType Type, 
                    boolean ForVirtualBase, boolean Delegating, 
                    Address This)/* = 0*/;

  
  /// Emits the VTable definitions required for the given record type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::emitVTableDefinitions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 371,
   FQN="clang::CodeGen::CGCXXABI::emitVTableDefinitions", NM="_ZN5clang7CodeGen8CGCXXABI21emitVTableDefinitionsERNS0_14CodeGenVTablesEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI21emitVTableDefinitionsERNS0_14CodeGenVTablesEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public abstract /*virtual*/ void emitVTableDefinitions(final CodeGenVTables /*&*/ CGVT, 
                       /*const*/ CXXRecordDecl /*P*/ RD)/* = 0*/;

  
  /// Checks if ABI requires extra virtual offset for vtable field.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::isVirtualOffsetNeededForVTableField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 375,
   FQN="clang::CodeGen::CGCXXABI::isVirtualOffsetNeededForVTableField", NM="_ZN5clang7CodeGen8CGCXXABI35isVirtualOffsetNeededForVTableFieldERNS0_15CodeGenFunctionENS2_4VPtrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI35isVirtualOffsetNeededForVTableFieldERNS0_15CodeGenFunctionENS2_4VPtrE")
  //</editor-fold>
  public abstract /*virtual*/ boolean isVirtualOffsetNeededForVTableField(final CodeGenFunction /*&*/ CGF, 
                                     CodeGenFunction.VPtr Vptr)/* = 0*/;

  
  /// Checks if ABI requires to initilize vptrs for given dynamic class.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::doStructorsInitializeVPtrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 380,
   FQN="clang::CodeGen::CGCXXABI::doStructorsInitializeVPtrs", NM="_ZN5clang7CodeGen8CGCXXABI26doStructorsInitializeVPtrsEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI26doStructorsInitializeVPtrsEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public abstract /*virtual*/ boolean doStructorsInitializeVPtrs(/*const*/ CXXRecordDecl /*P*/ VTableClass)/* = 0*/;

  
  /// Get the address point of the vtable for the given base subobject.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getVTableAddressPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 383,
   FQN="clang::CodeGen::CGCXXABI::getVTableAddressPoint", NM="_ZN5clang7CodeGen8CGCXXABI21getVTableAddressPointENS_13BaseSubobjectEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI21getVTableAddressPointENS_13BaseSubobjectEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ getVTableAddressPoint(BaseSubobject Base, 
                       /*const*/ CXXRecordDecl /*P*/ VTableClass)/* = 0*/;

  
  /// Get the address point of the vtable for the given base subobject while
  /// building a constructor or a destructor.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getVTableAddressPointInStructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 389,
   FQN="clang::CodeGen::CGCXXABI::getVTableAddressPointInStructor", NM="_ZN5clang7CodeGen8CGCXXABI31getVTableAddressPointInStructorERNS0_15CodeGenFunctionEPKNS_13CXXRecordDeclENS_13BaseSubobjectES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI31getVTableAddressPointInStructorERNS0_15CodeGenFunctionEPKNS_13CXXRecordDeclENS_13BaseSubobjectES6_")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ getVTableAddressPointInStructor(final CodeGenFunction /*&*/ CGF, /*const*/ CXXRecordDecl /*P*/ RD, 
                                 BaseSubobject Base, 
                                 /*const*/ CXXRecordDecl /*P*/ NearestVBase)/* = 0*/;

  
  /// Get the address point of the vtable for the given base subobject while
  /// building a constexpr.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getVTableAddressPointForConstExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 396,
   FQN="clang::CodeGen::CGCXXABI::getVTableAddressPointForConstExpr", NM="_ZN5clang7CodeGen8CGCXXABI33getVTableAddressPointForConstExprENS_13BaseSubobjectEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI33getVTableAddressPointForConstExprENS_13BaseSubobjectEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ getVTableAddressPointForConstExpr(BaseSubobject Base, 
                                   /*const*/ CXXRecordDecl /*P*/ VTableClass)/* = 0*/;

  
  /// Get the address of the vtable for the given record decl which should be
  /// used for the vptr at the given offset in RD.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getAddrOfVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 402,
   FQN="clang::CodeGen::CGCXXABI::getAddrOfVTable", NM="_ZN5clang7CodeGen8CGCXXABI15getAddrOfVTableEPKNS_13CXXRecordDeclENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI15getAddrOfVTableEPKNS_13CXXRecordDeclENS_9CharUnitsE")
  //</editor-fold>
  public abstract /*virtual*/ GlobalVariable /*P*/ getAddrOfVTable(/*const*/ CXXRecordDecl /*P*/ RD, 
                 CharUnits VPtrOffset)/* = 0*/;

  
  /// Build a virtual function pointer in the ABI-specific way.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getVirtualFunctionPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 406,
   FQN="clang::CodeGen::CGCXXABI::getVirtualFunctionPointer", NM="_ZN5clang7CodeGen8CGCXXABI25getVirtualFunctionPointerERNS0_15CodeGenFunctionENS_10GlobalDeclENS0_7AddressEPN4llvm4TypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI25getVirtualFunctionPointerERNS0_15CodeGenFunctionENS_10GlobalDeclENS0_7AddressEPN4llvm4TypeENS_14SourceLocationE")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ getVirtualFunctionPointer(final CodeGenFunction /*&*/ CGF, 
                           GlobalDecl GD, 
                           Address This, 
                           org.llvm.ir.Type /*P*/ Ty, 
                           SourceLocation Loc)/* = 0*/;

  
  /// Emit the ABI-specific virtual destructor call.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitVirtualDestructorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 413,
   FQN="clang::CodeGen::CGCXXABI::EmitVirtualDestructorCall", NM="_ZN5clang7CodeGen8CGCXXABI25EmitVirtualDestructorCallERNS0_15CodeGenFunctionEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeENS0_7AddressEPKNS_17CXXMemberCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI25EmitVirtualDestructorCallERNS0_15CodeGenFunctionEPKNS_17CXXDestructorDeclENS_11CXXDtorTypeENS0_7AddressEPKNS_17CXXMemberCallExprE")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ EmitVirtualDestructorCall(final CodeGenFunction /*&*/ CGF, /*const*/ CXXDestructorDecl /*P*/ Dtor, 
                           CXXDtorType DtorType, Address This, 
                           /*const*/ CXXMemberCallExpr /*P*/ CE)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::adjustCallArgsForDestructorThunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 418,
   FQN="clang::CodeGen::CGCXXABI::adjustCallArgsForDestructorThunk", NM="_ZN5clang7CodeGen8CGCXXABI32adjustCallArgsForDestructorThunkERNS0_15CodeGenFunctionENS_10GlobalDeclERNS0_11CallArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI32adjustCallArgsForDestructorThunkERNS0_15CodeGenFunctionENS_10GlobalDeclERNS0_11CallArgListE")
  //</editor-fold>
  public /*virtual*/ void adjustCallArgsForDestructorThunk(final CodeGenFunction /*&*/ CGF, 
                                  GlobalDecl GD, 
                                  final CallArgList /*&*/ CallArgs) {
  }

  
  /// Emit any tables needed to implement virtual inheritance.  For Itanium,
  /// this emits virtual table tables.  For the MSVC++ ABI, this emits virtual
  /// base tables.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::emitVirtualInheritanceTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 425,
   FQN="clang::CodeGen::CGCXXABI::emitVirtualInheritanceTables", NM="_ZN5clang7CodeGen8CGCXXABI28emitVirtualInheritanceTablesEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI28emitVirtualInheritanceTablesEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public abstract /*virtual*/ void emitVirtualInheritanceTables(/*const*/ CXXRecordDecl /*P*/ RD)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::setThunkLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 427,
   FQN="clang::CodeGen::CGCXXABI::setThunkLinkage", NM="_ZN5clang7CodeGen8CGCXXABI15setThunkLinkageEPN4llvm8FunctionEbNS_10GlobalDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI15setThunkLinkageEPN4llvm8FunctionEbNS_10GlobalDeclEb")
  //</editor-fold>
  public abstract /*virtual*/ void setThunkLinkage(Function /*P*/ Thunk, boolean ForVTable, 
                 GlobalDecl GD, boolean ReturnAdjustment)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::performThisAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 430,
   FQN="clang::CodeGen::CGCXXABI::performThisAdjustment", NM="_ZN5clang7CodeGen8CGCXXABI21performThisAdjustmentERNS0_15CodeGenFunctionENS0_7AddressERKNS_14ThisAdjustmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI21performThisAdjustmentERNS0_15CodeGenFunctionENS0_7AddressERKNS_14ThisAdjustmentE")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ performThisAdjustment(final CodeGenFunction /*&*/ CGF, 
                       Address This, 
                       final /*const*/ ThisAdjustment /*&*/ TA)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::performReturnAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 434,
   FQN="clang::CodeGen::CGCXXABI::performReturnAdjustment", NM="_ZN5clang7CodeGen8CGCXXABI23performReturnAdjustmentERNS0_15CodeGenFunctionENS0_7AddressERKNS_16ReturnAdjustmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI23performReturnAdjustmentERNS0_15CodeGenFunctionENS0_7AddressERKNS_16ReturnAdjustmentE")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ performReturnAdjustment(final CodeGenFunction /*&*/ CGF, 
                         Address Ret, 
                         final /*const*/ ReturnAdjustment /*&*/ RA)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitReturnFromThunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 188,
   FQN="clang::CodeGen::CGCXXABI::EmitReturnFromThunk", NM="_ZN5clang7CodeGen8CGCXXABI19EmitReturnFromThunkERNS0_15CodeGenFunctionENS0_6RValueENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI19EmitReturnFromThunkERNS0_15CodeGenFunctionENS0_6RValueENS_8QualTypeE")
  //</editor-fold>
  public void EmitReturnFromThunk(final CodeGenFunction /*&*/ CGF, 
                     RValue RV, QualType ResultType) {
    CGF.EmitReturnOfRValue(new RValue(RV), new QualType(ResultType));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getSrcArgforCopyCtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 441,
   FQN="clang::CodeGen::CGCXXABI::getSrcArgforCopyCtor", NM="_ZNK5clang7CodeGen8CGCXXABI20getSrcArgforCopyCtorEPKNS_18CXXConstructorDeclERNS0_15FunctionArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZNK5clang7CodeGen8CGCXXABI20getSrcArgforCopyCtorEPKNS_18CXXConstructorDeclERNS0_15FunctionArgListE")
  //</editor-fold>
  public abstract /*virtual*/ /*size_t*/int getSrcArgforCopyCtor(/*const*/ CXXConstructorDecl /*P*/ $Prm0, 
                      final FunctionArgList /*&*/ Args) /*const*//* = 0*/;

  
  /// Gets the offsets of all the virtual base pointers in a given class.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getVBPtrOffsets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 330,
   FQN="clang::CodeGen::CGCXXABI::getVBPtrOffsets", NM="_ZN5clang7CodeGen8CGCXXABI15getVBPtrOffsetsEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI15getVBPtrOffsetsEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public std.vector<CharUnits> getVBPtrOffsets(/*const*/ CXXRecordDecl /*P*/ RD) {
    return new std.vector<CharUnits>(new CharUnits());
  }

  
  /// Gets the pure virtual member call function.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::GetPureVirtualCallName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 448,
   FQN="clang::CodeGen::CGCXXABI::GetPureVirtualCallName", NM="_ZN5clang7CodeGen8CGCXXABI22GetPureVirtualCallNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI22GetPureVirtualCallNameEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef GetPureVirtualCallName()/* = 0*/;

  
  /// Gets the deleted virtual member call name.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::GetDeletedVirtualCallName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 451,
   FQN="clang::CodeGen::CGCXXABI::GetDeletedVirtualCallName", NM="_ZN5clang7CodeGen8CGCXXABI25GetDeletedVirtualCallNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI25GetDeletedVirtualCallNameEv")
  //</editor-fold>
  public abstract /*virtual*/ StringRef GetDeletedVirtualCallName()/* = 0*/;

  
  /**************************** Array cookies ******************************/
  
  /// Returns the extra size required in order to store the array
  /// cookie for the given new-expression.  May return 0 to indicate that no
  /// array cookie is required.
  ///
  /// Several cases are filtered out before this method is called:
  ///   - non-array allocations never need a cookie
  ///   - calls to \::operator new(size_t, void*) never need a cookie
  ///
  /// \param expr - the new-expression being allocated.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::GetArrayCookieSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 193,
   FQN="clang::CodeGen::CGCXXABI::GetArrayCookieSize", NM="_ZN5clang7CodeGen8CGCXXABI18GetArrayCookieSizeEPKNS_10CXXNewExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI18GetArrayCookieSizeEPKNS_10CXXNewExprE")
  //</editor-fold>
  public CharUnits GetArrayCookieSize(/*const*/ CXXNewExpr /*P*/ expr) {
    if (!requiresArrayCookie(expr)) {
      return CharUnits.Zero();
    }
    return getArrayCookieSizeImpl(expr.getAllocatedType());
  }

  
  /// Initialize the array cookie for the given allocation.
  ///
  /// \param NewPtr - a char* which is the presumed-non-null
  ///   return value of the allocation function
  /// \param NumElements - the computed number of elements,
  ///   potentially collapsed from the multidimensional array case;
  ///   always a size_t
  /// \param ElementType - the base element allocated type,
  ///   i.e. the allocated type after stripping all array types
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::InitializeArrayCookie">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 204,
   FQN="clang::CodeGen::CGCXXABI::InitializeArrayCookie", NM="_ZN5clang7CodeGen8CGCXXABI21InitializeArrayCookieERNS0_15CodeGenFunctionENS0_7AddressEPN4llvm5ValueEPKNS_10CXXNewExprENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI21InitializeArrayCookieERNS0_15CodeGenFunctionENS0_7AddressEPN4llvm5ValueEPKNS_10CXXNewExprENS_8QualTypeE")
  //</editor-fold>
  public Address InitializeArrayCookie(final CodeGenFunction /*&*/ CGF, 
                       Address NewPtr, 
                       Value /*P*/ NumElements, 
                       /*const*/ CXXNewExpr /*P*/ expr, 
                       QualType ElementType) {
    // Should never be called.
    ErrorUnsupportedABI(CGF, new StringRef(/*KEEP_STR*/"array cookie initialization"));
    return Address.invalid();
  }

  
  /// Reads the array cookie associated with the given pointer,
  /// if it has one.
  ///
  /// \param Ptr - a pointer to the first element in the array
  /// \param ElementType - the base element type of elements of the array
  /// \param NumElements - an out parameter which will be initialized
  ///   with the number of elements allocated, or zero if there is no
  ///   cookie
  /// \param AllocPtr - an out parameter which will be initialized
  ///   with a char* pointing to the address returned by the allocation
  ///   function
  /// \param CookieSize - an out parameter which will be initialized
  ///   with the size of the cookie, or zero if there is no cookie
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::ReadArrayCookie">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 233,
   FQN="clang::CodeGen::CGCXXABI::ReadArrayCookie", NM="_ZN5clang7CodeGen8CGCXXABI15ReadArrayCookieERNS0_15CodeGenFunctionENS0_7AddressEPKNS_13CXXDeleteExprENS_8QualTypeERPN4llvm5ValueESC_RNS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI15ReadArrayCookieERNS0_15CodeGenFunctionENS0_7AddressEPKNS_13CXXDeleteExprENS_8QualTypeERPN4llvm5ValueESC_RNS_9CharUnitsE")
  //</editor-fold>
  public void ReadArrayCookie(final CodeGenFunction /*&*/ CGF, Address ptr, 
                 /*const*/ CXXDeleteExpr /*P*/ expr, QualType eltTy, 
                 final type$ref<Value /*P*/ /*&*/> numElements, 
                 final type$ref<Value /*P*/ /*&*/> allocPtr, final CharUnits /*&*/ cookieSize) {
    // Derive a char* in the same address space as the pointer.
    ptr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(ptr), CGF.Int8Ty));
    
    // If we don't need an array cookie, bail out early.
    if (!requiresArrayCookie(expr, new QualType(eltTy))) {
      allocPtr.$set(ptr.getPointer());
      numElements.$set(null);
      cookieSize.$assignMove(CharUnits.Zero());
      return;
    }
    
    cookieSize.$assignMove(getArrayCookieSizeImpl(new QualType(eltTy)));
    Address allocAddr = CGF.Builder.CreateConstInBoundsByteGEP(new Address(ptr), cookieSize.$sub());
    allocPtr.$set(allocAddr.getPointer());
    numElements.$set(readArrayCookieImpl(CGF, new Address(allocAddr), new CharUnits(cookieSize)));
  }

  
  /// Return whether the given global decl needs a VTT parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::NeedsVTTParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 315,
   FQN="clang::CodeGen::CGCXXABI::NeedsVTTParameter", NM="_ZN5clang7CodeGen8CGCXXABI17NeedsVTTParameterENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI17NeedsVTTParameterENS_10GlobalDeclE")
  //</editor-fold>
  public boolean NeedsVTTParameter(GlobalDecl GD) {
    return false;
  }

/*protected:*/
  /// Returns the extra size required in order to store the array
  /// cookie for the given type.  Assumes that an array cookie is
  /// required.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::getArrayCookieSizeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 199,
   FQN="clang::CodeGen::CGCXXABI::getArrayCookieSizeImpl", NM="_ZN5clang7CodeGen8CGCXXABI22getArrayCookieSizeImplENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI22getArrayCookieSizeImplENS_8QualTypeE")
  //</editor-fold>
  protected CharUnits getArrayCookieSizeImpl(QualType elementType) {
    // BOGUS
    return CharUnits.Zero();
  }

  
  /// Reads the array cookie for an allocation which is known to have one.
  /// This is called by the standard implementation of ReadArrayCookie.
  ///
  /// \param ptr - a pointer to the allocation made for an array, as a char*
  /// \param cookieSize - the computed cookie size of an array
  ///
  /// Other parameters are as above.
  ///
  /// \return a size_t
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::readArrayCookieImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp", line = 255,
   FQN="clang::CodeGen::CGCXXABI::readArrayCookieImpl", NM="_ZN5clang7CodeGen8CGCXXABI19readArrayCookieImplERNS0_15CodeGenFunctionENS0_7AddressENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI19readArrayCookieImplERNS0_15CodeGenFunctionENS0_7AddressENS_9CharUnitsE")
  //</editor-fold>
  protected Value /*P*/ readArrayCookieImpl(final CodeGenFunction /*&*/ CGF, 
                     Address ptr, 
                     CharUnits cookieSize) {
    ErrorUnsupportedABI(CGF, new StringRef(/*KEEP_STR*/"reading a new[] cookie"));
    return ConstantInt.get(CGF.Unnamed_field8.SizeTy, $int2ulong(0));
  }

/*public:*/
  
  /*************************** Static local guards ****************************/
  
  /// Emits the guarded initializer and destructor setup for the given
  /// variable, given that it couldn't be emitted as a constant.
  /// If \p PerformInit is false, the initialization has been folded to a
  /// constant and should not be performed.
  ///
  /// The variable may be:
  ///   - a static local variable
  ///   - a static data member of a class template instantiation
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitGuardedInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 532,
   FQN="clang::CodeGen::CGCXXABI::EmitGuardedInit", NM="_ZN5clang7CodeGen8CGCXXABI15EmitGuardedInitERNS0_15CodeGenFunctionERKNS_7VarDeclEPN4llvm14GlobalVariableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI15EmitGuardedInitERNS0_15CodeGenFunctionERKNS_7VarDeclEPN4llvm14GlobalVariableEb")
  //</editor-fold>
  public abstract /*virtual*/ void EmitGuardedInit(final CodeGenFunction /*&*/ CGF, final /*const*/ VarDecl /*&*/ D, 
                 GlobalVariable /*P*/ DeclPtr, 
                 boolean PerformInit)/* = 0*/;

  
  /// Emit code to force the execution of a destructor during global
  /// teardown.  The default implementation of this uses atexit.
  ///
  /// \param Dtor - a function taking a single pointer argument
  /// \param Addr - a pointer to pass to the destructor function.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::registerGlobalDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 541,
   FQN="clang::CodeGen::CGCXXABI::registerGlobalDtor", NM="_ZN5clang7CodeGen8CGCXXABI18registerGlobalDtorERNS0_15CodeGenFunctionERKNS_7VarDeclEPN4llvm8ConstantES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI18registerGlobalDtorERNS0_15CodeGenFunctionERKNS_7VarDeclEPN4llvm8ConstantES9_")
  //</editor-fold>
  public abstract /*virtual*/ void registerGlobalDtor(final CodeGenFunction /*&*/ CGF, final /*const*/ VarDecl /*&*/ D, 
                    Constant /*P*/ Dtor, 
                    Constant /*P*/ Addr)/* = 0*/;

  
  /*************************** thread_local initialization ********************/
  
  /// Emits ABI-required functions necessary to initialize thread_local
  /// variables in this translation unit.
  ///
  /// \param CXXThreadLocals - The thread_local declarations in this translation
  ///        unit.
  /// \param CXXThreadLocalInits - If this translation unit contains any
  ///        non-constant initialization or non-trivial destruction for
  ///        thread_local variables, a list of functions to perform the
  ///        initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitThreadLocalInitFuncs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 556,
   FQN="clang::CodeGen::CGCXXABI::EmitThreadLocalInitFuncs", NM="_ZN5clang7CodeGen8CGCXXABI24EmitThreadLocalInitFuncsERNS0_13CodeGenModuleEN4llvm8ArrayRefIPKNS_7VarDeclEEENS5_IPNS4_8FunctionEEES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI24EmitThreadLocalInitFuncsERNS0_13CodeGenModuleEN4llvm8ArrayRefIPKNS_7VarDeclEEENS5_IPNS4_8FunctionEEES9_")
  //</editor-fold>
  public abstract /*virtual*/ void EmitThreadLocalInitFuncs(final CodeGenModule /*&*/ CGM, ArrayRef</*const*/ VarDecl /*P*/ > CXXThreadLocals, 
                          ArrayRef<Function /*P*/ > CXXThreadLocalInits, 
                          ArrayRef</*const*/ VarDecl /*P*/ > CXXThreadLocalInitVars)/* = 0*/;

  
  // Determine if references to thread_local global variables can be made
  // directly or require access through a thread wrapper function.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::usesThreadWrapperFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 563,
   FQN="clang::CodeGen::CGCXXABI::usesThreadWrapperFunction", NM="_ZNK5clang7CodeGen8CGCXXABI25usesThreadWrapperFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZNK5clang7CodeGen8CGCXXABI25usesThreadWrapperFunctionEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean usesThreadWrapperFunction() /*const*//* = 0*/;

  
  /// Emit a reference to a non-local thread_local variable (including
  /// triggering the initialization of all thread_local variables in its
  /// translation unit).
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::EmitThreadLocalVarDeclLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 568,
   FQN="clang::CodeGen::CGCXXABI::EmitThreadLocalVarDeclLValue", NM="_ZN5clang7CodeGen8CGCXXABI28EmitThreadLocalVarDeclLValueERNS0_15CodeGenFunctionEPKNS_7VarDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI28EmitThreadLocalVarDeclLValueERNS0_15CodeGenFunctionEPKNS_7VarDeclENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ LValue EmitThreadLocalVarDeclLValue(final CodeGenFunction /*&*/ CGF, 
                              /*const*/ VarDecl /*P*/ VD, 
                              QualType LValType)/* = 0*/;

  
  /// Emit a single constructor/destructor with the given type from a C++
  /// constructor Decl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCXXABI::emitCXXStructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.h", line = 574,
   FQN="clang::CodeGen::CGCXXABI::emitCXXStructor", NM="_ZN5clang7CodeGen8CGCXXABI15emitCXXStructorEPKNS_13CXXMethodDeclENS0_12StructorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXXABI.cpp -nm=_ZN5clang7CodeGen8CGCXXABI15emitCXXStructorEPKNS_13CXXMethodDeclENS0_12StructorTypeE")
  //</editor-fold>
  public abstract /*virtual*/ void emitCXXStructor(/*const*/ CXXMethodDecl /*P*/ MD, StructorType Type)/* = 0*/;

  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", MangleCtx=" + "[Unique_ptr$MangleContext]"; // NOI18N
  }
}
