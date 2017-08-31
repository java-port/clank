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
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// \brief Describes the capture of a variable or of \c this, or of a
/// C++1y init-capture.
//<editor-fold defaultstate="collapsed" desc="clang::LambdaCapture">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LambdaCapture.h", line = 26,
 FQN="clang::LambdaCapture", NM="_ZN5clang13LambdaCaptureE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13LambdaCaptureE")
//</editor-fold>
public class LambdaCapture implements NativePOD<LambdaCapture> {
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaCapture::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LambdaCapture.h", line = 27,
   FQN="clang::LambdaCapture::(anonymous)", NM="_ZN5clang13LambdaCaptureE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13LambdaCaptureE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    /// \brief Flag used by the Capture class to indicate that the given
    /// capture was implicit.
    public static final /*uint*/int Capture_Implicit = 0x01;
    
    /// \brief Flag used by the Capture class to indicate that the
    /// given capture was by-copy.
    ///
    /// This includes the case of a non-reference init-capture.
    public static final /*uint*/int Capture_ByCopy = 0x02;
    
    /// \brief Flag used by the Capture class to distinguish between a capture
    /// of '*this' and a capture of a VLA type.
    public static final /*uint*/int Capture_This = 0x04;
  /*}*/;
  
  // Decl could represent:
  // - a VarDecl* that represents the variable that was captured or the 
  //   init-capture.
  // - or, is a nullptr and Capture_This is set in Bits if this represents a
  //   capture of '*this' by value or reference.
  // - or, is a nullptr and Capture_This is not set in Bits if this represents
  //   a capture of a VLA type.
  private PointerIntPair<Decl /*P*/ > DeclAndBits;
  
