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
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.java.AstJavaDifferentiators.*;


/// \brief A set of unresolved declarations.
//<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 55,
 FQN="clang::UnresolvedSetImpl", NM="_ZN5clang17UnresolvedSetImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImplE")
//</editor-fold>
public class UnresolvedSetImpl implements Iterable<NamedDecl /*P*/> {
  /*typedef SmallVectorImpl<DeclAccessPair> DeclsTy*/
//  public final class DeclsTy extends SmallVectorImpl<DeclAccessPair>{ };

  // Don't allow direct construction, and only permit subclassing by
  // UnresolvedSet.
  /*private:*/
  /*friend template <unsigned int N> class UnresolvedSet*/
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::UnresolvedSetImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 62,
   FQN="clang::UnresolvedSetImpl::UnresolvedSetImpl", NM="_ZN5clang17UnresolvedSetImplC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImplC1Ev")
  //</editor-fold>
  /*friend*/protected/*private*/ UnresolvedSetImpl()/* = default*/ {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::UnresolvedSetImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 63,
   FQN="clang::UnresolvedSetImpl::UnresolvedSetImpl", NM="_ZN5clang17UnresolvedSetImplC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImplC1ERKS0_")
  //</editor-fold>
  /*friend*/protected/*private*/ UnresolvedSetImpl(final /*const*/ UnresolvedSetImpl /*&*/ $Prm0)/* = default*/ {
    /*<<<default copy constructor: may be there is another TU where objects are copied?>>>*/
    // memcpy(this, $1, sizeof($1));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::operator=">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 64,
   FQN="clang::UnresolvedSetImpl::operator=", NM="_ZN5clang17UnresolvedSetImplaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImplaSERKS0_")
  //</editor-fold>
  private UnresolvedSetImpl /*&*/ $assign(final /*const*/ UnresolvedSetImpl /*&*/ $Prm0)/* = default*/ {
    /*<<<default assign operator: may be there is another TU where objects are assigned?>>>*/
    // memcpy(this, $1, sizeof($1));
    return this;
  }


  
  // FIXME: Switch these to "= default" once MSVC supports generating move ops
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::UnresolvedSetImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 67,
   FQN="clang::UnresolvedSetImpl::UnresolvedSetImpl", NM="_ZN5clang17UnresolvedSetImplC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImplC1EOS0_")
  //</editor-fold>
  /*friend*/protected/*private*/ UnresolvedSetImpl(JD$Move _dparam, final UnresolvedSetImpl /*&&*/$Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 68,
   FQN="clang::UnresolvedSetImpl::operator=", NM="_ZN5clang17UnresolvedSetImplaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImplaSEOS0_")
  //</editor-fold>
  private UnresolvedSetImpl /*&*/ $assignMove(final UnresolvedSetImpl /*&&*/$Prm0) {
    return /*Deref*/this;
  }

/*public:*/
  // We don't currently support assignment through this iterator, so we might
  // as well use the same implementation twice.
  /*typedef UnresolvedSetIterator iterator*/
//  public final class iterator extends UnresolvedSetIterator{ };
  /*typedef UnresolvedSetIterator const_iterator*/
