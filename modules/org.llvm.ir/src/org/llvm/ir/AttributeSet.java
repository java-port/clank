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
import static org.clank.java.std.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$Move;
import org.clank.support.JavaDifferentiators.JD$T$C$P_T2$C$R;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.ADTAliases.OptionalUInt;
import org.llvm.adt.aliases.*;
import org.llvm.adt.java.TrailingObjectsUtils;
import org.llvm.ir.impl.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;


//===----------------------------------------------------------------------===//
/// \class
/// \brief This class holds the attributes for a function, its return value, and
/// its parameters. You access the attributes for each of them via an index into
/// the AttributeSet object. The function attributes are at index
/// `AttributeSet::FunctionIndex', the return value is at index
/// `AttributeSet::ReturnIndex', and the attributes for the parameters start at
/// index `1'.
//<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 203,
 FQN="llvm::AttributeSet", NM="_ZN4llvm12AttributeSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSetE")
//</editor-fold>
public class AttributeSet implements Native.NativeComparable<AttributeSet>, NativePOD<AttributeSet>, NativeMoveable<AttributeSet> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::AttrIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 205,
   FQN="llvm::AttributeSet::AttrIndex", NM="_ZN4llvm12AttributeSet9AttrIndexE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSet9AttrIndexE")
  //</editor-fold>
  public enum AttrIndex/* : unsigned int*/ implements Native.NativeUIntEnum {
    ReturnIndex(0/*U*/),
    FunctionIndex(~0/*U*/);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AttrIndex valueOf(int val) {
      AttrIndex out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AttrIndex[] VALUES;
      private static final AttrIndex[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AttrIndex kind : AttrIndex.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AttrIndex[min < 0 ? (1-min) : 0];
        VALUES = new AttrIndex[max >= 0 ? (1+max) : 0];
        for (AttrIndex kind : AttrIndex.values()) {
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
    private AttrIndex(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  /*friend  class AttrBuilder*/
  /*friend  class AttributeSetImpl*/
  /*friend  class AttributeSetNode*/
  /*friend template <typename Ty> struct DenseMapInfo*/
  
  /// \brief The attributes that we are managing. This can be null to represent
  /// the empty attributes list.
  /*friend*//*package*/AttributeSetImpl /*P*/ pImpl;
  
  /// \brief The attributes for the specified index are returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1169,
   FQN="llvm::AttributeSet::getAttributes", NM="_ZNK4llvm12AttributeSet13getAttributesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet13getAttributesEj")
  //</editor-fold>
  /*friend*/public/*private*/ AttributeSetNode /*P*/ getAttributes(/*uint*/int Index) /*const*/ {
    if (!(pImpl != null)) {
      return null;
    }
    
    // Loop through to find the attribute node we want.
    for (/*uint*/int I = 0, E = pImpl.getNumSlots(); I != E; ++I)  {
      if (pImpl.getSlotIndex(I) == Index) {
        return pImpl.getSlotNode(I);
      }
    }
    
    return null;
  }

  
  /// \brief Create an AttributeSet with the specified parameters in it.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 713,
   FQN="llvm::AttributeSet::get", NM="_ZN4llvm12AttributeSet3getERNS_11LLVMContextENS_8ArrayRefISt4pairIjNS_9AttributeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSet3getERNS_11LLVMContextENS_8ArrayRefISt4pairIjNS_9AttributeEEEE")
  //</editor-fold>
  /*friend*/public/*private*/ static AttributeSet get_LLVMContext_ArrayRef$pairUIntType(final LLVMContext /*&*/ C, 
                                       ArrayRef<std.pairUIntType<Attribute>> Attrs) {
    // If there are no attributes then return a null AttributesList pointer.
    if (Attrs.empty()) {
      return new AttributeSet();
    }
    assert (std.is_sorted(Attrs.begin(), Attrs.end(), /*[]*/ (final /*const*/std.pairUIntType<Attribute> /*&*/ LHS, final /*const*/std.pairUIntType<Attribute> /*&*/ RHS) -> {
          return $less_uint(LHS.first, RHS.first);
        })) : "Misordered Attributes list!";
    assert (std.none_of(Attrs.begin(), Attrs.end(), /*[]*/ (final /*const*/std.pairUIntType<Attribute> /*&*/ Pair) -> {
          return Pair.second.hasAttribute(Attribute.AttrKind.None);
        })) : "Pointless attribute!";
    
    // Create a vector if (unsigned, AttributeSetNode*) pairs from the attributes
    // list.
    SmallVector<std.pairUIntPtr<AttributeSetNode /*P*/ >> AttrPairVec/*J*/= new SmallVector<std.pairUIntPtr<AttributeSetNode /*P*/ >>(8, new std.pairUIntPtr<AttributeSetNode /*P*/ >());
    for (type$ptr<std.pairUIntType<Attribute>> I = $tryClone(Attrs.begin()), 
        /*P*/ E = $tryClone(Attrs.end()); $noteq_ptr(I, E);) {
      /*uint*/int Index = I./*->*/$star().first;
      SmallVector<Attribute> AttrVec/*J*/= new SmallVector<Attribute>(4, new Attribute());
      while ($noteq_ptr(I, E) && I./*->*/$star().first == Index) {
        AttrVec.push_back(I./*->*/$star().second);
        I.$preInc();
      }
      
      AttrPairVec.push_back(std.make_pair_uint_Ptr(Index, 
              AttributeSetNode.get(C, new ArrayRef<Attribute>(AttrVec, false))));
    }
    
    return getImpl(C, new ArrayRef<std.pairUIntPtr<AttributeSetNode /*P*/ >>(AttrPairVec, false));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 748,
   FQN="llvm::AttributeSet::get", NM="_ZN4llvm12AttributeSet3getERNS_11LLVMContextENS_8ArrayRefISt4pairIjPNS_16AttributeSetNodeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSet3getERNS_11LLVMContextENS_8ArrayRefISt4pairIjPNS_16AttributeSetNodeEEEE")
  //</editor-fold>
  /*friend*/public/*private*/ static AttributeSet get_LLVMContext_ArrayRef$pairUIntType$P(final LLVMContext /*&*/ C, 
                                         ArrayRef<std.pairUIntPtr<AttributeSetNode /*P*/ >> Attrs) {
    // If there are no attributes then return a null AttributesList pointer.
    if (Attrs.empty()) {
      return new AttributeSet();
    }
    
    return getImpl(C, new ArrayRef<std.pairUIntPtr<AttributeSetNode /*P*/ >>(Attrs));
  }

  
  
  //===----------------------------------------------------------------------===//
  // AttributeSet Construction and Mutation Methods
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*ALLOC*/,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 689,
   FQN="llvm::AttributeSet::getImpl", NM="_ZN4llvm12AttributeSet7getImplERNS_11LLVMContextENS_8ArrayRefISt4pairIjPNS_16AttributeSetNodeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSet7getImplERNS_11LLVMContextENS_8ArrayRefISt4pairIjPNS_16AttributeSetNodeEEEE")
  //</editor-fold>
  private static AttributeSet getImpl(final LLVMContext /*&*/ C, 
         ArrayRef<std.pairUIntPtr<AttributeSetNode /*P*/ >> Attrs) {
    LLVMContextImpl /*P*/ pImpl = C.pImpl;
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    AttributeSetImpl.Profile(ID, /*NO_COPY*/Attrs);
    
    type$ref<type$ptr<AttributeSetImpl>/*void P*/ > InsertPoint = create_type$ref();
    AttributeSetImpl /*P*/ PA = pImpl.AttrsLists.FindNodeOrInsertPos(ID, InsertPoint);
    
    // If we didn't find any existing attributes of the same shape then
    // create a new one and insert it.
    if (!(PA != null)) {
      final int totalSizeToAlloc$Same = TrailingObjects.totalSizeToAlloc$Same(std.pairUIntPtr.class, Attrs.size());
      // Coallocate entries after the AttributeSetImpl itself.
      type$ptr/*void P*/ Mem = create_type$ptr(new$Object(totalSizeToAlloc$Same));
      // JAVA: init pairs after this-zero slot 
      for (int i = 1; i < totalSizeToAlloc$Same; i++) {
        Mem.$set(i, new std.pairUIntPtr<>());
      }
      PA = ((/*JCast*/AttributeSetImpl /*P*/ )(/*NEW_EXPR [System]*//*Mem = *//*new (Mem)*/ TrailingObjectsUtils.$new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
          return new AttributeSetImpl(C, new ArrayRef<std.pairUIntPtr<AttributeSetNode /*P*/ >>(Attrs));
       })));
      pImpl.AttrsLists.InsertNode(PA, InsertPoint.$deref());
    }
    
    // Return the AttributesList that we found or created.
    return new AttributeSet(JavaDifferentiators.JD$Misc.INSTANCE, PA);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::AttributeSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 234,
   FQN="llvm::AttributeSet::AttributeSet", NM="_ZN4llvm12AttributeSetC1EPNS_16AttributeSetImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSetC1EPNS_16AttributeSetImplE")
  //</editor-fold>
  /*friend*/public/*private*/ /*explicit*/ AttributeSet(JavaDifferentiators.JD$Misc diff, AttributeSetImpl /*P*/ LI) {
    // : pImpl(LI) 
    //START JInit
    this.pImpl = LI;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::AttributeSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 237,
   FQN="llvm::AttributeSet::AttributeSet", NM="_ZN4llvm12AttributeSetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSetC1Ev")
  //</editor-fold>
  /*friend*/public/*public*/ AttributeSet() {
    // : pImpl(null) 
    //START JInit
    this.pImpl = null;
    //END JInit
  }

  
  //===--------------------------------------------------------------------===//
  // AttributeSet Construction and Mutation
  //===--------------------------------------------------------------------===//
  
  //===--------------------------------------------------------------------===//
  // AttributeSet Construction and Mutation
  //===--------------------------------------------------------------------===//

  /// \brief Return an AttributeSet with the specified parameters in it.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 821,
   FQN="llvm::AttributeSet::get", NM="_ZN4llvm12AttributeSet3getERNS_11LLVMContextENS_8ArrayRefIS0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSet3getERNS_11LLVMContextENS_8ArrayRefIS0_EE")
  //</editor-fold>
  /*friend*/public/*public*/ static AttributeSet get_LLVMContext_ArrayRef$AttributeSet(final LLVMContext /*&*/ C, ArrayRef<AttributeSet> Attrs) {
    if (Attrs.empty()) {
      return new AttributeSet();
    }
    if (Attrs.size() == 1) {
      return new AttributeSet(Attrs.$at(0));
    }
    
    SmallVector<std.pairUIntPtr<AttributeSetNode /*P*/ >> AttrNodeVec/*J*/= new SmallVector<std.pairUIntPtr<AttributeSetNode /*P*/ >>(8, new std.pairUIntPtr<AttributeSetNode /*P*/ >());
    AttributeSetImpl /*P*/ A0 = Attrs.$at(0).pImpl;
    if ((A0 != null)) {
      AttrNodeVec.append_T(A0.getNode(0), A0.getNode(A0.getNumSlots()));
    }
    // Copy all attributes from Attrs into AttrNodeVec while keeping AttrNodeVec
    // ordered by index.  Because we know that each list in Attrs is ordered by
    // index we only need to merge each successive list in rather than doing a
    // full sort.
    for (/*uint*/int I = 1, E = Attrs.size(); I != E; ++I) {
      AttributeSetImpl /*P*/ AS = Attrs.$at(I).pImpl;
      if (!(AS != null)) {
        continue;
      }
      type$ptr<std.pairUIntPtr<AttributeSetNode /*P*/ >> ANVI = $tryClone(AttrNodeVec.begin());
      type$ptr<std.pairUIntPtr<AttributeSetNode /*P*/ >> ANVE = create_type$ptr();
      for (/*const*/type$ptr<std.pairUIntPtr<AttributeSetNode /*P*/ >> AI = $tryClone(AS.getNode(0)), 
          /*P*/ AE = $tryClone(AS.getNode(AS.getNumSlots()));
           $noteq_ptr(AI, AE); AI.$preInc()) {
        ANVE = $tryClone(AttrNodeVec.end());
        while ($noteq_ptr(ANVI, ANVE) && $lesseq_uint(ANVI./*->*/$star().first, AI./*->*/$star().first)) {
          ANVI.$preInc();
        }
        ANVI = $tryClone(AttrNodeVec.insert/*_iterator$T$value_T$C$R*/(ANVI, AI.$star()).$add(1));
      }
    }
    
    return getImpl(C, new ArrayRef<std.pairUIntPtr<AttributeSetNode /*P*/ >>(AttrNodeVec, false));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 805,
   FQN="llvm::AttributeSet::get", NM="_ZN4llvm12AttributeSet3getERNS_11LLVMContextEjNS_8ArrayRefINS_9Attribute8AttrKindEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSet3getERNS_11LLVMContextEjNS_8ArrayRefINS_9Attribute8AttrKindEEE")
  //</editor-fold>
  /*friend*/public/*public*/ static AttributeSet get_LLVMContext_uint_ArrayRef$AttrKind(final LLVMContext /*&*/ C, /*uint*/int Index, 
                                        ArrayRef<Attribute.AttrKind> Kinds) {
    SmallVector<std.pairUIntType<Attribute>> Attrs/*J*/= new SmallVector<std.pairUIntType<Attribute>>(8, new std.pairUIntType<Attribute>(0, new Attribute()));
    for (Attribute.AttrKind K : Kinds)  {
      Attrs.push_back(std.make_pair_uint_T(Index, Attribute.get(C, K)));
    }
    return get_LLVMContext_ArrayRef$pairUIntType(C, new ArrayRef<std.pairUIntType<Attribute>>(Attrs, false));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 813,
   FQN="llvm::AttributeSet::get", NM="_ZN4llvm12AttributeSet3getERNS_11LLVMContextEjNS_8ArrayRefINS_9StringRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSet3getERNS_11LLVMContextEjNS_8ArrayRefINS_9StringRefEEE")
  //</editor-fold>
  /*friend*/public/*public*/ static AttributeSet get_LLVMContext_uint_ArrayRef$StringRef(final LLVMContext /*&*/ C, /*uint*/int Index, 
                                         ArrayRef<StringRef> Kinds) {
    SmallVector<std.pairUIntType<Attribute>> Attrs/*J*/= new SmallVector<std.pairUIntType<Attribute>>(8, new std.pairUIntType<Attribute>(0, new Attribute()));
    for (StringRef K : Kinds)  {
      Attrs.push_back(std.make_pair_uint_T(Index, Attribute.get(C, new StringRef(K))));
    }
    return get_LLVMContext_ArrayRef$pairUIntType(C, new ArrayRef<std.pairUIntType<Attribute>>(Attrs, false));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 758,
   FQN="llvm::AttributeSet::get", NM="_ZN4llvm12AttributeSet3getERNS_11LLVMContextEjRKNS_11AttrBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSet3getERNS_11LLVMContextEjRKNS_11AttrBuilderE")
  //</editor-fold>
  /*friend*/public/*public*/ static AttributeSet get(final LLVMContext /*&*/ C, /*uint*/int Index, 
     final /*const*/ AttrBuilder /*&*/ B) {
    if (!B.hasAttributes()) {
      return new AttributeSet();
    }
    
    // Add target-independent attributes.
    SmallVector<std.pairUIntType<Attribute>> Attrs/*J*/= new SmallVector<std.pairUIntType<Attribute>>(8, new std.pairUIntType<Attribute>(0, new Attribute()));
    for (Attribute.AttrKind Kind = Attribute.AttrKind.None;
         Kind != Attribute.AttrKind.EndAttrKinds; Kind = Attribute.AttrKind.valueOf(Kind.getValue() + 1)) {
      if (!B.contains(Kind)) {
        continue;
      }
      
      Attribute Attr/*J*/= new Attribute();
      switch (Kind) {
       case Alignment:
        Attr.$assignMove(Attribute.getWithAlignment(C, B.getAlignment()));
        break;
       case StackAlignment:
        Attr.$assignMove(Attribute.getWithStackAlignment(C, B.getStackAlignment()));
        break;
       case Dereferenceable:
        Attr.$assignMove(Attribute.getWithDereferenceableBytes(C, B.getDereferenceableBytes()));
        break;
       case DereferenceableOrNull:
        Attr.$assignMove(Attribute.getWithDereferenceableOrNullBytes(C, B.getDereferenceableOrNullBytes()));
        break;
       case AllocSize:
        {
          std.pairUIntType<OptionalUInt> A = B.getAllocSizeArgs();
          Attr.$assignMove(Attribute.getWithAllocSizeArgs(C, A.first, A.second));
          break;
        }
       default:
        Attr.$assignMove(Attribute.get(C, Kind));
      }
      Attrs.push_back(std.make_pair_uint_T(Index, Attr));
    }
    
    // Add target-dependent (string) attributes.
    for (final /*const*/ std.pair</*const*/std.string, std.string> /*&*/ TDA : B.td_attrs$Const())  {
      Attrs.push_back(std.make_pair_uint_T(Index, Attribute.get(C, new StringRef(TDA.first), new StringRef(TDA.second))));
    }
    
    return get_LLVMContext_ArrayRef$pairUIntType(C, new ArrayRef<std.pairUIntType<Attribute>>(Attrs, false));
  }

  
  /// \brief Add an attribute to the attribute set at the given index. Because
  /// attribute sets are immutable, this returns a new set.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::addAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 851,
   FQN="llvm::AttributeSet::addAttribute", NM="_ZNK4llvm12AttributeSet12addAttributeERNS_11LLVMContextEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet12addAttributeERNS_11LLVMContextEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public AttributeSet addAttribute(final LLVMContext /*&*/ C, /*uint*/int Index, 
              Attribute.AttrKind Kind) /*const*/ {
    if (hasAttribute(Index, Kind)) {
      return new AttributeSet(/*Deref*/this);
    }
    return addAttributes(C, Index, AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, Index, new ArrayRef<Attribute.AttrKind>(Kind)));
  }

  
  /// \brief Add an attribute to the attribute set at the given index. Because
  /// attribute sets are immutable, this returns a new set.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::addAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 857,
   FQN="llvm::AttributeSet::addAttribute", NM="_ZNK4llvm12AttributeSet12addAttributeERNS_11LLVMContextEjNS_9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet12addAttributeERNS_11LLVMContextEjNS_9StringRefES3_")
  //</editor-fold>
  public AttributeSet addAttribute(final LLVMContext /*&*/ C, /*uint*/int Index, 
              StringRef Kind) /*const*/ {
    return addAttribute(C, Index, 
              Kind, new StringRef());
  }
  public AttributeSet addAttribute(final LLVMContext /*&*/ C, /*uint*/int Index, 
              StringRef Kind, StringRef Value/*= StringRef()*/) /*const*/ {
    AttrBuilder B = null;
    try {
      B/*J*/= new AttrBuilder();
      B.addAttribute(new StringRef(Kind), new StringRef(Value));
      return addAttributes(C, Index, AttributeSet.get(C, Index, B));
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  
  /// Add an attribute to the attribute set at the given indices. Because
  /// attribute sets are immutable, this returns a new set.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::addAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 864,
   FQN="llvm::AttributeSet::addAttribute", NM="_ZNK4llvm12AttributeSet12addAttributeERNS_11LLVMContextENS_8ArrayRefIjEENS_9AttributeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet12addAttributeERNS_11LLVMContextENS_8ArrayRefIjEENS_9AttributeE")
  //</editor-fold>
  public AttributeSet addAttribute(final LLVMContext /*&*/ C, 
              ArrayRefUInt Indices, 
              Attribute A) /*const*/ {
    /*uint*/int I = 0;
    /*uint*/int E = (pImpl != null) ? pImpl.getNumSlots() : 0;
    /*const*/uint$ptr/*uint P*/ IdxI = $tryClone(Indices.begin());
    /*const*/uint$ptr/*uint P*/ IdxE = $tryClone(Indices.end());
    SmallVector<AttributeSet> AttrSet/*J*/= new SmallVector<AttributeSet>(4, new AttributeSet());
    while (I != E && $noteq_ptr(IdxI, IdxE)) {
      if ($less_uint(getSlotIndex(I), IdxI.$star())) {
        AttrSet.emplace_back(new AttributeSet(getSlotAttributes(I++)));
      } else if ($greater_uint(getSlotIndex(I), IdxI.$star())) {
        AttrSet.emplace_back(new AttributeSet(AttributeSet.get_LLVMContext_ArrayRef$pairUIntType(C, new ArrayRef<std.pairUIntType<Attribute>>(std.make_pair_uint_T(IdxI.$postInc().$star(), A), false))));
      } else {
        AttrBuilder B = null;
        try {
          B/*J*/= new AttrBuilder(getSlotAttributes(I), IdxI.$star());
          B.addAttribute(new Attribute(A));
          AttrSet.emplace_back(new AttributeSet(AttributeSet.get(C, IdxI.$star(), B)));
          ++I;
          IdxI.$preInc();
        } finally {
          if (B != null) { B.$destroy(); }
        }
      }
    }
    while (I != E) {
      AttrSet.emplace_back(new AttributeSet(getSlotAttributes(I++)));
    }
    while ($noteq_ptr(IdxI, IdxE)) {
      AttrSet.emplace_back(new AttributeSet(AttributeSet.get_LLVMContext_ArrayRef$pairUIntType(C, new ArrayRef<std.pairUIntType<Attribute>>(std.make_pair_uint_T(IdxI.$postInc().$star(), A), false))));
    }
    
    return get_LLVMContext_ArrayRef$AttributeSet(C, new ArrayRef<AttributeSet>(AttrSet, false));
  }

  
  /// \brief Add attributes to the attribute set at the given index. Because
  /// attribute sets are immutable, this returns a new set.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::addAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 894,
   FQN="llvm::AttributeSet::addAttributes", NM="_ZNK4llvm12AttributeSet13addAttributesERNS_11LLVMContextEjS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet13addAttributesERNS_11LLVMContextEjS0_")
  //</editor-fold>
  public AttributeSet addAttributes(final LLVMContext /*&*/ C, /*uint*/int Index, 
               AttributeSet Attrs) /*const*/ {
    AttrBuilder B = null;
    try {
      if (!(pImpl != null)) {
        return new AttributeSet(JD$Move.INSTANCE, Attrs);
      }
      if (!(Attrs.pImpl != null)) {
        return new AttributeSet(/*Deref*/this);
      }
      // FIXME it is not obvious how this should work for alignment. For now, say
      // we can't change a known alignment.
      /*uint*/int OldAlign = getParamAlignment(Index);
      /*uint*/int NewAlign = Attrs.getParamAlignment(Index);
      assert ((!(OldAlign != 0) || !(NewAlign != 0) || OldAlign == NewAlign)) : "Attempt to change alignment!";
      
      // Add the attribute slots before the one we're trying to add.
      SmallVector<AttributeSet> AttrSet/*J*/= new SmallVector<AttributeSet>(4, new AttributeSet());
      long/*uint64_t*/ NumAttrs = $uint2ulong(pImpl.getNumSlots());
      AttributeSet AS/*J*/= new AttributeSet();
      long/*uint64_t*/ LastIndex = $int2ulong(0);
      for (/*uint*/int I = 0, E = $ulong2uint(NumAttrs); I != E; ++I) {
        if ($greatereq_uint(getSlotIndex(I), Index)) {
          if (getSlotIndex(I) == Index) {
            AS.$assignMove(getSlotAttributes($ulong2uint(LastIndex++)));
          }
          break;
        }
        LastIndex = $uint2ulong(I + 1);
        AttrSet.push_back(getSlotAttributes(I));
      }
      
      // Now add the attribute into the correct slot. There may already be an
      // AttributeSet there.
      B/*J*/= new AttrBuilder(new AttributeSet(AS), Index);
      
      for (/*uint*/int I = 0, E = Attrs.pImpl.getNumSlots(); I != E; ++I)  {
        if (Attrs.getSlotIndex(I) == Index) {
          for (type$ptr<Attribute/*P*/> II = $tryClone(Attrs.pImpl.begin(I)), 
              /*P*/ IE = $tryClone(Attrs.pImpl.end(I)); $noteq_ptr(II, IE); II.$preInc())  {
            B.addAttribute(new Attribute(II.$star()));
          }
          break;
        }
      }
      
      AttrSet.push_back(AttributeSet.get(C, Index, B));
      
      // Add the remaining attribute slots.
      for (/*uint*/int I = $ulong2uint(LastIndex), E = $ulong2uint(NumAttrs); $less_uint(I, E); ++I)  {
        AttrSet.push_back(getSlotAttributes(I));
      }
      
      return get_LLVMContext_ArrayRef$AttributeSet(C, new ArrayRef<AttributeSet>(AttrSet, false));
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  
  /// \brief Remove the specified attribute at the specified index from this
  /// attribute list. Because attribute lists are immutable, this returns the
  /// new list.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::removeAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 943,
   FQN="llvm::AttributeSet::removeAttribute", NM="_ZNK4llvm12AttributeSet15removeAttributeERNS_11LLVMContextEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet15removeAttributeERNS_11LLVMContextEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public AttributeSet removeAttribute(final LLVMContext /*&*/ C, /*uint*/int Index, 
                 Attribute.AttrKind Kind) /*const*/ {
    if (!hasAttribute(Index, Kind)) {
      return new AttributeSet(/*Deref*/this);
    }
    return removeAttributes(C, Index, AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, Index, new ArrayRef<Attribute.AttrKind>(Kind)));
  }

  
  /// \brief Remove the specified attribute at the specified index from this
  /// attribute list. Because attribute lists are immutable, this returns the
  /// new list.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::removeAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 949,
   FQN="llvm::AttributeSet::removeAttribute", NM="_ZNK4llvm12AttributeSet15removeAttributeERNS_11LLVMContextEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet15removeAttributeERNS_11LLVMContextEjNS_9StringRefE")
  //</editor-fold>
  public AttributeSet removeAttribute(final LLVMContext /*&*/ C, /*uint*/int Index, 
                 StringRef Kind) /*const*/ {
    if (!hasAttribute(Index, new StringRef(Kind))) {
      return new AttributeSet(/*Deref*/this);
    }
    return removeAttributes(C, Index, AttributeSet.get_LLVMContext_uint_ArrayRef$StringRef(C, Index, new ArrayRef<StringRef>(Kind, false)));
  }

  
  /// \brief Remove the specified attributes at the specified index from this
  /// attribute list. Because attribute lists are immutable, this returns the
  /// new list.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::removeAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 955,
   FQN="llvm::AttributeSet::removeAttributes", NM="_ZNK4llvm12AttributeSet16removeAttributesERNS_11LLVMContextEjS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet16removeAttributesERNS_11LLVMContextEjS0_")
  //</editor-fold>
  public AttributeSet removeAttributes(final LLVMContext /*&*/ C, /*uint*/int Index, 
                  AttributeSet Attrs) /*const*/ {
    AttrBuilder B = null;
    try {
      if (!(pImpl != null)) {
        return new AttributeSet();
      }
      if (!(Attrs.pImpl != null)) {
        return new AttributeSet(/*Deref*/this);
      }
      
      // FIXME it is not obvious how this should work for alignment.
      // For now, say we can't pass in alignment, which no current use does.
      assert (!Attrs.hasAttribute(Index, Attribute.AttrKind.Alignment)) : "Attempt to change alignment!";
      
      // Add the attribute slots before the one we're trying to add.
      SmallVector<AttributeSet> AttrSet/*J*/= new SmallVector<AttributeSet>(4, new AttributeSet());
      long/*uint64_t*/ NumAttrs = $uint2ulong(pImpl.getNumSlots());
      AttributeSet AS/*J*/= new AttributeSet();
      long/*uint64_t*/ LastIndex = $int2ulong(0);
      for (/*uint*/int I = 0, E = $ulong2uint(NumAttrs); I != E; ++I) {
        if ($greatereq_uint(getSlotIndex(I), Index)) {
          if (getSlotIndex(I) == Index) {
            AS.$assignMove(getSlotAttributes($ulong2uint(LastIndex++)));
          }
          break;
        }
        LastIndex = $uint2ulong(I + 1);
        AttrSet.push_back(getSlotAttributes(I));
      }
      
      // Now remove the attribute from the correct slot. There may already be an
      // AttributeSet there.
      B/*J*/= new AttrBuilder(new AttributeSet(AS), Index);
      
      for (/*uint*/int I = 0, E = Attrs.pImpl.getNumSlots(); I != E; ++I)  {
        if (Attrs.getSlotIndex(I) == Index) {
          B.removeAttributes(Attrs.pImpl.getSlotAttributes(I), $uint2ulong(Index));
          break;
        }
      }
      
      AttrSet.push_back(AttributeSet.get(C, Index, B));
      
      // Add the remaining attribute slots.
      for (/*uint*/int I = $ulong2uint(LastIndex), E = $ulong2uint(NumAttrs); $less_uint(I, E); ++I)  {
        AttrSet.push_back(getSlotAttributes(I));
      }
      
      return get_LLVMContext_ArrayRef$AttributeSet(C, new ArrayRef<AttributeSet>(AttrSet, false));
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  
  /// \brief Remove the specified attributes at the specified index from this
  /// attribute list. Because attribute lists are immutable, this returns the
  /// new list.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::removeAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 998,
   FQN="llvm::AttributeSet::removeAttributes", NM="_ZNK4llvm12AttributeSet16removeAttributesERNS_11LLVMContextEjRKNS_11AttrBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet16removeAttributesERNS_11LLVMContextEjRKNS_11AttrBuilderE")
  //</editor-fold>
  public AttributeSet removeAttributes(final LLVMContext /*&*/ C, /*uint*/int Index, 
                  final /*const*/ AttrBuilder /*&*/ Attrs) /*const*/ {
    AttrBuilder B = null;
    try {
      if (!(pImpl != null)) {
        return new AttributeSet();
      }
      
      // FIXME it is not obvious how this should work for alignment.
      // For now, say we can't pass in alignment, which no current use does.
      assert (!Attrs.hasAlignmentAttr()) : "Attempt to change alignment!";
      
      // Add the attribute slots before the one we're trying to add.
      SmallVector<AttributeSet> AttrSet/*J*/= new SmallVector<AttributeSet>(4, new AttributeSet());
      long/*uint64_t*/ NumAttrs = $uint2ulong(pImpl.getNumSlots());
      AttributeSet AS/*J*/= new AttributeSet();
      long/*uint64_t*/ LastIndex = $int2ulong(0);
      for (/*uint*/int I = 0, E = $ulong2uint(NumAttrs); I != E; ++I) {
        if ($greatereq_uint(getSlotIndex(I), Index)) {
          if (getSlotIndex(I) == Index) {
            AS.$assignMove(getSlotAttributes($ulong2uint(LastIndex++)));
          }
          break;
        }
        LastIndex = $uint2ulong(I + 1);
        AttrSet.push_back(getSlotAttributes(I));
      }
      
      // Now remove the attribute from the correct slot. There may already be an
      // AttributeSet there.
      B/*J*/= new AttrBuilder(new AttributeSet(AS), Index);
      B.remove(Attrs);
      
      AttrSet.push_back(AttributeSet.get(C, Index, B));
      
      // Add the remaining attribute slots.
      for (/*uint*/int I = $ulong2uint(LastIndex), E = $ulong2uint(NumAttrs); $less_uint(I, E); ++I)  {
        AttrSet.push_back(getSlotAttributes(I));
      }
      
      return get_LLVMContext_ArrayRef$AttributeSet(C, new ArrayRef<AttributeSet>(AttrSet, false));
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  
  /// \brief Add the dereferenceable attribute to the attribute set at the given
  /// index. Because attribute sets are immutable, this returns a new set.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::addDereferenceableAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1034,
   FQN="llvm::AttributeSet::addDereferenceableAttr", NM="_ZNK4llvm12AttributeSet22addDereferenceableAttrERNS_11LLVMContextEjy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet22addDereferenceableAttrERNS_11LLVMContextEjy")
  //</editor-fold>
  public AttributeSet addDereferenceableAttr(final LLVMContext /*&*/ C, /*uint*/int Index, 
                        long/*uint64_t*/ Bytes) /*const*/ {
    AttrBuilder B = null;
    try {
      B/*J*/= new AttrBuilder();
      B.addDereferenceableAttr(Bytes);
      return addAttributes(C, Index, AttributeSet.get(C, Index, B));
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  
  /// \brief Add the dereferenceable_or_null attribute to the attribute set at
  /// the given index. Because attribute sets are immutable, this returns a new
  /// set.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::addDereferenceableOrNullAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1041,
   FQN="llvm::AttributeSet::addDereferenceableOrNullAttr", NM="_ZNK4llvm12AttributeSet28addDereferenceableOrNullAttrERNS_11LLVMContextEjy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet28addDereferenceableOrNullAttrERNS_11LLVMContextEjy")
  //</editor-fold>
  public AttributeSet addDereferenceableOrNullAttr(final LLVMContext /*&*/ C, 
                              /*uint*/int Index, 
                              long/*uint64_t*/ Bytes) /*const*/ {
    AttrBuilder B = null;
    try {
      B/*J*/= new AttrBuilder();
      B.addDereferenceableOrNullAttr(Bytes);
      return addAttributes(C, Index, AttributeSet.get(C, Index, B));
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  
  /// Add the allocsize attribute to the attribute set at the given index.
  /// Because attribute sets are immutable, this returns a new set.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::addAllocSizeAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1049,
   FQN="llvm::AttributeSet::addAllocSizeAttr", NM="_ZN4llvm12AttributeSet16addAllocSizeAttrERNS_11LLVMContextEjjRKNS_8OptionalIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSet16addAllocSizeAttrERNS_11LLVMContextEjjRKNS_8OptionalIjEE")
  //</editor-fold>
  public AttributeSet addAllocSizeAttr(final LLVMContext /*&*/ C, /*uint*/int Index, 
                  /*uint*/int ElemSizeArg, 
                  final /*const*/OptionalUInt /*&*/ NumElemsArg) {
    AttrBuilder B = null;
    try {
      B/*J*/= new AttrBuilder();
      B.addAllocSizeAttr(ElemSizeArg, NumElemsArg);
      return addAttributes(C, Index, AttributeSet.get(C, Index, B));
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  
  //===--------------------------------------------------------------------===//
  // AttributeSet Accessors
  //===--------------------------------------------------------------------===//
  
  /// \brief Retrieve the LLVM context.
  
  //===----------------------------------------------------------------------===//
  // AttributeSet Accessor Methods
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1062,
   FQN="llvm::AttributeSet::getContext", NM="_ZNK4llvm12AttributeSet10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet10getContextEv")
  //</editor-fold>
  public LLVMContext /*&*/ getContext() /*const*/ {
    return pImpl.getContext();
  }

  
  /// \brief The attributes for the specified index are returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getParamAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1066,
   FQN="llvm::AttributeSet::getParamAttributes", NM="_ZNK4llvm12AttributeSet18getParamAttributesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet18getParamAttributesEj")
  //</editor-fold>
  public AttributeSet getParamAttributes(/*uint*/int Index) /*const*/ {
    return (pImpl != null) && hasAttributes(Index) ? AttributeSet.get_LLVMContext_ArrayRef$pairUIntType$P(pImpl.getContext(), 
        new ArrayRef<std.pairUIntPtr<AttributeSetNode /*P*/ >>(std.make_pair_uint_Ptr(Index, getAttributes(Index)), false)) : new AttributeSet();
  }

  
  /// \brief The attributes for the ret value are returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getRetAttributes">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1074,
   FQN="llvm::AttributeSet::getRetAttributes", NM="_ZNK4llvm12AttributeSet16getRetAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet16getRetAttributesEv")
  //</editor-fold>
  public AttributeSet getRetAttributes() /*const*/ {
    return (pImpl != null) && hasAttributes(AttrIndex.ReturnIndex.getValue()) ? AttributeSet.get_LLVMContext_ArrayRef$pairUIntType$P(pImpl.getContext(), 
        new ArrayRef<std.pairUIntPtr<AttributeSetNode /*P*/ >>(std.make_pair_uint_Ptr(AttrIndex.ReturnIndex.value, 
                    getAttributes(AttrIndex.ReturnIndex.getValue())), false)) : new AttributeSet();
  }

  
  /// \brief The function attributes are returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getFnAttributes">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1083,
   FQN="llvm::AttributeSet::getFnAttributes", NM="_ZNK4llvm12AttributeSet15getFnAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet15getFnAttributesEv")
  //</editor-fold>
  public AttributeSet getFnAttributes() /*const*/ {
    return (pImpl != null) && hasAttributes(AttrIndex.FunctionIndex.getValue()) ? AttributeSet.get_LLVMContext_ArrayRef$pairUIntType$P(pImpl.getContext(), 
        new ArrayRef<std.pairUIntPtr<AttributeSetNode /*P*/ >>(std.make_pair_uint_Ptr(AttrIndex.FunctionIndex.value, 
                    getAttributes(AttrIndex.FunctionIndex.getValue())), false)) : new AttributeSet();
  }

  
  /// \brief Return true if the attribute exists at the given index.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::hasAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1092,
   FQN="llvm::AttributeSet::hasAttribute", NM="_ZNK4llvm12AttributeSet12hasAttributeEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet12hasAttributeEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean hasAttribute(/*uint*/int Index, Attribute.AttrKind Kind) /*const*/ {
    AttributeSetNode /*P*/ ASN = getAttributes(Index);
    return (ASN != null) && ASN.hasAttribute(Kind);
  }

  
  /// \brief Return true if the attribute exists at the given index.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::hasAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1097,
   FQN="llvm::AttributeSet::hasAttribute", NM="_ZNK4llvm12AttributeSet12hasAttributeEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet12hasAttributeEjNS_9StringRefE")
  //</editor-fold>
  public boolean hasAttribute(/*uint*/int Index, StringRef Kind) /*const*/ {
    AttributeSetNode /*P*/ ASN = getAttributes(Index);
    return (ASN != null) && ASN.hasAttribute(new StringRef(Kind));
  }

  
  /// \brief Return true if attribute exists at the given index.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::hasAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1102,
   FQN="llvm::AttributeSet::hasAttributes", NM="_ZNK4llvm12AttributeSet13hasAttributesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet13hasAttributesEj")
  //</editor-fold>
  public boolean hasAttributes(/*uint*/int Index) /*const*/ {
    AttributeSetNode /*P*/ ASN = getAttributes(Index);
    return (ASN != null) && ASN.hasAttributes();
  }

  
  /// \brief Equivalent to hasAttribute(AttributeSet::FunctionIndex, Kind) but
  /// may be faster.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::hasFnAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1107,
   FQN="llvm::AttributeSet::hasFnAttribute", NM="_ZNK4llvm12AttributeSet14hasFnAttributeENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet14hasFnAttributeENS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean hasFnAttribute(Attribute.AttrKind Kind) /*const*/ {
    return (pImpl != null) && pImpl.hasFnAttribute(Kind);
  }

  
  /// \brief Return true if the specified attribute is set for at least one
  /// parameter or for the return value. If Index is not nullptr, the index
  /// of a parameter with the specified attribute is provided.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::hasAttrSomewhere">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1111,
   FQN="llvm::AttributeSet::hasAttrSomewhere", NM="_ZNK4llvm12AttributeSet16hasAttrSomewhereENS_9Attribute8AttrKindEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet16hasAttrSomewhereENS_9Attribute8AttrKindEPj")
  //</editor-fold>
  public boolean hasAttrSomewhere(Attribute.AttrKind Attr) /*const*/ {
    return hasAttrSomewhere(Attr, 
                  (uint$ptr/*uint P*/ )null);
  }
  public boolean hasAttrSomewhere(Attribute.AttrKind Attr, 
                  uint$ptr/*uint P*/ Index/*= null*/) /*const*/ {
    if (!(pImpl != null)) {
      return false;
    }
    
    for (/*uint*/int I = 0, E = pImpl.getNumSlots(); I != E; ++I)  {
      for (type$ptr<Attribute/*P*/> II = $tryClone(pImpl.begin(I)), 
          /*P*/ IE = $tryClone(pImpl.end(I)); $noteq_ptr(II, IE); II.$preInc())  {
        if (II./*->*/$star().hasAttribute(Attr)) {
          if (Native.$bool(Index)) {
            Index.$set(pImpl.getSlotIndex(I));
          }
          return true;
        }
      }
    }
    
    return false;
  }

  
  /// \brief Return the attribute object that exists at the given index.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1126,
   FQN="llvm::AttributeSet::getAttribute", NM="_ZNK4llvm12AttributeSet12getAttributeEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet12getAttributeEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public Attribute getAttribute(/*uint*/int Index, 
              Attribute.AttrKind Kind) /*const*/ {
    AttributeSetNode /*P*/ ASN = getAttributes(Index);
    return (ASN != null) ? ASN.getAttribute(Kind) : new Attribute();
  }

  
  /// \brief Return the attribute object that exists at the given index.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1132,
   FQN="llvm::AttributeSet::getAttribute", NM="_ZNK4llvm12AttributeSet12getAttributeEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet12getAttributeEjNS_9StringRefE")
  //</editor-fold>
  public Attribute getAttribute(/*uint*/int Index, 
              StringRef Kind) /*const*/ {
    AttributeSetNode /*P*/ ASN = getAttributes(Index);
    return (ASN != null) ? ASN.getAttribute(new StringRef(Kind)) : new Attribute();
  }

  
  /// \brief Return the alignment for the specified function parameter.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getParamAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1138,
   FQN="llvm::AttributeSet::getParamAlignment", NM="_ZNK4llvm12AttributeSet17getParamAlignmentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet17getParamAlignmentEj")
  //</editor-fold>
  public /*uint*/int getParamAlignment(/*uint*/int Index) /*const*/ {
    AttributeSetNode /*P*/ ASN = getAttributes(Index);
    return (ASN != null) ? ASN.getAlignment() : 0;
  }

  
  /// \brief Get the stack alignment.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getStackAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1143,
   FQN="llvm::AttributeSet::getStackAlignment", NM="_ZNK4llvm12AttributeSet17getStackAlignmentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet17getStackAlignmentEj")
  //</editor-fold>
  public /*uint*/int getStackAlignment(/*uint*/int Index) /*const*/ {
    AttributeSetNode /*P*/ ASN = getAttributes(Index);
    return (ASN != null) ? ASN.getStackAlignment() : 0;
  }

  
  /// \brief Get the number of dereferenceable bytes (or zero if unknown).
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getDereferenceableBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1148,
   FQN="llvm::AttributeSet::getDereferenceableBytes", NM="_ZNK4llvm12AttributeSet23getDereferenceableBytesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet23getDereferenceableBytesEj")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableBytes(/*uint*/int Index) /*const*/ {
    AttributeSetNode /*P*/ ASN = getAttributes(Index);
    return (ASN != null) ? ASN.getDereferenceableBytes() : $int2ullong(0);
  }

  
  /// \brief Get the number of dereferenceable_or_null bytes (or zero if
  /// unknown).
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getDereferenceableOrNullBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1153,
   FQN="llvm::AttributeSet::getDereferenceableOrNullBytes", NM="_ZNK4llvm12AttributeSet29getDereferenceableOrNullBytesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet29getDereferenceableOrNullBytesEj")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableOrNullBytes(/*uint*/int Index) /*const*/ {
    AttributeSetNode /*P*/ ASN = getAttributes(Index);
    return (ASN != null) ? ASN.getDereferenceableOrNullBytes() : $int2ullong(0);
  }

  
  /// Get the allocsize argument numbers (or pair(0, 0) if unknown).
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getAllocSizeArgs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1158,
   FQN="llvm::AttributeSet::getAllocSizeArgs", NM="_ZNK4llvm12AttributeSet16getAllocSizeArgsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet16getAllocSizeArgsEj")
  //</editor-fold>
  public std.pairUIntType<OptionalUInt> getAllocSizeArgs(/*uint*/int Index) /*const*/ {
    AttributeSetNode /*P*/ ASN = getAttributes(Index);
    return (ASN != null) ? ASN.getAllocSizeArgs() : std.make_pair_uint_Ptr(0, null);
  }

  
  /// \brief Return the attributes at the index as a string.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1164,
   FQN="llvm::AttributeSet::getAsString", NM="_ZNK4llvm12AttributeSet11getAsStringEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet11getAsStringEjb")
  //</editor-fold>
  public std.string getAsString(/*uint*/int Index) /*const*/ {
    return getAsString(Index, false);
  }
  public std.string getAsString(/*uint*/int Index, boolean InAttrGrp/*= false*/) /*const*/ {
    AttributeSetNode /*P*/ ASN = getAttributes(Index);
    return (ASN != null) ? ASN.getAsString(InAttrGrp) : new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
  }

  
  // JAVA: typedef ArrayRef<Attribute>::iterator iterator
