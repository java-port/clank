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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.Qualifiers.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.impl.SemaInitStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


/// \brief Describes the sequence of initializations required to initialize
/// a given object or reference with a set of arguments.
//<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 621,
 FQN="clang::InitializationSequence", NM="_ZN5clang22InitializationSequenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequenceE")
//</editor-fold>
public class InitializationSequence implements Destructors.ClassWithDestructor, Native.Native$Bool {
/*public:*/
  /// \brief Describes the kind of initialization sequence computed.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::SequenceKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 624,
   FQN="clang::InitializationSequence::SequenceKind", NM="_ZN5clang22InitializationSequence12SequenceKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence12SequenceKindE")
  //</editor-fold>
  public enum SequenceKind implements Native.ComparableLower {
    /// \brief A failed initialization sequence. The failure kind tells what
    /// happened.
    FailedSequence(0),
    
    /// \brief A dependent initialization, which could not be
    /// type-checked due to the presence of dependent types or
    /// dependently-typed expressions.
    DependentSequence(FailedSequence.getValue() + 1),
    
    /// \brief A normal sequence.
    NormalSequence(DependentSequence.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SequenceKind valueOf(int val) {
      SequenceKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SequenceKind[] VALUES;
      private static final SequenceKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SequenceKind kind : SequenceKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SequenceKind[min < 0 ? (1-min) : 0];
        VALUES = new SequenceKind[max >= 0 ? (1+max) : 0];
        for (SequenceKind kind : SequenceKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private SequenceKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((SequenceKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((SequenceKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Describes the kind of a particular step in an initialization
  /// sequence.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::StepKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 640,
   FQN="clang::InitializationSequence::StepKind", NM="_ZN5clang22InitializationSequence8StepKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence8StepKindE")
  //</editor-fold>
  public enum StepKind implements Native.ComparableLower {
    /// \brief Resolve the address of an overloaded function to a specific
    /// function declaration.
    SK_ResolveAddressOfOverloadedFunction(0),
    /// \brief Perform a derived-to-base cast, producing an rvalue.
    SK_CastDerivedToBaseRValue(SK_ResolveAddressOfOverloadedFunction.getValue() + 1),
    /// \brief Perform a derived-to-base cast, producing an xvalue.
    SK_CastDerivedToBaseXValue(SK_CastDerivedToBaseRValue.getValue() + 1),
    /// \brief Perform a derived-to-base cast, producing an lvalue.
    SK_CastDerivedToBaseLValue(SK_CastDerivedToBaseXValue.getValue() + 1),
    /// \brief Reference binding to an lvalue.
    SK_BindReference(SK_CastDerivedToBaseLValue.getValue() + 1),
    /// \brief Reference binding to a temporary.
    SK_BindReferenceToTemporary(SK_BindReference.getValue() + 1),
    /// \brief An optional copy of a temporary object to another
    /// temporary object, which is permitted (but not required) by
    /// C++98/03 but not C++0x.
    SK_ExtraneousCopyToTemporary(SK_BindReferenceToTemporary.getValue() + 1),
    /// \brief Perform a user-defined conversion, either via a conversion
    /// function or via a constructor.
    SK_UserConversion(SK_ExtraneousCopyToTemporary.getValue() + 1),
    /// \brief Perform a qualification conversion, producing an rvalue.
    SK_QualificationConversionRValue(SK_UserConversion.getValue() + 1),
    /// \brief Perform a qualification conversion, producing an xvalue.
    SK_QualificationConversionXValue(SK_QualificationConversionRValue.getValue() + 1),
    /// \brief Perform a qualification conversion, producing an lvalue.
    SK_QualificationConversionLValue(SK_QualificationConversionXValue.getValue() + 1),
    /// \brief Perform a conversion adding _Atomic to a type.
    SK_AtomicConversion(SK_QualificationConversionLValue.getValue() + 1),
    /// \brief Perform a load from a glvalue, producing an rvalue.
    SK_LValueToRValue(SK_AtomicConversion.getValue() + 1),
    /// \brief Perform an implicit conversion sequence.
    SK_ConversionSequence(SK_LValueToRValue.getValue() + 1),
    /// \brief Perform an implicit conversion sequence without narrowing.
    SK_ConversionSequenceNoNarrowing(SK_ConversionSequence.getValue() + 1),
    /// \brief Perform list-initialization without a constructor.
    SK_ListInitialization(SK_ConversionSequenceNoNarrowing.getValue() + 1),
    /// \brief Unwrap the single-element initializer list for a reference.
    SK_UnwrapInitList(SK_ListInitialization.getValue() + 1),
    /// \brief Rewrap the single-element initializer list for a reference.
    SK_RewrapInitList(SK_UnwrapInitList.getValue() + 1),
    /// \brief Perform initialization via a constructor.
    SK_ConstructorInitialization(SK_RewrapInitList.getValue() + 1),
    /// \brief Perform initialization via a constructor, taking arguments from
    /// a single InitListExpr.
    SK_ConstructorInitializationFromList(SK_ConstructorInitialization.getValue() + 1),
    /// \brief Zero-initialize the object
    SK_ZeroInitialization(SK_ConstructorInitializationFromList.getValue() + 1),
    /// \brief C assignment
    SK_CAssignment(SK_ZeroInitialization.getValue() + 1),
    /// \brief Initialization by string
    SK_StringInit(SK_CAssignment.getValue() + 1),
    /// \brief An initialization that "converts" an Objective-C object
    /// (not a point to an object) to another Objective-C object type.
    SK_ObjCObjectConversion(SK_StringInit.getValue() + 1),
    /// \brief Array initialization (from an array rvalue).
    /// This is a GNU C extension.
    SK_ArrayInit(SK_ObjCObjectConversion.getValue() + 1),
    /// \brief Array initialization from a parenthesized initializer list.
    /// This is a GNU C++ extension.
    SK_ParenthesizedArrayInit(SK_ArrayInit.getValue() + 1),
    /// \brief Pass an object by indirect copy-and-restore.
    SK_PassByIndirectCopyRestore(SK_ParenthesizedArrayInit.getValue() + 1),
    /// \brief Pass an object by indirect restore.
    SK_PassByIndirectRestore(SK_PassByIndirectCopyRestore.getValue() + 1),
    /// \brief Produce an Objective-C object pointer.
    SK_ProduceObjCObject(SK_PassByIndirectRestore.getValue() + 1),
    /// \brief Construct a std::initializer_list from an initializer list.
    SK_StdInitializerList(SK_ProduceObjCObject.getValue() + 1),
    /// \brief Perform initialization via a constructor taking a single
    /// std::initializer_list argument.
    SK_StdInitializerListConstructorCall(SK_StdInitializerList.getValue() + 1),
    /// \brief Initialize an OpenCL sampler from an integer.
    SK_OCLSamplerInit(SK_StdInitializerListConstructorCall.getValue() + 1),
    /// \brief Passing zero to a function where OpenCL event_t is expected.
    SK_OCLZeroEvent(SK_OCLSamplerInit.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static StepKind valueOf(int val) {
      StepKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final StepKind[] VALUES;
      private static final StepKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (StepKind kind : StepKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new StepKind[min < 0 ? (1-min) : 0];
        VALUES = new StepKind[max >= 0 ? (1+max) : 0];
        for (StepKind kind : StepKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private StepKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((StepKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((StepKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief A single step in the initialization sequence.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Step">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 719,
   FQN="clang::InitializationSequence::Step", NM="_ZN5clang22InitializationSequence4StepE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence4StepE")
  //</editor-fold>
  public static class Step implements NativePOD<Step> {
  /*public:*/
    /// \brief The kind of conversion or initialization step we are taking.
    public StepKind Kind;
    
    // \brief The type that results from this initialization.
    public QualType Type;
    
    //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Step::F">
    @Converted(kind = Converted.Kind.MANUAL/*init fields*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 727,
     FQN="clang::InitializationSequence::Step::F", NM="_ZN5clang22InitializationSequence4Step1FE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence4Step1FE")
    //</editor-fold>
    public static class/*struct*/ F {
      public boolean HadMultipleCandidates;
      public FunctionDecl /*P*/ Function;
      public DeclAccessPair FoundDecl = new DeclAccessPair();
      //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Step::F::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 727,
       FQN="clang::InitializationSequence::Step::F::operator=", NM="_ZN5clang22InitializationSequence4Step1FaSERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence4Step1FaSERKS2_")
      //</editor-fold>
      public /*inline*/ F /*&*/ $assign(final /*const*/ F /*&*/ $Prm0) {
        this.HadMultipleCandidates = $Prm0.HadMultipleCandidates;
        this.Function = $Prm0.Function;
        this.FoundDecl.$assign($Prm0.FoundDecl);
        return /*Deref*/this;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Step::F::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 727,
       FQN="clang::InitializationSequence::Step::F::operator=", NM="_ZN5clang22InitializationSequence4Step1FaSEOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence4Step1FaSEOS2_")
      //</editor-fold>
      public /*inline*/ F /*&*/ $assignMove(final F /*&&*/$Prm0) {
        this.HadMultipleCandidates = $Prm0.HadMultipleCandidates;
        this.Function = $Prm0.Function;
        this.FoundDecl.$assignMove($Prm0.FoundDecl);
        return /*Deref*/this;
      }

      
      @Override public String toString() {
        return "" + "HadMultipleCandidates=" + HadMultipleCandidates // NOI18N
                  + ", Function=" + Function // NOI18N
                  + ", FoundDecl=" + FoundDecl; // NOI18N
      }
    };
    //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Step::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 733,
     FQN="clang::InitializationSequence::Step::(anonymous)", NM="_ZN5clang22InitializationSequence4StepE_Unnamed_union2",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence4StepE_Unnamed_union2")
    //</editor-fold>
    public static class/*union*/ Unnamed_union2 {
      /// \brief When Kind == SK_ResolvedOverloadedFunction or Kind ==
      /// SK_UserConversion, the function that the expression should be 
      /// resolved to or the conversion function to call, respectively.
      /// When Kind == SK_ConstructorInitialization or SK_ListConstruction,
      /// the constructor to be called.
      ///
      /// Always a FunctionDecl, plus a Boolean flag telling if it was
      /// selected from an overloaded set having size greater than 1.
      /// For conversion decls, the naming class is the source type.
      /// For construct decls, the naming class is the target type.
      public  F Function;
      
      /// \brief When Kind = SK_ConversionSequence, the implicit conversion
      /// sequence.
      public ImplicitConversionSequence /*P*/ ICS;
      
      /// \brief When Kind = SK_RewrapInitList, the syntactic form of the
      /// wrapping list.
      public InitListExpr /*P*/ WrappingSyntacticList;
      
      //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Step::(anonymous union)::">
      @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assign fields*/,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 733,
       FQN="clang::InitializationSequence::Step::(anonymous union)::", NM="_ZN5clang22InitializationSequence4StepUt_C1EOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence4StepUt_C1EOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union2(JD$Move _dparam, final Unnamed_union2 $Prm0) {
        $assignMove($Prm0);
      }

      
      //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Step::(anonymous union)::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 733,
       FQN="clang::InitializationSequence::Step::(anonymous union)::operator=", NM="_ZN5clang22InitializationSequence4StepUt_aSERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence4StepUt_aSERKS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union2 $assign(final Unnamed_union2 $Prm0) {
        
        this.Function.$assign($Prm0.Function);
        
        this.ICS = $Prm0.ICS;
        
        this.WrappingSyntacticList = $Prm0.WrappingSyntacticList;
        
        return /*Deref*/this;
      }

      
      //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Step::(anonymous union)::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 733,
       FQN="clang::InitializationSequence::Step::(anonymous union)::operator=", NM="_ZN5clang22InitializationSequence4StepUt_aSEOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence4StepUt_aSEOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union2 $assignMove(final Unnamed_union2 $Prm0) {
        
        this.Function.$assignMove($Prm0.Function);
        
        this.ICS = $Prm0.ICS;
        
        this.WrappingSyntacticList = $Prm0.WrappingSyntacticList;
        
        return /*Deref*/this;
      }

      protected Unnamed_union2() {
        this.Function = new Step.F();
      }
      
      @Override public String toString() {
        return "" + "Function=" + Function // NOI18N
                  + ", ICS=" + ICS // NOI18N
                  + ", WrappingSyntacticList=" + WrappingSyntacticList; // NOI18N
      }
    };
    public Unnamed_union2 Unnamed_field2 = new Unnamed_union2();
    
    
    //===----------------------------------------------------------------------===//
    // Initialization sequence
    //===----------------------------------------------------------------------===//
    //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Step::Destroy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3026,
     FQN="clang::InitializationSequence::Step::Destroy", NM="_ZN5clang22InitializationSequence4Step7DestroyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence4Step7DestroyEv")
    //</editor-fold>
    public void Destroy() {
      switch (Kind) {
       case SK_ResolveAddressOfOverloadedFunction:
       case SK_CastDerivedToBaseRValue:
       case SK_CastDerivedToBaseXValue:
       case SK_CastDerivedToBaseLValue:
       case SK_BindReference:
       case SK_BindReferenceToTemporary:
       case SK_ExtraneousCopyToTemporary:
       case SK_UserConversion:
       case SK_QualificationConversionRValue:
       case SK_QualificationConversionXValue:
       case SK_QualificationConversionLValue:
       case SK_AtomicConversion:
       case SK_LValueToRValue:
       case SK_ListInitialization:
       case SK_UnwrapInitList:
       case SK_RewrapInitList:
       case SK_ConstructorInitialization:
       case SK_ConstructorInitializationFromList:
       case SK_ZeroInitialization:
       case SK_CAssignment:
       case SK_StringInit:
       case SK_ObjCObjectConversion:
       case SK_ArrayInit:
       case SK_ParenthesizedArrayInit:
       case SK_PassByIndirectCopyRestore:
       case SK_PassByIndirectRestore:
       case SK_ProduceObjCObject:
       case SK_StdInitializerList:
       case SK_StdInitializerListConstructorCall:
       case SK_OCLSamplerInit:
       case SK_OCLZeroEvent:
        break;
       case SK_ConversionSequence:
       case SK_ConversionSequenceNoNarrowing:
        if (Unnamed_field2.ICS != null) { Unnamed_field2.ICS.$destroy();};
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Step::Step">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 719,
     FQN="clang::InitializationSequence::Step::Step", NM="_ZN5clang22InitializationSequence4StepC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence4StepC1Ev")
    //</editor-fold>
    public /*inline*/ Step() {
      // : Type() 
      //START JInit
      this.Type = new QualType();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Step::Step">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 719,
     FQN="clang::InitializationSequence::Step::Step", NM="_ZN5clang22InitializationSequence4StepC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence4StepC1EOS1_")
    //</editor-fold>
    public /*inline*/ Step(JD$Move _dparam, final Step /*&&*/$Prm0) {
      // : Kind(static_cast<Step &&>().Kind), Type(static_cast<Step &&>().Type), Unnamed_field2(static_cast<Step &&>().) 
      //START JInit
      this.Kind = $Prm0.Kind;
      this.Type = new QualType(JD$Move.INSTANCE, $Prm0.Type);
      this.Unnamed_field2 = new Unnamed_union2(JD$Move.INSTANCE, $Prm0.Unnamed_field2);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Step::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 719,
     FQN="clang::InitializationSequence::Step::operator=", NM="_ZN5clang22InitializationSequence4StepaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence4StepaSERKS1_")
    //</editor-fold>
    public /*inline*/ Step /*&*/ $assign(final /*const*/ Step /*&*/ $Prm0) {
      this.Kind = $Prm0.Kind;
      this.Type.$assign($Prm0.Type);
      this.Unnamed_field2.$assign($Prm0.Unnamed_field2);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Step::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 719,
     FQN="clang::InitializationSequence::Step::operator=", NM="_ZN5clang22InitializationSequence4StepaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence4StepaSEOS1_")
    //</editor-fold>
    public /*inline*/ Step /*&*/ $assignMove(final Step /*&&*/$Prm0) {
      this.Kind = $Prm0.Kind;
      this.Type.$assignMove($Prm0.Type);
      this.Unnamed_field2.$assignMove($Prm0.Unnamed_field2);
      return /*Deref*/this;
    }

    @Override public Step clone() { return new Step().$assign(this); }
    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", Type=" + Type // NOI18N
                + ", Unnamed_field2=" + Unnamed_field2; // NOI18N
    }
  };
/*private:*/
  /// \brief The kind of initialization sequence computed.
  private  SequenceKind _SequenceKind;
  
  /// \brief Steps taken by this initialization.
  private SmallVector<Step> Steps;
/*public:*/
  /// \brief Describes why initialization failed.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::FailureKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 767,
   FQN="clang::InitializationSequence::FailureKind", NM="_ZN5clang22InitializationSequence11FailureKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence11FailureKindE")
  //</editor-fold>
  public enum FailureKind implements Native.ComparableLower {
    /// \brief Too many initializers provided for a reference.
    FK_TooManyInitsForReference(0),
    /// \brief Array must be initialized with an initializer list.
    FK_ArrayNeedsInitList(FK_TooManyInitsForReference.getValue() + 1),
    /// \brief Array must be initialized with an initializer list or a 
    /// string literal.
    FK_ArrayNeedsInitListOrStringLiteral(FK_ArrayNeedsInitList.getValue() + 1),
    /// \brief Array must be initialized with an initializer list or a
    /// wide string literal.
    FK_ArrayNeedsInitListOrWideStringLiteral(FK_ArrayNeedsInitListOrStringLiteral.getValue() + 1),
    /// \brief Initializing a wide char array with narrow string literal.
    FK_NarrowStringIntoWideCharArray(FK_ArrayNeedsInitListOrWideStringLiteral.getValue() + 1),
    /// \brief Initializing char array with wide string literal.
    FK_WideStringIntoCharArray(FK_NarrowStringIntoWideCharArray.getValue() + 1),
    /// \brief Initializing wide char array with incompatible wide string
    /// literal.
    FK_IncompatWideStringIntoWideChar(FK_WideStringIntoCharArray.getValue() + 1),
    /// \brief Array type mismatch.
    FK_ArrayTypeMismatch(FK_IncompatWideStringIntoWideChar.getValue() + 1),
    /// \brief Non-constant array initializer
    FK_NonConstantArrayInit(FK_ArrayTypeMismatch.getValue() + 1),
    /// \brief Cannot resolve the address of an overloaded function.
    FK_AddressOfOverloadFailed(FK_NonConstantArrayInit.getValue() + 1),
    /// \brief Overloading due to reference initialization failed.
    FK_ReferenceInitOverloadFailed(FK_AddressOfOverloadFailed.getValue() + 1),
    /// \brief Non-const lvalue reference binding to a temporary.
    FK_NonConstLValueReferenceBindingToTemporary(FK_ReferenceInitOverloadFailed.getValue() + 1),
    /// \brief Non-const lvalue reference binding to an lvalue of unrelated
    /// type.
    FK_NonConstLValueReferenceBindingToUnrelated(FK_NonConstLValueReferenceBindingToTemporary.getValue() + 1),
    /// \brief Rvalue reference binding to an lvalue.
    FK_RValueReferenceBindingToLValue(FK_NonConstLValueReferenceBindingToUnrelated.getValue() + 1),
    /// \brief Reference binding drops qualifiers.
    FK_ReferenceInitDropsQualifiers(FK_RValueReferenceBindingToLValue.getValue() + 1),
    /// \brief Reference binding failed.
    FK_ReferenceInitFailed(FK_ReferenceInitDropsQualifiers.getValue() + 1),
    /// \brief Implicit conversion failed.
    FK_ConversionFailed(FK_ReferenceInitFailed.getValue() + 1),
    /// \brief Implicit conversion failed.
    FK_ConversionFromPropertyFailed(FK_ConversionFailed.getValue() + 1),
    /// \brief Too many initializers for scalar
    FK_TooManyInitsForScalar(FK_ConversionFromPropertyFailed.getValue() + 1),
    /// \brief Reference initialization from an initializer list
    FK_ReferenceBindingToInitList(FK_TooManyInitsForScalar.getValue() + 1),
    /// \brief Initialization of some unused destination type with an
    /// initializer list.
    FK_InitListBadDestinationType(FK_ReferenceBindingToInitList.getValue() + 1),
    /// \brief Overloading for a user-defined conversion failed.
    FK_UserConversionOverloadFailed(FK_InitListBadDestinationType.getValue() + 1),
    /// \brief Overloading for initialization by constructor failed.
    FK_ConstructorOverloadFailed(FK_UserConversionOverloadFailed.getValue() + 1),
    /// \brief Overloading for list-initialization by constructor failed.
    FK_ListConstructorOverloadFailed(FK_ConstructorOverloadFailed.getValue() + 1),
    /// \brief Default-initialization of a 'const' object.
    FK_DefaultInitOfConst(FK_ListConstructorOverloadFailed.getValue() + 1),
    /// \brief Initialization of an incomplete type.
    FK_Incomplete(FK_DefaultInitOfConst.getValue() + 1),
    /// \brief Variable-length array must not have an initializer.
    FK_VariableLengthArrayHasInitializer(FK_Incomplete.getValue() + 1),
    /// \brief List initialization failed at some point.
    FK_ListInitializationFailed(FK_VariableLengthArrayHasInitializer.getValue() + 1),
    /// \brief Initializer has a placeholder type which cannot be
    /// resolved by initialization.
    FK_PlaceholderType(FK_ListInitializationFailed.getValue() + 1),
    /// \brief Trying to take the address of a function that doesn't support
    /// having its address taken.
    FK_AddressOfUnaddressableFunction(FK_PlaceholderType.getValue() + 1),
    /// \brief List-copy-initialization chose an explicit constructor.
    FK_ExplicitConstructor(FK_AddressOfUnaddressableFunction.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static FailureKind valueOf(int val) {
      FailureKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final FailureKind[] VALUES;
      private static final FailureKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (FailureKind kind : FailureKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new FailureKind[min < 0 ? (1-min) : 0];
        VALUES = new FailureKind[max >= 0 ? (1+max) : 0];
        for (FailureKind kind : FailureKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private FailureKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((FailureKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((FailureKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  /// \brief The reason why initialization failed.
  private FailureKind Failure;
  
  /// \brief The failed result of overload resolution.
  private OverloadingResult FailedOverloadResult;
  
  /// \brief The candidate set created when initialization failed.
  private OverloadCandidateSet FailedCandidateSet;
  
  /// \brief The incomplete type that caused a failure.
  private QualType FailedIncompleteType;
  
  /// \brief The fixit that needs to be applied to make this initialization
  /// succeed.
  private std.string ZeroInitializationFixit;
  private SourceLocation ZeroInitializationFixitLoc;
/*public:*/
  /// \brief Call for initializations are invalid but that would be valid
  /// zero initialzations if Fixit was applied.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::SetZeroInitializationFixit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 860,
   FQN="clang::InitializationSequence::SetZeroInitializationFixit", NM="_ZN5clang22InitializationSequence26SetZeroInitializationFixitERKSsNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence26SetZeroInitializationFixitERKSsNS_14SourceLocationE")
  //</editor-fold>
  public void SetZeroInitializationFixit(final /*const*/std.string/*&*/ Fixit, SourceLocation L) {
    ZeroInitializationFixit.$assign(Fixit);
    ZeroInitializationFixitLoc.$assign(L);
  }

/*private:*/
  
  /// \brief Prints a follow-up note that highlights the location of
  /// the initialized entity, if it's remote.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::PrintInitLocationNote">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5627,
   FQN="clang::InitializationSequence::PrintInitLocationNote", NM="_ZN5clang22InitializationSequence21PrintInitLocationNoteERNS_4SemaERKNS_17InitializedEntityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence21PrintInitLocationNoteERNS_4SemaERKNS_17InitializedEntityE")
  //</editor-fold>
  private void PrintInitLocationNote(final Sema /*&*/ S, 
                       final /*const*/ InitializedEntity /*&*/ Entity) {
    if (Entity.isParameterKind() && (Entity.getDecl() != null)) {
      if (Entity.getDecl().getLocation().isInvalid()) {
        return;
      }
      if (Entity.getDecl().getDeclName().$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Entity.getDecl().getLocation(), diag.note_parameter_named_here)), 
              Entity.getDecl().getDeclName()));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(Entity.getDecl().getLocation(), diag.note_parameter_here)));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (Entity.getKind() == InitializedEntity.EntityKind.EK_RelatedResult
       && (Entity.getMethodDecl() != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Entity.getMethodDecl().getLocation(), 
                diag.note_method_return_type_change)), 
            Entity.getMethodDecl().getDeclName()));
      } finally {
        $c$.$destroy();
      }
    }
  }

/*public:*/
  /// \brief Try to perform initialization of the given entity, creating a 
  /// record of the steps required to perform the initialization.
  ///
  /// The generated initialization sequence will either contain enough
  /// information to diagnose 
  ///
  /// \param S the semantic analysis object.
  ///
  /// \param Entity the entity being initialized.
  ///
  /// \param Kind the kind of initialization being performed.
  ///
  /// \param Args the argument(s) provided for initialization.
  ///
  /// \param TopLevelOfInitList true if we are initializing from an expression
  ///        at the top level inside an initializer list. This disallows
  ///        narrowing conversions in C++11 onwards.
  /// \param TreatUnavailableAsInvalid true if we want to treat unavailable
  ///        as invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::InitializationSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4917,
   FQN="clang::InitializationSequence::InitializationSequence", NM="_ZN5clang22InitializationSequenceC1ERNS_4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEN4llvm15MutableArrayRefIPNS_4ExprEEEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequenceC1ERNS_4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEN4llvm15MutableArrayRefIPNS_4ExprEEEbb")
  //</editor-fold>
  public InitializationSequence(final Sema /*&*/ S, 
      final /*const*/ InitializedEntity /*&*/ Entity, 
      final /*const*/ InitializationKind /*&*/ Kind, 
      MutableArrayRef<Expr /*P*/ > Args) {
    this(S, 
      Entity, 
      Kind, 
      Args, 
      false, 
      true);
  }
  public InitializationSequence(final Sema /*&*/ S, 
      final /*const*/ InitializedEntity /*&*/ Entity, 
      final /*const*/ InitializationKind /*&*/ Kind, 
      MutableArrayRef<Expr /*P*/ > Args, 
      boolean TopLevelOfInitList/*= false*/) {
    this(S, 
      Entity, 
      Kind, 
      Args, 
      TopLevelOfInitList, 
      true);
  }
  public InitializationSequence(final Sema /*&*/ S, 
      final /*const*/ InitializedEntity /*&*/ Entity, 
      final /*const*/ InitializationKind /*&*/ Kind, 
      MutableArrayRef<Expr /*P*/ > Args, 
      boolean TopLevelOfInitList/*= false*/, 
      boolean TreatUnavailableAsInvalid/*= true*/) {
    // : Steps(), FailedCandidateSet(Kind.getLocation(), OverloadCandidateSet::CSK_Normal), FailedIncompleteType(), ZeroInitializationFixit(), ZeroInitializationFixitLoc() 
    //START JInit
    this.Steps = new SmallVector<Step>(4, new Step());
    this.FailedCandidateSet = new OverloadCandidateSet(Kind.getLocation(), OverloadCandidateSet.CandidateSetKind.CSK_Normal);
    this.FailedIncompleteType = new QualType();
    this.ZeroInitializationFixit = new std.string();
    this.ZeroInitializationFixitLoc = new SourceLocation();
    //END JInit
    InitializeFrom(S, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Args), TopLevelOfInitList, 
        TreatUnavailableAsInvalid);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::InitializeFrom">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4939,
   FQN="clang::InitializationSequence::InitializeFrom", NM="_ZN5clang22InitializationSequence14InitializeFromERNS_4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEN4llvm15MutableArrayRefIPNS_4ExprEEEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence14InitializeFromERNS_4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEN4llvm15MutableArrayRefIPNS_4ExprEEEbb")
  //</editor-fold>
  public void InitializeFrom(final Sema /*&*/ S, 
                final /*const*/ InitializedEntity /*&*/ Entity, 
                final /*const*/ InitializationKind /*&*/ Kind, 
                MutableArrayRef<Expr /*P*/ > Args, 
                boolean TopLevelOfInitList, 
                boolean TreatUnavailableAsInvalid) {
    ImplicitConversionSequence ICS = null;
    try {
      final ASTContext /*&*/ Context = S.Context;
      
      // Eliminate non-overload placeholder types in the arguments.  We
      // need to do this before checking whether types are dependent
      // because lowering a pseudo-object expression might well give us
      // something of dependent type.
      for (/*uint*/int I = 0, E = Args.size(); I != E; ++I)  {
        if (Args.$at(I).getType().$arrow().isNonOverloadPlaceholderType()) {
          // FIXME: should we be doing this here?
          ActionResultTTrue<Expr /*P*/ > result = S.CheckPlaceholderExpr(Args.$at(I));
          if (result.isInvalid()) {
            SetFailed(FailureKind.FK_PlaceholderType);
            return;
          }
          Args.$set(I, result.get());
        }
      }
      
      // C++0x [dcl.init]p16:
      //   The semantics of initializers are as follows. The destination type is
      //   the type of the object or reference being initialized and the source
      //   type is the type of the initializer expression. The source type is not
      //   defined when the initializer is a braced-init-list or when it is a
      //   parenthesized list of expressions.
      QualType DestType = Entity.getType();
      if (DestType.$arrow().isDependentType()
         || Expr.hasAnyTypeDependentArguments(new ArrayRef<Expr /*P*/ >(Args))) {
        _SequenceKind = SequenceKind.DependentSequence;
        return;
      }
      
      // Almost everything is a normal sequence.
      setSequenceKind(SequenceKind.NormalSequence);
      
      QualType SourceType/*J*/= new QualType();
      type$ref<Expr /*P*/ > Initializer = create_type$ref(null);
      if (Args.size() == 1) {
        Initializer.$set(Args.$at(0));
        if (S.getLangOpts().ObjC1) {
          if (S.CheckObjCBridgeRelatedConversions(Initializer.$deref().getLocStart(), 
              new QualType(DestType), Initializer.$deref().getType(), 
              Initializer)
             || S.ConversionToObjCStringLiteralCheck(new QualType(DestType), Initializer)) {
            Args.$set(0, Initializer.$deref());
          }
        }
        if (!isa_InitListExpr(Initializer.$deref())) {
          SourceType.$assignMove(Initializer.$deref().getType());
        }
      }
      
      //     - If the initializer is a (non-parenthesized) braced-init-list, the
      //       object is list-initialized (8.5.4).
      if (Kind.getKind() != InitializationKind.InitKind.IK_Direct) {
        {
          InitListExpr /*P*/ InitList = dyn_cast_or_null_InitListExpr(Initializer.$deref());
          if ((InitList != null)) {
            TryListInitialization(S, Entity, Kind, InitList, /*Deref*/this, 
                TreatUnavailableAsInvalid);
            return;
          }
        }
      }
      
      //     - If the destination type is a reference type, see 8.5.3.
      if (DestType.$arrow().isReferenceType()) {
        // C++0x [dcl.init.ref]p1:
        //   A variable declared to be a T& or T&&, that is, "reference to type T"
        //   (8.3.2), shall be initialized by an object, or function, of type T or
        //   by an object that can be converted into a T.
        // (Therefore, multiple arguments are not permitted.)
        if (Args.size() != 1) {
          SetFailed(FailureKind.FK_TooManyInitsForReference);
        } else {
          TryReferenceInitialization(S, Entity, Kind, Args.$at(0), /*Deref*/this);
        }
        return;
      }
      
      //     - If the initializer is (), the object is value-initialized.
      if (Kind.getKind() == InitializationKind.InitKind.IK_Value
         || (Kind.getKind() == InitializationKind.InitKind.IK_Direct && Args.empty())) {
        TryValueInitialization(S, Entity, Kind, /*Deref*/this);
        return;
      }
      
      // Handle default initialization.
      if (Kind.getKind() == InitializationKind.InitKind.IK_Default) {
        TryDefaultInitialization(S, Entity, Kind, /*Deref*/this);
        return;
      }
      {
        
        //     - If the destination type is an array of characters, an array of
        //       char16_t, an array of char32_t, or an array of wchar_t, and the
        //       initializer is a string literal, see 8.5.2.
        //     - Otherwise, if the destination type is an array, the program is
        //       ill-formed.
        /*const*/ ArrayType /*P*/ DestAT = Context.getAsArrayType(new QualType(DestType));
        if ((DestAT != null)) {
          if ((Initializer.$deref() != null) && isa_VariableArrayType(DestAT)) {
            SetFailed(FailureKind.FK_VariableLengthArrayHasInitializer);
            return;
          }
          if ((Initializer.$deref() != null)) {
            switch (IsStringInit(Initializer.$deref(), DestAT, Context)) {
             case SIF_None:
              TryStringLiteralInitialization(S, Entity, Kind, Initializer.$deref(), /*Deref*/this);
              return;
             case SIF_NarrowStringIntoWideChar:
              SetFailed(FailureKind.FK_NarrowStringIntoWideCharArray);
              return;
             case SIF_WideStringIntoChar:
              SetFailed(FailureKind.FK_WideStringIntoCharArray);
              return;
             case SIF_IncompatWideStringIntoWideChar:
              SetFailed(FailureKind.FK_IncompatWideStringIntoWideChar);
              return;
             case SIF_Other:
              break;
            }
          }
          
          // Note: as an GNU C extension, we allow initialization of an
          // array from a compound literal that creates an array of the same
          // type, so long as the initializer has no side effects.
          if (!S.getLangOpts().CPlusPlus && (Initializer.$deref() != null)
             && isa_CompoundLiteralExpr(Initializer.$deref().IgnoreParens())
             && Initializer.$deref().getType().$arrow().isArrayType()) {
            /*const*/ ArrayType /*P*/ SourceAT = Context.getAsArrayType(Initializer.$deref().getType());
            if (!hasCompatibleArrayTypes(S.Context, DestAT, SourceAT)) {
              SetFailed(FailureKind.FK_ArrayTypeMismatch);
            } else if (Initializer.$deref().HasSideEffects(S.Context)) {
              SetFailed(FailureKind.FK_NonConstantArrayInit);
            } else {
              AddArrayInitStep(new QualType(DestType));
            }
          } else // Note: as a GNU C++ extension, we allow list-initialization of a
          // class member of array type from a parenthesized initializer list.
          if (S.getLangOpts().CPlusPlus
             && Entity.getKind() == InitializedEntity.EntityKind.EK_Member
             && (Initializer.$deref() != null) && isa_InitListExpr(Initializer.$deref())) {
            TryListInitialization(S, Entity, Kind, cast_InitListExpr(Initializer.$deref()), 
                /*Deref*/this, TreatUnavailableAsInvalid);
            AddParenthesizedArrayInitStep(new QualType(DestType));
          } else if (DestAT.getElementType().$arrow().isCharType()) {
            SetFailed(FailureKind.FK_ArrayNeedsInitListOrStringLiteral);
          } else if (IsWideCharCompatible(DestAT.getElementType(), Context)) {
            SetFailed(FailureKind.FK_ArrayNeedsInitListOrWideStringLiteral);
          } else {
            SetFailed(FailureKind.FK_ArrayNeedsInitList);
          }
          
          return;
        }
      }
      
      // Determine whether we should consider writeback conversions for
      // Objective-C ARC.
      boolean allowObjCWritebackConversion = S.getLangOpts().ObjCAutoRefCount
         && Entity.isParameterKind();
      
      // We're at the end of the line for C: it's either a write-back conversion
      // or it's a C assignment. There's no need to check anything else.
      if (!S.getLangOpts().CPlusPlus) {
        // If allowed, check whether this is an Objective-C writeback conversion.
        if (allowObjCWritebackConversion
           && tryObjCWritebackConversion(S, /*Deref*/this, Entity, Initializer.$deref())) {
          return;
        }
        if (TryOCLSamplerInitialization(S, /*Deref*/this, new QualType(DestType), Initializer.$deref())) {
          return;
        }
        if (TryOCLZeroEventInitialization(S, /*Deref*/this, new QualType(DestType), Initializer.$deref())) {
          return;
        }
        
        // Handle initialization in C
        AddCAssignmentStep(new QualType(DestType));
        MaybeProduceObjCObject(S, /*Deref*/this, Entity);
        return;
      }
      assert Native.$bool(S.getLangOpts().CPlusPlus);
      
      //     - If the destination type is a (possibly cv-qualified) class type:
      if (DestType.$arrow().isRecordType()) {
        //     - If the initialization is direct-initialization, or if it is
        //       copy-initialization where the cv-unqualified version of the
        //       source type is the same class as, or a derived class of, the
        //       class of the destination, constructors are considered. [...]
        if (Kind.getKind() == InitializationKind.InitKind.IK_Direct
           || (Kind.getKind() == InitializationKind.InitKind.IK_Copy
           && (Context.hasSameUnqualifiedType(new QualType(SourceType), new QualType(DestType))
           || S.IsDerivedFrom(Initializer.$deref().getLocStart(), new QualType(SourceType), new QualType(DestType))))) {
          TryConstructorInitialization(S, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Args), 
              new QualType(DestType), /*Deref*/this);
        } else {
          //     - Otherwise (i.e., for the remaining copy-initialization cases),
          //       user-defined conversion sequences that can convert from the source
          //       type to the destination type or (when a conversion function is
          //       used) to a derived class thereof are enumerated as described in
          //       13.3.1.4, and the best one is chosen through overload resolution
          //       (13.3).
          TryUserDefinedConversion(S, new QualType(DestType), Kind, Initializer.$deref(), /*Deref*/this, 
              TopLevelOfInitList);
        }
        return;
      }
      if ($greater_uint(Args.size(), 1)) {
        SetFailed(FailureKind.FK_TooManyInitsForScalar);
        return;
      }
      assert (Args.size() == 1) : "Zero-argument case handled above";
      
      //    - Otherwise, if the source type is a (possibly cv-qualified) class
      //      type, conversion functions are considered.
      if (!SourceType.isNull() && SourceType.$arrow().isRecordType()) {
        // For a conversion to _Atomic(T) from either T or a class type derived
        // from T, initialize the T object then convert to _Atomic type.
        boolean NeedAtomicConversion = false;
        {
          /*const*/ AtomicType /*P*/ Atomic = DestType.$arrow().getAs(AtomicType.class);
          if ((Atomic != null)) {
            if (Context.hasSameUnqualifiedType(new QualType(SourceType), Atomic.getValueType())
               || S.IsDerivedFrom(Initializer.$deref().getLocStart(), new QualType(SourceType), 
                Atomic.getValueType())) {
              DestType.$assignMove(Atomic.getValueType());
              NeedAtomicConversion = true;
            }
          }
        }
        
        TryUserDefinedConversion(S, new QualType(DestType), Kind, Initializer.$deref(), /*Deref*/this, 
            TopLevelOfInitList);
        MaybeProduceObjCObject(S, /*Deref*/this, Entity);
        if (!Failed() && NeedAtomicConversion) {
          AddAtomicConversionStep(Entity.getType());
        }
        return;
      }
      
      //    - Otherwise, the initial value of the object being initialized is the
      //      (possibly converted) value of the initializer expression. Standard
      //      conversions (Clause 4) will be used, if necessary, to convert the
      //      initializer expression to the cv-unqualified version of the
      //      destination type; no user-defined conversions are considered.
      ICS = S.TryImplicitConversion(Initializer.$deref(), new QualType(DestType), 
          /*SuppressUserConversions*/ true, 
          /*AllowExplicitConversions*/ false, 
          /*InOverloadResolution*/ false, 
          /*CStyle=*/ Kind.isCStyleOrFunctionalCast(), 
          allowObjCWritebackConversion);
      if (ICS.isStandard()
         && ICS.Unnamed_field2.Standard.Second == ImplicitConversionKind.ICK_Writeback_Conversion) {
        // Objective-C ARC writeback conversion.
        
        // We should copy unless we're passing to an argument explicitly
        // marked 'out'.
        boolean ShouldCopy = true;
        {
          ParmVarDecl /*P*/ Param = cast_or_null_ParmVarDecl(Entity.getDecl());
          if ((Param != null)) {
            ShouldCopy = (Param.getObjCDeclQualifier() != ParmVarDecl.ObjCDeclQualifier.OBJC_TQ_Out);
          }
        }
        
        // If there was an lvalue adjustment, add it as a separate conversion.
        if (ICS.Unnamed_field2.Standard.First == ImplicitConversionKind.ICK_Array_To_Pointer
           || ICS.Unnamed_field2.Standard.First == ImplicitConversionKind.ICK_Lvalue_To_Rvalue) {
          ImplicitConversionSequence LvalueICS = null;
          try {
            LvalueICS/*J*/= new ImplicitConversionSequence();
            LvalueICS.setStandard();
            LvalueICS.Unnamed_field2.Standard.setAsIdentityConversion();
            LvalueICS.Unnamed_field2.Standard.setAllToTypes(ICS.Unnamed_field2.Standard.getToType(0));
            LvalueICS.Unnamed_field2.Standard.First = ICS.Unnamed_field2.Standard.First;
            AddConversionSequenceStep(LvalueICS, ICS.Unnamed_field2.Standard.getToType(0));
          } finally {
            if (LvalueICS != null) { LvalueICS.$destroy(); }
          }
        }
        
        AddPassByIndirectCopyRestoreStep(new QualType(DestType), ShouldCopy);
      } else if (ICS.isBad()) {
        DeclAccessPair dap/*J*/= new DeclAccessPair();
        if (isLibstdcxxPointerReturnFalseHack(S, Entity, Initializer.$deref())) {
          AddZeroInitializationStep(Entity.getType());
        } else if ($eq_QualType$C(Initializer.$deref().getType(), Context.OverloadTy.$QualType())
           && !(S.ResolveAddressOfOverloadedFunction(Initializer.$deref(), new QualType(DestType), 
            false, dap) != null)) {
          SetFailed(InitializationSequence.FailureKind.FK_AddressOfOverloadFailed);
        } else if (Initializer.$deref().getType().$arrow().isFunctionType()
           && isExprAnUnaddressableFunction(S, Initializer.$deref())) {
          SetFailed(InitializationSequence.FailureKind.FK_AddressOfUnaddressableFunction);
        } else {
          SetFailed(InitializationSequence.FailureKind.FK_ConversionFailed);
        }
      } else {
        AddConversionSequenceStep(ICS, new QualType(DestType), TopLevelOfInitList);
        
        MaybeProduceObjCObject(S, /*Deref*/this, Entity);
      }
    } finally {
      if (ICS != null) { ICS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::~InitializationSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5232,
   FQN="clang::InitializationSequence::~InitializationSequence", NM="_ZN5clang22InitializationSequenceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequenceD0Ev")
  //</editor-fold>
  public void $destroy() {
    for (final Step /*&*/ S : Steps)  {
      S.Destroy();
    }
    //START JDestroy
    ZeroInitializationFixit.$destroy();
    FailedCandidateSet.$destroy();
    Steps.$destroy();
    //END JDestroy
  }

  
  /// \brief Perform the actual initialization of the given entity based on
  /// the computed initialization sequence.
  ///
  /// \param S the semantic analysis object.
  ///
  /// \param Entity the entity being initialized.
  ///
  /// \param Kind the kind of initialization being performed.
  ///
  /// \param Args the argument(s) provided for initialization, ownership of
  /// which is transferred into the routine.
  ///
  /// \param ResultType if non-NULL, will be set to the type of the
  /// initialized object, which is the type of the declaration in most
  /// cases. However, when the initialized object is a variable of
  /// incomplete array type and the initializer is an initializer
  /// list, this type will be set to the completed array type.
  ///
  /// \returns an expression that performs the actual object initialization, if
  /// the initialization is well-formed. Otherwise, emits diagnostics
  /// and returns an invalid expression.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Perform">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 6207,
   FQN="clang::InitializationSequence::Perform", NM="_ZN5clang22InitializationSequence7PerformERNS_4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEN4llvm15MutableArrayRefIPNS_4ExprEEEPNS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence7PerformERNS_4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEN4llvm15MutableArrayRefIPNS_4ExprEEEPNS_8QualTypeE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > Perform(final Sema /*&*/ S, 
         final /*const*/ InitializedEntity /*&*/ Entity, 
         final /*const*/ InitializationKind /*&*/ Kind, 
         MutableArrayRef<Expr /*P*/ > Args) {
    return Perform(S, 
         Entity, 
         Kind, 
         Args, 
         (type$ptr<QualType /*P*/> )null);
  }
  public ActionResultTTrue<Expr /*P*/ > Perform(final Sema /*&*/ S, 
         final /*const*/ InitializedEntity /*&*/ Entity, 
         final /*const*/ InitializationKind /*&*/ Kind, 
         MutableArrayRef<Expr /*P*/ > Args, 
         type$ptr<QualType /*P*/> ResultType/*= null*/) {
    if (Failed()) {
      Diagnose(S, Entity, Kind, new ArrayRef<Expr /*P*/ >(Args));
      return ExprError();
    }
    if (!ZeroInitializationFixit.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*uint*/int DiagID = diag.err_default_init_const;
        {
          Decl /*P*/ D = Entity.getDecl();
          if ((D != null)) {
            if (S.getLangOpts().MSVCCompat && D.hasAttr(SelectAnyAttr.class)) {
              DiagID = diag.ext_default_init_const;
            }
          }
        }
        
        // The initialization would have succeeded with this fixit. Since the fixit
        // is on the error, we need to build a valid AST in this case, so this isn't
        // handled in the Failed() branch above.
        QualType DestType = Entity.getType();
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), DiagID)), 
                    DestType), (boolean)(DestType.$arrow().getAs$RecordType() != null)), 
            FixItHint.CreateInsertion(/*NO_COPY*/ZeroInitializationFixitLoc, 
                new StringRef(ZeroInitializationFixit))));
      } finally {
        $c$.$destroy();
      }
    }
    if (getKind() == SequenceKind.DependentSequence) {
      // If the declaration is a non-dependent, incomplete array type
      // that has an initializer, then its type will be completed once
      // the initializer is instantiated.
      if (Native.$bool(ResultType) && !Entity.getType().$arrow().isDependentType()
         && Args.size() == 1) {
        QualType DeclType = Entity.getType();
        {
          /*const*/ IncompleteArrayType /*P*/ ArrayT = S.Context.getAsIncompleteArrayType(new QualType(DeclType));
          if ((ArrayT != null)) {
            // FIXME: We don't currently have the ability to accurately
            // compute the length of an initializer list without
            // performing full type-checking of the initializer list
            // (since we have to determine where braces are implicitly
            // introduced and such).  So, we fall back to making the array
            // type a dependently-sized array type with no specified
            // bound.
            if (isa_InitListExpr((Expr /*P*/ )Args.$at(0))) {
              SourceRange Brackets/*J*/= new SourceRange();
              {
                
                // Scavange the location of the brackets from the entity, if we can.
                DeclaratorDecl /*P*/ DD = Entity.getDecl();
                if ((DD != null)) {
                  {
                    TypeSourceInfo /*P*/ TInfo = DD.getTypeSourceInfo();
                    if ((TInfo != null)) {
                      TypeLoc TL = TInfo.getTypeLoc();
                      {
                        IncompleteArrayTypeLoc ArrayLoc = TL.getAs(IncompleteArrayTypeLoc.class);
                        if (ArrayLoc.$bool()) {
                          Brackets.$assignMove(ArrayLoc.getBracketsRange());
                        }
                      }
                    }
                  }
                }
              }
              
              ResultType.$star().$assignMove(
                  S.Context.getDependentSizedArrayType(ArrayT.getElementType(), 
                      /*NumElts=*/ (Expr /*P*/ )null, 
                      ArrayT.getSizeModifier(), 
                      ArrayT.getIndexTypeCVRQualifiers(), 
                      new SourceRange(Brackets))
              );
            }
          }
        }
      }
      if (Kind.getKind() == InitializationKind.InitKind.IK_Direct
         && !Kind.isExplicitCast()) {
        // Rebuild the ParenListExpr.
        SourceRange ParenRange = Kind.getParenRange();
        return S.ActOnParenListExpr(ParenRange.getBegin(), ParenRange.getEnd(), 
            new MutableArrayRef<Expr /*P*/ >(Args));
      }
      assert (Kind.getKind() == InitializationKind.InitKind.IK_Copy || Kind.isExplicitCast() || Kind.getKind() == InitializationKind.InitKind.IK_DirectList);
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Args.$at(0));
    }
    
    // No steps means no initialization.
    if (Steps.empty()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, (Expr /*P*/ )(Expr /*P*/ )null);
    }
    if (S.getLangOpts().CPlusPlus11 && Entity.getType().$arrow().isReferenceType()
       && Args.size() == 1 && isa_InitListExpr(Args.$at(0))
       && !Entity.isParameterKind()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Produce a C++98 compatibility warning if we are initializing a reference
        // from an initializer list. For parameters, we produce a better warning
        // elsewhere.
        Expr /*P*/ Init = Args.$at(0);
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Init.getLocStart(), diag.warn_cxx98_compat_reference_list_init)), 
            Init.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Diagnose cases where we initialize a pointer to an array temporary, and the
    // pointer obviously outlives the temporary.
    if (Args.size() == 1 && Args.$at(0).getType().$arrow().isArrayType()
       && Entity.getType().$arrow().isPointerType()
       && InitializedEntityOutlivesFullExpression(Entity)) {
      Expr /*P*/ Init = Args.$at(0);
      Expr.LValueClassification Kind$1 = Init.ClassifyLValue(S.Context);
      if (Kind$1 == Expr.LValueClassification.LV_ClassTemporary || Kind$1 == Expr.LValueClassification.LV_ArrayTemporary) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Init.getLocStart(), diag.warn_temporary_array_to_pointer_decay)), 
              Init.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    QualType DestType = Entity.getType().getNonReferenceType();
    // FIXME: Ugly hack around the fact that Entity.getType() is not
    // the same as Entity.getDecl()->getType() in cases involving type merging,
    //  and we want latter when it makes sense.
    if (Native.$bool(ResultType)) {
      ResultType.$star().$assignMove((Entity.getDecl() != null) ? Entity.getDecl().getType() : Entity.getType());
    }
    
    ActionResultTTrue<Expr /*P*/ > CurInit/*J*/= new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, (Expr /*P*/ )(Expr /*P*/ )null);
    
    // For initialization steps that start with a single initializer,
    // grab the only argument out the Args and place it into the "current"
    // initializer.
    switch (Steps.front().Kind) {
     case SK_ResolveAddressOfOverloadedFunction:
     case SK_CastDerivedToBaseRValue:
     case SK_CastDerivedToBaseXValue:
     case SK_CastDerivedToBaseLValue:
     case SK_BindReference:
     case SK_BindReferenceToTemporary:
     case SK_ExtraneousCopyToTemporary:
     case SK_UserConversion:
     case SK_QualificationConversionLValue:
     case SK_QualificationConversionXValue:
     case SK_QualificationConversionRValue:
     case SK_AtomicConversion:
     case SK_LValueToRValue:
     case SK_ConversionSequence:
     case SK_ConversionSequenceNoNarrowing:
     case SK_ListInitialization:
     case SK_UnwrapInitList:
     case SK_RewrapInitList:
     case SK_CAssignment:
     case SK_StringInit:
     case SK_ObjCObjectConversion:
     case SK_ArrayInit:
     case SK_ParenthesizedArrayInit:
     case SK_PassByIndirectCopyRestore:
     case SK_PassByIndirectRestore:
     case SK_ProduceObjCObject:
     case SK_StdInitializerList:
     case SK_OCLSamplerInit:
     case SK_OCLZeroEvent:
      {
        assert (Args.size() == 1);
        CurInit.$assign(Args.$at(0));
        if (!(CurInit.get() != null)) {
          return ExprError();
        }
        break;
      }
     case SK_ConstructorInitialization:
     case SK_ConstructorInitializationFromList:
     case SK_StdInitializerListConstructorCall:
     case SK_ZeroInitialization:
      break;
    }
    
    // Walk through the computed steps for the initialization sequence,
    // performing the specified conversions along the way.
    bool$ref ConstructorInitRequiresZeroInit = create_bool$ref(false);
    for (type$ptr<Step> Step = $tryClone(step_begin()), /*P*/ StepEnd = $tryClone(step_end());
         $noteq_ptr(Step, StepEnd); Step.$preInc()) {
      if (CurInit.isInvalid()) {
        return ExprError();
      }
      
      QualType SourceType = (CurInit.get() != null) ? CurInit.get().getType() : new QualType();
      switch (Step./*->*/$star().Kind) {
       case SK_ResolveAddressOfOverloadedFunction:
        // Overload resolution determined which function invoke; update the
        // initializer to reflect that choice.
        S.CheckAddressOfMemberAccess(CurInit.get(), new DeclAccessPair(Step./*->*/$star().Unnamed_field2.Function.FoundDecl));
        if (S.DiagnoseUseOfDecl(Step./*->*/$star().Unnamed_field2.Function.FoundDecl.$NamedDecl$P(), Kind.getLocation())) {
          return ExprError();
        }
        CurInit.$assignMove(S.FixOverloadedFunctionReference(new ActionResultTTrue<Expr /*P*/ >(CurInit), 
                new DeclAccessPair(Step./*->*/$star().Unnamed_field2.Function.FoundDecl), 
                Step./*->*/$star().Unnamed_field2.Function.Function));
        break;
       case SK_CastDerivedToBaseRValue:
       case SK_CastDerivedToBaseXValue:
       case SK_CastDerivedToBaseLValue:
        {
          // We have a derived-to-base cast that produces either an rvalue or an
          // lvalue. Perform that cast.
          SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
          
          // Casts to inaccessible base classes are allowed with C-style casts.
          boolean IgnoreBaseAccess = Kind.isCStyleOrFunctionalCast();
          if (S.CheckDerivedToBaseConversion(new QualType(SourceType), new QualType(Step./*->*/$star().Type), 
              CurInit.get().getLocStart(), 
              CurInit.get().getSourceRange(), 
              $AddrOf(BasePath), IgnoreBaseAccess)) {
            return ExprError();
          }
          
          ExprValueKind VK = Step./*->*/$star().Kind == StepKind.SK_CastDerivedToBaseLValue ? ExprValueKind.VK_LValue : (Step./*->*/$star().Kind == StepKind.SK_CastDerivedToBaseXValue ? ExprValueKind.VK_XValue : ExprValueKind.VK_RValue);
          CurInit.$assign(
              ImplicitCastExpr.Create(S.Context, new QualType(Step./*->*/$star().Type), CastKind.CK_DerivedToBase, 
                  CurInit.get(), $AddrOf(BasePath), VK)
          );
          break;
        }
       case SK_BindReference:
        // References cannot bind to bit-fields (C++ [dcl.init.ref]p5).
        if (CurInit.get().refersToBitField()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // We don't necessarily have an unambiguous source bit-field.
            FieldDecl /*P*/ BitField = CurInit.get().getSourceBitField();
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_reference_bind_to_bitfield)), 
                            Entity.getType().isVolatileQualified()), 
                        ((BitField != null) ? BitField.getDeclName() : new DeclarationName())), 
                    (BitField != (FieldDecl /*P*/ )null)), 
                CurInit.get().getSourceRange()));
            if ((BitField != null)) {
              $c$.clean($c$.track(S.Diag(BitField.getLocation(), diag.note_bitfield_decl)));
            }
            
            return ExprError();
          } finally {
            $c$.$destroy();
          }
        }
        if (CurInit.get().refersToVectorElement()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // References cannot bind to vector elements.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_reference_bind_to_vector_element)), 
                    Entity.getType().isVolatileQualified()), 
                CurInit.get().getSourceRange()));
            PrintInitLocationNote(S, Entity);
            return ExprError();
          } finally {
            $c$.$destroy();
          }
        }
        
        // Reference binding does not have any corresponding ASTs.
        
        // Check exception specifications
        if (S.CheckExceptionSpecCompatibility(CurInit.get(), new QualType(DestType))) {
          return ExprError();
        }
        {
          
          // Even though we didn't materialize a temporary, the binding may still
          // extend the lifetime of a temporary. This happens if we bind a reference
          // to the result of a cast to reference type.
          /*const*/ InitializedEntity /*P*/ ExtendingEntity = getEntityForTemporaryLifetimeExtension($AddrOf(Entity));
          if ((ExtendingEntity != null)) {
            if (performReferenceExtension(CurInit.get(), ExtendingEntity)) {
              warnOnLifetimeExtension(S, Entity, CurInit.get(), 
                  /*IsInitializerList=*/ false, 
                  ExtendingEntity.getDecl());
            }
          }
        }
        
        CheckForNullPointerDereference(S, CurInit.get());
        break;
       case SK_BindReferenceToTemporary:
        {
          // Make sure the "temporary" is actually an rvalue.
          assert (CurInit.get().isRValue()) : "not a temporary";
          
          // Check exception specifications
          if (S.CheckExceptionSpecCompatibility(CurInit.get(), new QualType(DestType))) {
            return ExprError();
          }
          
          // Materialize the temporary into memory.
          MaterializeTemporaryExpr /*P*/ MTE = S.CreateMaterializeTemporaryExpr(Entity.getType().getNonReferenceType(), CurInit.get(), 
              Entity.getType().$arrow().isLValueReferenceType());
          {
            
            // Maybe lifetime-extend the temporary's subobjects to match the
            // entity's lifetime.
            /*const*/ InitializedEntity /*P*/ ExtendingEntity = getEntityForTemporaryLifetimeExtension($AddrOf(Entity));
            if ((ExtendingEntity != null)) {
              if (performReferenceExtension(MTE, ExtendingEntity)) {
                warnOnLifetimeExtension(S, Entity, CurInit.get(), /*IsInitializerList=*/ false, 
                    ExtendingEntity.getDecl());
              }
            }
          }
          
          // If we're binding to an Objective-C object that has lifetime, we
          // need cleanups. Likewise if we're extending this temporary to automatic
          // storage duration -- we need to register its cleanup during the
          // full-expression's cleanups.
          if ((S.getLangOpts().ObjCAutoRefCount
             && MTE.getType().$arrow().isObjCLifetimeType())
             || (MTE.getStorageDuration() == StorageDuration.SD_Automatic
             && (MTE.getType().isDestructedType().getValue() != 0))) {
            S.Cleanup.setExprNeedsCleanups(true);
          }
          
          CurInit.$assign(MTE);
          break;
        }
       case SK_ExtraneousCopyToTemporary:
        CurInit.$assignMove(CopyObject(S, new QualType(Step./*->*/$star().Type), Entity, new ActionResultTTrue<Expr /*P*/ >(CurInit), 
                /*IsExtraneousCopy=*/ true));
        break;
       case SK_UserConversion:
        {
          // We have a user-defined conversion that invokes either a constructor
          // or a conversion function.
          CastKind $CastKind;
          boolean IsCopy = false;
          FunctionDecl /*P*/ Fn = Step./*->*/$star().Unnamed_field2.Function.Function;
          DeclAccessPair FoundFn = new DeclAccessPair(Step./*->*/$star().Unnamed_field2.Function.FoundDecl);
          boolean HadMultipleCandidates = Step./*->*/$star().Unnamed_field2.Function.HadMultipleCandidates;
          boolean CreatedObject = false;
          {
            CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(Fn);
            if ((Constructor != null)) {
              // Build a call to the selected constructor.
              SmallVector<Expr /*P*/ > ConstructorArgs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
              SourceLocation Loc = CurInit.get().getLocStart();
              CurInit.get(); // Ownership transferred into MultiExprArg, below.
              
              // Determine the arguments required to actually perform the constructor
              // call.
              type$ptr<Expr /*P*/ > Arg = create_type$ptr(CurInit.get());
              if (S.CompleteConstructorCall(Constructor, 
                  new MutableArrayRef<Expr /*P*/ >($AddrOf(Arg), 1, true), 
                  new SourceLocation(Loc), ConstructorArgs)) {
                return ExprError();
              }
              
              // Build an expression that constructs a temporary.
              CurInit.$assignMove(S.BuildCXXConstructExpr(new SourceLocation(Loc), new QualType(Step./*->*/$star().Type), 
                      FoundFn.$NamedDecl$P(), Constructor, 
                      new MutableArrayRef<Expr /*P*/ >(ConstructorArgs, true), 
                      HadMultipleCandidates, 
                      /*ListInit*/ false, 
                      /*StdInitListInit*/ false, 
                      /*ZeroInit*/ false, 
                      CXXConstructExpr.ConstructionKind.CK_Complete.getValue(), 
                      new SourceRange()));
              if (CurInit.isInvalid()) {
                return ExprError();
              }
              
              S.CheckConstructorAccess(Kind.getLocation(), Constructor, new DeclAccessPair(FoundFn), 
                  Entity);
              if (S.DiagnoseUseOfDecl(FoundFn.$NamedDecl$P(), Kind.getLocation())) {
                return ExprError();
              }
              
              $CastKind = CastKind.CK_ConstructorConversion;
              QualType Class = S.Context.getTypeDeclType(Constructor.getParent());
              if (S.Context.hasSameUnqualifiedType(new QualType(SourceType), new QualType(Class))
                 || S.IsDerivedFrom(new SourceLocation(Loc), new QualType(SourceType), new QualType(Class))) {
                IsCopy = true;
              }
              
              CreatedObject = true;
            } else {
              // Build a call to the conversion function.
              CXXConversionDecl /*P*/ Conversion = cast_CXXConversionDecl(Fn);
              S.CheckMemberOperatorAccess(Kind.getLocation(), CurInit.get(), (Expr /*P*/ )null, 
                  new DeclAccessPair(FoundFn));
              if (S.DiagnoseUseOfDecl(FoundFn.$NamedDecl$P(), Kind.getLocation())) {
                return ExprError();
              }
              
              // FIXME: Should we move this initialization into a separate
              // derived-to-base conversion? I believe the answer is "no", because
              // we don't want to turn off access control here for c-style casts.
              ActionResultTTrue<Expr /*P*/ > CurInitExprRes = S.PerformObjectArgumentInitialization(CurInit.get(), 
                  /*Qualifier=*/ (NestedNameSpecifier /*P*/ )null, 
                  FoundFn.$NamedDecl$P(), Conversion);
              if (CurInitExprRes.isInvalid()) {
                return ExprError();
              }
              CurInit.$assign(CurInitExprRes);
              
              // Build the actual call to the conversion function.
              CurInit.$assignMove(S.BuildCXXMemberCallExpr(CurInit.get(), FoundFn.$NamedDecl$P(), Conversion, 
                      HadMultipleCandidates));
              if (CurInit.isInvalid() || !(CurInit.get() != null)) {
                return ExprError();
              }
              
              $CastKind = CastKind.CK_UserDefinedConversion;
              
              CreatedObject = Conversion.getReturnType().$arrow().isRecordType();
            }
          }
          
          boolean RequiresCopy = !IsCopy && !isReferenceBinding(Steps.back());
          boolean MaybeBindToTemp = RequiresCopy || shouldBindAsTemporary(Entity);
          if (!MaybeBindToTemp && CreatedObject && shouldDestroyTemporary(Entity)) {
            QualType T = CurInit.get().getType();
            {
              /*const*/ RecordType /*P*/ Record = T.$arrow().getAs$RecordType();
              if ((Record != null)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  CXXDestructorDecl /*P*/ Destructor = S.LookupDestructor(cast_CXXRecordDecl(Record.getDecl()));
                  $c$.clean(S.CheckDestructorAccess(CurInit.get().getLocStart(), Destructor, 
                      $out_PartialDiagnostic$C_QualType($c$.track(S.PDiag(diag.err_access_dtor_temp)), /*NO_COPY*/T)));
                  S.MarkFunctionReferenced(CurInit.get().getLocStart(), Destructor);
                  if (S.DiagnoseUseOfDecl(Destructor, CurInit.get().getLocStart())) {
                    return ExprError();
                  }
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
          
          CurInit.$assign(ImplicitCastExpr.Create(S.Context, CurInit.get().getType(), 
                  $CastKind, CurInit.get(), (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, 
                  CurInit.get().getValueKind()));
          if (MaybeBindToTemp) {
            CurInit.$assignMove(S.MaybeBindToTemporary(CurInit.getAs(Expr.class)));
          }
          if (RequiresCopy) {
            CurInit.$assignMove(CopyObject(S, Entity.getType().getNonReferenceType(), Entity, 
                    new ActionResultTTrue<Expr /*P*/ >(CurInit), /*IsExtraneousCopy=*/ false));
          }
          break;
        }
       case SK_QualificationConversionLValue:
       case SK_QualificationConversionXValue:
       case SK_QualificationConversionRValue:
        {
          // Perform a qualification conversion; these can never go wrong.
          ExprValueKind VK = Step./*->*/$star().Kind == StepKind.SK_QualificationConversionLValue ? ExprValueKind.VK_LValue : (Step./*->*/$star().Kind == StepKind.SK_QualificationConversionXValue ? ExprValueKind.VK_XValue : ExprValueKind.VK_RValue);
          CurInit.$assignMove(S.ImpCastExprToType(CurInit.get(), new QualType(Step./*->*/$star().Type), CastKind.CK_NoOp, VK));
          break;
        }
       case SK_AtomicConversion:
        {
          assert (CurInit.get().isRValue()) : "cannot convert glvalue to atomic";
          CurInit.$assignMove(S.ImpCastExprToType(CurInit.get(), new QualType(Step./*->*/$star().Type), 
                  CastKind.CK_NonAtomicToAtomic, ExprValueKind.VK_RValue));
          break;
        }
       case SK_LValueToRValue:
        {
          assert (CurInit.get().isGLValue()) : "cannot load from a prvalue";
          CurInit.$assign(ImplicitCastExpr.Create(S.Context, new QualType(Step./*->*/$star().Type), 
                  CastKind.CK_LValueToRValue, CurInit.get(), 
                  /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue));
          break;
        }
       case SK_ConversionSequence:
       case SK_ConversionSequenceNoNarrowing:
        {
          Sema.CheckedConversionKind CCK = Kind.isCStyleCast() ? Sema.CheckedConversionKind.CCK_CStyleCast : Kind.isFunctionalCast() ? Sema.CheckedConversionKind.CCK_FunctionalCast : Kind.isExplicitCast() ? Sema.CheckedConversionKind.CCK_OtherCast : Sema.CheckedConversionKind.CCK_ImplicitConversion;
          ActionResultTTrue<Expr /*P*/ > CurInitExprRes = S.PerformImplicitConversion(CurInit.get(), new QualType(Step./*->*/$star().Type), $Deref(Step./*->*/$star().Unnamed_field2.ICS), 
              getAssignmentAction(Entity), CCK);
          if (CurInitExprRes.isInvalid()) {
            return ExprError();
          }
          CurInit.$assign(CurInitExprRes);
          if (Step./*->*/$star().Kind == StepKind.SK_ConversionSequenceNoNarrowing
             && S.getLangOpts().CPlusPlus && !CurInit.get().isValueDependent()) {
            DiagnoseNarrowingInInitList(S, $Deref(Step./*->*/$star().Unnamed_field2.ICS), new QualType(SourceType), Entity.getType(), 
                CurInit.get());
          }
          break;
        }
       case SK_ListInitialization:
        {
          InitListChecker PerformInitList = null;
          try {
            InitListExpr /*P*/ InitList = cast_InitListExpr(CurInit.get());
            // If we're not initializing the top-level entity, we need to create an
            // InitializeTemporary entity for our target type.
            QualType Ty = new QualType(Step./*->*/$star().Type);
            boolean IsTemporary = !S.Context.hasSameType(Entity.getType(), new QualType(Ty));
            InitializedEntity TempEntity = InitializedEntity.InitializeTemporary(new QualType(Ty));
            InitializedEntity InitEntity = new InitializedEntity(IsTemporary ? TempEntity : Entity);
            PerformInitList/*J*/= new InitListChecker(S, InitEntity, 
                InitList, Ty, /*VerifyOnly=*/ false, 
                /*TreatUnavailableAsInvalid=*/ false);
            if (PerformInitList.HadError()) {
              return ExprError();
            }
            
            // Hack: We must update *ResultType if available in order to set the
            // bounds of arrays, e.g. in 'int ar[] = {1, 2, 3};'.
            // Worst case: 'const int (&arref)[] = {1, 2, 3};'.
            if (Native.$bool(ResultType)
               && ResultType./*->*/$star().getNonReferenceType().$arrow().isIncompleteArrayType()) {
              if ((ResultType.$star()).$arrow().isRValueReferenceType()) {
                Ty.$assignMove(S.Context.getRValueReferenceType(new QualType(Ty)));
              } else if ((ResultType.$star()).$arrow().isLValueReferenceType()) {
                Ty.$assignMove(S.Context.getLValueReferenceType(new QualType(Ty), 
                        (ResultType.$star()).$arrow().getAs(LValueReferenceType.class).isSpelledAsLValue()));
              }
              ResultType.$star().$assign(Ty);
            }
            
            InitListExpr /*P*/ StructuredInitList = PerformInitList.getFullyStructuredList();
            CurInit.get();
            CurInit.$assignMove(shouldBindAsTemporary(InitEntity) ? S.MaybeBindToTemporary(StructuredInitList) : new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, StructuredInitList));
            break;
          } finally {
            if (PerformInitList != null) { PerformInitList.$destroy(); }
          }
        }
       case SK_ConstructorInitializationFromList:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // When an initializer list is passed for a parameter of type "reference
            // to object", we don't get an EK_Temporary entity, but instead an
            // EK_Parameter entity with reference type.
            // FIXME: This is a hack. What we really should do is create a user
            // conversion step for this case, but this makes it considerably more
            // complicated. For now, this will do.
            InitializedEntity TempEntity = InitializedEntity.InitializeTemporary(Entity.getType().getNonReferenceType());
            boolean UseTemporary = Entity.getType().$arrow().isReferenceType();
            assert (Args.size() == 1) : "expected a single argument for list init";
            InitListExpr /*P*/ InitList = cast_InitListExpr(Args.$at(0));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(InitList.getExprLoc(), diag.warn_cxx98_compat_ctor_list_init)), 
                InitList.getSourceRange()));
            MutableArrayRef<Expr /*P*/ > Arg/*J*/= new MutableArrayRef<Expr /*P*/ >(InitList.getInits(), InitList.getNumInits(), true);
            CurInit.$assignMove(PerformConstructorInitialization(S, UseTemporary ? TempEntity : Entity, 
                    Kind, new MutableArrayRef<Expr /*P*/ >(Arg), Step.$star(), 
                    ConstructorInitRequiresZeroInit, 
                    /*IsListInitialization*/ true, 
                    /*IsStdInitListInit*/ false, 
                    InitList.getLBraceLoc(), 
                    InitList.getRBraceLoc()));
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case SK_UnwrapInitList:
        CurInit.$assign(cast_InitListExpr(CurInit.get()).getInit(0));
        break;
       case SK_RewrapInitList:
        {
          Expr /*P*/ E = CurInit.get();
          InitListExpr /*P*/ Syntactic = Step./*->*/$star().Unnamed_field2.WrappingSyntacticList;
          InitListExpr /*P*/ ILE = /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new InitListExpr(S.Context, 
              Syntactic.getLBraceLoc(), new ArrayRef<Expr /*P*/ >(E, true), Syntactic.getRBraceLoc()));
          ILE.setSyntacticForm(Syntactic);
          ILE.setType(E.getType());
          ILE.setValueKind(E.getValueKind());
          CurInit.$assign(ILE);
          break;
        }
       case SK_ConstructorInitialization:
       case SK_StdInitializerListConstructorCall:
        {
          // When an initializer list is passed for a parameter of type "reference
          // to object", we don't get an EK_Temporary entity, but instead an
          // EK_Parameter entity with reference type.
          // FIXME: This is a hack. What we really should do is create a user
          // conversion step for this case, but this makes it considerably more
          // complicated. For now, this will do.
          InitializedEntity TempEntity = InitializedEntity.InitializeTemporary(Entity.getType().getNonReferenceType());
          boolean UseTemporary = Entity.getType().$arrow().isReferenceType();
          boolean IsStdInitListInit = Step./*->*/$star().Kind == StepKind.SK_StdInitializerListConstructorCall;
          CurInit.$assignMove(PerformConstructorInitialization(S, UseTemporary ? TempEntity : Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Args), Step.$star(), 
                  ConstructorInitRequiresZeroInit, 
                  /*IsListInitialization*/ IsStdInitListInit, 
                  /*IsStdInitListInitialization*/ IsStdInitListInit, 
                  /*LBraceLoc*/ new SourceLocation(), 
                  /*RBraceLoc*/ new SourceLocation()));
          break;
        }
       case SK_ZeroInitialization:
        {
          type$ptr<Step> NextStep = $tryClone(Step);
          NextStep.$preInc();
          if ($noteq_ptr(NextStep, StepEnd)
             && (NextStep./*->*/$star().Kind == StepKind.SK_ConstructorInitialization
             || NextStep./*->*/$star().Kind == StepKind.SK_ConstructorInitializationFromList)) {
            // The need for zero-initialization is recorded directly into
            // the call to the object's constructor within the next step.
            ConstructorInitRequiresZeroInit.$set(true);
          } else if (Kind.getKind() == InitializationKind.InitKind.IK_Value
             && S.getLangOpts().CPlusPlus
             && !Kind.isImplicitValueInit()) {
            TypeSourceInfo /*P*/ TSInfo = Entity.getTypeSourceInfo();
            if (!(TSInfo != null)) {
              TSInfo = S.Context.getTrivialTypeSourceInfo(new QualType(Step./*->*/$star().Type), 
                  Kind.getRange().getBegin());
            }
            
            final TypeSourceInfo /*P*/ L$TSInfo = TSInfo;
            CurInit.$assign(/*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new CXXScalarValueInitExpr(L$TSInfo.getType().getNonLValueExprType(S.Context), L$TSInfo, 
                    Kind.getRange().getEnd())));
          } else {
            CurInit.$assign(/*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new ImplicitValueInitExpr(new QualType(Step./*->*/$star().Type))));
          }
          break;
        }
       case SK_CAssignment:
        {
          QualType SourceType$1 = CurInit.get().getType();
          // Save off the initial CurInit in case we need to emit a diagnostic
          ActionResultTTrue<Expr /*P*/ > InitialCurInit = new ActionResultTTrue<Expr /*P*/ >(CurInit);
          ActionResultTTrue<Expr /*P*/ > Result = new ActionResultTTrue<Expr /*P*/ >(CurInit);
          Sema.AssignConvertType ConvTy = S.CheckSingleAssignmentConstraints(new QualType(Step./*->*/$star().Type), Result, true, 
              Entity.getKind() == InitializedEntity.EntityKind.EK_Parameter_CF_Audited);
          if (Result.isInvalid()) {
            return ExprError();
          }
          CurInit.$assign(Result);
          
          // If this is a call, allow conversion to a transparent union.
          ActionResultTTrue<Expr /*P*/ > CurInitExprRes = new ActionResultTTrue<Expr /*P*/ >(CurInit);
          if (ConvTy != Sema.AssignConvertType.Compatible
             && Entity.isParameterKind()
             && S.CheckTransparentUnionArgumentConstraints(new QualType(Step./*->*/$star().Type), CurInitExprRes)
             == Sema.AssignConvertType.Compatible) {
            ConvTy = Sema.AssignConvertType.Compatible;
          }
          if (CurInitExprRes.isInvalid()) {
            return ExprError();
          }
          CurInit.$assign(CurInitExprRes);
          
          bool$ptr Complained = create_bool$ptr();
          if (S.DiagnoseAssignmentResult(ConvTy, Kind.getLocation(), 
              new QualType(Step./*->*/$star().Type), new QualType(SourceType$1), 
              InitialCurInit.get(), 
              getAssignmentAction(Entity, true), 
              $AddrOf(Complained))) {
            PrintInitLocationNote(S, Entity);
            return ExprError();
          } else if (Complained.$star()) {
            PrintInitLocationNote(S, Entity);
          }
          break;
        }
       case SK_StringInit:
        {
          QualType Ty = new QualType(Step./*->*/$star().Type);
          CheckStringInit(CurInit.get(), Native.$bool(ResultType) ? ResultType.$star() : Ty, 
              S.Context.getAsArrayType(new QualType(Ty)), S);
          break;
        }
       case SK_ObjCObjectConversion:
        CurInit.$assignMove(S.ImpCastExprToType(CurInit.get(), new QualType(Step./*->*/$star().Type), 
                CastKind.CK_ObjCObjectLValueCast, 
                CurInit.get().getValueKind()));
        break;
       case SK_ArrayInit:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Okay: we checked everything before creating this step. Note that
            // this is a GNU extension.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.ext_array_init_copy)), 
                        Step./*->*/$star().Type), CurInit.get().getType()), 
                CurInit.get().getSourceRange()));
            
            // If the destination type is an incomplete array type, update the
            // type accordingly.
            if (Native.$bool(ResultType)) {
              {
                /*const*/ IncompleteArrayType /*P*/ IncompleteDest = S.Context.getAsIncompleteArrayType(new QualType(Step./*->*/$star().Type));
                if ((IncompleteDest != null)) {
                  {
                    /*const*/ ConstantArrayType /*P*/ ConstantSource = S.Context.getAsConstantArrayType(CurInit.get().getType());
                    if ((ConstantSource != null)) {
                      ResultType.$star().$assignMove(S.Context.getConstantArrayType(IncompleteDest.getElementType(), 
                              ConstantSource.getSize(), 
                              ArrayType.ArraySizeModifier.Normal, 0));
                    }
                  }
                }
              }
            }
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case SK_ParenthesizedArrayInit:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Okay: we checked everything before creating this step. Note that
            // this is a GNU extension.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.ext_array_init_parens)), 
                CurInit.get().getSourceRange()));
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case SK_PassByIndirectCopyRestore:
       case SK_PassByIndirectRestore:
        checkIndirectCopyRestoreSource(S, CurInit.get());
        CurInit.$assign(/*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new ObjCIndirectCopyRestoreExpr(CurInit.get(), new QualType(Step./*->*/$star().Type), 
                Step./*->*/$star().Kind == StepKind.SK_PassByIndirectCopyRestore)));
        break;
       case SK_ProduceObjCObject:
        CurInit.$assign(
            ImplicitCastExpr.Create(S.Context, new QualType(Step./*->*/$star().Type), CastKind.CK_ARCProduceObject, 
                CurInit.get(), (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue)
        );
        break;
       case SK_StdInitializerList:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(CurInit.get().getExprLoc(), 
                    diag.warn_cxx98_compat_initializer_list_init)), 
                CurInit.get().getSourceRange()));
            
            // Materialize the temporary into memory.
            MaterializeTemporaryExpr /*P*/ MTE = S.CreateMaterializeTemporaryExpr(CurInit.get().getType(), CurInit.get(), 
                /*BoundToLvalueReference=*/ false);
            {
              
              // Maybe lifetime-extend the array temporary's subobjects to match the
              // entity's lifetime.
              /*const*/ InitializedEntity /*P*/ ExtendingEntity = getEntityForTemporaryLifetimeExtension($AddrOf(Entity));
              if ((ExtendingEntity != null)) {
                if (performReferenceExtension(MTE, ExtendingEntity)) {
                  warnOnLifetimeExtension(S, Entity, CurInit.get(), 
                      /*IsInitializerList=*/ true, 
                      ExtendingEntity.getDecl());
                }
              }
            }
            
            // Wrap it in a construction of a std::initializer_list<T>.
            CurInit.$assign(/*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new CXXStdInitializerListExpr(new QualType(Step./*->*/$star().Type), MTE)));
            
            // Bind the result, in case the library has given initializer_list a
            // non-trivial destructor.
            if (shouldBindAsTemporary(Entity)) {
              CurInit.$assignMove(S.MaybeBindToTemporary(CurInit.get()));
            }
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case SK_OCLSamplerInit:
        {
          assert (Step./*->*/$star().Type.$arrow().isSamplerT()) : "Sampler initialization on non-sampler type.";
          
          QualType SourceType$1 = CurInit.get().getType();
          if (Entity.isParameterKind()) {
            if (!SourceType$1.$arrow().isSamplerT()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_sampler_argument_required)), 
                    SourceType$1));
              } finally {
                $c$.$destroy();
              }
            }
          } else if (Entity.getKind() != InitializedEntity.EntityKind.EK_Variable) {
            throw new llvm_unreachable("Invalid EntityKind!");
          }
          
          break;
        }
       case SK_OCLZeroEvent:
        {
          assert (Step./*->*/$star().Type.$arrow().isEventT()) : "Event initialization on non-event type.";
          
          CurInit.$assignMove(S.ImpCastExprToType(CurInit.get(), new QualType(Step./*->*/$star().Type), 
                  CastKind.CK_ZeroToOCLEvent, 
                  CurInit.get().getValueKind()));
          break;
        }
      }
    }
    
    // Diagnose non-fatal problems with the completed initialization.
    if (Entity.getKind() == InitializedEntity.EntityKind.EK_Member
       && cast_FieldDecl(Entity.getDecl()).isBitField()) {
      S.CheckBitFieldInitialization(Kind.getLocation(), 
          cast_FieldDecl(Entity.getDecl()), 
          CurInit.get());
    }
    {
      
      // Check for std::move on construction.
      /*const*/ Expr /*P*/ E = CurInit.get();
      if ((E != null)) {
        CheckMoveOnConstruction(S, E, 
            Entity.getKind() == InitializedEntity.EntityKind.EK_Result);
      }
    }
    
    return CurInit;
  }

  
  /// \brief Diagnose an potentially-invalid initialization sequence.
  ///
  /// \returns true if the initialization sequence was ill-formed, 
  /// false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Diagnose">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 7044,
   FQN="clang::InitializationSequence::Diagnose", NM="_ZN5clang22InitializationSequence8DiagnoseERNS_4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence8DiagnoseERNS_4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  public boolean Diagnose(final Sema /*&*/ S, 
          final /*const*/ InitializedEntity /*&*/ Entity, 
          final /*const*/ InitializationKind /*&*/ Kind, 
          ArrayRef<Expr /*P*/ > Args) {
    if (!Failed()) {
      return false;
    }
    
    QualType DestType = Entity.getType();
    switch (Failure) {
     case FK_TooManyInitsForReference:
      // FIXME: Customize for the initialized entity?
      if (Args.empty()) {
        // Dig out the reference subobject which is uninitialized and diagnose it.
        // If this is value-initialization, this could be nested some way within
        // the target type.
        assert (Kind.getKind() == InitializationKind.InitKind.IK_Value || DestType.$arrow().isReferenceType());
        boolean Diagnosed = DiagnoseUninitializedReference(S, Kind.getLocation(), new QualType(DestType));
        assert (Diagnosed) : "couldn't find uninitialized reference to diagnose";
        /*J:(void)*//*Diagnosed;*/
      } else { // FIXME: diagnostic below could be better!
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_reference_has_multiple_inits)), 
              new SourceRange(Args.front().getLocStart(), Args.back().getLocEnd())));
        } finally {
          $c$.$destroy();
        }
      }
      break;
     case FK_ArrayNeedsInitList:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_array_init_not_init_list)), 0));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case FK_ArrayNeedsInitListOrStringLiteral:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_array_init_not_init_list)), 1));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case FK_ArrayNeedsInitListOrWideStringLiteral:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_array_init_not_init_list)), 2));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case FK_NarrowStringIntoWideCharArray:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(Kind.getLocation(), diag.err_array_init_narrow_string_into_wchar)));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case FK_WideStringIntoCharArray:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(Kind.getLocation(), diag.err_array_init_wide_string_into_char)));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case FK_IncompatWideStringIntoWideChar:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(Kind.getLocation(), 
              diag.err_array_init_incompat_wide_string_into_wchar)));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case FK_ArrayTypeMismatch:
     case FK_NonConstantArrayInit:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), 
                          (Failure == FailureKind.FK_ArrayTypeMismatch ? diag.err_array_init_different_type : diag.err_array_init_non_constant_array))), 
                      DestType.getNonReferenceType()), 
                  Args.$at(0).getType()), 
              Args.$at(0).getSourceRange()));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case FK_VariableLengthArrayHasInitializer:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_variable_object_no_init)), 
              Args.$at(0).getSourceRange()));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case FK_AddressOfOverloadFailed:
      {
        DeclAccessPair Found/*J*/= new DeclAccessPair();
        S.ResolveAddressOfOverloadedFunction(Args.$at(0), 
            DestType.getNonReferenceType(), 
            true, 
            Found);
        break;
      }
     case FK_AddressOfUnaddressableFunction:
      {
        FunctionDecl /*P*/ FD = cast_FunctionDecl(cast_DeclRefExpr(Args.$at(0)).getDecl());
        S.checkAddressOfFunctionIsAvailable(FD, /*Complain=*/ true, 
            Args.$at(0).getLocStart());
        break;
      }
     case FK_ReferenceInitOverloadFailed:
     case FK_UserConversionOverloadFailed:
      switch (FailedOverloadResult) {
       case OR_Ambiguous:
        if (Failure == FailureKind.FK_UserConversionOverloadFailed) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_typecheck_ambiguous_condition)), 
                        Args.$at(0).getType()), DestType), 
                Args.$at(0).getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_ref_init_ambiguous)), 
                        DestType), Args.$at(0).getType()), 
                Args.$at(0).getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
        
        FailedCandidateSet.NoteCandidates(S, OverloadCandidateDisplayKind.OCD_ViableCandidates, new ArrayRef<Expr /*P*/ >(Args));
        break;
       case OR_No_Viable_Function:
        if (!S.RequireCompleteType$T(Kind.getLocation(), 
            DestType.getNonReferenceType(), 
            diag.err_typecheck_nonviable_condition_incomplete, 
            Args.$at(0).getType(), Args.$at(0).getSourceRange())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_typecheck_nonviable_condition)), 
                            (Entity.getKind() == InitializedEntity.EntityKind.EK_Result)), 
                        Args.$at(0).getType()), Args.$at(0).getSourceRange()), 
                DestType.getNonReferenceType()));
          } finally {
            $c$.$destroy();
          }
        }
        
        FailedCandidateSet.NoteCandidates(S, OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args));
        break;
       case OR_Deleted:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_typecheck_deleted_function)), 
                        Args.$at(0).getType()), DestType.getNonReferenceType()), 
                Args.$at(0).getSourceRange()));
            final type$ptr<OverloadCandidate> Best = create_type$ptr();
            OverloadingResult Ovl = FailedCandidateSet.BestViableFunction(S, Kind.getLocation(), Best, 
                true);
            if (Ovl == OverloadingResult.OR_Deleted) {
              S.NoteDeletedFunction(Best./*->*/$star().Function);
            } else {
              throw new llvm_unreachable("Inconsistent overload resolution?");
            }
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case OR_Success:
        throw new llvm_unreachable("Conversion did not fail!");
      }
      break;
     case FK_NonConstLValueReferenceBindingToTemporary:
      if (isa_InitListExpr(Args.$at(0))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), 
                          diag.err_lvalue_reference_bind_to_initlist)), 
                      DestType.getNonReferenceType().isVolatileQualified()), 
                  DestType.getNonReferenceType()), 
              Args.$at(0).getSourceRange()));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case FK_NonConstLValueReferenceBindingToUnrelated:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Intentional fallthrough
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), 
                              Failure == FailureKind.FK_NonConstLValueReferenceBindingToTemporary ? diag.err_lvalue_reference_bind_to_temporary : diag.err_lvalue_reference_bind_to_unrelated)), 
                          DestType.getNonReferenceType().isVolatileQualified()), 
                      DestType.getNonReferenceType()), 
                  Args.$at(0).getType()), 
              Args.$at(0).getSourceRange()));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case FK_RValueReferenceBindingToLValue:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_lvalue_to_rvalue_ref)), 
                      DestType.getNonReferenceType()), Args.$at(0).getType()), 
              Args.$at(0).getSourceRange()));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case FK_ReferenceInitDropsQualifiers:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          QualType SourceType = Args.$at(0).getType();
          QualType NonRefType = DestType.getNonReferenceType();
          Qualifiers DroppedQualifiers = $sub_Qualifiers(SourceType.getQualifiers(), NonRefType.getQualifiers());
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_reference_bind_drops_quals)), 
                          SourceType), 
                      NonRefType), 
                  DroppedQualifiers.getCVRQualifiers()), 
              Args.$at(0).getSourceRange()));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case FK_ReferenceInitFailed:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_reference_bind_failed)), 
                          DestType.getNonReferenceType()), 
                      Args.$at(0).isLValue()), 
                  Args.$at(0).getType()), 
              Args.$at(0).getSourceRange()));
          emitBadConversionNotes(S, Entity, Args.$at(0));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case FK_ConversionFailed:
      {
        PartialDiagnostic PDiag = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          QualType FromType = Args.$at(0).getType();
          /*FIXME: Initializer produces not destroyed temporary!*/PDiag = $c$.clean(new PartialDiagnostic($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_int($c$.track(S.PDiag(diag.err_init_conversion_failed)), 
                                  (int)Entity.getKind().getValue()), 
                              /*NO_COPY*/DestType), 
                          (Args.$at(0).isLValue() ? 1 : 0)), 
                      /*NO_COPY*/FromType), 
                  Args.$at(0).getSourceRange())));
          S.HandleFunctionTypeMismatch(PDiag, new QualType(FromType), new QualType(DestType));
          $c$.clean($c$.track(S.Diag(Kind.getLocation(), PDiag)));
          emitBadConversionNotes(S, Entity, Args.$at(0));
          break;
        } finally {
          if (PDiag != null) { PDiag.$destroy(); }
          $c$.$destroy();
        }
      }
     case FK_ConversionFromPropertyFailed:
      // No-op. This error has already been reported.
      break;
     case FK_TooManyInitsForScalar:
      {
        SourceRange R/*J*/= new SourceRange();
        
        InitListExpr /*P*/ InitList = dyn_cast_InitListExpr(Args.$at(0));
        if ((InitList != null) && $greatereq_uint(InitList.getNumInits(), 1)) {
          R.$assignMove(new SourceRange(InitList.getInit(0).getLocEnd(), InitList.getLocEnd()));
        } else {
          assert ($greater_uint(Args.size(), 1)) : "Expected multiple initializers!";
          R.$assignMove(new SourceRange(Args.front().getLocEnd(), Args.back().getLocEnd()));
        }
        
        R.setBegin(S.getLocForEndOfToken(R.getBegin()));
        if (Kind.isCStyleOrFunctionalCast()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_builtin_func_cast_more_than_one_arg)), 
                R));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_excess_initializers)), 
                    /*scalar=*/ 2), R));
          } finally {
            $c$.$destroy();
          }
        }
        break;
      }
     case FK_ReferenceBindingToInitList:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_reference_bind_init_list)), 
                  DestType.getNonReferenceType()), Args.$at(0).getSourceRange()));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case FK_InitListBadDestinationType:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_init_list_bad_dest_type)), 
                      (DestType.$arrow().isRecordType())), DestType), Args.$at(0).getSourceRange()));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case FK_ListConstructorOverloadFailed:
     case FK_ConstructorOverloadFailed:
      {
        SourceRange ArgsRange/*J*/= new SourceRange();
        if ((Args.size() != 0)) {
          ArgsRange.$assignMove(new SourceRange(Args.front().getLocStart(), 
                  Args.back().getLocEnd()));
        }
        if (Failure == FailureKind.FK_ListConstructorOverloadFailed) {
          assert (Args.size() == 1) : "List construction from other than 1 argument.";
          InitListExpr /*P*/ InitList = cast_InitListExpr(Args.$at(0));
          Args.$assignMove(new MutableArrayRef<Expr /*P*/ >(InitList.getInits(), InitList.getNumInits(), true));
        }
        
        // FIXME: Using "DestType" for the entity we're printing is probably
        // bad.
        switch (FailedOverloadResult) {
         case OR_Ambiguous:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_ovl_ambiguous_init)), 
                      DestType), ArgsRange));
              FailedCandidateSet.NoteCandidates(S, OverloadCandidateDisplayKind.OCD_ViableCandidates, new ArrayRef<Expr /*P*/ >(Args));
              break;
            } finally {
              $c$.$destroy();
            }
          }
         case OR_No_Viable_Function:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              if (Kind.getKind() == InitializationKind.InitKind.IK_Default
                 && (Entity.getKind() == InitializedEntity.EntityKind.EK_Base
                 || Entity.getKind() == InitializedEntity.EntityKind.EK_Member)
                 && isa_CXXConstructorDecl(S.CurContext)) {
                // This is implicit default initialization of a member or
                // base within a constructor. If no viable function was
                // found, notify the user that they need to explicitly
                // initialize this base/member.
                CXXConstructorDecl /*P*/ Constructor = cast_CXXConstructorDecl(S.CurContext);
                /*const*/ CXXRecordDecl /*P*/ InheritedFrom = null;
                {
                  InheritedConstructor Inherited = Constructor.getInheritedConstructor();
                  if (Inherited.$bool()) {
                    InheritedFrom = Inherited.getShadowDecl().getNominatedBaseClass();
                  }
                }
                if (Entity.getKind() == InitializedEntity.EntityKind.EK_Base) {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_missing_default_ctor)), 
                                      ((InheritedFrom != null) ? 2 : Constructor.isImplicit() ? 1 : 0)), 
                                  S.Context.getTypeDeclType(Constructor.getParent())), 
                              /*base=*/ 0), 
                          Entity.getType()), 
                      InheritedFrom));
                  
                  RecordDecl /*P*/ BaseDecl = Entity.getBaseSpecifier().getType().$arrow().<RecordType>getAs$RecordType().
                      getDecl();
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(BaseDecl.getLocation(), diag.note_previous_decl)), 
                      S.Context.getTagDeclType(BaseDecl)));
                } else {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_missing_default_ctor)), 
                                      ((InheritedFrom != null) ? 2 : Constructor.isImplicit() ? 1 : 0)), 
                                  S.Context.getTypeDeclType(Constructor.getParent())), 
                              /*member=*/ 1), 
                          Entity.getName()), 
                      InheritedFrom));
                  $c$.clean($c$.track(S.Diag(Entity.getDecl().getLocation(), 
                      diag.note_member_declared_at)));
                  {
                    
                    /*const*/ RecordType /*P*/ Record = Entity.getType().$arrow().<RecordType>getAs$RecordType();
                    if ((Record != null)) {
                      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Record.getDecl().getLocation(), 
                              diag.note_previous_decl)), 
                          S.Context.getTagDeclType(Record.getDecl())));
                    }
                  }
                }
                break;
              }
              
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_ovl_no_viable_function_in_init)), 
                      DestType), ArgsRange));
              FailedCandidateSet.NoteCandidates(S, OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args));
              break;
            } finally {
              $c$.$destroy();
            }
          }
         case OR_Deleted:
          {
            final type$ptr<OverloadCandidate> Best = create_type$ptr();
            OverloadingResult Ovl = FailedCandidateSet.BestViableFunction(S, Kind.getLocation(), Best);
            if (Ovl != OverloadingResult.OR_Deleted) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_ovl_deleted_init)), 
                            true), DestType), ArgsRange));
                throw new llvm_unreachable("Inconsistent overload resolution?");
