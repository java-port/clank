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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import static org.clang.sema.impl.IdentifierResolverStatics.*;
import org.clank.java.std;


/// IdentifierResolver - Keeps track of shadowed decls on enclosing
/// scopes.  It manages the shadowing chains of declaration names and
/// implements efficient decl lookup based on a declaration name.
//<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 35,
 FQN="clang::IdentifierResolver", NM="_ZN5clang18IdentifierResolverE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolverE")
//</editor-fold>
public class IdentifierResolver implements Destructors.ClassWithDestructor {
  
  /// IdDeclInfo - Keeps track of information about decls associated
  /// to a particular declaration name. IdDeclInfos are lazily
  /// constructed and assigned to a declaration name the first time a
  /// decl with that declaration name is shadowed in some scope.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdDeclInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 41,
   FQN="clang::IdentifierResolver::IdDeclInfo", NM="_ZN5clang18IdentifierResolver10IdDeclInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver10IdDeclInfoE")
  //</editor-fold>
  private static class IdDeclInfo implements Destructors.ClassWithDestructor {
  /*public:*/
    /*typedef SmallVector<NamedDecl *, 2> DeclsTy*/
//    public final class DeclsTy extends SmallVector<NamedDecl /*P*/ >{ };
    
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdDeclInfo::decls_begin">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 45,
     FQN="clang::IdentifierResolver::IdDeclInfo::decls_begin", NM="_ZN5clang18IdentifierResolver10IdDeclInfo11decls_beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver10IdDeclInfo11decls_beginEv")
    //</editor-fold>
    public /*inline*/ type$ptr<NamedDecl /*P*/ /*P*/> decls_begin() {
      return Decls.begin();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdDeclInfo::decls_end">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 46,
     FQN="clang::IdentifierResolver::IdDeclInfo::decls_end", NM="_ZN5clang18IdentifierResolver10IdDeclInfo9decls_endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver10IdDeclInfo9decls_endEv")
    //</editor-fold>
    public /*inline*/ type$ptr<NamedDecl /*P*/ /*P*/> decls_end() {
      return Decls.end();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdDeclInfo::AddDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 48,
     FQN="clang::IdentifierResolver::IdDeclInfo::AddDecl", NM="_ZN5clang18IdentifierResolver10IdDeclInfo7AddDeclEPNS_9NamedDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver10IdDeclInfo7AddDeclEPNS_9NamedDeclE")
    //</editor-fold>
    public void AddDecl(NamedDecl /*P*/ D) {
      Decls.push_back(D);
    }

    
    /// RemoveDecl - Remove the decl from the scope chain.
    /// The decl must already be part of the decl chain.
    
    //===----------------------------------------------------------------------===//
    // IdDeclInfo Implementation
    //===----------------------------------------------------------------------===//
    
    /// RemoveDecl - Remove the decl from the scope chain.
    /// The decl must already be part of the decl chain.
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdDeclInfo::RemoveDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 70,
     FQN="clang::IdentifierResolver::IdDeclInfo::RemoveDecl", NM="_ZN5clang18IdentifierResolver10IdDeclInfo10RemoveDeclEPNS_9NamedDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver10IdDeclInfo10RemoveDeclEPNS_9NamedDeclE")
    //</editor-fold>
    public void RemoveDecl(NamedDecl /*P*/ D) {
      for (type$ptr<NamedDecl /*P*/ /*P*/> I = $tryClone(Decls.end()); $noteq_ptr(I, Decls.begin()); I.$preDec()) {
        if (D == (I.$sub(1)).$star()) {
          Decls.erase(I.$sub(1));
          return;
        }
      }
      throw new llvm_unreachable("Didn't find this decl on its identifier's chain!");
    }

    
    /// \brief Insert the given declaration at the given position in the list.
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdDeclInfo::InsertDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 55,
     FQN="clang::IdentifierResolver::IdDeclInfo::InsertDecl", NM="_ZN5clang18IdentifierResolver10IdDeclInfo10InsertDeclEPPNS_9NamedDeclES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver10IdDeclInfo10InsertDeclEPPNS_9NamedDeclES3_")
    //</editor-fold>
    public void InsertDecl(type$ptr<NamedDecl /*P*/ /*P*/> Pos, NamedDecl /*P*/ D) {
      Decls.insert(Pos, D);
    }

  /*private:*/
    private SmallVector<NamedDecl /*P*/ > Decls;
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdDeclInfo::IdDeclInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 41,
     FQN="clang::IdentifierResolver::IdDeclInfo::IdDeclInfo", NM="_ZN5clang18IdentifierResolver10IdDeclInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver10IdDeclInfoC1Ev")
    //</editor-fold>
    public /*inline*/ IdDeclInfo() {
      // : Decls() 
      //START JInit
      this.Decls = new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdDeclInfo::~IdDeclInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 41,
     FQN="clang::IdentifierResolver::IdDeclInfo::~IdDeclInfo", NM="_ZN5clang18IdentifierResolver10IdDeclInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver10IdDeclInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Decls.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Decls=" + Decls.size(); // NOI18N
    }
  };
