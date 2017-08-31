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

package org.clang.analysis;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.clang.ast.*;
import static org.clang.analysis.impl.CFGStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// CFGImplicitDtor - Represents C++ object destructor implicitly generated
/// by compiler on various occasions.
//<editor-fold defaultstate="collapsed" desc="clang::CFGImplicitDtor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 171,
 FQN="clang::CFGImplicitDtor", NM="_ZN5clang15CFGImplicitDtorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang15CFGImplicitDtorE")
//</editor-fold>
public class CFGImplicitDtor extends /*public*/ CFGElement {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFGImplicitDtor::CFGImplicitDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 173,
   FQN="clang::CFGImplicitDtor::CFGImplicitDtor", NM="_ZN5clang15CFGImplicitDtorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang15CFGImplicitDtorC1Ev")
  //</editor-fold>
  protected CFGImplicitDtor() {
    // : CFGElement() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGImplicitDtor::CFGImplicitDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 174,
   FQN="clang::CFGImplicitDtor::CFGImplicitDtor", NM="_ZN5clang15CFGImplicitDtorC1ENS_10CFGElement4KindEPKvS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang15CFGImplicitDtorC1ENS_10CFGElement4KindEPKvS4_")
  //</editor-fold>
  protected CFGImplicitDtor(CFGElement.Kind kind, /*const*/Object/*void P*/ data1) {
    this(kind, data1, (/*const*/Object/*void P*/ )null);
  }
  protected CFGImplicitDtor(CFGElement.Kind kind, /*const*/Object/*void P*/ data1, /*const*/Object/*void P*/ data2/*= null*/) {
    // : CFGElement(kind, data1, data2) 
    //START JInit
    super(kind, data1, data2);
    //END JInit
    assert (kind.getValue() >= Kind.DTOR_BEGIN.getValue() && kind.getValue() <= Kind.DTOR_END.getValue());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFGImplicitDtor::getDestructorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3894,
   FQN="clang::CFGImplicitDtor::getDestructorDecl", NM="_ZNK5clang15CFGImplicitDtor17getDestructorDeclERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang15CFGImplicitDtor17getDestructorDeclERNS_10ASTContextE")
  //</editor-fold>
  public /*const*/ CXXDestructorDecl /*P*/ getDestructorDecl(final ASTContext /*&*/ astContext) /*const*/ {
    switch (getKind()) {
     case Statement:
     case Initializer:
     case NewAllocator:
      throw new llvm_unreachable("getDestructorDecl should only be used with ImplicitDtors");
     case AutomaticObjectDtor:
      {
        /*const*/ VarDecl /*P*/ var = castAs(CFGAutomaticObjDtor.class).getVarDecl();
        QualType ty = var.getType();
        
        // FIXME: See CFGBuilder::addLocalScopeForVarDecl.
        //
        // Lifetime-extending constructs are handled here. This works for a single
        // temporary in an initializer expression.
        if (ty.$arrow().isReferenceType()) {
          {
            /*const*/ Expr /*P*/ Init = var.getInit$Const();
            if ((Init != null)) {
              ty.$assignMove(getReferenceInitTemporaryType(astContext, Init));
            }
          }
        }
        {
          
          /*const*/ ArrayType /*P*/ arrayType;
          while (((/*P*/ arrayType = astContext.getAsArrayType(new QualType(ty))) != null)) {
            ty.$assignMove(arrayType.getElementType());
          }
        }
        /*const*/ RecordType /*P*/ recordType = ty.$arrow().getAs$RecordType();
        /*const*/ CXXRecordDecl /*P*/ classDecl = cast_CXXRecordDecl(recordType.getDecl());
        return classDecl.getDestructor();
      }
     case DeleteDtor:
      {
        /*const*/ CXXDeleteExpr /*P*/ DE = castAs(CFGDeleteDtor.class).getDeleteExpr();
        QualType DTy = DE.getDestroyedType();
        DTy.$assignMove(DTy.getNonReferenceType());
        /*const*/ CXXRecordDecl /*P*/ classDecl = astContext.getBaseElementType(new QualType(DTy)).$arrow().getAsCXXRecordDecl();
        return classDecl.getDestructor();
      }
     case TemporaryDtor:
      {
        /*const*/ CXXBindTemporaryExpr /*P*/ bindExpr = castAs(CFGTemporaryDtor.class).getBindTemporaryExpr();
        /*const*/ CXXTemporary /*P*/ temp = bindExpr.getTemporary$Const();
        return temp.getDestructor();
      }
     case BaseDtor:
     case MemberDtor:
      
      // Not yet supported.
      return null;
    }
    throw new llvm_unreachable("getKind() returned bogus value");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGImplicitDtor::isNoReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3947,
   FQN="clang::CFGImplicitDtor::isNoReturn", NM="_ZNK5clang15CFGImplicitDtor10isNoReturnERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang15CFGImplicitDtor10isNoReturnERNS_10ASTContextE")
  //</editor-fold>
  public boolean isNoReturn(final ASTContext /*&*/ astContext) /*const*/ {
    {
      /*const*/ CXXDestructorDecl /*P*/ DD = getDestructorDecl(astContext);
      if ((DD != null)) {
        return DD.isNoReturn();
      }
    }
    return false;
  }

/*private:*/
  /*friend  class CFGElement*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFGImplicitDtor::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 185,
   FQN="clang::CFGImplicitDtor::isKind", NM="_ZN5clang15CFGImplicitDtor6isKindERKNS_10CFGElementE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang15CFGImplicitDtor6isKindERKNS_10CFGElementE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ CFGElement /*&*/ E) {
    CFGElement.Kind kind = E.getKind();
    return kind.getValue() >= Kind.DTOR_BEGIN.getValue() && kind.getValue() <= Kind.DTOR_END.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGImplicitDtor::CFGImplicitDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 171,
   FQN="clang::CFGImplicitDtor::CFGImplicitDtor", NM="_ZN5clang15CFGImplicitDtorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang15CFGImplicitDtorC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CFGImplicitDtor(final /*const*/ CFGImplicitDtor /*&*/ $Prm0) {
    // : CFGElement() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGImplicitDtor::CFGImplicitDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 171,
   FQN="clang::CFGImplicitDtor::CFGImplicitDtor", NM="_ZN5clang15CFGImplicitDtorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang15CFGImplicitDtorC1EOS0_")
  //</editor-fold>
  public /*inline*/ CFGImplicitDtor(JD$Move _dparam, final CFGImplicitDtor /*&&*/$Prm0) {
    // : CFGElement(static_cast<CFGImplicitDtor &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CFGImplicitDtor::~CFGImplicitDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 171,
   FQN="clang::CFGImplicitDtor::~CFGImplicitDtor", NM="_ZN5clang15CFGImplicitDtorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang15CFGImplicitDtorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public CFGImplicitDtor clone() {
    assert this.getClass() == CFGImplicitDtor.class : "must be overridden in " + this.getClass();
    return new CFGImplicitDtor(this);
  }
  
  @Override public CFGImplicitDtor move() {
    assert this.getClass() == CFGImplicitDtor.class : "must be overridden in " + this.getClass();
    return new CFGImplicitDtor(JD$Move.INSTANCE, this);
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////  
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
