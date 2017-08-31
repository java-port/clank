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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.aliases.*;
import static org.clang.ast.Qualifiers.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaMemberPointers.*;
import static org.clang.sema.impl.SemaCodeCompleteStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.ast.llvm.DenseMapInfoDeclarationName;


/// \brief A container of code-completion results.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 42,
 FQN="(anonymous namespace)::ResultBuilder", NM="_ZN12_GLOBAL__N_113ResultBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilderE")
//</editor-fold>
public class ResultBuilder implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief The type of a name-lookup filter, which can be provided to the
  /// name-lookup routines to specify which declarations should be included in
  /// the result set (when it returns true) and which declarations should be
  /// filtered out (returns false).
  /*typedef bool (ResultBuilder::*LookupFilter)(const NamedDecl *) const*/
//  public final class LookupFilter extends ResultBuilder$LookupFilter{ };
  
  /*typedef CodeCompletionResult Result*/
//  public final class Result extends CodeCompletionResult{ };
/*private:*/
  /// \brief The actual results we have found.
  private std.vector<CodeCompletionResult> Results;
  
  /// \brief A record of all of the declarations we have found and placed
  /// into the result set, used to ensure that no declaration ever gets into
  /// the result set twice.
  private SmallPtrSet</*const*/ Decl /*P*/ > AllDeclsFound;
  
  /*typedef std::pair<const NamedDecl *, unsigned int> DeclIndexPair*/