//  public final class iterator extends type$ptr<Attribute>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1180,
   FQN="llvm::AttributeSet::begin", NM="_ZNK4llvm12AttributeSet5beginEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet5beginEj")
  //</editor-fold>
  public type$ptr<Attribute> begin(/*uint*/int Slot) /*const*/ {
    if (!(pImpl != null)) {
      return new ArrayRef<Attribute>(false).begin();
    }
    return pImpl.begin(Slot);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1186,
   FQN="llvm::AttributeSet::end", NM="_ZNK4llvm12AttributeSet3endEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet3endEj")
  //</editor-fold>
  public type$ptr<Attribute> end(/*uint*/int Slot) /*const*/ {
    if (!(pImpl != null)) {
      return new ArrayRef<Attribute>(false).end();
    }
    return pImpl.end(Slot);
  }

  
  /// operator==/!= - Provide equality predicates.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 379,
   FQN="llvm::AttributeSet::operator==", NM="_ZNK4llvm12AttributeSeteqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSeteqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ AttributeSet /*&*/ RHS) /*const*/ {
    return pImpl == RHS.pImpl;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 382,
   FQN="llvm::AttributeSet::operator!=", NM="_ZNK4llvm12AttributeSetneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSetneERKS0_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ AttributeSet /*&*/ RHS) /*const*/ {
    return pImpl != RHS.pImpl;
  }

  
  //===--------------------------------------------------------------------===//
  // AttributeSet Introspection
  //===--------------------------------------------------------------------===//
  
  // FIXME: Remove this.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::Raw">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1212,
   FQN="llvm::AttributeSet::Raw", NM="_ZNK4llvm12AttributeSet3RawEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet3RawEj")
  //</editor-fold>
  public long/*uint64_t*/ Raw(/*uint*/int Index) /*const*/ {
    // FIXME: Remove this.
    return (pImpl != null) ? pImpl.Raw(Index) : $int2ullong(0);
  }

  
  /// \brief Return a raw pointer that uniquely identifies this attribute list.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getRawPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 394,
   FQN="llvm::AttributeSet::getRawPointer", NM="_ZNK4llvm12AttributeSet13getRawPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet13getRawPointerEv")
  //</editor-fold>
  public Object/*void P*/ getRawPointer() /*const*/ {
    return pImpl;
  }

  
  /// \brief Return true if there are no attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::isEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 399,
   FQN="llvm::AttributeSet::isEmpty", NM="_ZNK4llvm12AttributeSet7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    return getNumSlots() == 0;
  }

  
  /// \brief Return the number of slots used in this attribute list.  This is
  /// the number of arguments that have an attribute set on them (including the
  /// function itself).
  
  //===----------------------------------------------------------------------===//
  // AttributeSet Introspection Methods
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getNumSlots">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1196,
   FQN="llvm::AttributeSet::getNumSlots", NM="_ZNK4llvm12AttributeSet11getNumSlotsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet11getNumSlotsEv")
  //</editor-fold>
  public /*uint*/int getNumSlots() /*const*/ {
    return (pImpl != null) ? pImpl.getNumSlots() : 0;
  }

  
  /// \brief Return the index for the given slot.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getSlotIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1200,
   FQN="llvm::AttributeSet::getSlotIndex", NM="_ZNK4llvm12AttributeSet12getSlotIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet12getSlotIndexEj")
  //</editor-fold>
  public /*uint*/int getSlotIndex(/*uint*/int Slot) /*const*/ {
    assert ((pImpl != null) && $less_uint(Slot, pImpl.getNumSlots())) : "Slot # out of range!";
    return pImpl.getSlotIndex(Slot);
  }

  
  /// \brief Return the attributes at the given slot.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::getSlotAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1206,
   FQN="llvm::AttributeSet::getSlotAttributes", NM="_ZNK4llvm12AttributeSet17getSlotAttributesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet17getSlotAttributesEj")
  //</editor-fold>
  public AttributeSet getSlotAttributes(/*uint*/int Slot) /*const*/ {
    assert ((pImpl != null) && $less_uint(Slot, pImpl.getNumSlots())) : "Slot # out of range!";
    return pImpl.getSlotAttributes(Slot);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1217,
   FQN="llvm::AttributeSet::dump", NM="_ZNK4llvm12AttributeSet4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm12AttributeSet4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dbgs().$out(/*KEEP_STR*/"PAL[\n");
    
    for (/*uint*/int i = 0, e = getNumSlots(); $less_uint(i, e); ++i) {
      long/*uint64_t*/ Index = $uint2ulong(getSlotIndex(i));
      dbgs().$out(/*KEEP_STR*/"  { ");
      if (Index == $uint2ullong(~0/*U*/)) {
        dbgs().$out(/*KEEP_STR*/"~0U");
      } else {
        dbgs().$out_ullong(Index);
      }
      dbgs().$out(/*KEEP_STR*/" => ").$out(getAsString($ulong2uint(Index))).$out(/*KEEP_STR*/" }\n");
    }
    
    dbgs().$out(/*KEEP_STR*/"]\n");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::AttributeSet">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 203,
   FQN="llvm::AttributeSet::AttributeSet", NM="_ZN4llvm12AttributeSetC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSetC1ERKS0_")
  //</editor-fold>
  /*friend*/public/*public*/ /*inline*/ AttributeSet(final /*const*/ AttributeSet /*&*/ $Prm0) {
    // : pImpl(.pImpl) 
    //START JInit
    this.pImpl = $Prm0.pImpl;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::AttributeSet">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 203,
   FQN="llvm::AttributeSet::AttributeSet", NM="_ZN4llvm12AttributeSetC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSetC1EOS0_")
  //</editor-fold>
  /*friend*/public/*public*/ /*inline*/ AttributeSet(JD$Move _dparam, final AttributeSet /*&&*/$Prm0) {
    // : pImpl(static_cast<AttributeSet &&>().pImpl) 
    //START JInit
    this.pImpl = $Prm0.pImpl;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 203,
   FQN="llvm::AttributeSet::operator=", NM="_ZN4llvm12AttributeSetaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSetaSERKS0_")
  //</editor-fold>
  public /*inline*/ AttributeSet /*&*/ $assign(final /*const*/ AttributeSet /*&*/ $Prm0) {
    this.pImpl = $Prm0.pImpl;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 203,
   FQN="llvm::AttributeSet::operator=", NM="_ZN4llvm12AttributeSetaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12AttributeSetaSEOS0_")
  //</editor-fold>
  public /*inline*/ AttributeSet /*&*/ $assignMove(final AttributeSet /*&&*/$Prm0) {
    this.pImpl = $Prm0.pImpl;
    return /*Deref*/this;
  }

  @Override public AttributeSet clone() {
    return new AttributeSet(this);
  }  
  
  @Override public AttributeSet move() {
    return new AttributeSet(JD$Move.INSTANCE, this);
  }
  
  
  @Override public String toString() {
    return "" + "pImpl=" + pImpl; // NOI18N
  }
}
