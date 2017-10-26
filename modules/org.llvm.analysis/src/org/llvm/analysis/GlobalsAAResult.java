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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.SmallPtrSet;
import org.llvm.adt.SmallPtrSetImpl;
import org.llvm.adt.aliases.DenseMap;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.DenseMapIterator;
import org.llvm.adt.aliases.DenseMapTypeUInt;
import org.llvm.adt.aliases.SmallDenseMap;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.adt.scc_iterator;
import org.llvm.ir.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.impl.*;
import static org.llvm.analysis.impl.GlobalsModRefStatics.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.pass.IrLlvmGlobals.instructions_Function$P;


/// An alias analysis result set for globals.
///
/// This focuses on handling aliasing properties of globals and interprocedural
/// function call mod/ref information.
//<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/GlobalsModRef.h", line = 32,
 FQN="llvm::GlobalsAAResult", NM="_ZN4llvm15GlobalsAAResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResultE")
//</editor-fold>
public class GlobalsAAResult extends /*public*/ AAResultBase<GlobalsAAResult> implements Destructors.ClassWithDestructor {
  /*friend  AAResultBase<GlobalsAAResult>*/
  
  
  /// The mod/ref information collected for a particular function.
  ///
  /// We collect information about mod/ref behavior of a function here, both in
  /// general and as pertains to specific globals. We only have this detailed
  /// information when we know *something* useful about the behavior. If we
  /// saturate to fully general mod/ref, we remove the info for the function.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 62,
   FQN="llvm::GlobalsAAResult::FunctionInfo", NM="_ZN4llvm15GlobalsAAResult12FunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfoE")
  //</editor-fold>
  private static class FunctionInfo implements Destructors.ClassWithDestructor {
    // JAVA: typedef SmallDenseMap<const GlobalValue *, ModRefInfo, 16> GlobalInfoMapType
//    public final class GlobalInfoMapType extends SmallDenseMap</*const*/ GlobalValue /*P*/ , ModRefInfo>{ };
    
    /// Build a wrapper struct that has 8-byte alignment. All heap allocations
    /// should provide this much alignment at least, but this makes it clear we
    /// specifically rely on this amount of alignment.
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::AlignedMap">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 68,
     FQN="llvm::GlobalsAAResult::FunctionInfo::AlignedMap", NM="_ZN4llvm15GlobalsAAResult12FunctionInfo10AlignedMapE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfo10AlignedMapE")
    //</editor-fold>
    private static class/*struct*/ AlignedMap implements Destructors.ClassWithDestructor {
      //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::AlignedMap::AlignedMap">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 69,
       FQN="llvm::GlobalsAAResult::FunctionInfo::AlignedMap::AlignedMap", NM="_ZN4llvm15GlobalsAAResult12FunctionInfo10AlignedMapC1Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfo10AlignedMapC1Ev")
      //</editor-fold>
      public AlignedMap() {
        // : Map() 
        //START JInit
        this.Map = new SmallDenseMap</*const*/ GlobalValue /*P*/ , ModRefInfo>(DenseMapInfo$LikePtr.$Info(), 16, ModRefInfo.valueOf(0));
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::AlignedMap::AlignedMap">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 70,
       FQN="llvm::GlobalsAAResult::FunctionInfo::AlignedMap::AlignedMap", NM="_ZN4llvm15GlobalsAAResult12FunctionInfo10AlignedMapC1ERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfo10AlignedMapC1ERKS2_")
      //</editor-fold>
      public AlignedMap(final /*const*/ AlignedMap /*&*/ Arg) {
        // : Map(Arg.Map) 
        //START JInit
        this.Map = new SmallDenseMap</*const*/ GlobalValue /*P*/ , ModRefInfo>(Arg.Map);
        //END JInit
      }

      public SmallDenseMap</*const*/ GlobalValue /*P*/ , ModRefInfo> Map;
      //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::AlignedMap::~AlignedMap">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 68,
       FQN="llvm::GlobalsAAResult::FunctionInfo::AlignedMap::~AlignedMap", NM="_ZN4llvm15GlobalsAAResult12FunctionInfo10AlignedMapD0Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfo10AlignedMapD0Ev")
      //</editor-fold>
      public /*inline*/ void $destroy() {
        //START JDestroy
        Map.$destroy();
        //END JDestroy
      }

      
      @Override public String toString() {
        return "" + "Map=" + Map; // NOI18N
      }
    };
    
    /// Pointer traits for our aligned map.
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::AlignedMapPointerTraits">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 75,
     FQN="llvm::GlobalsAAResult::FunctionInfo::AlignedMapPointerTraits", NM="_ZN4llvm15GlobalsAAResult12FunctionInfo23AlignedMapPointerTraitsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfo23AlignedMapPointerTraitsE")
    //</editor-fold>
    private static class/*struct*/ AlignedMapPointerTraits {
      //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::AlignedMapPointerTraits::getAsVoidPointer">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 76,
       FQN="llvm::GlobalsAAResult::FunctionInfo::AlignedMapPointerTraits::getAsVoidPointer", NM="_ZN4llvm15GlobalsAAResult12FunctionInfo23AlignedMapPointerTraits16getAsVoidPointerEPNS1_10AlignedMapE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfo23AlignedMapPointerTraits16getAsVoidPointerEPNS1_10AlignedMapE")
      //</editor-fold>
      public static /*inline*/ Object/*void P*/ getAsVoidPointer(AlignedMap /*P*/ P) {
        return P;
      }

      //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::AlignedMapPointerTraits::getFromVoidPointer">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 77,
       FQN="llvm::GlobalsAAResult::FunctionInfo::AlignedMapPointerTraits::getFromVoidPointer", NM="_ZN4llvm15GlobalsAAResult12FunctionInfo23AlignedMapPointerTraits18getFromVoidPointerEPv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfo23AlignedMapPointerTraits18getFromVoidPointerEPv")
      //</editor-fold>
      public static /*inline*/ AlignedMap /*P*/ getFromVoidPointer(Object/*void P*/ P) {
        return (AlignedMap /*P*/ )P;
      }

      //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::AlignedMapPointerTraits::(anonymous)">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 80,
       FQN="llvm::GlobalsAAResult::FunctionInfo::AlignedMapPointerTraits::(anonymous)", NM="_ZN4llvm15GlobalsAAResult12FunctionInfo23AlignedMapPointerTraitsE_Unnamed_enum",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfo23AlignedMapPointerTraitsE_Unnamed_enum")
      //</editor-fold>
      /*enum ANONYMOUS_INT_CONSTANTS {*/
        public static final /*uint*/int NumLowBitsAvailable = 3;
      /*}*/;
      //static { static_assert($greatereq_uint(AlignOf.<AlignedMap>Alignment, (1 << NumLowBitsAvailable)), $("AlignedMap insufficiently aligned to have enough low bits.")); };
      
      @Override public String toString() {
        return ""; // NOI18N
      }
    };
    
    /// The bit that flags that this function may read any global. This is
    /// chosen to mix together with ModRefInfo bits.
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 87,
     FQN="llvm::GlobalsAAResult::FunctionInfo::(anonymous)", NM="_ZN4llvm15GlobalsAAResult12FunctionInfoE_Unnamed_enum",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfoE_Unnamed_enum")
    //</editor-fold>
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      public static final /*uint*/int MayReadAnyGlobal = 4;
    /*}*/;
    
    /// Checks to document the invariants of the bit packing here.
    static { static_assert((MayReadAnyGlobal & ModRefInfo.MRI_ModRef.getValue()) == 0, $("ModRef and the MayReadAnyGlobal flag bits overlap.")); };
    static { static_assert(((MayReadAnyGlobal | ModRefInfo.MRI_ModRef.getValue())
       >> AlignedMapPointerTraits.NumLowBitsAvailable) == 0, $("Insufficient low bits to store our flag and ModRef info.")); };
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::FunctionInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 97,
     FQN="llvm::GlobalsAAResult::FunctionInfo::FunctionInfo", NM="_ZN4llvm15GlobalsAAResult12FunctionInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfoC1Ev")
    //</editor-fold>
    public FunctionInfo() {
      // : Info() 
      //START JInit
      this.Info = new PointerUIntPair<AlignedMap>/*<3>*/();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::~FunctionInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 98,
     FQN="llvm::GlobalsAAResult::FunctionInfo::~FunctionInfo", NM="_ZN4llvm15GlobalsAAResult12FunctionInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfoD0Ev")
    //</editor-fold>
    public void $destroy() {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)Info.getPointer());
    }

    // Spell out the copy ond move constructors and assignment operators to get
    // deep copy semantics and correct move semantics in the face of the
    // pointer-int pair.
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::FunctionInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 104,
     FQN="llvm::GlobalsAAResult::FunctionInfo::FunctionInfo", NM="_ZN4llvm15GlobalsAAResult12FunctionInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfoC1ERKS1_")
    //</editor-fold>
    public FunctionInfo(final /*const*/ FunctionInfo /*&*/ Arg) {
      // : Info(null, Arg.Info.getInt()) 
      //START JInit
      this.Info = new PointerUIntPair<AlignedMap>/*<3>*/((AlignedMap /*P*/ )null, Arg.Info.getInt());
      //END JInit
      {
        /*const*/ AlignedMap /*P*/ ArgPtr = Arg.Info.getPointer();
        if ((ArgPtr != null)) {
          Info.setPointer(new AlignedMap($Deref(ArgPtr)));
        }
      }
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::FunctionInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 109,
     FQN="llvm::GlobalsAAResult::FunctionInfo::FunctionInfo", NM="_ZN4llvm15GlobalsAAResult12FunctionInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfoC1EOS1_")
    //</editor-fold>
    public FunctionInfo(JD$Move _dparam, final FunctionInfo /*&&*/Arg) {
      // : Info(Arg.Info.getPointer(), Arg.Info.getInt()) 
      //START JInit
      this.Info = new PointerUIntPair<AlignedMap>/*<3>*/(Arg.Info.getPointer(), Arg.Info.getInt());
      //END JInit
      Arg.Info.setPointerAndInt((AlignedMap /*P*/ )null, 0);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 113,
     FQN="llvm::GlobalsAAResult::FunctionInfo::operator=", NM="_ZN4llvm15GlobalsAAResult12FunctionInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfoaSERKS1_")
    //</editor-fold>
    public FunctionInfo /*&*/ $assign(final /*const*/ FunctionInfo /*&*/ RHS) {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)Info.getPointer());
      Info.setPointerAndInt((AlignedMap /*P*/ )null, RHS.Info.getInt());
      {
        /*const*/ AlignedMap /*P*/ RHSPtr = RHS.Info.getPointer();
        if ((RHSPtr != null)) {
          Info.setPointer(new AlignedMap($Deref(RHSPtr)));
        }
      }
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 120,
     FQN="llvm::GlobalsAAResult::FunctionInfo::operator=", NM="_ZN4llvm15GlobalsAAResult12FunctionInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfoaSEOS1_")
    //</editor-fold>
    public FunctionInfo /*&*/ $assignMove(final FunctionInfo /*&&*/RHS) {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)Info.getPointer());
      Info.setPointerAndInt(RHS.Info.getPointer(), RHS.Info.getInt());
      RHS.Info.setPointerAndInt((AlignedMap /*P*/ )null, 0);
      return /*Deref*/this;
    }

    
    /// Returns the \c ModRefInfo info for this function.
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::getModRefInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 128,
     FQN="llvm::GlobalsAAResult::FunctionInfo::getModRefInfo", NM="_ZNK4llvm15GlobalsAAResult12FunctionInfo13getModRefInfoEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZNK4llvm15GlobalsAAResult12FunctionInfo13getModRefInfoEv")
    //</editor-fold>
    public ModRefInfo getModRefInfo() /*const*/ {
      return ModRefInfo.valueOf(Info.getInt() & ModRefInfo.MRI_ModRef.getValue());
    }

    
    /// Adds new \c ModRefInfo for this function to its state.
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::addModRefInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 133,
     FQN="llvm::GlobalsAAResult::FunctionInfo::addModRefInfo", NM="_ZN4llvm15GlobalsAAResult12FunctionInfo13addModRefInfoENS_10ModRefInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfo13addModRefInfoENS_10ModRefInfoE")
    //</editor-fold>
    public void addModRefInfo(ModRefInfo NewMRI) {
      Info.setInt(Info.getInt() | NewMRI.getValue());
    }

    
    /// Returns whether this function may read any global variable, and we don't
    /// know which global.
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::mayReadAnyGlobal">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 139,
     FQN="llvm::GlobalsAAResult::FunctionInfo::mayReadAnyGlobal", NM="_ZNK4llvm15GlobalsAAResult12FunctionInfo16mayReadAnyGlobalEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZNK4llvm15GlobalsAAResult12FunctionInfo16mayReadAnyGlobalEv")
    //</editor-fold>
    public boolean mayReadAnyGlobal() /*const*/ {
      return ((Info.getInt() & MayReadAnyGlobal) != 0);
    }

    
    /// Sets this function as potentially reading from any global.
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::setMayReadAnyGlobal">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 142,
     FQN="llvm::GlobalsAAResult::FunctionInfo::setMayReadAnyGlobal", NM="_ZN4llvm15GlobalsAAResult12FunctionInfo19setMayReadAnyGlobalEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfo19setMayReadAnyGlobalEv")
    //</editor-fold>
    public void setMayReadAnyGlobal() {
      Info.setInt(Info.getInt() | MayReadAnyGlobal);
    }

    
    /// Returns the \c ModRefInfo info for this function w.r.t. a particular
    /// global, which may be more precise than the general information above.
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::getModRefInfoForGlobal">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 146,
     FQN="llvm::GlobalsAAResult::FunctionInfo::getModRefInfoForGlobal", NM="_ZNK4llvm15GlobalsAAResult12FunctionInfo22getModRefInfoForGlobalERKNS_11GlobalValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZNK4llvm15GlobalsAAResult12FunctionInfo22getModRefInfoForGlobalERKNS_11GlobalValueE")
    //</editor-fold>
    public ModRefInfo getModRefInfoForGlobal(final /*const*/ GlobalValue /*&*/ GV) /*const*/ {
      ModRefInfo GlobalMRI = mayReadAnyGlobal() ? ModRefInfo.MRI_Ref : ModRefInfo.MRI_NoModRef;
      {
        AlignedMap /*P*/ P = Info.getPointer();
        if ((P != null)) {
          DenseMapIterator<GlobalValue, ModRefInfo>  I = P.Map.find($AddrOf(GV));
          if (I.$noteq(/*NO_ITER_COPY*/P.Map.end())) {
            GlobalMRI = ModRefInfo.valueOf(GlobalMRI.getValue() | I.$arrow().second.getValue());
          }
        }
      }
      return GlobalMRI;
    }

    
    /// Add mod/ref info from another function into ours, saturating towards
    /// MRI_ModRef.
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::addFunctionInfo">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 158,
     FQN="llvm::GlobalsAAResult::FunctionInfo::addFunctionInfo", NM="_ZN4llvm15GlobalsAAResult12FunctionInfo15addFunctionInfoERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfo15addFunctionInfoERKS1_")
    //</editor-fold>
    public void addFunctionInfo(final /*const*/ FunctionInfo /*&*/ FI) {
      addModRefInfo(FI.getModRefInfo());
      if (FI.mayReadAnyGlobal()) {
        setMayReadAnyGlobal();
      }
      {
        
        AlignedMap /*P*/ P = FI.Info.getPointer();
        if ((P != null)) {
          for (final /*const*/ pair</*const*/ GlobalValue /*P*/ , ModRefInfo> /*&*/ G : P.Map)  {
            addModRefInfoForGlobal($Deref(G.first), G.second);
          }
        }
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::addModRefInfoForGlobal">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 169,
     FQN="llvm::GlobalsAAResult::FunctionInfo::addModRefInfoForGlobal", NM="_ZN4llvm15GlobalsAAResult12FunctionInfo22addModRefInfoForGlobalERKNS_11GlobalValueENS_10ModRefInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfo22addModRefInfoForGlobalERKNS_11GlobalValueENS_10ModRefInfoE")
    //</editor-fold>
    public void addModRefInfoForGlobal(final /*const*/ GlobalValue /*&*/ GV, ModRefInfo NewMRI) {
      AlignedMap /*P*/ P = Info.getPointer();
      if (!(P != null)) {
        P = new AlignedMap();
        Info.setPointer(P);
      }
      final type$ref<ModRefInfo /*&*/> GlobalMRI = P.Map.ref$at($AddrOf(GV));
      GlobalMRI.$set(ModRefInfo.valueOf(GlobalMRI.$deref().getValue() | NewMRI.getValue()));
    }

    
    /// Clear a global's ModRef info. Should be used when a global is being
    /// deleted.
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::FunctionInfo::eraseModRefInfoForGlobal">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 181,
     FQN="llvm::GlobalsAAResult::FunctionInfo::eraseModRefInfoForGlobal", NM="_ZN4llvm15GlobalsAAResult12FunctionInfo24eraseModRefInfoForGlobalERKNS_11GlobalValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult12FunctionInfo24eraseModRefInfoForGlobalERKNS_11GlobalValueE")
    //</editor-fold>
    public void eraseModRefInfoForGlobal(final /*const*/ GlobalValue /*&*/ GV) {
      {
        AlignedMap /*P*/ P = Info.getPointer();
        if ((P != null)) {
          P.Map.erase($AddrOf(GV));
        }
      }
    }

  /*private:*/
    /// All of the information is encoded into a single pointer, with a three bit
    /// integer in the low three bits. The high bit provides a flag for when this
    /// function may read any global. The low two bits are the ModRefInfo. And
    /// the pointer, when non-null, points to a map from GlobalValue to
    /// ModRefInfo specific to that GlobalValue.
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
    private PointerUIntPair<AlignedMap>//PointerIntPair<AlignedMap /*P*/ , /*uint*/int, AlignedMapPointerTraits>/*<3>*/
            Info;
    
    @Override public String toString() {
      return "" + "Info=" + Info; // NOI18N
    }
  };
  
  private final /*const*/ DataLayout /*&*/ DL;
  private final /*const*/ TargetLibraryInfo /*&*/ TLI;
  
  /// The globals that do not have their addresses taken.
  private SmallPtrSet</*const*/ GlobalValue /*P*/ > NonAddressTakenGlobals;
  
  /// IndirectGlobals - The memory pointed to by this global is known to be
  /// 'owned' by the global.
  private SmallPtrSet</*const*/ GlobalValue /*P*/ > IndirectGlobals;
  
  /// AllocsForIndirectGlobals - If an instruction allocates memory for an
  /// indirect global, this map indicates which one.
  private DenseMap</*const*/ Value /*P*/ , /*const*/ GlobalValue /*P*/ > AllocsForIndirectGlobals;
  
  /// For each function, keep track of what globals are modified or read.
  private DenseMap</*const*/ Function /*P*/ , FunctionInfo> FunctionInfos;
  
  /// A map of functions to SCC. The SCCs are described by a simple integer
  /// ID that is only useful for comparing for equality (are two functions
  /// in the same SCC or not?)
  private DenseMapTypeUInt</*const*/ Function /*P*/ > FunctionToSCCMap;
  
  /// Handle to clear this analysis on deletion of values.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::DeletionCallbackHandle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/GlobalsModRef.h", line = 60,
   FQN="llvm::GlobalsAAResult::DeletionCallbackHandle", NM="_ZN4llvm15GlobalsAAResult22DeletionCallbackHandleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult22DeletionCallbackHandleE")
  //</editor-fold>
  private static final class/*struct*/ DeletionCallbackHandle extends /**/ CallbackVH implements Destructors.ClassWithDestructor {
    public GlobalsAAResult /*P*/ GAR;
    public std.list.iterator<DeletionCallbackHandle> I;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::DeletionCallbackHandle::DeletionCallbackHandle">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/GlobalsModRef.h", line = 64,
     FQN="llvm::GlobalsAAResult::DeletionCallbackHandle::DeletionCallbackHandle", NM="_ZN4llvm15GlobalsAAResult22DeletionCallbackHandleC1ERS0_PNS_5ValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult22DeletionCallbackHandleC1ERS0_PNS_5ValueE")
    //</editor-fold>
    public DeletionCallbackHandle(final GlobalsAAResult /*&*/ GAR, Value /*P*/ V) {
      // : CallbackVH(V), GAR(&GAR), I() 
      //START JInit
      super(V);
      this.GAR = $AddrOf(GAR);
      this.I = $tryClone(new std.list.iterator<DeletionCallbackHandle>());
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::DeletionCallbackHandle::deleted">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 195,
     FQN="llvm::GlobalsAAResult::DeletionCallbackHandle::deleted", NM="_ZN4llvm15GlobalsAAResult22DeletionCallbackHandle7deletedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult22DeletionCallbackHandle7deletedEv")
    //</editor-fold>
    @Override public void deleted()/* override*/ {
      Value /*P*/ V = getValPtr();
      {
        Function /*P*/ F = dyn_cast_Function(V);
        if ((F != null)) {
          GAR.FunctionInfos.erase(F);
        }
      }
      {
        
        GlobalValue /*P*/ GV = dyn_cast_GlobalValue(V);
        if ((GV != null)) {
          if (GAR.NonAddressTakenGlobals.erase(GV)) {
            // This global might be an indirect global.  If so, remove it and
            // remove any AllocRelatedValues for it.
            if (GAR.IndirectGlobals.erase(GV)) {
              // Remove any entries in AllocsForIndirectGlobals for this global.
              for (DenseMapIterator</*const*/ Value /*P*/ , /*const*/ GlobalValue /*P*/ > I = GAR.AllocsForIndirectGlobals.begin(), 
                  E = GAR.AllocsForIndirectGlobals.end();
                   I.$noteq(/*NO_ITER_COPY*/E); I.$preInc())  {
                if (I.$arrow().second == GV) {
                  GAR.AllocsForIndirectGlobals.erase(new DenseMapIterator</*const*/ Value /*P*/ , /*const*/ GlobalValue /*P*/ >(I));
                }
              }
            }
            
            // Scan the function info we have collected and remove this global
            // from all of them.
            for (final std.pair</*const*/ Function /*P*/ , FunctionInfo> /*&*/ FIPair : GAR.FunctionInfos)  {
              FIPair.second.eraseModRefInfoForGlobal($Deref(GV));
            }
          }
        }
      }
      
      // If this is an allocation related to an indirect global, remove it.
      GAR.AllocsForIndirectGlobals.erase(V);
      
      // And clear out the handle.
      setValPtr((Value /*P*/ )null);
      GAR.Handles.erase(new std.list.iterator<DeletionCallbackHandle>(I));
      // This object is now destroyed!
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::DeletionCallbackHandle::~DeletionCallbackHandle">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/GlobalsModRef.h", line = 60,
     FQN="llvm::GlobalsAAResult::DeletionCallbackHandle::~DeletionCallbackHandle", NM="_ZN4llvm15GlobalsAAResult22DeletionCallbackHandleD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult22DeletionCallbackHandleD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      super.$destroy();
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public DeletionCallbackHandle() {
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "GAR=" + GAR // NOI18N
                + ", I=" + I // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /// List of callbacks for globals being tracked by this analysis. Note that
  /// these objects are quite large, but we only anticipate having one per
  /// global tracked by this analysis. There are numerous optimizations we
  /// could perform to the memory utilization here if this becomes a problem.
  private std.list<DeletionCallbackHandle> Handles;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::GlobalsAAResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 903,
   FQN="llvm::GlobalsAAResult::GlobalsAAResult", NM="_ZN4llvm15GlobalsAAResultC1ERKNS_10DataLayoutERKNS_17TargetLibraryInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResultC1ERKNS_10DataLayoutERKNS_17TargetLibraryInfoE")
  //</editor-fold>
  private GlobalsAAResult(final /*const*/ DataLayout /*&*/ DL, 
      final /*const*/ TargetLibraryInfo /*&*/ TLI) {
    // : AAResultBase<GlobalsAAResult>(), DL(DL), TLI(TLI), NonAddressTakenGlobals(), IndirectGlobals(), AllocsForIndirectGlobals(), FunctionInfos(), FunctionToSCCMap(), Handles() 
    //START JInit
    super();
    this./*&*/DL=/*&*/DL;
    this./*&*/TLI=/*&*/TLI;
    this.NonAddressTakenGlobals = new SmallPtrSet</*const*/ GlobalValue /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    this.IndirectGlobals = new SmallPtrSet</*const*/ GlobalValue /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    this.AllocsForIndirectGlobals = new DenseMap</*const*/ Value /*P*/ , /*const*/ GlobalValue /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ GlobalValue /*P*/ )null);
    this.FunctionInfos = new DenseMap</*const*/ Function /*P*/ , FunctionInfo>(DenseMapInfo$LikePtr.$Info(), new FunctionInfo());
    this.FunctionToSCCMap = new DenseMapTypeUInt</*const*/ Function /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.Handles = new std.list<DeletionCallbackHandle>(new DeletionCallbackHandle());
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::GlobalsAAResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 907,
   FQN="llvm::GlobalsAAResult::GlobalsAAResult", NM="_ZN4llvm15GlobalsAAResultC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResultC1EOS0_")
  //</editor-fold>
  public GlobalsAAResult(JD$Move _dparam, final GlobalsAAResult /*&&*/Arg) {
    // : AAResultBase<GlobalsAAResult>(std::move(Arg)), DL(Arg.DL), TLI(Arg.TLI), NonAddressTakenGlobals(std::move(Arg.NonAddressTakenGlobals)), IndirectGlobals(std::move(Arg.IndirectGlobals)), AllocsForIndirectGlobals(std::move(Arg.AllocsForIndirectGlobals)), FunctionInfos(std::move(Arg.FunctionInfos)), FunctionToSCCMap(), Handles(std::move(Arg.Handles)) 
    //START JInit
    super(JD$Move.INSTANCE, std.move(Arg));
    this./*&*/DL=/*&*/Arg.DL;
    this./*&*/TLI=/*&*/Arg.TLI;
    this.NonAddressTakenGlobals = new SmallPtrSet</*const*/ GlobalValue /*P*/ >(JD$Move.INSTANCE, std.move(Arg.NonAddressTakenGlobals));
    this.IndirectGlobals = new SmallPtrSet</*const*/ GlobalValue /*P*/ >(JD$Move.INSTANCE, std.move(Arg.IndirectGlobals));
    this.AllocsForIndirectGlobals = new DenseMap</*const*/ Value /*P*/ , /*const*/ GlobalValue /*P*/ >(JD$Move.INSTANCE, std.move(Arg.AllocsForIndirectGlobals));
    this.FunctionInfos = new DenseMap</*const*/ Function /*P*/ , FunctionInfo>(JD$Move.INSTANCE, std.move(Arg.FunctionInfos));
    this.FunctionToSCCMap = new DenseMapTypeUInt</*const*/ Function /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.Handles = new std.list<DeletionCallbackHandle>(JD$Move.INSTANCE, std.move(Arg.Handles));
    //END JInit
    // Update the parent for each DeletionCallbackHandle.
    for (final DeletionCallbackHandle /*&*/ H : Handles) {
      assert (H.GAR == $AddrOf(Arg));
      H.GAR = this;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::~GlobalsAAResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 921,
   FQN="llvm::GlobalsAAResult::~GlobalsAAResult", NM="_ZN4llvm15GlobalsAAResultD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResultD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    Handles.$destroy();
    FunctionToSCCMap.$destroy();
    FunctionInfos.$destroy();
    AllocsForIndirectGlobals.$destroy();
    IndirectGlobals.$destroy();
    NonAddressTakenGlobals.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  
  /*static*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::analyzeModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 923,
   FQN="llvm::GlobalsAAResult::analyzeModule", NM="_ZN4llvm15GlobalsAAResult13analyzeModuleERNS_6ModuleERKNS_17TargetLibraryInfoERNS_9CallGraphE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult13analyzeModuleERNS_6ModuleERKNS_17TargetLibraryInfoERNS_9CallGraphE")
  //</editor-fold>
  public static GlobalsAAResult analyzeModule(final Module /*&*/ M, final /*const*/ TargetLibraryInfo /*&*/ TLI, 
               final CallGraph /*&*/ CG) {
    GlobalsAAResult Result = null;
    try {
      Result/*J*/= new GlobalsAAResult(M.getDataLayout(), TLI);
      
      // Discover which functions aren't recursive, to feed into AnalyzeGlobals.
      Result.CollectSCCMembership(CG);
      
      // Find non-addr taken globals.
      Result.AnalyzeGlobals(M);
      
      // Propagate on CG.
      Result.AnalyzeCallGraph(CG, M);
      
      return new GlobalsAAResult(JD$Move.INSTANCE, Result);
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }

  
  //------------------------------------------------
  // Implement the AliasAnalysis API
  //
  
  /// alias - If one of the pointers is to a global that we are tracking, and the
  /// other is some random pointer, we know there cannot be an alias, because the
  /// address of the global isn't taken.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::alias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 776,
   FQN="llvm::GlobalsAAResult::alias", NM="_ZN4llvm15GlobalsAAResult5aliasERKNS_14MemoryLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult5aliasERKNS_14MemoryLocationES3_")
  //</editor-fold>
  public AliasResult alias(final /*const*/ MemoryLocation /*&*/ LocA, 
       final /*const*/ MemoryLocation /*&*/ LocB) {
    // Get the base object these pointers point to.
    /*const*/ Value /*P*/ UV1 = ValueTrackingLlvmGlobals.GetUnderlyingObject_Value$C$P_DataLayout$C_uint(LocA.Ptr, DL);
    /*const*/ Value /*P*/ UV2 = ValueTrackingLlvmGlobals.GetUnderlyingObject_Value$C$P_DataLayout$C_uint(LocB.Ptr, DL);
    
    // If either of the underlying values is a global, they may be non-addr-taken
    // globals, which we can answer queries about.
    /*const*/ GlobalValue /*P*/ GV1 = dyn_cast_GlobalValue(UV1);
    /*const*/ GlobalValue /*P*/ GV2 = dyn_cast_GlobalValue(UV2);
    if ((GV1 != null) || (GV2 != null)) {
      // If the global's address is taken, pretend we don't know it's a pointer to
      // the global.
      if ((GV1 != null) && !(NonAddressTakenGlobals.count(GV1) != 0)) {
        GV1 = null;
      }
      if ((GV2 != null) && !(NonAddressTakenGlobals.count(GV2) != 0)) {
        GV2 = null;
      }
      
      // If the two pointers are derived from two different non-addr-taken
      // globals we know these can't alias.
      if ((GV1 != null) && (GV2 != null) && GV1 != GV2) {
        return AliasResult.NoAlias;
      }
      
      // If one is and the other isn't, it isn't strictly safe but we can fake
      // this result if necessary for performance. This does not appear to be
      // a common problem in practice.
      if (EnableUnsafeGlobalsModRefAliasResults.$T()) {
        if (((GV1 != null) || (GV2 != null)) && GV1 != GV2) {
          return AliasResult.NoAlias;
        }
      }
      
      // Check for a special case where a non-escaping global can be used to
      // conclude no-alias.
      if (((GV1 != null) || (GV2 != null)) && GV1 != GV2) {
        /*const*/ GlobalValue /*P*/ GV = (GV1 != null) ? GV1 : GV2;
        /*const*/ Value /*P*/ UV = (GV1 != null) ? UV2 : UV1;
        if (isNonEscapingGlobalNoAlias(GV, UV)) {
          return AliasResult.NoAlias;
        }
      }
      // Otherwise if they are both derived from the same addr-taken global, we
      // can't know the two accesses don't overlap.
    }
    
    // These pointers may be based on the memory owned by an indirect global.  If
    // so, we may be able to handle this.  First check to see if the base pointer
    // is a direct load from an indirect global.
    GV1 = GV2 = null;
    {
      /*const*/ LoadInst /*P*/ LI = dyn_cast_LoadInst(UV1);
      if ((LI != null)) {
        {
          GlobalVariable /*P*/ GV = dyn_cast_GlobalVariable(LI.getOperand(0));
          if ((GV != null)) {
            if ((IndirectGlobals.count(GV) != 0)) {
              GV1 = GV;
            }
          }
        }
      }
    }
    {
      /*const*/ LoadInst /*P*/ LI = dyn_cast_LoadInst(UV2);
      if ((LI != null)) {
        {
          /*const*/ GlobalVariable /*P*/ GV = dyn_cast_GlobalVariable(LI.getOperand(0));
          if ((GV != null)) {
            if ((IndirectGlobals.count(GV) != 0)) {
              GV2 = GV;
            }
          }
        }
      }
    }
    
    // These pointers may also be from an allocation for the indirect global.  If
    // so, also handle them.
    if (!(GV1 != null)) {
      GV1 = AllocsForIndirectGlobals.lookup(UV1);
    }
    if (!(GV2 != null)) {
      GV2 = AllocsForIndirectGlobals.lookup(UV2);
    }
    
    // Now that we know whether the two pointers are related to indirect globals,
    // use this to disambiguate the pointers. If the pointers are based on
    // different indirect globals they cannot alias.
    if ((GV1 != null) && (GV2 != null) && GV1 != GV2) {
      return AliasResult.NoAlias;
    }
    
    // If one is based on an indirect global and the other isn't, it isn't
    // strictly safe but we can fake this result if necessary for performance.
    // This does not appear to be a common problem in practice.
    if (EnableUnsafeGlobalsModRefAliasResults.$T()) {
      if (((GV1 != null) || (GV2 != null)) && GV1 != GV2) {
        return AliasResult.NoAlias;
      }
    }
    
    return super.alias(LocA, LocB);
  }

  
  //JAVA: using AAResultBase<GlobalsAAResult>::getModRefInfo;
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::getModRefInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 883,
   FQN="llvm::GlobalsAAResult::getModRefInfo", NM="_ZN4llvm15GlobalsAAResult13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult13getModRefInfoENS_17ImmutableCallSiteERKNS_14MemoryLocationE")
  //</editor-fold>
  public ModRefInfo getModRefInfo(ImmutableCallSite CS, 
               final /*const*/ MemoryLocation /*&*/ Loc) {
    /*uint*/int Known = ModRefInfo.MRI_ModRef.getValue();
    {
      
      // If we are asking for mod/ref info of a direct call with a pointer to a
      // global we are tracking, return information if we have it.
      /*const*/ GlobalValue /*P*/ GV = dyn_cast_GlobalValue(ValueTrackingLlvmGlobals.GetUnderlyingObject_Value$C$P_DataLayout$C_uint(Loc.Ptr, DL));
      if ((GV != null)) {
        if (GV.hasLocalLinkage()) {
          {
            /*const*/ Function /*P*/ F = CS.getCalledFunction();
            if ((F != null)) {
              if ((NonAddressTakenGlobals.count(GV) != 0)) {
                {
                  /*const*/ FunctionInfo /*P*/ FI = getFunctionInfo(F);
                  if ((FI != null)) {
                    Known = FI.getModRefInfoForGlobal($Deref(GV)).getValue()
                       | getModRefInfoForArgument(new ImmutableCallSite(CS), GV).getValue();
                  }
                }
              }
            }
          }
        }
      }
    }
    if (Known == ModRefInfo.MRI_NoModRef.getValue()) {
      return ModRefInfo.MRI_NoModRef; // No need to query other mod/ref analyses
    }
    return ModRefInfo.valueOf(Known & super.getModRefInfo(new ImmutableCallSite(CS), Loc).getValue());
  }

  
  /// getModRefBehavior - Return the behavior of the specified function if
  /// called from the specified call site.  The call site may be null in which
  /// case the most generic behavior of this function should be returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::getModRefBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 229,
   FQN="llvm::GlobalsAAResult::getModRefBehavior", NM="_ZN4llvm15GlobalsAAResult17getModRefBehaviorEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult17getModRefBehaviorEPKNS_8FunctionE")
  //</editor-fold>
  public FunctionModRefBehavior getModRefBehavior(/*const*/ Function /*P*/ F) {
    FunctionModRefBehavior Min = FunctionModRefBehavior.FMRB_UnknownModRefBehavior;
    {
      
      FunctionInfo /*P*/ FI = getFunctionInfo(F);
      if ((FI != null)) {
        if (FI.getModRefInfo() == ModRefInfo.MRI_NoModRef) {
          Min = FunctionModRefBehavior.FMRB_DoesNotAccessMemory;
        } else if ((FI.getModRefInfo().getValue() & ModRefInfo.MRI_Mod.getValue()) == 0) {
          Min = FunctionModRefBehavior.FMRB_OnlyReadsMemory;
        }
      }
    }
    
    return FunctionModRefBehavior.valueOf(super.getModRefBehavior(F).getValue() & Min.getValue());
  }

  
  /// getModRefBehavior - Return the behavior of the specified function if
  /// called from the specified call site.  The call site may be null in which
  /// case the most generic behavior of this function should be returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::getModRefBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 242,
   FQN="llvm::GlobalsAAResult::getModRefBehavior", NM="_ZN4llvm15GlobalsAAResult17getModRefBehaviorENS_17ImmutableCallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult17getModRefBehaviorENS_17ImmutableCallSiteE")
  //</editor-fold>
  public FunctionModRefBehavior getModRefBehavior(ImmutableCallSite CS) {
    FunctionModRefBehavior Min = FunctionModRefBehavior.FMRB_UnknownModRefBehavior;
    if (!CS.hasOperandBundles()) {
      {
        /*const*/ Function /*P*/ F = CS.getCalledFunction();
        if ((F != null)) {
          {
            FunctionInfo /*P*/ FI = getFunctionInfo(F);
            if ((FI != null)) {
              if (FI.getModRefInfo() == ModRefInfo.MRI_NoModRef) {
                Min = FunctionModRefBehavior.FMRB_DoesNotAccessMemory;
              } else if ((FI.getModRefInfo().getValue() & ModRefInfo.MRI_Mod.getValue()) == 0) {
                Min = FunctionModRefBehavior.FMRB_OnlyReadsMemory;
              }
            }
          }
        }
      }
    }
    
    return FunctionModRefBehavior.valueOf(super.getModRefBehavior(new ImmutableCallSite(CS)).getValue() & Min.getValue());
  }

