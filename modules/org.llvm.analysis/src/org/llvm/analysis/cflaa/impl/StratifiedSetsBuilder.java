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

package org.llvm.analysis.cflaa.impl;

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
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;


/// Generic Builder class that produces StratifiedSets instances.
///
/// The goal of this builder is to efficiently produce correct StratifiedSets
/// instances. To this end, we use a few tricks:
///   > Set chains (A method for linking sets together)
///   > Set remaps (A method for marking a set as an alias [irony?] of another)
///
/// ==== Set chains ====
/// This builder has a notion of some value A being above, below, or with some
/// other value B:
///   > The `A above B` relationship implies that there is a reference edge
///   going from A to B. Namely, it notes that A can store anything in B's set.
///   > The `A below B` relationship is the opposite of `A above B`. It implies
///   that there's a dereference edge going from A to B.
///   > The `A with B` relationship states that there's an assignment edge going
///   from A to B, and that A and B should be treated as equals.
///
/// As an example, take the following code snippet:
///
/// %a = alloca i32, align 4
/// %ap = alloca i32*, align 8
/// %app = alloca i32**, align 8
/// store %a, %ap
/// store %ap, %app
/// %aw = getelementptr %ap, i32 0
///
/// Given this, the following relations exist:
///   - %a below %ap & %ap above %a
///   - %ap below %app & %app above %ap
///   - %aw with %ap & %ap with %aw
///
/// These relations produce the following sets:
///   [{%a}, {%ap, %aw}, {%app}]
///
/// ...Which state that the only MayAlias relationship in the above program is
/// between %ap and %aw.
///
/// Because LLVM allows arbitrary casts, code like the following needs to be
/// supported:
///   %ip = alloca i64, align 8
///   %ipp = alloca i64*, align 8
///   %i = bitcast i64** ipp to i64
///   store i64* %ip, i64** %ipp
///   store i64 %i, i64* %ip
///
/// Which, because %ipp ends up *both* above and below %ip, is fun.
///
/// This is solved by merging %i and %ipp into a single set (...which is the
/// only way to solve this, since their bit patterns are equivalent). Any sets
/// that ended up in between %i and %ipp at the time of merging (in this case,
/// the set containing %ip) also get conservatively merged into the set of %i
/// and %ipp. In short, the resulting StratifiedSet from the above code would be
/// {%ip, %ipp, %i}.
///
/// ==== Set remaps ====
/// More of an implementation detail than anything -- when merging sets, we need
/// to update the numbers of all of the elements mapped to those sets. Rather
/// than doing this at each merge, we note in the BuilderLink structure that a
/// remap has occurred, and use this information so we can defer renumbering set
/// elements until build time.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 183,
 FQN="llvm::cflaa::StratifiedSetsBuilder", NM="_ZN4llvm5cflaa21StratifiedSetsBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilderE")
