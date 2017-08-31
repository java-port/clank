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
import static org.clank.support.Casts.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;


/// \brief This captures a statement into a function. For example, the following
/// pragma annotated compound statement can be represented as a CapturedStmt,
/// and this compound statement is the body of an anonymous outlined function.
/// @code
/// #pragma omp parallel
/// {
///   compute();
/// }
/// @endcode
//<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2006,
 FQN="clang::CapturedStmt", NM="_ZN5clang12CapturedStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang12CapturedStmtE")
//</editor-fold>
public class CapturedStmt extends /*public*/ Stmt implements ITrailingObjectsJavaBase<CapturedStmt> {
/*public:*/
  /// \brief The different capture forms: by 'this', by reference, capture for
  /// variable-length array type etc.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::VariableCaptureKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2010,
   FQN="clang::CapturedStmt::VariableCaptureKind", NM="_ZN5clang12CapturedStmt19VariableCaptureKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang12CapturedStmt19VariableCaptureKindE")
  //</editor-fold>
  public enum VariableCaptureKind implements Native.ComparableLower {
    VCK_This(0),
    VCK_ByRef(VCK_This.getValue() + 1),
    VCK_ByCopy(VCK_ByRef.getValue() + 1),
    VCK_VLAType(VCK_ByCopy.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static VariableCaptureKind valueOf(int val) {
      VariableCaptureKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final VariableCaptureKind[] VALUES;
      private static final VariableCaptureKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (VariableCaptureKind kind : VariableCaptureKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new VariableCaptureKind[min < 0 ? (1-min) : 0];
        VALUES = new VariableCaptureKind[max >= 0 ? (1+max) : 0];
        for (VariableCaptureKind kind : VariableCaptureKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private VariableCaptureKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((VariableCaptureKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((VariableCaptureKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Describes the capture of either a variable, or 'this', or
  /// variable-length array type.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::Capture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2019,
   FQN="clang::CapturedStmt::Capture", NM="_ZN5clang12CapturedStmt7CaptureE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang12CapturedStmt7CaptureE")
  //</editor-fold>
  public static class Capture implements NativeCloneable<Capture> {

    /*friend*/public PointerEnum2Pair<VarDecl /*P*/ , VariableCaptureKind> VarAndKind;
    /*friend*/public SourceLocation Loc;
  /*public:*/
    /// \brief Create a new capture.
    ///
    /// \param Loc The source location associated with this capture.
    ///
    /// \param Kind The kind of capture (this, ByRef, ...).
    ///
    /// \param Var The variable being captured, or null if capturing this.
    ///
    /// \brief Create a new capture.
    ///
    /// \param Loc The source location associated with this capture.
    ///
    /// \param Kind The kind of capture (this, ByRef, ...).
    ///
    /// \param Var The variable being captured, or null if capturing this.
    ///
    //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::Capture::Capture">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 959,
     FQN="clang::CapturedStmt::Capture::Capture", NM="_ZN5clang12CapturedStmt7CaptureC1ENS_14SourceLocationENS0_19VariableCaptureKindEPNS_7VarDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CapturedStmt7CaptureC1ENS_14SourceLocationENS0_19VariableCaptureKindEPNS_7VarDeclE")
    //</editor-fold>
    public Capture(SourceLocation Loc, VariableCaptureKind Kind) {
      this(Loc, Kind, 
        (VarDecl /*P*/ )null);
    }
    public Capture(SourceLocation Loc, VariableCaptureKind Kind, 
        VarDecl /*P*/ Var/*= null*/) {
      // : VarAndKind(Var, Kind), Loc(Loc) 
      //START JInit
      this.VarAndKind = new PointerEnum2Pair<VarDecl /*P*/ , VariableCaptureKind>(Var, Kind);
      this.Loc = new SourceLocation(Loc);
      //END JInit
      switch (Kind) {
       case VCK_This:
        assert (!(Var != null)) : "'this' capture cannot have a variable!";
        break;
       case VCK_ByRef:
        assert ((Var != null)) : "capturing by reference must have a variable!";
        break;
       case VCK_ByCopy:
        assert ((Var != null)) : "capturing by copy must have a variable!";
        assert ((Var.getType().$arrow().isScalarType() || (Var.getType().$arrow().isReferenceType() && Var.getType().$arrow().castAs(ReferenceType.class).getPointeeType().$arrow().isScalarType()))) : "captures by copy are expected to have a scalar type!";
        break;
       case VCK_VLAType:
        assert (!(Var != null)) : "Variable-length array type capture cannot have a variable!";
        break;
      }
    }


    
    /// \brief Determine the kind of capture.
    
    /// \brief Determine the kind of capture.
    //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::Capture::getCaptureKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 986,
     FQN="clang::CapturedStmt::Capture::getCaptureKind", NM="_ZNK5clang12CapturedStmt7Capture14getCaptureKindEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CapturedStmt7Capture14getCaptureKindEv")
    //</editor-fold>
    public CapturedStmt.VariableCaptureKind getCaptureKind() /*const*/ {
      return VarAndKind.getInt();
    }


    
    /// \brief Retrieve the source location at which the variable or 'this' was
    /// first used.
    //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::Capture::getLocation">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2040,
     FQN="clang::CapturedStmt::Capture::getLocation", NM="_ZNK5clang12CapturedStmt7Capture11getLocationEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt7Capture11getLocationEv")
    //</editor-fold>
    public SourceLocation getLocation() /*const*/ {
      return new SourceLocation(Loc);
    }

    
    /// \brief Determine whether this capture handles the C++ 'this' pointer.
    //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::Capture::capturesThis">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2043,
     FQN="clang::CapturedStmt::Capture::capturesThis", NM="_ZNK5clang12CapturedStmt7Capture12capturesThisEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt7Capture12capturesThisEv")
    //</editor-fold>
    public boolean capturesThis() /*const*/ {
      return getCaptureKind() == VariableCaptureKind.VCK_This;
    }

    
    /// \brief Determine whether this capture handles a variable (by reference).
    //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::Capture::capturesVariable">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2046,
     FQN="clang::CapturedStmt::Capture::capturesVariable", NM="_ZNK5clang12CapturedStmt7Capture16capturesVariableEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt7Capture16capturesVariableEv")
    //</editor-fold>
    public boolean capturesVariable() /*const*/ {
      return getCaptureKind() == VariableCaptureKind.VCK_ByRef;
    }

    
    /// \brief Determine whether this capture handles a variable by copy.
    //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::Capture::capturesVariableByCopy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2049,
     FQN="clang::CapturedStmt::Capture::capturesVariableByCopy", NM="_ZNK5clang12CapturedStmt7Capture22capturesVariableByCopyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt7Capture22capturesVariableByCopyEv")
    //</editor-fold>
    public boolean capturesVariableByCopy() /*const*/ {
      return getCaptureKind() == VariableCaptureKind.VCK_ByCopy;
    }

    
    /// \brief Determine whether this capture handles a variable-length array
    /// type.
    //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::Capture::capturesVariableArrayType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2055,
     FQN="clang::CapturedStmt::Capture::capturesVariableArrayType", NM="_ZNK5clang12CapturedStmt7Capture25capturesVariableArrayTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt7Capture25capturesVariableArrayTypeEv")
    //</editor-fold>
    public boolean capturesVariableArrayType() /*const*/ {
      return getCaptureKind() == VariableCaptureKind.VCK_VLAType;
    }

    
    /// \brief Retrieve the declaration of the variable being captured.
    ///
    /// This operation is only valid if this capture captures a variable.
    
    /// \brief Retrieve the declaration of the variable being captured.
    ///
    /// This operation is only valid if this capture captures a variable.
    //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::Capture::getCapturedVar">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 991,
     FQN="clang::CapturedStmt::Capture::getCapturedVar", NM="_ZNK5clang12CapturedStmt7Capture14getCapturedVarEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CapturedStmt7Capture14getCapturedVarEv")
    //</editor-fold>
    public VarDecl /*P*/ getCapturedVar() /*const*/ {
      assert ((capturesVariable() || capturesVariableByCopy())) : "No variable available for 'this' or VAT capture";
      return VarAndKind.getPointer();
    }


    
    /*friend  class ASTStmtReader*/

    //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::Capture::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2019,
     FQN="clang::CapturedStmt::Capture::operator=", NM="_ZN5clang12CapturedStmt7CaptureaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CapturedStmt7CaptureaSERKS1_")
    //</editor-fold>
    public /*inline*/ Capture /*&*/ $assign(final /*const*/ Capture /*&*/ $Prm0) {
      this.VarAndKind.$assign($Prm0.VarAndKind);
      this.Loc.$assign($Prm0.Loc);
      return /*Deref*/this;
    }

    public Capture() {
      this.VarAndKind = new PointerEnum2Pair<VarDecl /*P*/ , VariableCaptureKind>();
      this.Loc = new SourceLocation();      
    }

    @Override public Capture clone() {
      return new Capture().$assign(this);
    }
    
    @Override public String toString() {
      return "" + "VarAndKind=" + VarAndKind // NOI18N
                + ", Loc=" + Loc; // NOI18N
    }
  };