  private SourceLocation Loc;
  private SourceLocation EllipsisLoc;
  
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
/*public:*/
  /// \brief Create a new capture of a variable or of \c this.
  ///
  /// \param Loc The source location associated with this capture.
  ///
  /// \param Kind The kind of capture (this, byref, bycopy), which must
  /// not be init-capture.
  ///
  /// \param Implicit Whether the capture was implicit or explicit.
  ///
  /// \param Var The local variable being captured, or null if capturing
  /// \c this.
  ///
  /// \param EllipsisLoc The location of the ellipsis (...) for a
  /// capture that is a pack expansion, or an invalid source
  /// location to indicate that this is not a pack expansion.
  /// \brief Create a new capture of a variable or of \c this.
  ///
  /// \param Loc The source location associated with this capture.
  ///
  /// \param Kind The kind of capture (this, byref, bycopy), which must
  /// not be init-capture.
  ///
  /// \param Implicit Whether the capture was implicit or explicit.
  ///
  /// \param Var The local variable being captured, or null if capturing
  /// \c this.
  ///
  /// \param EllipsisLoc The location of the ellipsis (...) for a
  /// capture that is a pack expansion, or an invalid source
  /// location to indicate that this is not a pack expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaCapture::LambdaCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 811,
   FQN="clang::LambdaCapture::LambdaCapture", NM="_ZN5clang13LambdaCaptureC1ENS_14SourceLocationEbNS_17LambdaCaptureKindEPNS_7VarDeclES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13LambdaCaptureC1ENS_14SourceLocationEbNS_17LambdaCaptureKindEPNS_7VarDeclES1_")
  //</editor-fold>
  public LambdaCapture(SourceLocation Loc, boolean Implicit, 
      LambdaCaptureKind Kind) {
    this(Loc, Implicit, 
      Kind, (VarDecl /*P*/ )null, 
      new SourceLocation());
  }
  public LambdaCapture(SourceLocation Loc, boolean Implicit, 
      LambdaCaptureKind Kind, VarDecl /*P*/ Var/*= null*/) {
    this(Loc, Implicit, 
      Kind, Var, 
      new SourceLocation());
  }
  public LambdaCapture(SourceLocation Loc, boolean Implicit, 
      LambdaCaptureKind Kind, VarDecl /*P*/ Var/*= null*/, 
      SourceLocation EllipsisLoc/*= SourceLocation()*/) {
    // : DeclAndBits(Var, 0), Loc(Loc), EllipsisLoc(EllipsisLoc) 
    //START JInit
    this.DeclAndBits = new PointerIntPair<Decl /*P*/ >(Var, 0);
    this.Loc = new SourceLocation(Loc);
    this.EllipsisLoc = new SourceLocation(EllipsisLoc);
    //END JInit
    /*uint*/int Bits = 0;
    if (Implicit) {
      Bits |= Capture_Implicit;
    }
    switch (Kind) {
     case LCK_StarThis:
      Bits |= Capture_ByCopy;
     case LCK_This:
      // Fall through
      assert (!(Var != null)) : "'this' capture cannot have a variable!";
      Bits |= Capture_This;
      break;
     case LCK_ByCopy:
      Bits |= Capture_ByCopy;
     case LCK_ByRef:
      // Fall through 
      assert ((Var != null)) : "capture must have a variable!";
      break;
     case LCK_VLAType:
      assert (!(Var != null)) : "VLA type capture cannot have a variable!";
      break;
    }
    DeclAndBits.setInt(Bits);
  }


  
  /// \brief Determine the kind of capture.
  
  /// \brief Determine the kind of capture.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaCapture::getCaptureKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 842,
   FQN="clang::LambdaCapture::getCaptureKind", NM="_ZNK5clang13LambdaCapture14getCaptureKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang13LambdaCapture14getCaptureKindEv")
  //</editor-fold>
  public LambdaCaptureKind getCaptureKind() /*const*/ {
    if (capturesVLAType()) {
      return LambdaCaptureKind.LCK_VLAType;
    }
    boolean CapByCopy = ((DeclAndBits.getInt() & Capture_ByCopy) != 0);
    if (capturesThis()) {
      return CapByCopy ? LambdaCaptureKind.LCK_StarThis : LambdaCaptureKind.LCK_This;
    }
    return CapByCopy ? LambdaCaptureKind.LCK_ByCopy : LambdaCaptureKind.LCK_ByRef;
  }


  
  /// \brief Determine whether this capture handles the C++ \c this
  /// pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaCapture::capturesThis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LambdaCapture.h", line = 83,
   FQN="clang::LambdaCapture::capturesThis", NM="_ZNK5clang13LambdaCapture12capturesThisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13LambdaCapture12capturesThisEv")
  //</editor-fold>
  public boolean capturesThis() /*const*/ {
    return DeclAndBits.getPointer() == null
       && ((DeclAndBits.getInt() & Capture_This) != 0);
  }

  
  /// \brief Determine whether this capture handles a variable.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaCapture::capturesVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LambdaCapture.h", line = 89,
   FQN="clang::LambdaCapture::capturesVariable", NM="_ZNK5clang13LambdaCapture16capturesVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13LambdaCapture16capturesVariableEv")
  //</editor-fold>
  public boolean capturesVariable() /*const*/ {
    return (dyn_cast_or_null_VarDecl(DeclAndBits.getPointer()) != null);
  }

  
  /// \brief Determine whether this captures a variable length array bound
  /// expression.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaCapture::capturesVLAType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LambdaCapture.h", line = 95,
   FQN="clang::LambdaCapture::capturesVLAType", NM="_ZNK5clang13LambdaCapture15capturesVLATypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13LambdaCapture15capturesVLATypeEv")
  //</editor-fold>
  public boolean capturesVLAType() /*const*/ {
    return DeclAndBits.getPointer() == null
       && !((DeclAndBits.getInt() & Capture_This) != 0);
  }

  
  /// \brief Retrieve the declaration of the local variable being
  /// captured.
  ///
  /// This operation is only valid if this capture is a variable capture
  /// (other than a capture of \c this).
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaCapture::getCapturedVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LambdaCapture.h", line = 105,
   FQN="clang::LambdaCapture::getCapturedVar", NM="_ZNK5clang13LambdaCapture14getCapturedVarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13LambdaCapture14getCapturedVarEv")
  //</editor-fold>
  public VarDecl /*P*/ getCapturedVar() /*const*/ {
    assert (capturesVariable()) : "No variable available for capture";
    return ((/*static_cast*/VarDecl /*P*/ )(DeclAndBits.getPointer()));
  }

  
  /// \brief Determine whether this was an implicit capture (not
  /// written between the square brackets introducing the lambda).
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaCapture::isImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LambdaCapture.h", line = 112,
   FQN="clang::LambdaCapture::isImplicit", NM="_ZNK5clang13LambdaCapture10isImplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13LambdaCapture10isImplicitEv")
  //</editor-fold>
  public boolean isImplicit() /*const*/ {
    return ((DeclAndBits.getInt() & Capture_Implicit) != 0);
  }

  
  /// \brief Determine whether this was an explicit capture (written
  /// between the square brackets introducing the lambda).
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaCapture::isExplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LambdaCapture.h", line = 118,
   FQN="clang::LambdaCapture::isExplicit", NM="_ZNK5clang13LambdaCapture10isExplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13LambdaCapture10isExplicitEv")
  //</editor-fold>
  public boolean isExplicit() /*const*/ {
    return !isImplicit();
  }

  
  /// \brief Retrieve the source location of the capture.
  ///
  /// For an explicit capture, this returns the location of the
  /// explicit capture in the source. For an implicit capture, this
  /// returns the location at which the variable or \c this was first
  /// used.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaCapture::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LambdaCapture.h", line = 126,
   FQN="clang::LambdaCapture::getLocation", NM="_ZNK5clang13LambdaCapture11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13LambdaCapture11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Loc);
  }

  
  /// \brief Determine whether this capture is a pack expansion,
  /// which captures a function parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaCapture::isPackExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LambdaCapture.h", line = 130,
   FQN="clang::LambdaCapture::isPackExpansion", NM="_ZNK5clang13LambdaCapture15isPackExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13LambdaCapture15isPackExpansionEv")
  //</editor-fold>
  public boolean isPackExpansion() /*const*/ {
    return EllipsisLoc.isValid();
  }

  
  /// \brief Retrieve the location of the ellipsis for a capture
  /// that is a pack expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::LambdaCapture::getEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LambdaCapture.h", line = 134,
   FQN="clang::LambdaCapture::getEllipsisLoc", NM="_ZNK5clang13LambdaCapture14getEllipsisLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13LambdaCapture14getEllipsisLocEv")
  //</editor-fold>
  public SourceLocation getEllipsisLoc() /*const*/ {
    assert (isPackExpansion()) : "No ellipsis location for a non-expansion";
    return new SourceLocation(EllipsisLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LambdaCapture::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LambdaCapture.h", line = 26,
   FQN="clang::LambdaCapture::operator=", NM="_ZN5clang13LambdaCaptureaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13LambdaCaptureaSEOS0_")
  //</editor-fold>
  public /*inline*/ LambdaCapture /*&*/ $assignMove(final LambdaCapture /*&&*/$Prm0) {
    this.DeclAndBits.$assignMove($Prm0.DeclAndBits);
    this.Loc.$assignMove($Prm0.Loc);
    this.EllipsisLoc.$assignMove($Prm0.EllipsisLoc);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::LambdaCapture::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LambdaCapture.h", line = 26,
   FQN="clang::LambdaCapture::operator=", NM="_ZN5clang13LambdaCaptureaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang13LambdaCaptureaSERKS0_")
  //</editor-fold>
  public /*inline*/ LambdaCapture /*&*/ $assign(final /*const*/ LambdaCapture /*&*/ $Prm0) {
    this.DeclAndBits.$assign($Prm0.DeclAndBits);
    this.Loc.$assign($Prm0.Loc);
    this.EllipsisLoc.$assign($Prm0.EllipsisLoc);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public LambdaCapture() {
    this.DeclAndBits = new PointerIntPair<>();
    this.EllipsisLoc = new SourceLocation();
    this.Loc = new SourceLocation();
  }

  @Override public LambdaCapture clone() { return new LambdaCapture().$assign(this); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "DeclAndBits=" + DeclAndBits // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", EllipsisLoc=" + EllipsisLoc; // NOI18N
  }
}
