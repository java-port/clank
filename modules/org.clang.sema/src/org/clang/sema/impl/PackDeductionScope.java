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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.impl.SemaTemplateDeductionStatics.*;

/// A scope in which we're performing pack deduction.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PackDeductionScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 577,
 FQN="(anonymous namespace)::PackDeductionScope", NM="_ZN12_GLOBAL__N_118PackDeductionScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN12_GLOBAL__N_118PackDeductionScopeE")
//</editor-fold>
public class PackDeductionScope implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PackDeductionScope::PackDeductionScope">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*tie*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 579,
   FQN="(anonymous namespace)::PackDeductionScope::PackDeductionScope", NM="_ZN12_GLOBAL__N_118PackDeductionScopeC1ERN5clang4SemaEPNS1_21TemplateParameterListERN4llvm15SmallVectorImplINS1_23DeducedTemplateArgumentEEERNS1_4sema21TemplateDeductionInfoENS1_16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN12_GLOBAL__N_118PackDeductionScopeC1ERN5clang4SemaEPNS1_21TemplateParameterListERN4llvm15SmallVectorImplINS1_23DeducedTemplateArgumentEEERNS1_4sema21TemplateDeductionInfoENS1_16TemplateArgumentE")
  //</editor-fold>
  public PackDeductionScope(final Sema /*&*/ S, TemplateParameterList /*P*/ TemplateParams, 
      final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced, 
      final TemplateDeductionInfo /*&*/ Info, TemplateArgument Pattern) {
    // : S(S), TemplateParams(TemplateParams), Deduced(Deduced), Info(Info), Packs() 
    //START JInit
    this./*&*/S=/*&*/S;
    this.TemplateParams = TemplateParams;
    this./*&*/Deduced=/*&*/Deduced;
    this./*&*/Info=/*&*/Info;
    this.Packs = new SmallVector<DeducedPack>(2, new DeducedPack());
    //END JInit
    {
      SmallBitVector SawIndices/*J*/= new SmallBitVector(TemplateParams.size());
      SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
      S.collectUnexpandedParameterPacks_TemplateArgument(new TemplateArgument(Pattern), Unexpanded);
      for (/*uint*/int I = 0, N = Unexpanded.size(); I != N; ++I) {
        // JAVA: unfold tie
        std.pairUIntUInt $pair = getDepthAndIndex(new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(Unexpanded.$at(I)));
        /*uint*/int Depth = $pair.first;
        /*uint*/int Index = $pair.second;
        if (Depth == 0 && !SawIndices.$at$Const(Index)) {
          DeducedPack Pack = null;
          try {
            SawIndices.set(Index);

            // Save the deduced template argument for the parameter pack expanded
            // by this pack expansion, then clear out the deduction.
            Pack/*J*/= new DeducedPack(Index);
            Pack.Saved.$assign(Deduced.$at(Index));
            Deduced.$at(Index).$assignMove(new DeducedTemplateArgument(new TemplateArgument()));

            Packs.push_back_T$C$R(Pack);
          } finally {
            if (Pack != null) { Pack.$destroy(); }
          }
        }
      }
    }
    assert (!Packs.empty()) : "Pack expansion without unexpanded packs?";
    
    for (final DeducedPack /*&*/ Pack : Packs) {
      if ($greater_uint(Info.PendingDeducedPacks.size(), Pack.Index)) {
        Pack.Outer = Info.PendingDeducedPacks.$at(Pack.Index);
      } else {
        Info.PendingDeducedPacks.resize(Pack.Index + 1);
      }
      Info.PendingDeducedPacks.$set(Pack.Index, $AddrOf(Pack));
      if ((S.CurrentInstantiationScope != null)) {
        // If the template argument pack was explicitly specified, add that to
        // the set of deduced arguments.
        type$ptr<type$ptr</*const*/ TemplateArgument /*P*/ >> ExplicitArgs = ((type$ptr)create_type$ptr()).$addr();
        uint$ptr NumExplicitArgs = create_uint$ptr();
        NamedDecl /*P*/ PartiallySubstitutedPack = S.CurrentInstantiationScope.getPartiallySubstitutedPack($AddrOf(ExplicitArgs), $AddrOf(NumExplicitArgs));
        if ((PartiallySubstitutedPack != null)
           && SemaTemplateDeductionStatics.getDepthAndIndex(PartiallySubstitutedPack).second == Pack.Index) {          
          Pack.New.append_T(ExplicitArgs.$star(), ExplicitArgs.$star().$add(NumExplicitArgs.$star()), 
                  (TemplateArgument ta) -> new DeducedTemplateArgument(ta));
        }
      }
    }
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PackDeductionScope::~PackDeductionScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 629,
   FQN="(anonymous namespace)::PackDeductionScope::~PackDeductionScope", NM="_ZN12_GLOBAL__N_118PackDeductionScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN12_GLOBAL__N_118PackDeductionScopeD0Ev")
  //</editor-fold>
  public void $destroy() {
    for (final DeducedPack /*&*/ Pack : Packs)  {
      Info.PendingDeducedPacks.$set(Pack.Index, Pack.Outer);
    }
    //START JDestroy
    Packs.$destroy();
    //END JDestroy
  }

  
  /// Move to deducing the next element in each pack that is being deduced.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PackDeductionScope::nextPackElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 635,
   FQN="(anonymous namespace)::PackDeductionScope::nextPackElement", NM="_ZN12_GLOBAL__N_118PackDeductionScope15nextPackElementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN12_GLOBAL__N_118PackDeductionScope15nextPackElementEv")
  //</editor-fold>
  public void nextPackElement() {
    // Capture the deduced template arguments for each parameter pack expanded
    // by this pack expansion, add them to the list of arguments we've deduced
    // for that pack, then clear out the deduced argument.
    for (final DeducedPack /*&*/ Pack : Packs) {
      final DeducedTemplateArgument /*&*/ DeducedArg = Deduced.$at(Pack.Index);
      if (!DeducedArg.isNull()) {
        Pack.New.push_back(DeducedArg);
        DeducedArg.$assignMove(new DeducedTemplateArgument());
      }
    }
  }

  
  /// \brief Finish template argument deduction for a set of argument packs,
  /// producing the argument packs and checking for consistency with prior
  /// deductions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PackDeductionScope::finish">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 651,
   FQN="(anonymous namespace)::PackDeductionScope::finish", NM="_ZN12_GLOBAL__N_118PackDeductionScope6finishEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN12_GLOBAL__N_118PackDeductionScope6finishEb")
  //</editor-fold>
  public Sema.TemplateDeductionResult finish(boolean HasAnyArguments) {
    // Build argument packs for each of the parameter packs expanded by this
    // pack expansion.
    for (final DeducedPack /*&*/ Pack : Packs) {
      // Put back the old value for this pack.
      Deduced.$at(Pack.Index).$assign(Pack.Saved);
      
      // Build or find a new value for this pack.
      DeducedTemplateArgument NewPack/*J*/= new DeducedTemplateArgument();
      if (HasAnyArguments && Pack.New.empty()) {
        if (Pack.DeferredDeduction.isNull()) {
          // We were not able to deduce anything for this parameter pack
          // (because it only appeared in non-deduced contexts), so just
          // restore the saved argument pack.
          continue;
        }
        
        NewPack.$assign(Pack.DeferredDeduction);
        Pack.DeferredDeduction.$assignMove(new DeducedTemplateArgument(new TemplateArgument()));
      } else if (Pack.New.empty()) {
        // If we deduced an empty argument pack, create it now.
        NewPack.$assignMove(new DeducedTemplateArgument(TemplateArgument.getEmptyPack()));
      } else {
        TemplateArgument[] /*P*/ ArgumentPack = /*FIXME:NEW_EXPR*//*new (S.Context)*/ new TemplateArgument [Pack.New.size()];
        std.copy(Pack.New.begin(), Pack.New.end(), create_type$ptr(ArgumentPack));
        NewPack.$assignMove(new DeducedTemplateArgument(new TemplateArgument(llvm.makeArrayRef(ArgumentPack, Pack.New.size())), 
                Pack.New.$at(0).wasDeducedFromArrayBound()));
      }
      
      // Pick where we're going to put the merged pack.
      DeducedTemplateArgument /*P*/ Loc;
      if ((Pack.Outer != null)) {
        if (Pack.Outer.DeferredDeduction.isNull()) {
          // Defer checking this pack until we have a complete pack to compare
          // it against.
          Pack.Outer.DeferredDeduction.$assign(NewPack);
          continue;
        }
        Loc = $AddrOf(Pack.Outer.DeferredDeduction);
      } else {
        Loc = $AddrOf(Deduced.$at(Pack.Index));
      }
      
      // Check the new pack matches any previous value.
      DeducedTemplateArgument OldPack = new DeducedTemplateArgument($Deref(Loc));
      DeducedTemplateArgument Result = checkDeducedTemplateArguments(S.Context, OldPack, NewPack);
      
      // If we deferred a deduction of this pack, check that one now too.
      if (!Result.isNull() && !Pack.DeferredDeduction.isNull()) {
        OldPack.$assign(Result);
        NewPack.$assign(Pack.DeferredDeduction);
        Result.$assignMove(checkDeducedTemplateArguments(S.Context, OldPack, NewPack));
      }
      if (Result.isNull()) {
        Info.Param.$assignMove(
            makeTemplateParameter(TemplateParams.getParam(Pack.Index))
        );
        Info.FirstArg.$assign(OldPack);
        Info.SecondArg.$assign(NewPack);
        return Sema.TemplateDeductionResult.TDK_Inconsistent;
      }
      
      /*Deref*/Loc.$assign(Result);
    }
    
    return Sema.TemplateDeductionResult.TDK_Success;
  }

/*private:*/
  private final Sema /*&*/ S;
  private TemplateParameterList /*P*/ TemplateParams;
  private final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced;
  private final TemplateDeductionInfo /*&*/ Info;
  
  private SmallVector<DeducedPack> Packs;
  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", TemplateParams=" + TemplateParams // NOI18N
              + ", Deduced=" + Deduced // NOI18N
              + ", Info=" + Info // NOI18N
              + ", Packs=" + Packs; // NOI18N
  }
}