/*private:*/
  
  /// Returns the function info for the function, or null if we don't have
  /// anything useful to say about it.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::getFunctionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 260,
   FQN="llvm::GlobalsAAResult::getFunctionInfo", NM="_ZN4llvm15GlobalsAAResult15getFunctionInfoEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult15getFunctionInfoEPKNS_8FunctionE")
  //</editor-fold>
  private GlobalsAAResult.FunctionInfo /*P*/ getFunctionInfo(/*const*/ Function /*P*/ F) {
    DenseMapIterator</*const*/ Function /*P*/ , FunctionInfo> I = FunctionInfos.find(F);
    if (I.$noteq(/*NO_ITER_COPY*/FunctionInfos.end())) {
      return $AddrOf(I.$arrow().second);
    }
    return null;
  }

  
  
  /// AnalyzeGlobals - Scan through the users of all of the internal
  /// GlobalValue's in the program.  If none of them have their "address taken"
  /// (really, their address passed to something nontrivial), record this fact,
  /// and record the functions that they are used directly in.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::AnalyzeGlobals">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 272,
   FQN="llvm::GlobalsAAResult::AnalyzeGlobals", NM="_ZN4llvm15GlobalsAAResult14AnalyzeGlobalsERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult14AnalyzeGlobalsERNS_6ModuleE")
  //</editor-fold>
  private void AnalyzeGlobals(final Module /*&*/ M) {
    SmallPtrSet<Function /*P*/ > TrackedFunctions/*J*/= new SmallPtrSet<Function /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
    for (final Function /*&*/ F : M)  {
      if (F.hasLocalLinkage()) {
        if (!AnalyzeUsesOfPointer($AddrOf(F))) {
          // Remember that we are tracking this global.
          NonAddressTakenGlobals.insert($AddrOf(F));
          TrackedFunctions.insert($AddrOf(F));
          Handles.emplace_front(new DeletionCallbackHandle(/*Deref*/this, $AddrOf(F)));
          Handles.front().I.$assignMove(Handles.begin());
          NumNonAddrTakenFunctions.$preInc();
        }
      }
    }
    
    SmallPtrSet<Function /*P*/ > Readers/*J*/= new SmallPtrSet<Function /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    SmallPtrSet<Function /*P*/ > Writers/*J*/= new SmallPtrSet<Function /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    for (final GlobalVariable /*&*/ GV : M.globals())  {
      if (GV.hasLocalLinkage()) {
        if (!AnalyzeUsesOfPointer($AddrOf(GV), $AddrOf(Readers), 
            GV.isConstant() ? (SmallPtrSet<Function /*P*/ > /*P*/)null : $AddrOf(Writers))) {
          // Remember that we are tracking this global, and the mod/ref fns
          NonAddressTakenGlobals.insert($AddrOf(GV));
          Handles.emplace_front(new DeletionCallbackHandle(/*Deref*/this, $AddrOf(GV)));
          Handles.front().I.$assignMove(Handles.begin());
          
          for (Function /*P*/ Reader : Readers) {
            if (TrackedFunctions.insert(Reader).second) {
              Handles.emplace_front(new DeletionCallbackHandle(/*Deref*/this, Reader));
              Handles.front().I.$assignMove(Handles.begin());
            }
            FunctionInfos.$at_T1$RR(Reader).addModRefInfoForGlobal(GV, ModRefInfo.MRI_Ref);
          }
          if (!GV.isConstant()) { // No need to keep track of writers to constants
            for (Function /*P*/ Writer : Writers) {
              if (TrackedFunctions.insert(Writer).second) {
                Handles.emplace_front(new DeletionCallbackHandle(/*Deref*/this, Writer));
                Handles.front().I.$assignMove(Handles.begin());
              }
              FunctionInfos.$at_T1$RR(Writer).addModRefInfoForGlobal(GV, ModRefInfo.MRI_Mod);
            }
          }
          NumNonAddrTakenGlobalVars.$preInc();
          
          // If this global holds a pointer type, see if it is an indirect global.
          if (GV.getValueType().isPointerTy()
             && AnalyzeIndirectGlobalMemory($AddrOf(GV))) {
            NumIndirectGlobalVars.$preInc();
          }
        }
        Readers.clear();
        Writers.clear();
      }
    }
  }

  
  /// AnalyzeCallGraph - At this point, we know the functions where globals are
  /// immediately stored to and read from.  Propagate this information up the call
  /// graph to all callers and compute the mod/ref info for all memory for each
  /// function.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::AnalyzeCallGraph">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 467,
   FQN="llvm::GlobalsAAResult::AnalyzeCallGraph", NM="_ZN4llvm15GlobalsAAResult16AnalyzeCallGraphERNS_9CallGraphERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult16AnalyzeCallGraphERNS_9CallGraphERNS_6ModuleE")
  //</editor-fold>
  private void AnalyzeCallGraph(final CallGraph /*&*/ CG, final Module /*&*/ M) {
    scc_iterator<CallGraph /*P*/, CallGraphNode, CallGraphNode > I = null;
    try {
      // We do a bottom-up SCC traversal of the call graph.  In other words, we
      // visit all callees before callers (leaf-first).
      for (I = scc_iterator.scc_begin(GraphTraitsCallGraph$C$P.$GTraits(), $AddrOf(CG)); !I.isAtEnd(); I.$preInc()) {
        FunctionInfo CachedFI = null;
        try {
          final /*const*/std.vector<CallGraphNode /*P*/ > /*&*/ SCC = I.$star();
          assert (!SCC.empty()) : "SCC with no functions?";
          if (!(SCC.$at$Const(0).getFunction() != null) || !SCC.$at$Const(0).getFunction().isDefinitionExact()) {
            // Calls externally or not exact - can't say anything useful. Remove any
            // existing function records (may have been created when scanning
            // globals).
            for (CallGraphNode /*P*/ Node : SCC)  {
              FunctionInfos.erase(Node.getFunction());
            }
            continue;
          }
          
          final FunctionInfo /*&*/ FI = FunctionInfos.$at_T1$RR(SCC.$at$Const(0).getFunction());
          boolean KnowNothing = false;
          
          // Collect the mod/ref properties due to called functions.  We only compute
          // one mod-ref set.
          for (/*uint*/int i = 0, e = SCC.size(); i != e && !KnowNothing; ++i) {
            Function /*P*/ F = SCC.$at$Const(i).getFunction();
            if (!(F != null)) {
              KnowNothing = true;
              break;
            }
            if (F.isDeclaration()) {
              // Try to get mod/ref behaviour from function attributes.
              if (F.doesNotAccessMemory()) {
                // Can't do better than that!
              } else if (F.onlyReadsMemory()) {
                FI.addModRefInfo(ModRefInfo.MRI_Ref);
                if (!F.isIntrinsic() && !F.onlyAccessesArgMemory()) {
                  // This function might call back into the module and read a global -
                  // consider every global as possibly being read by this function.
                  FI.setMayReadAnyGlobal();
                }
              } else {
                FI.addModRefInfo(ModRefInfo.MRI_ModRef);
                // Can't say anything useful unless it's an intrinsic - they don't
                // read or write global variables of the kind considered here.
                KnowNothing = !F.isIntrinsic();
              }
              continue;
            }
            
            for (std.vector.iterator<std.pairTypePtr<WeakVH, CallGraphNode /*P*/ > /*P*/> CI = SCC.$at$Const(i).begin(), E = SCC.$at$Const(i).end();
                 $noteq___normal_iterator$C(CI, E) && !KnowNothing; CI.$preInc())  {
              {
                Function /*P*/ Callee = CI.$arrow().second.getFunction();
                if ((Callee != null)) {
                  {
                    FunctionInfo /*P*/ CalleeFI = getFunctionInfo(Callee);
                    if ((CalleeFI != null)) {
                      // Propagate function effect up.
                      FI.addFunctionInfo($Deref(CalleeFI));
                    } else {
                      // Can't say anything about it.  However, if it is inside our SCC,
                      // then nothing needs to be done.
                      CallGraphNode /*P*/ CalleeNode = CG.$at(Callee);
                      if ($eq___normal_iterator$C(std.find(SCC.begin$Const(), SCC.end$Const(), CalleeNode), SCC.end$Const())) {
                        KnowNothing = true;
                      }
                    }
                  }
                } else {
                  KnowNothing = true;
                }
              }
            }
          }
          
          // If we can't say anything useful about this SCC, remove all SCC functions
          // from the FunctionInfos map.
          if (KnowNothing) {
            for (CallGraphNode /*P*/ Node : SCC)  {
              FunctionInfos.erase(Node.getFunction());
            }
            continue;
          }
          
          // Scan the function bodies for explicit loads or stores.
          for (CallGraphNode /*P*/ Node : SCC) {
            if (FI.getModRefInfo() == ModRefInfo.MRI_ModRef) {
              break; // The mod/ref lattice saturates here.
            }
            for (final Instruction /*&*/ I$1 : instructions_Function$P(Node.getFunction())) {
              if (FI.getModRefInfo() == ModRefInfo.MRI_ModRef) {
                break; // The mod/ref lattice saturates here.
              }
              {
                
                // We handle calls specially because the graph-relevant aspects are
                // handled above.
                CallSite CS = new CallSite($AddrOf(I$1));
                if (CS.$bool()) {
                  if (MemoryBuiltinsLlvmGlobals.isAllocationFn($AddrOf(I$1), $AddrOf(TLI)) || (MemoryBuiltinsLlvmGlobals.isFreeCall_Value$P_TargetLibraryInfo$C$P($AddrOf(I$1), $AddrOf(TLI)) != null)) {
                    // FIXME: It is completely unclear why this is necessary and not
                    // handled by the above graph code.
                    FI.addModRefInfo(ModRefInfo.MRI_ModRef);
                  } else {
                    Function /*P*/ Callee = CS.getCalledFunction();
                    if ((Callee != null)) {
                      // The callgraph doesn't include intrinsic calls.
                      if (Callee.isIntrinsic()) {
                        FunctionModRefBehavior Behaviour = super.getModRefBehavior(Callee);
                        FI.addModRefInfo(ModRefInfo.valueOf(Behaviour.getValue() & ModRefInfo.MRI_ModRef.getValue()));
                      }
                    }
                  }
                  continue;
                }
              }
              
              // All non-call instructions we use the primary predicates for whether
              // thay read or write memory.
              if (I$1.mayReadFromMemory()) {
                FI.addModRefInfo(ModRefInfo.MRI_Ref);
              }
              if (I$1.mayWriteToMemory()) {
                FI.addModRefInfo(ModRefInfo.MRI_Mod);
              }
            }
          }
          if ((FI.getModRefInfo().getValue() & ModRefInfo.MRI_Mod.getValue()) == 0) {
            NumReadMemFunctions.$preInc();
          }
          if (FI.getModRefInfo() == ModRefInfo.MRI_NoModRef) {
            NumNoMemFunctions.$preInc();
          }
          
          // Finally, now that we know the full effect on this SCC, clone the
          // information to each function in the SCC.
          // FI is a reference into FunctionInfos, so copy it now so that it doesn't
          // get invalidated if DenseMap decides to re-hash.
          CachedFI = new FunctionInfo(FI);
          for (/*uint*/int i = 1, e = SCC.size(); i != e; ++i)  {
            FunctionInfos.$at_T1$RR(SCC.$at$Const(i).getFunction()).$assign(CachedFI);
          }
        } finally {
          if (CachedFI != null) { CachedFI.$destroy(); }
        }
      }
    } finally {
      if (I != null) { I.$destroy(); }
    }
  }

  
  /// AnalyzeUsesOfPointer - Look at all of the users of the specified pointer.
  /// If this is used by anything complex (i.e., the address escapes), return
  /// true.  Also, while we are at it, keep track of those functions that read and
  /// write to the value.
  ///
  /// If OkayStoreDest is non-null, stores into this global are allowed.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::AnalyzeUsesOfPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 329,
   FQN="llvm::GlobalsAAResult::AnalyzeUsesOfPointer", NM="_ZN4llvm15GlobalsAAResult20AnalyzeUsesOfPointerEPNS_5ValueEPNS_15SmallPtrSetImplIPNS_8FunctionEEES7_PNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult20AnalyzeUsesOfPointerEPNS_5ValueEPNS_15SmallPtrSetImplIPNS_8FunctionEEES7_PNS_11GlobalValueE")
  //</editor-fold>
  private boolean AnalyzeUsesOfPointer(Value /*P*/ V) {
    return AnalyzeUsesOfPointer(V, 
                      (SmallPtrSetImpl<Function /*P*/ > /*P*/ )null, 
                      (SmallPtrSetImpl<Function /*P*/ > /*P*/ )null, 
                      (GlobalValue /*P*/ )null);
  }
  private boolean AnalyzeUsesOfPointer(Value /*P*/ V, 
                      SmallPtrSetImpl<Function /*P*/ > /*P*/ Readers/*= null*/) {
    return AnalyzeUsesOfPointer(V, 
                      Readers, 
                      (SmallPtrSetImpl<Function /*P*/ > /*P*/ )null, 
                      (GlobalValue /*P*/ )null);
  }
  private boolean AnalyzeUsesOfPointer(Value /*P*/ V, 
                      SmallPtrSetImpl<Function /*P*/ > /*P*/ Readers/*= null*/, 
                      SmallPtrSetImpl<Function /*P*/ > /*P*/ Writers/*= null*/) {
    return AnalyzeUsesOfPointer(V, 
                      Readers, 
                      Writers, 
                      (GlobalValue /*P*/ )null);
  }
  private boolean AnalyzeUsesOfPointer(Value /*P*/ V, 
                      SmallPtrSetImpl<Function /*P*/ > /*P*/ Readers/*= null*/, 
                      SmallPtrSetImpl<Function /*P*/ > /*P*/ Writers/*= null*/, 
                      GlobalValue /*P*/ OkayStoreDest/*= null*/) {
    if (!V.getType().isPointerTy()) {
      return true;
    }
    
    for (final Use /*&*/ U : V.uses()) {
      User /*P*/ I = U.getUser();
      {
        LoadInst /*P*/ LI = dyn_cast_LoadInst(I);
        if ((LI != null)) {
          if ((Readers != null)) {
            Readers.insert(LI.getParent().getParent());
          }
        } else {
          StoreInst /*P*/ SI = dyn_cast_StoreInst(I);
          if ((SI != null)) {
            if (V == SI.getOperand(1)) {
              if ((Writers != null)) {
                Writers.insert(SI.getParent().getParent());
              }
            } else if (SI.getOperand(1) != OkayStoreDest) {
              return true; // Storing the pointer
            }
          } else if (Operator.getOpcode(I) == Instruction.MemoryOps.GetElementPtr) {
            if (AnalyzeUsesOfPointer(I, Readers, Writers)) {
              return true;
            }
          } else if (Operator.getOpcode(I) == Instruction.CastOps.BitCast) {
            if (AnalyzeUsesOfPointer(I, Readers, Writers, OkayStoreDest)) {
              return true;
            }
          } else {
            CallSite CS = new CallSite(I);
            if (CS.$bool()) {
              // Make sure that this is just the function being called, not that it is
              // passing into the function.
              type$ptr<Use> tmp = create_type$ptr($AddrOf(U));
              if (CS.isDataOperand(tmp)) {
                // Detect calls to free.
                if (CS.isArgOperand(tmp) && (MemoryBuiltinsLlvmGlobals.isFreeCall_Value$P_TargetLibraryInfo$C$P(I, $AddrOf(TLI)) != null)) {
                  if ((Writers != null)) {
                    Writers.insert(CS.$arrow().getParent().getParent());
                  }
                } else {
                  return true; // Argument of an unknown call.
                }
              }
            } else {
              ICmpInst /*P*/ ICI = dyn_cast_ICmpInst(I);
              if ((ICI != null)) {
                if (!isa_ConstantPointerNull(ICI.getOperand(1))) {
                  return true; // Allow comparison against null.
                }
              } else {
                return true;
              }
            }
          }
        }
      }
    }
    
    return false;
  }

  
  /// AnalyzeIndirectGlobalMemory - We found an non-address-taken global variable
  /// which holds a pointer type.  See if the global always points to non-aliased
  /// heap memory: that is, all initializers of the globals are allocations, and
  /// those allocations have no use other than initialization of the global.
  /// Further, all loads out of GV must directly use the memory, not store the
  /// pointer somewhere.  If this is true, we consider the memory pointed to by
  /// GV to be owned by GV and can disambiguate other pointers from it.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::AnalyzeIndirectGlobalMemory">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 384,
   FQN="llvm::GlobalsAAResult::AnalyzeIndirectGlobalMemory", NM="_ZN4llvm15GlobalsAAResult27AnalyzeIndirectGlobalMemoryEPNS_14GlobalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult27AnalyzeIndirectGlobalMemoryEPNS_14GlobalVariableE")
  //</editor-fold>
  private boolean AnalyzeIndirectGlobalMemory(GlobalVariable /*P*/ GV) {
    std.vector<Value /*P*/ > AllocRelatedValues = null;
    try {
      // Keep track of values related to the allocation of the memory, f.e. the
      // value produced by the malloc call and any casts.
      AllocRelatedValues/*J*/= new std.vector<Value /*P*/ >((Value /*P*/ )null);
      {
        
        // If the initializer is a valid pointer, bail.
        Constant /*P*/ C = GV.getInitializer();
        if ((C != null)) {
          if (!C.isNullValue()) {
            return false;
          }
        }
      }
      
      // Walk the user list of the global.  If we find anything other than a direct
      // load or store, bail out.
      for (User /*P*/ U : GV.users()) {
        {
          LoadInst /*P*/ LI = dyn_cast_LoadInst(U);
          if ((LI != null)) {
            // The pointer loaded from the global can only be used in simple ways:
            // we allow addressing of it and loading storing to it.  We do *not* allow
            // storing the loaded pointer somewhere else or passing to a function.
            if (AnalyzeUsesOfPointer(LI)) {
              return false; // Loaded pointer escapes.
            }
            // TODO: Could try some IP mod/ref of the loaded pointer.
          } else {
            StoreInst /*P*/ SI = dyn_cast_StoreInst(U);
            if ((SI != null)) {
              // Storing the global itself.
              if (SI.getOperand(0) == GV) {
                return false;
              }
              
              // If storing the null pointer, ignore it.
              if (isa_ConstantPointerNull(SI.getOperand(0))) {
                continue;
              }
              
              // Check the value being stored.
              Value /*P*/ Ptr = ValueTrackingLlvmGlobals.GetUnderlyingObject_Value$P_DataLayout$C_uint(SI.getOperand(0), 
                  GV.getParent().getDataLayout());
              if (!MemoryBuiltinsLlvmGlobals.isAllocLikeFn(Ptr, $AddrOf(TLI))) {
                return false; // Too hard to analyze.
              }
              
              // Analyze all uses of the allocation.  If any of them are used in a
              // non-simple way (e.g. stored to another global) bail out.
              if (AnalyzeUsesOfPointer(Ptr, /*Readers*/ (SmallPtrSetImpl<Function /*P*/ > /*P*/ )null, /*Writers*/ (SmallPtrSetImpl<Function /*P*/ > /*P*/ )null, 
                  GV)) {
                return false; // Loaded pointer escapes.
              }
              
              // Remember that this allocation is related to the indirect global.
              AllocRelatedValues.push_back_T$C$R(Ptr);
            } else {
              // Something complex, bail out.
              return false;
            }
          }
        }
      }
      
      // Okay, this is an indirect global.  Remember all of the allocations for
      // this global in AllocsForIndirectGlobals.
      while (!AllocRelatedValues.empty()) {
        AllocsForIndirectGlobals.$set(AllocRelatedValues.back(), GV);
        Handles.emplace_front(new DeletionCallbackHandle(/*Deref*/this, AllocRelatedValues.back()));
        Handles.front().I.$assignMove(Handles.begin());
        AllocRelatedValues.pop_back();
      }
      IndirectGlobals.insert(GV);
      Handles.emplace_front(new DeletionCallbackHandle(/*Deref*/this, GV));
      Handles.front().I.$assignMove(Handles.begin());
      return true;
    } finally {
      if (AllocRelatedValues != null) { AllocRelatedValues.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::CollectSCCMembership">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 448,
   FQN="llvm::GlobalsAAResult::CollectSCCMembership", NM="_ZN4llvm15GlobalsAAResult20CollectSCCMembershipERNS_9CallGraphE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult20CollectSCCMembershipERNS_9CallGraphE")
  //</editor-fold>
  private void CollectSCCMembership(final CallGraph /*&*/ CG) {
    // We do a bottom-up SCC traversal of the call graph.  In other words, we
    // visit all callees before callers (leaf-first).
    /*uint*/int SCCID = 0;
    scc_iterator<CallGraph /*P*/, CallGraphNode, CallGraphNode > I = null;
    try {
      for (I = scc_iterator.scc_begin(GraphTraitsCallGraph$C$P.$GTraits(), $AddrOf(CG)); !I.isAtEnd(); I.$preInc()) {
        final /*const*/std.vector<CallGraphNode /*P*/ > /*&*/ SCC = I.$star();
        assert (!SCC.empty()) : "SCC with no functions?";
        
        for (CallGraphNode /*P*/ CGN : SCC)  {
          {
            Function /*P*/ F = CGN.getFunction();
            if ((F != null)) {
              FunctionToSCCMap.$set(F, SCCID);
            }
          }
        }
        ++SCCID;
      }
    } finally {
      if (I != null) { I.$destroy(); }
    }
  }

  
  
  // There are particular cases where we can conclude no-alias between
  // a non-addr-taken global and some other underlying object. Specifically,
  // a non-addr-taken global is known to not be escaped from any function. It is
  // also incorrect for a transformation to introduce an escape of a global in
  // a way that is observable when it was not there previously. One function
  // being transformed to introduce an escape which could possibly be observed
  // (via loading from a global or the return value for example) within another
  // function is never safe. If the observation is made through non-atomic
  // operations on different threads, it is a data-race and UB. If the
  // observation is well defined, by being observed the transformation would have
  // changed program behavior by introducing the observed escape, making it an
  // invalid transform.
  //
  // This property does require that transformations which *temporarily* escape
  // a global that was not previously escaped, prior to restoring it, cannot rely
  // on the results of GMR::alias. This seems a reasonable restriction, although
  // currently there is no way to enforce it. There is also no realistic
  // optimization pass that would make this mistake. The closest example is
  // a transformation pass which does reg2mem of SSA values but stores them into
  // global variables temporarily before restoring the global variable's value.
  // This could be useful to expose "benign" races for example. However, it seems
  // reasonable to require that a pass which introduces escapes of global
  // variables in this way to either not trust AA results while the escape is
  // active, or to be forced to operate as a module pass that cannot co-exist
  // with an alias analysis such as GMR.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::isNonEscapingGlobalNoAlias">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 675,
   FQN="llvm::GlobalsAAResult::isNonEscapingGlobalNoAlias", NM="_ZN4llvm15GlobalsAAResult26isNonEscapingGlobalNoAliasEPKNS_11GlobalValueEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult26isNonEscapingGlobalNoAliasEPKNS_11GlobalValueEPKNS_5ValueE")
  //</editor-fold>
  private boolean isNonEscapingGlobalNoAlias(/*const*/ GlobalValue /*P*/ GV, 
                            /*const*/ Value /*P*/ V) {
    // In order to know that the underlying object cannot alias the
    // non-addr-taken global, we must know that it would have to be an escape.
    // Thus if the underlying object is a function argument, a load from
    // a global, or the return of a function, it cannot alias. We can also
    // recurse through PHI nodes and select nodes provided all of their inputs
    // resolve to one of these known-escaping roots.
    SmallPtrSet</*const*/ Value /*P*/ > Visited/*J*/= new SmallPtrSet</*const*/ Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    SmallVector</*const*/ Value /*P*/ > Inputs/*J*/= new SmallVector</*const*/ Value /*P*/ >(8, (/*const*/ Value /*P*/ )null);
    Visited.insert(V);
    Inputs.push_back(V);
    int$ref Depth = create_int$ref(0);
    do {
      /*const*/ Value /*P*/ Input = Inputs.pop_back_val();
      {
        
        /*const*/ GlobalValue /*P*/ InputGV = dyn_cast_GlobalValue(Input);
        if ((InputGV != null)) {
          // If one input is the very global we're querying against, then we can't
          // conclude no-alias.
          if (InputGV == GV) {
            return false;
          }
          
          // Distinct GlobalVariables never alias, unless overriden or zero-sized.
          // FIXME: The condition can be refined, but be conservative for now.
          /*const*/ GlobalVariable /*P*/ GVar = dyn_cast_GlobalVariable(GV);
          /*const*/ GlobalVariable /*P*/ InputGVar = dyn_cast_GlobalVariable(InputGV);
          if ((GVar != null) && (InputGVar != null)
             && !GVar.isDeclaration() && !InputGVar.isDeclaration()
             && !GVar.isInterposable() && !InputGVar.isInterposable()) {
            Type /*P*/ GVType = GVar.getInitializer$Const().getType();
            Type /*P*/ InputGVType = InputGVar.getInitializer$Const().getType();
            if (GVType.isSized() && InputGVType.isSized()
               && ($greater_ulong_ullong(DL.getTypeAllocSize(GVType), $int2ullong(0)))
               && ($greater_ulong_ullong(DL.getTypeAllocSize(InputGVType), $int2ullong(0)))) {
              continue;
            }
          }
          
          // Conservatively return false, even though we could be smarter
          // (e.g. look through GlobalAliases).
          return false;
        }
      }
      if (isa_Argument(Input) || isa_CallInst(Input)
         || isa_InvokeInst(Input)) {
        // Arguments to functions or returns from functions are inherently
        // escaping, so we can immediately classify those as not aliasing any
        // non-addr-taken globals.
        continue;
      }
      
      // Recurse through a limited number of selects, loads and PHIs. This is an
      // arbitrary depth of 4, lower numbers could be used to fix compile time
      // issues if needed, but this is generally expected to be only be important
      // for small depths.
      if (Depth.$set$preInc() > 4) {
        return false;
      }
      {
        
        /*const*/ LoadInst /*P*/ LI = dyn_cast_LoadInst(Input);
        if ((LI != null)) {
          // A pointer loaded from a global would have been captured, and we know
          // that the global is non-escaping, so no alias.
          /*const*/ Value /*P*/ Ptr = ValueTrackingLlvmGlobals.GetUnderlyingObject_Value$C$P_DataLayout$C_uint(LI.getPointerOperand$Const(), DL);
          if (isNonEscapingGlobalNoAliasWithLoad(GV, Ptr, Depth, DL)) {
            // The load does not alias with GV.
            continue;
          }
          // Otherwise, a load could come from anywhere, so bail.
          return false;
        }
      }
      {
        /*const*/ SelectInst /*P*/ SI = dyn_cast_SelectInst(Input);
        if ((SI != null)) {
          /*const*/ Value /*P*/ LHS = ValueTrackingLlvmGlobals.GetUnderlyingObject_Value$C$P_DataLayout$C_uint(SI.getTrueValue$Const(), DL);
          /*const*/ Value /*P*/ RHS = ValueTrackingLlvmGlobals.GetUnderlyingObject_Value$C$P_DataLayout$C_uint(SI.getFalseValue$Const(), DL);
          if (Visited.insert(LHS).second) {
            Inputs.push_back(LHS);
          }
          if (Visited.insert(RHS).second) {
            Inputs.push_back(RHS);
          }
          continue;
        }
      }
      {
        /*const*/ PHINode /*P*/ PN = dyn_cast_PHINode(Input);
        if ((PN != null)) {
          for (/*const*/ Use /*P*/ use : PN.incoming_values$Const()) {
            /*const*/ Value /*P*/ Op = use.$Value$P();
            Op = ValueTrackingLlvmGlobals.GetUnderlyingObject_Value$C$P_DataLayout$C_uint(Op, DL);
            if (Visited.insert(Op).second) {
              Inputs.push_back(Op);
            }
          }
          continue;
        }
      }
      
      // FIXME: It would be good to handle other obvious no-alias cases here, but
      // it isn't clear how to do so reasonbly without building a small version
      // of BasicAA into this code. We could recurse into AAResultBase::alias
      // here but that seems likely to go poorly as we're inside the
      // implementation of such a query. Until then, just conservatievly retun
      // false.
      return false;
    } while (!Inputs.empty());
    
    // If all the inputs to V were definitively no-alias, then V is no-alias.
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalsAAResult::getModRefInfoForArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 855,
   FQN="llvm::GlobalsAAResult::getModRefInfoForArgument", NM="_ZN4llvm15GlobalsAAResult24getModRefInfoForArgumentENS_17ImmutableCallSiteEPKNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm15GlobalsAAResult24getModRefInfoForArgumentENS_17ImmutableCallSiteEPKNS_11GlobalValueE")
  //</editor-fold>
  private ModRefInfo getModRefInfoForArgument(ImmutableCallSite CS, 
                          /*const*/ GlobalValue /*P*/ GV) {
    if (CS.doesNotAccessMemory()) {
      return ModRefInfo.MRI_NoModRef;
    }
    ModRefInfo ConservativeResult = CS.onlyReadsMemory() ? ModRefInfo.MRI_Ref : ModRefInfo.MRI_ModRef;
    
    // Iterate through all the arguments to the called function. If any argument
    // is based on GV, return the conservative result.
    for (final /*const*/ Use /*&*/ A : CS.args()) {
      SmallVector<Value /*P*/ > Objects/*J*/= new SmallVector<Value /*P*/ >(4, (Value /*P*/ )null);
      ValueTrackingLlvmGlobals.GetUnderlyingObjects(A.$Value$P(), Objects, DL);
      
      // All objects must be identified.
      if (!std.all_of(Objects.begin(), Objects.end(), /*FuncRef*/AliasAnalysisLlvmGlobals::isIdentifiedObject)
        // Try ::alias to see if all objects are known not to alias GV.
         && !std.all_of(Objects.begin(), Objects.end(), /*[&, this, &GV]*/ (Value /*P*/ V) -> {
                return this.alias(new MemoryLocation(V), new MemoryLocation(GV)) == AliasResult.NoAlias;
              })) {
        return ConservativeResult;
      }
      if ($noteq_ptr(std.find(Objects.begin(), Objects.end(), GV), Objects.end())) {
        return ConservativeResult;
      }
    }
    
    // We identified all objects in the argument list, and none of them were GV.
    return ModRefInfo.MRI_NoModRef;
  }

  
  @Override public String toString() {
    return "" + "DL=" + DL // NOI18N
              + ", TLI=" + TLI // NOI18N
              + ", NonAddressTakenGlobals=" + NonAddressTakenGlobals // NOI18N
              + ", IndirectGlobals=" + IndirectGlobals // NOI18N
              + ", AllocsForIndirectGlobals=" + AllocsForIndirectGlobals // NOI18N
              + ", FunctionInfos=" + FunctionInfos // NOI18N
              + ", FunctionToSCCMap=" + FunctionToSCCMap // NOI18N
              + ", Handles=" + Handles // NOI18N
              + super.toString(); // NOI18N
  }
}