//                break;
              } finally {
                $c$.$destroy();
              }
            }
            
            // If this is a defaulted or implicitly-declared function, then
            // it was implicitly deleted. Make it clear that the deletion was
            // implicit.
            if (S.isImplicitlyDeleted(Best./*->*/$star().Function)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_ovl_deleted_special_init)), 
                            S.getSpecialMember(cast_CXXMethodDecl(Best./*->*/$star().Function))), 
                        DestType), ArgsRange));
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_ovl_deleted_init)), 
                            true), DestType), ArgsRange));
              } finally {
                $c$.$destroy();
              }
            }
            
            S.NoteDeletedFunction(Best./*->*/$star().Function);
            break;
          }
         case OR_Success:
          throw new llvm_unreachable("Conversion did not fail!");
        }
      }
      break;
     case FK_DefaultInitOfConst:
      if (Entity.getKind() == InitializedEntity.EntityKind.EK_Member
         && isa_CXXConstructorDecl(S.CurContext)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // This is implicit default-initialization of a const member in
          // a constructor. Complain that it needs to be explicitly
          // initialized.
          CXXConstructorDecl /*P*/ Constructor = cast_CXXConstructorDecl(S.CurContext);
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_uninitialized_member_in_ctor)), 
                          (Constructor.getInheritedConstructor().$bool() ? 2 : Constructor.isImplicit() ? 1 : 0)), 
                      S.Context.getTypeDeclType(Constructor.getParent())), 
                  /*const=*/ 1), 
              Entity.getName()));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Entity.getDecl().getLocation(), diag.note_previous_decl)), 
              Entity.getName()));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_default_init_const)), 
                  DestType), (boolean)(DestType.$arrow().<RecordType>getAs$RecordType() != null)));
        } finally {
          $c$.$destroy();
        }
      }
      break;
     case FK_Incomplete:
      S.RequireCompleteType(Kind.getLocation(), new QualType(FailedIncompleteType), 
          diag.err_init_incomplete_type);
      break;
     case FK_ListInitializationFailed:
      {
        // Run the init list checker again to emit diagnostics.
        InitListExpr /*P*/ InitList = cast_InitListExpr(Args.$at(0));
        diagnoseListInit(S, Entity, InitList);
        break;
      }
     case FK_PlaceholderType:
      {
        // FIXME: Already diagnosed!
        break;
      }
     case FK_ExplicitConstructor:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Kind.getLocation(), diag.err_selected_explicit_constructor)), 
              Args.$at(0).getSourceRange()));
          final type$ptr<OverloadCandidate> Best = create_type$ptr();
          OverloadingResult Ovl = FailedCandidateSet.BestViableFunction(S, Kind.getLocation(), Best);
          /*J:(void)*//*Ovl;*/
          assert (Ovl == OverloadingResult.OR_Success) : "Inconsistent overload resolution";
          CXXConstructorDecl /*P*/ CtorDecl = cast_CXXConstructorDecl(Best./*->*/$star().Function);
          $c$.clean($c$.track(S.Diag(CtorDecl.getLocation(), diag.note_constructor_declared_here)));
          break;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    PrintInitLocationNote(S, Entity);
    return true;
  }

  
  /// \brief Determine the kind of initialization sequence computed.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 940,
   FQN="clang::InitializationSequence::getKind", NM="_ZNK5clang22InitializationSequence7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang22InitializationSequence7getKindEv")
  //</editor-fold>
  public  SequenceKind getKind() /*const*/ {
    return _SequenceKind;
  }

  
  /// \brief Set the kind of sequence computed.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::setSequenceKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 943,
   FQN="clang::InitializationSequence::setSequenceKind", NM="_ZN5clang22InitializationSequence15setSequenceKindENS0_12SequenceKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence15setSequenceKindENS0_12SequenceKindE")
  //</editor-fold>
  public void setSequenceKind( SequenceKind SK) {
    _SequenceKind = SK;
  }

  
  /// \brief Determine whether the initialization sequence is valid.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 946,
   FQN="clang::InitializationSequence::operator bool", NM="_ZNK5clang22InitializationSequencecvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang22InitializationSequencecvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return !Failed();
  }

  
  /// \brief Determine whether the initialization sequence is invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::Failed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 949,
   FQN="clang::InitializationSequence::Failed", NM="_ZNK5clang22InitializationSequence6FailedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang22InitializationSequence6FailedEv")
  //</editor-fold>
  public boolean Failed() /*const*/ {
    return _SequenceKind == SequenceKind.FailedSequence;
  }

  
  /*typedef SmallVectorImpl<Step>::const_iterator step_iterator*/