//</editor-fold>
public class StratifiedSetsBuilder</*typename*/ T>  {
  /// \brief Represents a Stratified Set, with information about the Stratified
  /// Set above it, the set below it, and whether the current set has been
  /// remapped to another.
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 187,
   FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLinkE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLinkE")
  //</editor-fold>
  private static class/*struct*/ BuilderLink {
    public /*const*//*uint*/int Number;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::BuilderLink">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 190,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::BuilderLink", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLinkC1Ej",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLinkC1Ej")
    //</editor-fold>
    public BuilderLink(/*uint*/int N) {
      // : Number(N) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::hasAbove">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 194,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::hasAbove", NM="_ZNK4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8hasAboveEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8hasAboveEv")
    //</editor-fold>
    public boolean hasAbove() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::hasBelow">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 199,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::hasBelow", NM="_ZNK4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8hasBelowEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8hasBelowEv")
    //</editor-fold>
    public boolean hasBelow() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::setBelow">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 204,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::setBelow", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8setBelowEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8setBelowEj")
    //</editor-fold>
    public void setBelow(/*uint*/int I) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::setAbove">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 209,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::setAbove", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8setAboveEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8setAboveEj")
    //</editor-fold>
    public void setAbove(/*uint*/int I) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::clearBelow">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 214,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::clearBelow", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink10clearBelowEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink10clearBelowEv")
    //</editor-fold>
    public void clearBelow() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::clearAbove">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 219,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::clearAbove", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink10clearAboveEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink10clearAboveEv")
    //</editor-fold>
    public void clearAbove() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::getBelow">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 224,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::getBelow", NM="_ZNK4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8getBelowEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8getBelowEv")
    //</editor-fold>
    public /*uint*/int getBelow() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::getAbove">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 230,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::getAbove", NM="_ZNK4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8getAboveEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8getAboveEv")
    //</editor-fold>
    public /*uint*/int getAbove() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::getAttrs">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 236,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::getAttrs", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8getAttrsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8getAttrsEv")
    //</editor-fold>
    public std.bitset/*NumAliasAttrs*/ getAttrs() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::setAttrs">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 241,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::setAttrs", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8setAttrsESt6bitsetILj32EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink8setAttrsESt6bitsetILj32EE")
    //</editor-fold>
    public void setAttrs(std.bitset/*NumAliasAttrs*/ Other) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::isRemapped">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 246,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::isRemapped", NM="_ZNK4llvm5cflaa21StratifiedSetsBuilder11BuilderLink10isRemappedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa21StratifiedSetsBuilder11BuilderLink10isRemappedEv")
    //</editor-fold>
    public boolean isRemapped() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// For initial remapping to another set
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::remapTo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 249,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::remapTo", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink7remapToEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink7remapToEj")
    //</editor-fold>
    public void remapTo(/*uint*/int Other) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::getRemapIndex">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 254,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::getRemapIndex", NM="_ZNK4llvm5cflaa21StratifiedSetsBuilder11BuilderLink13getRemapIndexEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa21StratifiedSetsBuilder11BuilderLink13getRemapIndexEv")
    //</editor-fold>
    public /*uint*/int getRemapIndex() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Should only be called when we're already remapped.
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::updateRemap">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 260,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::updateRemap", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink11updateRemapEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder11BuilderLink11updateRemapEj")
    //</editor-fold>
    public void updateRemap(/*uint*/int Other) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Prefer the above functions to calling things directly on what's returned
    /// from this -- they guard against unexpected calls when the current
    /// BuilderLink is remapped.
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::getLink">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 268,
     FQN="llvm::cflaa::StratifiedSetsBuilder::BuilderLink::getLink", NM="_ZNK4llvm5cflaa21StratifiedSetsBuilder11BuilderLink7getLinkEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa21StratifiedSetsBuilder11BuilderLink7getLinkEv")
    //</editor-fold>
    public /*const*/ StratifiedLink /*&*/ getLink() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*private:*/
    private StratifiedLink Link;
    private /*uint*/int Remap;
    
    @Override public String toString() {
      return "" + "Number=" + Number // NOI18N
                + ", Link=" + Link // NOI18N
                + ", Remap=" + Remap; // NOI18N
    }
  };
  
  /// \brief This function performs all of the set unioning/value renumbering
  /// that we've been putting off, and generates a vector<StratifiedLink> that
  /// may be placed in a StratifiedSets instance.
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::finalizeSets">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 278,
   FQN="llvm::cflaa::StratifiedSetsBuilder::finalizeSets", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder12finalizeSetsERSt6vectorINS0_14StratifiedLinkESaIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder12finalizeSetsERSt6vectorINS0_14StratifiedLinkESaIS3_EE")
  //</editor-fold>
  private void finalizeSets(final std.vector<StratifiedLink> /*&*/ StratLinks) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief There's a guarantee in StratifiedLink where all bits set in a
  /// Link.externals will be set in all Link.externals "below" it.
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::propagateAttrs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 316,
   FQN="llvm::cflaa::StratifiedSetsBuilder::propagateAttrs", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder14propagateAttrsERSt6vectorINS0_14StratifiedLinkESaIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder14propagateAttrsERSt6vectorINS0_14StratifiedLinkESaIS3_EE")
  //</editor-fold>
  private static </*typename*/ T> void propagateAttrs(final std.vector<StratifiedLink> /*&*/ Links) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  /// Builds a StratifiedSet from the information we've been given since either
  /// construction or the prior build() call.
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::build">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 345,
   FQN="llvm::cflaa::StratifiedSetsBuilder::build", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder5buildEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder5buildEv")
  //</editor-fold>
  public StratifiedSets<T> build() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::has">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 353,
   FQN="llvm::cflaa::StratifiedSetsBuilder::has", NM="_ZNK4llvm5cflaa21StratifiedSetsBuilder3hasERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa21StratifiedSetsBuilder3hasERKT_")
  //</editor-fold>
  public boolean has(final /*const*/ T /*&*/ Elem) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::add">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 355,
   FQN="llvm::cflaa::StratifiedSetsBuilder::add", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder3addERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder3addERKT_")
  //</editor-fold>
  public boolean add(final /*const*/ T /*&*/ Main) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Restructures the stratified sets as necessary to make "ToAdd" in a
  /// set above "Main". There are some cases where this is not possible (see
  /// above), so we merge them such that ToAdd and Main are in the same set.
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::addAbove">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 366,
   FQN="llvm::cflaa::StratifiedSetsBuilder::addAbove", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder8addAboveERKT_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder8addAboveERKT_S4_")
  //</editor-fold>
  public boolean addAbove(final /*const*/ T /*&*/ Main, final /*const*/ T /*&*/ ToAdd) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Restructures the stratified sets as necessary to make "ToAdd" in a
  /// set below "Main". There are some cases where this is not possible (see
  /// above), so we merge them such that ToAdd and Main are in the same set.
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::addBelow">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 379,
   FQN="llvm::cflaa::StratifiedSetsBuilder::addBelow", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder8addBelowERKT_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder8addBelowERKT_S4_")
  //</editor-fold>
  public boolean addBelow(final /*const*/ T /*&*/ Main, final /*const*/ T /*&*/ ToAdd) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::addWith">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 389,
   FQN="llvm::cflaa::StratifiedSetsBuilder::addWith", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder7addWithERKT_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder7addWithERKT_S4_")
  //</editor-fold>
  public boolean addWith(final /*const*/ T /*&*/ Main, final /*const*/ T /*&*/ ToAdd) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::noteAttributes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 395,
   FQN="llvm::cflaa::StratifiedSetsBuilder::noteAttributes", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder14noteAttributesERKT_St6bitsetILj32EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder14noteAttributesERKT_St6bitsetILj32EE")
  //</editor-fold>
  public void noteAttributes(final /*const*/ T /*&*/ Main, std.bitset/*NumAliasAttrs*/ NewAttrs) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private DenseMap<T, StratifiedInfo> Values;
  private std.vector<BuilderLink> Links;
  
  /// Adds the given element at the given index, merging sets if necessary.
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::addAtMerging">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 407,
   FQN="llvm::cflaa::StratifiedSetsBuilder::addAtMerging", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder12addAtMergingERKT_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder12addAtMergingERKT_j")
  //</editor-fold>
  private boolean addAtMerging(final /*const*/ T /*&*/ ToAdd, /*uint*/int Index) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Gets the BuilderLink at the given index, taking set remapping into
  /// account.
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::linksAt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 426,
   FQN="llvm::cflaa::StratifiedSetsBuilder::linksAt", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder7linksAtEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder7linksAtEj")
  //</editor-fold>
  private BuilderLink /*&*/ linksAt(/*uint*/int Index) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Merges two sets into one another. Assumes that these sets are not
  /// already one in the same.
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::merge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 451,
   FQN="llvm::cflaa::StratifiedSetsBuilder::merge", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder5mergeEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder5mergeEjj")
  //</editor-fold>
  private void merge(/*uint*/int Idx1, /*uint*/int Idx2) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Merges two sets assuming that the set at `Idx1` is unreachable from
  /// traversing above or below the set at `Idx2`.
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::mergeDirect">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 472,
   FQN="llvm::cflaa::StratifiedSetsBuilder::mergeDirect", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder11mergeDirectEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder11mergeDirectEjj")
  //</editor-fold>
  private void mergeDirect(/*uint*/int Idx1, /*uint*/int Idx2) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Checks to see if lowerIndex is at a level lower than upperIndex. If so, it
  /// will merge lowerIndex with upperIndex (and all of the sets between) and
  /// return true. Otherwise, it will return false.
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::tryMergeUpwards">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 521,
   FQN="llvm::cflaa::StratifiedSetsBuilder::tryMergeUpwards", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder15tryMergeUpwardsEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder15tryMergeUpwardsEjj")
  //</editor-fold>
  private boolean tryMergeUpwards(/*uint*/int LowerIndex, /*uint*/int UpperIndex) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 557,
   FQN="llvm::cflaa::StratifiedSetsBuilder::get", NM="_ZNK4llvm5cflaa21StratifiedSetsBuilder3getERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa21StratifiedSetsBuilder3getERKT_")
  //</editor-fold>
  private OptionalPtr</*const*/ StratifiedInfo /*P*/ > get$Const(final /*const*/ T /*&*/ Val) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 564,
   FQN="llvm::cflaa::StratifiedSetsBuilder::get", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder3getERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder3getERKT_")
  //</editor-fold>
  private OptionalPtr<StratifiedInfo /*P*/ > get(final /*const*/ T /*&*/ Val) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::indexOf">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 571,
   FQN="llvm::cflaa::StratifiedSetsBuilder::indexOf", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder7indexOfERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder7indexOfERKT_")
  //</editor-fold>
  private OptionalUInt indexOf(final /*const*/ T /*&*/ Val) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::addLinkBelow">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 580,
   FQN="llvm::cflaa::StratifiedSetsBuilder::addLinkBelow", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder12addLinkBelowEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder12addLinkBelowEj")
  //</editor-fold>
  private /*uint*/int addLinkBelow(/*uint*/int Set) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::addLinkAbove">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 587,
   FQN="llvm::cflaa::StratifiedSetsBuilder::addLinkAbove", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder12addLinkAboveEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder12addLinkAboveEj")
  //</editor-fold>
  private /*uint*/int addLinkAbove(/*uint*/int Set) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::getNewUnlinkedIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 594,
   FQN="llvm::cflaa::StratifiedSetsBuilder::getNewUnlinkedIndex", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder19getNewUnlinkedIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder19getNewUnlinkedIndexEv")
  //</editor-fold>
  private /*uint*/int getNewUnlinkedIndex() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::addLinks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 596,
   FQN="llvm::cflaa::StratifiedSetsBuilder::addLinks", NM="_ZN4llvm5cflaa21StratifiedSetsBuilder8addLinksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa21StratifiedSetsBuilder8addLinksEv")
  //</editor-fold>
  private /*uint*/int addLinks() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSetsBuilder::inbounds">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 602,
   FQN="llvm::cflaa::StratifiedSetsBuilder::inbounds", NM="_ZNK4llvm5cflaa21StratifiedSetsBuilder8inboundsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa21StratifiedSetsBuilder8inboundsEj")
  //</editor-fold>
  private boolean inbounds(/*uint*/int N) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public void $destroy(){
  }
  
  @Override public String toString() {
    return "" + "Values=" + Values // NOI18N
              + ", Links=" + Links; // NOI18N
  }
}
