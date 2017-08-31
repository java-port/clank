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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.clang.basic.*;
import org.clang.ast.aliases.*;
import org.clang.ast.java.AstJavaDifferentiators.*;


/// \brief An UnresolvedSet-like class which uses the ASTContext's allocator.
//<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 24,
 FQN="clang::ASTUnresolvedSet", NM="_ZN5clang16ASTUnresolvedSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSetE")
//</editor-fold>
public class ASTUnresolvedSet implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::DeclsTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 25,
   FQN="clang::ASTUnresolvedSet::DeclsTy", NM="_ZN5clang16ASTUnresolvedSet7DeclsTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSet7DeclsTyE")
  //</editor-fold>
  /*friend*/protected/*private*/ static class/*struct*/ DeclsTy extends /**/ ASTVector<DeclAccessPair> implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::DeclsTy::DeclsTy">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 26,
     FQN="clang::ASTUnresolvedSet::DeclsTy::DeclsTy", NM="_ZN5clang16ASTUnresolvedSet7DeclsTyC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSet7DeclsTyC1Ev")
    //</editor-fold>
    public DeclsTy() {
      // : ASTVector<DeclAccessPair>() 
      //START JInit
      super(DeclAccessPair.DEFAULT);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::DeclsTy::DeclsTy">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 27,
     FQN="clang::ASTUnresolvedSet::DeclsTy::DeclsTy", NM="_ZN5clang16ASTUnresolvedSet7DeclsTyC1ERNS_10ASTContextEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSet7DeclsTyC1ERNS_10ASTContextEj")
    //</editor-fold>
    public DeclsTy(final ASTContext /*&*/ C, /*uint*/int N) {
      // : ASTVector<DeclAccessPair>(C, N) 
      //START JInit
      super(C, N, DeclAccessPair.DEFAULT);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::DeclsTy::isLazy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 29,
     FQN="clang::ASTUnresolvedSet::DeclsTy::isLazy", NM="_ZNK5clang16ASTUnresolvedSet7DeclsTy6isLazyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang16ASTUnresolvedSet7DeclsTy6isLazyEv")
    //</editor-fold>
    public boolean isLazy() /*const*/ {
      return getTag();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::DeclsTy::setLazy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 30,
     FQN="clang::ASTUnresolvedSet::DeclsTy::setLazy", NM="_ZN5clang16ASTUnresolvedSet7DeclsTy7setLazyEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSet7DeclsTy7setLazyEb")
    //</editor-fold>
    public void setLazy(boolean Lazy) {
      setTag(Lazy);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::DeclsTy::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 25,
     FQN="clang::ASTUnresolvedSet::DeclsTy::operator=", NM="_ZN5clang16ASTUnresolvedSet7DeclsTyaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSet7DeclsTyaSEOS1_")
    //</editor-fold>
    public /*inline*/ DeclsTy /*&*/ $assignMove(final DeclsTy /*&&*/$Prm0) {
      /*Deref*/super.$assignMove($Prm0);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::DeclsTy::~DeclsTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 25,
     FQN="clang::ASTUnresolvedSet::DeclsTy::~DeclsTy", NM="_ZN5clang16ASTUnresolvedSet7DeclsTyD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSet7DeclsTyD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      super.$destroy();
    }

    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
  
  /*friend*/protected final /*private*/ DeclsTy Decls;
  
  /*friend  class LazyASTUnresolvedSet*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::ASTUnresolvedSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 38,
   FQN="clang::ASTUnresolvedSet::ASTUnresolvedSet", NM="_ZN5clang16ASTUnresolvedSetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSetC1Ev")
  //</editor-fold>
  public ASTUnresolvedSet() {
    // : Decls() 
    //START JInit
    this.Decls = new DeclsTy();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::ASTUnresolvedSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 39,
   FQN="clang::ASTUnresolvedSet::ASTUnresolvedSet", NM="_ZN5clang16ASTUnresolvedSetC1ERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSetC1ERNS_10ASTContextEj")
  //</editor-fold>
  public ASTUnresolvedSet(final ASTContext /*&*/ C, /*uint*/int N) {
    // : Decls(C, N) 
    //START JInit
    this.Decls = new DeclsTy(C, N);
    //END JInit
  }

  
  /*typedef UnresolvedSetIterator iterator*/
//  public final class iterator extends UnresolvedSetIterator{ };
  /*typedef UnresolvedSetIterator const_iterator*/
