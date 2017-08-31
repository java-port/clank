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
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;

//<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 27,
 FQN="llvm::GlobalObject", NM="_ZN4llvm12GlobalObjectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm12GlobalObjectE")
//</editor-fold>
public abstract class GlobalObject extends /*public*/ GlobalValue implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::GlobalObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 28,
   FQN="llvm::GlobalObject::GlobalObject", NM="_ZN4llvm12GlobalObjectC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm12GlobalObjectC1ERKS0_")
  //</editor-fold>
  protected/*private*/ GlobalObject(final /*const*/ GlobalObject /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::GlobalObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 31,
   FQN="llvm::GlobalObject::GlobalObject", NM="_ZN4llvm12GlobalObjectC1EPNS_4TypeENS_5Value7ValueTyEPNS_3UseEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm12GlobalObjectC1EPNS_4TypeENS_5Value7ValueTyEPNS_3UseEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEj")
  //</editor-fold>
  protected GlobalObject(Type /*P*/ Ty, Value.ValueTy VTy, type$ptr<Use /*P*/> Ops, /*uint*/int NumOps, 
      GlobalValue.LinkageTypes Linkage, final /*const*/ Twine /*&*/ Name) {
    this(Ty, VTy, Ops, NumOps, 
      Linkage, Name, 
      0);
  }
  protected GlobalObject(Type /*P*/ Ty, Value.ValueTy VTy, type$ptr<Use /*P*/> Ops, /*uint*/int NumOps, 
      GlobalValue.LinkageTypes Linkage, final /*const*/ Twine /*&*/ Name, 
      /*uint*/int AddressSpace/*= 0*/) {
    // : GlobalValue(Ty, VTy, Ops, NumOps, Linkage, Name, AddressSpace), Section(), ObjComdat(null) 
    //START JInit
    super(Ty, VTy, Ops, NumOps, Linkage, Name, AddressSpace);
    this.Section = new std.string();
    this.ObjComdat = null;
    //END JInit
    setGlobalValueSubClassData(0);
  }

  
  protected std.string Section; // Section to emit this into, empty means default
  protected Comdat /*P*/ ObjComdat;
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 41,
   FQN="llvm::GlobalObject::(anonymous)", NM="_ZN4llvm12GlobalObjectE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm12GlobalObjectE_Unnamed_enum")
  //</editor-fold>
  protected enum Unnamed_enum implements Native.NativeUIntEnum {
    LastAlignmentBit(4),
    HasMetadataHashEntryBit(LastAlignmentBit.getValue() + 1),
    
    GlobalObjectBits(HasMetadataHashEntryBit.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
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
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  protected static /*const*//*uint*/int GlobalObjectSubClassDataBits = GlobalValueSubClassDataBits - Unnamed_enum.GlobalObjectBits.getValue();
/*private:*/
  private static /*const*//*uint*/int AlignmentBits = Unnamed_enum.LastAlignmentBit.getValue() + 1;
  private static /*const*//*uint*/int AlignmentMask = (1 << AlignmentBits) - 1;
  private static /*const*//*uint*/int GlobalObjectMask = (1 << Unnamed_enum.GlobalObjectBits.getValue()) - 1;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 56,
   FQN="llvm::GlobalObject::getAlignment", NM="_ZNK4llvm12GlobalObject12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm12GlobalObject12getAlignmentEv")
  //</editor-fold>
  public /*uint*/int getAlignment() /*const*/ {
    /*uint*/int Data = getGlobalValueSubClassData();
    /*uint*/int AlignmentData = Data & AlignmentMask;
    return (1/*U*/ << AlignmentData) >>> 1;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::setAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 72,
   FQN="llvm::GlobalObject::setAlignment", NM="_ZN4llvm12GlobalObject12setAlignmentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm12GlobalObject12setAlignmentEj")
  //</editor-fold>
  public void setAlignment(/*uint*/int Align) {
    assert ((Align & (Align - 1)) == 0) : "Alignment is not a power of 2!";
    assert ($lesseq_uint(Align, MaximumAlignment)) : "Alignment is greater than MaximumAlignment!";
    /*uint*/int AlignmentData = Log2_32(Align) + 1;
    /*uint*/int OldData = getGlobalValueSubClassData();
    setGlobalValueSubClassData((OldData & ~AlignmentMask) | AlignmentData);
    assert (getAlignment() == Align) : "Alignment representation error!";
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::getGlobalObjectSubClassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 82,
   FQN="llvm::GlobalObject::getGlobalObjectSubClassData", NM="_ZNK4llvm12GlobalObject27getGlobalObjectSubClassDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm12GlobalObject27getGlobalObjectSubClassDataEv")
  //</editor-fold>
  public /*uint*/int getGlobalObjectSubClassData() /*const*/ {
    /*uint*/int ValueData = getGlobalValueSubClassData();
    return ValueData >>> Unnamed_enum.GlobalObjectBits.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::setGlobalObjectSubClassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 87,
   FQN="llvm::GlobalObject::setGlobalObjectSubClassData", NM="_ZN4llvm12GlobalObject27setGlobalObjectSubClassDataEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm12GlobalObject27setGlobalObjectSubClassDataEj")
  //</editor-fold>
  public void setGlobalObjectSubClassData(/*uint*/int Val) {
    /*uint*/int OldData = getGlobalValueSubClassData();
    setGlobalValueSubClassData((OldData & GlobalObjectMask)
           | (Val << Unnamed_enum.GlobalObjectBits.getValue()));
    assert (getGlobalObjectSubClassData() == Val) : "representation error";
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::hasSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 66,
   FQN="llvm::GlobalObject::hasSection", NM="_ZNK4llvm12GlobalObject10hasSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm12GlobalObject10hasSectionEv")
  //</editor-fold>
  public boolean hasSection() /*const*/ {
    return !getSection().empty();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::getSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 67,
   FQN="llvm::GlobalObject::getSection", NM="_ZNK4llvm12GlobalObject10getSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm12GlobalObject10getSectionEv")
  //</editor-fold>
  public StringRef getSection() /*const*/ {
    return new StringRef(Section);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::setSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 154,
   FQN="llvm::GlobalObject::setSection", NM="_ZN4llvm12GlobalObject10setSectionENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm12GlobalObject10setSectionENS_9StringRefE")
  //</editor-fold>
  public void setSection(StringRef S) {
    Section.$assignMove(S.$string());
    
    // The C api requires this to be null terminated.
    Section.c_str();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::hasComdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 70,
   FQN="llvm::GlobalObject::hasComdat", NM="_ZNK4llvm12GlobalObject9hasComdatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm12GlobalObject9hasComdatEv")
  //</editor-fold>
  public boolean hasComdat() /*const*/ {
    return getComdat$Const() != null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::getComdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 71,
   FQN="llvm::GlobalObject::getComdat", NM="_ZNK4llvm12GlobalObject9getComdatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm12GlobalObject9getComdatEv")
  //</editor-fold>
  public /*const*/ Comdat /*P*/ getComdat$Const() /*const*/ {
    return ObjComdat;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::getComdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 72,
   FQN="llvm::GlobalObject::getComdat", NM="_ZN4llvm12GlobalObject9getComdatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm12GlobalObject9getComdatEv")
  //</editor-fold>
  public Comdat /*P*/ getComdat() {
    return ObjComdat;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::setComdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 73,
   FQN="llvm::GlobalObject::setComdat", NM="_ZN4llvm12GlobalObject9setComdatEPNS_6ComdatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm12GlobalObject9setComdatEPNS_6ComdatE")
  //</editor-fold>
  public void setComdat(Comdat /*P*/ C) {
    ObjComdat = C;
  }

  
  /// Check if this has any metadata.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::hasMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 76,
   FQN="llvm::GlobalObject::hasMetadata", NM="_ZNK4llvm12GlobalObject11hasMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm12GlobalObject11hasMetadataEv")
  //</editor-fold>
  public boolean hasMetadata() /*const*/ {
    return hasMetadataHashEntry();
  }

  
  /// Get the current metadata attachments for the given kind, if any.
  ///
  /// These functions require that the function have at most a single attachment
  /// of the given kind, and return \c nullptr if such an attachment is missing.
  /// @{
  
  /// Get the current metadata attachments for the given kind, if any.
  ///
  /// These functions require that the function have at most a single attachment
  /// of the given kind, and return \c nullptr if such an attachment is missing.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::getMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1408,
   FQN="llvm::GlobalObject::getMetadata", NM="_ZNK4llvm12GlobalObject11getMetadataEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm12GlobalObject11getMetadataEj")
  //</editor-fold>
  public MDNode /*P*/ getMetadata(/*uint*/int KindID) /*const*/ {
    SmallVector<MDNode /*P*/ > MDs/*J*/= new SmallVector<MDNode /*P*/ >(1, (MDNode /*P*/ )null);
    getMetadata(KindID, MDs);
    assert ($lesseq_uint(MDs.size(), 1)) : "Expected at most one metadata attachment";
    if (MDs.empty()) {
      return null;
    }
    return MDs.$at(0);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::getMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1417,
   FQN="llvm::GlobalObject::getMetadata", NM="_ZNK4llvm12GlobalObject11getMetadataENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm12GlobalObject11getMetadataENS_9StringRefE")
  //</editor-fold>
  public MDNode /*P*/ getMetadata(StringRef Kind) /*const*/ {
    return getMetadata(getContext().getMDKindID(new StringRef(Kind)));
  }


  /// @}
  
  /// Appends all attachments with the given ID to \c MDs in insertion order.
  /// If the global has no attachments with the given ID, or if ID is invalid,
  /// leaves MDs unchanged.
  /// @{
  /// @}
  
  /// Appends all attachments with the given ID to \c MDs in insertion order.
  /// If the global has no attachments with the given ID, or if ID is invalid,
  /// leaves MDs unchanged.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::getMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1347,
   FQN="llvm::GlobalObject::getMetadata", NM="_ZNK4llvm12GlobalObject11getMetadataEjRNS_15SmallVectorImplIPNS_6MDNodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm12GlobalObject11getMetadataEjRNS_15SmallVectorImplIPNS_6MDNodeEEE")
  //</editor-fold>
  public void getMetadata(/*uint*/int KindID, 
             final SmallVectorImpl<MDNode /*P*/ > /*&*/ MDs) /*const*/ {
    if (hasMetadata()) {
      getContext().pImpl.GlobalObjectMetadata.$at_T1$RR(this).get(KindID, MDs);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::getMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1353,
   FQN="llvm::GlobalObject::getMetadata", NM="_ZNK4llvm12GlobalObject11getMetadataENS_9StringRefERNS_15SmallVectorImplIPNS_6MDNodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm12GlobalObject11getMetadataENS_9StringRefERNS_15SmallVectorImplIPNS_6MDNodeEEE")
  //</editor-fold>
  public void getMetadata(StringRef Kind, 
             final SmallVectorImpl<MDNode /*P*/ > /*&*/ MDs) /*const*/ {
    if (hasMetadata()) {
      getMetadata(getContext().getMDKindID(new StringRef(Kind)), MDs);
    }
  }


  /// @}
  
  /// Set a particular kind of metadata attachment.
  ///
  /// Sets the given attachment to \c MD, erasing it if \c MD is \c nullptr or
  /// replacing it if it already exists.
  /// @{
  /// @}
  
  /// Set a particular kind of metadata attachment.
  ///
  /// Sets the given attachment to \c MD, erasing it if \c MD is \c nullptr or
  /// replacing it if it already exists.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::setMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1398,
   FQN="llvm::GlobalObject::setMetadata", NM="_ZN4llvm12GlobalObject11setMetadataEjPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm12GlobalObject11setMetadataEjPNS_6MDNodeE")
  //</editor-fold>
  public void setMetadata(/*uint*/int KindID, MDNode /*P*/ N) {
    eraseMetadata(KindID);
    if ((N != null)) {
      addMetadata(KindID, $Deref(N));
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::setMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1404,
   FQN="llvm::GlobalObject::setMetadata", NM="_ZN4llvm12GlobalObject11setMetadataENS_9StringRefEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm12GlobalObject11setMetadataENS_9StringRefEPNS_6MDNodeE")
  //</editor-fold>
  public void setMetadata(StringRef Kind, MDNode /*P*/ N) {
    setMetadata(getContext().getMDKindID(new StringRef(Kind)), N);
  }


  /// @}
  
  /// Add a metadata attachment.
  /// @{
  /// @}
  
  /// Add a metadata attachment.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::addMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1359,
   FQN="llvm::GlobalObject::addMetadata", NM="_ZN4llvm12GlobalObject11addMetadataEjRNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm12GlobalObject11addMetadataEjRNS_6MDNodeE")
  //</editor-fold>
  public void addMetadata(/*uint*/int KindID, final MDNode /*&*/ MD) {
    if (!hasMetadata()) {
      setHasMetadataHashEntry(true);
    }
    
    getContext().pImpl.GlobalObjectMetadata.$at_T1$RR(this).insert(KindID, MD);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::addMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1366,
   FQN="llvm::GlobalObject::addMetadata", NM="_ZN4llvm12GlobalObject11addMetadataENS_9StringRefERNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm12GlobalObject11addMetadataENS_9StringRefERNS_6MDNodeE")
  //</editor-fold>
  public void addMetadata(StringRef Kind, final MDNode /*&*/ MD) {
    addMetadata(getContext().getMDKindID(new StringRef(Kind)), MD);
  }


  /// @}
  
  /// Appends all attachments for the global to \c MDs, sorting by attachment
  /// ID. Attachments with the same ID appear in insertion order.
  /// @}
  
  /// Appends all attachments for the global to \c MDs, sorting by attachment
  /// ID. Attachments with the same ID appear in insertion order.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::getAllMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1381,
   FQN="llvm::GlobalObject::getAllMetadata", NM="_ZNK4llvm12GlobalObject14getAllMetadataERNS_15SmallVectorImplISt4pairIjPNS_6MDNodeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm12GlobalObject14getAllMetadataERNS_15SmallVectorImplISt4pairIjPNS_6MDNodeEEEE")
  //</editor-fold>
  public void getAllMetadata(final SmallVectorImpl<std.pairUIntPtr<MDNode /*P*/ > > /*&*/ MDs) /*const*/ {
    MDs.clear();
    if (!hasMetadata()) {
      return;
    }
    
    getContext().pImpl.GlobalObjectMetadata.$at_T1$RR(this).getAll(MDs);
  }


  
  /// Erase all metadata attachments with the given kind.
  
  /// Erase all metadata attachments with the given kind.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::eraseMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1370,
   FQN="llvm::GlobalObject::eraseMetadata", NM="_ZN4llvm12GlobalObject13eraseMetadataEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm12GlobalObject13eraseMetadataEj")
  //</editor-fold>
  public void eraseMetadata(/*uint*/int KindID) {
    // Nothing to unset.
    if (!hasMetadata()) {
      return;
    }
    
    final MDGlobalAttachmentMap /*&*/ Store = getContext().pImpl.GlobalObjectMetadata.$at_T1$RR(this);
    Store.erase(KindID);
    if (Store.empty()) {
      clearMetadata();
    }
  }


  
  /// Copy metadata from Src, adjusting offsets by Offset.
  
  /// Copy metadata from Src, adjusting offsets by Offset.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::copyMetadata">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1421,
   FQN="llvm::GlobalObject::copyMetadata", NM="_ZN4llvm12GlobalObject12copyMetadataEPKS0_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm12GlobalObject12copyMetadataEPKS0_j")
  //</editor-fold>
  public void copyMetadata(/*const*/ GlobalObject /*P*/ Other, /*uint*/int Offset) {
    SmallVector<std.pairUIntPtr<MDNode /*P*/ >> MDs/*J*/= new SmallVector<std.pairUIntPtr<MDNode /*P*/ >>(8, new std.pairUIntPtr<MDNode /*P*/ >());
    Other.getAllMetadata(MDs);
    for (final std.pairUIntPtr<MDNode /*P*/ > /*&*/ MD : MDs) {
      MDNode /*P*/ MD$Second = (MDNode/*P*/) MD.second;
      // We need to adjust the type metadata offset.
      if (Offset != 0 && MD.first == LLVMContext.Unnamed_enum.MD_type.getValue()) {
        ConstantInt /*P*/ OffsetConst = cast_ConstantInt(cast_ConstantAsMetadata(MD$Second.getOperand(0)).getValue());
        Metadata /*P*/ TypeId = MD$Second.getOperand(1).$Metadata$P();
        ConstantAsMetadata /*P*/ NewOffsetMD = ConstantAsMetadata.get(ConstantInt.get(OffsetConst.getType(), OffsetConst.getValue().$add($uint2ulong(Offset))));
        addMetadata(LLVMContext.Unnamed_enum.MD_type.getValue(), 
            $Deref(MDNode.get(getContext(), /*{ */new ArrayRef<Metadata /*P*/ >(new Metadata /*P*/ /*const*/ [/*2*/] {NewOffsetMD, TypeId}, true)/* }*/)));
        continue;
      }
      addMetadata(MD.first, $Deref(MD$Second));
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::addTypeMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1440,
   FQN="llvm::GlobalObject::addTypeMetadata", NM="_ZN4llvm12GlobalObject15addTypeMetadataEjPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm12GlobalObject15addTypeMetadataEjPNS_8MetadataE")
  //</editor-fold>
  public void addTypeMetadata(/*uint*/int Offset, Metadata /*P*/ TypeID) {
    addMetadata(LLVMContext.Unnamed_enum.MD_type.getValue(), 
        $Deref(MDTuple.get(getContext(), 
            /*{ */new ArrayRef<Metadata /*P*/ >(new Metadata /*P*/ /*const*/ [/*2*/] {
                  ConstantAsMetadata.get(ConstantInt.get(Type.getInt64Ty(getContext()), $uint2ulong(Offset))), 
                  TypeID}, true)/* }*/)));
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::copyAttributesFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 94,
   FQN="llvm::GlobalObject::copyAttributesFrom", NM="_ZN4llvm12GlobalObject18copyAttributesFromEPKNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm12GlobalObject18copyAttributesFromEPKNS_11GlobalValueE")
  //</editor-fold>
  @Override public void copyAttributesFrom(/*const*/ GlobalValue /*P*/ Src)/* override*/ {
    super.copyAttributesFrom(Src);
    {
      /*const*/ GlobalObject /*P*/ GV = dyn_cast_GlobalObject(Src);
      if ((GV != null)) {
        setAlignment(GV.getAlignment());
        setSection(GV.getSection());
      }
    }
  }

  
  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 126,
   FQN="llvm::GlobalObject::classof", NM="_ZN4llvm12GlobalObject7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm12GlobalObject7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == Value.ValueTy.FunctionVal.getValue()
       || V.getValueID() == Value.ValueTy.GlobalVariableVal.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::clearMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1391,
   FQN="llvm::GlobalObject::clearMetadata", NM="_ZN4llvm12GlobalObject13clearMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm12GlobalObject13clearMetadataEv")
  //</editor-fold>
  public void clearMetadata() {
    if (!hasMetadata()) {
      return;
    }
    getContext().pImpl.GlobalObjectMetadata.erase(this);
    setHasMetadataHashEntry(false);
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::hasMetadataHashEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 134,
   FQN="llvm::GlobalObject::hasMetadataHashEntry", NM="_ZNK4llvm12GlobalObject20hasMetadataHashEntryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm12GlobalObject20hasMetadataHashEntryEv")
  //</editor-fold>
  private boolean hasMetadataHashEntry() /*const*/ {
    return ((getGlobalValueSubClassData() & (1 << Unnamed_enum.HasMetadataHashEntryBit.getValue())) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::setHasMetadataHashEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 137,
   FQN="llvm::GlobalObject::setHasMetadataHashEntry", NM="_ZN4llvm12GlobalObject23setHasMetadataHashEntryEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm12GlobalObject23setHasMetadataHashEntryEb")
  //</editor-fold>
  private void setHasMetadataHashEntry(boolean HasEntry) {
    /*uint*/int Mask = 1 << Unnamed_enum.HasMetadataHashEntryBit.getValue();
    setGlobalValueSubClassData((~Mask & getGlobalValueSubClassData())
           | (HasEntry ? Mask : 0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalObject::~GlobalObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalObject.h", line = 27,
   FQN="llvm::GlobalObject::~GlobalObject", NM="_ZN4llvm12GlobalObjectD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm12GlobalObjectD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Section.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected GlobalObject() { /* for sentinels */ }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Section=" + Section // NOI18N
              + ", ObjComdat=" + ObjComdat // NOI18N
              + super.toString(); // NOI18N
  }
}
