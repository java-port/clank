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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// \brief Describes an entity that is being initialized.
//<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 41,
 FQN="clang::InitializedEntity", NM="_ZN5clang17InitializedEntityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntityE")
//</editor-fold>
public class InitializedEntity implements NativePOD<InitializedEntity> {
/*public:*/
  /// \brief Specifies the kind of entity being initialized.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::EntityKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 44,
   FQN="clang::InitializedEntity::EntityKind", NM="_ZN5clang17InitializedEntity10EntityKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity10EntityKindE")
  //</editor-fold>
  public enum EntityKind implements Native.ComparableLower, Native.NativeUIntEnum {
    /// \brief The entity being initialized is a variable.
    EK_Variable(0),
    /// \brief The entity being initialized is a function parameter.
    EK_Parameter(EK_Variable.getValue() + 1),
    /// \brief The entity being initialized is the result of a function call.
    EK_Result(EK_Parameter.getValue() + 1),
    /// \brief The entity being initialized is an exception object that
    /// is being thrown.
    EK_Exception(EK_Result.getValue() + 1),
    /// \brief The entity being initialized is a non-static data member 
    /// subobject.
    EK_Member(EK_Exception.getValue() + 1),
    /// \brief The entity being initialized is an element of an array.
    EK_ArrayElement(EK_Member.getValue() + 1),
    /// \brief The entity being initialized is an object (or array of
    /// objects) allocated via new.
    EK_New(EK_ArrayElement.getValue() + 1),
    /// \brief The entity being initialized is a temporary object.
    EK_Temporary(EK_New.getValue() + 1),
    /// \brief The entity being initialized is a base member subobject.
    EK_Base(EK_Temporary.getValue() + 1),
    /// \brief The initialization is being done by a delegating constructor.
    EK_Delegating(EK_Base.getValue() + 1),
    /// \brief The entity being initialized is an element of a vector.
    /// or vector.
    EK_VectorElement(EK_Delegating.getValue() + 1),
    /// \brief The entity being initialized is a field of block descriptor for
    /// the copied-in c++ object.
    EK_BlockElement(EK_VectorElement.getValue() + 1),
    /// \brief The entity being initialized is the real or imaginary part of a
    /// complex number.
    EK_ComplexElement(EK_BlockElement.getValue() + 1),
    /// \brief The entity being initialized is the field that captures a 
    /// variable in a lambda.
    EK_LambdaCapture(EK_ComplexElement.getValue() + 1),
    /// \brief The entity being initialized is the initializer for a compound
    /// literal.
    EK_CompoundLiteralInit(EK_LambdaCapture.getValue() + 1),
    /// \brief The entity being implicitly initialized back to the formal
    /// result type.
    EK_RelatedResult(EK_CompoundLiteralInit.getValue() + 1),
    /// \brief The entity being initialized is a function parameter; function
    /// is member of group of audited CF APIs.
    EK_Parameter_CF_Audited(EK_RelatedResult.getValue() + 1);
    // Note: err_init_conversion_failed in DiagnosticSemaKinds.td uses this
    // enum as an index for its first %select.  When modifying this list,
    // that diagnostic text needs to be updated as well.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static EntityKind valueOf(int val) {
      EntityKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final EntityKind[] VALUES;
      private static final EntityKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (EntityKind kind : EntityKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new EntityKind[min < 0 ? (1-min) : 0];
        VALUES = new EntityKind[max >= 0 ? (1+max) : 0];
        for (EntityKind kind : EntityKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private EntityKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((EntityKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((EntityKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  /// \brief The kind of entity being initialized.
  private EntityKind Kind;
  
  /// \brief If non-NULL, the parent entity in which this
  /// initialization occurs.
  private /*const*/ InitializedEntity /*P*/ Parent;
  
  /// \brief The type of the object or reference being initialized.
  private QualType Type;
  
  /// \brief The mangling number for the next reference temporary to be created.
  private /*mutable *//*uint*/int ManglingNumber;
  
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::LN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 109,
   FQN="clang::InitializedEntity::LN", NM="_ZN5clang17InitializedEntity2LNE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity2LNE")
  //</editor-fold>
  private static class/*struct*/ LN {
    /// \brief When Kind == EK_Result, EK_Exception, EK_New, the
    /// location of the 'return', 'throw', or 'new' keyword,
    /// respectively. When Kind == EK_Temporary, the location where
    /// the temporary is being created.
    public /*uint*/int Location;
    
    /// \brief Whether the entity being initialized may end up using the
    /// named return value optimization (NRVO).
    public boolean NRVO;
    //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::LN::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added from another TU*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 109,
     FQN="clang::InitializedEntity::LN::operator=", NM="_ZN5clang17InitializedEntity2LNaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity2LNaSEOS1_")
    //</editor-fold>
    public /*inline*/ LN /*&*/ $assignMove(final LN /*&&*/$Prm0) {
      this.Location = $Prm0.Location;
      this.NRVO = $Prm0.NRVO;
      return /*Deref*/this;
    }
    public /*inline*/ LN /*&*/ $assign(final LN /*&&*/$Prm0) {
      this.Location = $Prm0.Location;
      this.NRVO = $Prm0.NRVO;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Location=" + Location // NOI18N
                + ", NRVO=" + NRVO; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::C">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 121,
   FQN="clang::InitializedEntity::C", NM="_ZN5clang17InitializedEntity1CE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity1CE")
  //</editor-fold>
  private static class/*struct*/ C {
    /// \brief The name of the variable being captured by an EK_LambdaCapture.
    public IdentifierInfo /*P*/ VarID;
    
    /// \brief The source location at which the capture occurs.
    public /*uint*/int Location;
    //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::C::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added from another TU*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 121,
     FQN="clang::InitializedEntity::C::operator=", NM="_ZN5clang17InitializedEntity1CaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity1CaSEOS1_")
    //</editor-fold>
    public /*inline*/ C /*&*/ $assignMove(final C /*&&*/$Prm0) {
      this.VarID = $Prm0.VarID;
      this.Location = $Prm0.Location;
      return /*Deref*/this;
    }
    public /*inline*/ C /*&*/ $assign(final C /*&&*/$Prm0) {
      this.VarID = $Prm0.VarID;
      this.Location = $Prm0.Location;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "VarID=" + VarID // NOI18N
                + ", Location=" + Location; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 129,
   FQN="clang::InitializedEntity::(anonymous)", NM="_ZN5clang17InitializedEntityE_Unnamed_union3",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntityE_Unnamed_union3")
  //</editor-fold>
  private static class/*union*/ Unnamed_union3 {
    /// \brief When Kind == EK_Variable, or EK_Member, the VarDecl or
    /// FieldDecl, respectively.
    public DeclaratorDecl /*P*/ VariableOrMember;
    
    /// \brief When Kind == EK_RelatedResult, the ObjectiveC method where
    /// result type was implicitly changed to accommodate ARC semantics.
    public ObjCMethodDecl /*P*/ MethodDecl;
    
    /// \brief When Kind == EK_Parameter, the ParmVarDecl, with the
    /// low bit indicating whether the parameter is "consumed".
    public Object/*uintptr_t*/ Parameter; // JAVA it's lowest bit was moved into $lower$bits with mask 0x01
    
    /// \brief When Kind == EK_Temporary or EK_CompoundLiteralInit, the type
    /// source information for the temporary.
    public TypeSourceInfo /*P*/ TypeInfo;
    
    public final LN LocAndNRVO = new LN();
    
    /// \brief When Kind == EK_Base, the base specifier that provides the 
    /// base class. The lower bit specifies whether the base is an inherited
    /// virtual base.
    public Object/*uintptr_t*/ Base; // // JAVA it's lowest bit was moved into $lower$bits with mask 0x02
    
    /// \brief When Kind == EK_ArrayElement, EK_VectorElement, or
    /// EK_ComplexElement, the index of the array or vector element being
    /// initialized. 
    public /*uint*/int Index;
    
    public final C Capture = new C();
    
    //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 129,
     FQN="clang::InitializedEntity::(anonymous union)::", NM="_ZN5clang17InitializedEntityUt_C1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntityUt_C1ERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union3(final Unnamed_union3 $Prm0) {
      $assign($Prm0);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 129,
     FQN="clang::InitializedEntity::(anonymous union)::", NM="_ZN5clang17InitializedEntityUt_C1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntityUt_C1EOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union3(JD$Move _dparam, final Unnamed_union3 $Prm0) {
      $assignMove($Prm0);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 129,
     FQN="clang::InitializedEntity::(anonymous union)::operator=", NM="_ZN5clang17InitializedEntityUt_aSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntityUt_aSEOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union3 $assignMove(final Unnamed_union3 $Prm0) {
      
      this.VariableOrMember = $Prm0.VariableOrMember;
      
      this.MethodDecl = $Prm0.MethodDecl;
      
      this.Parameter = $Prm0.Parameter;
      
      this.TypeInfo = $Prm0.TypeInfo;
      
      this.LocAndNRVO.$assignMove($Prm0.LocAndNRVO);
      
      this.Base = $Prm0.Base;

      this.$lower$bits = $Prm0.$lower$bits;

      this.Index = $Prm0.Index;
      
      this.Capture.$assignMove($Prm0.Capture);
      
      return /*Deref*/this;
    }
    public /*inline*/ Unnamed_union3 $assign(final Unnamed_union3 $Prm0) {
      
      this.VariableOrMember = $Prm0.VariableOrMember;
      
      this.MethodDecl = $Prm0.MethodDecl;
      
      this.Parameter = $Prm0.Parameter;
      
      this.TypeInfo = $Prm0.TypeInfo;
      
      this.LocAndNRVO.$assign($Prm0.LocAndNRVO);
      
      this.Base = $Prm0.Base;

      this.$lower$bits = $Prm0.$lower$bits;

      this.Index = $Prm0.Index;
      
      this.Capture.$assign($Prm0.Capture);
      
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    /**/ char $lower$bits; // the lowest bit corresponds to Base lower bit, the 2-nd - to Param lower bit
    // see     private static char $Param$Mask = 0x01; && private static char $Base$Mask = 0x02;
    
    protected Unnamed_union3() {}

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "VariableOrMember=" + VariableOrMember // NOI18N
                + ", MethodDecl=" + MethodDecl // NOI18N
                + ", Parameter=" + Parameter // NOI18N
                + ", TypeInfo=" + TypeInfo // NOI18N
                + ", LocAndNRVO=" + LocAndNRVO // NOI18N
                + ", Base=" + Base // NOI18N
                + ", Index=" + Index // NOI18N
                + ", Capture=" + Capture; // NOI18N
    }
  };
  private static char $Param$Mask = 0x01;
  private static char $Base$Mask = 0x02;  
  private final Unnamed_union3 Unnamed_field4 = new Unnamed_union3();
  
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 161,
   FQN="clang::InitializedEntity::InitializedEntity", NM="_ZN5clang17InitializedEntityC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntityC1Ev")
  //</editor-fold>
  public/*private*/ InitializedEntity() {
    // : Type(), ManglingNumber(0) 
    //START JInit
    this.Type = new QualType();
    this.ManglingNumber = 0;
    //END JInit
  }

  
  /// \brief Create the initialization entity for a variable.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 164,
   FQN="clang::InitializedEntity::InitializedEntity", NM="_ZN5clang17InitializedEntityC1EPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntityC1EPNS_7VarDeclE")
  //</editor-fold>
  private InitializedEntity(VarDecl /*P*/ Var) {
    // : Kind(EK_Variable), Parent(null), Type(Var->getType()), ManglingNumber(0), VariableOrMember(Var) 
    //START JInit
    this.Kind = EntityKind.EK_Variable;
    this.Parent = null;
    this.Type = Var.getType();
    this.ManglingNumber = 0;
    /*Indirect*/this.Unnamed_field4.VariableOrMember = Var;
    //END JInit
  }

  
  /// \brief Create the initialization entity for the result of a
  /// function, throwing an object, performing an explicit cast, or
  /// initializing a parameter for which there is no declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 171,
   FQN="clang::InitializedEntity::InitializedEntity", NM="_ZN5clang17InitializedEntityC1ENS0_10EntityKindENS_14SourceLocationENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntityC1ENS0_10EntityKindENS_14SourceLocationENS_8QualTypeEb")
  //</editor-fold>
  private InitializedEntity(EntityKind Kind, SourceLocation Loc, QualType Type) {
    this(Kind, Loc, Type, 
      false);
  }
  private InitializedEntity(EntityKind Kind, SourceLocation Loc, QualType Type, 
      boolean NRVO/*= false*/) {
    // : Kind(Kind), Parent(null), Type(Type), ManglingNumber(0) 
    //START JInit
    this.Kind = Kind;
    this.Parent = null;
    this.Type = new QualType(Type);
    this.ManglingNumber = 0;
    //END JInit
    Unnamed_field4.LocAndNRVO.Location = Loc.getRawEncoding();
    Unnamed_field4.LocAndNRVO.NRVO = NRVO;
  }

  
  /// \brief Create the initialization entity for a member subobject.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 180,
   FQN="clang::InitializedEntity::InitializedEntity", NM="_ZN5clang17InitializedEntityC1EPNS_9FieldDeclEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntityC1EPNS_9FieldDeclEPKS0_")
  //</editor-fold>
  private InitializedEntity(FieldDecl /*P*/ Member, /*const*/ InitializedEntity /*P*/ Parent) {
    // : Kind(EK_Member), Parent(Parent), Type(Member->getType()), ManglingNumber(0), VariableOrMember(Member) 
    //START JInit
    this.Kind = EntityKind.EK_Member;
    this.Parent = Parent;
    this.Type = Member.getType();
    this.ManglingNumber = 0;
    /*Indirect*/this.Unnamed_field4.VariableOrMember = Member;
    //END JInit
  }

  
  /// \brief Create the initialization entity for an array element.
  
  //===----------------------------------------------------------------------===//
  // Initialization entity
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 2855,
   FQN="clang::InitializedEntity::InitializedEntity", NM="_ZN5clang17InitializedEntityC1ERNS_10ASTContextEjRKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntityC1ERNS_10ASTContextEjRKS0_")
  //</editor-fold>
  private InitializedEntity(final ASTContext /*&*/ Context, /*uint*/int Index, 
      final /*const*/ InitializedEntity /*&*/ Parent) {
    // : Parent(&Parent), Type(), Index(Index) 
    //START JInit
    this.Parent = $AddrOf(Parent);
    this.Type = new QualType();
    /*Indirect*/this.Unnamed_field4.Index = Index;
    //END JInit
    {
      /*const*/ ArrayType /*P*/ AT = Context.getAsArrayType(Parent.getType());
      if ((AT != null)) {
        Kind = EntityKind.EK_ArrayElement;
        Type.$assignMove(AT.getElementType());
      } else {
        /*const*/ VectorType /*P*/ VT = Parent.getType().$arrow().getAs(VectorType.class);
        if ((VT != null)) {
          Kind = EntityKind.EK_VectorElement;
          Type.$assignMove(VT.getElementType());
        } else {
          /*const*/ ComplexType /*P*/ CT = Parent.getType().$arrow().getAs(ComplexType.class);
          assert ((CT != null)) : "Unexpected type";
          Kind = EntityKind.EK_ComplexElement;
          Type.$assignMove(CT.getElementType());
        }
      }
    }
  }

  
  /// \brief Create the initialization entity for a lambda capture.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 189,
   FQN="clang::InitializedEntity::InitializedEntity", NM="_ZN5clang17InitializedEntityC1EPNS_14IdentifierInfoENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntityC1EPNS_14IdentifierInfoENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  private InitializedEntity(IdentifierInfo /*P*/ VarID, QualType FieldType, SourceLocation Loc) {
    // : Kind(EK_LambdaCapture), Parent(null), Type(FieldType), ManglingNumber(0) 
    //START JInit
    this.Kind = EntityKind.EK_LambdaCapture;
    this.Parent = null;
    this.Type = new QualType(FieldType);
    this.ManglingNumber = 0;
    //END JInit
    Unnamed_field4.Capture.VarID = VarID;
    Unnamed_field4.Capture.Location = Loc.getRawEncoding();
  }

