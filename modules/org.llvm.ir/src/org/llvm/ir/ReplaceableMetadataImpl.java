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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.java.DenseMapInfoMetadataPtrAddr;
import static org.llvm.ir.java.IrRTTI.*;


/// \brief Shared implementation of use-lists for replaceable metadata.
///
/// Most metadata cannot be RAUW'ed.  This is a shared implementation of
/// use-lists and associated API for the two that support it (\a ValueAsMetadata
/// and \a TempMDNode).
//<editor-fold defaultstate="collapsed" desc="llvm::ReplaceableMetadataImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 252,
 FQN="llvm::ReplaceableMetadataImpl", NM="_ZN4llvm23ReplaceableMetadataImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm23ReplaceableMetadataImplE")
//</editor-fold>
public interface/*class*/ ReplaceableMetadataImpl extends Destructors.ClassWithDestructor {
  public static final class ReplaceableMetadataImpl$Fields {
    /*friend  class MetadataTracking*/
  /*public:*/
    /*typedef MetadataTracking::OwnerTy OwnerTy*/
  //  public final class OwnerTy extends PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >{ };
  /*private:*/
    public/*private*/ final LLVMContext /*&*/ Context;
    public/*private*/ long/*uint64_t*/ NextIndex;
    public/*private*/ SmallDenseMap<type$ptr<Metadata /*P*/ /*&*/>/*void P*/ , std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >>> UseMap;

    public /*interface*/ ReplaceableMetadataImpl$Fields(final LLVMContext /*&*/ Context) {
      // : Context(Context), NextIndex(0), UseMap()
      //START JInit
      this./*&*/Context=/*&*/Context;
      this.NextIndex = 0;
      this.UseMap = new SmallDenseMap<type$ptr<Metadata /*P*/ /*&*/>/*void P*/ , std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >>>(DenseMapInfoMetadataPtrAddr.$Info(), 4, new std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >>());
      //END JInit
    }

    @Override public String toString() {
      return "" + "Context=" + "[LLVMContext]" // NOI18N
                + ", NextIndex=" + NextIndex // NOI18N
                + ", UseMap=" + UseMap; // NOI18N
    }
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public default ReplaceableMetadataImpl$Fields $ReplaceableMetadataImpl$Fields() {
    throw new UnsupportedOperationException("Why not implemented in derived? " + this.getClass() + ": Keep what was returned from $ReplaceableMetadataImpl in your final field and just return it here.");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ReplaceableMetadataImpl::ReplaceableMetadataImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 264,
   FQN="llvm::ReplaceableMetadataImpl::ReplaceableMetadataImpl", NM="_ZN4llvm23ReplaceableMetadataImplC1ERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm23ReplaceableMetadataImplC1ERNS_11LLVMContextE")
  //</editor-fold>
  public default/*interface*/ ReplaceableMetadataImpl$Fields $ReplaceableMetadataImpl(final LLVMContext /*&*/ Context) {
    // : Context(Context), NextIndex(0), UseMap()
    return new ReplaceableMetadataImpl$Fields(Context);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReplaceableMetadataImpl::~ReplaceableMetadataImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 266,
   FQN="llvm::ReplaceableMetadataImpl::~ReplaceableMetadataImpl", NM="_ZN4llvm23ReplaceableMetadataImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm23ReplaceableMetadataImplD0Ev")
  //</editor-fold>
  public default/*interface*/ void $destroy$ReplaceableMetadataImpl() {
    assert ($ReplaceableMetadataImpl$Fields().UseMap.empty()) : "Cannot destroy in-use replaceable metadata";
    //START JDestroy
    $ReplaceableMetadataImpl$Fields().UseMap.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ReplaceableMetadataImpl::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 270,
   FQN="llvm::ReplaceableMetadataImpl::getContext", NM="_ZNK4llvm23ReplaceableMetadataImpl10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm23ReplaceableMetadataImpl10getContextEv")
  //</editor-fold>
  public default/*interface*/ LLVMContext /*&*/ getContext() /*const*/ {
    return $ReplaceableMetadataImpl$Fields().Context;
  }