/*private:*/
  /// \brief The number of variable captured, including 'this'.
  private final /*uint*/int NumCaptures;
  
  /// \brief The pointer part is the implicit the outlined function and the 
  /// int part is the captured region kind, 'CR_Default' etc.
  private final PointerEnumPair<CapturedDecl /*P*/ , CapturedRegionKind> CapDeclAndKind;
  
  /// \brief The record for captured variables, a RecordDecl or CXXRecordDecl.
  private RecordDecl /*P*/ TheRecordDecl;
  
  /// \brief Construct a captured statement.
  
  /// \brief Construct a captured statement.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::CapturedStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 1008,
   FQN="clang::CapturedStmt::CapturedStmt", NM="_ZN5clang12CapturedStmtC1EPNS_4StmtENS_18CapturedRegionKindEN4llvm8ArrayRefINS0_7CaptureEEENS5_IPNS_4ExprEEEPNS_12CapturedDeclEPNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CapturedStmtC1EPNS_4StmtENS_18CapturedRegionKindEN4llvm8ArrayRefINS0_7CaptureEEENS5_IPNS_4ExprEEEPNS_12CapturedDeclEPNS_10RecordDeclE")
  //</editor-fold>
  private CapturedStmt(Stmt /*P*/ S, CapturedRegionKind Kind, 
      ArrayRef<Capture> Captures, 
      ArrayRef<Expr /*P*/ > CaptureInits, 
      CapturedDecl /*P*/ CD, 
      RecordDecl /*P*/ RD) {
    // : Stmt(CapturedStmtClass), NumCaptures(Captures.size()), CapDeclAndKind(CD, Kind), TheRecordDecl(RD) 
    //START JInit
    super(StmtClass.CapturedStmtClass);
    this.NumCaptures = Captures.size();
    this.CapDeclAndKind = new PointerEnumPair<CapturedDecl /*P*/ , CapturedRegionKind>(CD, Kind);
    this.TheRecordDecl = RD;
    //END JInit
    this.$Captures = init$StoredCaptures$Mem(NumCaptures);
    assert ((S != null)) : "null captured statement";
    assert ((CD != null)) : "null captured declaration for captured statement";
    assert ((RD != null)) : "null record declaration for captured statement";
    
    // Copy initialization expressions.
    type$ptr<Stmt /*P*/ /*P*/> Stored = $tryClone(getStoredStmts());
    for (/*uint*/int I = 0, N = NumCaptures; I != N; ++I)  {
      Stored.$postInc().$set(CaptureInits.$at(I));
    }
    
    // Copy the statement being captured.
    Stored.$set(S);
    
    // Copy all Capture objects.
    type$ptr<CapturedStmt.Capture /*P*/> Buffer = $tryClone(getStoredCaptures());
    std.copy(Captures.begin(), Captures.end(), Buffer);
  }


  
  /// \brief Construct an empty captured statement.
  
  /// \brief Construct an empty captured statement.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::CapturedStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 1032,
   FQN="clang::CapturedStmt::CapturedStmt", NM="_ZN5clang12CapturedStmtC1ENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CapturedStmtC1ENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  private CapturedStmt(EmptyShell Empty, /*uint*/int NumCaptures) {
    // : Stmt(CapturedStmtClass, Empty), NumCaptures(NumCaptures), CapDeclAndKind(null, CR_Default), TheRecordDecl(null) 
    //START JInit
    super(StmtClass.CapturedStmtClass, new EmptyShell(Empty));
    this.NumCaptures = NumCaptures;
    this.CapDeclAndKind = new PointerEnumPair<CapturedDecl /*P*/ , CapturedRegionKind>((CapturedDecl /*P*/ )null, CapturedRegionKind.CR_Default);
    this.TheRecordDecl = null;
    //END JInit
    this.$Captures = init$StoredCaptures$Mem(NumCaptures);
    getStoredStmts().$set(NumCaptures, null);
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::getStoredStmts">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2085,
   FQN="clang::CapturedStmt::getStoredStmts", NM="_ZN5clang12CapturedStmt14getStoredStmtsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang12CapturedStmt14getStoredStmtsEv")
  //</editor-fold>
  private type$ptr<Stmt /*P*/ /*P*/> getStoredStmts() {
    return (type$ptr<Stmt /*P*/ /*P*/>)super.$this$plus1();//((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, this + 1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::getStoredStmts">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2087,
   FQN="clang::CapturedStmt::getStoredStmts", NM="_ZNK5clang12CapturedStmt14getStoredStmtsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt14getStoredStmtsEv")
  //</editor-fold>
  private type$ptr<Stmt /*P*/ /*const*/ /*P*/> getStoredStmts$Const() /*const*/ {
    return (type$ptr<Stmt /*P*/ /*P*/>)super.$this$plus1();//((type$ptr<Stmt /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, this + 1));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::getStoredCaptures">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 997,
   FQN="clang::CapturedStmt::getStoredCaptures", NM="_ZNK5clang12CapturedStmt17getStoredCapturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CapturedStmt17getStoredCapturesEv")
  //</editor-fold>
  private type$ptr<CapturedStmt.Capture /*P*/> getStoredCaptures() /*const*/ {
//    /*uint*/int Size = $sizeof_CapturedStmt() + $sizeof_ptr(/*Stmt  */) * (NumCaptures + 1);
//    
//    // Offset of the first Capture object.
//    /*uint*/int FirstCaptureOffset = $ulong2uint(llvm.alignTo($uint2ulong(Size), $uint2ulong(llvm.<Capture>alignOf())));
    
    return $Captures;//reinterpret_cast(Capture /*P*/ .class, reinterpret_cast(char$ptr/*char P*/ .class, ((/*const_cast*/CapturedStmt /*P*/ )(this))).$add(FirstCaptureOffset));
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::setCapturedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2093,
   FQN="clang::CapturedStmt::setCapturedStmt", NM="_ZN5clang12CapturedStmt15setCapturedStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang12CapturedStmt15setCapturedStmtEPNS_4StmtE")
  //</editor-fold>
  /*friend*/public void setCapturedStmt(Stmt /*P*/ S) {
    getStoredStmts().$set(NumCaptures, S);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*ALLOC*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 1038,
   FQN="clang::CapturedStmt::Create", NM="_ZN5clang12CapturedStmt6CreateERKNS_10ASTContextEPNS_4StmtENS_18CapturedRegionKindEN4llvm8ArrayRefINS0_7CaptureEEENS8_IPNS_4ExprEEEPNS_12CapturedDeclEPNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CapturedStmt6CreateERKNS_10ASTContextEPNS_4StmtENS_18CapturedRegionKindEN4llvm8ArrayRefINS0_7CaptureEEENS8_IPNS_4ExprEEEPNS_12CapturedDeclEPNS_10RecordDeclE")
  //</editor-fold>
  public static CapturedStmt /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, Stmt /*P*/ S, 
        CapturedRegionKind Kind, 
        ArrayRef<Capture> Captures, 
        ArrayRef<Expr /*P*/ > CaptureInits, 
        CapturedDecl /*P*/ CD, 
        RecordDecl /*P*/ RD) {
    // The layout is
    //
    // -----------------------------------------------------------
    // | CapturedStmt, Init, ..., Init, S, Capture, ..., Capture |
    // ----------------^-------------------^----------------------
    //                 getStoredStmts()    getStoredCaptures()
    //
    // where S is the statement being captured.
    //
    assert (CaptureInits.size() == Captures.size()) : "wrong number of arguments";
    
    /*uint*/int Size = (true/*JAVA*/ ? 1 : $sizeof_CapturedStmt()) + (true/*JAVA*/ ? 1 : $sizeof_ptr(/*Stmt  */)) * (Captures.size() + 1);
    if (!Captures.empty()) {
      // Realign for the following Capture array.
      Size = $ulong2uint(llvm.alignTo($uint2ulong(Size), $uint2ulong((true/*JAVA*/ ? 1 : alignOf(Capture.class)))));
      Size += (true/*JAVA*/ ? 1 : $sizeof_Capture()) * Captures.size();
    }
    
    Object/*void P*/ _Mem;
    if (false) {
      _Mem = Context.Allocate(Size);
    } else {
      _Mem = Context.Allocate$JavaRef(Size,
              new std.pairIntPtr<>(1, ()->null), // for this
              new std.pairIntPtr<>(Captures.size() + 1, ()->null), // for Stmt*
              new std.pairIntPtr<>(Captures.size(), ()->new Capture()) // for Captures
              );
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new CapturedStmt(S, Kind, new ArrayRef<Capture>(Captures), new ArrayRef<Expr /*P*/ >(CaptureInits), CD, RD);
     });
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::CreateDeserialized">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*ALLOC*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 1066,
   FQN="clang::CapturedStmt::CreateDeserialized", NM="_ZN5clang12CapturedStmt18CreateDeserializedERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CapturedStmt18CreateDeserializedERKNS_10ASTContextEj")
  //</editor-fold>
  public static CapturedStmt /*P*/ CreateDeserialized(final /*const*/ ASTContext /*&*/ Context, 
                    /*uint*/int NumCaptures) {
    /*uint*/int Size = (true/*JAVA*/ ? 1 : $sizeof_CapturedStmt()) + (true/*JAVA*/ ? 1 : $sizeof_ptr(/*Stmt  */)) * (NumCaptures + 1);
    if ($greater_uint(NumCaptures, 0)) {
      // Realign for the following Capture array.
      Size = $ulong2uint(llvm.alignTo($uint2ulong(Size), $uint2ulong((true/*JAVA*/ ? 1 : alignOf(Capture.class)))));
      Size += (true/*JAVA*/ ? 1 : $sizeof_Capture()) * NumCaptures;
    }
    
    Object/*void P*/ _Mem;
    if (false) {
      _Mem = Context.Allocate(Size);
    } else {
      _Mem = Context.Allocate$JavaRef(Size,
              new std.pairIntPtr<>(1, ()->null), // for this
              new std.pairIntPtr<>(NumCaptures + 1, ()->null), // for Stmt*
              new std.pairIntPtr<>(NumCaptures, ()->new Capture()) // for Captures
              );
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new CapturedStmt(new EmptyShell(), NumCaptures);
     });
  }


  
  /// \brief Retrieve the statement being captured.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::getCapturedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2106,
   FQN="clang::CapturedStmt::getCapturedStmt", NM="_ZN5clang12CapturedStmt15getCapturedStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang12CapturedStmt15getCapturedStmtEv")
  //</editor-fold>
  public Stmt /*P*/ getCapturedStmt() {
    return getStoredStmts().$at(NumCaptures);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::getCapturedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2107,
   FQN="clang::CapturedStmt::getCapturedStmt", NM="_ZNK5clang12CapturedStmt15getCapturedStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt15getCapturedStmtEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getCapturedStmt$Const() /*const*/ {
    return getStoredStmts$Const().$at(NumCaptures);
  }

  
  /// \brief Retrieve the outlined function declaration.
  
  /// \brief Retrieve the outlined function declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::getCapturedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 1084,
   FQN="clang::CapturedStmt::getCapturedDecl", NM="_ZN5clang12CapturedStmt15getCapturedDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CapturedStmt15getCapturedDeclEv")
  //</editor-fold>
  public CapturedDecl /*P*/ getCapturedDecl() {
    return CapDeclAndKind.getPointer();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::getCapturedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 1087,
   FQN="clang::CapturedStmt::getCapturedDecl", NM="_ZNK5clang12CapturedStmt15getCapturedDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CapturedStmt15getCapturedDeclEv")
  //</editor-fold>
  public /*const*/ CapturedDecl /*P*/ getCapturedDecl$Const() /*const*/ {
    return CapDeclAndKind.getPointer();
  }


  
  /// \brief Set the outlined function declaration.
  
  /// \brief Set the outlined function declaration.
  
  /// \brief Set the outlined function declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::setCapturedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 1092,
   FQN="clang::CapturedStmt::setCapturedDecl", NM="_ZN5clang12CapturedStmt15setCapturedDeclEPNS_12CapturedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CapturedStmt15setCapturedDeclEPNS_12CapturedDeclE")
  //</editor-fold>
  public void setCapturedDecl(CapturedDecl /*P*/ D) {
    assert ((D != null)) : "null CapturedDecl";
    CapDeclAndKind.setPointer(D);
  }


  
  /// \brief Retrieve the captured region kind.
  
  /// \brief Retrieve the captured region kind.
  
  /// \brief Retrieve the captured region kind.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::getCapturedRegionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 1098,
   FQN="clang::CapturedStmt::getCapturedRegionKind", NM="_ZNK5clang12CapturedStmt21getCapturedRegionKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CapturedStmt21getCapturedRegionKindEv")
  //</editor-fold>
  public CapturedRegionKind getCapturedRegionKind() /*const*/ {
    return CapDeclAndKind.getInt();
  }


  
  /// \brief Set the captured region kind.
  
  /// \brief Set the captured region kind.
  
  /// \brief Set the captured region kind.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::setCapturedRegionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 1103,
   FQN="clang::CapturedStmt::setCapturedRegionKind", NM="_ZN5clang12CapturedStmt21setCapturedRegionKindENS_18CapturedRegionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CapturedStmt21setCapturedRegionKindENS_18CapturedRegionKindE")
  //</editor-fold>
  public void setCapturedRegionKind(CapturedRegionKind Kind) {
    CapDeclAndKind.setInt(Kind);
  }


  
  /// \brief Retrieve the record declaration for captured variables.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::getCapturedRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2123,
   FQN="clang::CapturedStmt::getCapturedRecordDecl", NM="_ZNK5clang12CapturedStmt21getCapturedRecordDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt21getCapturedRecordDeclEv")
  //</editor-fold>
  public /*const*/ RecordDecl /*P*/ getCapturedRecordDecl() /*const*/ {
    return TheRecordDecl;
  }

  
  /// \brief Set the record declaration for captured variables.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::setCapturedRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2126,
   FQN="clang::CapturedStmt::setCapturedRecordDecl", NM="_ZN5clang12CapturedStmt21setCapturedRecordDeclEPNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang12CapturedStmt21setCapturedRecordDeclEPNS_10RecordDeclE")
  //</editor-fold>
  public void setCapturedRecordDecl(RecordDecl /*P*/ D) {
    assert ((D != null)) : "null RecordDecl";
    TheRecordDecl = D;
  }

  
  /// \brief True if this variable has been captured.
  
  /// \brief True if this variable has been captured.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::capturesVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 1107,
   FQN="clang::CapturedStmt::capturesVariable", NM="_ZNK5clang12CapturedStmt16capturesVariableEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang12CapturedStmt16capturesVariableEPKNS_7VarDeclE")
  //</editor-fold>
  public boolean capturesVariable(/*const*/ VarDecl /*P*/ Var) /*const*/ {
    for (final /*const*/ Capture /*&*/ I : captures$Const()) {
      if (!I.capturesVariable()) {
        continue;
      }
      
      // This does not handle variable redeclarations. This should be
      // extended to capture variables with redeclarations, for example
      // a thread-private variable in OpenMP.
      if (I.getCapturedVar() == Var) {
        return true;
      }
    }
    
    return false;
  }


  
  /// \brief An iterator that walks over the captures.
  /*typedef Capture *capture_iterator*/
