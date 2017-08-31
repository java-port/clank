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

package org.llvm.ir.impl;

import org.clank.java.*;
import static org.clank.java.std.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import static org.clank.support.literal_constants.$;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;


//===----------------------------------------------------------------------===//
/// \class
/// \brief This class represents a set of attributes that apply to the function,
/// return type, and parameters.
//<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 151,
 FQN="llvm::AttributeSetImpl", NM="_ZN4llvm16AttributeSetImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetImplE")
//</editor-fold>
public final class AttributeSetImpl extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node, /*private*/ TrailingObjects<AttributeSetImpl, std.pairUIntPtr<AttributeSetNode /*P*/ > >,
        ITrailingObjectsJavaBase<AttributeSetImpl> {
  /*friend  class AttributeSet*/
  /*friend  TrailingObjects<AttributeSetImpl, pair<unsigned int, AttributeSetNode *> >*/
/*private:*/
  private final LLVMContext /*&*/ Context;
  private /*uint*/int NumSlots; ///< Number of entries in this set.
  /// Bitset with a bit for each available attribute Attribute::AttrKind.
  private long/*uint64_t*/ AvailableFunctionAttrs;
  
  // Helper fn for TrailingObjects class.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::numTrailingObjects">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 164,
   FQN="llvm::AttributeSetImpl::numTrailingObjects", NM="_ZN4llvm16AttributeSetImpl18numTrailingObjectsENS_25trailing_objects_internal19TrailingObjectsBase13OverloadTokenISt4pairIjPNS_16AttributeSetNodeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetImpl18numTrailingObjectsENS_25trailing_objects_internal19TrailingObjectsBase13OverloadTokenISt4pairIjPNS_16AttributeSetNodeEEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects(OverloadToken<std.pairUIntPtr<AttributeSetNode /*P*/ > > $Prm0) {
    return NumSlots;
  }

  
  /// \brief Return a pointer to the IndexAttrPair for the specified slot.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::getNode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 167,
   FQN="llvm::AttributeSetImpl::getNode", NM="_ZNK4llvm16AttributeSetImpl7getNodeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetImpl7getNodeEj")
  //</editor-fold>
  /*friend*/public/*private*/ /*const*/type$ptr<std.pairUIntPtr<AttributeSetNode /*P*/ >> getNode(/*uint*/int Slot) /*const*/ {
    return (type$ptr)getTrailingObjects$Const(std.pairUIntPtr.class).$add(Slot);
  }

  
  // AttributesSet is uniqued, these should not be publicly available.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 172,
   FQN="llvm::AttributeSetImpl::operator=", NM="_ZN4llvm16AttributeSetImplaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetImplaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ AttributeSetImpl /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::AttributeSetImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 173,
   FQN="llvm::AttributeSetImpl::AttributeSetImpl", NM="_ZN4llvm16AttributeSetImplC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetImplC1ERKS0_")
  //</editor-fold>
  protected/*private*/ AttributeSetImpl(final /*const*/ AttributeSetImpl /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::AttributeSetImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 175,
   FQN="llvm::AttributeSetImpl::AttributeSetImpl", NM="_ZN4llvm16AttributeSetImplC1ERNS_11LLVMContextENS_8ArrayRefISt4pairIjPNS_16AttributeSetNodeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetImplC1ERNS_11LLVMContextENS_8ArrayRefISt4pairIjPNS_16AttributeSetNodeEEEE")
  //</editor-fold>
  public AttributeSetImpl(final LLVMContext /*&*/ C, 
      ArrayRef<std.pairUIntPtr<AttributeSetNode /*P*/ >> Slots) {
    // : FoldingSetNode(), TrailingObjects<AttributeSetImpl, IndexAttrPair>(), Context(C), NumSlots(Slots.size()), AvailableFunctionAttrs(0) 
    //START JInit
    $Node();
    $TrailingObjects();
    this./*&*/Context=/*&*/C;
    this.NumSlots = Slots.size();
    this.AvailableFunctionAttrs = $int2ulong(0);
    //END JInit
    static_assert($lesseq_uint(Attribute.AttrKind.EndAttrKinds.getValue(), sizeof(AvailableFunctionAttrs) * CHAR_BIT), $("Too many attributes"));
    if ($greatereq_uint(Slots.size(), 2)) {
      for (/*const*/type$ptr<std.pairUIntPtr<AttributeSetNode /*P*/ >> i = $tryClone(Slots.begin().$add(1)), 
          /*P*/ e = $tryClone(Slots.end());
           $noteq_ptr(i, e); i.$preInc()) {
        assert ($lesseq_uint(i.$sub(1).$star().first, i./*->*/$star().first)) : "Attribute set not ordered!";
      }
    }
    // There's memory after the node where we can store the entries in.
    std.copy(Slots.begin(), Slots.end(), getTrailingObjects(std.pairUIntPtr.class));
    
    // Initialize AvailableFunctionAttrs summary bitset.
    if ($greater_uint(NumSlots, 0)) {
      static_assert(AttributeSet.AttrIndex.FunctionIndex.getValue() == ~0/*U*/, $("FunctionIndex should be biggest possible index"));
      final /*const*/std.pairUIntPtr<AttributeSetNode /*P*/ > /*&*/ Last = Slots.back();
      if (Last.first == AttributeSet.AttrIndex.FunctionIndex.getValue()) {
        /*const*/ AttributeSetNode /*P*/ Node = Last.second;
        for (Attribute I : /*Deref*/Node) {
          if (!I.isStringAttribute()) {
            AvailableFunctionAttrs |= ((long/*uint64_t*/)$int2ulong(1)) << I.getKindAsEnum().getValue();
          }
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::operator delete">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 209,
   FQN="llvm::AttributeSetImpl::operator delete", NM="_ZN4llvm16AttributeSetImpldlEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetImpldlEPv")
  //</editor-fold>
  public static void $delete(Object/*void P*/ p) {
    ///*::*/$delete_voidPtr(p);
  }

  
  /// \brief Get the context that created this AttributeSetImpl.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 212,
   FQN="llvm::AttributeSetImpl::getContext", NM="_ZN4llvm16AttributeSetImpl10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetImpl10getContextEv")
  //</editor-fold>
  public LLVMContext /*&*/ getContext() {
    return Context;
  }

  
  /// \brief Return the number of slots used in this attribute list. This is
  /// the number of arguments that have an attribute set on them (including the
  /// function itself).
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::getNumSlots">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 217,
   FQN="llvm::AttributeSetImpl::getNumSlots", NM="_ZNK4llvm16AttributeSetImpl11getNumSlotsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetImpl11getNumSlotsEv")
  //</editor-fold>
  public /*uint*/int getNumSlots() /*const*/ {
    return NumSlots;
  }

  
  /// \brief Get the index of the given "slot" in the AttrNodes list. This index
  /// is the index of the return, parameter, or function object that the
  /// attributes are applied to, not the index into the AttrNodes list where the
  /// attributes reside.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::getSlotIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 223,
   FQN="llvm::AttributeSetImpl::getSlotIndex", NM="_ZNK4llvm16AttributeSetImpl12getSlotIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetImpl12getSlotIndexEj")
  //</editor-fold>
  public /*uint*/int getSlotIndex(/*uint*/int Slot) /*const*/ {
    return getNode(Slot).$star().first;
  }

  
  /// \brief Retrieve the attributes for the given "slot" in the AttrNode list.
  /// \p Slot is an index into the AttrNodes list, not the index of the return /
  /// parameter/ function which the attributes apply to.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::getSlotAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 230,
   FQN="llvm::AttributeSetImpl::getSlotAttributes", NM="_ZNK4llvm16AttributeSetImpl17getSlotAttributesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetImpl17getSlotAttributesEj")
  //</editor-fold>
  public AttributeSet getSlotAttributes(/*uint*/int Slot) /*const*/ {
    return AttributeSet.get_LLVMContext_ArrayRef$pairUIntType$P(Context, new ArrayRef<std.pairUIntPtr<AttributeSetNode /*P*/ >>(getNode(Slot).$star(), false));
  }

  
  /// \brief Retrieve the attribute set node for the given "slot" in the
  /// AttrNode list.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::getSlotNode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 236,
   FQN="llvm::AttributeSetImpl::getSlotNode", NM="_ZNK4llvm16AttributeSetImpl11getSlotNodeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetImpl11getSlotNodeEj")
  //</editor-fold>
  public AttributeSetNode /*P*/ getSlotNode(/*uint*/int Slot) /*const*/ {
    return getNode(Slot).$star().second;
  }

  
  /// \brief Return true if the AttributeSetNode for the FunctionIndex has an
  /// enum attribute of the given kind.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::hasFnAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 242,
   FQN="llvm::AttributeSetImpl::hasFnAttribute", NM="_ZNK4llvm16AttributeSetImpl14hasFnAttributeENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetImpl14hasFnAttributeENS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean hasFnAttribute(Attribute.AttrKind Kind) /*const*/ {
    return ((AvailableFunctionAttrs & ((long/*uint64_t*/)$int2ulong(1)) << Kind.getValue()) != 0);
  }

  
  // JAVA: typedef AttributeSetNode::iterator iterator
