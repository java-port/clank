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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.support.AdtsupportLlvmGlobals.MD5Hash;

//<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 36,
 FQN="llvm::GlobalValue", NM="_ZN4llvm11GlobalValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValueE")
//</editor-fold>
public abstract class GlobalValue extends /*public*/ Constant implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::GlobalValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 37,
   FQN="llvm::GlobalValue::GlobalValue", NM="_ZN4llvm11GlobalValueC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValueC1ERKS0_")
  //</editor-fold>
  protected/*private*/ GlobalValue(final /*const*/ GlobalValue /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

/*public:*/
  /// @brief An enumeration for the kinds of linkage for global values.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::LinkageTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 40,
   FQN="llvm::GlobalValue::LinkageTypes", NM="_ZN4llvm11GlobalValue12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue12LinkageTypesE")
  //</editor-fold>
  public enum LinkageTypes implements Native.NativeUIntEnum {
    ExternalLinkage(0), ///< Externally visible function
    AvailableExternallyLinkage(ExternalLinkage.getValue() + 1), ///< Available for inspection, not emission.
    LinkOnceAnyLinkage(AvailableExternallyLinkage.getValue() + 1), ///< Keep one copy of function when linking (inline)
    LinkOnceODRLinkage(LinkOnceAnyLinkage.getValue() + 1), ///< Same, but only replaced by something equivalent.
    WeakAnyLinkage(LinkOnceODRLinkage.getValue() + 1), ///< Keep one copy of named function when linking (weak)
    WeakODRLinkage(WeakAnyLinkage.getValue() + 1), ///< Same, but only replaced by something equivalent.
    AppendingLinkage(WeakODRLinkage.getValue() + 1), ///< Special purpose, only applies to global arrays
    InternalLinkage(AppendingLinkage.getValue() + 1), ///< Rename collisions when linking (static functions).
    PrivateLinkage(InternalLinkage.getValue() + 1), ///< Like Internal, but omit from symbol table.
    ExternalWeakLinkage(PrivateLinkage.getValue() + 1), ///< ExternalWeak linkage description.
    CommonLinkage(ExternalWeakLinkage.getValue() + 1); ///< Tentative definitions.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LinkageTypes valueOf(int val) {
      LinkageTypes out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LinkageTypes[] VALUES;
      private static final LinkageTypes[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LinkageTypes kind : LinkageTypes.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LinkageTypes[min < 0 ? (1-min) : 0];
        VALUES = new LinkageTypes[max >= 0 ? (1+max) : 0];
        for (LinkageTypes kind : LinkageTypes.values()) {
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
    private LinkageTypes(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// @brief An enumeration for the kinds of visibility of global values.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::VisibilityTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 55,
   FQN="llvm::GlobalValue::VisibilityTypes", NM="_ZN4llvm11GlobalValue15VisibilityTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue15VisibilityTypesE")
  //</editor-fold>
  public enum VisibilityTypes implements Native.NativeUIntEnum {
    DefaultVisibility(0), ///< The GV is visible
    HiddenVisibility(DefaultVisibility.getValue() + 1), ///< The GV is hidden
    ProtectedVisibility(HiddenVisibility.getValue() + 1); ///< The GV is protected

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static VisibilityTypes valueOf(int val) {
      VisibilityTypes out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final VisibilityTypes[] VALUES;
      private static final VisibilityTypes[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (VisibilityTypes kind : VisibilityTypes.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new VisibilityTypes[min < 0 ? (1-min) : 0];
        VALUES = new VisibilityTypes[max >= 0 ? (1+max) : 0];
        for (VisibilityTypes kind : VisibilityTypes.values()) {
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
    private VisibilityTypes(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// @brief Storage classes of global values for PE targets.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::DLLStorageClassTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 62,
   FQN="llvm::GlobalValue::DLLStorageClassTypes", NM="_ZN4llvm11GlobalValue20DLLStorageClassTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue20DLLStorageClassTypesE")
  //</editor-fold>
  public enum DLLStorageClassTypes implements Native.NativeUIntEnum {
    DefaultStorageClass(0),
    DLLImportStorageClass(1), ///< Function to be imported from DLL
    DLLExportStorageClass(2); ///< Function to be accessible from DLL.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DLLStorageClassTypes valueOf(int val) {
      DLLStorageClassTypes out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DLLStorageClassTypes[] VALUES;
      private static final DLLStorageClassTypes[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DLLStorageClassTypes kind : DLLStorageClassTypes.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DLLStorageClassTypes[min < 0 ? (1-min) : 0];
        VALUES = new DLLStorageClassTypes[max >= 0 ? (1+max) : 0];
        for (DLLStorageClassTypes kind : DLLStorageClassTypes.values()) {
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
    private DLLStorageClassTypes(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::GlobalValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 69,
   FQN="llvm::GlobalValue::GlobalValue", NM="_ZN4llvm11GlobalValueC1EPNS_4TypeENS_5Value7ValueTyEPNS_3UseEjNS0_12LinkageTypesERKNS_5TwineEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValueC1EPNS_4TypeENS_5Value7ValueTyEPNS_3UseEjNS0_12LinkageTypesERKNS_5TwineEj")
  //</editor-fold>
  protected GlobalValue(Type /*P*/ Ty, Value.ValueTy VTy, type$ptr<Use /*P*/> Ops, /*uint*/int NumOps, 
      LinkageTypes Linkage, final /*const*/ Twine /*&*/ Name, /*uint*/int AddressSpace) {
    // : Constant(PointerType::get(Ty, AddressSpace), VTy, Ops, NumOps), ValueType(Ty), Linkage(Linkage), Visibility(DefaultVisibility), UnnamedAddrVal(unsigned int(UnnamedAddr::None)), DllStorageClass(DefaultStorageClass), ThreadLocal(NotThreadLocal), IntID((ID)0UU), Parent(null) 
    //START JInit
    super(PointerType.get(Ty, AddressSpace), VTy, Ops, NumOps);
    this.ValueType = Ty;
    this.Linkage = $uint2uint_4bits(Linkage.getValue());
    this.Visibility = $uint2uint_2bits(VisibilityTypes.DefaultVisibility.getValue());
    this.UnnamedAddrVal = $uint2uint_2bits(((/*uint*/int)(UnnamedAddr.None.getValue())));
    this.DllStorageClass = $uint2uint_2bits(DLLStorageClassTypes.DefaultStorageClass.getValue());
    this.ThreadLocal = $uint2uint_3bits(ThreadLocalMode.NotThreadLocal.getValue());
    this.IntID = /*(ID)*/0/*U*/;
    this.Parent = null;
    //END JInit
    setName(Name);
  }

  
  protected Type /*P*/ ValueType;
  // All bitfields use unsigned as the underlying type so that MSVC will pack
  // them.
  protected /*JBYTE unsigned int*/ byte Linkage /*: 4*/; // The linkage of this global
  protected /*JBYTE unsigned int*/ byte Visibility /*: 2*/; // The visibility style of this global
  protected /*JBYTE unsigned int*/ byte UnnamedAddrVal /*: 2*/; // This value's address is not significant
  protected /*JBYTE unsigned int*/ byte DllStorageClass /*: 2*/; // DLL storage class
  
  protected /*JBYTE unsigned int*/ byte ThreadLocal /*: 3*/; // Is this symbol "Thread Local", if so, what is
  // the desired model?
  protected static /*const*//*uint*/int GlobalValueSubClassDataBits = 19;
/*private:*/
  // Give subclasses access to what otherwise would be wasted padding.
  // (19 + 4 + 2 + 2 + 2 + 3) == 32.
  private /*uint*/int SubClassData /*: GlobalValueSubClassDataBits*/;
  
  /*friend  class Constant*/
  
  /// Override destroyConstantImpl to make sure it doesn't get called on
  /// GlobalValue's because they shouldn't be treated like other constants.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::destroyConstantImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 42,
   FQN="llvm::GlobalValue::destroyConstantImpl", NM="_ZN4llvm11GlobalValue19destroyConstantImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue19destroyConstantImplEv")
  //</editor-fold>
  /*friend*//*package*/ void destroyConstantImpl() {
    throw new llvm_unreachable("You can't GV->destroyConstantImpl()!");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::handleOperandChangeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 46,
   FQN="llvm::GlobalValue::handleOperandChangeImpl", NM="_ZN4llvm11GlobalValue23handleOperandChangeImplEPNS_5ValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue23handleOperandChangeImplEPNS_5ValueES2_")
  //</editor-fold>
  /*friend*//*package*/ Value /*P*/ handleOperandChangeImpl(Value /*P*/ From, Value /*P*/ To) {
    throw new llvm_unreachable("Unsupported class for handleOperandChange()!");
  }

  
  /// Returns true if the definition of this global may be replaced by a
  /// differently optimized variant of the same source level function at link
  /// time.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::mayBeDerefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 103,
   FQN="llvm::GlobalValue::mayBeDerefined", NM="_ZNK4llvm11GlobalValue14mayBeDerefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue14mayBeDerefinedEv")
  //</editor-fold>
  private boolean mayBeDerefined() /*const*/ {
    switch (getLinkage()) {
     case WeakODRLinkage:
     case LinkOnceODRLinkage:
     case AvailableExternallyLinkage:
      return true;
     case WeakAnyLinkage:
     case LinkOnceAnyLinkage:
     case CommonLinkage:
     case ExternalWeakLinkage:
     case ExternalLinkage:
     case AppendingLinkage:
     case InternalLinkage:
     case PrivateLinkage:
      return isInterposable();
    }
    throw new llvm_unreachable("Fully covered switch above!");
  }

/*protected:*/
  /// \brief The intrinsic ID for this subclass (which must be a Function).
  ///
  /// This member is defined by this class, but not used for anything.
  /// Subclasses can use it to store their intrinsic ID, if they have one.
  ///
  /// This is stored here to save space in Function on 64-bit hosts.
  protected /*intrinsic.ID*/int IntID;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getGlobalValueSubClassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 133,
   FQN="llvm::GlobalValue::getGlobalValueSubClassData", NM="_ZNK4llvm11GlobalValue26getGlobalValueSubClassDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue26getGlobalValueSubClassDataEv")
  //</editor-fold>
  protected /*uint*/int getGlobalValueSubClassData() /*const*/ {
    return SubClassData;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::setGlobalValueSubClassData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 136,
   FQN="llvm::GlobalValue::setGlobalValueSubClassData", NM="_ZN4llvm11GlobalValue26setGlobalValueSubClassDataEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue26setGlobalValueSubClassDataEj")
  //</editor-fold>
  protected void setGlobalValueSubClassData(/*uint*/int V) {
    assert ($less_uint(V, (1 << GlobalValueSubClassDataBits))) : "It will not fit";
    SubClassData = V;
  }

  
  protected Module /*P*/ Parent; // The containing module.
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::ThreadLocalMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 143,
   FQN="llvm::GlobalValue::ThreadLocalMode", NM="_ZN4llvm11GlobalValue15ThreadLocalModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue15ThreadLocalModeE")
  //</editor-fold>
  public enum ThreadLocalMode implements Native.NativeUIntEnum {
    NotThreadLocal(0),
    GeneralDynamicTLSModel(NotThreadLocal.getValue() + 1),
    LocalDynamicTLSModel(GeneralDynamicTLSModel.getValue() + 1),
    InitialExecTLSModel(LocalDynamicTLSModel.getValue() + 1),
    LocalExecTLSModel(InitialExecTLSModel.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ThreadLocalMode valueOf(int val) {
      ThreadLocalMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ThreadLocalMode[] VALUES;
      private static final ThreadLocalMode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ThreadLocalMode kind : ThreadLocalMode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ThreadLocalMode[min < 0 ? (1-min) : 0];
        VALUES = new ThreadLocalMode[max >= 0 ? (1+max) : 0];
        for (ThreadLocalMode kind : ThreadLocalMode.values()) {
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
    private ThreadLocalMode(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::~GlobalValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 151,
   FQN="llvm::GlobalValue::~GlobalValue", NM="_ZN4llvm11GlobalValueD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValueD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    removeDeadConstantUsers(); // remove any dead constants using this.
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 58,
   FQN="llvm::GlobalValue::getAlignment", NM="_ZNK4llvm11GlobalValue12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue12getAlignmentEv")
  //</editor-fold>
  public /*uint*/int getAlignment() /*const*/ {
    {
      /*const*/ GlobalAlias /*P*/ GA = dyn_cast_GlobalAlias(this);
      if ((GA != null)) {
        {
          // In general we cannot compute this at the IR level, but we try.
          /*const*/ GlobalObject /*P*/ GO = GA.getBaseObject$Const();
          if ((GO != null)) {
            return GO.getAlignment();
          }
        }
        
        // FIXME: we should also be able to handle:
        // Alias = Global + Offset
        // Alias = Absolute
        return 0;
      }
    }
    return cast_GlobalObject(this).getAlignment();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::UnnamedAddr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 157,
   FQN="llvm::GlobalValue::UnnamedAddr", NM="_ZN4llvm11GlobalValue11UnnamedAddrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue11UnnamedAddrE")
  //</editor-fold>
  public enum /*class */UnnamedAddr/* : int*/ implements Native.NativeIntEnum {
    None(0),
    Local(None.getValue() + 1),
    Global(Local.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static UnnamedAddr valueOf(int val) {
      UnnamedAddr out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final UnnamedAddr[] VALUES;
      private static final UnnamedAddr[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (UnnamedAddr kind : UnnamedAddr.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new UnnamedAddr[min < 0 ? (1-min) : 0];
        VALUES = new UnnamedAddr[max >= 0 ? (1+max) : 0];
        for (UnnamedAddr kind : UnnamedAddr.values()) {
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

    private final int value;
    private UnnamedAddr(int val) { this.value = (int)val;}
    @Override public final int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasGlobalUnnamedAddr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 163,
   FQN="llvm::GlobalValue::hasGlobalUnnamedAddr", NM="_ZNK4llvm11GlobalValue20hasGlobalUnnamedAddrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue20hasGlobalUnnamedAddrEv")
  //</editor-fold>
  public boolean hasGlobalUnnamedAddr() /*const*/ {
    return getUnnamedAddr() == UnnamedAddr.Global;
  }

  
  /// Returns true if this value's address is not significant in this module.
  /// This attribute is intended to be used only by the code generator and LTO
  /// to allow the linker to decide whether the global needs to be in the symbol
  /// table. It should probably not be used in optimizations, as the value may
  /// have uses outside the module; use hasGlobalUnnamedAddr() instead.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasAtLeastLocalUnnamedAddr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 172,
   FQN="llvm::GlobalValue::hasAtLeastLocalUnnamedAddr", NM="_ZNK4llvm11GlobalValue26hasAtLeastLocalUnnamedAddrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue26hasAtLeastLocalUnnamedAddrEv")
  //</editor-fold>
  public boolean hasAtLeastLocalUnnamedAddr() /*const*/ {
    return getUnnamedAddr() != UnnamedAddr.None;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getUnnamedAddr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 176,
   FQN="llvm::GlobalValue::getUnnamedAddr", NM="_ZNK4llvm11GlobalValue14getUnnamedAddrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue14getUnnamedAddrEv")
  //</editor-fold>
  public UnnamedAddr getUnnamedAddr() /*const*/ {
    return UnnamedAddr.valueOf($2bits_uint2uint(UnnamedAddrVal));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::setUnnamedAddr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 179,
   FQN="llvm::GlobalValue::setUnnamedAddr", NM="_ZN4llvm11GlobalValue14setUnnamedAddrENS0_11UnnamedAddrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue14setUnnamedAddrENS0_11UnnamedAddrE")
  //</editor-fold>
  public void setUnnamedAddr(UnnamedAddr Val) {
    UnnamedAddrVal = $uint2uint_2bits(((/*uint*/int)(Val.getValue())));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getMinUnnamedAddr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 181,
   FQN="llvm::GlobalValue::getMinUnnamedAddr", NM="_ZN4llvm11GlobalValue17getMinUnnamedAddrENS0_11UnnamedAddrES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue17getMinUnnamedAddrENS0_11UnnamedAddrES1_")
  //</editor-fold>
  public static UnnamedAddr getMinUnnamedAddr(UnnamedAddr A, UnnamedAddr B) {
    if (A == UnnamedAddr.None || B == UnnamedAddr.None) {
      return UnnamedAddr.None;
    }
    if (A == UnnamedAddr.Local || B == UnnamedAddr.Local) {
      return UnnamedAddr.Local;
    }
    return UnnamedAddr.Global;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasComdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 189,
   FQN="llvm::GlobalValue::hasComdat", NM="_ZNK4llvm11GlobalValue9hasComdatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue9hasComdatEv")
  //</editor-fold>
  public boolean hasComdat() /*const*/ {
    return getComdat$Const() != null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getComdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 141,
   FQN="llvm::GlobalValue::getComdat", NM="_ZN4llvm11GlobalValue9getComdatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue9getComdatEv")
  //</editor-fold>
  public Comdat /*P*/ getComdat() {
    {
      GlobalAlias /*P*/ GA = dyn_cast_GlobalAlias(this);
      if ((GA != null)) {
        {
          // In general we cannot compute this at the IR level, but we try.
          /*const*/ GlobalObject /*P*/ GO = GA.getBaseObject();
          if ((GO != null)) {
            return ((/*const_cast*/GlobalObject /*P*/ )(GO)).getComdat();
          }
        }
        return null;
      }
    }
    // ifunc and its resolver are separate things so don't use resolver comdat.
    if (isa_GlobalIFunc(this)) {
      return null;
    }
    return cast_GlobalObject(this).getComdat();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getComdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 191,
   FQN="llvm::GlobalValue::getComdat", NM="_ZNK4llvm11GlobalValue9getComdatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue9getComdatEv")
  //</editor-fold>
  public /*const*/ Comdat /*P*/ getComdat$Const() /*const*/ {
    return ((/*const_cast*/GlobalValue /*P*/ )(this)).getComdat();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 195,
   FQN="llvm::GlobalValue::getVisibility", NM="_ZNK4llvm11GlobalValue13getVisibilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue13getVisibilityEv")
  //</editor-fold>
  public VisibilityTypes getVisibility() /*const*/ {
    return VisibilityTypes.valueOf($2bits_uint2uint(Visibility));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasDefaultVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 196,
   FQN="llvm::GlobalValue::hasDefaultVisibility", NM="_ZNK4llvm11GlobalValue20hasDefaultVisibilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue20hasDefaultVisibilityEv")
  //</editor-fold>
  public boolean hasDefaultVisibility() /*const*/ {
    return $2bits_uint2uint(Visibility) == VisibilityTypes.DefaultVisibility.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasHiddenVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 197,
   FQN="llvm::GlobalValue::hasHiddenVisibility", NM="_ZNK4llvm11GlobalValue19hasHiddenVisibilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue19hasHiddenVisibilityEv")
  //</editor-fold>
  public boolean hasHiddenVisibility() /*const*/ {
    return $2bits_uint2uint(Visibility) == VisibilityTypes.HiddenVisibility.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasProtectedVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 198,
   FQN="llvm::GlobalValue::hasProtectedVisibility", NM="_ZNK4llvm11GlobalValue22hasProtectedVisibilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue22hasProtectedVisibilityEv")
  //</editor-fold>
  public boolean hasProtectedVisibility() /*const*/ {
    return $2bits_uint2uint(Visibility) == VisibilityTypes.ProtectedVisibility.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::setVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 201,
   FQN="llvm::GlobalValue::setVisibility", NM="_ZN4llvm11GlobalValue13setVisibilityENS0_15VisibilityTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue13setVisibilityENS0_15VisibilityTypesE")
  //</editor-fold>
  public void setVisibility(VisibilityTypes V) {
    assert ((!hasLocalLinkage() || V == VisibilityTypes.DefaultVisibility)) : "local linkage requires default visibility";
    Visibility = $uint2uint_2bits(V.getValue());
  }

  
  /// If the value is "Thread Local", its value isn't shared by the threads.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isThreadLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 208,
   FQN="llvm::GlobalValue::isThreadLocal", NM="_ZNK4llvm11GlobalValue13isThreadLocalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue13isThreadLocalEv")
  //</editor-fold>
  public boolean isThreadLocal() /*const*/ {
    return getThreadLocalMode() != ThreadLocalMode.NotThreadLocal;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::setThreadLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 209,
   FQN="llvm::GlobalValue::setThreadLocal", NM="_ZN4llvm11GlobalValue14setThreadLocalEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue14setThreadLocalEb")
  //</editor-fold>
  public void setThreadLocal(boolean Val) {
    setThreadLocalMode(Val ? ThreadLocalMode.GeneralDynamicTLSModel : ThreadLocalMode.NotThreadLocal);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::setThreadLocalMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 212,
   FQN="llvm::GlobalValue::setThreadLocalMode", NM="_ZN4llvm11GlobalValue18setThreadLocalModeENS0_15ThreadLocalModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue18setThreadLocalModeENS0_15ThreadLocalModeE")
  //</editor-fold>
  public void setThreadLocalMode(ThreadLocalMode Val) {
    assert (Val == ThreadLocalMode.NotThreadLocal || getValueID() != Value.ValueTy.FunctionVal.getValue());
    ThreadLocal = $uint2uint_3bits(Val.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getThreadLocalMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 216,
   FQN="llvm::GlobalValue::getThreadLocalMode", NM="_ZNK4llvm11GlobalValue18getThreadLocalModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue18getThreadLocalModeEv")
  //</editor-fold>
  public ThreadLocalMode getThreadLocalMode() /*const*/ {
    return /*static_cast*/ThreadLocalMode.valueOf($3bits_uint2uint(ThreadLocal));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getDLLStorageClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 220,
   FQN="llvm::GlobalValue::getDLLStorageClass", NM="_ZNK4llvm11GlobalValue18getDLLStorageClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue18getDLLStorageClassEv")
  //</editor-fold>
  public DLLStorageClassTypes getDLLStorageClass() /*const*/ {
    return DLLStorageClassTypes.valueOf($2bits_uint2uint(DllStorageClass));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasDLLImportStorageClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 223,
   FQN="llvm::GlobalValue::hasDLLImportStorageClass", NM="_ZNK4llvm11GlobalValue24hasDLLImportStorageClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue24hasDLLImportStorageClassEv")
  //</editor-fold>
  public boolean hasDLLImportStorageClass() /*const*/ {
    return $2bits_uint2uint(DllStorageClass) == DLLStorageClassTypes.DLLImportStorageClass.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasDLLExportStorageClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 226,
   FQN="llvm::GlobalValue::hasDLLExportStorageClass", NM="_ZNK4llvm11GlobalValue24hasDLLExportStorageClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue24hasDLLExportStorageClassEv")
  //</editor-fold>
  public boolean hasDLLExportStorageClass() /*const*/ {
    return $2bits_uint2uint(DllStorageClass) == DLLStorageClassTypes.DLLExportStorageClass.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::setDLLStorageClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 229,
   FQN="llvm::GlobalValue::setDLLStorageClass", NM="_ZN4llvm11GlobalValue18setDLLStorageClassENS0_20DLLStorageClassTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue18setDLLStorageClassENS0_20DLLStorageClassTypesE")
  //</editor-fold>
  public void setDLLStorageClass(DLLStorageClassTypes C) {
    DllStorageClass = $uint2uint_2bits(C.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 231,
   FQN="llvm::GlobalValue::hasSection", NM="_ZNK4llvm11GlobalValue10hasSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue10hasSectionEv")
  //</editor-fold>
  public boolean hasSection() /*const*/ {
    return !getSection().empty();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 131,
   FQN="llvm::GlobalValue::getSection", NM="_ZNK4llvm11GlobalValue10getSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue10getSectionEv")
  //</editor-fold>
  public StringRef getSection() /*const*/ {
    {
      /*const*/ GlobalAlias /*P*/ GA = dyn_cast_GlobalAlias(this);
      if ((GA != null)) {
        {
          // In general we cannot compute this at the IR level, but we try.
          /*const*/ GlobalObject /*P*/ GO = GA.getBaseObject$Const();
          if ((GO != null)) {
            return GO.getSection();
          }
        }
        return new StringRef(/*KEEP_STR*/$EMPTY);
      }
    }
    return cast_GlobalObject(this).getSection();
  }

  
  /// Global values are always pointers.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 235,
   FQN="llvm::GlobalValue::getType", NM="_ZNK4llvm11GlobalValue7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue7getTypeEv")
  //</editor-fold>
  public PointerType /*P*/ getType() /*const*/ {
    return cast_PointerType(super.getType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 237,
   FQN="llvm::GlobalValue::getValueType", NM="_ZNK4llvm11GlobalValue12getValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue12getValueTypeEv")
  //</editor-fold>
  public Type /*P*/ getValueType() /*const*/ {
    return ValueType;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getLinkOnceLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 239,
   FQN="llvm::GlobalValue::getLinkOnceLinkage", NM="_ZN4llvm11GlobalValue18getLinkOnceLinkageEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue18getLinkOnceLinkageEb")
  //</editor-fold>
  public static LinkageTypes getLinkOnceLinkage(boolean ODR) {
    return ODR ? LinkageTypes.LinkOnceODRLinkage : LinkageTypes.LinkOnceAnyLinkage;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getWeakLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 242,
   FQN="llvm::GlobalValue::getWeakLinkage", NM="_ZN4llvm11GlobalValue14getWeakLinkageEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue14getWeakLinkageEb")
  //</editor-fold>
  public static LinkageTypes getWeakLinkage(boolean ODR) {
    return ODR ? LinkageTypes.WeakODRLinkage : LinkageTypes.WeakAnyLinkage;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isExternalLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 246,
   FQN="llvm::GlobalValue::isExternalLinkage", NM="_ZN4llvm11GlobalValue17isExternalLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue17isExternalLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isExternalLinkage(LinkageTypes Linkage) {
    return Linkage == LinkageTypes.ExternalLinkage;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isAvailableExternallyLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 249,
   FQN="llvm::GlobalValue::isAvailableExternallyLinkage", NM="_ZN4llvm11GlobalValue28isAvailableExternallyLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue28isAvailableExternallyLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isAvailableExternallyLinkage(LinkageTypes Linkage) {
    return Linkage == LinkageTypes.AvailableExternallyLinkage;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isLinkOnceODRLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 252,
   FQN="llvm::GlobalValue::isLinkOnceODRLinkage", NM="_ZN4llvm11GlobalValue20isLinkOnceODRLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue20isLinkOnceODRLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isLinkOnceODRLinkage(LinkageTypes Linkage) {
    return Linkage == LinkageTypes.LinkOnceODRLinkage;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isLinkOnceLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 255,
   FQN="llvm::GlobalValue::isLinkOnceLinkage", NM="_ZN4llvm11GlobalValue17isLinkOnceLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue17isLinkOnceLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isLinkOnceLinkage(LinkageTypes Linkage) {
    return Linkage == LinkageTypes.LinkOnceAnyLinkage || Linkage == LinkageTypes.LinkOnceODRLinkage;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isWeakAnyLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 258,
   FQN="llvm::GlobalValue::isWeakAnyLinkage", NM="_ZN4llvm11GlobalValue16isWeakAnyLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue16isWeakAnyLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isWeakAnyLinkage(LinkageTypes Linkage) {
    return Linkage == LinkageTypes.WeakAnyLinkage;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isWeakODRLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 261,
   FQN="llvm::GlobalValue::isWeakODRLinkage", NM="_ZN4llvm11GlobalValue16isWeakODRLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue16isWeakODRLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isWeakODRLinkage(LinkageTypes Linkage) {
    return Linkage == LinkageTypes.WeakODRLinkage;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isWeakLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 264,
   FQN="llvm::GlobalValue::isWeakLinkage", NM="_ZN4llvm11GlobalValue13isWeakLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue13isWeakLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isWeakLinkage(LinkageTypes Linkage) {
    return GlobalValue.isWeakAnyLinkage(Linkage) || GlobalValue.isWeakODRLinkage(Linkage);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isAppendingLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 267,
   FQN="llvm::GlobalValue::isAppendingLinkage", NM="_ZN4llvm11GlobalValue18isAppendingLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue18isAppendingLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isAppendingLinkage(LinkageTypes Linkage) {
    return Linkage == LinkageTypes.AppendingLinkage;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isInternalLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 270,
   FQN="llvm::GlobalValue::isInternalLinkage", NM="_ZN4llvm11GlobalValue17isInternalLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue17isInternalLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isInternalLinkage(LinkageTypes Linkage) {
    return Linkage == LinkageTypes.InternalLinkage;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isPrivateLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 273,
   FQN="llvm::GlobalValue::isPrivateLinkage", NM="_ZN4llvm11GlobalValue16isPrivateLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue16isPrivateLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isPrivateLinkage(LinkageTypes Linkage) {
    return Linkage == LinkageTypes.PrivateLinkage;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isLocalLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 276,
   FQN="llvm::GlobalValue::isLocalLinkage", NM="_ZN4llvm11GlobalValue14isLocalLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue14isLocalLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isLocalLinkage(LinkageTypes Linkage) {
    return GlobalValue.isInternalLinkage(Linkage) || GlobalValue.isPrivateLinkage(Linkage);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isExternalWeakLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 279,
   FQN="llvm::GlobalValue::isExternalWeakLinkage", NM="_ZN4llvm11GlobalValue21isExternalWeakLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue21isExternalWeakLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isExternalWeakLinkage(LinkageTypes Linkage) {
    return Linkage == LinkageTypes.ExternalWeakLinkage;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isCommonLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 282,
   FQN="llvm::GlobalValue::isCommonLinkage", NM="_ZN4llvm11GlobalValue15isCommonLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue15isCommonLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isCommonLinkage(LinkageTypes Linkage) {
    return Linkage == LinkageTypes.CommonLinkage;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isValidDeclarationLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 285,
   FQN="llvm::GlobalValue::isValidDeclarationLinkage", NM="_ZN4llvm11GlobalValue25isValidDeclarationLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue25isValidDeclarationLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isValidDeclarationLinkage(LinkageTypes Linkage) {
    return GlobalValue.isExternalWeakLinkage(Linkage) || GlobalValue.isExternalLinkage(Linkage);
  }

  
  /// Whether the definition of this global may be replaced by something
  /// non-equivalent at link time. For example, if a function has weak linkage
  /// then the code defining it may be replaced by different code.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isInterposableLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 292,
   FQN="llvm::GlobalValue::isInterposableLinkage", NM="_ZN4llvm11GlobalValue21isInterposableLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue21isInterposableLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isInterposableLinkage(LinkageTypes Linkage) {
    switch (Linkage) {
     case WeakAnyLinkage:
     case LinkOnceAnyLinkage:
     case CommonLinkage:
     case ExternalWeakLinkage:
      return true;
     case AvailableExternallyLinkage:
     case LinkOnceODRLinkage:
     case WeakODRLinkage:
     case ExternalLinkage:
     case AppendingLinkage:
     case InternalLinkage:
     case PrivateLinkage:
      // The above three cannot be overridden but can be de-refined.
      return false;
    }
    throw new llvm_unreachable("Fully covered switch above!");
  }

  
  /// Whether the definition of this global may be discarded if it is not used
  /// in its compilation unit.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isDiscardableIfUnused">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 316,
   FQN="llvm::GlobalValue::isDiscardableIfUnused", NM="_ZN4llvm11GlobalValue21isDiscardableIfUnusedENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue21isDiscardableIfUnusedENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isDiscardableIfUnused(LinkageTypes Linkage) {
    return GlobalValue.isLinkOnceLinkage(Linkage) || GlobalValue.isLocalLinkage(Linkage)
       || GlobalValue.isAvailableExternallyLinkage(Linkage);
  }

  
  /// Whether the definition of this global may be replaced at link time.  NB:
  /// Using this method outside of the code generators is almost always a
  /// mistake: when working at the IR level use isInterposable instead as it
  /// knows about ODR semantics.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isWeakForLinker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 325,
   FQN="llvm::GlobalValue::isWeakForLinker", NM="_ZN4llvm11GlobalValue15isWeakForLinkerENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue15isWeakForLinkerENS0_12LinkageTypesE")
  //</editor-fold>
  public static boolean isWeakForLinker(LinkageTypes Linkage) {
    return Linkage == LinkageTypes.WeakAnyLinkage || Linkage == LinkageTypes.WeakODRLinkage
       || Linkage == LinkageTypes.LinkOnceAnyLinkage || Linkage == LinkageTypes.LinkOnceODRLinkage
       || Linkage == LinkageTypes.CommonLinkage || Linkage == LinkageTypes.ExternalWeakLinkage;
  }

  
  /// Return true if the currently visible definition of this global (if any) is
  /// exactly the definition we will see at runtime.
  ///
  /// Non-exact linkage types inhibits most non-inlining IPO, since a
  /// differently optimized variant of the same function can have different
  /// observable or undefined behavior than in the variant currently visible.
  /// For instance, we could have started with
  ///
  ///   void foo(int *v) {
  ///     int t = 5 / v[0];
  ///     (void) t;
  ///   }
  ///
  /// and "refined" it to
  ///
  ///   void foo(int *v) { }
  ///
  /// However, we cannot infer readnone for `foo`, since that would justify
  /// DSE'ing a store to `v[0]` across a call to `foo`, which can cause
  /// undefined behavior if the linker replaces the actual call destination with
  /// the unoptimized `foo`.
  ///
  /// Inlining is okay across non-exact linkage types as long as they're not
  /// interposable (see \c isInterposable), since in such cases the currently
  /// visible variant is *a* correct implementation of the original source
  /// function; it just isn't the *only* correct implementation.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isDefinitionExact">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 357,
   FQN="llvm::GlobalValue::isDefinitionExact", NM="_ZNK4llvm11GlobalValue17isDefinitionExactEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue17isDefinitionExactEv")
  //</editor-fold>
  public boolean isDefinitionExact() /*const*/ {
    return !mayBeDerefined();
  }

  
  /// Return true if this global has an exact defintion.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasExactDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 362,
   FQN="llvm::GlobalValue::hasExactDefinition", NM="_ZNK4llvm11GlobalValue18hasExactDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue18hasExactDefinitionEv")
  //</editor-fold>
  public boolean hasExactDefinition() /*const*/ {
    // While this computes exactly the same thing as
    // isStrongDefinitionForLinker, the intended uses are different.  This
    // function is intended to help decide if specific inter-procedural
    // transforms are correct, while isStrongDefinitionForLinker's intended use
    // is in low level code generation.
    return !isDeclaration() && isDefinitionExact();
  }

  
  /// Return true if this global's definition can be substituted with an
  /// *arbitrary* definition at link time.  We cannot do any IPO or inlinining
  /// across interposable call edges, since the callee can be replaced with
  /// something arbitrary at link time.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isInterposable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 375,
   FQN="llvm::GlobalValue::isInterposable", NM="_ZNK4llvm11GlobalValue14isInterposableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue14isInterposableEv")
  //</editor-fold>
  public boolean isInterposable() /*const*/ {
    return GlobalValue.isInterposableLinkage(getLinkage());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasExternalLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 377,
   FQN="llvm::GlobalValue::hasExternalLinkage", NM="_ZNK4llvm11GlobalValue18hasExternalLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue18hasExternalLinkageEv")
  //</editor-fold>
  public boolean hasExternalLinkage() /*const*/ {
    return GlobalValue.isExternalLinkage(getLinkage());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasAvailableExternallyLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 378,
   FQN="llvm::GlobalValue::hasAvailableExternallyLinkage", NM="_ZNK4llvm11GlobalValue29hasAvailableExternallyLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue29hasAvailableExternallyLinkageEv")
  //</editor-fold>
  public boolean hasAvailableExternallyLinkage() /*const*/ {
    return GlobalValue.isAvailableExternallyLinkage(getLinkage());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasLinkOnceLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 381,
   FQN="llvm::GlobalValue::hasLinkOnceLinkage", NM="_ZNK4llvm11GlobalValue18hasLinkOnceLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue18hasLinkOnceLinkageEv")
  //</editor-fold>
  public boolean hasLinkOnceLinkage() /*const*/ {
    return GlobalValue.isLinkOnceLinkage(getLinkage());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasLinkOnceODRLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 382,
   FQN="llvm::GlobalValue::hasLinkOnceODRLinkage", NM="_ZNK4llvm11GlobalValue21hasLinkOnceODRLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue21hasLinkOnceODRLinkageEv")
  //</editor-fold>
  public boolean hasLinkOnceODRLinkage() /*const*/ {
    return GlobalValue.isLinkOnceODRLinkage(getLinkage());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasWeakLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 385,
   FQN="llvm::GlobalValue::hasWeakLinkage", NM="_ZNK4llvm11GlobalValue14hasWeakLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue14hasWeakLinkageEv")
  //</editor-fold>
  public boolean hasWeakLinkage() /*const*/ {
    return GlobalValue.isWeakLinkage(getLinkage());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasWeakAnyLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 386,
   FQN="llvm::GlobalValue::hasWeakAnyLinkage", NM="_ZNK4llvm11GlobalValue17hasWeakAnyLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue17hasWeakAnyLinkageEv")
  //</editor-fold>
  public boolean hasWeakAnyLinkage() /*const*/ {
    return GlobalValue.isWeakAnyLinkage(getLinkage());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasWeakODRLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 387,
   FQN="llvm::GlobalValue::hasWeakODRLinkage", NM="_ZNK4llvm11GlobalValue17hasWeakODRLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue17hasWeakODRLinkageEv")
  //</editor-fold>
  public boolean hasWeakODRLinkage() /*const*/ {
    return GlobalValue.isWeakODRLinkage(getLinkage());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasAppendingLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 388,
   FQN="llvm::GlobalValue::hasAppendingLinkage", NM="_ZNK4llvm11GlobalValue19hasAppendingLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue19hasAppendingLinkageEv")
  //</editor-fold>
  public boolean hasAppendingLinkage() /*const*/ {
    return GlobalValue.isAppendingLinkage(getLinkage());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasInternalLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 389,
   FQN="llvm::GlobalValue::hasInternalLinkage", NM="_ZNK4llvm11GlobalValue18hasInternalLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue18hasInternalLinkageEv")
  //</editor-fold>
  public boolean hasInternalLinkage() /*const*/ {
    return GlobalValue.isInternalLinkage(getLinkage());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasPrivateLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 390,
   FQN="llvm::GlobalValue::hasPrivateLinkage", NM="_ZNK4llvm11GlobalValue17hasPrivateLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue17hasPrivateLinkageEv")
  //</editor-fold>
  public boolean hasPrivateLinkage() /*const*/ {
    return GlobalValue.isPrivateLinkage(getLinkage());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasLocalLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 391,
   FQN="llvm::GlobalValue::hasLocalLinkage", NM="_ZNK4llvm11GlobalValue15hasLocalLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue15hasLocalLinkageEv")
  //</editor-fold>
  public boolean hasLocalLinkage() /*const*/ {
    return GlobalValue.isLocalLinkage(getLinkage());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasExternalWeakLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 392,
   FQN="llvm::GlobalValue::hasExternalWeakLinkage", NM="_ZNK4llvm11GlobalValue22hasExternalWeakLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue22hasExternalWeakLinkageEv")
  //</editor-fold>
  public boolean hasExternalWeakLinkage() /*const*/ {
    return GlobalValue.isExternalWeakLinkage(getLinkage());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasCommonLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 395,
   FQN="llvm::GlobalValue::hasCommonLinkage", NM="_ZNK4llvm11GlobalValue16hasCommonLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue16hasCommonLinkageEv")
  //</editor-fold>
  public boolean hasCommonLinkage() /*const*/ {
    return GlobalValue.isCommonLinkage(getLinkage());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::hasValidDeclarationLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 396,
   FQN="llvm::GlobalValue::hasValidDeclarationLinkage", NM="_ZNK4llvm11GlobalValue26hasValidDeclarationLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue26hasValidDeclarationLinkageEv")
  //</editor-fold>
  public boolean hasValidDeclarationLinkage() /*const*/ {
    return GlobalValue.isValidDeclarationLinkage(getLinkage());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::setLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 400,
   FQN="llvm::GlobalValue::setLinkage", NM="_ZN4llvm11GlobalValue10setLinkageENS0_12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue10setLinkageENS0_12LinkageTypesE")
  //</editor-fold>
  public void setLinkage(LinkageTypes LT) {
    if (GlobalValue.isLocalLinkage(LT)) {
      Visibility = $uint2uint_2bits(VisibilityTypes.DefaultVisibility.getValue());
    }
    Linkage = $uint2uint_4bits(LT.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 405,
   FQN="llvm::GlobalValue::getLinkage", NM="_ZNK4llvm11GlobalValue10getLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue10getLinkageEv")
  //</editor-fold>
  public LinkageTypes getLinkage() /*const*/ {
    return LinkageTypes.valueOf($4bits_uint2uint(Linkage));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isDiscardableIfUnused">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 407,
   FQN="llvm::GlobalValue::isDiscardableIfUnused", NM="_ZNK4llvm11GlobalValue21isDiscardableIfUnusedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue21isDiscardableIfUnusedEv")
  //</editor-fold>
  public boolean isDiscardableIfUnused() /*const*/ {
    return GlobalValue.isDiscardableIfUnused(getLinkage());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isWeakForLinker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 411,
   FQN="llvm::GlobalValue::isWeakForLinker", NM="_ZNK4llvm11GlobalValue15isWeakForLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue15isWeakForLinkerEv")
  //</editor-fold>
  public boolean isWeakForLinker() /*const*/ {
    return GlobalValue.isWeakForLinker(getLinkage());
  }

  
  /// Copy all additional attributes (those not needed to create a GlobalValue)
  /// from the GlobalValue Src to this one.
  
  /// copyAttributesFrom - copy all additional attributes (those not needed to
  /// create a GlobalValue) from the GlobalValue Src to this one.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::copyAttributesFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 52,
   FQN="llvm::GlobalValue::copyAttributesFrom", NM="_ZN4llvm11GlobalValue18copyAttributesFromEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue18copyAttributesFromEPKS0_")
  //</editor-fold>
  public void copyAttributesFrom(/*const*/ GlobalValue /*P*/ Src) {
    setVisibility(Src.getVisibility());
    setUnnamedAddr(Src.getUnnamedAddr());
    setDLLStorageClass(Src.getDLLStorageClass());
  }

  
  /// If special LLVM prefix that is used to inform the asm printer to not emit
  /// usual symbol prefix before the symbol name is used then return linkage
  /// name after skipping this special LLVM prefix.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getRealLinkageName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 420,
   FQN="llvm::GlobalValue::getRealLinkageName", NM="_ZN4llvm11GlobalValue18getRealLinkageNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue18getRealLinkageNameENS_9StringRefE")
  //</editor-fold>
  public static StringRef getRealLinkageName(StringRef Name) {
    if (!Name.empty() && Name.$at(0) == $$SOH) {
      return Name.substr(1);
    }
    return new StringRef(JD$Move.INSTANCE, Name);
  }

  
  /// Return the modified name for a global value suitable to be
  /// used as the key for a global lookup (e.g. profile or ThinLTO).
  /// The value's original name is \c Name and has linkage of type
  /// \c Linkage. The value is defined in module \c FileName.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getGlobalIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 102,
   FQN="llvm::GlobalValue::getGlobalIdentifier", NM="_ZN4llvm11GlobalValue19getGlobalIdentifierENS_9StringRefENS0_12LinkageTypesES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue19getGlobalIdentifierENS_9StringRefENS0_12LinkageTypesES1_")
  //</editor-fold>
  public static std.string getGlobalIdentifier(StringRef Name, 
                     GlobalValue.LinkageTypes Linkage, 
                     StringRef FileName) {
    
    // Value names may be prefixed with a binary '1' to indicate
    // that the backend should not modify the symbols due to any platform
    // naming convention. Do not include that '1' in the PGO profile name.
    if (Name.$at(0) == $$SOH) {
      Name.$assignMove(Name.substr(1));
    }
    
    std.string NewName = Name.$string();
    if (GlobalValue.isLocalLinkage(Linkage)) {
      // For local symbols, prepend the main file name to distinguish them.
      // Do not include the full path in the file name since there's no guarantee
      // that it will stay the same, e.g., if the files are checked out from
      // version control in different locations.
      if (FileName.empty()) {
        NewName.$assign(NewName.insert_size_type$_CharT_T$C$P(0, $("<unknown>:")));
      } else {
        NewName.$assign(NewName.insert(0, $add_string_T$C$P(FileName.str(), /*KEEP_STR*/":")));
      }
    }
    return NewName;
  }

  
  /// Return the modified name for this global value suitable to be
  /// used as the key for a global lookup (e.g. profile or ThinLTO).
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getGlobalIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 126,
   FQN="llvm::GlobalValue::getGlobalIdentifier", NM="_ZNK4llvm11GlobalValue19getGlobalIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue19getGlobalIdentifierEv")
  //</editor-fold>
  public std.string getGlobalIdentifier() /*const*/ {
    return getGlobalIdentifier(getName(), getLinkage(), 
        new StringRef(getParent$Const().getSourceFileName()));
  }

  
  /// Declare a type to represent a global unique identifier for a global value.
  /// This is a 64 bits hash that is used by PGO and ThinLTO to have a compact
  /// unique way to identify a symbol.
  /*using GUID = uint64_t*/;
  
  /// Return a 64-bit global unique ID constructed from global value name
  /// (i.e. returned by getGlobalIdentifier()).
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getGUID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 445,
   FQN="llvm::GlobalValue::getGUID", NM="_ZN4llvm11GlobalValue7getGUIDENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue7getGUIDENS_9StringRefE")
  //</editor-fold>
  public static long/*uint64_t*/ getGUID(StringRef GlobalName) {
    return MD5Hash(new StringRef(GlobalName));
  }

  
  /// Return a 64-bit global unique ID constructed from global value name
  /// (i.e. returned by getGlobalIdentifier()).
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getGUID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 449,
   FQN="llvm::GlobalValue::getGUID", NM="_ZNK4llvm11GlobalValue7getGUIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue7getGUIDEv")
  //</editor-fold>
  public long/*uint64_t*/ getGUID() /*const*/ {
    return GlobalValue.getGUID(new StringRef(getGlobalIdentifier()));
  }

  
  /// @name Materialization
  /// Materialization is used to construct functions only as they're needed.
  /// This
  /// is useful to reduce memory usage in LLVM or parsing work done by the
  /// BitcodeReader to load the Module.
  /// @{
  
  /// If this function's Module is being lazily streamed in functions from disk
  /// or some other source, this method can be used to check to see if the
  /// function has been read in yet or not.
  
  //===----------------------------------------------------------------------===//
  //                            GlobalValue Class
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isMaterializable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 31,
   FQN="llvm::GlobalValue::isMaterializable", NM="_ZNK4llvm11GlobalValue16isMaterializableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue16isMaterializableEv")
  //</editor-fold>
  public boolean isMaterializable() /*const*/ {
    {
      /*const*/ Function /*P*/ F = dyn_cast_Function(this);
      if ((F != null)) {
        return F.isMaterializable();
      }
    }
    return false;
  }

  
  /// Make sure this GlobalValue is fully read. If the module is corrupt, this
  /// returns true and fills in the optional string with information about the
  /// problem.  If successful, this returns false.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::materialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 36,
   FQN="llvm::GlobalValue::materialize", NM="_ZN4llvm11GlobalValue11materializeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue11materializeEv")
  //</editor-fold>
  public std.error_code materialize() {
    return getParent().materialize(this);
  }

  
  /// @}
  
  /// Return true if the primary definition of this global value is outside of
  /// the current translation unit.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 161,
   FQN="llvm::GlobalValue::isDeclaration", NM="_ZNK4llvm11GlobalValue13isDeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue13isDeclarationEv")
  //</editor-fold>
  public boolean isDeclaration() /*const*/ {
    {
      // Globals are definitions if they have an initializer.
      /*const*/ GlobalVariable /*P*/ GV = dyn_cast_GlobalVariable(this);
      if ((GV != null)) {
        return GV.getNumOperands() == 0;
      }
    }
    {
      
      // Functions are definitions if they have a body.
      /*const*/ Function /*P*/ F = dyn_cast_Function(this);
      if ((F != null)) {
        return F.empty() && !F.isMaterializable();
      }
    }
    
    // Aliases and ifuncs are always definitions.
    assert (isa_GlobalIndirectSymbol(this));
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isDeclarationForLinker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 474,
   FQN="llvm::GlobalValue::isDeclarationForLinker", NM="_ZNK4llvm11GlobalValue22isDeclarationForLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue22isDeclarationForLinkerEv")
  //</editor-fold>
  public boolean isDeclarationForLinker() /*const*/ {
    if (hasAvailableExternallyLinkage()) {
      return true;
    }
    
    return isDeclaration();
  }

  
  /// Returns true if this global's definition will be the one chosen by the
  /// linker.
  ///
  /// NB! Ideally this should not be used at the IR level at all.  If you're
  /// interested in optimization constraints implied by the linker's ability to
  /// choose an implementation, prefer using \c hasExactDefinition.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::isStrongDefinitionForLinker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 487,
   FQN="llvm::GlobalValue::isStrongDefinitionForLinker", NM="_ZNK4llvm11GlobalValue27isStrongDefinitionForLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue27isStrongDefinitionForLinkerEv")
  //</editor-fold>
  public boolean isStrongDefinitionForLinker() /*const*/ {
    return !(isDeclarationForLinker() || isWeakForLinker());
  }

  
  // Returns true if the alignment of the value can be unilaterally
  // increased.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::canIncreaseAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 175,
   FQN="llvm::GlobalValue::canIncreaseAlignment", NM="_ZNK4llvm11GlobalValue20canIncreaseAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue20canIncreaseAlignmentEv")
  //</editor-fold>
  public boolean canIncreaseAlignment() /*const*/ {
    // Firstly, can only increase the alignment of a global if it
    // is a strong definition.
    if (!isStrongDefinitionForLinker()) {
      return false;
    }
    
    // It also has to either not have a section defined, or, not have
    // alignment specified. (If it is assigned a section, the global
    // could be densely packed with other objects in the section, and
    // increasing the alignment could cause padding issues.)
    if (hasSection() && $greater_uint(getAlignment(), 0)) {
      return false;
    }
    
    // On ELF platforms, we're further restricted in that we can't
    // increase the alignment of any variable which might be emitted
    // into a shared library, and which is exported. If the main
    // executable accesses a variable found in a shared-lib, the main
    // exe actually allocates memory for and exports the symbol ITSELF,
    // overriding the symbol found in the library. That is, at link
    // time, the observed alignment of the variable is copied into the
    // executable binary. (A COPY relocation is also generated, to copy
    // the initial data from the shadowed variable in the shared-lib
    // into the location in the main binary, before running code.)
    //
    // And thus, even though you might think you are defining the
    // global, and allocating the memory for the global in your object
    // file, and thus should be able to set the alignment arbitrarily,
    // that's not actually true. Doing so can cause an ABI breakage; an
    // executable might have already been built with the previous
    // alignment of the variable, and then assuming an increased
    // alignment will be incorrect.
    
    // Conservatively assume ELF if there's no parent pointer.
    boolean isELF = (!(Parent != null) || new Triple(new Twine(Parent.getTargetTriple())).isOSBinFormatELF());
    if (isELF && hasDefaultVisibility() && !hasLocalLinkage()) {
      return false;
    }
    
    return true;
  }

  
  /// This method unlinks 'this' from the containing module, but does not delete
  /// it.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::removeFromParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 497,
   FQN="llvm::GlobalValue::removeFromParent", NM="_ZN4llvm11GlobalValue16removeFromParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue16removeFromParentEv")
  //</editor-fold>
  public abstract /*virtual*/ void removeFromParent()/* = 0*/;

  
  /// This method unlinks 'this' from the containing module and deletes it.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::eraseFromParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 500,
   FQN="llvm::GlobalValue::eraseFromParent", NM="_ZN4llvm11GlobalValue15eraseFromParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue15eraseFromParentEv")
  //</editor-fold>
  public abstract /*virtual*/ void eraseFromParent()/* = 0*/;

  
  /// Get the module that this global value is contained inside of...
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 503,
   FQN="llvm::GlobalValue::getParent", NM="_ZN4llvm11GlobalValue9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue9getParentEv")
  //</editor-fold>
  public Module /*P*/ getParent() {
    return Parent;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 504,
   FQN="llvm::GlobalValue::getParent", NM="_ZNK4llvm11GlobalValue9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalValue9getParentEv")
  //</editor-fold>
  public /*const*/ Module /*P*/ getParent$Const() /*const*/ {
    return Parent;
  }

  
  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalValue::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalValue.h", line = 507,
   FQN="llvm::GlobalValue::classof", NM="_ZN4llvm11GlobalValue7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalValue7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == Value.ValueTy.FunctionVal.getValue()
       || V.getValueID() == Value.ValueTy.GlobalVariableVal.getValue()
       || V.getValueID() == Value.ValueTy.GlobalAliasVal.getValue()
       || V.getValueID() == Value.ValueTy.GlobalIFuncVal.getValue();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected GlobalValue() { /* for sentinels */ }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    if ($isSentinel()) {
      return "Sentinel " + this.getClass().getSimpleName();
    }    
    return "" + "ValueType=" + ValueType // NOI18N
              + ", Linkage=" + $uchar2uint(Linkage) // NOI18N
              + ", Visibility=" + $uchar2uint(Visibility) // NOI18N
              + ", UnnamedAddrVal=" + $uchar2uint(UnnamedAddrVal) // NOI18N
              + ", DllStorageClass=" + $uchar2uint(DllStorageClass) // NOI18N
              + ", ThreadLocal=" + $uchar2uint(ThreadLocal) // NOI18N
              + ", SubClassData=" + SubClassData // NOI18N
              + ", IntID=" + IntID // NOI18N
              + ", Parent=" + Parent // NOI18N
              + super.toString(); // NOI18N
  }
}
