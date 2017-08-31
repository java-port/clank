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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.ilist_node;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="llvm::AliasSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 37,
 FQN="llvm::AliasSet", NM="_ZN4llvm8AliasSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSetE")
//</editor-fold>
public class AliasSet implements /*public*/ ilist_node<AliasSet>, Destructors.ClassWithDestructor {
  /*friend  class AliasSetTracker*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::PointerRec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 40,
   FQN="llvm::AliasSet::PointerRec", NM="_ZN4llvm8AliasSet10PointerRecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet10PointerRecE")
  //</editor-fold>
  /*friend*/public/*private*/ static class PointerRec {
    private Value /*P*/ Val; // The pointer this record corresponds to.
    private type$ptr<PointerRec /*P*/ /*P*/> PrevInList;
    private PointerRec /*P*/ NextInList;
    private AliasSet /*P*/ AS;
    private long/*uint64_t*/ Size;
    private AAMDNodes AAInfo;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::PointerRec::PointerRec">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 48,
     FQN="llvm::AliasSet::PointerRec::PointerRec", NM="_ZN4llvm8AliasSet10PointerRecC1EPNS_5ValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet10PointerRecC1EPNS_5ValueE")
    //</editor-fold>
    public PointerRec(Value /*P*/ V) {
      // : Val(V), PrevInList(null), NextInList(null), AS(null), Size(0), AAInfo(DenseMapInfo<AAMDNodes>::getEmptyKey()) 
      //START JInit
      this.Val = V;
      this.PrevInList = null;
      this.NextInList = null;
      this.AS = null;
      this.Size = $int2ulong(0);
      this.AAInfo = (AAMDNodes) DenseMapInfoAAMDNodes.$Info().getEmptyKey();
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::PointerRec::getValue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 52,
     FQN="llvm::AliasSet::PointerRec::getValue", NM="_ZNK4llvm8AliasSet10PointerRec8getValueEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet10PointerRec8getValueEv")
    //</editor-fold>
    public Value /*P*/ getValue() /*const*/ {
      return Val;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::PointerRec::getNext">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 54,
     FQN="llvm::AliasSet::PointerRec::getNext", NM="_ZNK4llvm8AliasSet10PointerRec7getNextEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet10PointerRec7getNextEv")
    //</editor-fold>
    public PointerRec /*P*/ getNext() /*const*/ {
      return NextInList;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::PointerRec::hasAliasSet">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 55,
     FQN="llvm::AliasSet::PointerRec::hasAliasSet", NM="_ZNK4llvm8AliasSet10PointerRec11hasAliasSetEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet10PointerRec11hasAliasSetEv")
    //</editor-fold>
    public boolean hasAliasSet() /*const*/ {
      return AS != null;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::PointerRec::setPrevInList">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 57,
     FQN="llvm::AliasSet::PointerRec::setPrevInList", NM="_ZN4llvm8AliasSet10PointerRec13setPrevInListEPPS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet10PointerRec13setPrevInListEPPS1_")
    //</editor-fold>
    public type$ptr<PointerRec /*P*/ /*P*/> setPrevInList(type$ptr<PointerRec /*P*/ /*P*/> PIL) {
      PrevInList = $tryClone(PIL);
      return $AddrOf(create_type$ptr2ConstT(NextInList));
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::PointerRec::updateSizeAndAAInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 62,
     FQN="llvm::AliasSet::PointerRec::updateSizeAndAAInfo", NM="_ZN4llvm8AliasSet10PointerRec19updateSizeAndAAInfoEyRKNS_9AAMDNodesE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet10PointerRec19updateSizeAndAAInfoEyRKNS_9AAMDNodesE")
    //</editor-fold>
    public boolean updateSizeAndAAInfo(long/*uint64_t*/ NewSize, final /*const*/ AAMDNodes /*&*/ NewAAInfo) {
      boolean SizeChanged = false;
      if ($greater_ulong(NewSize, Size)) {
        Size = NewSize;
        SizeChanged = true;
      }
      if (AAInfo.$eq((AAMDNodes)DenseMapInfoAAMDNodes.$Info().getEmptyKey())) {
        // We don't have a AAInfo yet. Set it to NewAAInfo.
        AAInfo.$assign(NewAAInfo);
      } else if (AAInfo.$noteq(NewAAInfo)) {
        // NewAAInfo conflicts with AAInfo.
        AAInfo.$assignMove((AAMDNodes)DenseMapInfoAAMDNodes.$Info().getTombstoneKey());
      }
      
      return SizeChanged;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::PointerRec::getSize">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 79,
     FQN="llvm::AliasSet::PointerRec::getSize", NM="_ZNK4llvm8AliasSet10PointerRec7getSizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet10PointerRec7getSizeEv")
    //</editor-fold>
    public long/*uint64_t*/ getSize() /*const*/ {
      return Size;
    }

    
    /// Return the AAInfo, or null if there is no information or conflicting
    /// information.
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::PointerRec::getAAInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 83,
     FQN="llvm::AliasSet::PointerRec::getAAInfo", NM="_ZNK4llvm8AliasSet10PointerRec9getAAInfoEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet10PointerRec9getAAInfoEv")
    //</editor-fold>
    public AAMDNodes getAAInfo() /*const*/ {
      // If we have missing or conflicting AAInfo, return null.
      if (AAInfo.$eq((AAMDNodes)DenseMapInfoAAMDNodes.$Info().getEmptyKey())
         || AAInfo.$eq((AAMDNodes)DenseMapInfoAAMDNodes.$Info().getTombstoneKey())) {
        return new AAMDNodes();
      }
      return new AAMDNodes(AAInfo);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::PointerRec::getAliasSet">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 91,
     FQN="llvm::AliasSet::PointerRec::getAliasSet", NM="_ZN4llvm8AliasSet10PointerRec11getAliasSetERNS_15AliasSetTrackerE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet10PointerRec11getAliasSetERNS_15AliasSetTrackerE")
    //</editor-fold>
    public AliasSet /*P*/ getAliasSet(final AliasSetTracker /*&*/ AST) {
      assert ((AS != null)) : "No AliasSet yet!";
      if ((AS.Forward != null)) {
        AliasSet /*P*/ OldAS = AS;
        AS = OldAS.getForwardedTarget(AST);
        AS.addRef();
        OldAS.dropRef(AST);
      }
      return AS;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::PointerRec::setAliasSet">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 102,
     FQN="llvm::AliasSet::PointerRec::setAliasSet", NM="_ZN4llvm8AliasSet10PointerRec11setAliasSetEPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet10PointerRec11setAliasSetEPS0_")
    //</editor-fold>
    public void setAliasSet(AliasSet /*P*/ as) {
      assert (!(AS != null)) : "Already have an alias set!";
      AS = as;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::PointerRec::eraseFromList">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 107,
     FQN="llvm::AliasSet::PointerRec::eraseFromList", NM="_ZN4llvm8AliasSet10PointerRec13eraseFromListEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet10PointerRec13eraseFromListEv")
    //</editor-fold>
    public void eraseFromList() {
      if ((NextInList != null)) {
        NextInList.PrevInList = $tryClone(PrevInList);
      }
      PrevInList.$set(NextInList);
      if ($eq_ptr(AS.PtrListEnd, $AddrOf(create_type$ptr2ConstT(NextInList)))) {
        AS.PtrListEnd = $tryClone(PrevInList);
        assert (AS.PtrListEnd.$star() == null) : "List not terminated right!";
      }
      /*delete*/Destructors.$destroy(this);
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::PointerRec::PointerRec">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 40,
     FQN="llvm::AliasSet::PointerRec::PointerRec", NM="_ZN4llvm8AliasSet10PointerRecC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm8AliasSet10PointerRecC1ERKS1_")
    //</editor-fold>
    public /*inline*/ PointerRec(final /*const*/ PointerRec /*&*/ $Prm0) {
      // : Val(.Val), PrevInList(.PrevInList), NextInList(.NextInList), AS(.AS), Size(.Size), AAInfo(.AAInfo) 
      //START JInit
      this.Val = $Prm0.Val;
      this.PrevInList = $tryClone($Prm0.PrevInList);
      this.NextInList = $Prm0.NextInList;
      this.AS = $Prm0.AS;
      this.Size = $Prm0.Size;
      this.AAInfo = new AAMDNodes($Prm0.AAInfo);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Val=" + Val // NOI18N
                + ", PrevInList=" + PrevInList // NOI18N
                + ", NextInList=" + NextInList // NOI18N
                + ", AS=" + AS // NOI18N
                + ", Size=" + Size // NOI18N
                + ", AAInfo=" + AAInfo; // NOI18N
    }
  };
  
  /*friend*/public PointerRec /*P*/ PtrList;
  
  private type$ptr<PointerRec /*P*/ /*P*/> PtrListEnd; // Doubly linked list of nodes.
  /*friend*/public AliasSet /*P*/ Forward; // Forwarding pointer.
  
  /// All instructions without a specific address in this alias set.
  /*friend*/public std.vector<AssertingVH<Instruction>> UnknownInsts;
  
  /// Number of nodes pointing to this AliasSet plus the number of AliasSets
  /// forwarding to it.
  /*friend*/public /*uint*/int RefCount /*: 28*/;
  
  /// The kinds of access this alias set models.
  ///
  /// We keep track of whether this alias set merely refers to the locations of
  /// memory (and not any particular access), whether it modifies or references
  /// the memory, or whether it does both. The lattice goes from "NoAccess" to
  /// either RefAccess or ModAccess, then to ModRefAccess as necessary.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::AccessLattice">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 134,
   FQN="llvm::AliasSet::AccessLattice", NM="_ZN4llvm8AliasSet13AccessLatticeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet13AccessLatticeE")
  //</editor-fold>
  /*friend*/public/*private*/ enum AccessLattice implements Native.NativeUIntEnum {
    NoAccess(0),
    RefAccess(1),
    ModAccess(2),
    ModRefAccess(AccessLattice.RefAccess.getValue() | AccessLattice.ModAccess.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AccessLattice valueOf(int val) {
      AccessLattice out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AccessLattice[] VALUES;
      private static final AccessLattice[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AccessLattice kind : AccessLattice.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AccessLattice[min < 0 ? (1-min) : 0];
        VALUES = new AccessLattice[max >= 0 ? (1+max) : 0];
        for (AccessLattice kind : AccessLattice.values()) {
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
    private AccessLattice(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  /*friend*/public /*JBYTE unsigned int*/ byte Access /*: 2*/;
  
  /// The kind of alias relationship between pointers of the set.
  ///
  /// These represent conservatively correct alias results between any members
  /// of the set. We represent these independently of the values of alias
  /// results in order to pack it into a single bit. Lattice goes from
  /// MustAlias to MayAlias.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::AliasLattice">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 148,
   FQN="llvm::AliasSet::AliasLattice", NM="_ZN4llvm8AliasSet12AliasLatticeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet12AliasLatticeE")
  //</editor-fold>
  private enum AliasLattice implements Native.NativeUIntEnum {
    SetMustAlias(0),
    SetMayAlias(1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AliasLattice valueOf(int val) {
      AliasLattice out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AliasLattice[] VALUES;
      private static final AliasLattice[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AliasLattice kind : AliasLattice.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AliasLattice[min < 0 ? (1-min) : 0];
        VALUES = new AliasLattice[max >= 0 ? (1+max) : 0];
        for (AliasLattice kind : AliasLattice.values()) {
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
    private AliasLattice(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  private /*JBIT unsigned int*/ boolean Alias /*: 1*/;
  
  /// True if this alias set contains volatile loads or stores.
  private /*JBIT unsigned int*/ boolean Volatile /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::addRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 156,
   FQN="llvm::AliasSet::addRef", NM="_ZN4llvm8AliasSet6addRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet6addRefEv")
  //</editor-fold>
  private void addRef() {
    ++RefCount;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::dropRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 157,
   FQN="llvm::AliasSet::dropRef", NM="_ZN4llvm8AliasSet7dropRefERNS_15AliasSetTrackerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet7dropRefERNS_15AliasSetTrackerE")
  //</editor-fold>
  /*friend*/public void dropRef(final AliasSetTracker /*&*/ AST) {
    assert (RefCount >= 1) : "Invalid reference count detected!";
    if (--RefCount == 0) {
      removeFromTracker(AST);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::getUnknownInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 163,
   FQN="llvm::AliasSet::getUnknownInst", NM="_ZNK4llvm8AliasSet14getUnknownInstEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet14getUnknownInstEj")
  //</editor-fold>
  private Instruction /*P*/ getUnknownInst(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, UnknownInsts.size()));
    return UnknownInsts.$at$Const(i).$T$P();
  }

/*public:*/
  /// Accessors...
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::isRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 170,
   FQN="llvm::AliasSet::isRef", NM="_ZNK4llvm8AliasSet5isRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet5isRefEv")
  //</editor-fold>
  public boolean isRef() /*const*/ {
    return (($2bits_uint2uint(Access) & AccessLattice.RefAccess.getValue()) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::isMod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 171,
   FQN="llvm::AliasSet::isMod", NM="_ZNK4llvm8AliasSet5isModEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet5isModEv")
  //</editor-fold>
  public boolean isMod() /*const*/ {
    return (($2bits_uint2uint(Access) & AccessLattice.ModAccess.getValue()) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::isMustAlias">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 172,
   FQN="llvm::AliasSet::isMustAlias", NM="_ZNK4llvm8AliasSet11isMustAliasEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet11isMustAliasEv")
  //</editor-fold>
  public boolean isMustAlias() /*const*/ {
    return (Alias ? 1:0) == AliasLattice.SetMustAlias.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::isMayAlias">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 173,
   FQN="llvm::AliasSet::isMayAlias", NM="_ZNK4llvm8AliasSet10isMayAliasEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet10isMayAliasEv")
  //</editor-fold>
  public boolean isMayAlias() /*const*/ {
    return (Alias ? 1:0) == AliasLattice.SetMayAlias.getValue();
  }

  
  /// Return true if this alias set contains volatile loads or stores.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::isVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 176,
   FQN="llvm::AliasSet::isVolatile", NM="_ZNK4llvm8AliasSet10isVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet10isVolatileEv")
  //</editor-fold>
  public boolean isVolatile() /*const*/ {
    return Volatile;
  }

  
  /// Return true if this alias set should be ignored as part of the
  /// AliasSetTracker object.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::isForwardingAliasSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 180,
   FQN="llvm::AliasSet::isForwardingAliasSet", NM="_ZNK4llvm8AliasSet20isForwardingAliasSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet20isForwardingAliasSetEv")
  //</editor-fold>
  public boolean isForwardingAliasSet() /*const*/ {
    return (Forward != null);
  }

  
  /// Merge the specified alias set into this alias set.
  
  /// mergeSetIn - Merge the specified alias set into this alias set.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::mergeSetIn">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 31,
   FQN="llvm::AliasSet::mergeSetIn", NM="_ZN4llvm8AliasSet10mergeSetInERS0_RNS_15AliasSetTrackerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet10mergeSetInERS0_RNS_15AliasSetTrackerE")
  //</editor-fold>
  public void mergeSetIn(final AliasSet /*&*/ AS, final AliasSetTracker /*&*/ AST) {
    assert (!(AS.Forward != null)) : "Alias set is already forwarding!";
    assert (!(Forward != null)) : "This set is a forwarding set!!";
    
    // Update the alias and access types of this set...
    Access |= $int2uint_2bits($2bits_uint2uint(AS.Access));
    Alias |= AS.Alias;
    Volatile |= AS.Volatile;
    if ((Alias ? 1:0) == AliasLattice.SetMustAlias.getValue()) {
      // Check that these two merged sets really are must aliases.  Since both
      // used to be must-alias sets, we can just check any pointer from each set
      // for aliasing.
      final AAResults /*&*/ AA = AST.getAliasAnalysis();
      PointerRec /*P*/ L = getSomePointer();
      PointerRec /*P*/ R = AS.getSomePointer();
      
      // If the pointers are not a must-alias pair, this set becomes a may alias.
      if (AA.alias(new MemoryLocation(L.getValue(), L.getSize(), L.getAAInfo()), 
          new MemoryLocation(R.getValue(), R.getSize(), R.getAAInfo()))
         != AliasResult.MustAlias) {
        Alias = $uint2uint_1bit(AliasLattice.SetMayAlias.getValue());
      }
    }
    
    boolean ASHadUnknownInsts = !AS.UnknownInsts.empty();
    if (UnknownInsts.empty()) { // Merge call sites...
      if (ASHadUnknownInsts) {
        std.swap(UnknownInsts, AS.UnknownInsts);
        addRef();
      }
    } else if (ASHadUnknownInsts) {
      UnknownInsts.insert$T(new std.vector.iterator</*const*/ AssertingVH<Instruction> /*P*/ >(UnknownInsts.end()), AS.UnknownInsts.begin(), AS.UnknownInsts.end());
      AS.UnknownInsts.clear();
    }
    
    AS.Forward = this; // Forward across AS now...
    addRef(); // AS is now pointing to us...
    
    // Merge the list of constituent pointers...
    if ((AS.PtrList != null)) {
      PtrListEnd.$set(AS.PtrList);
      AS.PtrList.setPrevInList(PtrListEnd);
      PtrListEnd = $tryClone(AS.PtrListEnd);
      
      AS.PtrList = null;
      AS.PtrListEnd = $tryClone($AddrOf(create_type$ptr2ConstT(AS.PtrList)));
      assert (AS.PtrListEnd.$star() == null) : "End of list is not null?";
    }
    if (ASHadUnknownInsts) {
      AS.dropRef(AST);
    }
  }

  
  // Alias Set iteration - Allow access to all of the pointers which are part of
  // this alias set.
  
  /// Define an iterator for alias sets... this is just a forward iterator.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 196,
   FQN="llvm::AliasSet::iterator", NM="_ZN4llvm8AliasSet8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet8iteratorE")
  //</editor-fold>
  public static class iterator implements /*public*/ std.iterator<std.input_iterator_tag, PointerRec>, Native.NativeComparable<iterator> {
    private PointerRec /*P*/ CurNode;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 201,
     FQN="llvm::AliasSet::iterator::iterator", NM="_ZN4llvm8AliasSet8iteratorC1EPNS0_10PointerRecE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet8iteratorC1EPNS0_10PointerRecE")
    //</editor-fold>
    public /*explicit*/ iterator() {
      this((PointerRec /*P*/ )null);
    }
    public /*explicit*/ iterator(PointerRec /*P*/ CN/*= null*/) {
      // : std::iterator<std::forward_iterator_tag, PointerRec, ptrdiff_t>(), CurNode(CN) 
      //START JInit
      $iterator();
      this.CurNode = CN;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 203,
     FQN="llvm::AliasSet::iterator::operator==", NM="_ZNK4llvm8AliasSet8iteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet8iteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ iterator /*&*/ x) /*const*/ {
      return CurNode == x.CurNode;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 206,
     FQN="llvm::AliasSet::iterator::operator!=", NM="_ZNK4llvm8AliasSet8iteratorneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet8iteratorneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ iterator /*&*/ x) /*const*/ {
      return !$eq(x);
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 208,
     FQN="llvm::AliasSet::iterator::operator*", NM="_ZNK4llvm8AliasSet8iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet8iteratordeEv")
    //</editor-fold>
    public PointerRec /*&*/ $star() /*const*/ {
      assert ((CurNode != null)) : "Dereferencing AliasSet.end()!";
      return $Deref(CurNode);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 212,
     FQN="llvm::AliasSet::iterator::operator->", NM="_ZNK4llvm8AliasSet8iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet8iteratorptEv")
    //</editor-fold>
    public PointerRec /*P*/ $arrow() /*const*/ {
      return $AddrOf($star());
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::iterator::getPointer">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 214,
     FQN="llvm::AliasSet::iterator::getPointer", NM="_ZNK4llvm8AliasSet8iterator10getPointerEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet8iterator10getPointerEv")
    //</editor-fold>
    public Value /*P*/ getPointer() /*const*/ {
      return CurNode.getValue();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::iterator::getSize">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 215,
     FQN="llvm::AliasSet::iterator::getSize", NM="_ZNK4llvm8AliasSet8iterator7getSizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet8iterator7getSizeEv")
    //</editor-fold>
    public long/*uint64_t*/ getSize() /*const*/ {
      return CurNode.getSize();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::iterator::getAAInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 216,
     FQN="llvm::AliasSet::iterator::getAAInfo", NM="_ZNK4llvm8AliasSet8iterator9getAAInfoEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet8iterator9getAAInfoEv")
    //</editor-fold>
    public AAMDNodes getAAInfo() /*const*/ {
      return CurNode.getAAInfo();
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 218,
     FQN="llvm::AliasSet::iterator::operator++", NM="_ZN4llvm8AliasSet8iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet8iteratorppEv")
    //</editor-fold>
    public iterator /*&*/ $preInc() {
      // Preincrement
      assert ((CurNode != null)) : "Advancing past AliasSet.end()!";
      CurNode = CurNode.getNext();
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 223,
     FQN="llvm::AliasSet::iterator::operator++", NM="_ZN4llvm8AliasSet8iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet8iteratorppEi")
    //</editor-fold>
    public iterator $postInc(int $Prm0) {
      // Postincrement
      iterator tmp = new iterator(/*Deref*/this);
      /*Deref*/this.$preInc();
      return tmp;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 196,
     FQN="llvm::AliasSet::iterator::iterator", NM="_ZN4llvm8AliasSet8iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet8iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ iterator(final /*const*/ iterator /*&*/ $Prm0) {
      // : std::iterator<std::forward_iterator_tag, PointerRec, ptrdiff_t>(), CurNode(.CurNode) 
      //START JInit
      $iterator($Prm0);
      this.CurNode = $Prm0.CurNode;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 196,
     FQN="llvm::AliasSet::iterator::iterator", NM="_ZN4llvm8AliasSet8iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet8iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ iterator(JD$Move _dparam, final iterator /*&&*/$Prm0) {
      // : std::iterator<std::forward_iterator_tag, PointerRec, ptrdiff_t>(static_cast<iterator &&>()), CurNode(static_cast<iterator &&>().CurNode) 
      //START JInit
      $iterator(JD$Move.INSTANCE, $Prm0);
      this.CurNode = $Prm0.CurNode;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "CurNode=" + CurNode // NOI18N
                + super.toString(); // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 188,
   FQN="llvm::AliasSet::begin", NM="_ZNK4llvm8AliasSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet5beginEv")
  //</editor-fold>
  public iterator begin() /*const*/ {
    return new iterator(PtrList);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 189,
   FQN="llvm::AliasSet::end", NM="_ZNK4llvm8AliasSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet3endEv")
  //</editor-fold>
  public iterator end() /*const*/ {
    return new iterator();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 190,
   FQN="llvm::AliasSet::empty", NM="_ZNK4llvm8AliasSet5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return PtrList == null;
  }

  
  
  //===----------------------------------------------------------------------===//
  //               AliasSet/AliasSetTracker Printing Support
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::print">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 614,
   FQN="llvm::AliasSet::print", NM="_ZNK4llvm8AliasSet5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    OS.$out(/*KEEP_STR*/"  AliasSet[").$out(reinterpret_cast(/*const*/Object/*void P*/ .class, this)).$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(RefCount).$out(/*KEEP_STR*/"] ");
    OS.$out(((Alias ? 1:0) == AliasLattice.SetMustAlias.getValue() ? $("must") : $("may"))).$out(/*KEEP_STR*/" alias, ");
    switch (AliasSet.AccessLattice.valueOf($2bits_uint2uint(Access))) {
     case NoAccess:
      OS.$out(/*KEEP_STR*/"No access ");
      break;
     case RefAccess:
      OS.$out(/*KEEP_STR*/"Ref       ");
      break;
     case ModAccess:
      OS.$out(/*KEEP_STR*/"Mod       ");
      break;
     case ModRefAccess:
      OS.$out(/*KEEP_STR*/"Mod/Ref   ");
      break;
     default:
      throw new llvm_unreachable("Bad value for Access!");
    }
    if (isVolatile()) {
      OS.$out(/*KEEP_STR*/"[volatile] ");
    }
    if ((Forward != null)) {
      OS.$out(/*KEEP_STR*/" forwarding to ").$out(reinterpret_cast(Object/*void P*/ .class, Forward));
    }
    if (!empty()) {
      OS.$out(/*KEEP_STR*/"Pointers: ");
      for (iterator I = begin(), E = end(); I.$noteq(E); I.$preInc()) {
        if (I.$noteq(begin())) {
          OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        I.getPointer().printAsOperand(OS.$out(/*KEEP_STR*/$LPAREN));
        OS.$out(/*KEEP_STR*/$COMMA_SPACE).$out_ullong(I.getSize()).$out(/*KEEP_STR*/$RPAREN);
      }
    }
    if (!UnknownInsts.empty()) {
      OS.$out(/*KEEP_STR*/"\n    ").$out_uint(UnknownInsts.size()).$out(/*KEEP_STR*/" Unknown instructions: ");
      for (/*uint*/int i = 0, e = UnknownInsts.size(); i != e; ++i) {
        if ((i != 0)) {
          OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        UnknownInsts.$at$Const(i).$arrow_AssertingVH().printAsOperand(OS);
      }
    }
    OS.$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 656,
   FQN="llvm::AliasSet::dump", NM="_ZNK4llvm8AliasSet4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs());
  }

  ;
/*private:*/
  // Can only be created by AliasSetTracker. Also, ilist creates one
  // to serve as a sentinel.
  /*friend  struct ilist_sentinel_traits<AliasSet>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::AliasSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 232,
   FQN="llvm::AliasSet::AliasSet", NM="_ZN4llvm8AliasSetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSetC1Ev")
  //</editor-fold>
  /*friend*/public AliasSet() {
    // : ilist_node<AliasSet>(), PtrList(null), PtrListEnd(&PtrList), Forward(null), UnknownInsts(), RefCount(0), Access(NoAccess), Alias(SetMustAlias), Volatile(false) 
    //START JInit
    this.ilist_node$Flds = $ilist_node();
    this.PtrList = null;
    this.PtrListEnd = $tryClone($AddrOf(create_type$ptr2ConstT(PtrList)));
    this.Forward = null;
    this.UnknownInsts = new std.vector<AssertingVH<Instruction>>(new AssertingVH<Instruction>());
    this.RefCount = 0;
    this.Access = $uint2uint_2bits(AccessLattice.NoAccess.getValue());
    this.Alias = $uint2uint_1bit(AliasLattice.SetMustAlias.getValue());
    this.Volatile = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::AliasSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 237,
   FQN="llvm::AliasSet::AliasSet", NM="_ZN4llvm8AliasSetC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSetC1ERKS0_")
  //</editor-fold>
  protected/*private*/ AliasSet(final /*const*/ AliasSet /*&*/ AS) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 238,
   FQN="llvm::AliasSet::operator=", NM="_ZN4llvm8AliasSetaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSetaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ AliasSet /*&*/ AS) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::getSomePointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 240,
   FQN="llvm::AliasSet::getSomePointer", NM="_ZNK4llvm8AliasSet14getSomePointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet14getSomePointerEv")
  //</editor-fold>
  private PointerRec /*P*/ getSomePointer() /*const*/ {
    return PtrList;
  }

  
  /// Return the real alias set this represents. If this has been merged with
  /// another set and is forwarding, return the ultimate destination set. This
  /// also implements the union-find collapsing as well.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::getForwardedTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 247,
   FQN="llvm::AliasSet::getForwardedTarget", NM="_ZN4llvm8AliasSet18getForwardedTargetERNS_15AliasSetTrackerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet18getForwardedTargetERNS_15AliasSetTrackerE")
  //</editor-fold>
  /*friend*/public AliasSet /*P*/ getForwardedTarget(final AliasSetTracker /*&*/ AST) {
    if (!(Forward != null)) {
      return this;
    }
    
    AliasSet /*P*/ Dest = Forward.getForwardedTarget(AST);
    if (Dest != Forward) {
      Dest.addRef();
      Forward.dropRef(AST);
      Forward = Dest;
    }
    return Dest;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::removeFromTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 91,
   FQN="llvm::AliasSet::removeFromTracker", NM="_ZN4llvm8AliasSet17removeFromTrackerERNS_15AliasSetTrackerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet17removeFromTrackerERNS_15AliasSetTrackerE")
  //</editor-fold>
  /*friend*/public void removeFromTracker(final AliasSetTracker /*&*/ AST) {
    assert (RefCount == 0) : "Cannot remove non-dead alias set from tracker!";
    AST.removeAliasSet(this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::addPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 96,
   FQN="llvm::AliasSet::addPointer", NM="_ZN4llvm8AliasSet10addPointerERNS_15AliasSetTrackerERNS0_10PointerRecEyRKNS_9AAMDNodesEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet10addPointerERNS_15AliasSetTrackerERNS0_10PointerRecEyRKNS_9AAMDNodesEb")
  //</editor-fold>
  /*friend*/public void addPointer(final AliasSetTracker /*&*/ AST, final PointerRec /*&*/ Entry, 
            long/*uint64_t*/ Size, final /*const*/ AAMDNodes /*&*/ AAInfo) {
    addPointer(AST, Entry, 
            Size, AAInfo, 
            false);
  }
  /*friend*/public void addPointer(final AliasSetTracker /*&*/ AST, final PointerRec /*&*/ Entry, 
            long/*uint64_t*/ Size, final /*const*/ AAMDNodes /*&*/ AAInfo, 
            boolean KnownMustAlias/*= false*/) {
    assert (!Entry.hasAliasSet()) : "Entry already in set!";
    
    // Check to see if we have to downgrade to _may_ alias.
    if (isMustAlias() && !KnownMustAlias) {
      {
        PointerRec /*P*/ P = getSomePointer();
        if ((P != null)) {
          final AAResults /*&*/ AA = AST.getAliasAnalysis();
          AliasResult Result = AA.alias(new MemoryLocation(P.getValue(), P.getSize(), P.getAAInfo()), 
              new MemoryLocation(Entry.getValue(), Size, AAInfo));
          if (Result != AliasResult.MustAlias) {
            Alias = $uint2uint_1bit(AliasLattice.SetMayAlias.getValue());
          } else { // First entry of must alias must have maximum size!
            P.updateSizeAndAAInfo(Size, AAInfo);
          }
          assert (Result != AliasResult.NoAlias) : "Cannot be part of must set!";
        }
      }
    }
    
    Entry.setAliasSet(this);
    Entry.updateSizeAndAAInfo(Size, AAInfo);
    
    // Add it to the end of the list...
    assert (PtrListEnd.$star() == null) : "End of list is not null?";
    PtrListEnd.$set($AddrOf(Entry));
    PtrListEnd = $tryClone(Entry.setPrevInList(PtrListEnd));
    assert (PtrListEnd.$star() == null) : "End of list is not null?";
    addRef(); // Entry points to alias set.
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::addUnknownInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 126,
   FQN="llvm::AliasSet::addUnknownInst", NM="_ZN4llvm8AliasSet14addUnknownInstEPNS_11InstructionERNS_9AAResultsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet14addUnknownInstEPNS_11InstructionERNS_9AAResultsE")
  //</editor-fold>
  /*friend*/public void addUnknownInst(Instruction /*P*/ I, final AAResults /*&*/ AA) {
    if (UnknownInsts.empty()) {
      addRef();
    }
    UnknownInsts.emplace_back(new AssertingVH<Instruction>(I));
    if (!I.mayWriteToMemory()) {
      Alias = $uint2uint_1bit(AliasLattice.SetMayAlias.getValue());
      Access |= $int2uint_2bits(AccessLattice.RefAccess.getValue());
      return;
    }
    
    // FIXME: This should use mod/ref information to make this not suck so bad
    Alias = $uint2uint_1bit(AliasLattice.SetMayAlias.getValue());
    Access = $uint2uint_2bits(AccessLattice.ModRefAccess.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::removeUnknownInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 265,
   FQN="llvm::AliasSet::removeUnknownInst", NM="_ZN4llvm8AliasSet17removeUnknownInstERNS_15AliasSetTrackerEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet17removeUnknownInstERNS_15AliasSetTrackerEPNS_11InstructionE")
  //</editor-fold>
  /*friend*/public void removeUnknownInst(final AliasSetTracker /*&*/ AST, Instruction /*P*/ I) {
    boolean WasEmpty = UnknownInsts.empty();
    for (/*size_t*/int i = 0, e = UnknownInsts.size(); i != e; ++i)  {
      if (UnknownInsts.$at(i).$T$P() == I) {
        UnknownInsts.$at(i).$assign_AssertingVH(UnknownInsts.back());
        UnknownInsts.pop_back();
        --i;
        --e; // Revisit the moved entry.
      }
    }
    if (!WasEmpty && UnknownInsts.empty()) {
      dropRef(AST);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::setVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 276,
   FQN="llvm::AliasSet::setVolatile", NM="_ZN4llvm8AliasSet11setVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSet11setVolatileEv")
  //</editor-fold>
  /*friend*/public void setVolatile() {
    Volatile = true;
  }

/*public:*/
  /// Return true if the specified pointer "may" (or must) alias one of the
  /// members in the set.
  
  /// aliasesPointer - Return true if the specified pointer "may" (or must)
  /// alias one of the members in the set.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::aliasesPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 145,
   FQN="llvm::AliasSet::aliasesPointer", NM="_ZNK4llvm8AliasSet14aliasesPointerEPKNS_5ValueEyRKNS_9AAMDNodesERNS_9AAResultsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet14aliasesPointerEPKNS_5ValueEyRKNS_9AAMDNodesERNS_9AAResultsE")
  //</editor-fold>
  public boolean aliasesPointer(/*const*/ Value /*P*/ Ptr, long/*uint64_t*/ Size, 
                final /*const*/ AAMDNodes /*&*/ AAInfo, 
                final AAResults /*&*/ AA) /*const*/ {
    if ((Alias ? 1:0) == AliasLattice.SetMustAlias.getValue()) {
      assert (UnknownInsts.empty()) : "Illegal must alias set!";
      
      // If this is a set of MustAliases, only check to see if the pointer aliases
      // SOME value in the set.
      PointerRec /*P*/ SomePtr = getSomePointer();
      assert ((SomePtr != null)) : "Empty must-alias set??";
      return (AA.alias(new MemoryLocation(SomePtr.getValue(), SomePtr.getSize(), 
              SomePtr.getAAInfo()), 
          new MemoryLocation(Ptr, Size, AAInfo)).getValue() != 0);
    }
    
    // If this is a may-alias set, we have to check all of the pointers in the set
    // to be sure it doesn't alias the set...
    for (iterator I = begin(), E = end(); I.$noteq(E); I.$preInc())  {
      if ((AA.alias(new MemoryLocation(Ptr, Size, AAInfo), 
          new MemoryLocation(I.getPointer(), I.getSize(), I.getAAInfo())).getValue() != 0)) {
        return true;
      }
    }
    
    // Check the unknown instructions...
    if (!UnknownInsts.empty()) {
      for (/*uint*/int i = 0, e = UnknownInsts.size(); i != e; ++i)  {
        if (AA.getModRefInfo(UnknownInsts.$at$Const(i).$T$P(), 
            new MemoryLocation(Ptr, Size, AAInfo)) != ModRefInfo.MRI_NoModRef) {
          return true;
        }
      }
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::aliasesUnknownInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 178,
   FQN="llvm::AliasSet::aliasesUnknownInst", NM="_ZNK4llvm8AliasSet18aliasesUnknownInstEPKNS_11InstructionERNS_9AAResultsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm8AliasSet18aliasesUnknownInstEPKNS_11InstructionERNS_9AAResultsE")
  //</editor-fold>
  public boolean aliasesUnknownInst(/*const*/ Instruction /*P*/ Inst, 
                    final AAResults /*&*/ AA) /*const*/ {
    if (!Inst.mayReadOrWriteMemory()) {
      return false;
    }
    
    for (/*uint*/int i = 0, e = UnknownInsts.size(); i != e; ++i) {
      ImmutableCallSite C1/*J*/= new ImmutableCallSite(getUnknownInst(i));
      ImmutableCallSite C2/*J*/= new ImmutableCallSite(Inst);
      if (!C1.$bool() || !C2.$bool() || AA.getModRefInfo(new ImmutableCallSite(C1), new ImmutableCallSite(C2)) != ModRefInfo.MRI_NoModRef
         || AA.getModRefInfo(new ImmutableCallSite(C2), new ImmutableCallSite(C1)) != ModRefInfo.MRI_NoModRef) {
        return true;
      }
    }
    
    for (iterator I = begin(), E = end(); I.$noteq(E); I.$preInc())  {
      if (AA.getModRefInfo(Inst, new MemoryLocation(I.getPointer(), I.getSize(), 
              I.getAAInfo())) != ModRefInfo.MRI_NoModRef) {
        return true;
      }
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSet::~AliasSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 37,
   FQN="llvm::AliasSet::~AliasSet", NM="_ZN4llvm8AliasSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm8AliasSetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    UnknownInsts.$destroy();
    ilist_node.super.$destroy$ilist_node();
    //END JDestroy
  }

  
  private final ilist_node$Fields ilist_node$Flds;// use return value of $ilist_node();
  @Override public final ilist_node$Fields $ilist_node$Fields() { return ilist_node$Flds; }
  
  @Override public String toString() {
    return "" + "PtrList=" + PtrList // NOI18N
              + ", PtrListEnd=" + PtrListEnd // NOI18N
              + ", Forward=" + Forward // NOI18N
              + ", UnknownInsts=" + UnknownInsts // NOI18N
              + ", RefCount=" + RefCount // NOI18N
              + ", Access=" + $uchar2uint(Access) // NOI18N
              + ", Alias=" + Alias // NOI18N
              + ", Volatile=" + Volatile // NOI18N
              + super.toString(); // NOI18N
  }
}
