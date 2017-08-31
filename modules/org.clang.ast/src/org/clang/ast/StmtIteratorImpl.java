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

package org.clang.ast;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;

/*template <typename DERIVED, typename REFERENCE> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 76,
 FQN="clang::StmtIteratorImpl", NM="_ZN5clang16StmtIteratorImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorImplE")
//</editor-fold>
public abstract class StmtIteratorImpl</*typename*/ DERIVED extends StmtIteratorImpl<?, REFERENCE>, /*typename*/ REFERENCE>  extends /*public*/ StmtIteratorBase implements /*public*/ std.iterator<std.forward_iterator_tag, REFERENCE>, type$iterator<DERIVED, REFERENCE>, Native.NativeComparable {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorImpl::StmtIteratorImpl<DERIVED, REFERENCE>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 82,
   FQN="clang::StmtIteratorImpl::StmtIteratorImpl<DERIVED, REFERENCE>", NM="_ZN5clang16StmtIteratorImplC1ERKNS_16StmtIteratorBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorImplC1ERKNS_16StmtIteratorBaseE")
  //</editor-fold>
  protected StmtIteratorImpl(final /*const*/ StmtIteratorBase /*&*/ RHS) {
    // : StmtIteratorBase(RHS) 
    //START JInit
    /*ParenListExpr*/super(RHS);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorImpl::StmtIteratorImpl<DERIVED, REFERENCE>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 84,
   FQN="clang::StmtIteratorImpl::StmtIteratorImpl<DERIVED, REFERENCE>", NM="_ZN5clang16StmtIteratorImplC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorImplC1Ev")
  //</editor-fold>
  public StmtIteratorImpl() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorImpl::StmtIteratorImpl<DERIVED, REFERENCE>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 85,
   FQN="clang::StmtIteratorImpl::StmtIteratorImpl<DERIVED, REFERENCE>", NM="_ZN5clang16StmtIteratorImplC1EPPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorImplC1EPPNS_4StmtE")
  //</editor-fold>
  public StmtIteratorImpl(type$iterator<?, Stmt /*P*/ /*P*/> s) {
    // : StmtIteratorBase(s) 
    //START JInit
    /*ParenListExpr*/super(s);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorImpl::StmtIteratorImpl<DERIVED, REFERENCE>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 86,
   FQN="clang::StmtIteratorImpl::StmtIteratorImpl<DERIVED, REFERENCE>", NM="_ZN5clang16StmtIteratorImplC1EPPNS_4DeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorImplC1EPPNS_4DeclES3_")
  //</editor-fold>
  public StmtIteratorImpl(type$iterator<?, Decl /*P*/ /*P*/> dgi, type$ptr<Decl /*P*/ /*P*/> dge) {
    // : StmtIteratorBase(dgi, dge) 
    //START JInit
    /*ParenListExpr*/super(dgi, dge);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorImpl::StmtIteratorImpl<DERIVED, REFERENCE>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 87,
   FQN="clang::StmtIteratorImpl::StmtIteratorImpl<DERIVED, REFERENCE>", NM="_ZN5clang16StmtIteratorImplC1EPKNS_17VariableArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorImplC1EPKNS_17VariableArrayTypeE")
  //</editor-fold>
  public StmtIteratorImpl(/*const*/ VariableArrayType /*P*/ t) {
    // : StmtIteratorBase(t) 
    //START JInit
    /*ParenListExpr*/super(t);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorImpl::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 89,
   FQN="clang::StmtIteratorImpl::operator++", NM="_ZN5clang16StmtIteratorImplppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorImplppEv")
  //</editor-fold>
  public DERIVED /*&*/ $preInc() {
    if (inStmt()) {
      Unnamed_field.stmt.$preInc();
    } else if (Native.$bool(getVAPtr())) {
      NextVA();
    } else {
      NextDecl();
    }
    
    return ((/*static_cast*/DERIVED /*&*/ )(/*Deref*/this));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorImpl::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 100,
   FQN="clang::StmtIteratorImpl::operator++", NM="_ZN5clang16StmtIteratorImplppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorImplppEi")
  //</editor-fold>
  public DERIVED $postInc(int $Prm0) {
    DERIVED tmp = $tryClone((/*static_cast*/DERIVED /*&*/ )(/*Deref*/this));
    $preInc();
    return tmp;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorImpl::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 106,
   FQN="clang::StmtIteratorImpl::operator==", NM="_ZNK5clang16StmtIteratorImpleqERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZNK5clang16StmtIteratorImpleqERKT_")
  //</editor-fold>
  public boolean $eq(final /*const*/ DERIVED /*&*/ RHS) /*const*/ {
    return Native.$bool(Native.$eq_ptr(Unnamed_field.stmt, RHS.Unnamed_field.stmt) && Native.$eq_ptr(Unnamed_field.DGI, RHS.Unnamed_field.DGI)) 
            && 
            Native.$bool(RawVAPtr$Ptr == RHS.RawVAPtr$Ptr) && Native.$bool(RawVAPtr$Flags == RHS.RawVAPtr$Flags);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorImpl::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 110,
   FQN="clang::StmtIteratorImpl::operator!=", NM="_ZNK5clang16StmtIteratorImplneERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZNK5clang16StmtIteratorImplneERKT_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ DERIVED /*&*/ RHS) /*const*/ {
    return !$eq(RHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorImpl::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 114,
   FQN="clang::StmtIteratorImpl::operator*", NM="_ZNK5clang16StmtIteratorImpldeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZNK5clang16StmtIteratorImpldeEv")
  //</editor-fold>
  public REFERENCE $star() /*const*/ {
    return star$ref().$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorImpl::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 118,
   FQN="clang::StmtIteratorImpl::operator->", NM="_ZNK5clang16StmtIteratorImplptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZNK5clang16StmtIteratorImplptEv")
  //</editor-fold>
  public REFERENCE $arrow() /*const*/ {
    return $star();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public abstract DERIVED clone();
  
  protected StmtIteratorImpl(JD$Move _dparam, /*const*/ StmtIteratorBase /*&*/ RHS) { 
  /*for derived*/ 
  }
  
  @Override public boolean $eq(Object RHS) { 
    return this.$eq((DERIVED)RHS); 
  }

  @Override
  public type$ref<REFERENCE> star$ref() {
    type$iterator ptr = (inStmt() ? Unnamed_field.stmt : GetDeclExpr());
    return ptr.star$ref();
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
