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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.java.AstJavaDifferentiators.*;


/// The iterator over UnresolvedSets.  Serves as both the const and
/// non-const iterator.
//<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetIterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 28,
 FQN="clang::UnresolvedSetIterator", NM="_ZN5clang21UnresolvedSetIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang21UnresolvedSetIteratorE")
//</editor-fold>
public class UnresolvedSetIterator extends /*public*/ iterator_adaptor_base<UnresolvedSetIterator, type$ptr<DeclAccessPair /*P*/> , std.random_access_iterator_tag, NamedDecl /*P*/, NamedDecl /*P*/> {
  /*friend  class UnresolvedSetImpl*/
  /*friend  class ASTUnresolvedSet*/
  /*friend  class OverloadExpr*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetIterator::UnresolvedSetIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 36,
   FQN="clang::UnresolvedSetIterator::UnresolvedSetIterator", NM="_ZN5clang21UnresolvedSetIteratorC1EPNS_14DeclAccessPairE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang21UnresolvedSetIteratorC1EPNS_14DeclAccessPairE")
  //</editor-fold>
  /*friend*/public/*private*/ /*explicit*/ UnresolvedSetIterator(JD$DeclAccessPair$P _dparam, type$ptr<DeclAccessPair /*P*/> Iter) {
    // : iterator_adaptor_base<UnresolvedSetIterator, DeclAccessPair * , random_access_iterator_tag, NamedDecl * , int, NamedDecl * , NamedDecl * , iterator_traitsT$P<DeclAccessPair> >(Iter) 
    //START JInit
    super(Iter);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetIterator::UnresolvedSetIterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 38,
   FQN="clang::UnresolvedSetIterator::UnresolvedSetIterator", NM="_ZN5clang21UnresolvedSetIteratorC1EPKNS_14DeclAccessPairE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang21UnresolvedSetIteratorC1EPKNS_14DeclAccessPairE")
  //</editor-fold>
  /*friend*/public/*private*/ /*explicit*/ UnresolvedSetIterator(JD$DeclAccessPair$C$P _dparam, /*const*/ type$ptr<DeclAccessPair /*P*/> Iter) {
    // : iterator_adaptor_base<UnresolvedSetIterator, DeclAccessPair * , random_access_iterator_tag, NamedDecl * , int, NamedDecl * , NamedDecl * , iterator_traitsT$P<DeclAccessPair> >(const_cast<DeclAccessPair * >(Iter)) 
    //START JInit
    super((/*(const_cast DeclAccessPair P )*/(Iter)));
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetIterator::UnresolvedSetIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 42,
   FQN="clang::UnresolvedSetIterator::UnresolvedSetIterator", NM="_ZN5clang21UnresolvedSetIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang21UnresolvedSetIteratorC1Ev")
  //</editor-fold>
  /*friend*/public/*public*/ UnresolvedSetIterator() {
    // : iterator_adaptor_base<UnresolvedSetIterator, DeclAccessPair * , std::random_access_iterator_tag, NamedDecl * , std::ptrdiff_t, NamedDecl * , NamedDecl * >() 
    //START JInit
    super();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetIterator::getDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 44,
   FQN="clang::UnresolvedSetIterator::getDecl", NM="_ZNK5clang21UnresolvedSetIterator7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZNK5clang21UnresolvedSetIterator7getDeclEv")
  //</editor-fold>
  public NamedDecl /*P*/ getDecl() /*const*/ {
    return I.$star().getDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetIterator::setDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 45,
   FQN="clang::UnresolvedSetIterator::setDecl", NM="_ZNK5clang21UnresolvedSetIterator7setDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZNK5clang21UnresolvedSetIterator7setDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public void setDecl(NamedDecl /*P*/ ND) /*const*/ {
    I.$star().setDecl(ND);
    /*JAVA:return*/return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetIterator::getAccess">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 46,
   FQN="clang::UnresolvedSetIterator::getAccess", NM="_ZNK5clang21UnresolvedSetIterator9getAccessEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZNK5clang21UnresolvedSetIterator9getAccessEv")
  //</editor-fold>
  public AccessSpecifier getAccess() /*const*/ {
    return I.$star().getAccess();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetIterator::setAccess">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 47,
   FQN="clang::UnresolvedSetIterator::setAccess", NM="_ZN5clang21UnresolvedSetIterator9setAccessENS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang21UnresolvedSetIterator9setAccessENS_15AccessSpecifierE")
  //</editor-fold>
  public void setAccess(AccessSpecifier AS) {
    I.$star().setAccess(AS);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetIterator::getPair">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 48,
   FQN="clang::UnresolvedSetIterator::getPair", NM="_ZNK5clang21UnresolvedSetIterator7getPairEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZNK5clang21UnresolvedSetIterator7getPairEv")
  //</editor-fold>
  public /*const*/ DeclAccessPair /*&*/ getPair() /*const*/ {
    return $Deref(I.$star());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetIterator::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 50,
   FQN="clang::UnresolvedSetIterator::operator*", NM="_ZNK5clang21UnresolvedSetIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZNK5clang21UnresolvedSetIteratordeEv")
  //</editor-fold>
  public NamedDecl /*P*/ $star() /*const*/ {
    return getDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetIterator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 51,
   FQN="clang::UnresolvedSetIterator::operator->", NM="_ZNK5clang21UnresolvedSetIteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZNK5clang21UnresolvedSetIteratorptEv")
  //</editor-fold>
  public NamedDecl /*P*/ $arrow() /*const*/ {
    return $Deref(this.$star());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetIterator::UnresolvedSetIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 28,
   FQN="clang::UnresolvedSetIterator::UnresolvedSetIterator", NM="_ZN5clang21UnresolvedSetIteratorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang21UnresolvedSetIteratorC1ERKS0_")
  //</editor-fold>
  /*friend*/public/*public*/ /*inline*/ UnresolvedSetIterator(final /*const*/ UnresolvedSetIterator /*&*/ $Prm0) {
    // : iterator_adaptor_base<UnresolvedSetIterator, DeclAccessPair * , std::random_access_iterator_tag, NamedDecl * , std::ptrdiff_t, NamedDecl * , NamedDecl * >() 
    //START JInit
    super(JD$BaseOf.INSTANCE, $Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetIterator::UnresolvedSetIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 28,
   FQN="clang::UnresolvedSetIterator::UnresolvedSetIterator", NM="_ZN5clang21UnresolvedSetIteratorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang21UnresolvedSetIteratorC1EOS0_")
  //</editor-fold>
  /*friend*/public/*public*/ /*inline*/ UnresolvedSetIterator(JD$Move _dparam, final UnresolvedSetIterator /*&&*/$Prm0) {
    // : iterator_adaptor_base<UnresolvedSetIterator, DeclAccessPair * , std::random_access_iterator_tag, NamedDecl * , std::ptrdiff_t, NamedDecl * , NamedDecl * >(static_cast<UnresolvedSetIterator &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetIterator::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 28,
   FQN="clang::UnresolvedSetIterator::operator=", NM="_ZN5clang21UnresolvedSetIteratoraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang21UnresolvedSetIteratoraSERKS0_")
  //</editor-fold>
  public /*inline*/ UnresolvedSetIterator /*&*/ $assign(final /*const*/ UnresolvedSetIterator /*&*/ $Prm0) {
    /*Deref*/super.$assign($Prm0);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetIterator::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 28,
   FQN="clang::UnresolvedSetIterator::operator=", NM="_ZN5clang21UnresolvedSetIteratoraSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang21UnresolvedSetIteratoraSEOS0_")
  //</editor-fold>
  public /*inline*/ UnresolvedSetIterator /*&*/ $assignMove(final UnresolvedSetIterator /*&&*/$Prm0) {
    /*Deref*/super.$assignMove($Prm0);
    return /*Deref*/this;
  }

  public Integer /*P*/ getDecl$ID() /*const*/ {
    return I.$star().getDecl$ID();
  }

  @Override
  public UnresolvedSetIterator clone() {
    return new UnresolvedSetIterator(this);
  }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
