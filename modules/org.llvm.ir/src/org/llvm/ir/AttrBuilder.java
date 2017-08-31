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
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;


//===----------------------------------------------------------------------===//
/// \class
/// \brief This class is used in conjunction with the Attribute::get method to
/// create an Attribute object. The object itself is uniquified. The Builder's
/// value, however, is not. So this can be used as a quick way to test for
/// equality, presence of attributes, etc.
//<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 444,
 FQN="llvm::AttrBuilder", NM="_ZN4llvm11AttrBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilderE")
//</editor-fold>
public class AttrBuilder implements Destructors.ClassWithDestructor, Native.NativeComparable<AttrBuilder> {
  private std.bitset/*Attribute.AttrKind.EndAttrKinds.getValue()*/ Attrs;
  private std.mapTypeType<std.string, std.string> TargetDepAttrs;
  private long/*uint64_t*/ Alignment;
  private long/*uint64_t*/ StackAlignment;
  private long/*uint64_t*/ DerefBytes;
  private long/*uint64_t*/ DerefOrNullBytes;
  private long/*uint64_t*/ AllocSizeArgs;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::AttrBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 454,
   FQN="llvm::AttrBuilder::AttrBuilder", NM="_ZN4llvm11AttrBuilderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilderC1Ev")
  //</editor-fold>
  public AttrBuilder() {
    // : Attrs(0), TargetDepAttrs(), Alignment(0), StackAlignment(0), DerefBytes(0), DerefOrNullBytes(0), AllocSizeArgs(0)
    //START JInit
    this.Attrs = new std.bitset/*Attribute.AttrKind.EndAttrKinds.getValue()*/(Attribute.AttrKind.EndAttrKinds.getValue());
    this.TargetDepAttrs = new std.mapTypeType<std.string, std.string>(std.string.EMPTY);
    this.Alignment = $int2ulong(0);
    this.StackAlignment = $int2ulong(0);
    this.DerefBytes = $int2ulong(0);
    this.DerefOrNullBytes = $int2ulong(0);
    this.AllocSizeArgs = $int2ulong(0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::AttrBuilder">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 457,
   FQN="llvm::AttrBuilder::AttrBuilder", NM="_ZN4llvm11AttrBuilderC1Ey",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilderC1Ey")
  //</editor-fold>
  public /*explicit*/ AttrBuilder(long/*uint64_t*/ Val) {
    // : Attrs(0), TargetDepAttrs(), Alignment(0), StackAlignment(0), DerefBytes(0), DerefOrNullBytes(0), AllocSizeArgs(0)
    //START JInit
    this.Attrs = new std.bitset/*Attribute.AttrKind.EndAttrKinds.getValue()*/(Attribute.AttrKind.EndAttrKinds.getValue());
    this.TargetDepAttrs = new std.mapTypeType<std.string, std.string>(std.string.EMPTY);
    this.Alignment = $int2ulong(0);
    this.StackAlignment = $int2ulong(0);
    this.DerefBytes = $int2ulong(0);
    this.DerefOrNullBytes = $int2ulong(0);
    this.AllocSizeArgs = $int2ulong(0);
    //END JInit
    addRawValue(Val);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::AttrBuilder">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 462,
   FQN="llvm::AttrBuilder::AttrBuilder", NM="_ZN4llvm11AttrBuilderC1ERKNS_9AttributeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilderC1ERKNS_9AttributeE")
  //</editor-fold>
  public AttrBuilder(final /*const*/ Attribute /*&*/ A) {
    // : Attrs(0), TargetDepAttrs(), Alignment(0), StackAlignment(0), DerefBytes(0), DerefOrNullBytes(0), AllocSizeArgs(0)
    //START JInit
    this.Attrs = new std.bitset/*Attribute.AttrKind.EndAttrKinds.getValue()*/(Attribute.AttrKind.EndAttrKinds.getValue());
    this.TargetDepAttrs = new std.mapTypeType<std.string, std.string>(std.string.EMPTY);
    this.Alignment = $int2ulong(0);
    this.StackAlignment = $int2ulong(0);
    this.DerefBytes = $int2ulong(0);
    this.DerefOrNullBytes = $int2ulong(0);
    this.AllocSizeArgs = $int2ulong(0);
    //END JInit
    addAttribute(new Attribute(A));
  }


  //===----------------------------------------------------------------------===//
  // AttrBuilder Method Implementations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::AttrBuilder">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1237,
   FQN="llvm::AttrBuilder::AttrBuilder", NM="_ZN4llvm11AttrBuilderC1ENS_12AttributeSetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilderC1ENS_12AttributeSetEj")
  //</editor-fold>
  public AttrBuilder(AttributeSet AS, /*uint*/int Index) {
    // : Attrs(0), TargetDepAttrs(), Alignment(0), StackAlignment(0), DerefBytes(0), DerefOrNullBytes(0), AllocSizeArgs(0)
    //START JInit
    this.Attrs = new std.bitset/*Attribute.AttrKind.EndAttrKinds.getValue()*/(Attribute.AttrKind.EndAttrKinds.getValue());
    this.TargetDepAttrs = new std.mapTypeType<std.string, std.string>(std.string.EMPTY);
    this.Alignment = $int2ulong(0);
    this.StackAlignment = $int2ulong(0);
    this.DerefBytes = $int2ulong(0);
    this.DerefOrNullBytes = $int2ulong(0);
    this.AllocSizeArgs = $int2ulong(0);
    //END JInit
    AttributeSetImpl /*P*/ pImpl = AS.pImpl;
    if (!(pImpl != null)) {
      return;
    }

    for (/*uint*/int I = 0, E = pImpl.getNumSlots(); I != E; ++I) {
      if (pImpl.getSlotIndex(I) != Index) {
        continue;
      }

      for (type$ptr<Attribute/*P*/> II = $tryClone(pImpl.begin(I)),
          /*P*/ IE = $tryClone(pImpl.end(I)); $noteq_ptr(II, IE); II.$preInc())  {
        addAttribute(new Attribute(II.$star()));
      }

      break;
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1254,
   FQN="llvm::AttrBuilder::clear", NM="_ZN4llvm11AttrBuilder5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder5clearEv")
  //</editor-fold>
  public void clear() {
    Attrs.reset();
    TargetDepAttrs.clear();
    Alignment = StackAlignment = DerefBytes = DerefOrNullBytes = $int2ulong(0);
    AllocSizeArgs = $int2ulong(0);
  }


  /// \brief Add an attribute to the builder.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::addAttribute">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1261,
   FQN="llvm::AttrBuilder::addAttribute", NM="_ZN4llvm11AttrBuilder12addAttributeENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder12addAttributeENS_9Attribute8AttrKindE")
  //</editor-fold>
  public AttrBuilder /*&*/ addAttribute(Attribute.AttrKind Val) {
    assert ($less_uint(Val.getValue(), Attribute.AttrKind.EndAttrKinds.getValue())) : "Attribute out of range!";
    assert (Val != Attribute.AttrKind.Alignment && Val != Attribute.AttrKind.StackAlignment && Val != Attribute.AttrKind.Dereferenceable && Val != Attribute.AttrKind.AllocSize) : "Adding integer attribute without adding a value!";
    //$c$.clean($c$.track(Attrs.$at(/*KEEP_ENUM*/Val.getValue())).$assign(/*KEEP_BOOL*/true));
    Attrs.set(/*KEEP_ENUM*/Val.getValue(), /*KEEP_BOOL*/true);
    return /*Deref*/this;
  }


  /// \brief Add the Attribute object to the builder.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::addAttribute">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1270,
   FQN="llvm::AttrBuilder::addAttribute", NM="_ZN4llvm11AttrBuilder12addAttributeENS_9AttributeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder12addAttributeENS_9AttributeE")
  //</editor-fold>
  public AttrBuilder /*&*/ addAttribute(Attribute Attr) {
    if (Attr.isStringAttribute()) {
      addAttribute(Attr.getKindAsString(), Attr.getValueAsString());
      return /*Deref*/this;
    }

    Attribute.AttrKind Kind = Attr.getKindAsEnum();
    Attrs.set(/*KEEP_ENUM*/Kind.getValue(), /*KEEP_BOOL*/true);
    if (Kind == Attribute.AttrKind.Alignment) {
      Alignment = $uint2ulong(Attr.getAlignment());
    } else if (Kind == Attribute.AttrKind.StackAlignment) {
      StackAlignment = $uint2ulong(Attr.getStackAlignment());
    } else if (Kind == Attribute.AttrKind.Dereferenceable) {
      DerefBytes = Attr.getDereferenceableBytes();
    } else if (Kind == Attribute.AttrKind.DereferenceableOrNull) {
      DerefOrNullBytes = Attr.getDereferenceableOrNullBytes();
    } else if (Kind == Attribute.AttrKind.AllocSize) {
      AllocSizeArgs = Attr.getValueAsInt();
    }
    return /*Deref*/this;
  }


  /// \brief Add the target-dependent attribute to the builder.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::addAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1292,
   FQN="llvm::AttrBuilder::addAttribute", NM="_ZN4llvm11AttrBuilder12addAttributeENS_9StringRefES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder12addAttributeENS_9StringRefES1_")
  //</editor-fold>
  public AttrBuilder /*&*/ addAttribute(StringRef A) {
    return addAttribute(A, new StringRef());
  }
  public AttrBuilder /*&*/ addAttribute(StringRef A, StringRef V/*= StringRef()*/) {
    TargetDepAttrs.$at_T$RR(A.$string()).$assignMove(V.$string());
    return /*Deref*/this;
  }


  /// \brief Remove an attribute from the builder.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::removeAttribute">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1297,
   FQN="llvm::AttrBuilder::removeAttribute", NM="_ZN4llvm11AttrBuilder15removeAttributeENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder15removeAttributeENS_9Attribute8AttrKindE")
  //</editor-fold>
  public AttrBuilder /*&*/ removeAttribute(Attribute.AttrKind Val) {
    assert ($less_uint(Val.getValue(), Attribute.AttrKind.EndAttrKinds.getValue())) : "Attribute out of range!";
    Attrs.set(/*KEEP_ENUM*/Val.getValue(), /*KEEP_BOOL*/false);
    if (Val == Attribute.AttrKind.Alignment) {
      Alignment = $int2ulong(0);
    } else if (Val == Attribute.AttrKind.StackAlignment) {
      StackAlignment = $int2ulong(0);
    } else if (Val == Attribute.AttrKind.Dereferenceable) {
      DerefBytes = $int2ulong(0);
    } else if (Val == Attribute.AttrKind.DereferenceableOrNull) {
      DerefOrNullBytes = $int2ulong(0);
    } else if (Val == Attribute.AttrKind.AllocSize) {
      AllocSizeArgs = $int2ulong(0);
    }
    return /*Deref*/this;
  }

  /// \brief Remove the attributes from the builder.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::removeAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1315,
   FQN="llvm::AttrBuilder::removeAttributes", NM="_ZN4llvm11AttrBuilder16removeAttributesENS_12AttributeSetEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder16removeAttributesENS_12AttributeSetEy")
  //</editor-fold>
  public AttrBuilder /*&*/ removeAttributes(AttributeSet A, long/*uint64_t*/ Index) {
    /*uint*/int Slot = ~0/*U*/;
    for (/*uint*/int I = 0, E = A.getNumSlots(); I != E; ++I)  {
      if ($uint2ullong(A.getSlotIndex(I)) == Index) {
        Slot = I;
        break;
      }
    }
    assert (Slot != ~0/*U*/) : "Couldn't find index in AttributeSet!";

    for (type$ptr<Attribute> I = $tryClone(A.begin(Slot)), /*P*/ E = $tryClone(A.end(Slot)); $noteq_ptr(I, E); I.$preInc()) {
      Attribute Attr = new Attribute(I.$star());
      if (Attr.isEnumAttribute() || Attr.isIntAttribute()) {
        removeAttribute(Attr.getKindAsEnum());
      } else {
        assert (Attr.isStringAttribute()) : "Invalid attribute type!";
        removeAttribute(Attr.getKindAsString());
      }
    }

    return /*Deref*/this;
  }


  /// \brief Remove the target-dependent attribute to the builder.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::removeAttribute">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1338,
   FQN="llvm::AttrBuilder::removeAttribute", NM="_ZN4llvm11AttrBuilder15removeAttributeENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder15removeAttributeENS_9StringRefE")
  //</editor-fold>
  public AttrBuilder /*&*/ removeAttribute(StringRef A) {
    std.mapTypeType.iterator</*const*/std.string, std.string> I = TargetDepAttrs.find(A.$string());
    if (I.$noteq(TargetDepAttrs.end())) {
      TargetDepAttrs.erase(new std.mapTypeType.iterator</*const*/std.string, std.string>(I));
    }
    return /*Deref*/this;
  }


  /// \brief Add the attributes from the builder.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::merge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1405,
   FQN="llvm::AttrBuilder::merge", NM="_ZN4llvm11AttrBuilder5mergeERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder5mergeERKS0_")
  //</editor-fold>
  public AttrBuilder /*&*/ merge(final /*const*/ AttrBuilder /*&*/ B) {
    // FIXME: What if both have alignments, but they don't match?!
    if (!(Alignment != 0)) {
      Alignment = B.Alignment;
    }
    if (!(StackAlignment != 0)) {
      StackAlignment = B.StackAlignment;
    }
    if (!(DerefBytes != 0)) {
      DerefBytes = B.DerefBytes;
    }
    if (!(DerefOrNullBytes != 0)) {
      DerefOrNullBytes = B.DerefOrNullBytes;
    }
    if (!(AllocSizeArgs != 0)) {
      AllocSizeArgs = B.AllocSizeArgs;
    }

    Attrs.$orassign(B.Attrs);

    for (std.pair</*const*/std.string, std.string> I : B.td_attrs$Const())  {
      TargetDepAttrs.$at_T$C$R(I.first).$assign(I.second);
    }

    return /*Deref*/this;
  }


  /// \brief Remove the attributes from the builder.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1430,
   FQN="llvm::AttrBuilder::remove", NM="_ZN4llvm11AttrBuilder6removeERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder6removeERKS0_")
  //</editor-fold>
  public AttrBuilder /*&*/ remove(final /*const*/ AttrBuilder /*&*/ B) {
    // FIXME: What if both have alignments, but they don't match?!
    if ((B.Alignment != 0)) {
      Alignment = $int2ulong(0);
    }
    if ((B.StackAlignment != 0)) {
      StackAlignment = $int2ulong(0);
    }
    if ((B.DerefBytes != 0)) {
      DerefBytes = $int2ulong(0);
    }
    if ((B.DerefOrNullBytes != 0)) {
      DerefOrNullBytes = $int2ulong(0);
    }
    if ((B.AllocSizeArgs != 0)) {
      AllocSizeArgs = $int2ulong(0);
    }

    Attrs.$andassign(B.Attrs.$bitnot());

    for (std.pair</*const*/std.string, std.string> I : B.td_attrs$Const())  {
      TargetDepAttrs.erase(I.first);
    }

    return /*Deref*/this;
  }


  /// \brief Return true if the builder has any attribute that's in the
  /// specified builder.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::overlaps">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1455,
   FQN="llvm::AttrBuilder::overlaps", NM="_ZNK4llvm11AttrBuilder8overlapsERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder8overlapsERKS0_")
  //</editor-fold>
  public boolean overlaps(final /*const*/ AttrBuilder /*&*/ B) /*const*/ {
    // First check if any of the target independent attributes overlap.
    if ((bitset.$bitand_bitset$_Nb$C(Attrs, B.Attrs)).any()) {
      return true;
    }

    // Then check if any target dependent ones do.
    for (std.pair</*const*/std.string, std.string> I : td_attrs$Const())  {
      if (B.contains(new StringRef(I.first))) {
        return true;
      }
    }

    return false;
  }


  /// \brief Return true if the builder has the specified attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::contains">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 500,
   FQN="llvm::AttrBuilder::contains", NM="_ZNK4llvm11AttrBuilder8containsENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder8containsENS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean contains(Attribute.AttrKind A) /*const*/ {
    assert ($less_uint(A.getValue(), Attribute.AttrKind.EndAttrKinds.getValue())) : "Attribute out of range!";
    return Attrs.$at$Const(/*KEEP_ENUM*/A.getValue());
  }


  /// \brief Return true if the builder has the specified target-dependent
  /// attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::contains">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1468,
   FQN="llvm::AttrBuilder::contains", NM="_ZNK4llvm11AttrBuilder8containsENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder8containsENS_9StringRefE")
  //</editor-fold>
  public boolean contains(StringRef A) /*const*/ {
    return TargetDepAttrs.find$Const(A.$string()).$noteq(TargetDepAttrs.end$Const());
  }


  /// \brief Return true if the builder has IR-level attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::hasAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1472,
   FQN="llvm::AttrBuilder::hasAttributes", NM="_ZNK4llvm11AttrBuilder13hasAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder13hasAttributesEv")
  //</editor-fold>
  public boolean hasAttributes() /*const*/ {
    return !Attrs.none() || !TargetDepAttrs.empty();
  }


  /// \brief Return true if the builder has any attribute that's in the
  /// specified attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::hasAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1476,
   FQN="llvm::AttrBuilder::hasAttributes", NM="_ZNK4llvm11AttrBuilder13hasAttributesENS_12AttributeSetEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder13hasAttributesENS_12AttributeSetEy")
  //</editor-fold>
  public boolean hasAttributes(AttributeSet A, long/*uint64_t*/ Index) /*const*/ {
    /*uint*/int Slot = ~0/*U*/;
    for (/*uint*/int I = 0, E = A.getNumSlots(); I != E; ++I)  {
      if ($uint2ullong(A.getSlotIndex(I)) == Index) {
        Slot = I;
        break;
      }
    }
    assert (Slot != ~0/*U*/) : "Couldn't find the index!";

    for (type$ptr<Attribute> I = $tryClone(A.begin(Slot)), /*P*/ E = $tryClone(A.end(Slot)); $noteq_ptr(I, E); I.$preInc()) {
      Attribute Attr = new Attribute(I.$star());
      if (Attr.isEnumAttribute() || Attr.isIntAttribute()) {
        if (Attrs.$at$Const(I./*->*/$star().getKindAsEnum().getValue())) {
          return true;
        }
      } else {
        assert (Attr.isStringAttribute()) : "Invalid attribute kind!";
        return TargetDepAttrs.find$Const(Attr.getKindAsString().$string()).$noteq(TargetDepAttrs.end$Const());
      }
    }

    return false;
  }


  /// \brief Return true if the builder has an alignment attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::hasAlignmentAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1500,
   FQN="llvm::AttrBuilder::hasAlignmentAttr", NM="_ZNK4llvm11AttrBuilder16hasAlignmentAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder16hasAlignmentAttrEv")
  //</editor-fold>
  public boolean hasAlignmentAttr() /*const*/ {
    return Alignment != $int2ullong(0);
  }


  /// \brief Retrieve the alignment attribute, if it exists.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 520,
   FQN="llvm::AttrBuilder::getAlignment", NM="_ZNK4llvm11AttrBuilder12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder12getAlignmentEv")
  //</editor-fold>
  public long/*uint64_t*/ getAlignment() /*const*/ {
    return Alignment;
  }


  /// \brief Retrieve the stack alignment attribute, if it exists.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::getStackAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 523,
   FQN="llvm::AttrBuilder::getStackAlignment", NM="_ZNK4llvm11AttrBuilder17getStackAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder17getStackAlignmentEv")
  //</editor-fold>
  public long/*uint64_t*/ getStackAlignment() /*const*/ {
    return StackAlignment;
  }


  /// \brief Retrieve the number of dereferenceable bytes, if the
  /// dereferenceable attribute exists (zero is returned otherwise).
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::getDereferenceableBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 527,
   FQN="llvm::AttrBuilder::getDereferenceableBytes", NM="_ZNK4llvm11AttrBuilder23getDereferenceableBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder23getDereferenceableBytesEv")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableBytes() /*const*/ {
    return DerefBytes;
  }


  /// \brief Retrieve the number of dereferenceable_or_null bytes, if the
  /// dereferenceable_or_null attribute exists (zero is returned otherwise).
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::getDereferenceableOrNullBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 531,
   FQN="llvm::AttrBuilder::getDereferenceableOrNullBytes", NM="_ZNK4llvm11AttrBuilder29getDereferenceableOrNullBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder29getDereferenceableOrNullBytesEv")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableOrNullBytes() /*const*/ {
    return DerefOrNullBytes;
  }


  /// Retrieve the allocsize args, if the allocsize attribute exists.  If it
  /// doesn't exist, pair(0, 0) is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::getAllocSizeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1345,
   FQN="llvm::AttrBuilder::getAllocSizeArgs", NM="_ZNK4llvm11AttrBuilder16getAllocSizeArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder16getAllocSizeArgsEv")
  //</editor-fold>
  public std.pairUIntType<OptionalUInt> getAllocSizeArgs() /*const*/ {
    return AttributesStatics.unpackAllocSizeArgs(AllocSizeArgs);
  }


  /// \brief This turns an int alignment (which must be a power of 2) into the
  /// form used internally in Attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::addAlignmentAttr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1349,
   FQN="llvm::AttrBuilder::addAlignmentAttr", NM="_ZN4llvm11AttrBuilder16addAlignmentAttrEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder16addAlignmentAttrEj")
  //</editor-fold>
  public AttrBuilder /*&*/ addAlignmentAttr(/*uint*/int Align) {
    if (Align == 0) {
      return /*Deref*/this;
    }
    assert (isPowerOf2_32(Align)) : "Alignment must be a power of two.";
    assert ($lesseq_uint(Align, 0x40000000)) : "Alignment too large.";

    Attrs.set(/*KEEP_ENUM*/Attribute.AttrKind.Alignment.getValue(), /*KEEP_BOOL*/true);
    Alignment = $uint2ulong(Align);
    return /*Deref*/this;
  }


  /// \brief This turns an int stack alignment (which must be a power of 2) into
  /// the form used internally in Attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::addStackAlignmentAttr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1360,
   FQN="llvm::AttrBuilder::addStackAlignmentAttr", NM="_ZN4llvm11AttrBuilder21addStackAlignmentAttrEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder21addStackAlignmentAttrEj")
  //</editor-fold>
  public AttrBuilder /*&*/ addStackAlignmentAttr(/*uint*/int Align) {
    // Default alignment, allow the target to define how to align it.
    if (Align == 0) {
      return /*Deref*/this;
    }
    assert (isPowerOf2_32(Align)) : "Alignment must be a power of two.";
    assert ($lesseq_uint(Align, 0x100)) : "Alignment too large.";

    Attrs.set(/*KEEP_ENUM*/Attribute.AttrKind.StackAlignment.getValue(), /*KEEP_BOOL*/true);
    StackAlignment = $uint2ulong(Align);
    return /*Deref*/this;
  }


  /// \brief This turns the number of dereferenceable bytes into the form used
  /// internally in Attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::addDereferenceableAttr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1372,
   FQN="llvm::AttrBuilder::addDereferenceableAttr", NM="_ZN4llvm11AttrBuilder22addDereferenceableAttrEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder22addDereferenceableAttrEy")
  //</editor-fold>
  public AttrBuilder /*&*/ addDereferenceableAttr(long/*uint64_t*/ Bytes) {
    if (Bytes == $int2ullong(0)) {
      return /*Deref*/this;
    }

    Attrs.set(/*KEEP_ENUM*/Attribute.AttrKind.Dereferenceable.getValue(), /*KEEP_BOOL*/true);
    DerefBytes = Bytes;
    return /*Deref*/this;
  }


  /// \brief This turns the number of dereferenceable_or_null bytes into the
  /// form used internally in Attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::addDereferenceableOrNullAttr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1380,
   FQN="llvm::AttrBuilder::addDereferenceableOrNullAttr", NM="_ZN4llvm11AttrBuilder28addDereferenceableOrNullAttrEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder28addDereferenceableOrNullAttrEy")
  //</editor-fold>
  public AttrBuilder /*&*/ addDereferenceableOrNullAttr(long/*uint64_t*/ Bytes) {
    if (Bytes == $int2ullong(0)) {
      return /*Deref*/this;
    }

    Attrs.set(/*KEEP_ENUM*/Attribute.AttrKind.DereferenceableOrNull.getValue(), /*KEEP_BOOL*/true);
    DerefOrNullBytes = Bytes;
    return /*Deref*/this;
  }

  /// This turns one (or two) ints into the form used internally in Attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::addAllocSizeAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1389,
   FQN="llvm::AttrBuilder::addAllocSizeAttr", NM="_ZN4llvm11AttrBuilder16addAllocSizeAttrEjRKNS_8OptionalIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder16addAllocSizeAttrEjRKNS_8OptionalIjEE")
  //</editor-fold>
  public AttrBuilder /*&*/ addAllocSizeAttr(/*uint*/int ElemSize,
                  final /*const*/OptionalUInt /*&*/ NumElems) {
    return addAllocSizeAttrFromRawRepr(AttributesStatics.packAllocSizeArgs(ElemSize, NumElems));
  }


  /// Add an allocsize attribute, using the representation returned by
  /// Attribute.getIntValue().
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::addAllocSizeAttrFromRawRepr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1394,
   FQN="llvm::AttrBuilder::addAllocSizeAttrFromRawRepr", NM="_ZN4llvm11AttrBuilder27addAllocSizeAttrFromRawReprEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder27addAllocSizeAttrFromRawReprEy")
  //</editor-fold>
  public AttrBuilder /*&*/ addAllocSizeAttrFromRawRepr(long/*uint64_t*/ RawArgs) {
    // (0, 0) is our "not present" value, so we need to check for it here.
    assert ((RawArgs != 0)) : "Invalid allocsize arguments -- given allocsize(0, 0)";

    Attrs.set(/*KEEP_ENUM*/Attribute.AttrKind.AllocSize.getValue(), /*KEEP_BOOL*/true);
    // Reuse existing machinery to store this as a single 64-bit integer so we can
    // save a few bytes over using a pair<unsigned, Optional<unsigned>>.
    AllocSizeArgs = RawArgs;
    return /*Deref*/this;
  }


  /// \brief Return true if the builder contains no target-independent
  /// attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 563,
   FQN="llvm::AttrBuilder::empty", NM="_ZNK4llvm11AttrBuilder5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Attrs.none();
  }


  // Iterators for target-dependent attributes.
  // JAVA: typedef std::pair<std::string, std::string> td_type