  /// \brief Replace all uses of this with MD.
  ///
  /// Replace all uses of this with \c MD, which is allowed to be null.
  //<editor-fold defaultstate="collapsed" desc="llvm::ReplaceableMetadataImpl::replaceAllUsesWith">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 200,
   FQN="llvm::ReplaceableMetadataImpl::replaceAllUsesWith", NM="_ZN4llvm23ReplaceableMetadataImpl18replaceAllUsesWithEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm23ReplaceableMetadataImpl18replaceAllUsesWithEPNS_8MetadataE")
  //</editor-fold>
  public default/*interface*/ void replaceAllUsesWith(Metadata /*P*/ MD) {
    if ($ReplaceableMetadataImpl$Fields().UseMap.empty()) {
      return;
    }

    // Copy out uses since UseMap will get touched below.
    // JAVA: typedef std::pair<void *, std::pair<OwnerTy, uint64_t> > UseTy
//    final class UseTy extends std.pairPtrType<Object/*void P*/ , std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >>>{ };

    SmallVector<std.pair<type$ptr<Metadata /*P*/ /*&*/>/*void P*/ , std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >>>> Uses/*J*/=
            new SmallVector<std.pair<type$ptr<Metadata /*P*/ /*&*/>/*void P*/ , std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >>>>(
                    JD$T.INSTANCE, 8, $ReplaceableMetadataImpl$Fields().UseMap.begin(), $ReplaceableMetadataImpl$Fields().UseMap.end(),
                    new std.pairPtrType<type$ptr<Metadata /*P*/ /*&*/>/*void P*/ , std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >>>());
    std.sort(Uses.begin(), Uses.end(), /*[]*/ (final /*const*/std.pair<type$ptr<Metadata /*P*/ /*&*/>/*void P*/ , std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >>> /*&*/ L,
            final /*const*/std.pair<type$ptr<Metadata /*P*/ /*&*/>/*void P*/ , std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >>> /*&*/ R) -> {
              return $less_ullong(L.second.second, R.second.second);
            });
    for (final /*const*/std.pair<type$ptr<Metadata /*P*/ /*&*/>/*void P*/ , std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >>> /*&*/ Pair : Uses) {
      // Check that this Ref hasn't disappeared after RAUW (when updating a
      // previous Ref).
      if (!($ReplaceableMetadataImpl$Fields().UseMap.count(Pair.first) != 0)) {
        continue;
      }

      PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ > Owner = new PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >(Pair.second.first);
      if (!Owner.$bool()) {
        // Update unowned tracking references directly.
        final type$ptr<Metadata /*P*/ /*&*/> Ref = ((/*static_cast*/type$ptr<Metadata /*P*/ /*P*/>)(Pair.first));
        Ref.$set(MD);
        if ((MD != null)) {
          MetadataTracking.track(Ref);
        }
        $ReplaceableMetadataImpl$Fields().UseMap.erase(Pair.first);
        continue;
      }

      // Check for MetadataAsValue.
      if ((Owner.is(MetadataAsValue /*P*/.class) != 0)) {
        Owner.get(MetadataAsValue /*P*/.class).handleChangedMetadata(MD);
        continue;
      }

      // There's a Metadata owner -- dispatch.
      Metadata /*P*/ OwnerMD = Owner.get(Metadata /*P*/.class);
      switch (Metadata.MetadataKind.valueOf(OwnerMD.getMetadataID())) {
       case MDStringKind:
        cast_MDString(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case ConstantAsMetadataKind:
        cast_ConstantAsMetadata(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case LocalAsMetadataKind:
        cast_LocalAsMetadata(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DistinctMDOperandPlaceholderKind:
        cast_DistinctMDOperandPlaceholder(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case MDTupleKind:
        cast_MDTuple(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DILocationKind:
        cast_DILocation(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DIExpressionKind:
        cast_DIExpression(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case GenericDINodeKind:
        cast_GenericDINode(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DISubrangeKind:
        cast_DISubrange(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DIEnumeratorKind:
        cast_DIEnumerator(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DIBasicTypeKind:
        cast_DIBasicType(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DIDerivedTypeKind:
        cast_DIDerivedType(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DICompositeTypeKind:
        cast_DICompositeType(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DISubroutineTypeKind:
        cast_DISubroutineType(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DIFileKind:
        cast_DIFile(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DICompileUnitKind:
        cast_DICompileUnit(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DISubprogramKind:
        cast_DISubprogram(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DILexicalBlockKind:
        cast_DILexicalBlock(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DILexicalBlockFileKind:
        cast_DILexicalBlockFile(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DINamespaceKind:
        cast_DINamespace(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DIModuleKind:
        cast_DIModule(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DITemplateTypeParameterKind:
        cast_DITemplateTypeParameter(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DITemplateValueParameterKind:
        cast_DITemplateValueParameter(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DIGlobalVariableKind:
        cast_DIGlobalVariable(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DILocalVariableKind:
        cast_DILocalVariable(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DIObjCPropertyKind:
        cast_DIObjCProperty(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DIImportedEntityKind:
        cast_DIImportedEntity(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DIMacroKind:
        cast_DIMacro(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       case DIMacroFileKind:
        cast_DIMacroFile(OwnerMD).handleChangedOperand(Pair.first, MD);
        continue;
       default:
        throw new llvm_unreachable("Invalid metadata subclass");
      }
    }
    assert ($ReplaceableMetadataImpl$Fields().UseMap.empty()) : "Expected all uses to be replaced";
  }


  /// \brief Resolve all uses of this.
  ///
  /// Resolve all uses of this, turning off RAUW permanently.  If \c
  /// ResolveUsers, call \a MDNode::resolve() on any users whose last operand
  /// is resolved.
  //<editor-fold defaultstate="collapsed" desc="llvm::ReplaceableMetadataImpl::resolveAllUses">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 248,
   FQN="llvm::ReplaceableMetadataImpl::resolveAllUses", NM="_ZN4llvm23ReplaceableMetadataImpl14resolveAllUsesEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm23ReplaceableMetadataImpl14resolveAllUsesEb")
  //</editor-fold>
  public default/*interface*/ void resolveAllUses() {
    resolveAllUses(true);
  }
  public default/*interface*/ void resolveAllUses(boolean ResolveUsers/*= true*/) {
    if ($ReplaceableMetadataImpl$Fields().UseMap.empty()) {
      return;
    }
    if (!ResolveUsers) {
      $ReplaceableMetadataImpl$Fields().UseMap.clear();
      return;
    }

    // Copy out uses since UseMap could get touched below.
    // JAVA: typedef std::pair<void *, std::pair<OwnerTy, uint64_t> > UseTy
//    final class UseTy extends std.pairPtrType<Object/*void P*/ , std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >>>{ };
    SmallVector<std.pair<type$ptr<Metadata /*P*/ /*&*/>/*void P*/, std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/, Metadata /*P*/>>>> Uses/*J*/ = new SmallVector<std.pair<type$ptr<Metadata /*P*/ /*&*/>/*void P*/, std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/, Metadata /*P*/>>>>(JD$T.INSTANCE, 8, $ReplaceableMetadataImpl$Fields().UseMap.begin(), $ReplaceableMetadataImpl$Fields().UseMap.end(), new std.pairPtrType<type$ptr<Metadata /*P*/ /*&*/>/*void P*/, std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/, Metadata /*P*/>>>());
    std.sort(Uses.begin(), Uses.end(), /*[]*/ (final /*const*/ std.pair<type$ptr<Metadata /*P*/ /*&*/>/*void P*/, std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/, Metadata /*P*/>>> /*&*/ L, final /*const*/ std.pair<type$ptr<Metadata /*P*/ /*&*/>/*void P*/, std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/, Metadata /*P*/>>> /*&*/ R) -> {
              return $less_ullong(L.second.second, R.second.second);
            });
    $ReplaceableMetadataImpl$Fields().UseMap.clear();
    for (final /*const*/ std.pair<type$ptr<Metadata /*P*/ /*&*/>/*void P*/, std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/, Metadata /*P*/>>> /*&*/ Pair : Uses) {
      PointerUnion<MetadataAsValue /*P*/, Metadata /*P*/> Owner = new PointerUnion<MetadataAsValue /*P*/, Metadata /*P*/>(Pair.second.first);
      if (!Owner.$bool()) {
        continue;
      }
      if ((Owner.is(MetadataAsValue /*P*/.class) != 0)) {
        continue;
      }

      // Resolve MDNodes that point at this.
      MDNode /*P*/ OwnerMD = dyn_cast_MDNode(Owner.get(Metadata /*P*/.class));
      if (!(OwnerMD != null)) {
        continue;
      }
      if (OwnerMD.isResolved()) {
        continue;
      }
      OwnerMD.decrementUnresolvedOperandCount();
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ReplaceableMetadataImpl::addRef">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 165,
   FQN="llvm::ReplaceableMetadataImpl::addRef", NM="_ZN4llvm23ReplaceableMetadataImpl6addRefEPvNS_12PointerUnionIPNS_15MetadataAsValueEPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm23ReplaceableMetadataImpl6addRefEPvNS_12PointerUnionIPNS_15MetadataAsValueEPNS_8MetadataEEE")
  //</editor-fold>
  public/*private*/ default/*interface*/ void addRef(type$ptr<Metadata /*P*/ /*&*/>/*void P*/ Ref, PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ > Owner) {
    boolean WasInserted = $ReplaceableMetadataImpl$Fields().UseMap.insert_pair$KeyT$ValueT(std.make_pair_T_T(Ref, $Move(std.make_pair_T_ulong($Clone(Owner), $ReplaceableMetadataImpl$Fields().NextIndex)))).
        second;
    ///*J:(void)*/WasInserted;
    assert (WasInserted) : "Expected to add a reference";

    ++$ReplaceableMetadataImpl$Fields().NextIndex;
    assert ($ReplaceableMetadataImpl$Fields().NextIndex != $int2ullong(0)) : "Unexpected overflow";
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReplaceableMetadataImpl::dropRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 176,
   FQN="llvm::ReplaceableMetadataImpl::dropRef", NM="_ZN4llvm23ReplaceableMetadataImpl7dropRefEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm23ReplaceableMetadataImpl7dropRefEPv")
  //</editor-fold>
  public/*private*/ default/*interface*/ void dropRef(type$ptr<Metadata /*P*/ /*&*/>/*void P*/ Ref) {
    boolean WasErased = $ReplaceableMetadataImpl$Fields().UseMap.erase(Ref);
    ///*J:(void)*/WasErased;
    assert (WasErased) : "Expected to drop a reference";
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ReplaceableMetadataImpl::moveRef">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 182,
   FQN="llvm::ReplaceableMetadataImpl::moveRef", NM="_ZN4llvm23ReplaceableMetadataImpl7moveRefEPvS1_RKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm23ReplaceableMetadataImpl7moveRefEPvS1_RKNS_8MetadataE")
  //</editor-fold>
  public/*private*/ default/*interface*/ void moveRef(type$ptr<Metadata /*P*/ /*&*/>/*void P*/ Ref, type$ptr<Metadata /*P*/ /*&*/>/*void P*/ New,
         final /*const*/ Metadata /*&*/ MD) {
    DenseMapIterator<type$ptr<Metadata /*P*/ /*&*/>, pairTypeULong<PointerUnion<MetadataAsValue, Metadata>>> I = $ReplaceableMetadataImpl$Fields().UseMap.find(Ref);
    assert (I.$noteq(/*NO_ITER_COPY*/$ReplaceableMetadataImpl$Fields().UseMap.end())) : "Expected to move a reference";
    std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >> OwnerAndIndex = new std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >>(I.$arrow().second);
    $ReplaceableMetadataImpl$Fields().UseMap.erase(new DenseMapIterator<type$ptr<Metadata /*P*/ /*&*/>/*void P*/ , std.pairTypeULong<PointerUnion<MetadataAsValue /*P*/ , Metadata /*P*/ >>>(I));
    boolean WasInserted = $ReplaceableMetadataImpl$Fields().UseMap.insert_pair$KeyT$ValueT(std.make_pair_T_T(New, $Clone(OwnerAndIndex))).second;
    ///*J:(void)*/WasInserted;
    assert (WasInserted) : "Expected to add a reference";

    // Check that the references are direct if there's no owner.
    ///*J:(void)*/MD;
    assert ((OwnerAndIndex.first.$bool() || ((/*static_cast*/type$ptr<Metadata /*P*/ /*P*/>)(Ref)).$star() == $AddrOf(MD))) : "Reference without owner must be direct";
    assert ((OwnerAndIndex.first.$bool() || ((/*static_cast*/type$ptr<Metadata /*P*/ /*P*/>)(New)).$star() == $AddrOf(MD))) : "Reference without owner must be direct";
  }


  /// Lazily construct RAUW support on MD.
  ///
  /// If this is an unresolved MDNode, RAUW support will be created on-demand.
  /// ValueAsMetadata always has RAUW support.
  //<editor-fold defaultstate="collapsed" desc="llvm::ReplaceableMetadataImpl::getOrCreate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 281,
   FQN="llvm::ReplaceableMetadataImpl::getOrCreate", NM="_ZN4llvm23ReplaceableMetadataImpl11getOrCreateERNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm23ReplaceableMetadataImpl11getOrCreateERNS_8MetadataE")
  //</editor-fold>
  public/*private*/ /*interface*/ static ReplaceableMetadataImpl /*P*/ getOrCreate(final Metadata /*&*/ MD) {
    {
      MDNode /*P*/ N = dyn_cast_MDNode($AddrOf(MD));
      if ((N != null)) {
        return N.isResolved() ? null : N.Context.getOrCreateReplaceableUses();
      }
    }
    return dyn_cast_ValueAsMetadata($AddrOf(MD));
  }


  /// Get RAUW support on MD, if it exists.
  //<editor-fold defaultstate="collapsed" desc="llvm::ReplaceableMetadataImpl::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 287,
   FQN="llvm::ReplaceableMetadataImpl::getIfExists", NM="_ZN4llvm23ReplaceableMetadataImpl11getIfExistsERNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm23ReplaceableMetadataImpl11getIfExistsERNS_8MetadataE")
  //</editor-fold>
  public/*private*/ /*interface*/ static ReplaceableMetadataImpl /*P*/ getIfExists(final Metadata /*&*/ MD) {
    {
      MDNode /*P*/ N = dyn_cast_MDNode($AddrOf(MD));
      if ((N != null)) {
        return N.isResolved() ? null : N.Context.getReplaceableUses();
      }
    }
    return dyn_cast_ValueAsMetadata($AddrOf(MD));
  }


  /// Check whether this node will support RAUW.
  ///
  /// Returns \c true unless getOrCreate() would return null.
  //<editor-fold defaultstate="collapsed" desc="llvm::ReplaceableMetadataImpl::isReplaceable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 293,
   FQN="llvm::ReplaceableMetadataImpl::isReplaceable", NM="_ZN4llvm23ReplaceableMetadataImpl13isReplaceableERKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm23ReplaceableMetadataImpl13isReplaceableERKNS_8MetadataE")
  //</editor-fold>
  public/*private*/ /*interface*/ static boolean isReplaceable(final /*const*/ Metadata /*&*/ MD) {
    {
      /*const*/ MDNode /*P*/ N = dyn_cast_MDNode($AddrOf(MD));
      if ((N != null)) {
        return !N.isResolved();
      }
    }
    return (dyn_cast_ValueAsMetadata($AddrOf(MD)) != null);
  }


//  @Override public String toString() {
//    return "" + "Context=" + "[LLVMContext]" // NOI18N
//              + ", NextIndex=" + NextIndex // NOI18N
//              + ", UseMap=" + UseMap; // NOI18N
//  }
}