/*public:*/
  
  /// iterator - Iterate over the decls of a specified declaration name.
  /// It will walk or not the parent declaration contexts depending on how
  /// it was instantiated.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 68,
   FQN="clang::IdentifierResolver::iterator", NM="_ZN5clang18IdentifierResolver8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver8iteratorE")
  //</editor-fold>
  public static class iterator implements Native.assignable<iterator>, type$iterator<iterator, NamedDecl /*P*/> {
  /*public:*/
    /*typedef NamedDecl *value_type*/
//    public final class value_type extends NamedDecl /*P*/ { };
    /*typedef NamedDecl *reference*/
//    public final class reference extends NamedDecl /*P*/ { };
    /*typedef NamedDecl *pointer*/
//    public final class pointer extends NamedDecl /*P*/ { };
    /*typedef std::input_iterator_tag iterator_category*/
//    public final class iterator_category extends std.input_iterator_tag{ };
    /*typedef std::ptrdiff_t difference_type*/;
    
    /// Ptr - There are 3 forms that 'Ptr' represents:
    /// 1) A single NamedDecl. (Ptr & 0x1 == 0)
    /// 2) A IdDeclInfo::DeclsTy::iterator that traverses only the decls of the
    ///    same declaration context. (Ptr & 0x3 == 0x1)
    /// 3) A IdDeclInfo::DeclsTy::iterator that traverses the decls of parent
    ///    declaration contexts too. (Ptr & 0x3 == 0x3)    
    /// JAVA: ($lower$bits & 0x1 == 0)   => NamedDecl (Java reference)
    /// JAVA: ($lower$bits & 0x3 == 0x1) => type$ptr<NamedDecl> that traverses only the decls of the same declaration context
    /// JAVA: ($lower$bits & 0x3 == 0x3) => type$ptr<NamedDecl> that traverses the decls of parent declaration contexts too
    public Object/*uintptr_t*/ Ptr;
    /*typedef IdDeclInfo::DeclsTy::iterator BaseIter*/
//    public final class BaseIter extends type$ptr<NamedDecl /*P*/ /*P*/>{ };
    
    /// A single NamedDecl. (Ptr & 0x1 == 0)
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator::iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 86,
     FQN="clang::IdentifierResolver::iterator::iterator", NM="_ZN5clang18IdentifierResolver8iteratorC1EPNS_9NamedDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver8iteratorC1EPNS_9NamedDeclE")
    //</editor-fold>
    public iterator(JD$NamedDecl$P _dparam, NamedDecl /*P*/ D) {
      Ptr = reinterpret_cast_Object/*uintptr_t*/(D);
      $lower$bits = 0;
    }

    /// A IdDeclInfo::DeclsTy::iterator that walks or not the parent declaration
    /// contexts depending on 'LookInParentCtx'.
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator::iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 92,
     FQN="clang::IdentifierResolver::iterator::iterator", NM="_ZN5clang18IdentifierResolver8iteratorC1EPPNS_9NamedDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver8iteratorC1EPPNS_9NamedDeclE")
    //</editor-fold>
    public iterator(JD$NamedDecl$P _dparam, type$ptr<NamedDecl> /*P*/ I) {
      Ptr = $tryConstClone(I); //  | 0x1;
      $lower$bits = 0x1;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator::isIterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 96,
     FQN="clang::IdentifierResolver::iterator::isIterator", NM="_ZNK5clang18IdentifierResolver8iterator10isIteratorEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZNK5clang18IdentifierResolver8iterator10isIteratorEv")
    //</editor-fold>
    public boolean isIterator() /*const*/ {
      return (($lower$bits & 0x1) != 0);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator::getIterator">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 98,
     FQN="clang::IdentifierResolver::iterator::getIterator", NM="_ZNK5clang18IdentifierResolver8iterator11getIteratorEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZNK5clang18IdentifierResolver8iterator11getIteratorEv")
    //</editor-fold>
    public type$ptr<NamedDecl> /*P*/ getIterator() /*const*/ {
      assert (isIterator()) : "Ptr not an iterator!";
      return $tryClone((type$ptr<NamedDecl>) Ptr); // return reinterpret_cast<BaseIter>(Ptr & ~0x3);
    }

    
    /*friend  class IdentifierResolver*/
    
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator::incrementSlowCase">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 411,
     FQN="clang::IdentifierResolver::iterator::incrementSlowCase", NM="_ZN5clang18IdentifierResolver8iterator17incrementSlowCaseEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver8iterator17incrementSlowCaseEv")
    //</editor-fold>
    public void incrementSlowCase() {
      NamedDecl /*P*/ D = $Deref(this.$star());
      Object/*void P*/ InfoPtr = D.getDeclName().getFETokenInfo();
      assert (!isDeclPtr(InfoPtr)) : "Decl with wrong id ?";
      IdDeclInfo /*P*/ Info = toIdDeclInfo(InfoPtr);
      
      type$ptr<NamedDecl> /*P*/ I = getIterator();
      if (I.$noteq(Info.decls_begin())) { // JAVA: why not added $noteq???
        /*Deref*/this.$assignMove(new iterator(JD$NamedDecl$P.INSTANCE, I.$sub(1)));
      } else { // No more decls.
        /*Deref*/this.$assignMove(new iterator());
      }
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator::iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 107,
     FQN="clang::IdentifierResolver::iterator::iterator", NM="_ZN5clang18IdentifierResolver8iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver8iteratorC1Ev")
    //</editor-fold>
    public iterator() {
      // : Ptr(0) 
      //START JInit
      this.Ptr = null;
      //END JInit
      $lower$bits = 0x0;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator::operator*">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 109,
     FQN="clang::IdentifierResolver::iterator::operator*", NM="_ZNK5clang18IdentifierResolver8iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZNK5clang18IdentifierResolver8iteratordeEv")
    //</editor-fold>
    public NamedDecl /*P*/ $star() /*const*/ {
      if (isIterator()) {
        return $Deref(getIterator().$arrow());
      } else {
        return reinterpret_cast(NamedDecl /*P*/ .class, Ptr);
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator::operator==">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 116,
     FQN="clang::IdentifierResolver::iterator::operator==", NM="_ZNK5clang18IdentifierResolver8iteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZNK5clang18IdentifierResolver8iteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ iterator /*&*/ RHS) /*const*/ {
      return Native.$eq_ptr(this.Ptr, RHS.Ptr);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator::operator!=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 119,
     FQN="clang::IdentifierResolver::iterator::operator!=", NM="_ZNK5clang18IdentifierResolver8iteratorneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZNK5clang18IdentifierResolver8iteratorneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ iterator /*&*/ RHS) /*const*/ {
      return !$eq(RHS);
    }

    
    // Preincrement.
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 124,
     FQN="clang::IdentifierResolver::iterator::operator++", NM="_ZN5clang18IdentifierResolver8iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver8iteratorppEv")
    //</editor-fold>
    public iterator /*&*/ $preInc() {
      if (!isIterator()) { // common case.
        Ptr = null;
        assert this.$lower$bits == 0x0 : "Unexpected bit marker " + $lower$bits;
      } else {
        assert (this.$lower$bits & 0x1) == 0x1 : "Unexpected bit marker " + $lower$bits;
        incrementSlowCase();
      }
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator::getAsOpaqueValue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 132,
     FQN="clang::IdentifierResolver::iterator::getAsOpaqueValue", NM="_ZNK5clang18IdentifierResolver8iterator16getAsOpaqueValueEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZNK5clang18IdentifierResolver8iterator16getAsOpaqueValueEv")
    //</editor-fold>
    public Object/*uintptr_t*/ getAsOpaqueValue() /*const*/ {
      return Ptr;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator::getFromOpaqueValue">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 134,
     FQN="clang::IdentifierResolver::iterator::getFromOpaqueValue", NM="_ZN5clang18IdentifierResolver8iterator18getFromOpaqueValueEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver8iterator18getFromOpaqueValueEj")
    //</editor-fold>
    public static iterator getFromOpaqueValue(Object/*uintptr_t*/ P) {
      iterator Result/*J*/= new iterator();
      if (P instanceof type$ptr) {
        Result.Ptr = $tryConstClone(P);
        Result.$lower$bits = 0x1;/// 0x1 vs 0x3???
      } else {
        Result.Ptr = P;
        Result.$lower$bits = 0x0;
      }
      return Result;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator::iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 68,
     FQN="clang::IdentifierResolver::iterator::iterator", NM="_ZN5clang18IdentifierResolver8iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver8iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ iterator(JD$Move _dparam, final iterator /*&&*/$Prm0) {
      // : Ptr(static_cast<iterator &&>().Ptr) 
      //START JInit
      this.Ptr = $Prm0.Ptr;
      this.$lower$bits = $Prm0.$lower$bits;
      //END JInit
      $Prm0.Ptr = null;
      $Prm0.$lower$bits = 0;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 68,
     FQN="clang::IdentifierResolver::iterator::operator=", NM="_ZN5clang18IdentifierResolver8iteratoraSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver8iteratoraSEOS1_")
    //</editor-fold>
    public /*inline*/ iterator /*&*/ $assignMove(final iterator /*&&*/$Prm0) {
      this.Ptr = $Prm0.Ptr;
      this.$lower$bits = $Prm0.$lower$bits;
      $Prm0.Ptr = null;
      $Prm0.$lower$bits = 0;
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::iterator::iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 68,
     FQN="clang::IdentifierResolver::iterator::iterator", NM="_ZN5clang18IdentifierResolver8iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang18IdentifierResolver8iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ iterator(final /*const*/ iterator /*&*/ $Prm0) {
      // : Ptr(.Ptr) 
      //START JInit
      this.Ptr = $Prm0.Ptr instanceof type$ptr ? $tryConstClone($Prm0.Ptr) : $Prm0.Ptr;
      this.$lower$bits = $Prm0.$lower$bits;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    char $lower$bits; // FIXME: can be replaced by instanceof if 0x3 is not used (and I can not find it's usage)

    @Override public iterator clone() { return new iterator(this); }

    @Override
    public iterator $assign(iterator $Prm0) {
      this.Ptr = $Prm0.Ptr instanceof type$ptr ? $tryConstClone($Prm0.Ptr) : $Prm0.Ptr;
      this.$lower$bits = $Prm0.$lower$bits;     
      return this;
    }

    @Override
    public boolean $eq(Object other) {
      return $eq((iterator)other);
    }

    @Override
    public int $sub(iterator iter) {
      return std.distance(iter, this, JD$FAKE.TRAILING);
    }
    
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "Ptr=" + Ptr; // NOI18N
    }
  };
  
  /// begin - Returns an iterator for decls with the name 'Name'.
  
  /// begin - Returns an iterator for decls with name 'Name'.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 227,
   FQN="clang::IdentifierResolver::begin", NM="_ZN5clang18IdentifierResolver5beginENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver5beginENS_15DeclarationNameE")
  //</editor-fold>
  public IdentifierResolver.iterator begin(DeclarationName Name) {
    {
      IdentifierInfo /*P*/ II = Name.getAsIdentifierInfo();
      if ((II != null)) {
        readingIdentifier($Deref(II));
      }
    }
    
    Object/*void P*/ Ptr = Name.getFETokenInfo();
    if (!(Ptr != null)) {
      return end();
    }
    if (isDeclPtr(Ptr)) {
      return new iterator(JD$NamedDecl$P.INSTANCE, ((/*static_cast*/NamedDecl /*P*/ )(Ptr)));
    }
    
    IdDeclInfo /*P*/ IDI = toIdDeclInfo(Ptr);
    
    type$ptr<NamedDecl /*P*/ /*P*/> I = $tryClone(IDI.decls_end());
    if ($noteq_ptr(I, IDI.decls_begin())) {
      return new iterator(JD$NamedDecl$P.INSTANCE, I.$sub(1));
    }
    // No decls found.
    return end();
  }

  
  /// end - Returns an iterator that has 'finished'.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 145,
   FQN="clang::IdentifierResolver::end", NM="_ZN5clang18IdentifierResolver3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver3endEv")
  //</editor-fold>
  public iterator end() {
    return new iterator();
  }

  
  /// isDeclInScope - If 'Ctx' is a function/method, isDeclInScope returns true
  /// if 'D' is in Scope 'S', otherwise 'S' is ignored and isDeclInScope returns
  /// true if 'D' belongs to the given declaration context.
  ///
  /// \param AllowInlineNamespace If \c true, we are checking whether a prior
  ///        declaration is in scope in a declaration that requires a prior
  ///        declaration (because it is either explicitly qualified or is a
  ///        template instantiation or specialization). In this case, a
  ///        declaration is in scope if it's in the inline namespace set of the
  ///        context.
  
  /// isDeclInScope - If 'Ctx' is a function/method, isDeclInScope returns true
  /// if 'D' is in Scope 'S', otherwise 'S' is ignored and isDeclInScope returns
  /// true if 'D' belongs to the given declaration context.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::isDeclInScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 97,
   FQN="clang::IdentifierResolver::isDeclInScope", NM="_ZNK5clang18IdentifierResolver13isDeclInScopeEPNS_4DeclEPNS_11DeclContextEPNS_5ScopeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZNK5clang18IdentifierResolver13isDeclInScopeEPNS_4DeclEPNS_11DeclContextEPNS_5ScopeEb")
  //</editor-fold>
  public boolean isDeclInScope(Decl /*P*/ D, DeclContext /*P*/ Ctx) /*const*/ {
    return isDeclInScope(D, Ctx, (Scope /*P*/ )null, 
               false);
  }
  public boolean isDeclInScope(Decl /*P*/ D, DeclContext /*P*/ Ctx, Scope /*P*/ S/*= null*/) /*const*/ {
    return isDeclInScope(D, Ctx, S, 
               false);
  }
  public boolean isDeclInScope(Decl /*P*/ D, DeclContext /*P*/ Ctx, Scope /*P*/ S/*= null*/, 
               boolean AllowInlineNamespace/*= false*/) /*const*/ {
    Ctx = Ctx.getRedeclContext();
    if (Ctx.isFunctionOrMethod() || ((S != null) && S.isFunctionPrototypeScope())) {
      // Ignore the scopes associated within transparent declaration contexts.
      while ((S.getEntity() != null) && S.getEntity().isTransparentContext()) {
        S = S.getParent();
      }
      if (S.isDeclScope(D)) {
        return true;
      }
      if (LangOpt.CPlusPlus) {
        // C++ 3.3.2p3:
        // The name declared in a catch exception-declaration is local to the
        // handler and shall not be redeclared in the outermost block of the
        // handler.
        // C++ 3.3.2p4:
        // Names declared in the for-init-statement, and in the condition of if,
        // while, for, and switch statements are local to the if, while, for, or
        // switch statement (including the controlled statement), and shall not be
        // redeclared in a subsequent condition of that statement nor in the
        // outermost block (or, for the if statement, any of the outermost blocks)
        // of the controlled statement.
        //
        assert ((S.getParent() != null)) : "No TUScope?";
        if (((S.getParent().getFlags() & Scope.ScopeFlags.ControlScope) != 0)) {
          S = S.getParent();
          if (S.isDeclScope(D)) {
            return true;
          }
        }
        if (((S.getFlags() & Scope.ScopeFlags.FnTryCatchScope) != 0)) {
          return S.getParent().isDeclScope(D);
        }
      }
      return false;
    }
    
    // FIXME: If D is a local extern declaration, this check doesn't make sense;
    // we should be checking its lexical context instead in that case, because
    // that is its scope.
    DeclContext /*P*/ DCtx = D.getDeclContext().getRedeclContext();
    return AllowInlineNamespace ? Ctx.InEnclosingNamespaceSetOf(DCtx) : Ctx.Equals(DCtx);
  }

  
  /// AddDecl - Link the decl to its shadowed decl chain.
  
  /// AddDecl - Link the decl to its shadowed decl chain.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::AddDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 142,
   FQN="clang::IdentifierResolver::AddDecl", NM="_ZN5clang18IdentifierResolver7AddDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver7AddDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public void AddDecl(NamedDecl /*P*/ D) {
    DeclarationName Name = D.getDeclName();
    {
      IdentifierInfo /*P*/ II = Name.getAsIdentifierInfo();
      if ((II != null)) {
        updatingIdentifier($Deref(II));
      }
    }
    
    Object/*void P*/ Ptr = Name.getFETokenInfo();
    if (!(Ptr != null)) {
      Name.setFETokenInfo(D);
      return;
    }
    
    IdDeclInfo /*P*/ IDI;
    if (isDeclPtr(Ptr)) {
      Name.setFETokenInfo((Object/*void P*/ )null);
      IDI = $AddrOf((/*Deref*/IdDeclInfos).$at(/*NO_COPY*/Name));
      NamedDecl /*P*/ PrevD = ((/*static_cast*/NamedDecl /*P*/ )(Ptr));
      IDI.AddDecl(PrevD);
    } else {
      IDI = toIdDeclInfo(Ptr);
    }
    
    IDI.AddDecl(D);
  }

  
  /// RemoveDecl - Unlink the decl from its shadowed decl chain.
  /// The decl must already be part of the decl chain.
  
  /// RemoveDecl - Unlink the decl from its shadowed decl chain.
  /// The decl must already be part of the decl chain.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::RemoveDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 207,
   FQN="clang::IdentifierResolver::RemoveDecl", NM="_ZN5clang18IdentifierResolver10RemoveDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver10RemoveDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public void RemoveDecl(NamedDecl /*P*/ D) {
    assert ((D != null)) : "null param passed";
    DeclarationName Name = D.getDeclName();
    {
      IdentifierInfo /*P*/ II = Name.getAsIdentifierInfo();
      if ((II != null)) {
        updatingIdentifier($Deref(II));
      }
    }
    
    Object/*void P*/ Ptr = Name.getFETokenInfo();
    assert ((Ptr != null)) : "Didn't find this decl on its identifier's chain!";
    if (isDeclPtr(Ptr)) {
      assert ($eq_ptr(D, Ptr)) : "Didn't find this decl on its identifier's chain!";
      Name.setFETokenInfo((Object/*void P*/ )null);
      return;
    }
    
    toIdDeclInfo(Ptr).RemoveDecl(D);
    /*JAVA:return*/return;
  }

  
  /// \brief Insert the given declaration after the given iterator
  /// position.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::InsertDeclAfter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 167,
   FQN="clang::IdentifierResolver::InsertDeclAfter", NM="_ZN5clang18IdentifierResolver15InsertDeclAfterENS0_8iteratorEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver15InsertDeclAfterENS0_8iteratorEPNS_9NamedDeclE")
  //</editor-fold>
  public void InsertDeclAfter(iterator Pos, NamedDecl /*P*/ D) {
    DeclarationName Name = D.getDeclName();
    {
      IdentifierInfo /*P*/ II = Name.getAsIdentifierInfo();
      if ((II != null)) {
        updatingIdentifier($Deref(II));
      }
    }
    
    Object/*void P*/ Ptr = Name.getFETokenInfo();
    if (!(Ptr != null)) {
      AddDecl(D);
      return;
    }
    if (isDeclPtr(Ptr)) {
      // We only have a single declaration: insert before or after it,
      // as appropriate.
      if (Pos.$eq(new iterator())) {
        // Add the new declaration before the existing declaration.
        NamedDecl /*P*/ PrevD = ((/*static_cast*/NamedDecl /*P*/ )(Ptr));
        RemoveDecl(PrevD);
        AddDecl(D);
        AddDecl(PrevD);
      } else {
        // Add new declaration after the existing declaration.
        AddDecl(D);
      }
      
      return;
    }
    
    // General case: insert the declaration at the appropriate point in the 
    // list, which already has at least two elements.
    IdDeclInfo /*P*/ IDI = toIdDeclInfo(Ptr);
    if (Pos.isIterator()) {
      IDI.InsertDecl(Pos.getIterator().$add(1), D);
    } else {
      IDI.InsertDecl(IDI.decls_begin(), D);
    }
  }

  
  /// \brief Try to add the given declaration to the top level scope, if it
  /// (or a redeclaration of it) hasn't already been added.
  ///
  /// \param D The externally-produced declaration to add.
  ///
  /// \param Name The name of the externally-produced declaration.
  ///
  /// \returns true if the declaration was added, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::tryAddTopLevelDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 298,
   FQN="clang::IdentifierResolver::tryAddTopLevelDecl", NM="_ZN5clang18IdentifierResolver18tryAddTopLevelDeclEPNS_9NamedDeclENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver18tryAddTopLevelDeclEPNS_9NamedDeclENS_15DeclarationNameE")
  //</editor-fold>
  public boolean tryAddTopLevelDecl(NamedDecl /*P*/ D, DeclarationName Name) {
    {
      IdentifierInfo /*P*/ II = Name.getAsIdentifierInfo();
      if ((II != null)) {
        readingIdentifier($Deref(II));
      }
    }
    
    Object/*void P*/ Ptr = Name.getFETokenInfo();
    if (!(Ptr != null)) {
      Name.setFETokenInfo(D);
      return true;
    }
    
    IdDeclInfo /*P*/ IDI;
    if (isDeclPtr(Ptr)) {
      NamedDecl /*P*/ PrevD = ((/*static_cast*/NamedDecl /*P*/ )(Ptr));
      switch (compareDeclarations(PrevD, D)) {
       case DMK_Different:
        break;
       case DMK_Ignore:
        return false;
       case DMK_Replace:
        Name.setFETokenInfo(D);
        return true;
      }
      
      Name.setFETokenInfo((Object/*void P*/ )null);
      IDI = $AddrOf((/*Deref*/IdDeclInfos).$at(/*NO_COPY*/Name));
      
      // If the existing declaration is not visible in translation unit scope,
      // then add the new top-level declaration first.
      if (!PrevD.getDeclContext().getRedeclContext().isTranslationUnit()) {
        IDI.AddDecl(D);
        IDI.AddDecl(PrevD);
      } else {
        IDI.AddDecl(PrevD);
        IDI.AddDecl(D);
      }
      return true;
    }
    
    IDI = toIdDeclInfo(Ptr);
    
    // See whether this declaration is identical to any existing declarations.
    // If not, find the right place to insert it.
    for (type$ptr<NamedDecl /*P*/ /*P*/> I = $tryClone(IDI.decls_begin()), 
        /*P*/ IEnd = $tryClone(IDI.decls_end());
         $noteq_ptr(I, IEnd); I.$preInc()) {
      switch (compareDeclarations(I.$star(), D)) {
       case DMK_Different:
        break;
       case DMK_Ignore:
        return false;
       case DMK_Replace:
        I.$set(D);
        return true;
      }
      if (!(I.$star()).getDeclContext().getRedeclContext().isTranslationUnit()) {
        // We've found a declaration that is not visible from the translation
        // unit (it's in an inner scope). Insert our declaration here.
        IDI.InsertDecl(I, D);
        return true;
      }
    }
    
    // Add the declaration to the end.
    IDI.AddDecl(D);
    return true;
  }

  
  
  //===----------------------------------------------------------------------===//
  // IdentifierResolver Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdentifierResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 85,
   FQN="clang::IdentifierResolver::IdentifierResolver", NM="_ZN5clang18IdentifierResolverC1ERNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolverC1ERNS_12PreprocessorE")
  //</editor-fold>
  public IdentifierResolver(final Preprocessor /*&*/ PP) {
    // : LangOpt(PP.getLangOpts()), PP(PP), IdDeclInfos(new IdDeclInfoMap) 
    //START JInit
    this./*&*/LangOpt=/*&*/PP.getLangOpts();
    this./*&*/PP=/*&*/PP;
    this.IdDeclInfos = new IdDeclInfoMap();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::~IdentifierResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 90,
   FQN="clang::IdentifierResolver::~IdentifierResolver", NM="_ZN5clang18IdentifierResolverD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolverD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (IdDeclInfos != null) { IdDeclInfos.$destroy();};
  }