//  public final class td_type extends std.pairTypeType<std.string, std.string>{ };
  // JAVA: typedef std::map<std::string, std::string>::iterator td_iterator
//  public final class td_iterator extends std.mapTypeType.iterator</*const*/std.string, std.string>{ };
  // JAVA: typedef std::map<std::string, std::string>::const_iterator td_const_iterator
//  public final class td_const_iterator extends std.mapTypeType.iterator</*const*/std.string, std.string>{ };
  // JAVA: typedef llvm::iterator_range<td_iterator> td_range
//  public final class td_range extends iterator_range<std.pairTypeType</*const*/std.string, std.string> /*&*/>{ };
  // JAVA: typedef llvm::iterator_range<td_const_iterator> td_const_range
//  public final class td_const_range extends iterator_range</*const*/std.pairTypeType</*const*/std.string, std.string> /*&*/>{ };

  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::td_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 572,
   FQN="llvm::AttrBuilder::td_begin", NM="_ZN4llvm11AttrBuilder8td_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder8td_beginEv")
  //</editor-fold>
  public std.mapTypeType.iterator</*const*/std.string, std.string> td_begin() {
    return TargetDepAttrs.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::td_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 573,
   FQN="llvm::AttrBuilder::td_end", NM="_ZN4llvm11AttrBuilder6td_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder6td_endEv")
  //</editor-fold>
  public std.mapTypeType.iterator</*const*/std.string, std.string> td_end() {
    return TargetDepAttrs.end();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::td_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 575,
   FQN="llvm::AttrBuilder::td_begin", NM="_ZNK4llvm11AttrBuilder8td_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder8td_beginEv")
  //</editor-fold>
  public std.mapTypeType.iterator</*const*/std.string, std.string> td_begin$Const() /*const*/ {
    return TargetDepAttrs.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::td_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 576,
   FQN="llvm::AttrBuilder::td_end", NM="_ZNK4llvm11AttrBuilder6td_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder6td_endEv")
  //</editor-fold>
  public std.mapTypeType.iterator</*const*/std.string, std.string> td_end$Const() /*const*/ {
    return TargetDepAttrs.end$Const();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::td_attrs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 578,
   FQN="llvm::AttrBuilder::td_attrs", NM="_ZN4llvm11AttrBuilder8td_attrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder8td_attrsEv")
  //</editor-fold>
  public iterator_range<std.pairTypeType</*const*/std.string, std.string> /*&*/ > td_attrs() {
    return new iterator_range<std.pairTypeType</*const*/std.string, std.string> /*&*/>(td_begin(), td_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::td_attrs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 579,
   FQN="llvm::AttrBuilder::td_attrs", NM="_ZNK4llvm11AttrBuilder8td_attrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder8td_attrsEv")
  //</editor-fold>
  public iterator_range</*const*/ std.pairTypeType</*const*/std.string, std.string> /*&*/ > td_attrs$Const() /*const*/ {
    return new iterator_range<std.pairTypeType</*const*/std.string, std.string> /*&*/>(td_begin(), td_end());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::td_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 583,
   FQN="llvm::AttrBuilder::td_empty", NM="_ZNK4llvm11AttrBuilder8td_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm11AttrBuilder8td_emptyEv")
  //</editor-fold>
  public boolean td_empty() /*const*/ {
    return TargetDepAttrs.empty();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1504,
   FQN="llvm::AttrBuilder::operator==", NM="_ZN4llvm11AttrBuildereqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuildereqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ AttrBuilder /*&*/ B) {
    if (Attrs.$noteq(B.Attrs)) {
      return false;
    }

    for (std.mapTypeType.iterator</*const*/std.string, std.string> I = new std.mapTypeType.iterator</*const*/std.string, std.string>(TargetDepAttrs.begin()),
        E = new std.mapTypeType.iterator</*const*/std.string, std.string>(TargetDepAttrs.end()); I.$noteq(E); I.$preInc())  {
      if (B.TargetDepAttrs.find$Const(I.$arrow().first).$eq(B.TargetDepAttrs.end$Const())) {
        return false;
      }
    }

    return Alignment == B.Alignment && StackAlignment == B.StackAlignment
       && DerefBytes == B.DerefBytes;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 586,
   FQN="llvm::AttrBuilder::operator!=", NM="_ZN4llvm11AttrBuilderneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilderneERKS0_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ AttrBuilder /*&*/ B) {
    return !(/*Deref*/this.$eq(B));
  }


  // FIXME: Remove this in 4.0.

  /// \brief Add the raw value to the internal representation.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::addRawValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1517,
   FQN="llvm::AttrBuilder::addRawValue", NM="_ZN4llvm11AttrBuilder11addRawValueEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilder11addRawValueEy")
  //</editor-fold>
  public AttrBuilder /*&*/ addRawValue(long/*uint64_t*/ Val) {
    // FIXME: Remove this in 4.0.
    if (!(Val != 0)) {
      return /*Deref*/this;
    }

    for (Attribute.AttrKind I = Attribute.AttrKind.None; I != Attribute.AttrKind.EndAttrKinds;
         I = Attribute.AttrKind.valueOf(I.getValue() + 1)) {
      if (I == Attribute.AttrKind.Dereferenceable
         || I == Attribute.AttrKind.DereferenceableOrNull
         || I == Attribute.AttrKind.ArgMemOnly
         || I == Attribute.AttrKind.AllocSize) {
        continue;
      }
      {
        long/*uint64_t*/ A = (Val & AttributeImpl.getAttrMask(I));
        if ((A != 0)) {
          Attrs.set(/*KEEP_ENUM*/I.getValue(), /*KEEP_BOOL*/true);
          if (I == Attribute.AttrKind.Alignment) {
            Alignment = 1L/*ULL*/ << ((A >>> 16) - $int2ullong(1));
          } else if (I == Attribute.AttrKind.StackAlignment) {
            StackAlignment = 1L/*ULL*/ << ((A >>> 26) - $int2ullong(1));
          }
        }
      }
    }

    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::AttrBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 444,
   FQN="llvm::AttrBuilder::AttrBuilder", NM="_ZN4llvm11AttrBuilderC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilderC1EOS0_")
  //</editor-fold>
  public /*inline*/ AttrBuilder(JD$Move _dparam, final AttrBuilder /*&&*/$Prm0) {
    // : Attrs(static_cast<AttrBuilder &&>().Attrs), TargetDepAttrs(static_cast<AttrBuilder &&>().TargetDepAttrs), Alignment(static_cast<AttrBuilder &&>().Alignment), StackAlignment(static_cast<AttrBuilder &&>().StackAlignment), DerefBytes(static_cast<AttrBuilder &&>().DerefBytes), DerefOrNullBytes(static_cast<AttrBuilder &&>().DerefOrNullBytes), AllocSizeArgs(static_cast<AttrBuilder &&>().AllocSizeArgs)
    //START JInit
    this.Attrs = new std.bitset/*Attribute.AttrKind.EndAttrKinds.getValue()*/(JD$Move.INSTANCE, $Prm0.Attrs);
    this.TargetDepAttrs = new std.mapTypeType<std.string, std.string>(JD$Move.INSTANCE, $Prm0.TargetDepAttrs);
    this.Alignment = $Prm0.Alignment;
    this.StackAlignment = $Prm0.StackAlignment;
    this.DerefBytes = $Prm0.DerefBytes;
    this.DerefOrNullBytes = $Prm0.DerefOrNullBytes;
    this.AllocSizeArgs = $Prm0.AllocSizeArgs;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttrBuilder::~AttrBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 444,
   FQN="llvm::AttrBuilder::~AttrBuilder", NM="_ZN4llvm11AttrBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm11AttrBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    TargetDepAttrs.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "Attrs=" + Attrs // NOI18N
              + ", TargetDepAttrs=" + TargetDepAttrs // NOI18N
              + ", Alignment=" + Alignment // NOI18N
              + ", StackAlignment=" + StackAlignment // NOI18N
              + ", DerefBytes=" + DerefBytes // NOI18N
              + ", DerefOrNullBytes=" + DerefOrNullBytes // NOI18N
              + ", AllocSizeArgs=" + AllocSizeArgs; // NOI18N
  }
}