//  public final class DeclIndexPair extends std.pairTypeUInt</*const*/ NamedDecl /*P*/ >{ };
  
  /// \brief An entry in the shadow map, which is optimized to store
  /// a single (declaration, index) mapping (the common case) but
  /// can also store a list of (declaration, index) mappings.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 66,
   FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntryE")
  //</editor-fold>
  private static class ShadowMapEntry implements NativeCloneable<ShadowMapEntry> {
    /*typedef SmallVector<DeclIndexPair, 4> DeclIndexPairVector*/
//    public final class DeclIndexPairVector extends SmallVector<std.pairTypeUInt</*const*/ NamedDecl /*P*/ >>{ };
    
    /// \brief Contains either the solitary NamedDecl * or a vector
    /// of (declaration, index) pairs.
    private PointerUnion</*const*/ NamedDecl /*P*/ , SmallVector/*<std.pairTypeUInt<NamedDecl>>*/ /*P*/> DeclOrVector;
    
    /// \brief When the entry contains a single declaration, this is
    /// the index associated with that entry.
    private /*uint*/int SingleDeclIndex;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::ShadowMapEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 78,
     FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::ShadowMapEntry", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntryC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntryC1Ev")
    //</editor-fold>
    public ShadowMapEntry() {
      // : DeclOrVector(), SingleDeclIndex(0) 
      //START JInit
      this.DeclOrVector = new PointerUnion<>(/*const*/ NamedDecl /*P*/ .class);
      this.SingleDeclIndex = 0;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::Add">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 80,
     FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::Add", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry3AddEPKN5clang9NamedDeclEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry3AddEPKN5clang9NamedDeclEj")
    //</editor-fold>
    public void Add(/*const*/ NamedDecl /*P*/ ND, /*uint*/int Index) {
      if (DeclOrVector.isNull()) {
        // 0 - > 1 elements: just set the single element information.
        DeclOrVector.$assign_T$C$R(NamedDecl /*P*/.class, ND);
        SingleDeclIndex = Index;
        return;
      }
      {
        
        /*const*/ NamedDecl /*P*/ PrevND = DeclOrVector.dyn_cast(/*const*/ NamedDecl /*P*/.class);
        if ((PrevND != null)) {
          // 1 -> 2 elements: create the vector of results and push in the
          // existing declaration.
          SmallVector<std.pairTypeUInt</*const*/ NamedDecl /*P*/ >> /*P*/ Vec = new SmallVector<std.pairTypeUInt</*const*/ NamedDecl /*P*/ >>(4, new std.pairPtrUInt</*const*/ NamedDecl /*P*/ >());
          Vec.push_back(new std.pairPtrUInt</*const*/ NamedDecl /*P*/ >(JD$T$RR_T1$RR.INSTANCE, PrevND, SingleDeclIndex));
          ((PointerUnion)DeclOrVector).$assign_T1$C$R(SmallVector /*P*/.class, Vec);
        }
      }
      
      // Add the new element to the end of the vector.
      DeclOrVector.get(SmallVector /*P*/.class).push_back(new std.pairPtrUInt</*const*/ NamedDecl /*P*/ >(JD$T$RR_T1$RR.INSTANCE, ND, Index));
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::Destroy">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 102,
     FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::Destroy", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry7DestroyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry7DestroyEv")
    //</editor-fold>
    public void Destroy() {
      {
        SmallVector<std.pairTypeUInt</*const*/ NamedDecl /*P*/ >> /*P*/ Vec = DeclOrVector.dyn_cast(SmallVector /*P*/.class);
        if ((Vec != null)) {
          if (Vec != null) { Vec.$destroy();};
          DeclOrVector.$assign_T$C$R(NamedDecl /*P*/.class, (NamedDecl /*P*/ )null);
        }
      }
    }

    
    // Iteration.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 346,
     FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratorE")
    //</editor-fold>
    public static class iterator {
      private PointerUnion</*const*/ NamedDecl /*P*/ , /*const*/type$ptr<std.pairTypeUInt</*const*/ NamedDecl /*P*/>>> DeclOrIterator;
      private /*uint*/int SingleDeclIndex;
    /*public:*/
      /*typedef DeclIndexPair value_type*/
//      public final class value_type extends std.pairTypeUInt</*const*/ NamedDecl /*P*/ >{ };
      /*typedef value_type reference*/
//      public final class reference extends std.pairTypeUInt</*const*/ NamedDecl /*P*/ >{ };
      /*typedef std::ptrdiff_t difference_type*/;
      /*typedef std::input_iterator_tag iterator_category*/
//      public final class iterator_category extends std.input_iterator_tag{ };
      
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::pointer">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 356,
       FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::pointer", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iterator7pointerE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iterator7pointerE")
      //</editor-fold>
      public static class pointer {
        private std.pairTypeUInt</*const*/ NamedDecl /*P*/ > Value;
      /*public:*/
        //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::pointer::pointer">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 360,
         FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::pointer::pointer", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iterator7pointerC1ERKSt4pairIPKN5clang9NamedDeclEjE",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iterator7pointerC1ERKSt4pairIPKN5clang9NamedDeclEjE")
        //</editor-fold>
        public pointer(final /*const*/std.pairTypeUInt</*const*/ NamedDecl /*P*/ > /*&*/ Value) {
          // : Value(Value) 
          //START JInit
          this.Value = new std.pairPtrUInt</*const*/ NamedDecl /*P*/ >(Value);
          //END JInit
        }

        
        //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::pointer::operator->">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 362,
         FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::pointer::operator->", NM="_ZNK12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iterator7pointerptEv",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iterator7pointerptEv")
        //</editor-fold>
        public /*const*/std.pairTypeUInt</*const*/ NamedDecl /*P*/ > /*P*/ $arrow() /*const*/ {
          return $AddrOf(Value);
        }

        //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::pointer::pointer">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 356,
         FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::pointer::pointer", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iterator7pointerC1EOS3_",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iterator7pointerC1EOS3_")
        //</editor-fold>
        public /*inline*/ pointer(JD$Move _dparam, final pointer /*&&*/$Prm0) {
          // : Value(static_cast<pointer &&>().Value) 
          //START JInit
          this.Value = new std.pairPtrUInt</*const*/ NamedDecl /*P*/ >(JD$Move.INSTANCE, $Prm0.Value);
          //END JInit
        }

        
        @Override public String toString() {
          return "" + "Value=" + Value; // NOI18N
        }
      };
      
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::iterator">
      @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 367,
       FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::iterator", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratorC1Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratorC1Ev")
      //</editor-fold>
      public iterator() {
        // : DeclOrIterator((NamedDecl * )null), SingleDeclIndex(0) 
        //START JInit
        this.DeclOrIterator = new PointerUnion(JD$T.INSTANCE, /*const*/ NamedDecl /*P*/ .class, (NamedDecl /*P*/ )null);
        this.SingleDeclIndex = 0;
        //END JInit
      }

      
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::iterator">
      @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 369,
       FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::iterator", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratorC1EPKN5clang9NamedDeclEj",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratorC1EPKN5clang9NamedDeclEj")
      //</editor-fold>
      public iterator(/*const*/ NamedDecl /*P*/ SingleDecl, /*uint*/int Index) {
        // : DeclOrIterator(SingleDecl), SingleDeclIndex(Index) 
        //START JInit
        this.DeclOrIterator = new PointerUnion(JD$T.INSTANCE, /*const*/ NamedDecl /*P*/ .class, SingleDecl);
        this.SingleDeclIndex = Index;
        //END JInit
      }

      
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::iterator">
      @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 372,
       FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::iterator", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratorC1EPKSt4pairIPKN5clang9NamedDeclEjE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratorC1EPKSt4pairIPKN5clang9NamedDeclEjE")
      //</editor-fold>
      public iterator(/*const*/std.pairTypeUInt</*const*/ NamedDecl /*P*/ > /*P*/ Iterator) {
        // : DeclOrIterator(Iterator), SingleDeclIndex(0) 
        //START JInit
        this.DeclOrIterator = new PointerUnion(JD$T1.INSTANCE, type$ptr/*std.pairTypeUInt<const NamedDecl P>*/.class, Iterator);
        this.SingleDeclIndex = 0;
        //END JInit
      }

      
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::operator++">
      @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 375,
       FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::operator++", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratorppEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratorppEv")
      //</editor-fold>
      public iterator /*&*/ $preInc() {
        if ((DeclOrIterator.is(/*const*/ NamedDecl /*P*/.class) != 0)) {
          DeclOrIterator.$assign_T$C$R(NamedDecl /*P*/.class, (NamedDecl /*P*/ )null);
          SingleDeclIndex = 0;
          return /*Deref*/this;
        }
        
        /*const*/type$ptr<std.pairTypeUInt</*const*/ NamedDecl /*P*/ >> /*P*/ I = DeclOrIterator.get(type$ptr/*std.pairTypeUInt<const NamedDecl P>*/.class);
        I.$preInc();
        ((PointerUnion)DeclOrIterator).$assign_T1$C$R(type$ptr/*std.pairTypeUInt<const NamedDecl P>*/.class, I);
        return /*Deref*/this;
      }

      
      /*iterator operator++(int) {
      iterator tmp(*this);
      ++(*this);
      return tmp;
      }*/
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::operator*">
      @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 394,
       FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::operator*", NM="_ZNK12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratordeEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratordeEv")
      //</editor-fold>
      public std.pairTypeUInt</*const*/ NamedDecl /*P*/ > $star() /*const*/ {
        {
          /*const*/ NamedDecl /*P*/ ND = DeclOrIterator.dyn_cast(/*const*/ NamedDecl /*P*/.class);
          if ((ND != null)) {
            return new std.pairPtrUInt</*const*/ NamedDecl /*P*/>(JD$T$RR_T1$C$R.INSTANCE, ND, SingleDeclIndex);
          }
        }
        
        return new std.pairPtrUInt</*const*/ NamedDecl /*P*/ >(/*Deref*/(std.pairTypeUInt</*const*/ NamedDecl /*P*/ >)DeclOrIterator.get(/*const*/type$ptr/*std.pairTypeUInt<const NamedDecl P>*/.class).$star());
      }

      
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::operator->">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 401,
       FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::operator->", NM="_ZNK12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratorptEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratorptEv")
      //</editor-fold>
      public pointer $arrow() /*const*/ {
        return new pointer($Deref(this.$star()));
      }

      
      /*friend*///<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::operator==">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 405,
       FQN="(anonymous namespace)::operator==", NM="_ZN12_GLOBAL__N_1eqERKNS_13ResultBuilder14ShadowMapEntry8iteratorES4_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_1eqERKNS_13ResultBuilder14ShadowMapEntry8iteratorES4_")
      //</editor-fold>
      public static boolean $eq_iterator$C(final /*const*/ iterator /*&*/ X, final /*const*/ iterator /*&*/ Y) {
        return $eq_ptr(X.DeclOrIterator.getOpaqueValue(), Y.DeclOrIterator.getOpaqueValue())
           && X.SingleDeclIndex == Y.SingleDeclIndex;
      }

      
      /*friend*///<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::operator!=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 411,
       FQN="(anonymous namespace)::operator!=", NM="_ZN12_GLOBAL__N_1neERKNS_13ResultBuilder14ShadowMapEntry8iteratorES4_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_1neERKNS_13ResultBuilder14ShadowMapEntry8iteratorES4_")
      //</editor-fold>
      public static boolean $noteq_iterator$C(final /*const*/ iterator /*&*/ X, final /*const*/ iterator /*&*/ Y) {
        return !($eq_iterator$C(X, Y));
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::iterator">
      @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 346,
       FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::iterator", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratorC1EOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratorC1EOS2_")
      //</editor-fold>
      public /*inline*/ iterator(JD$Move _dparam, final iterator /*&&*/$Prm0) {
        // : DeclOrIterator(static_cast<iterator &&>().DeclOrIterator), SingleDeclIndex(static_cast<iterator &&>().SingleDeclIndex) 
        //START JInit
        this.DeclOrIterator = new PointerUnion(JD$Move.INSTANCE, $Prm0.DeclOrIterator);
        this.SingleDeclIndex = $Prm0.SingleDeclIndex;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 346,
       FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::iterator::operator=", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratoraSEOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntry8iteratoraSEOS2_")
      //</editor-fold>
      public /*inline*/ iterator /*&*/ $assignMove(final iterator /*&&*/$Prm0) {
        this.DeclOrIterator.$assignMove($Prm0.DeclOrIterator);
        this.SingleDeclIndex = $Prm0.SingleDeclIndex;
        return /*Deref*/this;
      }

      
      @Override public String toString() {
        return "" + "DeclOrIterator=" + DeclOrIterator // NOI18N
                  + ", SingleDeclIndex=" + SingleDeclIndex; // NOI18N
      }
    };
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::begin">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 416,
     FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::begin", NM="_ZNK12_GLOBAL__N_113ResultBuilder14ShadowMapEntry5beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder14ShadowMapEntry5beginEv")
    //</editor-fold>
    public ResultBuilder.ShadowMapEntry.iterator begin() /*const*/ {
      if (DeclOrVector.isNull()) {
        return new iterator();
      }
      {
        
        /*const*/ NamedDecl /*P*/ ND = DeclOrVector.dyn_cast(/*const*/ NamedDecl /*P*/.class);
        if ((ND != null)) {
          return new iterator(ND, SingleDeclIndex);
        }
      }
      return new iterator((std.pairTypeUInt<NamedDecl>)DeclOrVector.get(SmallVector /*P*/.class).begin());
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::end">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 427,
     FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::end", NM="_ZNK12_GLOBAL__N_113ResultBuilder14ShadowMapEntry3endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder14ShadowMapEntry3endEv")
    //</editor-fold>
    public ResultBuilder.ShadowMapEntry.iterator end() /*const*/ {
      if ((DeclOrVector.is(/*const*/ NamedDecl /*P*/.class) != 0) || DeclOrVector.isNull()) {
        return new iterator();
      }
      
      return new iterator((std.pairTypeUInt<NamedDecl >)DeclOrVector.get(SmallVector /*P*/.class).end());
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::ShadowMapEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 66,
     FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::ShadowMapEntry", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntryC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntryC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ShadowMapEntry(final /*const*/ ShadowMapEntry /*&*/ $Prm0) {
      // : DeclOrVector(.DeclOrVector), SingleDeclIndex(.SingleDeclIndex) 
      //START JInit
      this.DeclOrVector = new PointerUnion<>($Prm0.DeclOrVector);
      this.SingleDeclIndex = $Prm0.SingleDeclIndex;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ShadowMapEntry::ShadowMapEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 66,
     FQN="(anonymous namespace)::ResultBuilder::ShadowMapEntry::ShadowMapEntry", NM="_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntryC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14ShadowMapEntryC1EOS1_")
    //</editor-fold>
    public /*inline*/ ShadowMapEntry(JD$Move _dparam, final ShadowMapEntry /*&&*/$Prm0) {
      // : DeclOrVector(static_cast<ShadowMapEntry &&>().DeclOrVector), SingleDeclIndex(static_cast<ShadowMapEntry &&>().SingleDeclIndex) 
      //START JInit
      this.DeclOrVector = new PointerUnion</*const*/ NamedDecl /*P*/ , SmallVector/*<std.pairTypeUInt<NamedDecl>>*/ /*P*/>(JD$Move.INSTANCE, $Prm0.DeclOrVector);
      this.SingleDeclIndex = $Prm0.SingleDeclIndex;
      //END JInit
    }

    @Override public ShadowMapEntry clone() { return new ShadowMapEntry(this); }
    
    @Override public String toString() {
      return "" + "DeclOrVector=" + DeclOrVector // NOI18N
                + ", SingleDeclIndex=" + SingleDeclIndex; // NOI18N
    }
  };
  
  /// \brief A mapping from declaration names to the declarations that have
  /// this name within a particular scope and their index within the list of
  /// results.
  /*typedef llvm::DenseMap<DeclarationName, ShadowMapEntry> ShadowMap*/