//  public final class const_iterator extends UnresolvedSetIterator{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 76,
   FQN="clang::UnresolvedSetImpl::begin", NM="_ZN5clang17UnresolvedSetImpl5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImpl5beginEv")
  //</editor-fold>
  public UnresolvedSetIterator begin() {
    return new UnresolvedSetIterator(JD$DeclAccessPair$P.INSTANCE, decls().begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 77,
   FQN="clang::UnresolvedSetImpl::end", NM="_ZN5clang17UnresolvedSetImpl3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImpl3endEv")
  //</editor-fold>
  public UnresolvedSetIterator end() {
    return new UnresolvedSetIterator(JD$DeclAccessPair$P.INSTANCE, decls().end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 79,
   FQN="clang::UnresolvedSetImpl::begin", NM="_ZNK5clang17UnresolvedSetImpl5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang17UnresolvedSetImpl5beginEv")
  //</editor-fold>
  public UnresolvedSetIterator begin$Const() /*const*/ {
    return new UnresolvedSetIterator(JD$DeclAccessPair$C$P.INSTANCE, decls$Const().begin$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 80,
   FQN="clang::UnresolvedSetImpl::end", NM="_ZNK5clang17UnresolvedSetImpl3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang17UnresolvedSetImpl3endEv")
  //</editor-fold>
  public UnresolvedSetIterator end$Const() /*const*/ {
    return new UnresolvedSetIterator(JD$DeclAccessPair$C$P.INSTANCE, decls$Const().end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::addDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 82,
   FQN="clang::UnresolvedSetImpl::addDecl", NM="_ZN5clang17UnresolvedSetImpl7addDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImpl7addDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public void addDecl(NamedDecl /*P*/ D) {
    addDecl(D, AccessSpecifier.AS_none);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::addDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 86,
   FQN="clang::UnresolvedSetImpl::addDecl", NM="_ZN5clang17UnresolvedSetImpl7addDeclEPNS_9NamedDeclENS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImpl7addDeclEPNS_9NamedDeclENS_15AccessSpecifierE")
  //</editor-fold>
  public void addDecl(NamedDecl /*P*/ D, AccessSpecifier AS) {
    decls().push_back(DeclAccessPair.make(D, AS));
  }

  
  /// Replaces the given declaration with the new one, once.
  ///
  /// \return true if the set changed
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::replace">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 93,
   FQN="clang::UnresolvedSetImpl::replace", NM="_ZN5clang17UnresolvedSetImpl7replaceEPKNS_9NamedDeclEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImpl7replaceEPKNS_9NamedDeclEPS1_")
  //</editor-fold>
  public boolean replace(/*const*/ NamedDecl /*P*/ Old, NamedDecl /*P*/ New) {
    for (type$ptr<DeclAccessPair /*P*/ > I = $tryClone(decls().begin()), /*P*/ E = $tryClone(decls().end()); $noteq_ptr(I, E); I.$preInc())  {
      if (I./*->*/$star().getDecl() == Old) {
        I./*->*/$star().setDecl(New);
        return /*,*/true;
      }
    }
    return false;
  }

  
  /// Replaces the declaration at the given iterator with the new one,
  /// preserving the original access bits.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::replace">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 102,
   FQN="clang::UnresolvedSetImpl::replace", NM="_ZN5clang17UnresolvedSetImpl7replaceENS_21UnresolvedSetIteratorEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImpl7replaceENS_21UnresolvedSetIteratorEPNS_9NamedDeclE")
  //</editor-fold>
  public void replace(UnresolvedSetIterator I, NamedDecl /*P*/ New) {
    I.I.$arrow().setDecl(New);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::replace">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 104,
   FQN="clang::UnresolvedSetImpl::replace", NM="_ZN5clang17UnresolvedSetImpl7replaceENS_21UnresolvedSetIteratorEPNS_9NamedDeclENS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImpl7replaceENS_21UnresolvedSetIteratorEPNS_9NamedDeclENS_15AccessSpecifierE")
  //</editor-fold>
  public void replace(UnresolvedSetIterator I, NamedDecl /*P*/ New, AccessSpecifier AS) {
    I.I.$arrow().set(New, AS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::erase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 108,
   FQN="clang::UnresolvedSetImpl::erase", NM="_ZN5clang17UnresolvedSetImpl5eraseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImpl5eraseEj")
  //</editor-fold>
  public void erase(/*uint*/int I) {
    decls().$at(I).$assignMove(decls().pop_back_val());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::erase">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 110,
   FQN="clang::UnresolvedSetImpl::erase", NM="_ZN5clang17UnresolvedSetImpl5eraseENS_21UnresolvedSetIteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImpl5eraseENS_21UnresolvedSetIteratorE")
  //</editor-fold>
  public void erase(UnresolvedSetIterator I) {
    /*Deref*/I.I.$arrow().$assignMove(decls().pop_back_val());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::setAccess">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 112,
   FQN="clang::UnresolvedSetImpl::setAccess", NM="_ZN5clang17UnresolvedSetImpl9setAccessENS_21UnresolvedSetIteratorENS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImpl9setAccessENS_21UnresolvedSetIteratorENS_15AccessSpecifierE")
  //</editor-fold>
  public void setAccess(UnresolvedSetIterator I, AccessSpecifier AS) {
    I.I.$arrow().setAccess(AS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 114,
   FQN="clang::UnresolvedSetImpl::clear", NM="_ZN5clang17UnresolvedSetImpl5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImpl5clearEv")
  //</editor-fold>
  public void clear() {
    decls().clear();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::set_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 115,
   FQN="clang::UnresolvedSetImpl::set_size", NM="_ZN5clang17UnresolvedSetImpl8set_sizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImpl8set_sizeEj")
  //</editor-fold>
  public void set_size(/*uint*/int N) {
    decls().set_size(N);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 117,
   FQN="clang::UnresolvedSetImpl::empty", NM="_ZNK5clang17UnresolvedSetImpl5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang17UnresolvedSetImpl5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return decls$Const().empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 118,
   FQN="clang::UnresolvedSetImpl::size", NM="_ZNK5clang17UnresolvedSetImpl4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang17UnresolvedSetImpl4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return decls$Const().size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::append">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 120,
   FQN="clang::UnresolvedSetImpl::append", NM="_ZN5clang17UnresolvedSetImpl6appendENS_21UnresolvedSetIteratorES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImpl6appendENS_21UnresolvedSetIteratorES1_")
  //</editor-fold>
  public void append(UnresolvedSetIterator I, UnresolvedSetIterator E) {
    decls().append_T(I.I, E.I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 122,
   FQN="clang::UnresolvedSetImpl::operator[]", NM="_ZN5clang17UnresolvedSetImplixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImplixEj")
  //</editor-fold>
  public DeclAccessPair /*&*/ $at(/*uint*/int I) {
    return decls().$at(I);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 123,
   FQN="clang::UnresolvedSetImpl::operator[]", NM="_ZNK5clang17UnresolvedSetImplixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang17UnresolvedSetImplixEj")
  //</editor-fold>
  public /*const*/ DeclAccessPair /*&*/ $at$Const(/*uint*/int I) /*const*/ {
    return decls$Const().$at$Const(I);
  }

/*private:*/
  // These work because the only permitted subclass is UnresolvedSetImpl
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::decls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 128,
   FQN="clang::UnresolvedSetImpl::decls", NM="_ZN5clang17UnresolvedSetImpl5declsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang17UnresolvedSetImpl5declsEv")
  //</editor-fold>
  /*friend*/protected/*private*/ SmallVectorImpl<DeclAccessPair> /*&*/ decls() {
    return $Deref(((SmallVectorImpl<DeclAccessPair> /*P*/ )reinterpret_cast(SmallVectorImpl.class, this)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedSetImpl::decls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/UnresolvedSet.h", line = 131,
   FQN="clang::UnresolvedSetImpl::decls", NM="_ZNK5clang17UnresolvedSetImpl5declsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang17UnresolvedSetImpl5declsEv")
  //</editor-fold>
  /*friend*/protected/*private*/ /*const*/ SmallVectorImpl<DeclAccessPair> /*&*/ decls$Const() /*const*/ {
    return $Deref(((/*const*/ SmallVectorImpl<DeclAccessPair> /*P*/ )reinterpret_cast(/*const*/ SmallVectorImpl.class, this)));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public java.util.Iterator<NamedDecl /*P*/> iterator() { return new JavaIterator(begin(), end()); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