/*public:*/
  /// \brief Create the initialization entity for a variable.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 199,
   FQN="clang::InitializedEntity::InitializeVariable", NM="_ZN5clang17InitializedEntity18InitializeVariableEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity18InitializeVariableEPNS_7VarDeclE")
  //</editor-fold>
  public static InitializedEntity InitializeVariable(VarDecl /*P*/ Var) {
    return new InitializedEntity(Var);
  }

  
  /// \brief Create the initialization entity for a parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 204,
   FQN="clang::InitializedEntity::InitializeParameter", NM="_ZN5clang17InitializedEntity19InitializeParameterERNS_10ASTContextEPNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity19InitializeParameterERNS_10ASTContextEPNS_11ParmVarDeclE")
  //</editor-fold>
  public static InitializedEntity InitializeParameter(final ASTContext /*&*/ Context, 
                     ParmVarDecl /*P*/ Parm) {
    return InitializeParameter(Context, Parm, Parm.getType());
  }

  
  /// \brief Create the initialization entity for a parameter, but use
  /// another type.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeParameter">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 211,
   FQN="clang::InitializedEntity::InitializeParameter", NM="_ZN5clang17InitializedEntity19InitializeParameterERNS_10ASTContextEPNS_11ParmVarDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity19InitializeParameterERNS_10ASTContextEPNS_11ParmVarDeclENS_8QualTypeE")
  //</editor-fold>
  public static InitializedEntity InitializeParameter(final ASTContext /*&*/ Context, 
                     ParmVarDecl /*P*/ Parm, 
                     QualType Type) {
    boolean Consumed = (Context.getLangOpts().ObjCAutoRefCount
       && Parm.hasAttr(NSConsumedAttr.class));
    
    InitializedEntity Entity/*J*/= new InitializedEntity();
    Entity.Kind = EntityKind.EK_Parameter;
    Entity.Type.$assignMove(
        Context.getVariableArrayDecayedType(Type.getUnqualifiedType())
    );
    Entity.Parent = null;
    Entity.Unnamed_field4.Parameter = Parm;
    Entity.Unnamed_field4.$lower$bits |= Consumed ? $Param$Mask : 0; // orginally the lowest bit was used, but we use 2-nd one
    return Entity;
  }

  
  /// \brief Create the initialization entity for a parameter that is
  /// only known by its type.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeParameter">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 229,
   FQN="clang::InitializedEntity::InitializeParameter", NM="_ZN5clang17InitializedEntity19InitializeParameterERNS_10ASTContextENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity19InitializeParameterERNS_10ASTContextENS_8QualTypeEb")
  //</editor-fold>
  public static InitializedEntity InitializeParameter(final ASTContext /*&*/ Context, 
                     QualType Type, 
                     boolean Consumed) {
    InitializedEntity Entity/*J*/= new InitializedEntity();
    Entity.Kind = EntityKind.EK_Parameter;
    Entity.Type.$assignMove(Context.getVariableArrayDecayedType(new QualType(Type)));
    Entity.Parent = null;
    Entity.Unnamed_field4.Parameter = null;
    Entity.Unnamed_field4.$lower$bits |= Consumed ? $Param$Mask : 0; // orginally the lowest bit was used, but we use 2-nd one
    return Entity;
  }

  
  /// \brief Create the initialization entity for the result of a function.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 241,
   FQN="clang::InitializedEntity::InitializeResult", NM="_ZN5clang17InitializedEntity16InitializeResultENS_14SourceLocationENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity16InitializeResultENS_14SourceLocationENS_8QualTypeEb")
  //</editor-fold>
  public static InitializedEntity InitializeResult(SourceLocation ReturnLoc, 
                  QualType Type, boolean NRVO) {
    return new InitializedEntity(EntityKind.EK_Result, new SourceLocation(ReturnLoc), new QualType(Type), NRVO);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 246,
   FQN="clang::InitializedEntity::InitializeBlock", NM="_ZN5clang17InitializedEntity15InitializeBlockENS_14SourceLocationENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity15InitializeBlockENS_14SourceLocationENS_8QualTypeEb")
  //</editor-fold>
  public static InitializedEntity InitializeBlock(SourceLocation BlockVarLoc, 
                 QualType Type, boolean NRVO) {
    return new InitializedEntity(EntityKind.EK_BlockElement, new SourceLocation(BlockVarLoc), new QualType(Type), NRVO);
  }

  
  /// \brief Create the initialization entity for an exception object.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeException">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 252,
   FQN="clang::InitializedEntity::InitializeException", NM="_ZN5clang17InitializedEntity19InitializeExceptionENS_14SourceLocationENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity19InitializeExceptionENS_14SourceLocationENS_8QualTypeEb")
  //</editor-fold>
  public static InitializedEntity InitializeException(SourceLocation ThrowLoc, 
                     QualType Type, boolean NRVO) {
    return new InitializedEntity(EntityKind.EK_Exception, new SourceLocation(ThrowLoc), new QualType(Type), NRVO);
  }

  
  /// \brief Create the initialization entity for an object allocated via new.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeNew">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 258,
   FQN="clang::InitializedEntity::InitializeNew", NM="_ZN5clang17InitializedEntity13InitializeNewENS_14SourceLocationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity13InitializeNewENS_14SourceLocationENS_8QualTypeE")
  //</editor-fold>
  public static InitializedEntity InitializeNew(SourceLocation NewLoc, QualType Type) {
    return new InitializedEntity(EntityKind.EK_New, new SourceLocation(NewLoc), new QualType(Type));
  }

  
  /// \brief Create the initialization entity for a temporary.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 263,
   FQN="clang::InitializedEntity::InitializeTemporary", NM="_ZN5clang17InitializedEntity19InitializeTemporaryENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity19InitializeTemporaryENS_8QualTypeE")
  //</editor-fold>
  public static InitializedEntity InitializeTemporary(QualType Type) {
    InitializedEntity Result/*J*/= new InitializedEntity(EntityKind.EK_Temporary, new SourceLocation(), new QualType(Type));
    Result.Unnamed_field4.TypeInfo = null;
    return Result;
  }

  
  /// \brief Create the initialization entity for a temporary.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 270,
   FQN="clang::InitializedEntity::InitializeTemporary", NM="_ZN5clang17InitializedEntity19InitializeTemporaryEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity19InitializeTemporaryEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public static InitializedEntity InitializeTemporary(TypeSourceInfo /*P*/ TypeInfo) {
    InitializedEntity Result/*J*/= new InitializedEntity(EntityKind.EK_Temporary, new SourceLocation(), 
        TypeInfo.getType());
    Result.Unnamed_field4.TypeInfo = TypeInfo;
    return Result;
  }

  
  /// \brief Create the initialization entity for a related result.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeRelatedResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 278,
   FQN="clang::InitializedEntity::InitializeRelatedResult", NM="_ZN5clang17InitializedEntity23InitializeRelatedResultEPNS_14ObjCMethodDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity23InitializeRelatedResultEPNS_14ObjCMethodDeclENS_8QualTypeE")
  //</editor-fold>
  public static InitializedEntity InitializeRelatedResult(ObjCMethodDecl /*P*/ MD, 
                         QualType Type) {
    InitializedEntity Result/*J*/= new InitializedEntity(EntityKind.EK_RelatedResult, new SourceLocation(), new QualType(Type));
    Result.Unnamed_field4.MethodDecl = MD;
    return Result;
  }

  
  /// \brief Create the initialization entity for a base class subobject.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeBase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 2873,
   FQN="clang::InitializedEntity::InitializeBase", NM="_ZN5clang17InitializedEntity14InitializeBaseERNS_10ASTContextEPKNS_16CXXBaseSpecifierEbPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity14InitializeBaseERNS_10ASTContextEPKNS_16CXXBaseSpecifierEbPKS0_")
  //</editor-fold>
  public static InitializedEntity InitializeBase(final ASTContext /*&*/ Context, 
                /*const*/ CXXBaseSpecifier /*P*/ Base, 
                boolean IsInheritedVirtualBase) {
    return InitializeBase(Context, 
                Base, 
                IsInheritedVirtualBase, 
                (/*const*/ InitializedEntity /*P*/ )null);
  }
  public static InitializedEntity InitializeBase(final ASTContext /*&*/ Context, 
                /*const*/ CXXBaseSpecifier /*P*/ Base, 
                boolean IsInheritedVirtualBase, 
                /*const*/ InitializedEntity /*P*/ Parent/*= null*/) {
    InitializedEntity Result/*J*/= new InitializedEntity();
    Result.Kind = EntityKind.EK_Base;
    Result.Parent = Parent;
    Result.Unnamed_field4.Base = reinterpret_cast_Object/*uintptr_t*/(Base);
    Result.Unnamed_field4.$lower$bits = 0;
    if (IsInheritedVirtualBase) {
      Result.Unnamed_field4.$lower$bits |= $Base$Mask;
    }
    
    Result.Type.$assignMove(Base.getType());
    return Result;
  }

  
  /// \brief Create the initialization entity for a delegated constructor.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeDelegation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 293,
   FQN="clang::InitializedEntity::InitializeDelegation", NM="_ZN5clang17InitializedEntity20InitializeDelegationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity20InitializeDelegationENS_8QualTypeE")
  //</editor-fold>
  public static InitializedEntity InitializeDelegation(QualType Type) {
    return new InitializedEntity(EntityKind.EK_Delegating, new SourceLocation(), new QualType(Type));
  }

  
  /// \brief Create the initialization entity for a member subobject.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 298,
   FQN="clang::InitializedEntity::InitializeMember", NM="_ZN5clang17InitializedEntity16InitializeMemberEPNS_9FieldDeclEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity16InitializeMemberEPNS_9FieldDeclEPKS0_")
  //</editor-fold>
  public static InitializedEntity InitializeMember(FieldDecl /*P*/ Member) {
    return InitializeMember(Member, 
                  (/*const*/ InitializedEntity /*P*/ )null);
  }
  public static InitializedEntity InitializeMember(FieldDecl /*P*/ Member, 
                  /*const*/ InitializedEntity /*P*/ Parent/*= null*/) {
    return new InitializedEntity(Member, Parent);
  }

  
  /// \brief Create the initialization entity for a member subobject.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 305,
   FQN="clang::InitializedEntity::InitializeMember", NM="_ZN5clang17InitializedEntity16InitializeMemberEPNS_17IndirectFieldDeclEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity16InitializeMemberEPNS_17IndirectFieldDeclEPKS0_")
  //</editor-fold>
  public static InitializedEntity InitializeMember(IndirectFieldDecl /*P*/ Member) {
    return InitializeMember(Member, 
                  (/*const*/ InitializedEntity /*P*/ )null);
  }
  public static InitializedEntity InitializeMember(IndirectFieldDecl /*P*/ Member, 
                  /*const*/ InitializedEntity /*P*/ Parent/*= null*/) {
    return new InitializedEntity(Member.getAnonField(), Parent);
  }

  
  /// \brief Create the initialization entity for an array element.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 312,
   FQN="clang::InitializedEntity::InitializeElement", NM="_ZN5clang17InitializedEntity17InitializeElementERNS_10ASTContextEjRKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity17InitializeElementERNS_10ASTContextEjRKS0_")
  //</editor-fold>
  public static InitializedEntity InitializeElement(final ASTContext /*&*/ Context, 
                   /*uint*/int Index, 
                   final /*const*/ InitializedEntity /*&*/ Parent) {
    return new InitializedEntity(Context, Index, Parent);
  }

  
  /// \brief Create the initialization entity for a lambda capture.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeLambdaCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 319,
   FQN="clang::InitializedEntity::InitializeLambdaCapture", NM="_ZN5clang17InitializedEntity23InitializeLambdaCaptureEPNS_14IdentifierInfoENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity23InitializeLambdaCaptureEPNS_14IdentifierInfoENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public static InitializedEntity InitializeLambdaCapture(IdentifierInfo /*P*/ VarID, 
                         QualType FieldType, 
                         SourceLocation Loc) {
    return new InitializedEntity(VarID, new QualType(FieldType), new SourceLocation(Loc));
  }

  
  /// \brief Create the entity for a compound literal initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializeCompoundLiteralInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 326,
   FQN="clang::InitializedEntity::InitializeCompoundLiteralInit", NM="_ZN5clang17InitializedEntity29InitializeCompoundLiteralInitEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity29InitializeCompoundLiteralInitEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public static InitializedEntity InitializeCompoundLiteralInit(TypeSourceInfo /*P*/ TSI) {
    InitializedEntity Result/*J*/= new InitializedEntity(EntityKind.EK_CompoundLiteralInit, new SourceLocation(), 
        TSI.getType());
    Result.Unnamed_field4.TypeInfo = TSI;
    return Result;
  }

  
  /// \brief Determine the kind of initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 335,
   FQN="clang::InitializedEntity::getKind", NM="_ZNK5clang17InitializedEntity7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity7getKindEv")
  //</editor-fold>
  public EntityKind getKind() /*const*/ {
    return Kind;
  }

  
  /// \brief Retrieve the parent of the entity being initialized, when
  /// the initialization itself is occurring within the context of a
  /// larger initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 340,
   FQN="clang::InitializedEntity::getParent", NM="_ZNK5clang17InitializedEntity9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity9getParentEv")
  //</editor-fold>
  public /*const*/ InitializedEntity /*P*/ getParent() /*const*/ {
    return Parent;
  }

  
  /// \brief Retrieve type being initialized.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 343,
   FQN="clang::InitializedEntity::getType", NM="_ZNK5clang17InitializedEntity7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity7getTypeEv")
  //</editor-fold>
  public QualType getType() /*const*/ {
    return new QualType(Type);
  }

  
  /// \brief Retrieve complete type-source information for the object being 
  /// constructed, if known.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::getTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 347,
   FQN="clang::InitializedEntity::getTypeSourceInfo", NM="_ZNK5clang17InitializedEntity17getTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity17getTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeSourceInfo() /*const*/ {
    if (Kind == EntityKind.EK_Temporary || Kind == EntityKind.EK_CompoundLiteralInit) {
      return Unnamed_field4.TypeInfo;
    }
    
    return null;
  }

  
  /// \brief Retrieve the name of the entity being initialized.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::getName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 2889,
   FQN="clang::InitializedEntity::getName", NM="_ZNK5clang17InitializedEntity7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity7getNameEv")
  //</editor-fold>
  public DeclarationName getName() /*const*/ {
    switch (getKind()) {
     case EK_Parameter:
     case EK_Parameter_CF_Audited:
      {
        ParmVarDecl /*P*/ D = reinterpret_cast(ParmVarDecl /*P*/ .class, Unnamed_field4.Parameter/* & ~0x1*/);
        return ((D != null) ? D.getDeclName() : new DeclarationName());
      }
     case EK_Variable:
     case EK_Member:
      return Unnamed_field4.VariableOrMember.getDeclName();
     case EK_LambdaCapture:
      return new DeclarationName(Unnamed_field4.Capture.VarID);
     case EK_Result:
     case EK_Exception:
     case EK_New:
     case EK_Temporary:
     case EK_Base:
     case EK_Delegating:
     case EK_ArrayElement:
     case EK_VectorElement:
     case EK_ComplexElement:
     case EK_BlockElement:
     case EK_CompoundLiteralInit:
     case EK_RelatedResult:
      return new DeclarationName();
    }
    throw new llvm_unreachable("Invalid EntityKind!");
  }

  
  /// \brief Retrieve the variable, parameter, or field being
  /// initialized.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::getDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 2922,
   FQN="clang::InitializedEntity::getDecl", NM="_ZNK5clang17InitializedEntity7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity7getDeclEv")
  //</editor-fold>
  public DeclaratorDecl /*P*/ getDecl() /*const*/ {
    switch (getKind()) {
     case EK_Variable:
     case EK_Member:
      return Unnamed_field4.VariableOrMember;
     case EK_Parameter:
     case EK_Parameter_CF_Audited:
      return reinterpret_cast(ParmVarDecl /*P*/ .class, Unnamed_field4.Parameter/* & ~0x1*/);
     case EK_Result:
     case EK_Exception:
     case EK_New:
     case EK_Temporary:
     case EK_Base:
     case EK_Delegating:
     case EK_ArrayElement:
     case EK_VectorElement:
     case EK_ComplexElement:
     case EK_BlockElement:
     case EK_LambdaCapture:
     case EK_CompoundLiteralInit:
     case EK_RelatedResult:
      return null;
    }
    throw new llvm_unreachable("Invalid EntityKind!");
  }

  
  /// \brief Retrieve the ObjectiveC method being initialized.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::getMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 362,
   FQN="clang::InitializedEntity::getMethodDecl", NM="_ZNK5clang17InitializedEntity13getMethodDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity13getMethodDeclEv")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getMethodDecl() /*const*/ {
    return Unnamed_field4.MethodDecl;
  }

  
  /// \brief Determine whether this initialization allows the named return 
  /// value optimization, which also applies to thrown objects.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::allowsNRVO">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 2951,
   FQN="clang::InitializedEntity::allowsNRVO", NM="_ZNK5clang17InitializedEntity10allowsNRVOEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity10allowsNRVOEv")
  //</editor-fold>
  public boolean allowsNRVO() /*const*/ {
    switch (getKind()) {
     case EK_Result:
     case EK_Exception:
      return Unnamed_field4.LocAndNRVO.NRVO;
     case EK_Variable:
     case EK_Parameter:
     case EK_Parameter_CF_Audited:
     case EK_Member:
     case EK_New:
     case EK_Temporary:
     case EK_CompoundLiteralInit:
     case EK_Base:
     case EK_Delegating:
     case EK_ArrayElement:
     case EK_VectorElement:
     case EK_ComplexElement:
     case EK_BlockElement:
     case EK_LambdaCapture:
     case EK_RelatedResult:
      break;
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::isParameterKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 368,
   FQN="clang::InitializedEntity::isParameterKind", NM="_ZNK5clang17InitializedEntity15isParameterKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity15isParameterKindEv")
  //</editor-fold>
  public boolean isParameterKind() /*const*/ {
    return (getKind() == EntityKind.EK_Parameter
       || getKind() == EntityKind.EK_Parameter_CF_Audited);
  }

  /// \brief Determine whether this initialization consumes the
  /// parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::isParameterConsumed">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 374,
   FQN="clang::InitializedEntity::isParameterConsumed", NM="_ZNK5clang17InitializedEntity19isParameterConsumedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity19isParameterConsumedEv")
  //</editor-fold>
  public boolean isParameterConsumed() /*const*/ {
    assert (isParameterKind()) : "Not a parameter";
    return ((/*Unnamed_field4.Parameter & 1*/ Unnamed_field4.$lower$bits & $Param$Mask) != 0);
  }

  
  /// \brief Retrieve the base specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::getBaseSpecifier">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 380,
   FQN="clang::InitializedEntity::getBaseSpecifier", NM="_ZNK5clang17InitializedEntity16getBaseSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity16getBaseSpecifierEv")
  //</editor-fold>
  public /*const*/ CXXBaseSpecifier /*P*/ getBaseSpecifier() /*const*/ {
    assert (getKind() == EntityKind.EK_Base) : "Not a base specifier";
    return reinterpret_cast(/*const*/ CXXBaseSpecifier /*P*/ .class, Unnamed_field4.Base);
  }

  
  /// \brief Return whether the base is an inherited virtual base.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::isInheritedVirtualBase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 386,
   FQN="clang::InitializedEntity::isInheritedVirtualBase", NM="_ZNK5clang17InitializedEntity22isInheritedVirtualBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity22isInheritedVirtualBaseEv")
  //</editor-fold>
  public boolean isInheritedVirtualBase() /*const*/ {
    assert (getKind() == EntityKind.EK_Base) : "Not a base specifier";
    return ((Unnamed_field4.$lower$bits & $Base$Mask) != 0);
  }

  
  /// \brief Determine the location of the 'return' keyword when initializing
  /// the result of a function call.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::getReturnLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 393,
   FQN="clang::InitializedEntity::getReturnLoc", NM="_ZNK5clang17InitializedEntity12getReturnLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity12getReturnLocEv")
  //</editor-fold>
  public SourceLocation getReturnLoc() /*const*/ {
    assert (getKind() == EntityKind.EK_Result) : "No 'return' location!";
    return SourceLocation.getFromRawEncoding(Unnamed_field4.LocAndNRVO.Location);
  }

  
  /// \brief Determine the location of the 'throw' keyword when initializing
  /// an exception object.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::getThrowLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 400,
   FQN="clang::InitializedEntity::getThrowLoc", NM="_ZNK5clang17InitializedEntity11getThrowLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity11getThrowLocEv")
  //</editor-fold>
  public SourceLocation getThrowLoc() /*const*/ {
    assert (getKind() == EntityKind.EK_Exception) : "No 'throw' location!";
    return SourceLocation.getFromRawEncoding(Unnamed_field4.LocAndNRVO.Location);
  }

  
  /// \brief If this is an array, vector, or complex number element, get the
  /// element's index.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::getElementIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 407,
   FQN="clang::InitializedEntity::getElementIndex", NM="_ZNK5clang17InitializedEntity15getElementIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity15getElementIndexEv")
  //</editor-fold>
  public /*uint*/int getElementIndex() /*const*/ {
    assert (getKind() == EntityKind.EK_ArrayElement || getKind() == EntityKind.EK_VectorElement || getKind() == EntityKind.EK_ComplexElement);
    return Unnamed_field4.Index;
  }

  /// \brief If this is already the initializer for an array or vector
  /// element, sets the element index.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::setElementIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 414,
   FQN="clang::InitializedEntity::setElementIndex", NM="_ZN5clang17InitializedEntity15setElementIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity15setElementIndexEj")
  //</editor-fold>
  public void setElementIndex(/*uint*/int Index) {
    assert (getKind() == EntityKind.EK_ArrayElement || getKind() == EntityKind.EK_VectorElement || getKind() == EntityKind.EK_ComplexElement);
    this.Unnamed_field4.Index = Index;
  }

  /// \brief For a lambda capture, return the capture's name.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::getCapturedVarName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 420,
   FQN="clang::InitializedEntity::getCapturedVarName", NM="_ZNK5clang17InitializedEntity18getCapturedVarNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity18getCapturedVarNameEv")
  //</editor-fold>
  public StringRef getCapturedVarName() /*const*/ {
    assert (getKind() == EntityKind.EK_LambdaCapture) : "Not a lambda capture!";
    return Unnamed_field4.Capture.VarID.getName();
  }

  /// \brief Determine the location of the capture when initializing
  /// field from a captured variable in a lambda.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::getCaptureLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 426,
   FQN="clang::InitializedEntity::getCaptureLoc", NM="_ZNK5clang17InitializedEntity13getCaptureLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity13getCaptureLocEv")
  //</editor-fold>
  public SourceLocation getCaptureLoc() /*const*/ {
    assert (getKind() == EntityKind.EK_LambdaCapture) : "Not a lambda capture!";
    return SourceLocation.getFromRawEncoding(Unnamed_field4.Capture.Location);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::setParameterCFAudited">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 431,
   FQN="clang::InitializedEntity::setParameterCFAudited", NM="_ZN5clang17InitializedEntity21setParameterCFAuditedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntity21setParameterCFAuditedEv")
  //</editor-fold>
  public void setParameterCFAudited() {
    Kind = EntityKind.EK_Parameter_CF_Audited;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::allocateManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 435,
   FQN="clang::InitializedEntity::allocateManglingNumber", NM="_ZNK5clang17InitializedEntity22allocateManglingNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity22allocateManglingNumberEv")
  //</editor-fold>
  public /*uint*/int allocateManglingNumber() /*const*/ {
    return ++ManglingNumber;
  }

  
  /// Dump a representation of the initialized entity to standard error,
  /// for debugging purposes.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3018,
   FQN="clang::InitializedEntity::dump", NM="_ZNK5clang17InitializedEntity4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dumpImpl(llvm.errs());
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::dumpImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 2978,
   FQN="clang::InitializedEntity::dumpImpl", NM="_ZNK5clang17InitializedEntity8dumpImplERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang17InitializedEntity8dumpImplERN4llvm11raw_ostreamE")
  //</editor-fold>
  private /*uint*/int dumpImpl(final raw_ostream /*&*/ OS) /*const*/ {
    assert (getParent() != this);
    /*uint*/int Depth = (getParent() != null) ? getParent().dumpImpl(OS) : 0;
    for (/*uint*/int I = 0; I != Depth; ++I)  {
      OS.$out(/*KEEP_STR*/"`-");
    }
    switch (getKind()) {
     case EK_Variable:
      OS.$out(/*KEEP_STR*/"Variable");
      break;
     case EK_Parameter:
      OS.$out(/*KEEP_STR*/"Parameter");
      break;
     case EK_Parameter_CF_Audited:
      OS.$out(/*KEEP_STR*/"CF audited function Parameter");
      break;
     case EK_Result:
      OS.$out(/*KEEP_STR*/"Result");
      break;
     case EK_Exception:
      OS.$out(/*KEEP_STR*/"Exception");
      break;
     case EK_Member:
      OS.$out(/*KEEP_STR*/"Member");
      break;
     case EK_New:
      OS.$out(/*KEEP_STR*/"New");
      break;
     case EK_Temporary:
      OS.$out(/*KEEP_STR*/"Temporary");
      break;
     case EK_CompoundLiteralInit:
      OS.$out(/*KEEP_STR*/"CompoundLiteral");
      break;
     case EK_RelatedResult:
      OS.$out(/*KEEP_STR*/"RelatedResult");
      break;
     case EK_Base:
      OS.$out(/*KEEP_STR*/"Base");
      break;
     case EK_Delegating:
      OS.$out(/*KEEP_STR*/"Delegating");
      break;
     case EK_ArrayElement:
      OS.$out(/*KEEP_STR*/"ArrayElement ").$out_uint(Unnamed_field4.Index);
      break;
     case EK_VectorElement:
      OS.$out(/*KEEP_STR*/"VectorElement ").$out_uint(Unnamed_field4.Index);
      break;
     case EK_ComplexElement:
      OS.$out(/*KEEP_STR*/"ComplexElement ").$out_uint(Unnamed_field4.Index);
      break;
     case EK_BlockElement:
      OS.$out(/*KEEP_STR*/"Block");
      break;
     case EK_LambdaCapture:
      OS.$out(/*KEEP_STR*/"LambdaCapture ");
      $out_raw_ostream_DeclarationName(OS, new DeclarationName(Unnamed_field4.Capture.VarID));
      break;
    }
    {
      
      Decl /*P*/ D = getDecl();
      if ((D != null)) {
        OS.$out(/*KEEP_STR*/$SPACE);
        cast_NamedDecl(D).printQualifiedName(OS);
      }
    }
    
    OS.$out(/*KEEP_STR*/" '").$out(getType().getAsString()).$out(/*KEEP_STR*/"'\n");
    
    return Depth + 1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializedEntity">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 41,
   FQN="clang::InitializedEntity::InitializedEntity", NM="_ZN5clang17InitializedEntityC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntityC1ERKS0_")
  //</editor-fold>
  public /*inline*/ InitializedEntity(final /*const*/ InitializedEntity /*&*/ $Prm0) {
    // : Kind(.Kind), Parent(.Parent), Type(.Type), ManglingNumber(.ManglingNumber), Unnamed_field4(.) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Parent = $Prm0.Parent;
    this.Type = new QualType($Prm0.Type);
    this.ManglingNumber = $Prm0.ManglingNumber;
    // JAVA: to keep final field
    this.Unnamed_field4.$assign($Prm0.Unnamed_field4);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::InitializedEntity">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 41,
   FQN="clang::InitializedEntity::InitializedEntity", NM="_ZN5clang17InitializedEntityC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntityC1EOS0_")
  //</editor-fold>
  public /*inline*/ InitializedEntity(JD$Move _dparam, final InitializedEntity /*&&*/$Prm0) {
    // : Kind(static_cast<InitializedEntity &&>().Kind), Parent(static_cast<InitializedEntity &&>().Parent), Type(static_cast<InitializedEntity &&>().Type), ManglingNumber(static_cast<InitializedEntity &&>().ManglingNumber), Unnamed_field4(static_cast<InitializedEntity &&>().) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Parent = $Prm0.Parent;
    this.Type = new QualType(JD$Move.INSTANCE, $Prm0.Type);
    this.ManglingNumber = $Prm0.ManglingNumber;
    // JAVA: to keep final field
    this.Unnamed_field4.$assignMove($Prm0.Unnamed_field4);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitializedEntity::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 41,
   FQN="clang::InitializedEntity::operator=", NM="_ZN5clang17InitializedEntityaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang17InitializedEntityaSEOS0_")
  //</editor-fold>
  public /*inline*/ InitializedEntity /*&*/ $assignMove(final InitializedEntity /*&&*/$Prm0) {
    this.Kind = $Prm0.Kind;
    this.Parent = $Prm0.Parent;
    this.Type.$assignMove($Prm0.Type);
    this.ManglingNumber = $Prm0.ManglingNumber;
    this.Unnamed_field4.$assignMove($Prm0.Unnamed_field4);
    return /*Deref*/this;
  }
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public InitializedEntity $assign(final InitializedEntity $Prm0) {
    this.Kind = $Prm0.Kind;
    this.Parent = $Prm0.Parent;
    this.Type.$assign($Prm0.Type);
    this.ManglingNumber = $Prm0.ManglingNumber;
    this.Unnamed_field4.$assign($Prm0.Unnamed_field4);
    return /*Deref*/this;
  }

  @Override public InitializedEntity clone() { return new InitializedEntity(this); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Parent=" + Parent // NOI18N
              + ", Type=" + Type // NOI18N
              + ", ManglingNumber=" + ManglingNumber // NOI18N
              + ", Unnamed_field4=" + Unnamed_field4; // NOI18N
  }
}
