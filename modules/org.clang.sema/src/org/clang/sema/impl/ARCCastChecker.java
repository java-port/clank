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

package org.clang.sema.impl;

import org.clank.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.analysis.domainspecific.ento.coreFoundation;
import static org.clang.sema.impl.SemaExprObjCStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// A checker which white-lists certain expressions whose conversion
/// to or from retainable type would otherwise be forbidden in ARC.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3160,
 FQN="(anonymous namespace)::ARCCastChecker", NM="_ZN12_GLOBAL__N_114ARCCastCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastCheckerE")
//</editor-fold>
public class ARCCastChecker implements /*public*/ StmtVisitor<ARCCastChecker, ACCResult> {
  /*typedef StmtVisitor<ARCCastChecker, ACCResult> super*/
//  public final class super extends StmtVisitor<ARCCastChecker, ACCResult>{ };
  
  private final ASTContext /*&*/ Context;
  private ARCConversionTypeClass SourceClass;
  private ARCConversionTypeClass TargetClass;
  private boolean Diagnose;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::isCFType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3168,
   FQN="(anonymous namespace)::ARCCastChecker::isCFType", NM="_ZN12_GLOBAL__N_114ARCCastChecker8isCFTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker8isCFTypeEN5clang8QualTypeE")
  //</editor-fold>
  private static boolean isCFType(QualType type) {
    // Someday this can use ns_bridged.  For now, it has to do this.
    return type.$arrow().isCARCBridgableType();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::ARCCastChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3174,
   FQN="(anonymous namespace)::ARCCastChecker::ARCCastChecker", NM="_ZN12_GLOBAL__N_114ARCCastCheckerC1ERN5clang10ASTContextE22ARCConversionTypeClassS4_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastCheckerC1ERN5clang10ASTContextE22ARCConversionTypeClassS4_b")
  //</editor-fold>
  public ARCCastChecker(final ASTContext /*&*/ Context, ARCConversionTypeClass source, 
      ARCConversionTypeClass target, boolean diagnose) {
    // : StmtVisitor<ARCCastChecker, ACCResult>(), Context(Context), SourceClass(source), TargetClass(target), Diagnose(diagnose) 
    //START JInit
    $StmtVisitor();
    this./*&*/Context=/*&*/Context;
    this.SourceClass = source;
    this.TargetClass = target;
    this.Diagnose = diagnose;
    //END JInit
  }

  
  //JAVA: using StmtVisitor<ARCCastChecker, ACCResult>::Visit;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::Visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3180,
   FQN="(anonymous namespace)::ARCCastChecker::Visit", NM="_ZN12_GLOBAL__N_114ARCCastChecker5VisitEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker5VisitEPN5clang4ExprE")
  //</editor-fold>
  public ACCResult Visit(Expr /*P*/ e) {
    return StmtVisitor.super.Visit(e.IgnoreParens());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3184,
   FQN="(anonymous namespace)::ARCCastChecker::VisitStmt", NM="_ZN12_GLOBAL__N_114ARCCastChecker9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public ACCResult VisitStmt(Stmt /*P*/ s) {
    return ACCResult.ACC_invalid;
  }

  
  /// Null pointer constants can be casted however you please.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::VisitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3189,
   FQN="(anonymous namespace)::ARCCastChecker::VisitExpr", NM="_ZN12_GLOBAL__N_114ARCCastChecker9VisitExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker9VisitExprEPN5clang4ExprE")
  //</editor-fold>
  public ACCResult VisitExpr(Expr /*P*/ e) {
    if ((e.isNullPointerConstant(Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull).getValue() != 0)) {
      return ACCResult.ACC_bottom;
    }
    return ACCResult.ACC_invalid;
  }

  
  /// Objective-C string literals can be safely casted.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::VisitObjCStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3196,
   FQN="(anonymous namespace)::ARCCastChecker::VisitObjCStringLiteral", NM="_ZN12_GLOBAL__N_114ARCCastChecker22VisitObjCStringLiteralEPN5clang17ObjCStringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker22VisitObjCStringLiteralEPN5clang17ObjCStringLiteralE")
  //</editor-fold>
  public ACCResult VisitObjCStringLiteral(ObjCStringLiteral /*P*/ e) {
    // If we're casting to any retainable type, go ahead.  Global
    // strings are immune to retains, so this is bottom.
    if (isAnyRetainable(TargetClass)) {
      return ACCResult.ACC_bottom;
    }
    
    return ACCResult.ACC_invalid;
  }

  
  /// Look through certain implicit and explicit casts.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3205,
   FQN="(anonymous namespace)::ARCCastChecker::VisitCastExpr", NM="_ZN12_GLOBAL__N_114ARCCastChecker13VisitCastExprEPN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker13VisitCastExprEPN5clang8CastExprE")
  //</editor-fold>
  public ACCResult VisitCastExpr(CastExpr /*P*/ e) {
    switch (e.getCastKind()) {
     case CK_NullToPointer:
      return ACCResult.ACC_bottom;
     case CK_NoOp:
     case CK_LValueToRValue:
     case CK_BitCast:
     case CK_CPointerToObjCPointerCast:
     case CK_BlockPointerToObjCPointerCast:
     case CK_AnyPointerToBlockPointerCast:
      return Visit(e.getSubExpr());
     default:
      return ACCResult.ACC_invalid;
    }
  }

  
  /// Look through unary extension.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::VisitUnaryExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3224,
   FQN="(anonymous namespace)::ARCCastChecker::VisitUnaryExtension", NM="_ZN12_GLOBAL__N_114ARCCastChecker19VisitUnaryExtensionEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker19VisitUnaryExtensionEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public ACCResult VisitUnaryExtension(UnaryOperator /*P*/ e) {
    return Visit(e.getSubExpr());
  }

  
  /// Ignore the LHS of a comma operator.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::VisitBinComma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3229,
   FQN="(anonymous namespace)::ARCCastChecker::VisitBinComma", NM="_ZN12_GLOBAL__N_114ARCCastChecker13VisitBinCommaEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker13VisitBinCommaEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public ACCResult VisitBinComma(BinaryOperator /*P*/ e) {
    return Visit(e.getRHS());
  }

  
  /// Conditional operators are okay if both sides are okay.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::VisitConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3234,
   FQN="(anonymous namespace)::ARCCastChecker::VisitConditionalOperator", NM="_ZN12_GLOBAL__N_114ARCCastChecker24VisitConditionalOperatorEPN5clang19ConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker24VisitConditionalOperatorEPN5clang19ConditionalOperatorE")
  //</editor-fold>
  public ACCResult VisitConditionalOperator(ConditionalOperator /*P*/ e) {
    ACCResult left = Visit(e.getTrueExpr());
    if (left == ACCResult.ACC_invalid) {
      return ACCResult.ACC_invalid;
    }
    return merge(left, Visit(e.getFalseExpr()));
  }

  
  /// Look through pseudo-objects.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::VisitPseudoObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3241,
   FQN="(anonymous namespace)::ARCCastChecker::VisitPseudoObjectExpr", NM="_ZN12_GLOBAL__N_114ARCCastChecker21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE")
  //</editor-fold>
  public ACCResult VisitPseudoObjectExpr(PseudoObjectExpr /*P*/ e) {
    // If we're getting here, we should always have a result.
    return Visit(e.getResultExpr());
  }

  
  /// Statement expressions are okay if their result expression is okay.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::VisitStmtExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3247,
   FQN="(anonymous namespace)::ARCCastChecker::VisitStmtExpr", NM="_ZN12_GLOBAL__N_114ARCCastChecker13VisitStmtExprEPN5clang8StmtExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker13VisitStmtExprEPN5clang8StmtExprE")
  //</editor-fold>
  public ACCResult VisitStmtExpr(StmtExpr /*P*/ e) {
    return Visit(e.getSubStmt().body_back());
  }

  
  /// Some declaration references are okay.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3252,
   FQN="(anonymous namespace)::ARCCastChecker::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_114ARCCastChecker16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public ACCResult VisitDeclRefExpr(DeclRefExpr /*P*/ e) {
    VarDecl /*P*/ var = dyn_cast_VarDecl(e.getDecl());
    // References to global constants are okay.
    if (isAnyRetainable(TargetClass)
       && isAnyRetainable(SourceClass)
       && (var != null)
       && var.getStorageClass() == StorageClass.SC_Extern
       && var.getType().isConstQualified()) {
      
      // In system headers, they can also be assumed to be immune to retains.
      // These are things like 'kCFStringTransformToLatin'.
      if (Context.getSourceManager().isInSystemHeader(var.getLocation())) {
        return ACCResult.ACC_bottom;
      }
      
      return ACCResult.ACC_plusZero;
    }
    
    // Nothing else.
    return ACCResult.ACC_invalid;
  }

  
  /// Some calls are okay.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3274,
   FQN="(anonymous namespace)::ARCCastChecker::VisitCallExpr", NM="_ZN12_GLOBAL__N_114ARCCastChecker13VisitCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker13VisitCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public ACCResult VisitCallExpr(CallExpr /*P*/ e) {
    {
      FunctionDecl /*P*/ fn = e.getDirectCallee();
      if ((fn != null)) {
        {
          ACCResult result = checkCallToFunction(fn);
          if ((result.getValue() != 0)) {
            return result;
          }
        }
      }
    }
    
    return StmtVisitor.super.VisitCallExpr(e);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::checkCallToFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3282,
   FQN="(anonymous namespace)::ARCCastChecker::checkCallToFunction", NM="_ZN12_GLOBAL__N_114ARCCastChecker19checkCallToFunctionEPN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker19checkCallToFunctionEPN5clang12FunctionDeclE")
  //</editor-fold>
  public ACCResult checkCallToFunction(FunctionDecl /*P*/ fn) {
    // Require a CF*Ref return type.
    if (!isCFType(fn.getReturnType())) {
      return ACCResult.ACC_invalid;
    }
    if (!isAnyRetainable(TargetClass)) {
      return ACCResult.ACC_invalid;
    }
    
    // Honor an explicit 'not retained' attribute.
    if (fn.hasAttr(CFReturnsNotRetainedAttr.class)) {
      return ACCResult.ACC_plusZero;
    }
    
    // Honor an explicit 'retained' attribute, except that for
    // now we're not going to permit implicit handling of +1 results,
    // because it's a bit frightening.
    if (fn.hasAttr(CFReturnsRetainedAttr.class)) {
      return Diagnose ? ACCResult.ACC_plusOne : ACCResult.ACC_invalid; // ACC_plusOne if we start accepting this
    }
    
    // Recognize this specific builtin function, which is used by CFSTR.
    /*uint*/int builtinID = fn.getBuiltinID();
    if (builtinID == Builtin.ID.BI__builtin___CFStringMakeConstantString.getValue()) {
      return ACCResult.ACC_bottom;
    }
    
    // Otherwise, don't do anything implicit with an unaudited function.
    if (!fn.hasAttr(CFAuditedTransferAttr.class)) {
      return ACCResult.ACC_invalid;
    }
    
    // Otherwise, it's +0 unless it follows the create convention.
    if (coreFoundation.followsCreateRule(fn)) {
      return Diagnose ? ACCResult.ACC_plusOne : ACCResult.ACC_invalid; // ACC_plusOne if we start accepting this
    }
    
    return ACCResult.ACC_plusZero;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3318,
   FQN="(anonymous namespace)::ARCCastChecker::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_114ARCCastChecker20VisitObjCMessageExprEPN5clang15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker20VisitObjCMessageExprEPN5clang15ObjCMessageExprE")
  //</editor-fold>
  public ACCResult VisitObjCMessageExpr(ObjCMessageExpr /*P*/ e) {
    return checkCallToMethod(e.getMethodDecl());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::VisitObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3322,
   FQN="(anonymous namespace)::ARCCastChecker::VisitObjCPropertyRefExpr", NM="_ZN12_GLOBAL__N_114ARCCastChecker24VisitObjCPropertyRefExprEPN5clang19ObjCPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker24VisitObjCPropertyRefExprEPN5clang19ObjCPropertyRefExprE")
  //</editor-fold>
  public ACCResult VisitObjCPropertyRefExpr(ObjCPropertyRefExpr /*P*/ e) {
    ObjCMethodDecl /*P*/ method;
    if (e.isExplicitProperty()) {
      method = e.getExplicitProperty().getGetterMethodDecl();
    } else {
      method = e.getImplicitPropertyGetter();
    }
    return checkCallToMethod(method);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCCastChecker::checkCallToMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp", line = 3331,
   FQN="(anonymous namespace)::ARCCastChecker::checkCallToMethod", NM="_ZN12_GLOBAL__N_114ARCCastChecker17checkCallToMethodEPN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCCastChecker17checkCallToMethodEPN5clang14ObjCMethodDeclE")
  //</editor-fold>
  public ACCResult checkCallToMethod(ObjCMethodDecl /*P*/ method) {
    if (!(method != null)) {
      return ACCResult.ACC_invalid;
    }
    
    // Check for message sends to functions returning CF types.  We
    // just obey the Cocoa conventions with these, even though the
    // return type is CF.
    if (!isAnyRetainable(TargetClass) || !isCFType(method.getReturnType())) {
      return ACCResult.ACC_invalid;
    }
    
    // If the method is explicitly marked not-retained, it's +0.
    if (method.hasAttr(CFReturnsNotRetainedAttr.class)) {
      return ACCResult.ACC_plusZero;
    }
    
    // If the method is explicitly marked as returning retained, or its
    // selector follows a +1 Cocoa convention, treat it as +1.
    if (method.hasAttr(CFReturnsRetainedAttr.class)) {
      return ACCResult.ACC_plusOne;
    }
    switch (method.getSelector().getMethodFamily()) {
     case OMF_alloc:
     case OMF_copy:
     case OMF_mutableCopy:
     case OMF_new:
      return ACCResult.ACC_plusOne;
     default:
      // Otherwise, treat it as +0.
      return ACCResult.ACC_plusZero;
    }
  }

  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", SourceClass=" + SourceClass // NOI18N
              + ", TargetClass=" + TargetClass // NOI18N
              + ", Diagnose=" + Diagnose // NOI18N
              + super.toString(); // NOI18N
  }
}