//  public final class step_iterator extends type$ptr<Step>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::step_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 952,
   FQN="clang::InitializationSequence::step_begin", NM="_ZNK5clang22InitializationSequence10step_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang22InitializationSequence10step_beginEv")
  //</editor-fold>
  public type$ptr<Step> step_begin() /*const*/ {
    return Steps.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::step_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 953,
   FQN="clang::InitializationSequence::step_end", NM="_ZNK5clang22InitializationSequence8step_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang22InitializationSequence8step_endEv")
  //</editor-fold>
  public type$ptr<Step> step_end() /*const*/ {
    return Steps.end$Const();
  }

  
  /*typedef llvm::iterator_range<step_iterator> step_range*/
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::steps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 956,
   FQN="clang::InitializationSequence::steps", NM="_ZNK5clang22InitializationSequence5stepsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang22InitializationSequence5stepsEv")
  //</editor-fold>
  public iterator_range<Step> steps() /*const*/ {
    return /*{ */new iterator_range<Step>(step_begin(), step_end())/* }*/;
  }

  
  /// \brief Determine whether this initialization is a direct reference 
  /// binding (C++ [dcl.init.ref]).
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::isDirectReferenceBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3067,
   FQN="clang::InitializationSequence::isDirectReferenceBinding", NM="_ZNK5clang22InitializationSequence24isDirectReferenceBindingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang22InitializationSequence24isDirectReferenceBindingEv")
  //</editor-fold>
  public boolean isDirectReferenceBinding() /*const*/ {
    return !Steps.empty() && Steps.back$Const().Kind == StepKind.SK_BindReference;
  }

  
  /// \brief Determine whether this initialization failed due to an ambiguity.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::isAmbiguous">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3071,
   FQN="clang::InitializationSequence::isAmbiguous", NM="_ZNK5clang22InitializationSequence11isAmbiguousEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang22InitializationSequence11isAmbiguousEv")
  //</editor-fold>
  public boolean isAmbiguous() /*const*/ {
    if (!Failed()) {
      return false;
    }
    switch (getFailureKind()) {
     case FK_TooManyInitsForReference:
     case FK_ArrayNeedsInitList:
     case FK_ArrayNeedsInitListOrStringLiteral:
     case FK_ArrayNeedsInitListOrWideStringLiteral:
     case FK_NarrowStringIntoWideCharArray:
     case FK_WideStringIntoCharArray:
     case FK_IncompatWideStringIntoWideChar:
     case FK_AddressOfOverloadFailed: // FIXME: Could do better
     case FK_NonConstLValueReferenceBindingToTemporary:
     case FK_NonConstLValueReferenceBindingToUnrelated:
     case FK_RValueReferenceBindingToLValue:
     case FK_ReferenceInitDropsQualifiers:
     case FK_ReferenceInitFailed:
     case FK_ConversionFailed:
     case FK_ConversionFromPropertyFailed:
     case FK_TooManyInitsForScalar:
     case FK_ReferenceBindingToInitList:
     case FK_InitListBadDestinationType:
     case FK_DefaultInitOfConst:
     case FK_Incomplete:
     case FK_ArrayTypeMismatch:
     case FK_NonConstantArrayInit:
     case FK_ListInitializationFailed:
     case FK_VariableLengthArrayHasInitializer:
     case FK_PlaceholderType:
     case FK_ExplicitConstructor:
     case FK_AddressOfUnaddressableFunction:
      return false;
     case FK_ReferenceInitOverloadFailed:
     case FK_UserConversionOverloadFailed:
     case FK_ConstructorOverloadFailed:
     case FK_ListConstructorOverloadFailed:
      return FailedOverloadResult == OverloadingResult.OR_Ambiguous;
    }
    throw new llvm_unreachable("Invalid EntityKind!");
  }

  
  /// \brief Determine whether this initialization is direct call to a 
  /// constructor.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::isConstructorInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3115,
   FQN="clang::InitializationSequence::isConstructorInitialization", NM="_ZNK5clang22InitializationSequence27isConstructorInitializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang22InitializationSequence27isConstructorInitializationEv")
  //</editor-fold>
  public boolean isConstructorInitialization() /*const*/ {
    return !Steps.empty() && Steps.back$Const().Kind == StepKind.SK_ConstructorInitialization;
  }

  
  /// \brief Returns whether the last step in this initialization sequence is a
  /// narrowing conversion, defined by C++0x [dcl.init.list]p7.
  ///
  /// If this function returns true, *isInitializerConstant will be set to
  /// describe whether *Initializer was a constant expression.  If
  /// *isInitializerConstant is set to true, *ConstantValue will be set to the
  /// evaluated value of *Initializer.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::endsWithNarrowing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 976,
   FQN="clang::InitializationSequence::endsWithNarrowing", NM="_ZNK5clang22InitializationSequence17endsWithNarrowingERNS_10ASTContextEPKNS_4ExprEPbPNS_7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang22InitializationSequence17endsWithNarrowingERNS_10ASTContextEPKNS_4ExprEPbPNS_7APValueE")
  //</editor-fold>
  public boolean endsWithNarrowing(final ASTContext /*&*/ Ctx, /*const*/ Expr /*P*/ Initializer, 
                   bool$ptr/*bool P*/ isInitializerConstant, 
                   APValue /*P*/ ConstantValue) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  /// \brief Add a new step in the initialization that resolves the address
  /// of an overloaded function to a specific function declaration.
  ///
  /// \param Function the function to which the overloaded function reference
  /// resolves.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddAddressOverloadResolutionStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3119,
   FQN="clang::InitializationSequence::AddAddressOverloadResolutionStep", NM="_ZN5clang22InitializationSequence32AddAddressOverloadResolutionStepEPNS_12FunctionDeclENS_14DeclAccessPairEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence32AddAddressOverloadResolutionStepEPNS_12FunctionDeclENS_14DeclAccessPairEb")
  //</editor-fold>
  public void AddAddressOverloadResolutionStep(FunctionDecl /*P*/ Function, 
                                  DeclAccessPair Found, 
                                  boolean HadMultipleCandidates) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_ResolveAddressOfOverloadedFunction;
    S.Type.$assignMove(Function.getType());
    S.Unnamed_field2.Function.HadMultipleCandidates = HadMultipleCandidates;
    S.Unnamed_field2.Function.Function = Function;
    S.Unnamed_field2.Function.FoundDecl.$assign(Found);
    Steps.push_back(S);
  }

  
  /// \brief Add a new step in the initialization that performs a derived-to-
  /// base cast.
  ///
  /// \param BaseType the base type to which we will be casting.
  ///
  /// \param Category Indicates whether the result will be treated as an
  /// rvalue, an xvalue, or an lvalue.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddDerivedToBaseCastStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3133,
   FQN="clang::InitializationSequence::AddDerivedToBaseCastStep", NM="_ZN5clang22InitializationSequence24AddDerivedToBaseCastStepENS_8QualTypeENS_13ExprValueKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence24AddDerivedToBaseCastStepENS_8QualTypeENS_13ExprValueKindE")
  //</editor-fold>
  public void AddDerivedToBaseCastStep(QualType BaseType, 
                          ExprValueKind VK) {
    Step S/*J*/= new Step();
    switch (VK) {
     case VK_RValue:
      S.Kind = StepKind.SK_CastDerivedToBaseRValue;
      break;
     case VK_XValue:
      S.Kind = StepKind.SK_CastDerivedToBaseXValue;
      break;
     case VK_LValue:
      S.Kind = StepKind.SK_CastDerivedToBaseLValue;
      break;
    }
    S.Type.$assign(BaseType);
    Steps.push_back(S);
  }

  
  /// \brief Add a new step binding a reference to an object.
  ///
  /// \param BindingTemporary True if we are binding a reference to a temporary
  /// object (thereby extending its lifetime); false if we are binding to an
  /// lvalue or an lvalue treated as an rvalue.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddReferenceBindingStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3145,
   FQN="clang::InitializationSequence::AddReferenceBindingStep", NM="_ZN5clang22InitializationSequence23AddReferenceBindingStepENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence23AddReferenceBindingStepENS_8QualTypeEb")
  //</editor-fold>
  public void AddReferenceBindingStep(QualType T, 
                         boolean BindingTemporary) {
    Step S/*J*/= new Step();
    S.Kind = BindingTemporary ? StepKind.SK_BindReferenceToTemporary : StepKind.SK_BindReference;
    S.Type.$assign(T);
    Steps.push_back(S);
  }

  
  /// \brief Add a new step that makes an extraneous copy of the input
  /// to a temporary of the same class type.
  ///
  /// This extraneous copy only occurs during reference binding in
  /// C++98/03, where we are permitted (but not required) to introduce
  /// an extra copy. At a bare minimum, we must check that we could
  /// call the copy constructor, and produce a diagnostic if the copy
  /// constructor is inaccessible or no copy constructor matches.
  //
  /// \param T The type of the temporary being created.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddExtraneousCopyToTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3153,
   FQN="clang::InitializationSequence::AddExtraneousCopyToTemporary", NM="_ZN5clang22InitializationSequence28AddExtraneousCopyToTemporaryENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence28AddExtraneousCopyToTemporaryENS_8QualTypeE")
  //</editor-fold>
  public void AddExtraneousCopyToTemporary(QualType T) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_ExtraneousCopyToTemporary;
    S.Type.$assign(T);
    Steps.push_back(S);
  }

  
  /// \brief Add a new step invoking a conversion function, which is either
  /// a constructor or a conversion function.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddUserConversionStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3160,
   FQN="clang::InitializationSequence::AddUserConversionStep", NM="_ZN5clang22InitializationSequence21AddUserConversionStepEPNS_12FunctionDeclENS_14DeclAccessPairENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence21AddUserConversionStepEPNS_12FunctionDeclENS_14DeclAccessPairENS_8QualTypeEb")
  //</editor-fold>
  public void AddUserConversionStep(FunctionDecl /*P*/ Function, 
                       DeclAccessPair FoundDecl, 
                       QualType T, 
                       boolean HadMultipleCandidates) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_UserConversion;
    S.Type.$assign(T);
    S.Unnamed_field2.Function.HadMultipleCandidates = HadMultipleCandidates;
    S.Unnamed_field2.Function.Function = Function;
    S.Unnamed_field2.Function.FoundDecl.$assign(FoundDecl);
    Steps.push_back(S);
  }

  
  /// \brief Add a new step that performs a qualification conversion to the
  /// given type.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddQualificationConversionStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3174,
   FQN="clang::InitializationSequence::AddQualificationConversionStep", NM="_ZN5clang22InitializationSequence30AddQualificationConversionStepENS_8QualTypeENS_13ExprValueKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence30AddQualificationConversionStepENS_8QualTypeENS_13ExprValueKindE")
  //</editor-fold>
  public void AddQualificationConversionStep(QualType Ty, 
                                ExprValueKind VK) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_QualificationConversionRValue; // work around a gcc warning
    switch (VK) {
     case VK_RValue:
      S.Kind = StepKind.SK_QualificationConversionRValue;
      break;
     case VK_XValue:
      S.Kind = StepKind.SK_QualificationConversionXValue;
      break;
     case VK_LValue:
      S.Kind = StepKind.SK_QualificationConversionLValue;
      break;
    }
    S.Type.$assign(Ty);
    Steps.push_back(S);
  }

  
  /// \brief Add a new step that performs conversion from non-atomic to atomic
  /// type.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddAtomicConversionStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3193,
   FQN="clang::InitializationSequence::AddAtomicConversionStep", NM="_ZN5clang22InitializationSequence23AddAtomicConversionStepENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence23AddAtomicConversionStepENS_8QualTypeE")
  //</editor-fold>
  public void AddAtomicConversionStep(QualType Ty) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_AtomicConversion;
    S.Type.$assign(Ty);
    Steps.push_back(S);
  }

  
  /// \brief Add a new step that performs a load of the given type.
  ///
  /// Although the term "LValueToRValue" is conventional, this applies to both
  /// lvalues and xvalues.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddLValueToRValueStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3200,
   FQN="clang::InitializationSequence::AddLValueToRValueStep", NM="_ZN5clang22InitializationSequence21AddLValueToRValueStepENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence21AddLValueToRValueStepENS_8QualTypeE")
  //</editor-fold>
  public void AddLValueToRValueStep(QualType Ty) {
    assert (!Ty.hasQualifiers()) : "rvalues may not have qualifiers";
    
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_LValueToRValue;
    S.Type.$assign(Ty);
    Steps.push_back(S);
  }

  
  /// \brief Add a new step that applies an implicit conversion sequence.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddConversionSequenceStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3209,
   FQN="clang::InitializationSequence::AddConversionSequenceStep", NM="_ZN5clang22InitializationSequence25AddConversionSequenceStepERKNS_26ImplicitConversionSequenceENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence25AddConversionSequenceStepERKNS_26ImplicitConversionSequenceENS_8QualTypeEb")
  //</editor-fold>
  public void AddConversionSequenceStep(final /*const*/ ImplicitConversionSequence /*&*/ ICS, QualType T) {
    AddConversionSequenceStep(ICS, T, 
                           false);
  }
  public void AddConversionSequenceStep(final /*const*/ ImplicitConversionSequence /*&*/ ICS, QualType T, 
                           boolean TopLevelOfInitList/*= false*/) {
    Step S/*J*/= new Step();
    S.Kind = TopLevelOfInitList ? StepKind.SK_ConversionSequenceNoNarrowing : StepKind.SK_ConversionSequence;
    S.Type.$assign(T);
    S.Unnamed_field2.ICS = new ImplicitConversionSequence(ICS);
    Steps.push_back(S);
  }

  
  /// \brief Add a list-initialization step.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddListInitializationStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3220,
   FQN="clang::InitializationSequence::AddListInitializationStep", NM="_ZN5clang22InitializationSequence25AddListInitializationStepENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence25AddListInitializationStepENS_8QualTypeE")
  //</editor-fold>
  public void AddListInitializationStep(QualType T) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_ListInitialization;
    S.Type.$assign(T);
    Steps.push_back(S);
  }

  
  /// \brief Add a constructor-initialization step.
  ///
  /// \param FromInitList The constructor call is syntactically an initializer
  /// list.
  /// \param AsInitList The constructor is called as an init list constructor.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddConstructorInitializationStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3227,
   FQN="clang::InitializationSequence::AddConstructorInitializationStep", NM="_ZN5clang22InitializationSequence32AddConstructorInitializationStepENS_14DeclAccessPairEPNS_18CXXConstructorDeclENS_8QualTypeEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence32AddConstructorInitializationStepENS_14DeclAccessPairEPNS_18CXXConstructorDeclENS_8QualTypeEbbb")
  //</editor-fold>
  public void AddConstructorInitializationStep(DeclAccessPair FoundDecl, CXXConstructorDecl /*P*/ Constructor, QualType T, 
                                  boolean HadMultipleCandidates, boolean FromInitList, boolean AsInitList) {
    Step S/*J*/= new Step();
    S.Kind = FromInitList ? AsInitList ? StepKind.SK_StdInitializerListConstructorCall : StepKind.SK_ConstructorInitializationFromList : StepKind.SK_ConstructorInitialization;
    S.Type.$assign(T);
    S.Unnamed_field2.Function.HadMultipleCandidates = HadMultipleCandidates;
    S.Unnamed_field2.Function.Function = Constructor;
    S.Unnamed_field2.Function.FoundDecl.$assign(FoundDecl);
    Steps.push_back(S);
  }

  
  /// \brief Add a zero-initialization step.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddZeroInitializationStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3241,
   FQN="clang::InitializationSequence::AddZeroInitializationStep", NM="_ZN5clang22InitializationSequence25AddZeroInitializationStepENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence25AddZeroInitializationStepENS_8QualTypeE")
  //</editor-fold>
  public void AddZeroInitializationStep(QualType T) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_ZeroInitialization;
    S.Type.$assign(T);
    Steps.push_back(S);
  }

  
  /// \brief Add a C assignment step.
  //
  // FIXME: It isn't clear whether this should ever be needed;
  // ideally, we would handle everything needed in C in the common
  // path. However, that isn't the case yet.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddCAssignmentStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3248,
   FQN="clang::InitializationSequence::AddCAssignmentStep", NM="_ZN5clang22InitializationSequence18AddCAssignmentStepENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence18AddCAssignmentStepENS_8QualTypeE")
  //</editor-fold>
  public void AddCAssignmentStep(QualType T) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_CAssignment;
    S.Type.$assign(T);
    Steps.push_back(S);
  }

  
  /// \brief Add a string init step.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddStringInitStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3255,
   FQN="clang::InitializationSequence::AddStringInitStep", NM="_ZN5clang22InitializationSequence17AddStringInitStepENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence17AddStringInitStepENS_8QualTypeE")
  //</editor-fold>
  public void AddStringInitStep(QualType T) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_StringInit;
    S.Type.$assign(T);
    Steps.push_back(S);
  }

  
  /// \brief Add an Objective-C object conversion step, which is
  /// always a no-op.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddObjCObjectConversionStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3262,
   FQN="clang::InitializationSequence::AddObjCObjectConversionStep", NM="_ZN5clang22InitializationSequence27AddObjCObjectConversionStepENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence27AddObjCObjectConversionStepENS_8QualTypeE")
  //</editor-fold>
  public void AddObjCObjectConversionStep(QualType T) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_ObjCObjectConversion;
    S.Type.$assign(T);
    Steps.push_back(S);
  }

  
  /// \brief Add an array initialization step.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddArrayInitStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3269,
   FQN="clang::InitializationSequence::AddArrayInitStep", NM="_ZN5clang22InitializationSequence16AddArrayInitStepENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence16AddArrayInitStepENS_8QualTypeE")
  //</editor-fold>
  public void AddArrayInitStep(QualType T) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_ArrayInit;
    S.Type.$assign(T);
    Steps.push_back(S);
  }

  
  /// \brief Add a parenthesized array initialization step.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddParenthesizedArrayInitStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3276,
   FQN="clang::InitializationSequence::AddParenthesizedArrayInitStep", NM="_ZN5clang22InitializationSequence29AddParenthesizedArrayInitStepENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence29AddParenthesizedArrayInitStepENS_8QualTypeE")
  //</editor-fold>
  public void AddParenthesizedArrayInitStep(QualType T) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_ParenthesizedArrayInit;
    S.Type.$assign(T);
    Steps.push_back(S);
  }

  
  /// \brief Add a step to pass an object by indirect copy-restore.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddPassByIndirectCopyRestoreStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3283,
   FQN="clang::InitializationSequence::AddPassByIndirectCopyRestoreStep", NM="_ZN5clang22InitializationSequence32AddPassByIndirectCopyRestoreStepENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence32AddPassByIndirectCopyRestoreStepENS_8QualTypeEb")
  //</editor-fold>
  public void AddPassByIndirectCopyRestoreStep(QualType type, 
                                  boolean shouldCopy) {
    Step s/*J*/= new Step();
    s.Kind = (shouldCopy ? StepKind.SK_PassByIndirectCopyRestore : StepKind.SK_PassByIndirectRestore);
    s.Type.$assign(type);
    Steps.push_back(s);
  }

  
  /// \brief Add a step to "produce" an Objective-C object (by
  /// retaining it).
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddProduceObjCObjectStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3292,
   FQN="clang::InitializationSequence::AddProduceObjCObjectStep", NM="_ZN5clang22InitializationSequence24AddProduceObjCObjectStepENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence24AddProduceObjCObjectStepENS_8QualTypeE")
  //</editor-fold>
  public void AddProduceObjCObjectStep(QualType T) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_ProduceObjCObject;
    S.Type.$assign(T);
    Steps.push_back(S);
  }

  
  /// \brief Add a step to construct a std::initializer_list object from an
  /// initializer list.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddStdInitializerListConstructionStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3299,
   FQN="clang::InitializationSequence::AddStdInitializerListConstructionStep", NM="_ZN5clang22InitializationSequence37AddStdInitializerListConstructionStepENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence37AddStdInitializerListConstructionStepENS_8QualTypeE")
  //</editor-fold>
  public void AddStdInitializerListConstructionStep(QualType T) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_StdInitializerList;
    S.Type.$assign(T);
    Steps.push_back(S);
  }

  
  /// \brief Add a step to initialize an OpenCL sampler from an integer
  /// constant.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddOCLSamplerInitStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3306,
   FQN="clang::InitializationSequence::AddOCLSamplerInitStep", NM="_ZN5clang22InitializationSequence21AddOCLSamplerInitStepENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence21AddOCLSamplerInitStepENS_8QualTypeE")
  //</editor-fold>
  public void AddOCLSamplerInitStep(QualType T) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_OCLSamplerInit;
    S.Type.$assign(T);
    Steps.push_back(S);
  }

  
  /// \brief Add a step to initialize an OpenCL event_t from a NULL
  /// constant.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::AddOCLZeroEventStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3313,
   FQN="clang::InitializationSequence::AddOCLZeroEventStep", NM="_ZN5clang22InitializationSequence19AddOCLZeroEventStepENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence19AddOCLZeroEventStepENS_8QualTypeE")
  //</editor-fold>
  public void AddOCLZeroEventStep(QualType T) {
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_OCLZeroEvent;
    S.Type.$assign(T);
    Steps.push_back(S);
  }

  
  /// \brief Add steps to unwrap a initializer list for a reference around a
  /// single element and rewrap it at the end.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::RewrapReferenceInitList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3320,
   FQN="clang::InitializationSequence::RewrapReferenceInitList", NM="_ZN5clang22InitializationSequence23RewrapReferenceInitListENS_8QualTypeEPNS_12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence23RewrapReferenceInitListENS_8QualTypeEPNS_12InitListExprE")
  //</editor-fold>
  public void RewrapReferenceInitList(QualType T, 
                         InitListExpr /*P*/ Syntactic) {
    assert (Syntactic.getNumInits() == 1) : "Can only rewrap trivial init lists.";
    Step S/*J*/= new Step();
    S.Kind = StepKind.SK_UnwrapInitList;
    S.Type.$assignMove(Syntactic.getInit(0).getType());
    Steps.insert(Steps.begin(), S);
    
    S.Kind = StepKind.SK_RewrapInitList;
    S.Type.$assign(T);
    S.Unnamed_field2.WrappingSyntacticList = Syntactic;
    Steps.push_back(S);
  }

  
  /// \brief Note that this initialization sequence failed.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::SetFailed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 1105,
   FQN="clang::InitializationSequence::SetFailed", NM="_ZN5clang22InitializationSequence9SetFailedENS0_11FailureKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence9SetFailedENS0_11FailureKindE")
  //</editor-fold>
  public void SetFailed(FailureKind Failure) {
    _SequenceKind = SequenceKind.FailedSequence;
    this.Failure = Failure;
    assert ((Failure != FailureKind.FK_Incomplete || !FailedIncompleteType.isNull())) : "Incomplete type failure requires a type!";
  }

  
  /// \brief Note that this initialization sequence failed due to failed
  /// overload resolution.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::SetOverloadFailure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3335,
   FQN="clang::InitializationSequence::SetOverloadFailure", NM="_ZN5clang22InitializationSequence18SetOverloadFailureENS0_11FailureKindENS_17OverloadingResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence18SetOverloadFailureENS0_11FailureKindENS_17OverloadingResultE")
  //</editor-fold>
  public void SetOverloadFailure(FailureKind Failure, 
                    OverloadingResult Result) {
    setSequenceKind(SequenceKind.FailedSequence);
    this.Failure = Failure;
    this.FailedOverloadResult = Result;
  }

  
  /// \brief Retrieve a reference to the candidate set when overload
  /// resolution fails.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::getFailedCandidateSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 1118,
   FQN="clang::InitializationSequence::getFailedCandidateSet", NM="_ZN5clang22InitializationSequence21getFailedCandidateSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence21getFailedCandidateSetEv")
  //</editor-fold>
  public OverloadCandidateSet /*&*/ getFailedCandidateSet() {
    return FailedCandidateSet;
  }

  
  /// \brief Get the overloading result, for when the initialization
  /// sequence failed due to a bad overload.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::getFailedOverloadResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 1124,
   FQN="clang::InitializationSequence::getFailedOverloadResult", NM="_ZNK5clang22InitializationSequence23getFailedOverloadResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang22InitializationSequence23getFailedOverloadResultEv")
  //</editor-fold>
  public OverloadingResult getFailedOverloadResult() /*const*/ {
    return FailedOverloadResult;
  }

  
  /// \brief Note that this initialization sequence failed due to an
  /// incomplete type.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::setIncompleteTypeFailure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 1130,
   FQN="clang::InitializationSequence::setIncompleteTypeFailure", NM="_ZN5clang22InitializationSequence24setIncompleteTypeFailureENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang22InitializationSequence24setIncompleteTypeFailureENS_8QualTypeE")
  //</editor-fold>
  public void setIncompleteTypeFailure(QualType IncompleteType) {
    FailedIncompleteType.$assign(IncompleteType);
    SetFailed(FailureKind.FK_Incomplete);
  }

  
  /// \brief Determine why initialization failed.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::getFailureKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 1136,
   FQN="clang::InitializationSequence::getFailureKind", NM="_ZNK5clang22InitializationSequence14getFailureKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang22InitializationSequence14getFailureKindEv")
  //</editor-fold>
  public FailureKind getFailureKind() /*const*/ {
    assert (Failed()) : "Not an initialization failure!";
    return Failure;
  }

  
  /// \brief Dump a representation of this initialization sequence to 
  /// the given stream, for debugging purposes.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 7433,
   FQN="clang::InitializationSequence::dump", NM="_ZNK5clang22InitializationSequence4dumpERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang22InitializationSequence4dumpERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS) /*const*/ {
    switch (_SequenceKind) {
     case FailedSequence:
      {
        OS.$out(/*KEEP_STR*/"Failed sequence: ");
        switch (Failure) {
         case FK_TooManyInitsForReference:
          OS.$out(/*KEEP_STR*/"too many initializers for reference");
          break;
         case FK_ArrayNeedsInitList:
          OS.$out(/*KEEP_STR*/"array requires initializer list");
          break;
         case FK_AddressOfUnaddressableFunction:
          OS.$out(/*KEEP_STR*/"address of unaddressable function was taken");
          break;
         case FK_ArrayNeedsInitListOrStringLiteral:
          OS.$out(/*KEEP_STR*/"array requires initializer list or string literal");
          break;
         case FK_ArrayNeedsInitListOrWideStringLiteral:
          OS.$out(/*KEEP_STR*/"array requires initializer list or wide string literal");
          break;
         case FK_NarrowStringIntoWideCharArray:
          OS.$out(/*KEEP_STR*/"narrow string into wide char array");
          break;
         case FK_WideStringIntoCharArray:
          OS.$out(/*KEEP_STR*/"wide string into char array");
          break;
         case FK_IncompatWideStringIntoWideChar:
          OS.$out(/*KEEP_STR*/"incompatible wide string into wide char array");
          break;
         case FK_ArrayTypeMismatch:
          OS.$out(/*KEEP_STR*/"array type mismatch");
          break;
         case FK_NonConstantArrayInit:
          OS.$out(/*KEEP_STR*/"non-constant array initializer");
          break;
         case FK_AddressOfOverloadFailed:
          OS.$out(/*KEEP_STR*/"address of overloaded function failed");
          break;
         case FK_ReferenceInitOverloadFailed:
          OS.$out(/*KEEP_STR*/"overload resolution for reference initialization failed");
          break;
         case FK_NonConstLValueReferenceBindingToTemporary:
          OS.$out(/*KEEP_STR*/"non-const lvalue reference bound to temporary");
          break;
         case FK_NonConstLValueReferenceBindingToUnrelated:
          OS.$out(/*KEEP_STR*/"non-const lvalue reference bound to unrelated type");
          break;
         case FK_RValueReferenceBindingToLValue:
          OS.$out(/*KEEP_STR*/"rvalue reference bound to an lvalue");
          break;
         case FK_ReferenceInitDropsQualifiers:
          OS.$out(/*KEEP_STR*/"reference initialization drops qualifiers");
          break;
         case FK_ReferenceInitFailed:
          OS.$out(/*KEEP_STR*/"reference initialization failed");
          break;
         case FK_ConversionFailed:
          OS.$out(/*KEEP_STR*/"conversion failed");
          break;
         case FK_ConversionFromPropertyFailed:
          OS.$out(/*KEEP_STR*/"conversion from property failed");
          break;
         case FK_TooManyInitsForScalar:
          OS.$out(/*KEEP_STR*/"too many initializers for scalar");
          break;
         case FK_ReferenceBindingToInitList:
          OS.$out(/*KEEP_STR*/"referencing binding to initializer list");
          break;
         case FK_InitListBadDestinationType:
          OS.$out(/*KEEP_STR*/"initializer list for non-aggregate, non-scalar type");
          break;
         case FK_UserConversionOverloadFailed:
          OS.$out(/*KEEP_STR*/"overloading failed for user-defined conversion");
          break;
         case FK_ConstructorOverloadFailed:
          OS.$out(/*KEEP_STR*/"constructor overloading failed");
          break;
         case FK_DefaultInitOfConst:
          OS.$out(/*KEEP_STR*/"default initialization of a const variable");
          break;
         case FK_Incomplete:
          OS.$out(/*KEEP_STR*/"initialization of incomplete type");
          break;
         case FK_ListInitializationFailed:
          OS.$out(/*KEEP_STR*/"list initialization checker failure");
          break;
         case FK_VariableLengthArrayHasInitializer:
          OS.$out(/*KEEP_STR*/"variable length array has an initializer");
          break;
         case FK_PlaceholderType:
          OS.$out(/*KEEP_STR*/"initializer expression isn't contextually valid");
          break;
         case FK_ListConstructorOverloadFailed:
          OS.$out(/*KEEP_STR*/"list constructor overloading failed");
          break;
         case FK_ExplicitConstructor:
          OS.$out(/*KEEP_STR*/"list copy initialization chose explicit constructor");
          break;
        }
        OS.$out_char($$LF);
        return;
      }
     case DependentSequence:
      OS.$out(/*KEEP_STR*/"Dependent sequence\n");
      return;
     case NormalSequence:
      OS.$out(/*KEEP_STR*/"Normal sequence: ");
      break;
    }
    
    for (type$ptr<Step> S = step_begin(), /*P*/ SEnd = step_end(); $noteq_iter(S, SEnd); S.$preInc()) {
      if ($noteq_iter(S, step_begin())) {
        OS.$out(/*KEEP_STR*/" -> ");
      }
      switch (S./*->*/$star().Kind) {
       case SK_ResolveAddressOfOverloadedFunction:
        OS.$out(/*KEEP_STR*/"resolve address of overloaded function");
        break;
       case SK_CastDerivedToBaseRValue:
        OS.$out(/*KEEP_STR*/"derived-to-base case (rvalue").$out(S./*->*/$star().Type.getAsString()).$out(/*KEEP_STR*/$RPAREN);
        break;
       case SK_CastDerivedToBaseXValue:
        OS.$out(/*KEEP_STR*/"derived-to-base case (xvalue").$out(S./*->*/$star().Type.getAsString()).$out(/*KEEP_STR*/$RPAREN);
        break;
       case SK_CastDerivedToBaseLValue:
        OS.$out(/*KEEP_STR*/"derived-to-base case (lvalue").$out(S./*->*/$star().Type.getAsString()).$out(/*KEEP_STR*/$RPAREN);
        break;
       case SK_BindReference:
        OS.$out(/*KEEP_STR*/"bind reference to lvalue");
        break;
       case SK_BindReferenceToTemporary:
        OS.$out(/*KEEP_STR*/"bind reference to a temporary");
        break;
       case SK_ExtraneousCopyToTemporary:
        OS.$out(/*KEEP_STR*/"extraneous C++03 copy to temporary");
        break;
       case SK_UserConversion:
        $out_raw_ostream_NamedDecl$C(OS.$out(/*KEEP_STR*/"user-defined conversion via "), $Deref(S./*->*/$star().Unnamed_field2.Function.Function));
        break;
       case SK_QualificationConversionRValue:
        OS.$out(/*KEEP_STR*/"qualification conversion (rvalue)");
        break;
       case SK_QualificationConversionXValue:
        OS.$out(/*KEEP_STR*/"qualification conversion (xvalue)");
        break;
       case SK_QualificationConversionLValue:
        OS.$out(/*KEEP_STR*/"qualification conversion (lvalue)");
        break;
       case SK_AtomicConversion:
        OS.$out(/*KEEP_STR*/"non-atomic-to-atomic conversion");
        break;
       case SK_LValueToRValue:
        OS.$out(/*KEEP_STR*/"load (lvalue to rvalue)");
        break;
       case SK_ConversionSequence:
        OS.$out(/*KEEP_STR*/"implicit conversion sequence (");
        S./*->*/$star().Unnamed_field2.ICS.dump(); // FIXME: use OS
        OS.$out(/*KEEP_STR*/$RPAREN);
        break;
       case SK_ConversionSequenceNoNarrowing:
        OS.$out(/*KEEP_STR*/"implicit conversion sequence with narrowing prohibited (");
        S./*->*/$star().Unnamed_field2.ICS.dump(); // FIXME: use OS
        OS.$out(/*KEEP_STR*/$RPAREN);
        break;
       case SK_ListInitialization:
        OS.$out(/*KEEP_STR*/"list aggregate initialization");
        break;
       case SK_UnwrapInitList:
        OS.$out(/*KEEP_STR*/"unwrap reference initializer list");
        break;
       case SK_RewrapInitList:
        OS.$out(/*KEEP_STR*/"rewrap reference initializer list");
        break;
       case SK_ConstructorInitialization:
        OS.$out(/*KEEP_STR*/"constructor initialization");
        break;
       case SK_ConstructorInitializationFromList:
        OS.$out(/*KEEP_STR*/"list initialization via constructor");
        break;
       case SK_ZeroInitialization:
        OS.$out(/*KEEP_STR*/"zero initialization");
        break;
       case SK_CAssignment:
        OS.$out(/*KEEP_STR*/"C assignment");
        break;
       case SK_StringInit:
        OS.$out(/*KEEP_STR*/"string initialization");
        break;
       case SK_ObjCObjectConversion:
        OS.$out(/*KEEP_STR*/"Objective-C object conversion");
        break;
       case SK_ArrayInit:
        OS.$out(/*KEEP_STR*/"array initialization");
        break;
       case SK_ParenthesizedArrayInit:
        OS.$out(/*KEEP_STR*/"parenthesized array initialization");
        break;
       case SK_PassByIndirectCopyRestore:
        OS.$out(/*KEEP_STR*/"pass by indirect copy and restore");
        break;
       case SK_PassByIndirectRestore:
        OS.$out(/*KEEP_STR*/"pass by indirect restore");
        break;
       case SK_ProduceObjCObject:
        OS.$out(/*KEEP_STR*/"Objective-C object retension");
        break;
       case SK_StdInitializerList:
        OS.$out(/*KEEP_STR*/"std::initializer_list from initializer list");
        break;
       case SK_StdInitializerListConstructorCall:
        OS.$out(/*KEEP_STR*/"list initialization from std::initializer_list");
        break;
       case SK_OCLSamplerInit:
        OS.$out(/*KEEP_STR*/"OpenCL sampler_t from integer constant");
        break;
       case SK_OCLZeroEvent:
        OS.$out(/*KEEP_STR*/"OpenCL event_t from zero");
        break;
      }
      
      OS.$out(/*KEEP_STR*/" [").$out(S./*->*/$star().Type.getAsString()).$out_char($$RSQUARE);
    }
    
    OS.$out_char($$LF);
  }

  
  /// \brief Dump a representation of this initialization sequence to 
  /// standard error, for debugging purposes.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationSequence::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 7724,
   FQN="clang::InitializationSequence::dump", NM="_ZNK5clang22InitializationSequence4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang22InitializationSequence4dumpEv")
  //</editor-fold>
  public void dump() /*const*/ {
    dump(llvm.errs());
  }

  
  @Override public String toString() {
    return "" + "_SequenceKind=" + _SequenceKind // NOI18N
              + ", Steps=" + Steps // NOI18N
              + ", Failure=" + Failure // NOI18N
              + ", FailedOverloadResult=" + FailedOverloadResult // NOI18N
              + ", FailedCandidateSet=" + FailedCandidateSet // NOI18N
              + ", FailedIncompleteType=" + FailedIncompleteType // NOI18N
              + ", ZeroInitializationFixit=" + ZeroInitializationFixit // NOI18N
              + ", ZeroInitializationFixitLoc=" + ZeroInitializationFixitLoc; // NOI18N
  }
}
