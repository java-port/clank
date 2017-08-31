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

import org.clank.support.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// \brief Represents a C++ unqualified-id that has been parsed. 
//<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 884,
 FQN="clang::UnqualifiedId", NM="_ZN5clang13UnqualifiedIdE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedIdE")
//</editor-fold>
public class UnqualifiedId {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::UnqualifiedId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 886,
   FQN="clang::UnqualifiedId::UnqualifiedId", NM="_ZN5clang13UnqualifiedIdC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedIdC1ERKS0_")
  //</editor-fold>
  private UnqualifiedId(final /*const*/ UnqualifiedId /*&*/ Other) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 887,
   FQN="clang::UnqualifiedId::operator=", NM="_ZN5clang13UnqualifiedIdaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedIdaSERKS0_")
  //</editor-fold>
  private /*const*/ UnqualifiedId /*&*/ $assign(final /*const*/ UnqualifiedId /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  /// \brief Describes the kind of unqualified-id parsed.
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::IdKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 891,
   FQN="clang::UnqualifiedId::IdKind", NM="_ZN5clang13UnqualifiedId6IdKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedId6IdKindE")
  //</editor-fold>
  public enum IdKind implements Native.ComparableLower {
    /// \brief An identifier.
    IK_Identifier(0),
    /// \brief An overloaded operator name, e.g., operator+.
    IK_OperatorFunctionId(IK_Identifier.getValue() + 1),
    /// \brief A conversion function name, e.g., operator int.
    IK_ConversionFunctionId(IK_OperatorFunctionId.getValue() + 1),
    /// \brief A user-defined literal name, e.g., operator "" _i.
    IK_LiteralOperatorId(IK_ConversionFunctionId.getValue() + 1),
    /// \brief A constructor name.
    IK_ConstructorName(IK_LiteralOperatorId.getValue() + 1),
    /// \brief A constructor named via a template-id.
    IK_ConstructorTemplateId(IK_ConstructorName.getValue() + 1),
    /// \brief A destructor name.
    IK_DestructorName(IK_ConstructorTemplateId.getValue() + 1),
    /// \brief A template-id, e.g., f<int>.
    IK_TemplateId(IK_DestructorName.getValue() + 1),
    /// \brief An implicit 'self' parameter
    IK_ImplicitSelfParam(IK_TemplateId.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static IdKind valueOf(int val) {
      IdKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final IdKind[] VALUES;
      private static final IdKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (IdKind kind : IdKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new IdKind[min < 0 ? (1-min) : 0];
        VALUES = new IdKind[max >= 0 ? (1+max) : 0];
        for (IdKind kind : IdKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private IdKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((IdKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((IdKind)obj).value);}
    //</editor-fold>
  };
  public  IdKind Kind;
  
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::OFI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 912,
   FQN="clang::UnqualifiedId::OFI", NM="_ZN5clang13UnqualifiedId3OFIE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedId3OFIE")
  //</editor-fold>
  public static class/*struct*/ OFI {
    /// \brief The kind of overloaded operator.
    public OverloadedOperatorKind Operator;
    
    /// \brief The source locations of the individual tokens that name
    /// the operator, e.g., the "new", "[", and "]" tokens in 
    /// operator new []. 
    ///
    /// Different operators have different numbers of tokens in their name,
    /// up to three. Any remaining source locations in this array will be
    /// set to an invalid value for operators with fewer than three tokens.
    public /*uint*/int SymbolLocations[/*3*/] = new /*uint*/int [3];
    
    @Override public String toString() {
      return "" + "Operator=" + Operator // NOI18N
                + ", SymbolLocations=" + SymbolLocations; // NOI18N
    }
  };
  
  /// \brief Anonymous union that holds extra data associated with the
  /// parsed unqualified-id.
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*init fields*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 928,
   FQN="clang::UnqualifiedId::(anonymous)", NM="_ZN5clang13UnqualifiedIdE_Unnamed_union2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedIdE_Unnamed_union2")
  //</editor-fold>
  public static class/*union*/ Unnamed_union2 {
    /// \brief When Kind == IK_Identifier, the parsed identifier, or when Kind
    /// == IK_UserLiteralId, the identifier suffix.
    public IdentifierInfo /*P*/ Identifier;
    
    /// \brief When Kind == IK_OperatorFunctionId, the overloaded operator
    /// that we parsed.
    public final OFI OperatorFunctionId = new OFI();
    
    /// \brief When Kind == IK_ConversionFunctionId, the type that the 
    /// conversion function names.
    public final UnionOpaquePtr<QualType> ConversionFunctionId = new UnionOpaquePtr<QualType>();
    
    /// \brief When Kind == IK_ConstructorName, the class-name of the type
    /// whose constructor is being referenced.
    public final UnionOpaquePtr<QualType> ConstructorName = new UnionOpaquePtr<QualType>();
    
    /// \brief When Kind == IK_DestructorName, the type referred to by the
    /// class-name.
    public final UnionOpaquePtr<QualType> DestructorName = new UnionOpaquePtr<QualType>();
    
    /// \brief When Kind == IK_TemplateId or IK_ConstructorTemplateId,
    /// the template-id annotation that contains the template name and
    /// template arguments.
    public TemplateIdAnnotation /*P*/ TemplateId;
    
    @Override public String toString() {
      return "" + "Identifier=" + Identifier // NOI18N
                + ", OperatorFunctionId=" + OperatorFunctionId // NOI18N
                + ", ConversionFunctionId=" + ConversionFunctionId // NOI18N
                + ", ConstructorName=" + ConstructorName // NOI18N
                + ", DestructorName=" + DestructorName // NOI18N
                + ", TemplateId=" + TemplateId; // NOI18N
    }
  };
  public final Unnamed_union2 Unnamed_field1 = new Unnamed_union2();
  
  /// \brief The location of the first token that describes this unqualified-id,
  /// which will be the location of the identifier, "operator" keyword,
  /// tilde (for a destructor), or the template name of a template-id.
  public SourceLocation StartLocation;
  
  /// \brief The location of the last token that describes this unqualified-id.
  public SourceLocation EndLocation;
  
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::UnqualifiedId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 963,
   FQN="clang::UnqualifiedId::UnqualifiedId", NM="_ZN5clang13UnqualifiedIdC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedIdC1Ev")
  //</editor-fold>
  public UnqualifiedId() {
    // : Kind(IK_Identifier), Identifier(null), StartLocation(), EndLocation() 
    //START JInit
    this.Kind = IdKind.IK_Identifier;
    /*Indirect*/Unnamed_field1.Identifier = null;
    this.StartLocation = new SourceLocation();
    this.EndLocation = new SourceLocation();
    //END JInit
  }

  
  /// \brief Clear out this unqualified-id, setting it to default (invalid) 
  /// state.
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 967,
   FQN="clang::UnqualifiedId::clear", NM="_ZN5clang13UnqualifiedId5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedId5clearEv")
  //</editor-fold>
  public void clear() {
    Kind = IdKind.IK_Identifier;
    Unnamed_field1.Identifier = null;
    StartLocation.$assignMove(new SourceLocation());
    EndLocation.$assignMove(new SourceLocation());
  }

  
  /// \brief Determine whether this unqualified-id refers to a valid name.
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 975,
   FQN="clang::UnqualifiedId::isValid", NM="_ZNK5clang13UnqualifiedId7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang13UnqualifiedId7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return StartLocation.isValid();
  }

  
  /// \brief Determine whether this unqualified-id refers to an invalid name.
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::isInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 978,
   FQN="clang::UnqualifiedId::isInvalid", NM="_ZNK5clang13UnqualifiedId9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang13UnqualifiedId9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*/ {
    return !isValid();
  }

  
  /// \brief Determine what kind of name we have.
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 981,
   FQN="clang::UnqualifiedId::getKind", NM="_ZNK5clang13UnqualifiedId7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang13UnqualifiedId7getKindEv")
  //</editor-fold>
  public IdKind getKind() /*const*/ {
    return Kind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::setKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 982,
   FQN="clang::UnqualifiedId::setKind", NM="_ZN5clang13UnqualifiedId7setKindENS0_6IdKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedId7setKindENS0_6IdKindE")
  //</editor-fold>
  public void setKind(IdKind kind) {
    Kind = kind;
  }

  
  /// \brief Specify that this unqualified-id was parsed as an identifier.
  ///
  /// \param Id the parsed identifier.
  /// \param IdLoc the location of the parsed identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::setIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 988,
   FQN="clang::UnqualifiedId::setIdentifier", NM="_ZN5clang13UnqualifiedId13setIdentifierEPKNS_14IdentifierInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedId13setIdentifierEPKNS_14IdentifierInfoENS_14SourceLocationE")
  //</editor-fold>
  public void setIdentifier(/*const*/ IdentifierInfo /*P*/ Id, SourceLocation IdLoc) {
    Kind = IdKind.IK_Identifier;
    Unnamed_field1.Identifier = ((/*const_cast*/IdentifierInfo /*P*/ )(Id));
    StartLocation.$assign(EndLocation.$assign(IdLoc));
  }

  
  /// \brief Specify that this unqualified-id was parsed as an 
  /// operator-function-id.
  ///
  /// \param OperatorLoc the location of the 'operator' keyword.
  ///
  /// \param Op the overloaded operator.
  ///
  /// \param SymbolLocations the locations of the individual operator symbols
  /// in the operator.
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::setOperatorFunctionId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 1238,
   FQN="clang::UnqualifiedId::setOperatorFunctionId", NM="_ZN5clang13UnqualifiedId21setOperatorFunctionIdENS_14SourceLocationENS_22OverloadedOperatorKindEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedId21setOperatorFunctionIdENS_14SourceLocationENS_22OverloadedOperatorKindEPS1_")
  //</editor-fold>
  public void setOperatorFunctionId(SourceLocation OperatorLoc, 
                       OverloadedOperatorKind Op, 
                       SourceLocation SymbolLocations[/*3*/]) {
    Kind = IdKind.IK_OperatorFunctionId;
    StartLocation.$assign(OperatorLoc);
    EndLocation.$assign(OperatorLoc);
    Unnamed_field1.OperatorFunctionId.Operator = Op;
    for (/*uint*/int I = 0; I != 3; ++I) {
      Unnamed_field1.OperatorFunctionId.SymbolLocations[I] = SymbolLocations[I].getRawEncoding();
      if (SymbolLocations[I].isValid()) {
        EndLocation.$assign(SymbolLocations[I]);
      }
    }
  }

  
  /// \brief Specify that this unqualified-id was parsed as a 
  /// conversion-function-id.
  ///
  /// \param OperatorLoc the location of the 'operator' keyword.
  ///
  /// \param Ty the type to which this conversion function is converting.
  ///
  /// \param EndLoc the location of the last token that makes up the type name.
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::setConversionFunctionId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1015,
   FQN="clang::UnqualifiedId::setConversionFunctionId", NM="_ZN5clang13UnqualifiedId23setConversionFunctionIdENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedId23setConversionFunctionIdENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEES1_")
  //</editor-fold>
  public void setConversionFunctionId(SourceLocation OperatorLoc, 
                         OpaquePtr<QualType> Ty, 
                         SourceLocation EndLoc) {
    Kind = IdKind.IK_ConversionFunctionId;
    StartLocation.$assign(OperatorLoc);
    EndLocation.$assign(EndLoc);
    Unnamed_field1.ConversionFunctionId.$assign(/*NO_COPY*/Ty);
  }

  
  /// \brief Specific that this unqualified-id was parsed as a
  /// literal-operator-id.
  ///
  /// \param Id the parsed identifier.
  ///
  /// \param OpLoc the location of the 'operator' keyword.
  ///
  /// \param IdLoc the location of the identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::setLiteralOperatorId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1032,
   FQN="clang::UnqualifiedId::setLiteralOperatorId", NM="_ZN5clang13UnqualifiedId20setLiteralOperatorIdEPKNS_14IdentifierInfoENS_14SourceLocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedId20setLiteralOperatorIdEPKNS_14IdentifierInfoENS_14SourceLocationES4_")
  //</editor-fold>
  public void setLiteralOperatorId(/*const*/ IdentifierInfo /*P*/ Id, SourceLocation OpLoc, 
                      SourceLocation IdLoc) {
    Kind = IdKind.IK_LiteralOperatorId;
    Unnamed_field1.Identifier = ((/*const_cast*/IdentifierInfo /*P*/ )(Id));
    StartLocation.$assign(OpLoc);
    EndLocation.$assign(IdLoc);
  }

  
  /// \brief Specify that this unqualified-id was parsed as a constructor name.
  ///
  /// \param ClassType the class type referred to by the constructor name.
  ///
  /// \param ClassNameLoc the location of the class name.
  ///
  /// \param EndLoc the location of the last token that makes up the type name.
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::setConstructorName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1047,
   FQN="clang::UnqualifiedId::setConstructorName", NM="_ZN5clang13UnqualifiedId18setConstructorNameENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedId18setConstructorNameENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationES4_")
  //</editor-fold>
  public void setConstructorName(OpaquePtr<QualType> ClassType, 
                    SourceLocation ClassNameLoc, 
                    SourceLocation EndLoc) {
    Kind = IdKind.IK_ConstructorName;
    StartLocation.$assign(ClassNameLoc);
    EndLocation.$assign(EndLoc);
    Unnamed_field1.ConstructorName.$assign(/*NO_COPY*/ClassType);
  }

  
  /// \brief Specify that this unqualified-id was parsed as a
  /// template-id that names a constructor.
  ///
  /// \param TemplateId the template-id annotation that describes the parsed
  /// template-id. This UnqualifiedId instance will take ownership of the
  /// \p TemplateId and will free it on destruction.
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::setConstructorTemplateId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 39,
   FQN="clang::UnqualifiedId::setConstructorTemplateId", NM="_ZN5clang13UnqualifiedId24setConstructorTemplateIdEPNS_20TemplateIdAnnotationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedId24setConstructorTemplateIdEPNS_20TemplateIdAnnotationE")
  //</editor-fold>
  public void setConstructorTemplateId(TemplateIdAnnotation /*P*/ TemplateId) {
    assert ((TemplateId != null)) : "NULL template-id annotation?";
    Kind = IdKind.IK_ConstructorTemplateId;
    this.Unnamed_field1.TemplateId = TemplateId;
    StartLocation.$assign(TemplateId.TemplateNameLoc);
    EndLocation.$assign(TemplateId.RAngleLoc);
  }

  
  /// \brief Specify that this unqualified-id was parsed as a destructor name.
  ///
  /// \param TildeLoc the location of the '~' that introduces the destructor
  /// name.
  ///
  /// \param ClassType the name of the class referred to by the destructor name.
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::setDestructorName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1070,
   FQN="clang::UnqualifiedId::setDestructorName", NM="_ZN5clang13UnqualifiedId17setDestructorNameENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedId17setDestructorNameENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEES1_")
  //</editor-fold>
  public void setDestructorName(SourceLocation TildeLoc, 
                   OpaquePtr<QualType> ClassType, 
                   SourceLocation EndLoc) {
    Kind = IdKind.IK_DestructorName;
    StartLocation.$assign(TildeLoc);
    EndLocation.$assign(EndLoc);
    Unnamed_field1.DestructorName.$assign(/*NO_COPY*/ClassType);
  }

  
  /// \brief Specify that this unqualified-id was parsed as a template-id.
  ///
  /// \param TemplateId the template-id annotation that describes the parsed
  /// template-id. This UnqualifiedId instance will take ownership of the
  /// \p TemplateId and will free it on destruction.
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::setTemplateId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 31,
   FQN="clang::UnqualifiedId::setTemplateId", NM="_ZN5clang13UnqualifiedId13setTemplateIdEPNS_20TemplateIdAnnotationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang13UnqualifiedId13setTemplateIdEPNS_20TemplateIdAnnotationE")
  //</editor-fold>
  public void setTemplateId(TemplateIdAnnotation /*P*/ TemplateId) {
    assert ((TemplateId != null)) : "NULL template-id annotation?";
    Kind = IdKind.IK_TemplateId;
    this.Unnamed_field1.TemplateId = TemplateId;
    StartLocation.$assign(TemplateId.TemplateNameLoc);
    EndLocation.$assign(TemplateId.RAngleLoc);
  }

  
  /// \brief Return the source range that covers this unqualified-id.
  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1087,
   FQN="clang::UnqualifiedId::getSourceRange", NM="_ZNK5clang13UnqualifiedId14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang13UnqualifiedId14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(/*NO_COPY*/StartLocation, /*NO_COPY*/EndLocation);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1090,
   FQN="clang::UnqualifiedId::getLocStart", NM="_ZNK5clang13UnqualifiedId11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang13UnqualifiedId11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(StartLocation);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnqualifiedId::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 1091,
   FQN="clang::UnqualifiedId::getLocEnd", NM="_ZNK5clang13UnqualifiedId9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang13UnqualifiedId9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(EndLocation);
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Unnamed_field1=" + Unnamed_field1 // NOI18N
              + ", StartLocation=" + StartLocation // NOI18N
              + ", EndLocation=" + EndLocation; // NOI18N
  }
}
