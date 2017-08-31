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

package org.llvm.linker;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.llvm.adt.HashingGlobals.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.linker.*;;
import org.llvm.linker.java.*;
import org.llvm.linker.java.LinkerFunctionPointers.*;
import org.llvm.linker.impl.*;
import org.llvm.llvmc.*;
import org.llvm.transforms.utils.*;

//<editor-fold defaultstate="collapsed" desc="llvm::IRMover">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Linker/IRMover.h", line = 26,
 FQN="llvm::IRMover", NM="_ZN4llvm7IRMoverE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMoverE")
//</editor-fold>
public class IRMover implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::StructTypeKeyInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Linker/IRMover.h", line = 27,
   FQN="llvm::IRMover::StructTypeKeyInfo", NM="_ZN4llvm7IRMover17StructTypeKeyInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover17StructTypeKeyInfoE")
  //</editor-fold>
  private static class/*struct*/ StructTypeKeyInfo implements DenseMapInfo<StructType /*P*/> {
    private static final StructTypeKeyInfo $INFO = new StructTypeKeyInfo();
    protected final Object/*P*/ emptyKey;
    protected final Object/*P*/ tombstoneKey;    

    public StructTypeKeyInfo() {
        this.emptyKey = DenseMapInfo$LikePtr.$Info().getEmptyKey();
        this.tombstoneKey = DenseMapInfo$LikePtr.$Info().getTombstoneKey();
    }
    
    public static StructTypeKeyInfo $Info() {
      return $INFO;
    }
  
    @Override
    public boolean isKeyPointerLike() {
        return true;
    }
    
    //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::StructTypeKeyInfo::KeyTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Linker/IRMover.h", line = 28,
     FQN="llvm::IRMover::StructTypeKeyInfo::KeyTy", NM="_ZN4llvm7IRMover17StructTypeKeyInfo5KeyTyE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover17StructTypeKeyInfo5KeyTyE")
    //</editor-fold>
    public static class/*struct*/ KeyTy implements Native.NativeComparable<KeyTy> {
      public ArrayRef<Type /*P*/ > ETypes;
      public boolean IsPacked;
      //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::StructTypeKeyInfo::KeyTy::KeyTy">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1259,
       FQN="llvm::IRMover::StructTypeKeyInfo::KeyTy::KeyTy", NM="_ZN4llvm7IRMover17StructTypeKeyInfo5KeyTyC1ENS_8ArrayRefIPNS_4TypeEEEb",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover17StructTypeKeyInfo5KeyTyC1ENS_8ArrayRefIPNS_4TypeEEEb")
      //</editor-fold>
      public KeyTy(ArrayRef<Type /*P*/ > E, boolean P) {
        // : ETypes(E), IsPacked(P) 
        //START JInit
        this.ETypes = new ArrayRef<Type /*P*/ >(E);
        this.IsPacked = P;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::StructTypeKeyInfo::KeyTy::KeyTy">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1262,
       FQN="llvm::IRMover::StructTypeKeyInfo::KeyTy::KeyTy", NM="_ZN4llvm7IRMover17StructTypeKeyInfo5KeyTyC1EPKNS_10StructTypeE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover17StructTypeKeyInfo5KeyTyC1EPKNS_10StructTypeE")
      //</editor-fold>
      public KeyTy(/*const*/ StructType /*P*/ ST) {
        // : ETypes(ST->elements()), IsPacked(ST->isPacked()) 
        //START JInit
        this.ETypes = ST.elements();
        this.IsPacked = ST.isPacked();
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::StructTypeKeyInfo::KeyTy::operator==">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1265,
       FQN="llvm::IRMover::StructTypeKeyInfo::KeyTy::operator==", NM="_ZNK4llvm7IRMover17StructTypeKeyInfo5KeyTyeqERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZNK4llvm7IRMover17StructTypeKeyInfo5KeyTyeqERKS2_")
      //</editor-fold>
      public boolean $eq(final /*const*/ KeyTy /*&*/ That) /*const*/ {
        return IsPacked == That.IsPacked && $eq_ArrayRef$T(/*NO_COPY*/ETypes, /*NO_COPY*/That.ETypes);
      }

      //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::StructTypeKeyInfo::KeyTy::operator!=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1269,
       FQN="llvm::IRMover::StructTypeKeyInfo::KeyTy::operator!=", NM="_ZNK4llvm7IRMover17StructTypeKeyInfo5KeyTyneERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZNK4llvm7IRMover17StructTypeKeyInfo5KeyTyneERKS2_")
      //</editor-fold>
      public boolean $noteq(final /*const*/ KeyTy /*&*/ That) /*const*/ {
        return !this.$eq(That);
      }

      
      @Override public String toString() {
        return "" + "ETypes=" + ETypes // NOI18N
                  + ", IsPacked=" + IsPacked; // NOI18N
      }
    };
    //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::StructTypeKeyInfo::getEmptyKey">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1273,
     FQN="llvm::IRMover::StructTypeKeyInfo::getEmptyKey", NM="_ZN4llvm7IRMover17StructTypeKeyInfo11getEmptyKeyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover17StructTypeKeyInfo11getEmptyKeyEv")
    //</editor-fold>
    public Object/*StructType P*/ getEmptyKey() {
      return emptyKey;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::StructTypeKeyInfo::getTombstoneKey">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1277,
     FQN="llvm::IRMover::StructTypeKeyInfo::getTombstoneKey", NM="_ZN4llvm7IRMover17StructTypeKeyInfo15getTombstoneKeyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover17StructTypeKeyInfo15getTombstoneKeyEv")
    //</editor-fold>
    public Object/*StructType P*/ getTombstoneKey() {
      return tombstoneKey;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::StructTypeKeyInfo::getHashValue">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1281,
     FQN="llvm::IRMover::StructTypeKeyInfo::getHashValue", NM="_ZN4llvm7IRMover17StructTypeKeyInfo12getHashValueERKNS1_5KeyTyE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover17StructTypeKeyInfo12getHashValueERKNS1_5KeyTyE")
    //</editor-fold>
    public /*uint*/int getHashValue(final /*const*/ KeyTy /*&*/ Key) {
      return hash_combine(hash_combine_range_ptrs(Key.ETypes.begin(), Key.ETypes.end()), 
          Key.IsPacked).$uint();
    }

    @Override
    public int getHashValueAlt(Object AltKey) {
        return getHashValue((KeyTy)AltKey);
    }
    
    //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::StructTypeKeyInfo::getHashValue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1286,
     FQN="llvm::IRMover::StructTypeKeyInfo::getHashValue", NM="_ZN4llvm7IRMover17StructTypeKeyInfo12getHashValueEPKNS_10StructTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover17StructTypeKeyInfo12getHashValueEPKNS_10StructTypeE")
    //</editor-fold>
    @Override public /*uint*/int getHashValue(/*const*/ StructType /*P*/ ST) {
      return getHashValue(new KeyTy(ST));
    }

    @Override
    public boolean isEqualAlt(Object AltLHS, StructType RHS) {
        return isEqual((KeyTy)AltLHS, RHS);
    }
    
    //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::StructTypeKeyInfo::isEqual">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1290,
     FQN="llvm::IRMover::StructTypeKeyInfo::isEqual", NM="_ZN4llvm7IRMover17StructTypeKeyInfo7isEqualERKNS1_5KeyTyEPKNS_10StructTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover17StructTypeKeyInfo7isEqualERKNS1_5KeyTyEPKNS_10StructTypeE")
    //</editor-fold>
    public boolean isEqual(final /*const*/ KeyTy /*&*/ LHS, 
           /*const*/ StructType /*P*/ RHS) {
      if (RHS == getEmptyKey() || RHS == getTombstoneKey()) {
        return false;
      }
      return LHS.$eq(new KeyTy(RHS));
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::StructTypeKeyInfo::isEqual">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1297,
     FQN="llvm::IRMover::StructTypeKeyInfo::isEqual", NM="_ZN4llvm7IRMover17StructTypeKeyInfo7isEqualEPKNS_10StructTypeES4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover17StructTypeKeyInfo7isEqualEPKNS_10StructTypeES4_")
    //</editor-fold>
    public boolean isEqual(/*const*/ StructType /*P*/ LHS, 
           /*const*/ StructType /*P*/ RHS) {
      if (RHS == getEmptyKey() || RHS == getTombstoneKey()) {
        return LHS == RHS;
      }
      return new KeyTy(LHS).$eq(new KeyTy(RHS));
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  /// Type of the Metadata map in \a ValueToValueMapTy.
  /*typedef DenseMap<const Metadata *, TrackingMDRef> MDMapT*/
//  public final class MDMapT extends DenseMap</*const*/ Metadata /*P*/ , TrackingMDRef>{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::IdentifiedStructTypeSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Linker/IRMover.h", line = 48,
   FQN="llvm::IRMover::IdentifiedStructTypeSet", NM="_ZN4llvm7IRMover23IdentifiedStructTypeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover23IdentifiedStructTypeSetE")
  //</editor-fold>
  public static class IdentifiedStructTypeSet implements Destructors.ClassWithDestructor {
    // The set of opaque types is the composite module.
    private DenseSet<StructType /*P*/ > OpaqueStructTypes;
    
    // The set of identified but non opaque structures in the composite module.
    private DenseSet<StructType /*P*/ > NonOpaqueStructTypes;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::IdentifiedStructTypeSet::addNonOpaque">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1304,
     FQN="llvm::IRMover::IdentifiedStructTypeSet::addNonOpaque", NM="_ZN4llvm7IRMover23IdentifiedStructTypeSet12addNonOpaqueEPNS_10StructTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover23IdentifiedStructTypeSet12addNonOpaqueEPNS_10StructTypeE")
    //</editor-fold>
    public void addNonOpaque(StructType /*P*/ Ty) {
      assert (!Ty.isOpaque());
      NonOpaqueStructTypes.insert(Ty);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::IdentifiedStructTypeSet::switchToNonOpaque">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1309,
     FQN="llvm::IRMover::IdentifiedStructTypeSet::switchToNonOpaque", NM="_ZN4llvm7IRMover23IdentifiedStructTypeSet17switchToNonOpaqueEPNS_10StructTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover23IdentifiedStructTypeSet17switchToNonOpaqueEPNS_10StructTypeE")
    //</editor-fold>
    public void switchToNonOpaque(StructType /*P*/ Ty) {
      assert (!Ty.isOpaque());
      NonOpaqueStructTypes.insert(Ty);
      boolean Removed = OpaqueStructTypes.erase(Ty);
      //JAVA:(void)Removed;
      assert (Removed);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::IdentifiedStructTypeSet::addOpaque">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1317,
     FQN="llvm::IRMover::IdentifiedStructTypeSet::addOpaque", NM="_ZN4llvm7IRMover23IdentifiedStructTypeSet9addOpaqueEPNS_10StructTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover23IdentifiedStructTypeSet9addOpaqueEPNS_10StructTypeE")
    //</editor-fold>
    public void addOpaque(StructType /*P*/ Ty) {
      assert (Ty.isOpaque());
      OpaqueStructTypes.insert(Ty);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::IdentifiedStructTypeSet::findNonOpaque">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1322,
     FQN="llvm::IRMover::IdentifiedStructTypeSet::findNonOpaque", NM="_ZN4llvm7IRMover23IdentifiedStructTypeSet13findNonOpaqueENS_8ArrayRefIPNS_4TypeEEEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover23IdentifiedStructTypeSet13findNonOpaqueENS_8ArrayRefIPNS_4TypeEEEb")
    //</editor-fold>
    public StructType /*P*/ findNonOpaque(ArrayRef<Type /*P*/ > ETypes, 
                 boolean IsPacked) {
      IRMover.StructTypeKeyInfo.KeyTy Key/*J*/= new IRMover.StructTypeKeyInfo.KeyTy(new ArrayRef<Type /*P*/ >(ETypes), IsPacked);
      DenseSet.iterator<StructType /*P*/> I = NonOpaqueStructTypes.find_as_T$C$R(Key);
      return I.$eq(NonOpaqueStructTypes.end()) ? null : I.$star();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::IdentifiedStructTypeSet::hasType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1330,
     FQN="llvm::IRMover::IdentifiedStructTypeSet::hasType", NM="_ZN4llvm7IRMover23IdentifiedStructTypeSet7hasTypeEPNS_10StructTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover23IdentifiedStructTypeSet7hasTypeEPNS_10StructTypeE")
    //</editor-fold>
    public boolean hasType(StructType /*P*/ Ty) {
      if (Ty.isOpaque()) {
        return (OpaqueStructTypes.count(Ty) != 0);
      }
      DenseSet.iterator<StructType /*P*/> I = NonOpaqueStructTypes.find(Ty);
      return I.$eq(NonOpaqueStructTypes.end()) ? false : I.$star() == Ty;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::IdentifiedStructTypeSet::~IdentifiedStructTypeSet">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Linker/IRMover.h", line = 48,
     FQN="llvm::IRMover::IdentifiedStructTypeSet::~IdentifiedStructTypeSet", NM="_ZN4llvm7IRMover23IdentifiedStructTypeSetD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover23IdentifiedStructTypeSetD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      NonOpaqueStructTypes.$destroy();
      OpaqueStructTypes.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::IdentifiedStructTypeSet::IdentifiedStructTypeSet">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Linker/IRMover.h", line = 48,
     FQN="llvm::IRMover::IdentifiedStructTypeSet::IdentifiedStructTypeSet", NM="_ZN4llvm7IRMover23IdentifiedStructTypeSetC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover23IdentifiedStructTypeSetC1Ev")
    //</editor-fold>
    public /*inline*/ IdentifiedStructTypeSet() {
      // : OpaqueStructTypes(), NonOpaqueStructTypes() 
      //START JInit
      this.OpaqueStructTypes = new DenseSet<StructType /*P*/ >(DenseMapInfo$LikePtr.$Info());
      this.NonOpaqueStructTypes = new DenseSet<StructType /*P*/ >(StructTypeKeyInfo.$Info());
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "OpaqueStructTypes=" + OpaqueStructTypes // NOI18N
                + ", NonOpaqueStructTypes=" + NonOpaqueStructTypes; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::IRMover">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1337,
   FQN="llvm::IRMover::IRMover", NM="_ZN4llvm7IRMoverC1ERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMoverC1ERNS_6ModuleE")
  //</editor-fold>
  public IRMover(final Module /*&*/ M) {
    // : Composite(M), IdentifiedStructTypes(), SharedMDs() 
    //START JInit
    this./*&*/Composite=/*&*/M;
    this.IdentifiedStructTypes = new IdentifiedStructTypeSet();
    this.SharedMDs = new DenseMap</*const*/ Metadata /*P*/ , TrackingMDRef>(DenseMapInfo$LikePtr.$Info(), new TrackingMDRef());
    //END JInit
    TypeFinder StructTypes = null;
    try {
      StructTypes/*J*/= new TypeFinder();
      StructTypes.run(M, true);
      for (StructType /*P*/ Ty : StructTypes) {
        if (Ty.isOpaque()) {
          IdentifiedStructTypes.addOpaque(Ty);
        } else {
          IdentifiedStructTypes.addNonOpaque(Ty);
        }
      }
    } finally {
      if (StructTypes != null) { StructTypes.$destroy(); }
    }
  }

  
  /*typedef std::function<void (GlobalValue &)> ValueAdder*/
