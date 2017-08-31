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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::LazyCompoundValData">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 45,
 FQN="clang::ento::LazyCompoundValData", NM="_ZN5clang4ento19LazyCompoundValDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento19LazyCompoundValDataE")
//</editor-fold>
public class LazyCompoundValData extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node, Destructors.ClassWithDestructor {
  private StoreRef store;
  private /*const*/ TypedValueRegion /*P*/ region;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::LazyCompoundValData::LazyCompoundValData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 49,
   FQN="clang::ento::LazyCompoundValData::LazyCompoundValData", NM="_ZN5clang4ento19LazyCompoundValDataC1ERKNS0_8StoreRefEPKNS0_16TypedValueRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento19LazyCompoundValDataC1ERKNS0_8StoreRefEPKNS0_16TypedValueRegionE")
  //</editor-fold>
  public LazyCompoundValData(final /*const*/ StoreRef /*&*/ st, /*const*/ TypedValueRegion /*P*/ r) {
    // : FoldingSetNode(), store(st), region(r) 
    //START JInit
    $Node();
    this.store = new StoreRef(st);
    this.region = r;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::LazyCompoundValData::getStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 52,
   FQN="clang::ento::LazyCompoundValData::getStore", NM="_ZNK5clang4ento19LazyCompoundValData8getStoreEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZNK5clang4ento19LazyCompoundValData8getStoreEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getStore() /*const*/ {
    return store.getStore();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::LazyCompoundValData::getRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 53,
   FQN="clang::ento::LazyCompoundValData::getRegion", NM="_ZNK5clang4ento19LazyCompoundValData9getRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZNK5clang4ento19LazyCompoundValData9getRegionEv")
  //</editor-fold>
  public /*const*/ TypedValueRegion /*P*/ getRegion() /*const*/ {
    return region;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::LazyCompoundValData::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp", line = 29,
   FQN="clang::ento::LazyCompoundValData::Profile", NM="_ZN5clang4ento19LazyCompoundValData7ProfileERN4llvm16FoldingSetNodeIDERKNS0_8StoreRefEPKNS0_16TypedValueRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento19LazyCompoundValData7ProfileERN4llvm16FoldingSetNodeIDERKNS0_8StoreRefEPKNS0_16TypedValueRegionE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, 
         final /*const*/ StoreRef /*&*/ store, 
         /*const*/ TypedValueRegion /*P*/ region) {
    ID.AddPointer(store.getStore());
    ID.AddPointer(region);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::LazyCompoundValData::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 59,
   FQN="clang::ento::LazyCompoundValData::Profile", NM="_ZN5clang4ento19LazyCompoundValData7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento19LazyCompoundValData7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, store, region);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::LazyCompoundValData::~LazyCompoundValData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 45,
   FQN="clang::ento::LazyCompoundValData::~LazyCompoundValData", NM="_ZN5clang4ento19LazyCompoundValDataD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento19LazyCompoundValDataD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }


  
  @Override public String toString() {
    return "" + "store=" + store // NOI18N
              + ", region=" + region // NOI18N
              + super.toString(); // NOI18N
  }
}