//  public final class iterator extends type$ptr<Attribute/*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 247,
   FQN="llvm::AttributeSetImpl::begin", NM="_ZNK4llvm16AttributeSetImpl5beginEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetImpl5beginEj")
  //</editor-fold>
  public type$ptr<Attribute/*P*/> begin(/*uint*/int Slot) /*const*/ {
    return getSlotNode(Slot).begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 248,
   FQN="llvm::AttributeSetImpl::end", NM="_ZNK4llvm16AttributeSetImpl3endEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetImpl3endEj")
  //</editor-fold>
  public type$ptr<Attribute/*P*/> end(/*uint*/int Slot) /*const*/ {
    return getSlotNode(Slot).end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 250,
   FQN="llvm::AttributeSetImpl::Profile", NM="_ZNK4llvm16AttributeSetImpl7ProfileERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetImpl7ProfileERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    AttributeSetImpl.Profile(ID, makeArrayRef(getNode(0), getNumSlots(), false));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 253,
   FQN="llvm::AttributeSetImpl::Profile", NM="_ZN4llvm16AttributeSetImpl7ProfileERNS_16FoldingSetNodeIDENS_8ArrayRefISt4pairIjPNS_16AttributeSetNodeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetImpl7ProfileERNS_16FoldingSetNodeIDENS_8ArrayRefISt4pairIjPNS_16AttributeSetNodeEEEE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, 
         ArrayRef<std.pairUIntPtr<AttributeSetNode /*P*/ >> Nodes) {
    for (/*uint*/int i = 0, e = Nodes.size(); i != e; ++i) {
      ID.AddInteger_uint(Nodes.$at(i).first);
      ID.AddPointer(Nodes.$at(i).second);
    }
  }

  
  // FIXME: This atrocity is temporary.
  
  //===----------------------------------------------------------------------===//
  // AttributeSetImpl Definition
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::Raw">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 648,
   FQN="llvm::AttributeSetImpl::Raw", NM="_ZNK4llvm16AttributeSetImpl3RawEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetImpl3RawEj")
  //</editor-fold>
  public long/*uint64_t*/ Raw(/*uint*/int Index) /*const*/ {
    for (/*uint*/int I = 0, E = getNumSlots(); I != E; ++I) {
      if (getSlotIndex(I) != Index) {
        continue;
      }
      /*const*/ AttributeSetNode /*P*/ ASN = getSlotNode(I);
      long/*uint64_t*/ Mask = $int2ulong(0);
      
      for (type$ptr<Attribute/*P*/> II = $tryClone(ASN.begin()), 
          /*P*/ IE = $tryClone(ASN.end()); $noteq_ptr(II, IE); II.$preInc()) {
        Attribute Attr = new Attribute(II.$star());
        
        // This cannot handle string attributes.
        if (Attr.isStringAttribute()) {
          continue;
        }
        
        Attribute.AttrKind Kind = Attr.getKindAsEnum();
        if (Kind == Attribute.AttrKind.Alignment) {
          Mask |= $uint2ullong((Log2_32(ASN.getAlignment()) + 1) << 16);
        } else if (Kind == Attribute.AttrKind.StackAlignment) {
          Mask |= $uint2ullong((Log2_32(ASN.getStackAlignment()) + 1) << 26);
        } else if (Kind == Attribute.AttrKind.Dereferenceable) {
          throw new llvm_unreachable("dereferenceable not supported in bit mask");
        } else if (Kind == Attribute.AttrKind.AllocSize) {
          throw new llvm_unreachable("allocsize not supported in bit mask");
        } else {
          Mask |= AttributeImpl.getAttrMask(Kind);
        }
      }
      
      return Mask;
    }
    
    return $int2ulong(0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetImpl::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 681,
   FQN="llvm::AttributeSetImpl::dump", NM="_ZNK4llvm16AttributeSetImpl4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetImpl4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    new AttributeSet(JavaDifferentiators.JD$Misc.INSTANCE, ((/*const_cast*/AttributeSetImpl /*P*/ )(this))).dump();
  }

  private final type$ptr<?> $This$TrailingObjects = $ITrailingObjectsJavaBase();

  @Override
  public final type$ptr<?> $TrailingObjects() {
    assert $This$TrailingObjects != null;
    return $This$TrailingObjects;
  }

  @Override
  public int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == std.pairUIntPtr.class;
    return 0;
  }
  
  @Override public String toString() {
    return "" + "Context=" + "[LLVMContext]" // NOI18N
              + ", NumSlots=" + NumSlots // NOI18N
              + ", AvailableFunctionAttrs=" + AvailableFunctionAttrs // NOI18N
              + super.toString(); // NOI18N
  }
}
