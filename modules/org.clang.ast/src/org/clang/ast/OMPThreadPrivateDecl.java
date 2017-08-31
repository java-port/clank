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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// \brief This represents '#pragma omp threadprivate ...' directive.
/// For example, in the following, both 'a' and 'A::b' are threadprivate:
///
/// \code
/// int a;
/// #pragma omp threadprivate(a)
/// struct A {
///   static int b;
/// #pragma omp threadprivate(b)
/// };
/// \endcode
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 39,
 FQN="clang::OMPThreadPrivateDecl", NM="_ZN5clang20OMPThreadPrivateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang20OMPThreadPrivateDeclE")
//</editor-fold>
public final class OMPThreadPrivateDecl extends /*public*/ Decl implements /*private*/ TrailingObjects<OMPThreadPrivateDecl, Expr /*P*/ >, Destructors.ClassWithDestructor {
  /*friend  class ASTDeclReader*/
  /*friend  TrailingObjects<OMPThreadPrivateDecl, Expr *>*/
  
  private /*uint*/int NumVars;
  
  
  //===----------------------------------------------------------------------===//
  // OMPThreadPrivateDecl Implementation.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp", line = 27,
   FQN="clang::OMPThreadPrivateDecl::anchor", NM="_ZN5clang20OMPThreadPrivateDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang20OMPThreadPrivateDecl6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::OMPThreadPrivateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 49,
   FQN="clang::OMPThreadPrivateDecl::OMPThreadPrivateDecl", NM="_ZN5clang20OMPThreadPrivateDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang20OMPThreadPrivateDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationE")
  //</editor-fold>
  private OMPThreadPrivateDecl(Kind DK, DeclContext /*P*/ DC, SourceLocation L) {
    // : Decl(DK, DC, L), TrailingObjects<OMPThreadPrivateDecl, Expr * >(), NumVars(0) 
    //START JInit
    super(DK, DC, new SourceLocation(L));
    $TrailingObjects();
    this.NumVars = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::getVars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 52,
   FQN="clang::OMPThreadPrivateDecl::getVars", NM="_ZNK5clang20OMPThreadPrivateDecl7getVarsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZNK5clang20OMPThreadPrivateDecl7getVarsEv")
  //</editor-fold>
  private ArrayRef</*const*/ Expr /*P*/ > getVars$Const() /*const*/ {
    return new ArrayRef</*const*/ Expr /*P*/ >(JD$Convertible.INSTANCE, llvm.makeArrayRef(getTrailingObjects$Const(Expr /*P*/.class), NumVars), true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::getVars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 56,
   FQN="clang::OMPThreadPrivateDecl::getVars", NM="_ZN5clang20OMPThreadPrivateDecl7getVarsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang20OMPThreadPrivateDecl7getVarsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getVars() {
    return new MutableArrayRef<Expr /*P*/ >(getTrailingObjects(Expr /*P*/.class), NumVars, true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::setVars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp", line = 50,
   FQN="clang::OMPThreadPrivateDecl::setVars", NM="_ZN5clang20OMPThreadPrivateDecl7setVarsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang20OMPThreadPrivateDecl7setVarsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setVars(ArrayRef<Expr /*P*/ > VL) {
    assert (VL.size() == NumVars) : "Number of variables is not the same as the preallocated buffer";
    std.uninitialized_copy(VL.begin(), VL.end(), getTrailingObjects(Expr /*P*/.class));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp", line = 29,
   FQN="clang::OMPThreadPrivateDecl::Create", NM="_ZN5clang20OMPThreadPrivateDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang20OMPThreadPrivateDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  public static OMPThreadPrivateDecl /*P*/ Create(final ASTContext /*&*/ C, 
        DeclContext /*P*/ DC, 
        SourceLocation L, 
        ArrayRef<Expr /*P*/ > VL) {
    OMPThreadPrivateDecl /*P*/ D = /*NEW_EXPR [Decl::new]*//*new (C, DC, additionalSizeToAlloc<Expr *>(VL.size()))*/ Decl.$new(C, DC, TrailingObjects.additionalSizeToAlloc$Same(Expr/*P*/.class, VL.size()), (type$ptr<?> New$Mem)->{
        return new OMPThreadPrivateDecl(Kind.OMPThreadPrivate, DC, new SourceLocation(L));
     },
        new std.pairIntPtr<>(VL.size(), ()->null) // for Expr *
    );
    D.NumVars = VL.size();
    D.setVars(new ArrayRef<Expr /*P*/ >(VL));
    return D;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp", line = 41,
   FQN="clang::OMPThreadPrivateDecl::CreateDeserialized", NM="_ZN5clang20OMPThreadPrivateDecl18CreateDeserializedERNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang20OMPThreadPrivateDecl18CreateDeserializedERNS_10ASTContextEjj")
  //</editor-fold>
  public static OMPThreadPrivateDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID, 
                    /*uint*/int N) {
    OMPThreadPrivateDecl /*P*/ D = /*NEW_EXPR [Decl::new]*//*new (C, ID, additionalSizeToAlloc<Expr *>(N))*/ Decl.$new(C, ID, TrailingObjects.additionalSizeToAlloc$Same(Expr.class, N), (type$ptr<?> New$Mem)->{
        return new OMPThreadPrivateDecl(Kind.OMPThreadPrivate, (DeclContext /*P*/ )null, new SourceLocation());
     },
      new std.pairIntPtr<>(N, ()->null) // for Expr *
    );
    D.NumVars = N;
    return D;
  }

  
  /*typedef MutableArrayRef<Expr *>::iterator varlist_iterator*/
//  public final class varlist_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef ArrayRef<const Expr *>::iterator varlist_const_iterator*/
//  public final class varlist_const_iterator extends type$ptr<Expr/*P*/>/*iterator*/{ };
  /*typedef llvm::iterator_range<varlist_iterator> varlist_range*/
//  public final class varlist_range extends iterator_range<Expr /*P*/ >{ };
  /*typedef llvm::iterator_range<varlist_const_iterator> varlist_const_range*/
//  public final class varlist_const_range extends iterator_range</*const*/ Expr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::varlist_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 74,
   FQN="clang::OMPThreadPrivateDecl::varlist_size", NM="_ZNK5clang20OMPThreadPrivateDecl12varlist_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZNK5clang20OMPThreadPrivateDecl12varlist_sizeEv")
  //</editor-fold>
  public /*uint*/int varlist_size() /*const*/ {
    return NumVars;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::varlist_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 75,
   FQN="clang::OMPThreadPrivateDecl::varlist_empty", NM="_ZNK5clang20OMPThreadPrivateDecl13varlist_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZNK5clang20OMPThreadPrivateDecl13varlist_emptyEv")
  //</editor-fold>
  public boolean varlist_empty() /*const*/ {
    return NumVars == 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::varlists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 77,
   FQN="clang::OMPThreadPrivateDecl::varlists", NM="_ZN5clang20OMPThreadPrivateDecl8varlistsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang20OMPThreadPrivateDecl8varlistsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > varlists() {
    return new iterator_range<Expr /*P*/ >(varlist_begin(), varlist_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::varlists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 80,
   FQN="clang::OMPThreadPrivateDecl::varlists", NM="_ZNK5clang20OMPThreadPrivateDecl8varlistsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZNK5clang20OMPThreadPrivateDecl8varlistsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> varlists$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(varlist_begin$Const(), varlist_end$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::varlist_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 83,
   FQN="clang::OMPThreadPrivateDecl::varlist_begin", NM="_ZN5clang20OMPThreadPrivateDecl13varlist_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang20OMPThreadPrivateDecl13varlist_beginEv")
  //</editor-fold>
  public type$ptr<Expr/*P*/>/*iterator*/ varlist_begin() {
    return getVars().begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::varlist_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 84,
   FQN="clang::OMPThreadPrivateDecl::varlist_end", NM="_ZN5clang20OMPThreadPrivateDecl11varlist_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang20OMPThreadPrivateDecl11varlist_endEv")
  //</editor-fold>
  public type$ptr<Expr/*P*/>/*iterator*/ varlist_end() {
    return getVars().end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::varlist_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 85,
   FQN="clang::OMPThreadPrivateDecl::varlist_begin", NM="_ZNK5clang20OMPThreadPrivateDecl13varlist_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZNK5clang20OMPThreadPrivateDecl13varlist_beginEv")
  //</editor-fold>
  public type$ptr<Expr/*P*/>/*iterator*/ varlist_begin$Const() /*const*/ {
    return getVars$Const().begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::varlist_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 86,
   FQN="clang::OMPThreadPrivateDecl::varlist_end", NM="_ZNK5clang20OMPThreadPrivateDecl11varlist_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZNK5clang20OMPThreadPrivateDecl11varlist_endEv")
  //</editor-fold>
  public type$ptr<Expr/*P*/>/*iterator*/ varlist_end$Const() /*const*/ {
    return getVars$Const().end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 88,
   FQN="clang::OMPThreadPrivateDecl::classof", NM="_ZN5clang20OMPThreadPrivateDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang20OMPThreadPrivateDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 89,
   FQN="clang::OMPThreadPrivateDecl::classofKind", NM="_ZN5clang20OMPThreadPrivateDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang20OMPThreadPrivateDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.OMPThreadPrivate;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPThreadPrivateDecl::~OMPThreadPrivateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclOpenMP.h", line = 39,
   FQN="clang::OMPThreadPrivateDecl::~OMPThreadPrivateDecl", NM="_ZN5clang20OMPThreadPrivateDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclOpenMP.cpp -nm=_ZN5clang20OMPThreadPrivateDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    TrailingObjects.super.$destroy$TrailingObjects();
  }

  
  @Override public String toString() {
    return "" + "NumVars=" + NumVars // NOI18N
              + super.toString(); // NOI18N
  }
}