/*private:*/
  private final /*const*/ LangOptions /*&*/ LangOpt;
  private final Preprocessor /*&*/ PP;
  
  
  //===----------------------------------------------------------------------===//
  // IdDeclInfoMap class
  //===----------------------------------------------------------------------===//
  
  /// IdDeclInfoMap - Associates IdDeclInfos with declaration names.
  /// Allocates 'pools' (vectors of IdDeclInfos) to avoid allocating each
  /// individual IdDeclInfo to heap.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdDeclInfoMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 31,
   FQN="clang::IdentifierResolver::IdDeclInfoMap", NM="_ZN5clang18IdentifierResolver13IdDeclInfoMapE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver13IdDeclInfoMapE")
  //</editor-fold>
  private static class IdDeclInfoMap implements Destructors.ClassWithDestructor {
    private static /*const*//*uint*/int POOL_SIZE = 512;
    
    /// We use our own linked-list implementation because it is sadly
    /// impossible to add something to a pre-C++0x STL container without
    /// a completely unnecessary copy.
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdDeclInfoMap::IdDeclInfoPool">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 37,
     FQN="clang::IdentifierResolver::IdDeclInfoMap::IdDeclInfoPool", NM="_ZN5clang18IdentifierResolver13IdDeclInfoMap14IdDeclInfoPoolE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver13IdDeclInfoMap14IdDeclInfoPoolE")
    //</editor-fold>
    private static class/*struct*/ IdDeclInfoPool implements Destructors.ClassWithDestructor {
      //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdDeclInfoMap::IdDeclInfoPool::IdDeclInfoPool">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 38,
       FQN="clang::IdentifierResolver::IdDeclInfoMap::IdDeclInfoPool::IdDeclInfoPool", NM="_ZN5clang18IdentifierResolver13IdDeclInfoMap14IdDeclInfoPoolC1EPS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver13IdDeclInfoMap14IdDeclInfoPoolC1EPS2_")
      //</editor-fold>
      public IdDeclInfoPool(JD$IdDeclInfoPool$P _dparam, IdDeclInfoPool /*P*/ Next) {
        // : Next(Next), Pool() 
        //START JInit
        this.Next = Next;
        this.Pool = new$T(new IdDeclInfo [512], ()->new IdDeclInfo());
        //END JInit
      }

      
      public IdDeclInfoPool /*P*/ Next;
      public IdDeclInfo Pool[/*512*/] = new IdDeclInfo [512];
      //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdDeclInfoMap::IdDeclInfoPool::~IdDeclInfoPool">
      @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 37,
       FQN="clang::IdentifierResolver::IdDeclInfoMap::IdDeclInfoPool::~IdDeclInfoPool", NM="_ZN5clang18IdentifierResolver13IdDeclInfoMap14IdDeclInfoPoolD0Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver13IdDeclInfoMap14IdDeclInfoPoolD0Ev")
      //</editor-fold>
      public /*inline*/ void $destroy() {
        //START JDestroy
        for (IdDeclInfo d : Pool) {
          if (d != null) {
            d.$destroy();
          }
        }
        //END JDestroy
      }

      
      @Override public String toString() {
        return "" + "Next=" + Next // NOI18N
                  + ", Pool=" + Pool; // NOI18N
      }
    };
    
    private IdDeclInfoPool /*P*/ CurPool;
    private /*uint*/int CurIndex;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdDeclInfoMap::IdDeclInfoMap">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 48,
     FQN="clang::IdentifierResolver::IdDeclInfoMap::IdDeclInfoMap", NM="_ZN5clang18IdentifierResolver13IdDeclInfoMapC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver13IdDeclInfoMapC1Ev")
    //</editor-fold>
    public IdDeclInfoMap() {
      // : CurPool(null), CurIndex(POOL_SIZE) 
      //START JInit
      this.CurPool = null;
      this.CurIndex = POOL_SIZE;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdDeclInfoMap::~IdDeclInfoMap">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 50,
     FQN="clang::IdentifierResolver::IdDeclInfoMap::~IdDeclInfoMap", NM="_ZN5clang18IdentifierResolver13IdDeclInfoMapD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver13IdDeclInfoMapD0Ev")
    //</editor-fold>
    public void $destroy() {
      IdDeclInfoPool /*P*/ Cur = CurPool;
      {
        IdDeclInfoPool /*P*/ P;
        while (((/*P*/ P = Cur) != null)) {
          Cur = Cur.Next;
          if (P != null) { P.$destroy();};
        }
      }
    }

    
    /// Returns the IdDeclInfo associated to the DeclarationName.
    /// It creates a new IdDeclInfo if one was not created before for this id.
    
    //===----------------------------------------------------------------------===//
    // IdDeclInfoMap Implementation
    //===----------------------------------------------------------------------===//
    
    /// Returns the IdDeclInfo associated to the DeclarationName.
    /// It creates a new IdDeclInfo if one was not created before for this id.
    //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::IdDeclInfoMap::operator[]">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 393,
     FQN="clang::IdentifierResolver::IdDeclInfoMap::operator[]", NM="_ZN5clang18IdentifierResolver13IdDeclInfoMapixENS_15DeclarationNameE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver13IdDeclInfoMapixENS_15DeclarationNameE")
    //</editor-fold>
    public IdentifierResolver.IdDeclInfo /*&*/ $at(DeclarationName Name) {
      Object/*void P*/ Ptr = Name.getFETokenInfo();
      if ((Ptr != null)) {
        return $Deref(toIdDeclInfo(Ptr));
      }
      if (CurIndex == POOL_SIZE) {
        CurPool = new IdDeclInfoPool(JD$IdDeclInfoPool$P.INSTANCE, CurPool);
        CurIndex = 0;
      }
      IdDeclInfo /*P*/ IDI = $AddrOf(CurPool.Pool[CurIndex]);
      Name.setFETokenInfo(IDI); // (reinterpret_cast(Object/*void P*/ .class, reinterpret_cast_Object/*uintptr_t*/(IDI) | 0x1));
      ++CurIndex;
      return $Deref(IDI);
    }

    
    @Override public String toString() {
      return "" + "CurPool=" + CurPool // NOI18N
                + ", CurIndex=" + CurIndex; // NOI18N
    }
  };
  private IdDeclInfoMap /*P*/ IdDeclInfos;
  
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::updatingIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 379,
   FQN="clang::IdentifierResolver::updatingIdentifier", NM="_ZN5clang18IdentifierResolver18updatingIdentifierERNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver18updatingIdentifierERNS_14IdentifierInfoE")
  //</editor-fold>
  private void updatingIdentifier(final IdentifierInfo /*&*/ II) {
    if (II.isOutOfDate()) {
      PP.getExternalSource().updateOutOfDateIdentifier(II);
    }
    if (II.isFromAST()) {
      II.setFETokenInfoChangedSinceDeserialization();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::readingIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp", line = 374,
   FQN="clang::IdentifierResolver::readingIdentifier", NM="_ZN5clang18IdentifierResolver17readingIdentifierERNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver17readingIdentifierERNS_14IdentifierInfoE")
  //</editor-fold>
  private void readingIdentifier(final IdentifierInfo /*&*/ II) {
    if (II.isOutOfDate()) {
      PP.getExternalSource().updateOutOfDateIdentifier(II);
    }
  }

  
  /// FETokenInfo contains a Decl pointer if lower bit == 0.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::isDeclPtr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 197,
   FQN="clang::IdentifierResolver::isDeclPtr", NM="_ZN5clang18IdentifierResolver9isDeclPtrEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver9isDeclPtrEPv")
  //</editor-fold>
  private static /*inline*/ boolean isDeclPtr(Object/*void P*/ Ptr) {
    return Ptr == null || Ptr instanceof NamedDecl; // (reinterpret_cast_Object/*uintptr_t*/(Ptr) & 0x1) == 0;
  }

  
  /// FETokenInfo contains a IdDeclInfo pointer if lower bit == 1.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierResolver::toIdDeclInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/IdentifierResolver.h", line = 202,
   FQN="clang::IdentifierResolver::toIdDeclInfo", NM="_ZN5clang18IdentifierResolver12toIdDeclInfoEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/IdentifierResolver.cpp -nm=_ZN5clang18IdentifierResolver12toIdDeclInfoEPv")
  //</editor-fold>
  private static /*inline*/ IdDeclInfo /*P*/ toIdDeclInfo(Object/*void P*/ Ptr) {
    //assert ((reinterpret_cast_Object/*uintptr_t*/(Ptr) & 0x1) == 1) : "Ptr not a IdDeclInfo* !";
    assert Ptr == null || Ptr instanceof IdDeclInfo;
    return reinterpret_cast(IdDeclInfo /*P*/ .class, Ptr /* & ~0x1*/);
  }

  @Override public String toString() {
    return "" + "LangOpt=" + LangOpt // NOI18N
              + ", PP=" + "[Preprocessor]" // NOI18N
              + ", IdDeclInfos=" + IdDeclInfos; // NOI18N
  }
}