//  public final class capture_iterator extends Capture /*P*/ { };
  /*typedef const Capture *const_capture_iterator*/
//  public final class const_capture_iterator extends /*const*/ Capture /*P*/ { };
  /*typedef llvm::iterator_range<capture_iterator> capture_range*/
//  public final class capture_range extends iterator_range<Capture>{ };
  /*typedef llvm::iterator_range<const_capture_iterator> capture_const_range*/
//  public final class capture_const_range extends iterator_range</*const*/ Capture>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::captures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2140,
   FQN="clang::CapturedStmt::captures", NM="_ZN5clang12CapturedStmt8capturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang12CapturedStmt8capturesEv")
  //</editor-fold>
  public iterator_range<Capture> captures() {
    return new iterator_range<Capture>(capture_begin(), capture_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::captures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2143,
   FQN="clang::CapturedStmt::captures", NM="_ZNK5clang12CapturedStmt8capturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt8capturesEv")
  //</editor-fold>
  public iterator_range</*const*/ Capture> captures$Const() /*const*/ {
    return new iterator_range</*const*/ Capture>(capture_begin$Const(), capture_end());
  }

  
  /// \brief Retrieve an iterator pointing to the first capture.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::capture_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2148,
   FQN="clang::CapturedStmt::capture_begin", NM="_ZN5clang12CapturedStmt13capture_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang12CapturedStmt13capture_beginEv")
  //</editor-fold>
  public type$ptr<Capture /*P*/ > capture_begin() {
    return getStoredCaptures();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::capture_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2149,
   FQN="clang::CapturedStmt::capture_begin", NM="_ZNK5clang12CapturedStmt13capture_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt13capture_beginEv")
  //</editor-fold>
  public type$ptr</*const*/ Capture /*P*/ > capture_begin$Const() /*const*/ {
    return getStoredCaptures();
  }

  
  /// \brief Retrieve an iterator pointing past the end of the sequence of
  /// captures.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::capture_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2153,
   FQN="clang::CapturedStmt::capture_end", NM="_ZNK5clang12CapturedStmt11capture_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt11capture_endEv")
  //</editor-fold>
  public type$ptr<Capture /*P*/ > capture_end() /*const*/ {
    return getStoredCaptures().$add(NumCaptures);
  }

  
  /// \brief Retrieve the number of captures, including 'this'.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::capture_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2158,
   FQN="clang::CapturedStmt::capture_size", NM="_ZNK5clang12CapturedStmt12capture_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt12capture_sizeEv")
  //</editor-fold>
  public /*uint*/int capture_size() /*const*/ {
    return NumCaptures;
  }

  
  /// \brief Iterator that walks over the capture initialization arguments.
  /*typedef Expr **capture_init_iterator*/
