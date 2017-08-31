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

package org.clang.sema.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaOverloadStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


// A helper class to help with address of function resolution
// - allows us to avoid passing around all those ugly parameters
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10275,
 FQN="(anonymous namespace)::AddressOfFunctionResolver", NM="_ZN12_GLOBAL__N_125AddressOfFunctionResolverE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_125AddressOfFunctionResolverE")
//</editor-fold>
public class AddressOfFunctionResolver implements Destructors.ClassWithDestructor {
  private final Sema /*&*/ S;
  private Expr /*P*/ SourceExpr;
  private final /*const*/ QualType /*&*/ TargetType;
  private QualType TargetFunctionType; // Extracted function type from target type 
  
  private boolean Complain;
  //DeclAccessPair& ResultFunctionAccessPair;
  private final ASTContext /*&*/ Context;
  
  private boolean TargetTypeIsNonStaticMemberFunction;
  private boolean FoundNonTemplateFunction;
  private boolean StaticMemberFunctionFromBoundPointer;
  private boolean HasComplained;
  
  private OverloadExpr.FindResult OvlExprInfo;
  private OverloadExpr /*P*/ OvlExpr;
  private TemplateArgumentListInfo OvlExplicitTemplateArgs;
  private SmallVector<std.pair<DeclAccessPair, FunctionDecl /*P*/ >> Matches;
  private TemplateSpecCandidateSet FailedCandidates;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::AddressOfFunctionResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10297,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::AddressOfFunctionResolver", NM="_ZN12_GLOBAL__N_125AddressOfFunctionResolverC1ERN5clang4SemaEPNS1_4ExprERKNS1_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_125AddressOfFunctionResolverC1ERN5clang4SemaEPNS1_4ExprERKNS1_8QualTypeEb")
  //</editor-fold>
  public AddressOfFunctionResolver(final Sema /*&*/ S, Expr /*P*/ SourceExpr, 
      final /*const*/ QualType /*&*/ TargetType, boolean Complain) {
    // : S(S), SourceExpr(SourceExpr), TargetType(TargetType), TargetFunctionType(), Complain(Complain), Context(S.getASTContext()), TargetTypeIsNonStaticMemberFunction(!!TargetType->getAs<MemberPointerType>()), FoundNonTemplateFunction(false), StaticMemberFunctionFromBoundPointer(false), HasComplained(false), OvlExprInfo(OverloadExpr::find(SourceExpr)), OvlExpr(OvlExprInfo.Expression), OvlExplicitTemplateArgs(), Matches(), FailedCandidates(OvlExpr->getNameLoc(), /*ForTakingAddress=*/ true) 
    //START JInit
    this./*&*/S=/*&*/S;
    this.SourceExpr = SourceExpr;
    this./*&*/TargetType=/*&*/TargetType;
    this.TargetFunctionType = new QualType();
    this.Complain = Complain;
    this./*&*/Context=/*&*/S.getASTContext();
    this.TargetTypeIsNonStaticMemberFunction = !!(TargetType.$arrow().getAs(MemberPointerType.class) != null);
    this.FoundNonTemplateFunction = false;
    this.StaticMemberFunctionFromBoundPointer = false;
    this.HasComplained = false;
    this.OvlExprInfo = OverloadExpr.find(SourceExpr);
    this.OvlExpr = OvlExprInfo.Expression;
    this.OvlExplicitTemplateArgs = new TemplateArgumentListInfo();
    this.Matches = new SmallVector<std.pair<DeclAccessPair, FunctionDecl /*P*/ >>(4, new std.pairTypePtr<DeclAccessPair, FunctionDecl /*P*/ >(new DeclAccessPair(), null));
    this.FailedCandidates = new TemplateSpecCandidateSet(OvlExpr.getNameLoc(), true);
    //END JInit
    ExtractUnqualifiedFunctionTypeFromTargetType();
    if (TargetFunctionType.$arrow().isFunctionType()) {
      {
        UnresolvedMemberExpr /*P*/ UME = dyn_cast_UnresolvedMemberExpr(OvlExpr);
        if ((UME != null)) {
          if (!UME.isImplicitAccess()
             && !(S.ResolveSingleFunctionTemplateSpecialization(UME) != null)) {
            StaticMemberFunctionFromBoundPointer = true;
          }
        }
      }
    } else if (OvlExpr.hasExplicitTemplateArgs()) {
      DeclAccessPair dap/*J*/= new DeclAccessPair();
      {
        FunctionDecl /*P*/ Fn = S.ResolveSingleFunctionTemplateSpecialization(OvlExpr, false, $AddrOf(dap));
        if ((Fn != null)) {
          {
            CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(Fn);
            if ((Method != null)) {
              if (!Method.isStatic()) {
                // If the target type is a non-function type and the function found
                // is a non-static member function, pretend as if that was the
                // target, it's the only possible type to end up with.
                TargetTypeIsNonStaticMemberFunction = true;
                
                // And skip adding the function if its not in the proper form.
                // We'll diagnose this due to an empty set of functions.
                if (!OvlExprInfo.HasFormOfMemberPointer) {
                  return;
                }
              }
            }
          }
          
          Matches.push_back(std.make_pair_T_Ptr(dap, Fn));
        }
      }
      return;
    }
    if (OvlExpr.hasExplicitTemplateArgs()) {
      OvlExpr.copyTemplateArgumentsInto(OvlExplicitTemplateArgs);
    }
    if (FindAllFunctionsThatMatchTargetTypeExactly()) {
      // C++ [over.over]p4:
      //   If more than one function is selected, [...]
      if ($greater_uint(Matches.size(), 1) && !eliminiateSuboptimalOverloadCandidates()) {
        if (FoundNonTemplateFunction) {
          EliminateAllTemplateMatches();
        } else {
          EliminateAllExceptMostSpecializedTemplate();
        }
      }
    }
    if (S.getLangOpts().CUDA && $greater_uint(Matches.size(), 1)) {
      EliminateSuboptimalCudaMatches();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::hasComplained">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10356,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::hasComplained", NM="_ZNK12_GLOBAL__N_125AddressOfFunctionResolver13hasComplainedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK12_GLOBAL__N_125AddressOfFunctionResolver13hasComplainedEv")
  //</editor-fold>
  public boolean hasComplained() /*const*/ {
    return HasComplained;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::candidateHasExactlyCorrectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10359,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::candidateHasExactlyCorrectType", NM="_ZN12_GLOBAL__N_125AddressOfFunctionResolver30candidateHasExactlyCorrectTypeEPKN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_125AddressOfFunctionResolver30candidateHasExactlyCorrectTypeEPKN5clang12FunctionDeclE")
  //</editor-fold>
  private boolean candidateHasExactlyCorrectType(/*const*/ FunctionDecl /*P*/ FD) {
    QualType Discard/*J*/= new QualType();
    return Context.hasSameUnqualifiedType(new QualType(TargetFunctionType), FD.getType())
       || S.IsNoReturnConversion(FD.getType(), new QualType(TargetFunctionType), Discard);
  }

  
  /// \return true if A is considered a better overload candidate for the
  /// desired type than B.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::isBetterCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10367,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::isBetterCandidate", NM="_ZN12_GLOBAL__N_125AddressOfFunctionResolver17isBetterCandidateEPKN5clang12FunctionDeclES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_125AddressOfFunctionResolver17isBetterCandidateEPKN5clang12FunctionDeclES4_")
  //</editor-fold>
  private boolean isBetterCandidate(/*const*/ FunctionDecl /*P*/ A, /*const*/ FunctionDecl /*P*/ B) {
    // If A doesn't have exactly the correct type, we don't want to classify it
    // as "better" than anything else. This way, the user is required to
    // disambiguate for us if there are multiple candidates and no exact match.
    return candidateHasExactlyCorrectType(A)
       && (!candidateHasExactlyCorrectType(B)
       || compareEnableIfAttrs(S, A, B) == Comparison.Better);
  }

  
  /// \return true if we were able to eliminate all but one overload candidate,
  /// false otherwise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::eliminiateSuboptimalOverloadCandidates">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10378,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::eliminiateSuboptimalOverloadCandidates", NM="_ZN12_GLOBAL__N_125AddressOfFunctionResolver38eliminiateSuboptimalOverloadCandidatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_125AddressOfFunctionResolver38eliminiateSuboptimalOverloadCandidatesEv")
  //</editor-fold>
  private boolean eliminiateSuboptimalOverloadCandidates() {
    // Same algorithm as overload resolution -- one pass to pick the "best",
    // another pass to be sure that nothing is better than the best.
    type$ptr<pair<DeclAccessPair, FunctionDecl /*P*/ > /*P*/ > Best = $tryClone(Matches.begin());
    for (type$ptr<pair<DeclAccessPair, FunctionDecl /*P*/ > /*P*/ > I = $tryClone(Matches.begin().$add(1)), /*P*/ E = $tryClone(Matches.end()); $noteq_ptr(I, E); I.$preInc())  {
      if (isBetterCandidate(I./*->*/$star().second, Best./*->*/$star().second)) {
        Best.$assign(I);
      }
    }
    
    /*const*/ FunctionDecl /*P*/ BestFn = Best./*->*/$star().second;
    /*const*/ FunctionDecl /*P*/ L$BestFn = BestFn;
    BoolPredicate<std.pair<DeclAccessPair, FunctionDecl /*P*/ >>/*const*/ IsBestOrInferiorToBest = /*[this, =L$BestFn(BestFn)]*/ (final /*const*/ std.pair<DeclAccessPair, FunctionDecl /*P*/ > /*&*/ Pair) -> {
          return L$BestFn == Pair.second || isBetterCandidate(L$BestFn, Pair.second);
        };
    
    // Note: We explicitly leave Matches unmodified if there isn't a clear best
    // option, so we can potentially give the user a better error
    if (!std.all_of(Matches.begin(), Matches.end(), IsBestOrInferiorToBest)) {
      return false;
    }
    Matches.$at(0).$assign(Best.$star());
    Matches.resize(1);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::isTargetTypeAFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10401,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::isTargetTypeAFunction", NM="_ZNK12_GLOBAL__N_125AddressOfFunctionResolver21isTargetTypeAFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK12_GLOBAL__N_125AddressOfFunctionResolver21isTargetTypeAFunctionEv")
  //</editor-fold>
  private boolean isTargetTypeAFunction() /*const*/ {
    return TargetFunctionType.$arrow().isFunctionType();
  }

  
  // [ToType]     [Return]
  
  // R (*)(A) --> R (A), IsNonStaticMemberFunction = false
  // R (&)(A) --> R (A), IsNonStaticMemberFunction = false
  // R (S::*)(A) --> R (A), IsNonStaticMemberFunction = true
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::ExtractUnqualifiedFunctionTypeFromTargetType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10410,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::ExtractUnqualifiedFunctionTypeFromTargetType", NM="_ZN12_GLOBAL__N_125AddressOfFunctionResolver44ExtractUnqualifiedFunctionTypeFromTargetTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_125AddressOfFunctionResolver44ExtractUnqualifiedFunctionTypeFromTargetTypeEv")
  //</editor-fold>
  private /*inline*/ void ExtractUnqualifiedFunctionTypeFromTargetType() {
    TargetFunctionType.$assignMove(S.ExtractUnqualifiedFunctionType(new QualType(TargetType)));
  }

  
  // return true if any matching specializations were found
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::AddMatchingTemplateFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10415,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::AddMatchingTemplateFunction", NM="_ZN12_GLOBAL__N_125AddressOfFunctionResolver27AddMatchingTemplateFunctionEPN5clang20FunctionTemplateDeclERKNS1_14DeclAccessPairE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_125AddressOfFunctionResolver27AddMatchingTemplateFunctionEPN5clang20FunctionTemplateDeclERKNS1_14DeclAccessPairE")
  //</editor-fold>
  private boolean AddMatchingTemplateFunction(FunctionTemplateDecl /*P*/ FunctionTemplate, 
                             final /*const*/ DeclAccessPair /*&*/ CurAccessFunPair) {
    TemplateDeductionInfo Info = null;
    try {
      {
        CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(FunctionTemplate.getTemplatedDecl());
        if ((Method != null)) {
          // Skip non-static function templates when converting to pointer, and
          // static when converting to member pointer.
          if (Method.isStatic() == TargetTypeIsNonStaticMemberFunction) {
            return false;
          }
        } else if (TargetTypeIsNonStaticMemberFunction) {
          return false;
        }
      }
      
      // C++ [over.over]p2:
      //   If the name is a function template, template argument deduction is
      //   done (14.8.2.2), and if the argument deduction succeeds, the
      //   resulting template argument list is used to generate a single
      //   function template specialization, which is added to the set of
      //   overloaded functions considered.
      type$ref<FunctionDecl /*P*/ > Specialization = create_type$ref();
      Info/*J*/= new TemplateDeductionInfo(FailedCandidates.getLocation());
      {
        Sema.TemplateDeductionResult Result = S.DeduceTemplateArguments3(FunctionTemplate, 
            $AddrOf(OvlExplicitTemplateArgs), 
            new QualType(TargetFunctionType), Specialization, 
            Info, /*InOverloadResolution=*/ true);
        if ((Result.getValue() != 0)) {
          // Make a note of the failed deduction for diagnostics.
          FailedCandidates.addCandidate().
              set(new DeclAccessPair(CurAccessFunPair), FunctionTemplate.getTemplatedDecl(), 
              MakeDeductionFailureInfo(Context, Result, Info));
          return false;
        }
      }
      
      // Template argument deduction ensures that we have an exact match or
      // compatible pointer-to-function arguments that would be adjusted by ICS.
      // This function template specicalization works.
      assert (S.isSameOrCompatibleFunctionType(Context.getCanonicalType(Specialization.$deref().getType()), Context.getCanonicalType(new QualType(TargetFunctionType))));
      if (!S.checkAddressOfFunctionIsAvailable(Specialization.$deref())) {
        return false;
      }
      
      Matches.push_back(std.make_pair_T_Ptr(CurAccessFunPair, Specialization.$deref()));
      return true;
    } finally {
      if (Info != null) { Info.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::AddMatchingNonTemplateFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10461,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::AddMatchingNonTemplateFunction", NM="_ZN12_GLOBAL__N_125AddressOfFunctionResolver30AddMatchingNonTemplateFunctionEPN5clang9NamedDeclERKNS1_14DeclAccessPairE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_125AddressOfFunctionResolver30AddMatchingNonTemplateFunctionEPN5clang9NamedDeclERKNS1_14DeclAccessPairE")
  //</editor-fold>
  private boolean AddMatchingNonTemplateFunction(NamedDecl /*P*/ Fn, 
                                final /*const*/ DeclAccessPair /*&*/ CurAccessFunPair) {
    {
      CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(Fn);
      if ((Method != null)) {
        // Skip non-static functions when converting to pointer, and static
        // when converting to member pointer.
        if (Method.isStatic() == TargetTypeIsNonStaticMemberFunction) {
          return false;
        }
      } else if (TargetTypeIsNonStaticMemberFunction) {
        return false;
      }
    }
    {
      
      FunctionDecl /*P*/ FunDecl = dyn_cast_FunctionDecl(Fn);
      if ((FunDecl != null)) {
        if (S.getLangOpts().CUDA) {
          {
            FunctionDecl /*P*/ Caller = dyn_cast_FunctionDecl(S.CurContext);
            if ((Caller != null)) {
              if (!Caller.isImplicit() && S.CheckCUDATarget(Caller, FunDecl)) {
                return false;
              }
            }
          }
        }
        
        // If any candidate has a placeholder return type, trigger its deduction
        // now.
        if (S.getLangOpts().CPlusPlus14
           && FunDecl.getReturnType().$arrow().isUndeducedType()
           && S.DeduceReturnType(FunDecl, SourceExpr.getLocStart(), Complain)) {
          HasComplained |= Complain;
          return false;
        }
        if (!S.checkAddressOfFunctionIsAvailable(FunDecl)) {
          return false;
        }
        
        // If we're in C, we need to support types that aren't exactly identical.
        if (!S.getLangOpts().CPlusPlus
           || candidateHasExactlyCorrectType(FunDecl)) {
          Matches.push_back(std.make_pair_T_Ptr(CurAccessFunPair, cast_FunctionDecl(FunDecl.getCanonicalDecl())));
          FoundNonTemplateFunction = true;
          return true;
        }
      }
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::FindAllFunctionsThatMatchTargetTypeExactly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10503,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::FindAllFunctionsThatMatchTargetTypeExactly", NM="_ZN12_GLOBAL__N_125AddressOfFunctionResolver42FindAllFunctionsThatMatchTargetTypeExactlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_125AddressOfFunctionResolver42FindAllFunctionsThatMatchTargetTypeExactlyEv")
  //</editor-fold>
  private boolean FindAllFunctionsThatMatchTargetTypeExactly() {
    boolean Ret = false;
    
    // If the overload expression doesn't have the form of a pointer to
    // member, don't try to convert it to a pointer-to-member type.
    if (IsInvalidFormOfPointerToMemberFunction()) {
      return false;
    }
    
    for (UnresolvedSetIterator I = OvlExpr.decls_begin(), 
        E = OvlExpr.decls_end();
         I.$noteq(E); I.$preInc()) {
      // Look through any using declarations to find the underlying function.
      NamedDecl /*P*/ Fn = (I.$star()).getUnderlyingDecl();
      {
        
        // C++ [over.over]p3:
        //   Non-member functions and static member functions match
        //   targets of type "pointer-to-function" or "reference-to-function."
        //   Nonstatic member functions match targets of
        //   type "pointer-to-member-function."
        // Note that according to DR 247, the containing class does not matter.
        FunctionTemplateDecl /*P*/ FunctionTemplate = dyn_cast_FunctionTemplateDecl(Fn);
        if ((FunctionTemplate != null)) {
          if (AddMatchingTemplateFunction(FunctionTemplate, I.getPair())) {
            Ret = true;
          }
        } else // If we have explicit template arguments supplied, skip non-templates.
        if (!OvlExpr.hasExplicitTemplateArgs()
           && AddMatchingNonTemplateFunction(Fn, I.getPair())) {
          Ret = true;
        }
      }
    }
    assert (Ret || Matches.empty());
    return Ret;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::EliminateAllExceptMostSpecializedTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10537,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::EliminateAllExceptMostSpecializedTemplate", NM="_ZN12_GLOBAL__N_125AddressOfFunctionResolver41EliminateAllExceptMostSpecializedTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_125AddressOfFunctionResolver41EliminateAllExceptMostSpecializedTemplateEv")
  //</editor-fold>
  private void EliminateAllExceptMostSpecializedTemplate() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      //   [...] and any given function template specialization F1 is
      //   eliminated if the set contains a second function template
      //   specialization whose function template is more specialized
      //   than the function template of F1 according to the partial
      //   ordering rules of 14.5.5.2.
      
      // The algorithm specified above is quadratic. We instead use a
      // two-pass algorithm (similar to the one used to identify the
      // best viable function in an overload set) that identifies the
      // best function template (if it exists).
      UnresolvedSet MatchesCopy/*J*/= new UnresolvedSet(4); // TODO: avoid!
      for (/*uint*/int I = 0, E = Matches.size(); I != E; ++I)  {
        MatchesCopy.addDecl(Matches.$at(I).second, Matches.$at(I).first.getAccess());
      }
      
      // TODO: It looks like FailedCandidates does not serve much purpose
      // here, since the no_viable diagnostic has index 0.
      UnresolvedSetIterator Result = $c$.clean(S.getMostSpecialized(MatchesCopy.begin(), MatchesCopy.end(), FailedCandidates, 
          SourceExpr.getLocStart(), $c$.track(S.PDiag()), 
          $out_PartialDiagnostic$C_DeclarationName($c$.track(S.PDiag(diag.err_addr_ovl_ambiguous)), 
              Matches.$at(0).second.getDeclName()), 
          $out_PartialDiagnostic$C_uint($c$.track(S.PDiag(diag.note_ovl_candidate)), 
              (/*uint*/int)OverloadCandidateKind.oc_function_template.getValue()), 
          Complain, new QualType(TargetFunctionType)));
      if (Result.$noteq(MatchesCopy.end())) {
        // Make it the first and only element
        Matches.$at(0).first.$assign(Matches.$at(Result.$sub(MatchesCopy.begin())).first);
        Matches.$at(0).second = cast_FunctionDecl(Result.$star());
        Matches.resize(1);
      } else {
        HasComplained |= Complain;
      }
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::EliminateAllTemplateMatches">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10573,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::EliminateAllTemplateMatches", NM="_ZN12_GLOBAL__N_125AddressOfFunctionResolver27EliminateAllTemplateMatchesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_125AddressOfFunctionResolver27EliminateAllTemplateMatchesEv")
  //</editor-fold>
  private void EliminateAllTemplateMatches() {
    //   [...] any function template specializations in the set are
    //   eliminated if the set also contains a non-template function, [...]
    for (/*uint*/int I = 0, N = Matches.size(); I != N;) {
      if (Matches.$at(I).second.getPrimaryTemplate() == null) {
        ++I;
      } else {
        Matches.$at(I).$assign(Matches.$at(--N));
        Matches.resize(N);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::EliminateSuboptimalCudaMatches">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10586,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::EliminateSuboptimalCudaMatches", NM="_ZN12_GLOBAL__N_125AddressOfFunctionResolver30EliminateSuboptimalCudaMatchesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_125AddressOfFunctionResolver30EliminateSuboptimalCudaMatchesEv")
  //</editor-fold>
  private void EliminateSuboptimalCudaMatches() {
    S.EraseUnwantedCUDAMatches_FunctionDecl$C$P_SmallVectorImpl$pair$P(dyn_cast_FunctionDecl(S.CurContext), Matches);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::ComplainNoMatchesFound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10591,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::ComplainNoMatchesFound", NM="_ZNK12_GLOBAL__N_125AddressOfFunctionResolver22ComplainNoMatchesFoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK12_GLOBAL__N_125AddressOfFunctionResolver22ComplainNoMatchesFoundEv")
  //</editor-fold>
  public void ComplainNoMatchesFound() /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (Matches.empty());
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(OvlExpr.getLocStart(), diag.err_addr_ovl_no_viable)), 
                  OvlExpr.getName()), TargetFunctionType), 
          OvlExpr.getSourceRange()));
      if (FailedCandidates.empty()) {
        S.NoteAllOverloadCandidates(OvlExpr, new QualType(TargetFunctionType), 
            /*TakingAddress=*/ true);
      } else {
        // We have some deduction failure messages. Use them to diagnose
        // the function templates, and diagnose the non-template candidates
        // normally.
        for (UnresolvedSetIterator I = OvlExpr.decls_begin(), 
            IEnd = OvlExpr.decls_end();
             I.$noteq(IEnd); I.$preInc())  {
          {
            FunctionDecl /*P*/ Fun = dyn_cast_FunctionDecl((I.$star()).getUnderlyingDecl());
            if ((Fun != null)) {
              if (!functionHasPassObjectSizeParams(Fun)) {
                S.NoteOverloadCandidate(I.$star(), Fun, new QualType(TargetFunctionType), 
                    /*TakingAddress=*/ true);
              }
            }
          }
        }
        FailedCandidates.NoteCandidates$Const(S, OvlExpr.getLocStart());
      }
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::IsInvalidFormOfPointerToMemberFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10615,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::IsInvalidFormOfPointerToMemberFunction", NM="_ZNK12_GLOBAL__N_125AddressOfFunctionResolver38IsInvalidFormOfPointerToMemberFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK12_GLOBAL__N_125AddressOfFunctionResolver38IsInvalidFormOfPointerToMemberFunctionEv")
  //</editor-fold>
  public boolean IsInvalidFormOfPointerToMemberFunction() /*const*/ {
    return TargetTypeIsNonStaticMemberFunction
       && !OvlExprInfo.HasFormOfMemberPointer;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::ComplainIsInvalidFormOfPointerToMemberFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10620,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::ComplainIsInvalidFormOfPointerToMemberFunction", NM="_ZNK12_GLOBAL__N_125AddressOfFunctionResolver46ComplainIsInvalidFormOfPointerToMemberFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK12_GLOBAL__N_125AddressOfFunctionResolver46ComplainIsInvalidFormOfPointerToMemberFunctionEv")
  //</editor-fold>
  public void ComplainIsInvalidFormOfPointerToMemberFunction() /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // TODO: Should we condition this on whether any functions might
      // have matched, or is it more appropriate to do that in callers?
      // TODO: a fixit wouldn't hurt.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(OvlExpr.getNameLoc(), diag.err_addr_ovl_no_qualifier)), 
              TargetType), OvlExpr.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::IsStaticMemberFunctionFromBoundPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10628,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::IsStaticMemberFunctionFromBoundPointer", NM="_ZNK12_GLOBAL__N_125AddressOfFunctionResolver38IsStaticMemberFunctionFromBoundPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK12_GLOBAL__N_125AddressOfFunctionResolver38IsStaticMemberFunctionFromBoundPointerEv")
  //</editor-fold>
  public boolean IsStaticMemberFunctionFromBoundPointer() /*const*/ {
    return StaticMemberFunctionFromBoundPointer;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::ComplainIsStaticMemberFunctionFromBoundPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10632,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::ComplainIsStaticMemberFunctionFromBoundPointer", NM="_ZNK12_GLOBAL__N_125AddressOfFunctionResolver46ComplainIsStaticMemberFunctionFromBoundPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK12_GLOBAL__N_125AddressOfFunctionResolver46ComplainIsStaticMemberFunctionFromBoundPointerEv")
  //</editor-fold>
  public void ComplainIsStaticMemberFunctionFromBoundPointer() /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(OvlExpr.getLocStart(), 
              diag.err_invalid_form_pointer_member_function)), 
          OvlExpr.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::ComplainOfInvalidConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10638,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::ComplainOfInvalidConversion", NM="_ZNK12_GLOBAL__N_125AddressOfFunctionResolver27ComplainOfInvalidConversionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK12_GLOBAL__N_125AddressOfFunctionResolver27ComplainOfInvalidConversionEv")
  //</editor-fold>
  public void ComplainOfInvalidConversion() /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(OvlExpr.getLocStart(), diag.err_addr_ovl_not_func_ptrref)), 
              OvlExpr.getName()), TargetType));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::ComplainMultipleMatchesFound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10643,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::ComplainMultipleMatchesFound", NM="_ZNK12_GLOBAL__N_125AddressOfFunctionResolver28ComplainMultipleMatchesFoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK12_GLOBAL__N_125AddressOfFunctionResolver28ComplainMultipleMatchesFoundEv")
  //</editor-fold>
  public void ComplainMultipleMatchesFound() /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ($greater_uint(Matches.size(), 1));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(OvlExpr.getLocStart(), diag.err_addr_ovl_ambiguous)), 
              OvlExpr.getName()), 
          OvlExpr.getSourceRange()));
      S.NoteAllOverloadCandidates(OvlExpr, new QualType(TargetFunctionType), 
          /*TakingAddress=*/ true);
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::hadMultipleCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10652,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::hadMultipleCandidates", NM="_ZNK12_GLOBAL__N_125AddressOfFunctionResolver21hadMultipleCandidatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK12_GLOBAL__N_125AddressOfFunctionResolver21hadMultipleCandidatesEv")
  //</editor-fold>
  public boolean hadMultipleCandidates() /*const*/ {
    return ($greater_uint(OvlExpr.getNumDecls(), 1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::getNumMatches">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10654,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::getNumMatches", NM="_ZNK12_GLOBAL__N_125AddressOfFunctionResolver13getNumMatchesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK12_GLOBAL__N_125AddressOfFunctionResolver13getNumMatchesEv")
  //</editor-fold>
  public int getNumMatches() /*const*/ {
    return Matches.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::getMatchingFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10656,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::getMatchingFunctionDecl", NM="_ZNK12_GLOBAL__N_125AddressOfFunctionResolver23getMatchingFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK12_GLOBAL__N_125AddressOfFunctionResolver23getMatchingFunctionDeclEv")
  //</editor-fold>
  public FunctionDecl /*P*/ getMatchingFunctionDecl() /*const*/ {
    if (Matches.size() != 1) {
      return null;
    }
    return Matches.$at$Const(0).second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::getMatchingFunctionAccessPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10661,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::getMatchingFunctionAccessPair", NM="_ZNK12_GLOBAL__N_125AddressOfFunctionResolver29getMatchingFunctionAccessPairEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK12_GLOBAL__N_125AddressOfFunctionResolver29getMatchingFunctionAccessPairEv")
  //</editor-fold>
  public /*const*/ DeclAccessPair /*P*/ getMatchingFunctionAccessPair() /*const*/ {
    if (Matches.size() != 1) {
      return null;
    }
    return $AddrOf(Matches.$at$Const(0).first);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressOfFunctionResolver::~AddressOfFunctionResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10275,
   FQN="(anonymous namespace)::AddressOfFunctionResolver::~AddressOfFunctionResolver", NM="_ZN12_GLOBAL__N_125AddressOfFunctionResolverD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_125AddressOfFunctionResolverD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FailedCandidates.$destroy();
    Matches.$destroy();
    OvlExplicitTemplateArgs.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", SourceExpr=" + SourceExpr // NOI18N
              + ", TargetType=" + TargetType // NOI18N
              + ", TargetFunctionType=" + TargetFunctionType // NOI18N
              + ", Complain=" + Complain // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + ", TargetTypeIsNonStaticMemberFunction=" + TargetTypeIsNonStaticMemberFunction // NOI18N
              + ", FoundNonTemplateFunction=" + FoundNonTemplateFunction // NOI18N
              + ", StaticMemberFunctionFromBoundPointer=" + StaticMemberFunctionFromBoundPointer // NOI18N
              + ", HasComplained=" + HasComplained // NOI18N
              + ", OvlExprInfo=" + OvlExprInfo // NOI18N
              + ", OvlExpr=" + OvlExpr // NOI18N
              + ", OvlExplicitTemplateArgs=" + OvlExplicitTemplateArgs // NOI18N
              + ", Matches=" + Matches // NOI18N
              + ", FailedCandidates=" + FailedCandidates; // NOI18N
  }
}