//  public final class ValueAdder extends ValueAdder{ };
  
  /// Move in the provide values in \p ValuesToLink from \p Src.
  ///
  /// - \p AddLazyFor is a call back that the IRMover will call when a global
  ///   value is referenced by one of the ValuesToLink (transitively) but was
  ///   not present in ValuesToLink. The GlobalValue and a ValueAdder callback
  ///   are passed as an argument, and the callback is expected to be called
  ///   if the GlobalValue needs to be added to the \p ValuesToLink and linked.
  //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::move">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 1348,
   FQN="llvm::IRMover::move", NM="_ZN4llvm7IRMover4moveESt10unique_ptrINS_6ModuleESt14default_deleteIS2_EENS_8ArrayRefIPNS_11GlobalValueEEESt8functionIFvRS7_SA_IFvSB_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover4moveESt10unique_ptrINS_6ModuleESt14default_deleteIS2_EENS_8ArrayRefIPNS_11GlobalValueEEESt8functionIFvRS7_SA_IFvSB_EEEE")
  //</editor-fold>
  public Error move(std.unique_ptr<Module> Src, ArrayRef<GlobalValue /*P*/ > ValuesToLink, 
      GlobalValueValueAdder2Void AddLazyFor) {
    IRLinker TheIRLinker = null;
    Error E = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      TheIRLinker/*J*/= $c$.clean(new IRLinker(Composite, SharedMDs, IdentifiedStructTypes, 
          $c$.track(new std.unique_ptr<Module>(JD$Move.INSTANCE, std.move(Src))), new ArrayRef<GlobalValue /*P*/ >(ValuesToLink), AddLazyFor));
      E = TheIRLinker.run();
      Composite.dropTriviallyDeadConstantArrays();
      return new Error(JD$Move.INSTANCE, E);
    } finally {
      if (E != null) { E.$destroy(); }
      if (TheIRLinker != null) { TheIRLinker.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Linker/IRMover.h", line = 76,
   FQN="llvm::IRMover::getModule", NM="_ZN4llvm7IRMover9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm7IRMover9getModuleEv")
  //</editor-fold>
  public Module /*&*/ getModule() {
    return Composite;
  }

/*private:*/
  private final Module /*&*/ Composite;
  private IdentifiedStructTypeSet IdentifiedStructTypes;
  private DenseMap</*const*/ Metadata /*P*/ , TrackingMDRef> SharedMDs; ///< A Metadata map to use for all calls to \a move().
  //<editor-fold defaultstate="collapsed" desc="llvm::IRMover::~IRMover">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Linker/IRMover.h", line = 26,
   FQN="llvm::IRMover::~IRMover", NM="_ZN4llvm7IRMoverD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm7IRMoverD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    SharedMDs.$destroy();
    IdentifiedStructTypes.$destroy();
    //END JDestroy
  }


  
  @Override public String toString() {
    return "" + "Composite=" + Composite // NOI18N
              + ", IdentifiedStructTypes=" + IdentifiedStructTypes // NOI18N
              + ", SharedMDs=" + SharedMDs; // NOI18N
  }
}