//  public final class capture_init_iterator extends type$ptr<Expr /*P*/ /*P*/>{ };
  /*typedef llvm::iterator_range<capture_init_iterator> capture_init_range*/
//  public final class capture_init_range extends iterator_range<Expr /*P*/ >{ };
  
  /// \brief Const iterator that walks over the capture initialization
  /// arguments.
  /*typedef Expr *const *const_capture_init_iterator*/
//  public final class const_capture_init_iterator extends type$ptr<Expr /*P*/ /*const*/ /*P*/>{ };
  /*typedef llvm::iterator_range<const_capture_init_iterator> const_capture_init_range*/
//  public final class const_capture_init_range extends iterator_range<Expr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::capture_inits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2170,
   FQN="clang::CapturedStmt::capture_inits", NM="_ZN5clang12CapturedStmt13capture_initsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang12CapturedStmt13capture_initsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > capture_inits() {
    return new iterator_range<Expr /*P*/ >(capture_init_begin(), capture_init_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::capture_inits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2174,
   FQN="clang::CapturedStmt::capture_inits", NM="_ZNK5clang12CapturedStmt13capture_initsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt13capture_initsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ /*const*/> capture_inits$Const() /*const*/ {
    return new iterator_range<Expr /*P*/ /*const*/>(capture_init_begin$Const(), capture_init_end$Const());
  }

  
  /// \brief Retrieve the first initialization argument.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::capture_init_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2179,
   FQN="clang::CapturedStmt::capture_init_begin", NM="_ZN5clang12CapturedStmt18capture_init_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang12CapturedStmt18capture_init_beginEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*P*/> capture_init_begin() {
    return ((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, getStoredStmts()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::capture_init_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2183,
   FQN="clang::CapturedStmt::capture_init_begin", NM="_ZNK5clang12CapturedStmt18capture_init_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt18capture_init_beginEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*const*/ /*P*/> capture_init_begin$Const() /*const*/ {
    return ((type$ptr<Expr /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, getStoredStmts$Const()));
  }

  
  /// \brief Retrieve the iterator pointing one past the last initialization
  /// argument.
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::capture_init_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2189,
   FQN="clang::CapturedStmt::capture_init_end", NM="_ZN5clang12CapturedStmt16capture_init_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang12CapturedStmt16capture_init_endEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*P*/> capture_init_end() {
    return capture_init_begin().$add(NumCaptures);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::capture_init_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2193,
   FQN="clang::CapturedStmt::capture_init_end", NM="_ZNK5clang12CapturedStmt16capture_init_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt16capture_init_endEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*const*/ /*P*/> capture_init_end$Const() /*const*/ {
    return capture_init_begin$Const().$add(NumCaptures);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2197,
   FQN="clang::CapturedStmt::getLocStart", NM="_ZNK5clang12CapturedStmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getCapturedStmt$Const().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2200,
   FQN="clang::CapturedStmt::getLocEnd", NM="_ZNK5clang12CapturedStmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getCapturedStmt$Const().getLocEnd();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2203,
   FQN="clang::CapturedStmt::getSourceRange", NM="_ZNK5clang12CapturedStmt14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang12CapturedStmt14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return getCapturedStmt$Const().getSourceRange();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 2207,
   FQN="clang::CapturedStmt::classof", NM="_ZN5clang12CapturedStmt7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang12CapturedStmt7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CapturedStmtClass;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapturedStmt::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 1079,
   FQN="clang::CapturedStmt::children", NM="_ZN5clang12CapturedStmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang12CapturedStmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    // Children are captured field initilizers.
    return new iterator_range<Stmt/*P*/>(new StmtIterator(getStoredStmts()), new StmtIterator(getStoredStmts().$add(NumCaptures)));
  }


  
  /*friend  class ASTStmtReader*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private type$ptr<Capture> init$StoredCaptures$Mem(int NumCaptures) {
    /*uint*/int Size =(true/*JAVA*/ ? 1 : $sizeof_CapturedStmt()) + (true/*JAVA*/ ? 1 : $sizeof_ptr(/*Stmt  */)) * (NumCaptures + 1);
//    
    // Offset of the first Capture object.
    /*uint*/int FirstCaptureOffset = $ulong2uint(llvm.alignTo($uint2ulong(Size), $uint2ulong((true/*JAVA*/ ? 1 : llvm.<Capture>alignOf(Capture.class)))));
    
//    return reinterpret_cast(Capture /*P*/ .class, reinterpret_cast(char$ptr/*char P*/ .class, ((/*const_cast*/CapturedStmt /*P*/ )(this))).$add(FirstCaptureOffset));
    return (type$ptr<Capture>)super.$this().$add(FirstCaptureOffset);
  }
  private final type$ptr</*const*/ Capture /*P*/ /*const*/ /*P*/> $Captures;

  @Override public final type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "NumCaptures=" + NumCaptures // NOI18N
              + ", CapDeclAndKind=" + CapDeclAndKind // NOI18N
              + ", TheRecordDecl=" + TheRecordDecl // NOI18N
              + super.toString(); // NOI18N
  }
}
