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
import org.clang.sema.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// \brief Helper class that marks all of the declarations referenced by
/// potentially-evaluated subexpressions as "referenced".
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvaluatedExprMarker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14119,
 FQN="(anonymous namespace)::EvaluatedExprMarker", NM="_ZN12_GLOBAL__N_119EvaluatedExprMarkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_119EvaluatedExprMarkerE")
//</editor-fold>
public class EvaluatedExprMarker implements /*public*/ EvaluatedExprVisitor<EvaluatedExprMarker> {
  private final Sema /*&*/ S;
  private boolean SkipLocalVariables;
/*public:*/
  /*typedef EvaluatedExprVisitor<EvaluatedExprMarker> Inherited*/
//  public final class Inherited extends EvaluatedExprVisitor<EvaluatedExprMarker>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvaluatedExprMarker::EvaluatedExprMarker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*EvaluatedExprVisitorBase$Flds*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14126,
   FQN="(anonymous namespace)::EvaluatedExprMarker::EvaluatedExprMarker", NM="_ZN12_GLOBAL__N_119EvaluatedExprMarkerC1ERN5clang4SemaEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_119EvaluatedExprMarkerC1ERN5clang4SemaEb")
  //</editor-fold>
  public EvaluatedExprMarker(final Sema /*&*/ S, boolean SkipLocalVariables) {
    // : Inherited(S.Context), S(S), SkipLocalVariables(SkipLocalVariables) 
    //START JInit
    this.EvaluatedExprVisitorBase$Flds = $EvaluatedExprVisitor(S.Context);
    this./*&*/S=/*&*/S;
    this.SkipLocalVariables = SkipLocalVariables;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvaluatedExprMarker::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14129,
   FQN="(anonymous namespace)::EvaluatedExprMarker::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_119EvaluatedExprMarker16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_119EvaluatedExprMarker16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    // If we were asked not to visit local variables, don't.
    if (SkipLocalVariables) {
      {
        VarDecl /*P*/ VD = dyn_cast_VarDecl(E.getDecl());
        if ((VD != null)) {
          if (VD.hasLocalStorage()) {
            return;
          }
        }
      }
    }
    
    S.MarkDeclRefReferenced(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvaluatedExprMarker::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14140,
   FQN="(anonymous namespace)::EvaluatedExprMarker::VisitMemberExpr", NM="_ZN12_GLOBAL__N_119EvaluatedExprMarker15VisitMemberExprEPN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_119EvaluatedExprMarker15VisitMemberExprEPN5clang10MemberExprE")
  //</editor-fold>
  public void VisitMemberExpr(MemberExpr /*P*/ E) {
    S.MarkMemberReferenced(E);
    EvaluatedExprVisitor.super.VisitMemberExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvaluatedExprMarker::VisitCXXBindTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14145,
   FQN="(anonymous namespace)::EvaluatedExprMarker::VisitCXXBindTemporaryExpr", NM="_ZN12_GLOBAL__N_119EvaluatedExprMarker25VisitCXXBindTemporaryExprEPN5clang20CXXBindTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_119EvaluatedExprMarker25VisitCXXBindTemporaryExprEPN5clang20CXXBindTemporaryExprE")
  //</editor-fold>
  public void VisitCXXBindTemporaryExpr(CXXBindTemporaryExpr /*P*/ E) {
    S.MarkFunctionReferenced(E.getLocStart(), 
        ((/*const_cast*/CXXDestructorDecl /*P*/ )(E.getTemporary().getDestructor())));
    Visit(E.getSubExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvaluatedExprMarker::VisitCXXNewExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14151,
   FQN="(anonymous namespace)::EvaluatedExprMarker::VisitCXXNewExpr", NM="_ZN12_GLOBAL__N_119EvaluatedExprMarker15VisitCXXNewExprEPN5clang10CXXNewExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_119EvaluatedExprMarker15VisitCXXNewExprEPN5clang10CXXNewExprE")
  //</editor-fold>
  public void VisitCXXNewExpr(CXXNewExpr /*P*/ E) {
    if ((E.getOperatorNew() != null)) {
      S.MarkFunctionReferenced(E.getLocStart(), E.getOperatorNew());
    }
    if ((E.getOperatorDelete() != null)) {
      S.MarkFunctionReferenced(E.getLocStart(), E.getOperatorDelete());
    }
    EvaluatedExprVisitor.super.VisitCXXNewExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvaluatedExprMarker::VisitCXXDeleteExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14159,
   FQN="(anonymous namespace)::EvaluatedExprMarker::VisitCXXDeleteExpr", NM="_ZN12_GLOBAL__N_119EvaluatedExprMarker18VisitCXXDeleteExprEPN5clang13CXXDeleteExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_119EvaluatedExprMarker18VisitCXXDeleteExprEPN5clang13CXXDeleteExprE")
  //</editor-fold>
  public void VisitCXXDeleteExpr(CXXDeleteExpr /*P*/ E) {
    if ((E.getOperatorDelete() != null)) {
      S.MarkFunctionReferenced(E.getLocStart(), E.getOperatorDelete());
    }
    QualType Destroyed = S.Context.getBaseElementType(E.getDestroyedType());
    {
      /*const*/ RecordType /*P*/ DestroyedRec = Destroyed.$arrow().<RecordType>getAs$RecordType();
      if ((DestroyedRec != null)) {
        CXXRecordDecl /*P*/ Record = cast_CXXRecordDecl(DestroyedRec.getDecl());
        S.MarkFunctionReferenced(E.getLocStart(), 
            S.LookupDestructor(Record));
      }
    }
    
    EvaluatedExprVisitor.super.VisitCXXDeleteExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvaluatedExprMarker::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14172,
   FQN="(anonymous namespace)::EvaluatedExprMarker::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_119EvaluatedExprMarker21VisitCXXConstructExprEPN5clang16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_119EvaluatedExprMarker21VisitCXXConstructExprEPN5clang16CXXConstructExprE")
  //</editor-fold>
  public void VisitCXXConstructExpr(CXXConstructExpr /*P*/ E) {
    S.MarkFunctionReferenced(E.getLocStart(), E.getConstructor());
    EvaluatedExprVisitor.super.VisitCXXConstructExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvaluatedExprMarker::VisitCXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14177,
   FQN="(anonymous namespace)::EvaluatedExprMarker::VisitCXXDefaultArgExpr", NM="_ZN12_GLOBAL__N_119EvaluatedExprMarker22VisitCXXDefaultArgExprEPN5clang17CXXDefaultArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_119EvaluatedExprMarker22VisitCXXDefaultArgExprEPN5clang17CXXDefaultArgExprE")
  //</editor-fold>
  public void VisitCXXDefaultArgExpr(CXXDefaultArgExpr /*P*/ E) {
    Visit(E.getExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EvaluatedExprMarker::VisitImplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14181,
   FQN="(anonymous namespace)::EvaluatedExprMarker::VisitImplicitCastExpr", NM="_ZN12_GLOBAL__N_119EvaluatedExprMarker21VisitImplicitCastExprEPN5clang16ImplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_119EvaluatedExprMarker21VisitImplicitCastExprEPN5clang16ImplicitCastExprE")
  //</editor-fold>
  public void VisitImplicitCastExpr(ImplicitCastExpr /*P*/ E) {
    EvaluatedExprVisitor.super.VisitImplicitCastExpr(E);
    if (E.getCastKind() == CastKind.CK_LValueToRValue) {
      S.UpdateMarkingForLValueToRValue(E.getSubExpr());
    }
  }

  private final EvaluatedExprVisitorBase$Fields EvaluatedExprVisitorBase$Flds;// use return value of $EvaluatedExprVisitor();
  @Override public final EvaluatedExprVisitorBase$Fields $EvaluatedExprVisitorBase$Fields() { return EvaluatedExprVisitorBase$Flds; }
  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", SkipLocalVariables=" + SkipLocalVariables // NOI18N
              + super.toString(); // NOI18N
  }
}