//  public final class const_iterator extends UnresolvedSetIterator{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 44,
   FQN="clang::ASTUnresolvedSet::begin", NM="_ZN5clang16ASTUnresolvedSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSet5beginEv")
  //</editor-fold>
  public UnresolvedSetIterator begin() {
    return new UnresolvedSetIterator(JD$DeclAccessPair$P.INSTANCE, Decls.begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 45,
   FQN="clang::ASTUnresolvedSet::end", NM="_ZN5clang16ASTUnresolvedSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSet3endEv")
  //</editor-fold>
  public UnresolvedSetIterator end() {
    return new UnresolvedSetIterator(JD$DeclAccessPair$P.INSTANCE, Decls.end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 47,
   FQN="clang::ASTUnresolvedSet::begin", NM="_ZNK5clang16ASTUnresolvedSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang16ASTUnresolvedSet5beginEv")
  //</editor-fold>
  public UnresolvedSetIterator begin$Const() /*const*/ {
    return new UnresolvedSetIterator(JD$DeclAccessPair$C$P.INSTANCE, Decls.begin$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 48,
   FQN="clang::ASTUnresolvedSet::end", NM="_ZNK5clang16ASTUnresolvedSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang16ASTUnresolvedSet3endEv")
  //</editor-fold>
  public UnresolvedSetIterator end$Const() /*const*/ {
    return new UnresolvedSetIterator(JD$DeclAccessPair$C$P.INSTANCE, Decls.end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::addDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 50,
   FQN="clang::ASTUnresolvedSet::addDecl", NM="_ZN5clang16ASTUnresolvedSet7addDeclERNS_10ASTContextEPNS_9NamedDeclENS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSet7addDeclERNS_10ASTContextEPNS_9NamedDeclENS_15AccessSpecifierE")
  //</editor-fold>
  public void addDecl(final ASTContext /*&*/ C, NamedDecl /*P*/ D, AccessSpecifier AS) {
    Decls.push_back(DeclAccessPair.make(D, AS), C);
  }

  
  /// Replaces the given declaration with the new one, once.
  ///
  /// \return true if the set changed
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::replace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 57,
   FQN="clang::ASTUnresolvedSet::replace", NM="_ZN5clang16ASTUnresolvedSet7replaceEPKNS_9NamedDeclEPS1_NS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSet7replaceEPKNS_9NamedDeclEPS1_NS_15AccessSpecifierE")
  //</editor-fold>
  public boolean replace(/*const*/ NamedDecl /*P*/ Old, NamedDecl /*P*/ New, AccessSpecifier AS) {
    for (type$ptr<DeclAccessPair /*P*/ > I = $tryClone(Decls.begin()), /*P*/ E = $tryClone(Decls.end()); $noteq_ptr(I, E); I.$preInc()) {
      if (I./*->*/$star().getDecl() == Old) {
        I./*->*/$star().set(New, AS);
        return true;
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::erase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 67,
   FQN="clang::ASTUnresolvedSet::erase", NM="_ZN5clang16ASTUnresolvedSet5eraseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSet5eraseEj")
  //</editor-fold>
  public void erase(/*uint*/int I) {
    Decls.$at(I).$assignMove(Decls.pop_back_val());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 69,
   FQN="clang::ASTUnresolvedSet::clear", NM="_ZN5clang16ASTUnresolvedSet5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSet5clearEv")
  //</editor-fold>
  public void clear() {
    Decls.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 71,
   FQN="clang::ASTUnresolvedSet::empty", NM="_ZNK5clang16ASTUnresolvedSet5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang16ASTUnresolvedSet5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Decls.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 72,
   FQN="clang::ASTUnresolvedSet::size", NM="_ZNK5clang16ASTUnresolvedSet4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang16ASTUnresolvedSet4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Decls.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::reserve">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 74,
   FQN="clang::ASTUnresolvedSet::reserve", NM="_ZN5clang16ASTUnresolvedSet7reserveERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSet7reserveERNS_10ASTContextEj")
  //</editor-fold>
  public void reserve(final ASTContext /*&*/ C, /*uint*/int N) {
    Decls.reserve(C, N);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::append">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 78,
   FQN="clang::ASTUnresolvedSet::append", NM="_ZN5clang16ASTUnresolvedSet6appendERNS_10ASTContextENS_21UnresolvedSetIteratorES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSet6appendERNS_10ASTContextENS_21UnresolvedSetIteratorES3_")
  //</editor-fold>
  public void append(final ASTContext /*&*/ C, UnresolvedSetIterator I, UnresolvedSetIterator E) {
    Decls.append_ASTContext$C_T(C, I.I, E.I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 82,
   FQN="clang::ASTUnresolvedSet::operator[]", NM="_ZN5clang16ASTUnresolvedSetixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSetixEj")
  //</editor-fold>
  public DeclAccessPair /*&*/ $at(/*uint*/int I) {
    return Decls.$at(I);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 83,
   FQN="clang::ASTUnresolvedSet::operator[]", NM="_ZNK5clang16ASTUnresolvedSetixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang16ASTUnresolvedSetixEj")
  //</editor-fold>
  public /*const*/ DeclAccessPair /*&*/ $at$Const(/*uint*/int I) /*const*/ {
    return Decls.$at$Const(I);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 24,
   FQN="clang::ASTUnresolvedSet::operator=", NM="_ZN5clang16ASTUnresolvedSetaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSetaSEOS0_")
  //</editor-fold>
  public /*inline*/ ASTUnresolvedSet /*&*/ $assignMove(final ASTUnresolvedSet /*&&*/$Prm0) {
    this.Decls.$assignMove($Prm0.Decls);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTUnresolvedSet::~ASTUnresolvedSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTUnresolvedSet.h", line = 24,
   FQN="clang::ASTUnresolvedSet::~ASTUnresolvedSet", NM="_ZN5clang16ASTUnresolvedSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang16ASTUnresolvedSetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Decls.$destroy();
    //END JDestroy
  }

  /**
   * Used by deserialization
   */
  public void addDecl(final ASTContext /*&*/ C, /*NamedDecl P*/int D, AccessSpecifier AS) {
    Decls.push_back(DeclAccessPair.make(D, AS), C);
  }
  
  @Override public String toString() {
    return "" + "Decls=" + Decls; // NOI18N
  }
}
