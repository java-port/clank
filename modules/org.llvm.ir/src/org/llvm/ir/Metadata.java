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

import static org.clank.java.std.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$Move;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.literal_constants.$;
import static org.clank.support.literal_constants.$$LF;
import org.llvm.ir.Metadata.MetadataKind;
import org.llvm.ir.Metadata.StorageType;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;


/// \brief Root of the metadata hierarchy.
///
/// This is a root class for typeless data in the IR.
//<editor-fold defaultstate="collapsed" desc="llvm::Metadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 44,
 FQN="llvm::Metadata", NM="_ZN4llvm8MetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8MetadataE")
//</editor-fold>
public class Metadata implements Destructors.ClassWithDestructor {
  /*friend  class ReplaceableMetadataImpl*/
  
  /// \brief RTTI.
  private /*const*//*uchar*/byte SubclassID;
/*protected:*/
  /// \brief Active type of storage.
  //<editor-fold defaultstate="collapsed" desc="llvm::Metadata::StorageType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 52,
   FQN="llvm::Metadata::StorageType", NM="_ZN4llvm8Metadata11StorageTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Metadata11StorageTypeE")
  //</editor-fold>
  protected enum StorageType implements Native.NativeUIntEnum {
    Uniqued(0),
    Distinct(Uniqued.getValue() + 1),
    Temporary(Distinct.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static StorageType valueOf(int val) {
      StorageType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final StorageType[] VALUES;
      private static final StorageType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (StorageType kind : StorageType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new StorageType[min < 0 ? (1-min) : 0];
        VALUES = new StorageType[max >= 0 ? (1+max) : 0];
        for (StorageType kind : StorageType.values()) {
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
    private StorageType(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Storage flag for non-uniqued, otherwise unowned, metadata.
  protected /*uchar*/byte Storage;
  // TODO: expose remaining bits to subclasses.
  protected /*ushort*/char SubclassData16;
  protected /*uint*/int SubclassData32;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Metadata::MetadataKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 62,
   FQN="llvm::Metadata::MetadataKind", NM="_ZN4llvm8Metadata12MetadataKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Metadata12MetadataKindE")
  //</editor-fold>
  public enum MetadataKind implements Native.NativeUIntEnum {
    MDStringKind(0),
    ConstantAsMetadataKind(MDStringKind.getValue() + 1),
    LocalAsMetadataKind(ConstantAsMetadataKind.getValue() + 1),
    DistinctMDOperandPlaceholderKind(LocalAsMetadataKind.getValue() + 1),
    MDTupleKind(DistinctMDOperandPlaceholderKind.getValue() + 1),
    DILocationKind(MDTupleKind.getValue() + 1),
    DIExpressionKind(DILocationKind.getValue() + 1),
    GenericDINodeKind(DIExpressionKind.getValue() + 1),
    DISubrangeKind(GenericDINodeKind.getValue() + 1),
    DIEnumeratorKind(DISubrangeKind.getValue() + 1),
    DIBasicTypeKind(DIEnumeratorKind.getValue() + 1),
    DIDerivedTypeKind(DIBasicTypeKind.getValue() + 1),
    DICompositeTypeKind(DIDerivedTypeKind.getValue() + 1),
    DISubroutineTypeKind(DICompositeTypeKind.getValue() + 1),
    DIFileKind(DISubroutineTypeKind.getValue() + 1),
    DICompileUnitKind(DIFileKind.getValue() + 1),
    DISubprogramKind(DICompileUnitKind.getValue() + 1),
    DILexicalBlockKind(DISubprogramKind.getValue() + 1),
    DILexicalBlockFileKind(DILexicalBlockKind.getValue() + 1),
    DINamespaceKind(DILexicalBlockFileKind.getValue() + 1),
    DIModuleKind(DINamespaceKind.getValue() + 1),
    DITemplateTypeParameterKind(DIModuleKind.getValue() + 1),
    DITemplateValueParameterKind(DITemplateTypeParameterKind.getValue() + 1),
    DIGlobalVariableKind(DITemplateValueParameterKind.getValue() + 1),
    DILocalVariableKind(DIGlobalVariableKind.getValue() + 1),
    DIObjCPropertyKind(DILocalVariableKind.getValue() + 1),
    DIImportedEntityKind(DIObjCPropertyKind.getValue() + 1),
    DIMacroKind(DIImportedEntityKind.getValue() + 1),
    DIMacroFileKind(DIMacroKind.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static MetadataKind valueOf(int val) {
      MetadataKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final MetadataKind[] VALUES;
      private static final MetadataKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (MetadataKind kind : MetadataKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new MetadataKind[min < 0 ? (1-min) : 0];
        VALUES = new MetadataKind[max >= 0 ? (1+max) : 0];
        for (MetadataKind kind : MetadataKind.values()) {
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
    private MetadataKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Metadata::Metadata">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 68,
   FQN="llvm::Metadata::Metadata", NM="_ZN4llvm8MetadataC1EjNS0_11StorageTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8MetadataC1EjNS0_11StorageTypeE")
  //</editor-fold>
  protected Metadata(/*uint*/int ID, StorageType Storage) {
    // : SubclassID(ID), Storage(Storage), SubclassData16(0), SubclassData32(0) 
    //START JInit
    this.SubclassID = $uint2uchar(ID);
    this.Storage = (byte)Storage.getValue();
    this.SubclassData16 = $int2ushort(0);
    this.SubclassData32 = 0;
    //END JInit
    static_assert(sizeof(/*Deref*/this) == 4, $("Metdata fields poorly packed"));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Metadata::~Metadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 72,
   FQN="llvm::Metadata::~Metadata", NM="_ZN4llvm8MetadataD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8MetadataD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }


  
  /// \brief Default handling of a changed operand, which asserts.
  ///
  /// If subclasses pass themselves in as owners to a tracking node reference,
  /// they must provide an implementation of this method.
  //<editor-fold defaultstate="collapsed" desc="llvm::Metadata::handleChangedOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 78,
   FQN="llvm::Metadata::handleChangedOperand", NM="_ZN4llvm8Metadata20handleChangedOperandEPvPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm8Metadata20handleChangedOperandEPvPS0_")
  //</editor-fold>
  protected void handleChangedOperand(Object/*void P*/ $Prm0, Metadata /*P*/ $Prm1) {
    throw new llvm_unreachable("Unimplemented in Metadata subclass");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Metadata::getMetadataID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 83,
   FQN="llvm::Metadata::getMetadataID", NM="_ZNK4llvm8Metadata13getMetadataIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Metadata13getMetadataIDEv")
  //</editor-fold>
  public /*uint*/int getMetadataID() /*const*/ {
    return $uchar2uint(SubclassID);
  }

  
  /// \brief User-friendly dump.
  ///
  /// If \c M is provided, metadata nodes will be numbered canonically;
  /// otherwise, pointer addresses are substituted.
  ///
  /// Note: this uses an explicit overload instead of default arguments so that
  /// the nullptr version is easy to call from a debugger.
  ///
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::Metadata::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3556,
   FQN="llvm::Metadata::dump", NM="_ZNK4llvm8Metadata4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Metadata4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dump((/*const*/ Module /*P*/ )null);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Metadata::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3559,
   FQN="llvm::Metadata::dump", NM="_ZNK4llvm8Metadata4dumpEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Metadata4dumpEPKNS_6ModuleE")
  //</editor-fold>
  public void dump(/*const*/ Module /*P*/ M) /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs(), M, /*IsForDebug=*/ true);
    dbgs().$out_char($$LF);
  }

  /// @}
  
  /// \brief Print.
  ///
  /// Prints definition of \c this.
  ///
  /// If \c M is provided, metadata nodes will be numbered canonically;
  /// otherwise, pointer addresses are substituted.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::Metadata::print">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3522,
   FQN="llvm::Metadata::print", NM="_ZNK4llvm8Metadata5printERNS_11raw_ostreamEPKNS_6ModuleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Metadata5printERNS_11raw_ostreamEPKNS_6ModuleEb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    print(OS, (/*const*/ Module /*P*/ )null, 
       false);
  }
  public void print(final raw_ostream /*&*/ OS, /*const*/ Module /*P*/ M/*= null*/) /*const*/ {
    print(OS, M, 
       false);
  }
  public void print(final raw_ostream /*&*/ OS, /*const*/ Module /*P*/ M/*= null*/, 
       boolean $Prm2/*= false*//*IsForDebug*/) /*const*/ {
    ModuleSlotTracker MST = null;
    try {
      MST/*J*/= new ModuleSlotTracker(M, isa_MDNode(this));
      AsmWriterStatics.printMetadataImpl(OS, /*Deref*/this, MST, M, /* OnlyAsOperand */ false);
    } finally {
      if (MST != null) { MST.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Metadata::print">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3528,
   FQN="llvm::Metadata::print", NM="_ZNK4llvm8Metadata5printERNS_11raw_ostreamERNS_17ModuleSlotTrackerEPKNS_6ModuleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Metadata5printERNS_11raw_ostreamERNS_17ModuleSlotTrackerEPKNS_6ModuleEb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS, final ModuleSlotTracker /*&*/ MST) /*const*/ {
    print(OS, MST, 
       (/*const*/ Module /*P*/ )null, false);
  }
  public void print(final raw_ostream /*&*/ OS, final ModuleSlotTracker /*&*/ MST, 
       /*const*/ Module /*P*/ M/*= null*/) /*const*/ {
    print(OS, MST, 
       M, false);
  }
  public void print(final raw_ostream /*&*/ OS, final ModuleSlotTracker /*&*/ MST, 
       /*const*/ Module /*P*/ M/*= null*/, boolean $Prm3/*= false*//*IsForDebug*/) /*const*/ {
    AsmWriterStatics.printMetadataImpl(OS, /*Deref*/this, MST, M, /* OnlyAsOperand */ false);
  }

  /// @}
  
  /// \brief Print as operand.
  ///
  /// Prints reference of \c this.
  ///
  /// If \c M is provided, metadata nodes will be numbered canonically;
  /// otherwise, pointer addresses are substituted.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::Metadata::printAsOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3512,
   FQN="llvm::Metadata::printAsOperand", NM="_ZNK4llvm8Metadata14printAsOperandERNS_11raw_ostreamEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Metadata14printAsOperandERNS_11raw_ostreamEPKNS_6ModuleE")
  //</editor-fold>
  public void printAsOperand(final raw_ostream /*&*/ OS) /*const*/ {
    printAsOperand(OS, (/*const*/ Module /*P*/ )null);
  }
  public void printAsOperand(final raw_ostream /*&*/ OS, /*const*/ Module /*P*/ M/*= null*/) /*const*/ {
    ModuleSlotTracker MST = null;
    try {
      MST/*J*/= new ModuleSlotTracker(M, isa_MDNode(this));
      AsmWriterStatics.printMetadataImpl(OS, /*Deref*/this, MST, M, /* OnlyAsOperand */ true);
    } finally {
      if (MST != null) { MST.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Metadata::printAsOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3517,
   FQN="llvm::Metadata::printAsOperand", NM="_ZNK4llvm8Metadata14printAsOperandERNS_11raw_ostreamERNS_17ModuleSlotTrackerEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm8Metadata14printAsOperandERNS_11raw_ostreamERNS_17ModuleSlotTrackerEPKNS_6ModuleE")
  //</editor-fold>
  public void printAsOperand(final raw_ostream /*&*/ OS, final ModuleSlotTracker /*&*/ MST) /*const*/ {
    printAsOperand(OS, MST, 
                (/*const*/ Module /*P*/ )null);
  }
  public void printAsOperand(final raw_ostream /*&*/ OS, final ModuleSlotTracker /*&*/ MST, 
                /*const*/ Module /*P*/ M/*= null*/) /*const*/ {
    AsmWriterStatics.printMetadataImpl(OS, /*Deref*/this, MST, M, /* OnlyAsOperand */ true);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected Metadata() {
  }
  
  protected Metadata(Metadata $Prm0) {
    this.Storage = $Prm0.Storage;
    this.SubclassID = $Prm0.SubclassID;
    this.SubclassData16 = $Prm0.SubclassData16;
    this.SubclassData32 = $Prm0.SubclassData32;
  }
  
  protected Metadata(JD$Move _dparam, Metadata $Prm0) {
    this.Storage = $Prm0.Storage;
    this.SubclassID = $Prm0.SubclassID;
    this.SubclassData16 = $Prm0.SubclassData16;
    this.SubclassData32 = $Prm0.SubclassData32;
  }

  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "SubclassID=" + $uchar2uint(SubclassID) // NOI18N
              + ", Storage=" + $uchar2uint(Storage) // NOI18N
              + ", SubclassData16=" + $ushort2uint(SubclassData16) // NOI18N
              + ", SubclassData32=" + SubclassData32; // NOI18N
  }
/// @}
}
