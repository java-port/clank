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
import org.clank.support.JavaDifferentiators.JD$T;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.ADTAliases.OptionalUInt;
import org.llvm.adt.aliases.*;
import org.llvm.adt.java.TrailingObjectsUtils;
import org.llvm.ir.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;


//===----------------------------------------------------------------------===//
/// \class
/// \brief This class represents a group of attributes that apply to one
/// element: function, return type, or parameter.
//<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AttributeSetNode.h", line = 29,
 FQN="llvm::AttributeSetNode", NM="_ZN4llvm16AttributeSetNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetNodeE")
//</editor-fold>
public final class AttributeSetNode extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node, /*private*/ TrailingObjects<AttributeSetNode, Attribute>, Iterable<Attribute /*P*/ >,
        ITrailingObjectsJavaBase<AttributeSetNode> {
  /*friend  TrailingObjects<AttributeSetNode, Attribute>*/
  
  private /*uint*/int NumAttrs; ///< Number of attributes in this node.
  /// Bitset with a bit for each available attribute Attribute::AttrKind.
  private long/*uint64_t*/ AvailableAttrs;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::AttributeSetNode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeSetNode.h", line = 38,
   FQN="llvm::AttributeSetNode::AttributeSetNode", NM="_ZN4llvm16AttributeSetNodeC1ENS_8ArrayRefINS_9AttributeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetNodeC1ENS_8ArrayRefINS_9AttributeEEE")
  //</editor-fold>
  private AttributeSetNode(ArrayRef<Attribute> Attrs) {
    // : FoldingSetNode(), TrailingObjects<AttributeSetNode, Attribute>(), NumAttrs(Attrs.size()), AvailableAttrs(0) 
    //START JInit
    $Node();
    $TrailingObjects();
    this.NumAttrs = Attrs.size();
    this.AvailableAttrs = $int2ulong(0);
    //END JInit
    static_assert($lesseq_uint(Attribute.AttrKind.EndAttrKinds.getValue(), sizeof(AvailableAttrs) * CHAR_BIT), $("Too many attributes for AvailableAttrs"));
    // There's memory after the node where we can store the entries in.
    std.copy(Attrs.begin(), Attrs.end(), getTrailingObjects(Attribute.class));
    
    for (Attribute I : /*Deref*/this) {
      if (!I.isStringAttribute()) {
        AvailableAttrs |= ((long/*uint64_t*/)$int2ulong(1)) << I.getKindAsEnum().getValue();
      }
    }
  }

  
  // AttributesSetNode is uniqued, these should not be publicly available.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeSetNode.h", line = 53,
   FQN="llvm::AttributeSetNode::operator=", NM="_ZN4llvm16AttributeSetNodeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetNodeaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ AttributeSetNode /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::AttributeSetNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeSetNode.h", line = 54,
   FQN="llvm::AttributeSetNode::AttributeSetNode", NM="_ZN4llvm16AttributeSetNodeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetNodeC1ERKS0_")
  //</editor-fold>
  protected/*private*/ AttributeSetNode(final /*const*/ AttributeSetNode /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::operator delete">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeSetNode.h", line = 56,
   FQN="llvm::AttributeSetNode::operator delete", NM="_ZN4llvm16AttributeSetNodedlEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetNodedlEPv")
  //</editor-fold>
  public static void $delete(Object/*void P*/ p) {
    ///*::*/$delete_voidPtr(p);
  }

  
  
  //===----------------------------------------------------------------------===//
  // AttributeSetNode Definition
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 543,
   FQN="llvm::AttributeSetNode::get", NM="_ZN4llvm16AttributeSetNode3getERNS_11LLVMContextENS_8ArrayRefINS_9AttributeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetNode3getERNS_11LLVMContextENS_8ArrayRefINS_9AttributeEEE")
  //</editor-fold>
  public static AttributeSetNode /*P*/ get(final LLVMContext /*&*/ C, 
     ArrayRef<Attribute> Attrs) {
    if (Attrs.empty()) {
      return null;
    }
    
    // Otherwise, build a key to look up the existing attributes.
    LLVMContextImpl /*P*/ pImpl = C.pImpl;
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    
    SmallVector<Attribute> SortedAttrs/*J*/= new SmallVector<Attribute>(JD$T.INSTANCE, 8, Attrs.begin(), Attrs.end(), new Attribute());
    std.sort(SortedAttrs.begin(), SortedAttrs.end());
    
    for (Attribute Attr : SortedAttrs)  {
      Attr.Profile(ID);
    }
    
    type$ref<type$ptr<AttributeSetNode>/*void P*/ > InsertPoint = create_type$ref();
    AttributeSetNode /*P*/ PA = pImpl.AttrsSetNodes.FindNodeOrInsertPos(ID, InsertPoint);
    
    // If we didn't find any existing attributes of the same shape then create a
    // new one and insert it.
    if (!(PA != null)) {
      // Coallocate entries after the AttributeSetNode itself.
      // JAVA: ALLOC
      final int totalSizeToAlloc$Same = TrailingObjects.totalSizeToAlloc$Same(Attribute.class, SortedAttrs.size());
      type$ptr/*void P*/ Mem = create_type$ptr(new$Object(totalSizeToAlloc$Same));
      for (int i = 1/*skip zero element used for this*/; i < totalSizeToAlloc$Same; i++) {
        Mem.$set(i, new Attribute());
      }
      PA = ((/*JCast*/AttributeSetNode /*P*/ )(/*NEW_EXPR [System]*//*Mem = *//*new (Mem)*/ TrailingObjectsUtils.$new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
          return new AttributeSetNode(new ArrayRef<Attribute>(SortedAttrs, false));
       })));
      pImpl.AttrsSetNodes.InsertNode(PA, InsertPoint.$deref());
    }
    
    // Return the AttributesListNode that we found or created.
    return PA;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeSetNode.h", line = 60,
   FQN="llvm::AttributeSetNode::get", NM="_ZN4llvm16AttributeSetNode3getENS_12AttributeSetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetNode3getENS_12AttributeSetEj")
  //</editor-fold>
  public static AttributeSetNode /*P*/ get(AttributeSet AS, /*uint*/int Index) {
    return AS.getAttributes(Index);
  }

  
  /// \brief Return the number of attributes this AttributeSet contains.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::getNumAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeSetNode.h", line = 65,
   FQN="llvm::AttributeSetNode::getNumAttributes", NM="_ZNK4llvm16AttributeSetNode16getNumAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetNode16getNumAttributesEv")
  //</editor-fold>
  public /*uint*/int getNumAttributes() /*const*/ {
    return NumAttrs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::hasAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeSetNode.h", line = 67,
   FQN="llvm::AttributeSetNode::hasAttribute", NM="_ZNK4llvm16AttributeSetNode12hasAttributeENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetNode12hasAttributeENS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean hasAttribute(Attribute.AttrKind Kind) /*const*/ {
    return ((AvailableAttrs & ((long/*uint64_t*/)$int2ulong(1)) << Kind.getValue()) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::hasAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 575,
   FQN="llvm::AttributeSetNode::hasAttribute", NM="_ZNK4llvm16AttributeSetNode12hasAttributeENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetNode12hasAttributeENS_9StringRefE")
  //</editor-fold>
  public boolean hasAttribute(StringRef Kind) /*const*/ {
    for (Attribute I : /*Deref*/this)  {
      if (I.hasAttribute(new StringRef(Kind))) {
        return true;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::hasAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeSetNode.h", line = 71,
   FQN="llvm::AttributeSetNode::hasAttributes", NM="_ZNK4llvm16AttributeSetNode13hasAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetNode13hasAttributesEv")
  //</editor-fold>
  public boolean hasAttributes() /*const*/ {
    return NumAttrs != 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::getAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 582,
   FQN="llvm::AttributeSetNode::getAttribute", NM="_ZNK4llvm16AttributeSetNode12getAttributeENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetNode12getAttributeENS_9Attribute8AttrKindE")
  //</editor-fold>
  public Attribute getAttribute(Attribute.AttrKind Kind) /*const*/ {
    if (hasAttribute(Kind)) {
      for (Attribute I : /*Deref*/this)  {
        if (I.hasAttribute(Kind)) {
          return I;
        }
      }
    }
    return new Attribute();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::getAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 591,
   FQN="llvm::AttributeSetNode::getAttribute", NM="_ZNK4llvm16AttributeSetNode12getAttributeENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetNode12getAttributeENS_9StringRefE")
  //</editor-fold>
  public Attribute getAttribute(StringRef Kind) /*const*/ {
    for (Attribute I : /*Deref*/this)  {
      if (I.hasAttribute(new StringRef(Kind))) {
        return I;
      }
    }
    return new Attribute();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 598,
   FQN="llvm::AttributeSetNode::getAlignment", NM="_ZNK4llvm16AttributeSetNode12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetNode12getAlignmentEv")
  //</editor-fold>
  public /*uint*/int getAlignment() /*const*/ {
    for (Attribute I : /*Deref*/this)  {
      if (I.hasAttribute(Attribute.AttrKind.Alignment)) {
        return I.getAlignment();
      }
    }
    return 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::getStackAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 605,
   FQN="llvm::AttributeSetNode::getStackAlignment", NM="_ZNK4llvm16AttributeSetNode17getStackAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetNode17getStackAlignmentEv")
  //</editor-fold>
  public /*uint*/int getStackAlignment() /*const*/ {
    for (Attribute I : /*Deref*/this)  {
      if (I.hasAttribute(Attribute.AttrKind.StackAlignment)) {
        return I.getStackAlignment();
      }
    }
    return 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::getDereferenceableBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 612,
   FQN="llvm::AttributeSetNode::getDereferenceableBytes", NM="_ZNK4llvm16AttributeSetNode23getDereferenceableBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetNode23getDereferenceableBytesEv")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableBytes() /*const*/ {
    for (Attribute I : /*Deref*/this)  {
      if (I.hasAttribute(Attribute.AttrKind.Dereferenceable)) {
        return I.getDereferenceableBytes();
      }
    }
    return $int2ulong(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::getDereferenceableOrNullBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 619,
   FQN="llvm::AttributeSetNode::getDereferenceableOrNullBytes", NM="_ZNK4llvm16AttributeSetNode29getDereferenceableOrNullBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetNode29getDereferenceableOrNullBytesEv")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableOrNullBytes() /*const*/ {
    for (Attribute I : /*Deref*/this)  {
      if (I.hasAttribute(Attribute.AttrKind.DereferenceableOrNull)) {
        return I.getDereferenceableOrNullBytes();
      }
    }
    return $int2ulong(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::getAllocSizeArgs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 626,
   FQN="llvm::AttributeSetNode::getAllocSizeArgs", NM="_ZNK4llvm16AttributeSetNode16getAllocSizeArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetNode16getAllocSizeArgsEv")
  //</editor-fold>
  public std.pairUIntType<OptionalUInt> getAllocSizeArgs() /*const*/ {
    for (Attribute I : /*Deref*/this)  {
      if (I.hasAttribute(Attribute.AttrKind.AllocSize)) {
        return I.getAllocSizeArgs();
      }
    }
    return std.make_pair_uint_int2T(0, new OptionalUInt(0));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 634,
   FQN="llvm::AttributeSetNode::getAsString", NM="_ZNK4llvm16AttributeSetNode11getAsStringEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetNode11getAsStringEb")
  //</editor-fold>
  public std.string getAsString(boolean InAttrGrp) /*const*/ {
    std.string Str/*J*/= new std.string();
    for (type$ptr</*const*/ Attribute /*P*/ > I = $tryClone(begin()), /*P*/ E = $tryClone(end()); $noteq_ptr(I, E); I.$preInc()) {
      if ($noteq_ptr(I, begin())) {
        Str.$addassign_T($$SPACE);
      }
      Str.$addassign(I./*->*/$star().getAsString(InAttrGrp));
    }
    return Str;
  }

  
  // JAVA: typedef const Attribute *iterator
//  public final class iterator extends /*const*/ Attribute /*P*/ { };
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeSetNode.h", line = 84,
   FQN="llvm::AttributeSetNode::begin", NM="_ZNK4llvm16AttributeSetNode5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetNode5beginEv")
  //</editor-fold>
  public type$ptr</*const*/ Attribute /*P*/ > begin() /*const*/ {
    return getTrailingObjects$Const(Attribute.class);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeSetNode.h", line = 85,
   FQN="llvm::AttributeSetNode::end", NM="_ZNK4llvm16AttributeSetNode3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetNode3endEv")
  //</editor-fold>
  public type$ptr</*const*/ Attribute /*P*/ > end() /*const*/ {
    return begin().$add(NumAttrs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeSetNode.h", line = 87,
   FQN="llvm::AttributeSetNode::Profile", NM="_ZNK4llvm16AttributeSetNode7ProfileERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm16AttributeSetNode7ProfileERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    AttributeSetNode.Profile(ID, makeArrayRef(begin(), end()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeSetNode::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeSetNode.h", line = 90,
   FQN="llvm::AttributeSetNode::Profile", NM="_ZN4llvm16AttributeSetNode7ProfileERNS_16FoldingSetNodeIDENS_8ArrayRefINS_9AttributeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm16AttributeSetNode7ProfileERNS_16FoldingSetNodeIDENS_8ArrayRefINS_9AttributeEEE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, ArrayRef<Attribute> AttrList) {
    for (/*uint*/int I = 0, E = AttrList.size(); I != E; ++I)  {
      AttrList.$at(I).Profile(ID);
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public java.util.Iterator<Attribute> iterator() {
    return new JavaIterator<Attribute>(begin(), end());
  }

  private final type$ptr<?> $This$TrailingObjects = $ITrailingObjectsJavaBase();

  @Override
  public final type$ptr<?> $TrailingObjects() {
    assert $This$TrailingObjects != null;
    return $This$TrailingObjects;
  }

  @Override
  public int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == Attribute.class;
    return 0;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "NumAttrs=" + NumAttrs // NOI18N
              + ", AvailableAttrs=" + AvailableAttrs // NOI18N
              + super.toString(); // NOI18N
  }
}