//  public final class ShadowMap extends DenseMap<DeclarationName, ShadowMapEntry>{ };
  
  /// \brief The semantic analysis object for which results are being 
  /// produced.
  private final Sema /*&*/ SemaRef;
  
  /// \brief The allocator used to allocate new code-completion strings.
  private final CodeCompletionAllocator /*&*/ Allocator;
  
  private final CodeCompletionTUInfo /*&*/ CCTUInfo;
  
  /// \brief If non-NULL, a filter function used to remove any code-completion
  /// results that are not desirable.
  private ResultBuilder$LookupFilter Filter;
  
  /// \brief Whether we should allow declarations as
  /// nested-name-specifiers that would otherwise be filtered out.
  private boolean AllowNestedNameSpecifiers;
  
  /// \brief If set, the type that we would prefer our resulting value
  /// declarations to have.
  ///
  /// Closely matching the preferred type gives a boost to a result's 
  /// priority.
  private CanQual<Type> PreferredType;
  
  /// \brief A list of shadow maps, which is used to model name hiding at
  /// different levels of, e.g., the inheritance hierarchy.
  private std.list<DenseMap<DeclarationName, ShadowMapEntry> > ShadowMaps;
  
  /// \brief If we're potentially referring to a C++ member function, the set
  /// of qualifiers applied to the object type.
  private Qualifiers ObjectTypeQualifiers;
  
  /// \brief Whether the \p ObjectTypeQualifiers field is active.
  private boolean HasObjectTypeQualifiers;
  
  /// \brief The selector that we prefer.
  private Selector PreferredSelector;
  
  /// \brief The completion context in which we are gathering results.
  private CodeCompletionContext CompletionContext;
  
  /// \brief If we are in an instance method definition, the \@implementation
  /// object.
  private ObjCImplementationDecl /*P*/ ObjCImplementation;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::AdjustResultPriorityForDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 765,
   FQN="(anonymous namespace)::ResultBuilder::AdjustResultPriorityForDecl", NM="_ZN12_GLOBAL__N_113ResultBuilder27AdjustResultPriorityForDeclERN5clang20CodeCompletionResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder27AdjustResultPriorityForDeclERN5clang20CodeCompletionResultE")
  //</editor-fold>
  private void AdjustResultPriorityForDecl(final CodeCompletionResult /*&*/ R) {
    // If this is an Objective-C method declaration whose selector matches our
    // preferred selector, give it a priority boost.
    if (!PreferredSelector.isNull()) {
      {
        /*const*/ ObjCMethodDecl /*P*/ Method = dyn_cast_ObjCMethodDecl(R.Declaration);
        if ((Method != null)) {
          if (PreferredSelector.$eq(Method.getSelector())) {
            R.Priority += CCD_SelectorMatch;
          }
        }
      }
    }
    
    // If we have a preferred type, adjust the priority for results with exactly-
    // matching or nearly-matching types.
    if (!PreferredType.isNull()) {
      QualType T = getDeclUsageType(SemaRef.Context, R.Declaration);
      if (!T.isNull()) {
        CanQual<Type> TC = SemaRef.Context.getCanonicalType(new QualType(T));
        // Check for exactly-matching types (modulo qualifiers).
        if (SemaRef.Context.hasSameUnqualifiedType(PreferredType.$QualType(), TC.$QualType())) {
          R.Priority = $div_uint(R.Priority, CCF_ExactTypeMatch);
        } else // Check for nearly-matching types, based on classification of each.
        if ((getSimplifiedTypeClass(new CanQual<Type>(PreferredType))
           == getSimplifiedTypeClass(new CanQual<Type>(TC)))
           && !(((CanProxyType)PreferredType.$arrow()).$arrow().isEnumeralType() && ((CanProxyType)TC.$arrow()).$arrow().isEnumeralType())) {
          R.Priority = $div_uint(R.Priority, CCF_SimilarTypeMatch);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::MaybeAddConstructorResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 791,
   FQN="(anonymous namespace)::ResultBuilder::MaybeAddConstructorResults", NM="_ZN12_GLOBAL__N_113ResultBuilder26MaybeAddConstructorResultsEN5clang20CodeCompletionResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder26MaybeAddConstructorResultsEN5clang20CodeCompletionResultE")
  //</editor-fold>
  private void MaybeAddConstructorResults(CodeCompletionResult R) {
    if (!SemaRef.getLangOpts().CPlusPlus || !(R.Declaration != null)
       || !CompletionContext.wantConstructorResults()) {
      return;
    }
    
    final ASTContext /*&*/ Context = SemaRef.Context;
    /*const*/ NamedDecl /*P*/ D = R.Declaration;
    /*const*/ CXXRecordDecl /*P*/ Record = null;
    {
      /*const*/ ClassTemplateDecl /*P*/ ClassTemplate = dyn_cast_ClassTemplateDecl(D);
      if ((ClassTemplate != null)) {
        Record = ClassTemplate.getTemplatedDecl();
      } else if (((Record = dyn_cast_CXXRecordDecl(D)) != null)) {
        // Skip specializations and partial specializations.
        if (isa_ClassTemplateSpecializationDecl(Record)) {
          return;
        }
      } else {
        // There are no constructors here.
        return;
      }
    }
    
    Record = Record.getDefinition();
    if (!(Record != null)) {
      return;
    }
    
    QualType RecordTy = Context.getTypeDeclType(Record);
    DeclarationName ConstructorName = Context.DeclarationNames.getCXXConstructorName(Context.getCanonicalType(new QualType(RecordTy)));
    DeclContextLookupResult Ctors = Record.lookup(new DeclarationName(ConstructorName));
    for (DeclContextLookupResult.iterator I = Ctors.begin(), 
        E = Ctors.end();
         I.$noteq(E); I.$preInc()) {
      R.Declaration = I.$star();
      R.CursorKind = getCursorKindForDecl(R.Declaration);
      Results.push_back_T$C$R(R);
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ResultBuilder">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 171,
   FQN="(anonymous namespace)::ResultBuilder::ResultBuilder", NM="_ZN12_GLOBAL__N_113ResultBuilderC1ERN5clang4SemaERNS1_23CodeCompletionAllocatorERNS1_20CodeCompletionTUInfoERKNS1_21CodeCompletionContextEMS0_KFbPKNS1_9NamedDeclEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilderC1ERN5clang4SemaERNS1_23CodeCompletionAllocatorERNS1_20CodeCompletionTUInfoERKNS1_21CodeCompletionContextEMS0_KFbPKNS1_9NamedDeclEE")
  //</editor-fold>
  public /*explicit*/ ResultBuilder(final Sema /*&*/ SemaRef, final CodeCompletionAllocator /*&*/ Allocator, 
      final CodeCompletionTUInfo /*&*/ CCTUInfo, 
      final /*const*/ CodeCompletionContext /*&*/ CompletionContext) {
    this(SemaRef, Allocator, 
      CCTUInfo, 
      CompletionContext, 
      null);
  }
  public /*explicit*/ ResultBuilder(final Sema /*&*/ SemaRef, final CodeCompletionAllocator /*&*/ Allocator, 
      final CodeCompletionTUInfo /*&*/ CCTUInfo, 
      final /*const*/ CodeCompletionContext /*&*/ CompletionContext, 
      ResultBuilder$LookupFilter Filter/*= null*/) {
    // : Results(), AllDeclsFound(), SemaRef(SemaRef), Allocator(Allocator), CCTUInfo(CCTUInfo), Filter(Filter), AllowNestedNameSpecifiers(false), PreferredType(), ShadowMaps(), ObjectTypeQualifiers(), HasObjectTypeQualifiers(false), PreferredSelector(), CompletionContext(CompletionContext), ObjCImplementation(null) 
    //START JInit
    this.Results = new std.vector<CodeCompletionResult>(new CodeCompletionResult());
    this.AllDeclsFound = new SmallPtrSet</*const*/ Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    this./*&*/SemaRef=/*&*/SemaRef;
    this./*&*/Allocator=/*&*/Allocator;
    this./*&*/CCTUInfo=/*&*/CCTUInfo;
    this.Filter = Filter;
    this.AllowNestedNameSpecifiers = false;
    this.PreferredType = new CanQual<Type>();
    this.ShadowMaps = new std.list<DenseMap<DeclarationName, ShadowMapEntry> >(
            new DenseMap<>(DenseMapInfoDeclarationName.$Info(), new ShadowMapEntry()));
    this.ObjectTypeQualifiers = new Qualifiers();
    this.HasObjectTypeQualifiers = false;
    this.PreferredSelector = new Selector();
    this.CompletionContext = new CodeCompletionContext(CompletionContext);
    this.ObjCImplementation = null;
    //END JInit
    // If this is an Objective-C instance method definition, dig out the 
    // corresponding implementation.
    switch (CompletionContext.getKind()) {
     case CCC_Expression:
     case CCC_ObjCMessageReceiver:
     case CCC_ParenthesizedExpression:
     case CCC_Statement:
     case CCC_Recovery:
      {
        ObjCMethodDecl /*P*/ Method = SemaRef.getCurMethodDecl();
        if ((Method != null)) {
          if (Method.isInstanceMethod()) {
            {
              ObjCInterfaceDecl /*P*/ Interface = Method.getClassInterface();
              if ((Interface != null)) {
                ObjCImplementation = Interface.getImplementation();
              }
            }
          }
        }
      }
      break;
     default:
      break;
    }
  }

  
  /// \brief Determine the priority for a reference to the given declaration.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::getBasePriority">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 726,
   FQN="(anonymous namespace)::ResultBuilder::getBasePriority", NM="_ZN12_GLOBAL__N_113ResultBuilder15getBasePriorityEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder15getBasePriorityEPKN5clang9NamedDeclE")
  //</editor-fold>
  public /*uint*/int getBasePriority(/*const*/ NamedDecl /*P*/ ND) {
    if (!(ND != null)) {
      return CCP_Unlikely;
    }
    
    // Context-based decisions.
    /*const*/ DeclContext /*P*/ LexicalDC = ND.getLexicalDeclContext$Const();
    if (LexicalDC.isFunctionOrMethod()) {
      {
        // _cmd is relatively rare
        /*const*/ ImplicitParamDecl /*P*/ ImplicitParam = dyn_cast_ImplicitParamDecl(ND);
        if ((ImplicitParam != null)) {
          if ((ImplicitParam.getIdentifier() != null)
             && ImplicitParam.getIdentifier().isStr(/*KEEP_STR*/"_cmd")) {
            return CCP_ObjC_cmd;
          }
        }
      }
      
      return CCP_LocalDeclaration;
    }
    
    /*const*/ DeclContext /*P*/ DC = ND.getDeclContext$Const().getRedeclContext$Const();
    if (DC.isRecord() || isa_ObjCContainerDecl(DC)) {
      return CCP_MemberDeclaration;
    }
    
    // Content-based decisions.
    if (isa_EnumConstantDecl(ND)) {
      return CCP_Constant;
    }
    
    // Use CCP_Type for type declarations unless we're in a statement, Objective-C
    // message receiver, or parenthesized expression context. There, it's as
    // likely that the user will want to write a type as other declarations.
    if ((isa_TypeDecl(ND) || isa_ObjCInterfaceDecl(ND))
       && !(CompletionContext.getKind() == CodeCompletionContext.Kind.CCC_Statement
       || CompletionContext.getKind()
       == CodeCompletionContext.Kind.CCC_ObjCMessageReceiver
       || CompletionContext.getKind()
       == CodeCompletionContext.Kind.CCC_ParenthesizedExpression)) {
      return CCP_Type;
    }
    
    return CCP_Declaration;
  }

  
  /// \brief Whether we should include code patterns in the completion
  /// results.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::includeCodePatterns">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 205,
   FQN="(anonymous namespace)::ResultBuilder::includeCodePatterns", NM="_ZNK12_GLOBAL__N_113ResultBuilder19includeCodePatternsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder19includeCodePatternsEv")
  //</editor-fold>
  public boolean includeCodePatterns() /*const*/ {
    return (SemaRef.CodeCompleter != null)
       && SemaRef.CodeCompleter.includeCodePatterns();
  }

  
  /// \brief Set the filter used for code-completion results.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::setFilter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 211,
   FQN="(anonymous namespace)::ResultBuilder::setFilter", NM="_ZN12_GLOBAL__N_113ResultBuilder9setFilterEMS0_KFbPKN5clang9NamedDeclEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder9setFilterEMS0_KFbPKN5clang9NamedDeclEE")
  //</editor-fold>
  public void setFilter(ResultBuilder$LookupFilter Filter) {
    this.Filter = Filter;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::data">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 215,
   FQN="(anonymous namespace)::ResultBuilder::data", NM="_ZN12_GLOBAL__N_113ResultBuilder4dataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder4dataEv")
  //</editor-fold>
  public type$ptr<CodeCompletionResult/*P*/> data() {
    return Results.empty() ? create_type$null$ptr((CodeCompletionResult)null) : $AddrOf(Results.data());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 216,
   FQN="(anonymous namespace)::ResultBuilder::size", NM="_ZNK12_GLOBAL__N_113ResultBuilder4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Results.size();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 217,
   FQN="(anonymous namespace)::ResultBuilder::empty", NM="_ZNK12_GLOBAL__N_113ResultBuilder5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Results.empty();
  }

  
  /// \brief Specify the preferred type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::setPreferredType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 220,
   FQN="(anonymous namespace)::ResultBuilder::setPreferredType", NM="_ZN12_GLOBAL__N_113ResultBuilder16setPreferredTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder16setPreferredTypeEN5clang8QualTypeE")
  //</editor-fold>
  public void setPreferredType(QualType T) {
    PreferredType.$assignMove(SemaRef.Context.getCanonicalType(new QualType(T)));
  }

  
  /// \brief Set the cv-qualifiers on the object type, for us in filtering
  /// calls to member functions.
  ///
  /// When there are qualifiers in this set, they will be used to filter
  /// out member functions that aren't available (because there will be a 
  /// cv-qualifier mismatch) or prefer functions with an exact qualifier
  /// match.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::setObjectTypeQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 231,
   FQN="(anonymous namespace)::ResultBuilder::setObjectTypeQualifiers", NM="_ZN12_GLOBAL__N_113ResultBuilder23setObjectTypeQualifiersEN5clang10QualifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder23setObjectTypeQualifiersEN5clang10QualifiersE")
  //</editor-fold>
  public void setObjectTypeQualifiers(Qualifiers Quals) {
    ObjectTypeQualifiers.$assign(Quals);
    HasObjectTypeQualifiers = true;
  }

  
  /// \brief Set the preferred selector.
  ///
  /// When an Objective-C method declaration result is added, and that
  /// method's selector matches this preferred selector, we give that method
  /// a slight priority boost.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::setPreferredSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 241,
   FQN="(anonymous namespace)::ResultBuilder::setPreferredSelector", NM="_ZN12_GLOBAL__N_113ResultBuilder20setPreferredSelectorEN5clang8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder20setPreferredSelectorEN5clang8SelectorE")
  //</editor-fold>
  public void setPreferredSelector(Selector Sel) {
    PreferredSelector.$assign(Sel);
  }

  
  /// \brief Retrieve the code-completion context for which results are
  /// being collected.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::getCompletionContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 247,
   FQN="(anonymous namespace)::ResultBuilder::getCompletionContext", NM="_ZNK12_GLOBAL__N_113ResultBuilder20getCompletionContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder20getCompletionContextEv")
  //</editor-fold>
  public /*const*/ CodeCompletionContext /*&*/ getCompletionContext() /*const*/ {
    return CompletionContext;
  }

  
  /// \brief Specify whether nested-name-specifiers are allowed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::allowNestedNameSpecifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 252,
   FQN="(anonymous namespace)::ResultBuilder::allowNestedNameSpecifiers", NM="_ZN12_GLOBAL__N_113ResultBuilder25allowNestedNameSpecifiersEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder25allowNestedNameSpecifiersEb")
  //</editor-fold>
  public void allowNestedNameSpecifiers() {
    allowNestedNameSpecifiers(true);
  }
  public void allowNestedNameSpecifiers(boolean Allow/*= true*/) {
    AllowNestedNameSpecifiers = Allow;
  }

  
  /// \brief Return the semantic analysis object for which we are collecting
  /// code completion results.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::getSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 258,
   FQN="(anonymous namespace)::ResultBuilder::getSema", NM="_ZNK12_GLOBAL__N_113ResultBuilder7getSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder7getSemaEv")
  //</editor-fold>
  public Sema /*&*/ getSema() /*const*/ {
    return SemaRef;
  }

  
  /// \brief Retrieve the allocator used to allocate code completion strings.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::getAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 261,
   FQN="(anonymous namespace)::ResultBuilder::getAllocator", NM="_ZNK12_GLOBAL__N_113ResultBuilder12getAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder12getAllocatorEv")
  //</editor-fold>
  public CodeCompletionAllocator /*&*/ getAllocator() /*const*/ {
    return Allocator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::getCodeCompletionTUInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 263,
   FQN="(anonymous namespace)::ResultBuilder::getCodeCompletionTUInfo", NM="_ZNK12_GLOBAL__N_113ResultBuilder23getCodeCompletionTUInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder23getCodeCompletionTUInfoEv")
  //</editor-fold>
  public CodeCompletionTUInfo /*&*/ getCodeCompletionTUInfo() /*const*/ {
    return CCTUInfo;
  }

  
  /// \brief Determine whether the given declaration is at all interesting
  /// as a code-completion result.
  ///
  /// \param ND the declaration that we are inspecting.
  ///
  /// \param AsNestedNameSpecifier will be set true if this declaration is
  /// only interesting when it is a nested-name-specifier.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::isInterestingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 517,
   FQN="(anonymous namespace)::ResultBuilder::isInterestingDecl", NM="_ZNK12_GLOBAL__N_113ResultBuilder17isInterestingDeclEPKN5clang9NamedDeclERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder17isInterestingDeclEPKN5clang9NamedDeclERb")
  //</editor-fold>
  public boolean isInterestingDecl(/*const*/ NamedDecl /*P*/ ND, 
                   final bool$ref/*bool &*/ AsNestedNameSpecifier) /*const*/ {
    AsNestedNameSpecifier.$set(false);
    
    /*const*/ NamedDecl /*P*/ Named = ND;
    ND = ND.getUnderlyingDecl$Const();
    
    // Skip unnamed entities.
    if (!ND.getDeclName().$bool()) {
      return false;
    }
    
    // Friend declarations and declarations introduced due to friends are never
    // added as results.
    if (ND.getFriendObjectKind() == Decl.FriendObjectKind.FOK_Undeclared) {
      return false;
    }
    
    // Class template (partial) specializations are never added as results.
    if (isa_ClassTemplateSpecializationDecl(ND)
       || isa_ClassTemplatePartialSpecializationDecl(ND)) {
      return false;
    }
    
    // Using declarations themselves are never added as results.
    if (isa_UsingDecl(ND)) {
      return false;
    }
    if (shouldIgnoreDueToReservedName(ND, SemaRef)) {
      return false;
    }
    
    final ResultBuilder$LookupFilter IsNestedNameSpecifier = ResultBuilder::IsNestedNameSpecifier;
    final ResultBuilder$LookupFilter IsNamespace = ResultBuilder::IsNamespace;
    final ResultBuilder$LookupFilter IsNamespaceOrAlias = ResultBuilder::IsNamespaceOrAlias;
    if (Filter == /*FPtr*//*ResultBuilder::*/$AddrOf(IsNestedNameSpecifier)
       || (isa_NamespaceDecl(ND)
       && Filter != /*FPtr*//*ResultBuilder::*/$AddrOf(IsNamespace)
       && Filter != /*FPtr*//*ResultBuilder::*/$AddrOf(IsNamespaceOrAlias)
       && Filter != null)) {
      AsNestedNameSpecifier.$set(true);
    }
    
    // Filter out any unwanted results.
    if ((Filter != null) && !Filter.$call(/*PtrMemI*/this, Named)) {
      // Check whether it is interesting as a nested-name-specifier.
      final ResultBuilder$LookupFilter IsMember = ResultBuilder::IsMember;
      if (AllowNestedNameSpecifiers && SemaRef.getLangOpts().CPlusPlus
         && IsNestedNameSpecifier(ND)
         && (Filter != /*FPtr*//*ResultBuilder::*/$AddrOf(IsMember)
         || (isa_CXXRecordDecl(ND)
         && cast_CXXRecordDecl(ND).isInjectedClassName()))) {
        AsNestedNameSpecifier.$set(true);
        return true;
      }
      
      return false;
    }
    // ... then it must be interesting!
    return true;
  }

  
  /// \brief Check whether the result is hidden by the Hiding declaration.
  ///
  /// \returns true if the result is hidden and cannot be found, false if
  /// the hidden result could still be found. When false, \p R may be
  /// modified to describe how the result can be found (e.g., via extra
  /// qualification).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::CheckHiddenResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 570,
   FQN="(anonymous namespace)::ResultBuilder::CheckHiddenResult", NM="_ZN12_GLOBAL__N_113ResultBuilder17CheckHiddenResultERN5clang20CodeCompletionResultEPNS1_11DeclContextEPKNS1_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder17CheckHiddenResultERN5clang20CodeCompletionResultEPNS1_11DeclContextEPKNS1_9NamedDeclE")
  //</editor-fold>
  public boolean CheckHiddenResult(final CodeCompletionResult /*&*/ R, DeclContext /*P*/ CurContext, 
                   /*const*/ NamedDecl /*P*/ Hiding) {
    // In C, there is no way to refer to a hidden name.
    // FIXME: This isn't true; we can find a tag name hidden by an ordinary
    // name if we introduce the tag type.
    if (!SemaRef.getLangOpts().CPlusPlus) {
      return true;
    }
    
    /*const*/ DeclContext /*P*/ HiddenCtx = R.Declaration.getDeclContext$Const().getRedeclContext$Const();
    
    // There is no way to qualify a name declared in a function or method.
    if (HiddenCtx.isFunctionOrMethod()) {
      return true;
    }
    if (HiddenCtx == Hiding.getDeclContext$Const().getRedeclContext$Const()) {
      return true;
    }
    
    // We can refer to the result with the appropriate qualification. Do it.
    R.Hidden = true;
    R.QualifierIsInformative = false;
    if (!(R.Qualifier != null)) {
      R.Qualifier = getRequiredQualification(SemaRef.Context, 
          CurContext, 
          R.Declaration.getDeclContext$Const());
    }
    return false;
  }

  
  /// \brief Add a new result to this result set (if it isn't already in one
  /// of the shadow maps), or replace an existing result (for, e.g., a 
  /// redeclaration).
  ///
  /// \param R the result to add (if it is unique).
  ///
  /// \param CurContext the context in which this result will be named.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::MaybeAddResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 829,
   FQN="(anonymous namespace)::ResultBuilder::MaybeAddResult", NM="_ZN12_GLOBAL__N_113ResultBuilder14MaybeAddResultEN5clang20CodeCompletionResultEPNS1_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder14MaybeAddResultEN5clang20CodeCompletionResultEPNS1_11DeclContextE")
  //</editor-fold>
  public void MaybeAddResult(CodeCompletionResult R) {
    MaybeAddResult(R, (DeclContext /*P*/ )null);
  }
  public void MaybeAddResult(CodeCompletionResult R, DeclContext /*P*/ CurContext/*= null*/) {
    assert (!ShadowMaps.empty()) : "Must enter into a results scope";
    if (R.Kind != CodeCompletionResult.ResultKind.RK_Declaration) {
      // For non-declaration results, just add the result.
      Results.push_back_T$C$R(R);
      return;
    }
    {
      
      // Look through using declarations.
      /*const*/ UsingShadowDecl /*P*/ Using = dyn_cast_UsingShadowDecl(R.Declaration);
      if ((Using != null)) {
        MaybeAddResult(new CodeCompletionResult(Using.getTargetDecl(), 
                getBasePriority(Using.getTargetDecl()), 
                R.Qualifier), 
            CurContext);
        return;
      }
    }
    
    /*const*/ Decl /*P*/ CanonDecl = R.Declaration.getCanonicalDecl$Const();
    /*uint*/int IDNS = CanonDecl.getIdentifierNamespace();
    
    bool$ref AsNestedNameSpecifier = create_bool$ref(false);
    if (!isInterestingDecl(R.Declaration, AsNestedNameSpecifier)) {
      return;
    }
    
    // C++ constructors are never found by name lookup.
    if (isa_CXXConstructorDecl(R.Declaration)) {
      return;
    }
    
    final DenseMap<DeclarationName, ShadowMapEntry> /*&*/ SMap = ShadowMaps.back();
    ShadowMapEntry.iterator I/*J*/= new ShadowMapEntry.iterator();
    ShadowMapEntry.iterator IEnd/*J*/= new ShadowMapEntry.iterator();
    DenseMapIterator<DeclarationName, ShadowMapEntry> NamePos = SMap.find(R.Declaration.getDeclName());
    if (NamePos.$noteq(/*NO_ITER_COPY*/SMap.end())) {
      I.$assignMove(NamePos.$arrow().second.begin());
      IEnd.$assignMove(NamePos.$arrow().second.end());
    }
    
    for (; ShadowMapEntry.iterator.$noteq_iterator$C(I, IEnd); I.$preInc()) {
      /*const*/ NamedDecl /*P*/ ND = I.$arrow().$arrow().first;
      /*uint*/int Index = I.$arrow().$arrow().second;
      if (ND.getCanonicalDecl$Const() == CanonDecl) {
        // This is a redeclaration. Always pick the newer declaration.
        Results.$at(Index).Declaration = R.Declaration;
        
        // We're done.
        return;
      }
    }
    
    // This is a new declaration in this scope. However, check whether this
    // declaration name is hidden by a similarly-named declaration in an outer
    // scope.
    std.list.iterator<DenseMap<DeclarationName, ShadowMapEntry>> SM/*J*/= new std.list.iterator<DenseMap<DeclarationName, ShadowMapEntry>>();
    std.list.iterator<DenseMap<DeclarationName, ShadowMapEntry>> SMEnd = ShadowMaps.end();
    SMEnd.$preDec();
    for (SM.$assignMove(ShadowMaps.begin()); SM.$noteq(SMEnd); SM.$preInc()) {
      ShadowMapEntry.iterator I$1/*J*/= new ShadowMapEntry.iterator();
      ShadowMapEntry.iterator IEnd$1/*J*/= new ShadowMapEntry.iterator();
      DenseMapIterator<DeclarationName, ShadowMapEntry> NamePos$1 = SM.$arrow().find(R.Declaration.getDeclName());
      if (NamePos$1.$noteq(/*NO_ITER_COPY*/SM.$arrow().end())) {
        I$1.$assignMove(NamePos$1.$arrow().second.begin());
        IEnd$1.$assignMove(NamePos$1.$arrow().second.end());
      }
      for (; ShadowMapEntry.iterator.$noteq_iterator$C(I$1, IEnd$1); I$1.$preInc()) {
        // A tag declaration does not hide a non-tag declaration.
        if (I$1.$arrow().$arrow().first.hasTagIdentifierNamespace()
           && ((IDNS & (Decl.IdentifierNamespace.IDNS_Member | Decl.IdentifierNamespace.IDNS_Ordinary
           | Decl.IdentifierNamespace.IDNS_LocalExtern | Decl.IdentifierNamespace.IDNS_ObjCProtocol)) != 0)) {
          continue;
        }
        
        // Protocols are in distinct namespaces from everything else.
        if ((((I$1.$arrow().$arrow().first.getIdentifierNamespace() & Decl.IdentifierNamespace.IDNS_ObjCProtocol) != 0)
           || ((IDNS & Decl.IdentifierNamespace.IDNS_ObjCProtocol) != 0))
           && I$1.$arrow().$arrow().first.getIdentifierNamespace() != IDNS) {
          continue;
        }
        
        // The newly-added result is hidden by an entry in the shadow map.
        if (CheckHiddenResult(R, CurContext, I$1.$arrow().$arrow().first)) {
          return;
        }
        
        break;
      }
    }
    
    // Make sure that any given declaration only shows up in the result set once.
    if (!AllDeclsFound.insert(CanonDecl).second) {
      return;
    }
    
    // If the filter is for nested-name-specifiers, then this result starts a
    // nested-name-specifier.
    if (AsNestedNameSpecifier.$deref()) {
      R.StartsNestedNameSpecifier = true;
      R.Priority = CCP_NestedNameSpecifier;
    } else {
      AdjustResultPriorityForDecl(R);
    }
    
    // If this result is supposed to have an informative qualifier, add one.
    if (R.QualifierIsInformative && !(R.Qualifier != null)
       && !R.StartsNestedNameSpecifier) {
      /*const*/ DeclContext /*P*/ Ctx = R.Declaration.getDeclContext$Const();
      {
        /*const*/ NamespaceDecl /*P*/ Namespace = dyn_cast_NamespaceDecl(Ctx);
        if ((Namespace != null)) {
          R.Qualifier = NestedNameSpecifier.Create(SemaRef.Context, (NestedNameSpecifier /*P*/ )null, 
              Namespace);
        } else {
          /*const*/ TagDecl /*P*/ Tag = dyn_cast_TagDecl(Ctx);
          if ((Tag != null)) {
            R.Qualifier = NestedNameSpecifier.Create(SemaRef.Context, (NestedNameSpecifier /*P*/ )null, 
                false, SemaRef.Context.getTypeDeclType(Tag).getTypePtr());
          } else {
            R.QualifierIsInformative = false;
          }
        }
      }
    }
    
    // Insert this result into the set of results and into the current shadow
    // map.
    SMap.$at_T1$RR(R.Declaration.getDeclName()).Add(R.Declaration, Results.size());
    Results.push_back_T$C$R(R);
    if (!AsNestedNameSpecifier.$deref()) {
      MaybeAddConstructorResults(new CodeCompletionResult(R));
    }
  }

  
  /// \brief Add a new result to this result set, where we already know
  /// the hiding declaration (if any).
  ///
  /// \param R the result to add (if it is unique).
  ///
  /// \param CurContext the context in which this result will be named.
  ///
  /// \param Hiding the declaration that hides the result.
  ///
  /// \param InBaseClass whether the result was found in a base
  /// class of the searched context.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::AddResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 947,
   FQN="(anonymous namespace)::ResultBuilder::AddResult", NM="_ZN12_GLOBAL__N_113ResultBuilder9AddResultEN5clang20CodeCompletionResultEPNS1_11DeclContextEPNS1_9NamedDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder9AddResultEN5clang20CodeCompletionResultEPNS1_11DeclContextEPNS1_9NamedDeclEb")
  //</editor-fold>
  public void AddResult(CodeCompletionResult R, DeclContext /*P*/ CurContext, 
           NamedDecl /*P*/ Hiding) {
    AddResult(R, CurContext, 
           Hiding, false);
  }
  public void AddResult(CodeCompletionResult R, DeclContext /*P*/ CurContext, 
           NamedDecl /*P*/ Hiding, boolean InBaseClass/*= false*/) {
    if (R.Kind != CodeCompletionResult.ResultKind.RK_Declaration) {
      // For non-declaration results, just add the result.
      Results.push_back_T$C$R(R);
      return;
    }
    {
      
      // Look through using declarations.
      /*const*/ UsingShadowDecl /*P*/ Using = dyn_cast_UsingShadowDecl(R.Declaration);
      if ((Using != null)) {
        AddResult(new CodeCompletionResult(Using.getTargetDecl(), 
                getBasePriority(Using.getTargetDecl()), 
                R.Qualifier), 
            CurContext, Hiding);
        return;
      }
    }
    
    bool$ref AsNestedNameSpecifier = create_bool$ref(false);
    if (!isInterestingDecl(R.Declaration, AsNestedNameSpecifier)) {
      return;
    }
    
    // C++ constructors are never found by name lookup.
    if (isa_CXXConstructorDecl(R.Declaration)) {
      return;
    }
    if ((Hiding != null) && CheckHiddenResult(R, CurContext, Hiding)) {
      return;
    }
    
    // Make sure that any given declaration only shows up in the result set once.
    if (!AllDeclsFound.insert(R.Declaration.getCanonicalDecl$Const()).second) {
      return;
    }
    
    // If the filter is for nested-name-specifiers, then this result starts a
    // nested-name-specifier.
    final ResultBuilder$LookupFilter IsMember = ResultBuilder::IsMember;
    if (AsNestedNameSpecifier.$deref()) {
      R.StartsNestedNameSpecifier = true;
      R.Priority = CCP_NestedNameSpecifier;
    } else if (Filter == /*FPtr*//*ResultBuilder::*/$AddrOf(IsMember) && !(R.Qualifier != null) && InBaseClass
       && isa_CXXRecordDecl(R.Declaration.getDeclContext$Const().
    getRedeclContext$Const())) {
      R.QualifierIsInformative = true;
    }
    
    // If this result is supposed to have an informative qualifier, add one.
    if (R.QualifierIsInformative && !(R.Qualifier != null)
       && !R.StartsNestedNameSpecifier) {
      /*const*/ DeclContext /*P*/ Ctx = R.Declaration.getDeclContext$Const();
      {
        /*const*/ NamespaceDecl /*P*/ Namespace = dyn_cast_NamespaceDecl(Ctx);
        if ((Namespace != null)) {
          R.Qualifier = NestedNameSpecifier.Create(SemaRef.Context, (NestedNameSpecifier /*P*/ )null, 
              Namespace);
        } else {
          /*const*/ TagDecl /*P*/ Tag = dyn_cast_TagDecl(Ctx);
          if ((Tag != null)) {
            R.Qualifier = NestedNameSpecifier.Create(SemaRef.Context, (NestedNameSpecifier /*P*/ )null, false, 
                SemaRef.Context.getTypeDeclType(Tag).getTypePtr());
          } else {
            R.QualifierIsInformative = false;
          }
        }
      }
    }
    
    // Adjust the priority if this result comes from a base class.
    if (InBaseClass) {
      R.Priority += CCD_InBaseClass;
    }
    
    AdjustResultPriorityForDecl(R);
    if (HasObjectTypeQualifiers) {
      {
        /*const*/ CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(R.Declaration);
        if ((Method != null)) {
          if (Method.isInstance()) {
            Qualifiers MethodQuals = Qualifiers.fromCVRMask(Method.getTypeQualifiers());
            if (ObjectTypeQualifiers.$eq(/*NO_COPY*/MethodQuals)) {
              R.Priority += CCD_ObjectQualifierMatch;
            } else if ($sub_Qualifiers(/*NO_COPY*/ObjectTypeQualifiers, /*NO_COPY*/MethodQuals).$bool()) {
              // The method cannot be invoked, because doing so would drop 
              // qualifiers.
              return;
            }
          }
        }
      }
    }
    
    // Insert this result into the set of results.
    Results.push_back_T$C$R(R);
    if (!AsNestedNameSpecifier.$deref()) {
      MaybeAddConstructorResults(new CodeCompletionResult(R));
    }
  }

  
  /// \brief Add a new non-declaration result to this result set.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::AddResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1031,
   FQN="(anonymous namespace)::ResultBuilder::AddResult", NM="_ZN12_GLOBAL__N_113ResultBuilder9AddResultEN5clang20CodeCompletionResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder9AddResultEN5clang20CodeCompletionResultE")
  //</editor-fold>
  public void AddResult(CodeCompletionResult R) {
    assert (R.Kind != CodeCompletionResult.ResultKind.RK_Declaration) : "Declaration results need more context";
    Results.push_back_T$C$R(R);
  }

  
  /// \brief Enter into a new scope.
  
  /// \brief Enter into a new scope.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::EnterNewScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1038,
   FQN="(anonymous namespace)::ResultBuilder::EnterNewScope", NM="_ZN12_GLOBAL__N_113ResultBuilder13EnterNewScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder13EnterNewScopeEv")
  //</editor-fold>
  public void EnterNewScope() {
    ShadowMaps.emplace_back();
  }

  
  /// \brief Exit from the current scope.
  
  /// \brief Exit from the current scope.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::ExitScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1041,
   FQN="(anonymous namespace)::ResultBuilder::ExitScope", NM="_ZN12_GLOBAL__N_113ResultBuilder9ExitScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder9ExitScopeEv")
  //</editor-fold>
  public void ExitScope() {
    for (DenseMapIterator<DeclarationName, ShadowMapEntry> E = ShadowMaps.back().begin(), 
        EEnd = ShadowMaps.back().end();
         E.$noteq(/*NO_ITER_COPY*/EEnd);
         E.$preInc())  {
      E.$arrow().second.Destroy();
    }
    
    ShadowMaps.pop_back();
  }

  
  /// \brief Ignore this declaration, if it is seen again.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::Ignore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 317,
   FQN="(anonymous namespace)::ResultBuilder::Ignore", NM="_ZN12_GLOBAL__N_113ResultBuilder6IgnoreEPKN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilder6IgnoreEPKN5clang4DeclE")
  //</editor-fold>
  public void Ignore(/*const*/ Decl /*P*/ D) {
    AllDeclsFound.insert(D.getCanonicalDecl$Const());
  }

  
  /// \name Name lookup predicates
  ///
  /// These predicates can be passed to the name lookup functions to filter the
  /// results of name lookup. All of the predicates have the same type, so that
  /// 
  //@{
  
  /// \brief Determines whether this given declaration will be found by
  /// ordinary name lookup.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsOrdinaryName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1053,
   FQN="(anonymous namespace)::ResultBuilder::IsOrdinaryName", NM="_ZNK12_GLOBAL__N_113ResultBuilder14IsOrdinaryNameEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder14IsOrdinaryNameEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsOrdinaryName(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    ND = cast_NamedDecl(ND.getUnderlyingDecl$Const());
    
    // If name lookup finds a local extern declaration, then we are in a
    // context where it behaves like an ordinary name.
    /*uint*/int IDNS = Decl.IdentifierNamespace.IDNS_Ordinary | Decl.IdentifierNamespace.IDNS_LocalExtern;
    if (SemaRef.getLangOpts().CPlusPlus) {
      IDNS |= Decl.IdentifierNamespace.IDNS_Tag | Decl.IdentifierNamespace.IDNS_Namespace | Decl.IdentifierNamespace.IDNS_Member;
    } else if (SemaRef.getLangOpts().ObjC1) {
      if (isa_ObjCIvarDecl(ND)) {
        return true;
      }
    }
    
    return ((ND.getIdentifierNamespace() & IDNS) != 0);
  }

  
  /// \brief Determines whether this given declaration will be found by
  /// ordinary name lookup but is not a type name.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsOrdinaryNonTypeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1071,
   FQN="(anonymous namespace)::ResultBuilder::IsOrdinaryNonTypeName", NM="_ZNK12_GLOBAL__N_113ResultBuilder21IsOrdinaryNonTypeNameEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder21IsOrdinaryNonTypeNameEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsOrdinaryNonTypeName(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    ND = cast_NamedDecl(ND.getUnderlyingDecl$Const());
    if (isa_TypeDecl(ND) || isa_ObjCInterfaceDecl(ND)) {
      return false;
    }
    
    /*uint*/int IDNS = Decl.IdentifierNamespace.IDNS_Ordinary | Decl.IdentifierNamespace.IDNS_LocalExtern;
    if (SemaRef.getLangOpts().CPlusPlus) {
      IDNS |= Decl.IdentifierNamespace.IDNS_Tag | Decl.IdentifierNamespace.IDNS_Namespace | Decl.IdentifierNamespace.IDNS_Member;
    } else if (SemaRef.getLangOpts().ObjC1) {
      if (isa_ObjCIvarDecl(ND)) {
        return true;
      }
    }
    
    return ((ND.getIdentifierNamespace() & IDNS) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsIntegralConstantValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1087,
   FQN="(anonymous namespace)::ResultBuilder::IsIntegralConstantValue", NM="_ZNK12_GLOBAL__N_113ResultBuilder23IsIntegralConstantValueEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder23IsIntegralConstantValueEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsIntegralConstantValue(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    if (!IsOrdinaryNonTypeName(ND)) {
      return false;
    }
    {
      
      /*const*/ ValueDecl /*P*/ VD = dyn_cast_ValueDecl(ND.getUnderlyingDecl$Const());
      if ((VD != null)) {
        if (VD.getType().$arrow().isIntegralOrEnumerationType()) {
          return true;
        }
      }
    }
    
    return false;
  }

  
  /// \brief Determines whether this given declaration will be found by
  /// ordinary name lookup.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsOrdinaryNonValueName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1100,
   FQN="(anonymous namespace)::ResultBuilder::IsOrdinaryNonValueName", NM="_ZNK12_GLOBAL__N_113ResultBuilder22IsOrdinaryNonValueNameEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder22IsOrdinaryNonValueNameEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsOrdinaryNonValueName(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    ND = cast_NamedDecl(ND.getUnderlyingDecl$Const());
    
    /*uint*/int IDNS = Decl.IdentifierNamespace.IDNS_Ordinary | Decl.IdentifierNamespace.IDNS_LocalExtern;
    if (SemaRef.getLangOpts().CPlusPlus) {
      IDNS |= Decl.IdentifierNamespace.IDNS_Tag | Decl.IdentifierNamespace.IDNS_Namespace;
    }
    
    return ((ND.getIdentifierNamespace() & IDNS) != 0)
       && !isa_ValueDecl(ND) && !isa_FunctionTemplateDecl(ND)
       && !isa_ObjCPropertyDecl(ND);
  }

  
  /// \brief Determines whether the given declaration is suitable as the 
  /// start of a C++ nested-name-specifier, e.g., a class or namespace.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsNestedNameSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1114,
   FQN="(anonymous namespace)::ResultBuilder::IsNestedNameSpecifier", NM="_ZNK12_GLOBAL__N_113ResultBuilder21IsNestedNameSpecifierEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder21IsNestedNameSpecifierEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsNestedNameSpecifier(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    {
      // Allow us to find class templates, too.
      /*const*/ ClassTemplateDecl /*P*/ ClassTemplate = dyn_cast_ClassTemplateDecl(ND);
      if ((ClassTemplate != null)) {
        ND = ClassTemplate.getTemplatedDecl();
      }
    }
    
    return SemaRef.isAcceptableNestedNameSpecifier(ND);
  }

  
  /// \brief Determines whether the given declaration is an enumeration.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsEnum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1123,
   FQN="(anonymous namespace)::ResultBuilder::IsEnum", NM="_ZNK12_GLOBAL__N_113ResultBuilder6IsEnumEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder6IsEnumEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsEnum(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    return isa_EnumDecl(ND);
  }

  
  /// \brief Determines whether the given declaration is a class or struct.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsClassOrStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1128,
   FQN="(anonymous namespace)::ResultBuilder::IsClassOrStruct", NM="_ZNK12_GLOBAL__N_113ResultBuilder15IsClassOrStructEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder15IsClassOrStructEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsClassOrStruct(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    {
      // Allow us to find class templates, too.
      /*const*/ ClassTemplateDecl /*P*/ ClassTemplate = dyn_cast_ClassTemplateDecl(ND);
      if ((ClassTemplate != null)) {
        ND = ClassTemplate.getTemplatedDecl();
      }
    }
    {
      
      // For purposes of this check, interfaces match too.
      /*const*/ RecordDecl /*P*/ RD = dyn_cast_RecordDecl(ND);
      if ((RD != null)) {
        return RD.getTagKind() == TagTypeKind.TTK_Class
           || RD.getTagKind() == TagTypeKind.TTK_Struct
           || RD.getTagKind() == TagTypeKind.TTK_Interface;
      }
    }
    
    return false;
  }

  
  /// \brief Determines whether the given declaration is a union.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsUnion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1143,
   FQN="(anonymous namespace)::ResultBuilder::IsUnion", NM="_ZNK12_GLOBAL__N_113ResultBuilder7IsUnionEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder7IsUnionEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsUnion(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    {
      // Allow us to find class templates, too.
      /*const*/ ClassTemplateDecl /*P*/ ClassTemplate = dyn_cast_ClassTemplateDecl(ND);
      if ((ClassTemplate != null)) {
        ND = ClassTemplate.getTemplatedDecl();
      }
    }
    {
      
      /*const*/ RecordDecl /*P*/ RD = dyn_cast_RecordDecl(ND);
      if ((RD != null)) {
        return RD.getTagKind() == TagTypeKind.TTK_Union;
      }
    }
    
    return false;
  }

  
  /// \brief Determines whether the given declaration is a namespace.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1155,
   FQN="(anonymous namespace)::ResultBuilder::IsNamespace", NM="_ZNK12_GLOBAL__N_113ResultBuilder11IsNamespaceEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder11IsNamespaceEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsNamespace(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    return isa_NamespaceDecl(ND);
  }

  
  /// \brief Determines whether the given declaration is a namespace or 
  /// namespace alias.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsNamespaceOrAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1161,
   FQN="(anonymous namespace)::ResultBuilder::IsNamespaceOrAlias", NM="_ZNK12_GLOBAL__N_113ResultBuilder18IsNamespaceOrAliasEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder18IsNamespaceOrAliasEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsNamespaceOrAlias(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    return isa_NamespaceDecl(ND.getUnderlyingDecl$Const());
  }

  
  /// \brief Determines whether the given declaration is a type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1166,
   FQN="(anonymous namespace)::ResultBuilder::IsType", NM="_ZNK12_GLOBAL__N_113ResultBuilder6IsTypeEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder6IsTypeEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsType(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    ND = ND.getUnderlyingDecl$Const();
    return isa_TypeDecl(ND) || isa_ObjCInterfaceDecl(ND);
  }

  
  /// \brief Determines which members of a class should be visible via
  /// "." or "->".  Only value declarations, nested name specifiers, and
  /// using declarations thereof should show up.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1174,
   FQN="(anonymous namespace)::ResultBuilder::IsMember", NM="_ZNK12_GLOBAL__N_113ResultBuilder8IsMemberEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder8IsMemberEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsMember(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    ND = ND.getUnderlyingDecl$Const();
    return isa_ValueDecl(ND) || isa_FunctionTemplateDecl(ND)
       || isa_ObjCPropertyDecl(ND);
  }

  
  /// \brief Determines whether the given declaration is an Objective-C
  /// instance variable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsObjCIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1254,
   FQN="(anonymous namespace)::ResultBuilder::IsObjCIvar", NM="_ZNK12_GLOBAL__N_113ResultBuilder10IsObjCIvarEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder10IsObjCIvarEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsObjCIvar(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    return isa_ObjCIvarDecl(ND);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsObjCMessageReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1213,
   FQN="(anonymous namespace)::ResultBuilder::IsObjCMessageReceiver", NM="_ZNK12_GLOBAL__N_113ResultBuilder21IsObjCMessageReceiverEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder21IsObjCMessageReceiverEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsObjCMessageReceiver(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    QualType T = getDeclUsageType(SemaRef.Context, ND);
    if (T.isNull()) {
      return false;
    }
    
    T.$assignMove(SemaRef.Context.getBaseElementType(new QualType(T)));
    return isObjCReceiverType(SemaRef.Context, new QualType(T));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsObjCMessageReceiverOrLambdaCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1222,
   FQN="(anonymous namespace)::ResultBuilder::IsObjCMessageReceiverOrLambdaCapture", NM="_ZNK12_GLOBAL__N_113ResultBuilder36IsObjCMessageReceiverOrLambdaCaptureEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder36IsObjCMessageReceiverOrLambdaCaptureEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsObjCMessageReceiverOrLambdaCapture(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    if (IsObjCMessageReceiver(ND)) {
      return true;
    }
    
    /*const*/ VarDecl /*P*/ Var = dyn_cast_VarDecl(ND);
    if (!(Var != null)) {
      return false;
    }
    
    return Var.hasLocalStorage() && !Var.hasAttr(BlocksAttr.class);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsObjCCollection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1233,
   FQN="(anonymous namespace)::ResultBuilder::IsObjCCollection", NM="_ZNK12_GLOBAL__N_113ResultBuilder16IsObjCCollectionEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder16IsObjCCollectionEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsObjCCollection(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    if ((SemaRef.getLangOpts().CPlusPlus && !IsOrdinaryName(ND))
       || (!SemaRef.getLangOpts().CPlusPlus && !IsOrdinaryNonTypeName(ND))) {
      return false;
    }
    
    QualType T = getDeclUsageType(SemaRef.Context, ND);
    if (T.isNull()) {
      return false;
    }
    
    T.$assignMove(SemaRef.Context.getBaseElementType(new QualType(T)));
    return T.$arrow().isObjCObjectType() || T.$arrow().isObjCObjectPointerType()
       || T.$arrow().isObjCIdType()
       || (SemaRef.getLangOpts().CPlusPlus && T.$arrow().isRecordType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::IsImpossibleToSatisfy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1248,
   FQN="(anonymous namespace)::ResultBuilder::IsImpossibleToSatisfy", NM="_ZNK12_GLOBAL__N_113ResultBuilder21IsImpossibleToSatisfyEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK12_GLOBAL__N_113ResultBuilder21IsImpossibleToSatisfyEPKN5clang9NamedDeclE")
  //</editor-fold>
  public boolean IsImpossibleToSatisfy(/*const*/ NamedDecl /*P*/ ND) /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ResultBuilder::~ResultBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 42,
   FQN="(anonymous namespace)::ResultBuilder::~ResultBuilder", NM="_ZN12_GLOBAL__N_113ResultBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN12_GLOBAL__N_113ResultBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ShadowMaps.$destroy();
    AllDeclsFound.$destroy();
    Results.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Results=" + Results // NOI18N
              + ", AllDeclsFound=" + AllDeclsFound // NOI18N
              + ", SemaRef=" + "[Sema]" // NOI18N
              + ", Allocator=" + "[CodeCompletionAllocator]" // NOI18N
              + ", CCTUInfo=" + CCTUInfo // NOI18N
              + ", Filter=" + Filter // NOI18N
              + ", AllowNestedNameSpecifiers=" + AllowNestedNameSpecifiers // NOI18N
              + ", PreferredType=" + PreferredType // NOI18N
              + ", ShadowMaps=" + ShadowMaps // NOI18N
              + ", ObjectTypeQualifiers=" + ObjectTypeQualifiers // NOI18N
              + ", HasObjectTypeQualifiers=" + HasObjectTypeQualifiers // NOI18N
              + ", PreferredSelector=" + PreferredSelector // NOI18N
              + ", CompletionContext=" + "[CodeCompletionContext]" // NOI18N
              + ", ObjCImplementation=" + ObjCImplementation; // NOI18N
  }
//@}    
}
