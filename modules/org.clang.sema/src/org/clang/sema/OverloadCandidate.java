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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;


/// OverloadCandidate - A single candidate in an overload set (C++ 13.3).
//<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 593,
 FQN="clang::OverloadCandidate", NM="_ZN5clang17OverloadCandidateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang17OverloadCandidateE")
//</editor-fold>
public class/*struct*/ OverloadCandidate implements Destructors.ClassWithDestructor, NativePOD<OverloadCandidate>, NativeMoveable<OverloadCandidate> {
  /// Function - The actual function that this candidate
  /// represents. When NULL, this is a built-in candidate
  /// (C++ [over.oper]) or a surrogate for a conversion to a
  /// function pointer or reference (C++ [over.call.object]).
  public FunctionDecl /*P*/ Function;
  
  /// FoundDecl - The original declaration that was looked up /
  /// invented / otherwise found, together with its access.
  /// Might be a UsingShadowDecl or a FunctionTemplateDecl.
  public DeclAccessPair FoundDecl;
  
  // BuiltinTypes - Provides the return and parameter types of a
  // built-in overload candidate. Only valid when Function is NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 607,
   FQN="clang::OverloadCandidate::(anonymous)", NM="_ZN5clang17OverloadCandidateE_Unnamed_struct1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang17OverloadCandidateE_Unnamed_struct1")
  //</editor-fold>
  public static class/*struct*/ Unnamed_struct1 {
    public final QualType ResultTy;
    public final QualType ParamTypes[/*3*/];// = new QualType [3];
    //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate::(anonymous struct)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 607,
     FQN="clang::OverloadCandidate::(anonymous struct)::", NM="_ZN5clang17OverloadCandidateUt_C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang17OverloadCandidateUt_C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_struct1() {
      // : ResultTy(), ParamTypes() 
      //START JInit
      this.ResultTy = new QualType();
      this.ParamTypes = new$T(new QualType [3], ()->new QualType());
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate::(anonymous struct)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 607,
     FQN="clang::OverloadCandidate::(anonymous struct)::", NM="_ZN5clang17OverloadCandidateUt_C1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang17OverloadCandidateUt_C1EOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_struct1(JD$Move _dparam, final Unnamed_struct1 $Prm0) {
      // : ResultTy(static_cast<(anonymous struct at /home/vkvashin/src/LLVM39/llvm/tools/clang/include/clang/Sema/Overload.h:607:5) &&>().ResultTy), ParamTypes(static_cast<QualType &&>(static_cast<(anonymous struct at /home/vkvashin/src/LLVM39/llvm/tools/clang/include/clang/Sema/Overload.h:607:5) &&>().ParamTypes[__i0])) 
      //START JInit
      this.ResultTy = new QualType(JD$Move.INSTANCE, $Prm0.ResultTy);
      this.ParamTypes = new$T(new QualType [$Prm0.ParamTypes.length], ()->new QualType());
      for (int i = 0; i < $Prm0.ParamTypes.length; i++) {
        $Prm0.ParamTypes[i] = $tryMove($Prm0.ParamTypes[i]);
      }
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate::(anonymous struct)::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 607,
     FQN="clang::OverloadCandidate::(anonymous struct)::operator=", NM="_ZN5clang17OverloadCandidateUt_aSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang17OverloadCandidateUt_aSEOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_struct1 $assignMove(final Unnamed_struct1 $Prm0) {
      this.ResultTy.$assignMove($Prm0.ResultTy);
      for (int i = 0; i < $Prm0.ParamTypes.length; i++) {
        $Prm0.ParamTypes[i].$assignMove($Prm0.ParamTypes[i]);
      }
      return /*Deref*/this;
    }

    public /*inline*/ Unnamed_struct1(final Unnamed_struct1 $Prm0) {
      // : ResultTy(static_cast<(anonymous struct at /home/vkvashin/src/LLVM39/llvm/tools/clang/include/clang/Sema/Overload.h:607:5) &&>().ResultTy), ParamTypes(static_cast<QualType &&>(static_cast<(anonymous struct at /home/vkvashin/src/LLVM39/llvm/tools/clang/include/clang/Sema/Overload.h:607:5) &&>().ParamTypes[__i0])) 
      //START JInit
      this.ResultTy = new QualType($Prm0.ResultTy);
      this.ParamTypes = new$T(new QualType [$Prm0.ParamTypes.length], ()->new QualType());
      for (int i = 0; i < $Prm0.ParamTypes.length; i++) {
        $Prm0.ParamTypes[i].$assign($Prm0.ParamTypes[i]);
      }
      //END JInit
    }
    
    public /*inline*/ Unnamed_struct1 $assign(final Unnamed_struct1 $Prm0) {
      this.ResultTy.$assign($Prm0.ResultTy);
      for (int i = 0; i < $Prm0.ParamTypes.length; i++) {
        $Prm0.ParamTypes[i].$assign($Prm0.ParamTypes[i]);
      }
      return /*Deref*/this;
    }
    
    @Override public String toString() {
      return "" + "ResultTy=" + ResultTy // NOI18N
                + ", ParamTypes=" + ParamTypes; // NOI18N
    }
  };
  public Unnamed_struct1 BuiltinTypes;
  
  /// Surrogate - The conversion function for which this candidate
  /// is a surrogate, but only if IsSurrogate is true.
  public CXXConversionDecl /*P*/ Surrogate;
  
  /// Conversions - The conversion sequences used to convert the
  /// function arguments to the function parameters, the pointer points to a
  /// fixed size array with NumConversions elements. The memory is owned by
  /// the OverloadCandidateSet.
  public ImplicitConversionSequence[] /*P*/ Conversions;
  
  /// The FixIt hints which can be used to fix the Bad candidate.
  public ConversionFixItGenerator Fix;
  
  /// NumConversions - The number of elements in the Conversions array.
  public /*uint*/int NumConversions;
  
  /// Viable - True to indicate that this overload candidate is viable.
  public boolean Viable;
  
  /// IsSurrogate - True to indicate that this candidate is a
  /// surrogate for a conversion to a function pointer or reference
  /// (C++ [over.call.object]).
  public boolean IsSurrogate;
  
  /// IgnoreObjectArgument - True to indicate that the first
  /// argument's conversion, which for this function represents the
  /// implicit object argument, should be ignored. This will be true
  /// when the candidate is a static member function (where the
  /// implicit object argument is just a placeholder) or a
  /// non-static member function when the call doesn't have an
  /// object argument.
  public boolean IgnoreObjectArgument;
  
  /// FailureKind - The reason why this candidate is not viable.
  /// Actually an OverloadFailureKind.
  public /*uchar*/byte FailureKind;
  
  /// \brief The number of call arguments that were explicitly provided,
  /// to be used while performing partial ordering of function templates.
  public /*uint*/int ExplicitCallArguments;
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 653,
   FQN="clang::OverloadCandidate::(anonymous)", NM="_ZN5clang17OverloadCandidateE_Unnamed_union2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang17OverloadCandidateE_Unnamed_union2")
  //</editor-fold>
  public static class/*union*/ Unnamed_union2 {
    public final DeductionFailureInfo DeductionFailure;
    
    /// FinalConversion - For a conversion function (where Function is
    /// a CXXConversionDecl), the standard conversion that occurs
    /// after the call to the overload candidate to convert the result
    /// of calling the conversion function to the required type.
    public final StandardConversionSequence FinalConversion;
    
    //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assign fields*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 653,
     FQN="clang::OverloadCandidate::(anonymous union)::", NM="_ZN5clang17OverloadCandidateUt0_C1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang17OverloadCandidateUt0_C1EOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union2(JD$Move _dparam, final Unnamed_union2 $Prm0) {
      this.DeductionFailure = new DeductionFailureInfo(JD$Move.INSTANCE, $Prm0.DeductionFailure);
      this.FinalConversion = new StandardConversionSequence().$assignMove($Prm0.FinalConversion);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 653,
     FQN="clang::OverloadCandidate::(anonymous union)::operator=", NM="_ZN5clang17OverloadCandidateUt0_aSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang17OverloadCandidateUt0_aSEOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union2 $assignMove(final Unnamed_union2 $Prm0) {
      
      this.DeductionFailure.$assignMove($Prm0.DeductionFailure);
      
      this.FinalConversion.$assignMove($Prm0.FinalConversion);
      
      return /*Deref*/this;
    }

    public /*inline*/ Unnamed_union2(final Unnamed_union2 $Prm0) {
      this.DeductionFailure = new DeductionFailureInfo().$assign($Prm0.DeductionFailure);
      this.FinalConversion = new StandardConversionSequence().$assign($Prm0.FinalConversion);
    }
    
    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public Unnamed_union2() {
      this.DeductionFailure = new DeductionFailureInfo();
      this.FinalConversion = new StandardConversionSequence();
    }

    public /*inline*/ Unnamed_union2 $assign(final Unnamed_union2 $Prm0) {
      
      this.DeductionFailure.$assign($Prm0.DeductionFailure);
      
      this.FinalConversion.$assign($Prm0.FinalConversion);
      
      return /*Deref*/this;
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "DeductionFailure=" + DeductionFailure // NOI18N
                + ", FinalConversion=" + FinalConversion; // NOI18N
    }
  };
  public final Unnamed_union2 Unnamed_field12;
  
  /// hasAmbiguousConversion - Returns whether this overload
  /// candidate requires an ambiguous conversion or not.
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate::hasAmbiguousConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 665,
   FQN="clang::OverloadCandidate::hasAmbiguousConversion", NM="_ZNK5clang17OverloadCandidate22hasAmbiguousConversionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK5clang17OverloadCandidate22hasAmbiguousConversionEv")
  //</editor-fold>
  public boolean hasAmbiguousConversion() /*const*/ {
    for (/*uint*/int i = 0, e = NumConversions; i != e; ++i) {
      if (!Conversions[i].isInitialized()) {
        return false;
      }
      if (Conversions[i].isAmbiguous()) {
        return true;
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate::TryToFixBadConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 673,
   FQN="clang::OverloadCandidate::TryToFixBadConversion", NM="_ZN5clang17OverloadCandidate21TryToFixBadConversionEjRNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang17OverloadCandidate21TryToFixBadConversionEjRNS_4SemaE")
  //</editor-fold>
  public boolean TryToFixBadConversion(/*uint*/int Idx, final Sema /*&*/ S) {
    boolean CanFix = Fix.tryToFixConversion(Conversions[Idx].Unnamed_field2.Bad.FromExpr, 
        Conversions[Idx].Unnamed_field2.Bad.getFromType(), 
        Conversions[Idx].Unnamed_field2.Bad.getToType(), S);
    
    // If at least one conversion fails, the candidate cannot be fixed.
    if (!CanFix) {
      Fix.clear();
    }
    
    return CanFix;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate::getNumParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 686,
   FQN="clang::OverloadCandidate::getNumParams", NM="_ZNK5clang17OverloadCandidate12getNumParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK5clang17OverloadCandidate12getNumParamsEv")
  //</editor-fold>
  public /*uint*/int getNumParams() /*const*/ {
    if (IsSurrogate) {
      QualType STy = Surrogate.getConversionType();
      while (STy.$arrow().isPointerType() || STy.$arrow().isReferenceType()) {
        STy.$assignMove(STy.$arrow().getPointeeType());
      }
      return STy.$arrow().getAs(FunctionProtoType.class).getNumParams();
    }
    if ((Function != null)) {
      return Function.getNumParams();
    }
    return ExplicitCallArguments;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate::OverloadCandidate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 593,
   FQN="clang::OverloadCandidate::OverloadCandidate", NM="_ZN5clang17OverloadCandidateC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang17OverloadCandidateC1Ev")
  //</editor-fold>
  public /*inline*/ OverloadCandidate() {
    // : FoundDecl(), BuiltinTypes(), Fix() 
    //START JInit
    this.FoundDecl = new DeclAccessPair();
    this.BuiltinTypes = new Unnamed_struct1();
    this.Fix = new ConversionFixItGenerator();
    this.Unnamed_field12 = new Unnamed_union2();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate::OverloadCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 593,
   FQN="clang::OverloadCandidate::OverloadCandidate", NM="_ZN5clang17OverloadCandidateC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang17OverloadCandidateC1EOS0_")
  //</editor-fold>
  public /*inline*/ OverloadCandidate(JD$Move _dparam, final OverloadCandidate /*&&*/$Prm0) {
    // : Function(static_cast<OverloadCandidate &&>().Function), FoundDecl(static_cast<OverloadCandidate &&>().FoundDecl), BuiltinTypes(static_cast<OverloadCandidate &&>().BuiltinTypes), Surrogate(static_cast<OverloadCandidate &&>().Surrogate), Conversions(static_cast<OverloadCandidate &&>().Conversions), Fix(static_cast<OverloadCandidate &&>().Fix), NumConversions(static_cast<OverloadCandidate &&>().NumConversions), Viable(static_cast<OverloadCandidate &&>().Viable), IsSurrogate(static_cast<OverloadCandidate &&>().IsSurrogate), IgnoreObjectArgument(static_cast<OverloadCandidate &&>().IgnoreObjectArgument), FailureKind(static_cast<OverloadCandidate &&>().FailureKind), ExplicitCallArguments(static_cast<OverloadCandidate &&>().ExplicitCallArguments), Unnamed_field12(static_cast<OverloadCandidate &&>().) 
    //START JInit
    this.Function = $Prm0.Function;
    this.FoundDecl = new DeclAccessPair(JD$Move.INSTANCE, $Prm0.FoundDecl);
    this.BuiltinTypes = new Unnamed_struct1(JD$Move.INSTANCE, $Prm0.BuiltinTypes);
    this.Surrogate = $Prm0.Surrogate;
    this.Conversions = $Prm0.Conversions;
    this.Fix = new ConversionFixItGenerator(JD$Move.INSTANCE, $Prm0.Fix);
    this.NumConversions = $Prm0.NumConversions;
    this.Viable = $Prm0.Viable;
    this.IsSurrogate = $Prm0.IsSurrogate;
    this.IgnoreObjectArgument = $Prm0.IgnoreObjectArgument;
    this.FailureKind = $Prm0.FailureKind;
    this.ExplicitCallArguments = $Prm0.ExplicitCallArguments;
    this.Unnamed_field12 = new Unnamed_union2(JD$Move.INSTANCE, $Prm0.Unnamed_field12);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate::~OverloadCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 593,
   FQN="clang::OverloadCandidate::~OverloadCandidate", NM="_ZN5clang17OverloadCandidateD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang17OverloadCandidateD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Fix.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 593,
   FQN="clang::OverloadCandidate::operator=", NM="_ZN5clang17OverloadCandidateaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang17OverloadCandidateaSEOS0_")
  //</editor-fold>
  public /*inline*/ OverloadCandidate /*&*/ $assignMove(final OverloadCandidate /*&&*/$Prm0) {
    this.Function = $Prm0.Function;
    this.FoundDecl.$assignMove($Prm0.FoundDecl);
    this.BuiltinTypes.$assignMove($Prm0.BuiltinTypes);
    this.Surrogate = $Prm0.Surrogate;
    this.Conversions = $Prm0.Conversions;
    this.Fix.$assignMove($Prm0.Fix);
    this.NumConversions = $Prm0.NumConversions;
    this.Viable = $Prm0.Viable;
    this.IsSurrogate = $Prm0.IsSurrogate;
    this.IgnoreObjectArgument = $Prm0.IgnoreObjectArgument;
    this.FailureKind = $Prm0.FailureKind;
    this.ExplicitCallArguments = $Prm0.ExplicitCallArguments;
    this.Unnamed_field12.$assignMove($Prm0.Unnamed_field12);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverloadCandidate::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 593,
   FQN="clang::OverloadCandidate::operator=", NM="_ZN5clang17OverloadCandidateaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang17OverloadCandidateaSEOS0_")
  //</editor-fold>
  public /*inline*/ OverloadCandidate(final OverloadCandidate /*&*/$Prm0) {
    this.Function = $Prm0.Function;
    this.FoundDecl = new DeclAccessPair($Prm0.FoundDecl);
    this.BuiltinTypes = new Unnamed_struct1($Prm0.BuiltinTypes);
    this.Surrogate = $Prm0.Surrogate;
    this.Conversions = $Prm0.Conversions;
    this.Fix = new ConversionFixItGenerator($Prm0.Fix);
    this.NumConversions = $Prm0.NumConversions;
    this.Viable = $Prm0.Viable;
    this.IsSurrogate = $Prm0.IsSurrogate;
    this.IgnoreObjectArgument = $Prm0.IgnoreObjectArgument;
    this.FailureKind = $Prm0.FailureKind;
    this.ExplicitCallArguments = $Prm0.ExplicitCallArguments;
    this.Unnamed_field12 = new Unnamed_union2($Prm0.Unnamed_field12);
  }

  @Override
  public OverloadCandidate $assign(OverloadCandidate $Prm0) {
    this.Function = $Prm0.Function;
    this.FoundDecl.$assign($Prm0.FoundDecl);
    this.BuiltinTypes.$assign($Prm0.BuiltinTypes);
    this.Surrogate = $Prm0.Surrogate;
    this.Conversions = $Prm0.Conversions;
    this.Fix.$assign($Prm0.Fix);
    this.NumConversions = $Prm0.NumConversions;
    this.Viable = $Prm0.Viable;
    this.IsSurrogate = $Prm0.IsSurrogate;
    this.IgnoreObjectArgument = $Prm0.IgnoreObjectArgument;
    this.FailureKind = $Prm0.FailureKind;
    this.ExplicitCallArguments = $Prm0.ExplicitCallArguments;
    this.Unnamed_field12.$assign($Prm0.Unnamed_field12);
    return /*Deref*/this;
  }
  
  @Override public OverloadCandidate clone() { 
    return new OverloadCandidate(this); 
  }
  
  @Override public OverloadCandidate move() {
    return new OverloadCandidate(JD$Move.INSTANCE, this);
  }
  
  @Override public String toString() {
    return "" + "Function=" + Function // NOI18N
              + ", FoundDecl=" + FoundDecl // NOI18N
              + ", BuiltinTypes=" + BuiltinTypes // NOI18N
              + ", Surrogate=" + Surrogate // NOI18N
              + ", Conversions=" + Conversions // NOI18N
              + ", Fix=" + Fix // NOI18N
              + ", NumConversions=" + NumConversions // NOI18N
              + ", Viable=" + Viable // NOI18N
              + ", IsSurrogate=" + IsSurrogate // NOI18N
              + ", IgnoreObjectArgument=" + IgnoreObjectArgument // NOI18N
              + ", FailureKind=" + $uchar2uint(FailureKind) // NOI18N
              + ", ExplicitCallArguments=" + ExplicitCallArguments // NOI18N
              + ", Unnamed_field12=" + Unnamed_field12; // NOI18N
  }
}
