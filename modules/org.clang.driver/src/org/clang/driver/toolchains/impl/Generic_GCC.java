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

package org.clang.driver.toolchains.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.clank.support.NativeCallback.Converter;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.clang.driver.toolchains.impl.*;;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.driver.DriverGlobals.*;
import static org.clang.driver.impl.ToolChainsStatics.*;
import static org.clang.driver.ToolChain.*;
import org.clang.basic.vfs.directory_iterator;
import org.clang.driver.tools.impl.GccStatics;
import org.clang.driver.tools.impl.GnutoolsStatics;
import org.clang.basic.vfs.FileSystem;

/// Generic_GCC - A tool chain using the 'gcc' command to perform
/// all subcommands; this relies on gcc translating the majority of
/// command line options.
//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 33,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 31,
 FQN="clang::driver::toolchains::Generic_GCC", NM="_ZN5clang6driver10toolchains11Generic_GCCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCCE")
//</editor-fold>
public class Generic_GCC extends /*public*/ ToolChain implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Struct to store and manipulate GCC versions.
  ///
  /// We rely on assumptions about the form and structure of GCC version
  /// numbers: they consist of at most three '.'-separated components, and each
  /// component is a non-negative integer except for the last component. For
  /// the last component we are very flexible in order to tolerate release
  /// candidates or 'x' wildcards.
  ///
  /// Note that the ordering established among GCCVersions is based on the
  /// preferred version string to use. For example we prefer versions without
  /// a hard-coded patch number to those with a hard coded patch number.
  ///
  /// Currently this doesn't provide any logic for textual suffixes to patches
  /// in the way that (for example) Debian's version format does. If that ever
  /// becomes necessary, it can be added.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 50,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 48,
   FQN="clang::driver::toolchains::Generic_GCC::GCCVersion", NM="_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionE")
  //</editor-fold>
  public static class/*struct*/ GCCVersion implements Destructors.ClassWithDestructor {
    /// \brief The unparsed text of the version.
    public std.string Text;
    
    /// \brief The parsed major, minor, and patch numbers.
    public int Major;
    public int Minor;
    public int Patch;
    
    public final int$ref MajorRef = new int$ref() {
        public @Override int $deref() {
            return Major;
        }
        public @Override int $set(int value) {
            return Major = value;
        }
    };

    public final int$ref MinorRef = new int$ref() {
        public @Override int $deref() {
            return Minor;
        }
        public @Override int $set(int value) {
            return Minor = value;
        }
    };

    public final int$ref PatchRef = new int$ref() {
        public @Override int $deref() {
            return Patch;
        }
        public @Override int $set(int value) {
            return Patch = value;
        }
    };

    /// \brief The text of the parsed major, and major+minor versions.
    public std.string MajorStr;
    public std.string MinorStr;
    
    /// \brief Any textual suffix on the patch number.
    public std.string PatchSuffix;
    
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCVersion::GCCVersion">
    @Converted(kind = Converted.Kind.MANUAL_ADDED,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 50,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 48,
     FQN="clang::driver::toolchains::Generic_GCC::GCCVersion::GCCVersion", NM="_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionC1Ev")
    //</editor-fold>
    /// In factadded manually - analog of a struct initializer:
    /// const GCCVersion BadVersion = { VersionText.str(), -1, -1, -1, "", "", "" };
    public GCCVersion(string Text, int Major, int Minor, int Patch, String MajorStr, String MinorStr, String PatchSuffix) {
        this.Text = Text;
        this.Major = Major;
        this.Minor = Minor;
        this.Patch = Patch;
        this.MajorStr = new std.string(MajorStr);
        this.MinorStr = new std.string(MinorStr);
        this.PatchSuffix = new std.string(PatchSuffix);
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCVersion::GCCVersion">
    @Converted(kind = Converted.Kind.MANUAL_ADDED,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 50,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 48,
     FQN="clang::driver::toolchains::Generic_GCC::GCCVersion::GCCVersion", NM="_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionC1Ev")
    //</editor-fold>
    /// In factadded manually - analog of a struct initializer:
    /// const GCCVersion BadVersion = { VersionText.str(), -1, -1, -1, $(""), $(""), $("")};
    public GCCVersion(string Text, int Major, int Minor, int Patch, char$ptr MajorStr, char$ptr MinorStr, char$ptr PatchSuffix) {
        this.Text = Text;
        this.Major = Major;
        this.Minor = Minor;
        this.Patch = Patch;
        this.MajorStr = new std.string(MajorStr);
        this.MinorStr = new std.string(MinorStr);
        this.PatchSuffix = new std.string(PatchSuffix);
    }

    /// Generic_GCC - A tool chain using the 'gcc' command to perform
    /// all subcommands; this relies on gcc translating the majority of
    /// command line options.
    
    /// \brief Parse a GCCVersion object out of a string of text.
    ///
    /// This is the primary means of forming GCCVersion objects.
    /*static*/
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCVersion::Parse">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1286,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1235,
     FQN="clang::driver::toolchains::Generic_GCC::GCCVersion::Parse", NM="_ZN5clang6driver10toolchains11Generic_GCC10GCCVersion5ParseEN4llvm9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC10GCCVersion5ParseEN4llvm9StringRefE")
    //</editor-fold>
    public static Generic_GCC.GCCVersion Parse(StringRef VersionText) {
      /*const*/ GCCVersion BadVersion = new GCCVersion(VersionText.str(), -1, -1, -1, $EMPTY, $EMPTY, $EMPTY);
      std.pair<StringRef, StringRef> First = VersionText.split($$DOT);
      std.pair<StringRef, StringRef> Second = First.second.split($$DOT);
      
      GCCVersion GoodVersion = new GCCVersion(VersionText.str(), -1, -1, -1, $EMPTY, $EMPTY, $EMPTY);
      if (First.first.getAsInteger$Signed(10, GoodVersion.MajorRef) || GoodVersion.Major < 0) {
        return BadVersion;
      }
      GoodVersion.MajorStr.$assignMove(First.first.str());
      if (First.second.empty()) {
        return GoodVersion;
      }
      if (Second.first.getAsInteger$Signed(10, GoodVersion.MinorRef) || GoodVersion.Minor < 0) {
        return BadVersion;
      }
      GoodVersion.MinorStr.$assignMove(Second.first.str());
      
      // First look for a number prefix and parse that if present. Otherwise just
      // stash the entire patch string in the suffix, and leave the number
      // unspecified. This covers versions strings such as:
      //   5        (handled above)
      //   4.4
      //   4.4.0
      //   4.4.x
      //   4.4.2-rc4
      //   4.4.x-patched
      // And retains any patch number it finds.
      StringRef PatchText = new StringRef(GoodVersion.PatchSuffix.$assignMove(Second.second.str()));
      if (!PatchText.empty()) {
        {
          /*size_t*/int EndNumber = PatchText.find_first_not_of(/*STRINGREF_STR*/"0123456789");
          if ((EndNumber != 0)) {
            // Try to parse the number and any suffix.
            if (PatchText.slice(0, EndNumber).getAsInteger$Signed(10, GoodVersion.PatchRef)
               || GoodVersion.Patch < 0) {
              return BadVersion;
            }
            GoodVersion.PatchSuffix.$assignMove(PatchText.substr(EndNumber).$string());
          }
        }
      }
      
      return GoodVersion;
    }

    
    /// \brief Less-than for GCCVersion, implementing a Strict Weak Ordering.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCVersion::isOlderThan">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1326,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1272,
     FQN="clang::driver::toolchains::Generic_GCC::GCCVersion::isOlderThan", NM="_ZNK5clang6driver10toolchains11Generic_GCC10GCCVersion11isOlderThanEiiiN4llvm9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC10GCCVersion11isOlderThanEiiiN4llvm9StringRefE")
    //</editor-fold>
    public boolean isOlderThan(int RHSMajor, int RHSMinor, 
               int RHSPatch) /*const*/ {
      return isOlderThan(RHSMajor, RHSMinor, 
               RHSPatch, 
               new StringRef());
    }
    public boolean isOlderThan(int RHSMajor, int RHSMinor, 
               int RHSPatch, 
               StringRef RHSPatchSuffix/*= StringRef()*/) /*const*/ {
      if (Major != RHSMajor) {
        return Major < RHSMajor;
      }
      if (Minor != RHSMinor) {
        return Minor < RHSMinor;
      }
      if (Patch != RHSPatch) {
        // Note that versions without a specified patch sort higher than those with
        // a patch.
        if (RHSPatch == -1) {
          return true;
        }
        if (Patch == -1) {
          return false;
        }
        
        // Otherwise just sort on the patch itself.
        return Patch < RHSPatch;
      }
      if ($noteq_StringRef(new StringRef(PatchSuffix), /*NO_COPY*/RHSPatchSuffix)) {
        // Sort empty suffixes higher.
        if (RHSPatchSuffix.empty()) {
          return true;
        }
        if (PatchSuffix.empty()) {
          return false;
        }
        
        // Provide a lexicographic sort to make this a total ordering.
        return $less_StringRef(new StringRef(PatchSuffix), /*NO_COPY*/RHSPatchSuffix);
      }
      
      // The versions are equal.
      return false;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCVersion::operator<">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 66,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 64,
     FQN="clang::driver::toolchains::Generic_GCC::GCCVersion::operator<", NM="_ZNK5clang6driver10toolchains11Generic_GCC10GCCVersionltERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC10GCCVersionltERKS3_")
    //</editor-fold>
    public boolean $less(/*const*/ GCCVersion /*&*/ RHS) /*const*/ {
      return isOlderThan(RHS.Major, RHS.Minor, RHS.Patch, new StringRef(RHS.PatchSuffix));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCVersion::operator>">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 69,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 67,
     FQN="clang::driver::toolchains::Generic_GCC::GCCVersion::operator>", NM="_ZNK5clang6driver10toolchains11Generic_GCC10GCCVersiongtERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC10GCCVersiongtERKS3_")
    //</editor-fold>
    public boolean $greater(/*const*/ GCCVersion /*&*/ RHS) /*const*/ {
      return RHS.$less(/*Deref*/this);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCVersion::operator<=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 70,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 68,
     FQN="clang::driver::toolchains::Generic_GCC::GCCVersion::operator<=", NM="_ZNK5clang6driver10toolchains11Generic_GCC10GCCVersionleERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC10GCCVersionleERKS3_")
    //</editor-fold>
    public boolean $lesseq(/*const*/ GCCVersion /*&*/ RHS) /*const*/ {
      return !(/*Deref*/this.$greater(RHS));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCVersion::operator>=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 71,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 69,
     FQN="clang::driver::toolchains::Generic_GCC::GCCVersion::operator>=", NM="_ZNK5clang6driver10toolchains11Generic_GCC10GCCVersiongeERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC10GCCVersiongeERKS3_")
    //</editor-fold>
    public boolean $greatereq(/*const*/ GCCVersion /*&*/ RHS) /*const*/ {
      return !(/*Deref*/this.$less(RHS));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCVersion::GCCVersion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 50,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 48,
     FQN="clang::driver::toolchains::Generic_GCC::GCCVersion::GCCVersion", NM="_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionC1ERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionC1ERKS3_")
    //</editor-fold>
    public /*inline*/ GCCVersion(/*const*/ GCCVersion /*&*/ $Prm0) {
      /* : Text(.Text), Major(.Major), Minor(.Minor), Patch(.Patch), MajorStr(.MajorStr), MinorStr(.MinorStr), PatchSuffix(.PatchSuffix)*/ 
      //START JInit
      this.Text = new std.string($Prm0.Text);
      this.Major = $Prm0.Major;
      this.Minor = $Prm0.Minor;
      this.Patch = $Prm0.Patch;
      this.MajorStr = new std.string($Prm0.MajorStr);
      this.MinorStr = new std.string($Prm0.MinorStr);
      this.PatchSuffix = new std.string($Prm0.PatchSuffix);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCVersion::GCCVersion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 50,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 48,
     FQN="clang::driver::toolchains::Generic_GCC::GCCVersion::GCCVersion", NM="_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionC1EOS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionC1EOS3_")
    //</editor-fold>
    public /*inline*/ GCCVersion(JD$Move _dparam, GCCVersion /*&&*/$Prm0) {
      /* : Text(static_cast<GCCVersion &&>().Text), Major(static_cast<GCCVersion &&>().Major), Minor(static_cast<GCCVersion &&>().Minor), Patch(static_cast<GCCVersion &&>().Patch), MajorStr(static_cast<GCCVersion &&>().MajorStr), MinorStr(static_cast<GCCVersion &&>().MinorStr), PatchSuffix(static_cast<GCCVersion &&>().PatchSuffix)*/ 
      //START JInit
      this.Text = new std.string(JD$Move.INSTANCE, $Prm0.Text);
      this.Major = $Prm0.Major;
      this.Minor = $Prm0.Minor;
      this.Patch = $Prm0.Patch;
      this.MajorStr = new std.string(JD$Move.INSTANCE, $Prm0.MajorStr);
      this.MinorStr = new std.string(JD$Move.INSTANCE, $Prm0.MinorStr);
      this.PatchSuffix = new std.string(JD$Move.INSTANCE, $Prm0.PatchSuffix);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCVersion::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 50,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 48,
     FQN="clang::driver::toolchains::Generic_GCC::GCCVersion::operator=", NM="_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionaSERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionaSERKS3_")
    //</editor-fold>
    public /*inline*/ GCCVersion /*&*/ $assign(/*const*/ GCCVersion /*&*/ $Prm0) {
      this.Text.$assign($Prm0.Text);
      this.Major = $Prm0.Major;
      this.Minor = $Prm0.Minor;
      this.Patch = $Prm0.Patch;
      this.MajorStr.$assign($Prm0.MajorStr);
      this.MinorStr.$assign($Prm0.MinorStr);
      this.PatchSuffix.$assign($Prm0.PatchSuffix);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCVersion::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 50,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 48,
     FQN="clang::driver::toolchains::Generic_GCC::GCCVersion::operator=", NM="_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionaSEOS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionaSEOS3_")
    //</editor-fold>
    public /*inline*/ GCCVersion /*&*/ $assignMove(GCCVersion /*&&*/$Prm0) {
      this.Text.$assignMove($Prm0.Text);
      this.Major = $Prm0.Major;
      this.Minor = $Prm0.Minor;
      this.Patch = $Prm0.Patch;
      this.MajorStr.$assignMove($Prm0.MajorStr);
      this.MinorStr.$assignMove($Prm0.MinorStr);
      this.PatchSuffix.$assignMove($Prm0.PatchSuffix);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCVersion::~GCCVersion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 50,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 48,
     FQN="clang::driver::toolchains::Generic_GCC::GCCVersion::~GCCVersion", NM="_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      PatchSuffix.$destroy();
      MinorStr.$destroy();
      MajorStr.$destroy();
      Text.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCVersion::GCCVersion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 50,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 48,
     FQN="clang::driver::toolchains::Generic_GCC::GCCVersion::GCCVersion", NM="_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC10GCCVersionC1Ev")
    //</editor-fold>
    public /*inline*/ GCCVersion() {
      /* : Text(), MajorStr(), MinorStr(), PatchSuffix()*/ 
      //START JInit
      this.Text = new std.string();
      this.MajorStr = new std.string();
      this.MinorStr = new std.string();
      this.PatchSuffix = new std.string();
      //END JInit
    }

    
    public String toString() {
      return "" + "Text=" + Text // NOI18N
                + ", Major=" + Major // NOI18N
                + ", Minor=" + Minor // NOI18N
                + ", Patch=" + Patch // NOI18N
                + ", MajorStr=" + MajorStr // NOI18N
                + ", MinorStr=" + MinorStr // NOI18N
                + ", PatchSuffix=" + PatchSuffix; // NOI18N
    }
  };
  
  /// \brief This is a class to find a viable GCC installation for Clang to
  /// use.
  ///
  /// This class tries to find a GCC installation on the system, and report
  /// information about it. It starts from the host information provided to the
  /// Driver, and has logic for fuzzing that where appropriate.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 80,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 78,
   FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector", NM="_ZN5clang6driver10toolchains11Generic_GCC23GCCInstallationDetectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC23GCCInstallationDetectorE")
  //</editor-fold>
  public static class GCCInstallationDetector implements Destructors.ClassWithDestructor {
    private boolean IsValid;
    private Triple GCCTriple;
    private /*const*/ Driver /*&*/ D;
    
    // FIXME: These might be better as path objects.
    private std.string GCCInstallPath;
    private std.string GCCParentLibPath;
    
    /// The primary multilib appropriate for the given flags.
    private Multilib SelectedMultilib;
    /// On Biarch systems, this corresponds to the default multilib when
    /// targeting the non-default multilib. Otherwise, it is empty.
    private Optional<Multilib> BiarchSibling;
    
    private GCCVersion Version;
    
    // We retain the list of install paths that were considered and rejected in
    // order to print out detailed information in verbose mode.
    private std.setType<std.string> CandidateGCCInstallPaths;
    
    /// The set of multilibs that the detected installation supports.
    private MultilibSet Multilibs;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::GCCInstallationDetector">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 105,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 103,
     FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::GCCInstallationDetector", NM="_ZN5clang6driver10toolchains11Generic_GCC23GCCInstallationDetectorC1ERKNS0_6DriverE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC23GCCInstallationDetectorC1ERKNS0_6DriverE")
    //</editor-fold>
    public /*explicit*/ GCCInstallationDetector(/*const*/ Driver /*&*/ D) {
      /* : IsValid(false), GCCTriple(), D(D), GCCInstallPath(), GCCParentLibPath(), SelectedMultilib(), BiarchSibling(), Version(), CandidateGCCInstallPaths(), Multilibs()*/ 
      //START JInit
      this.IsValid = false;
      this.GCCTriple = new Triple();
      this./*&*/D=/*&*/D;
      this.GCCInstallPath = new std.string();
      this.GCCParentLibPath = new std.string();
      this.SelectedMultilib = new Multilib();
      this.BiarchSibling = new Optional<Multilib>();
      this.Version = new GCCVersion();
      this.CandidateGCCInstallPaths = new std.setType<std.string>();
      this.Multilibs = new MultilibSet();
      //END JInit
    }

    
    /// \brief Initialize a GCCInstallationDetector from the driver.
    ///
    /// This performs all of the autodetection and sets up the various paths.
    /// Once constructed, a GCCInstallationDetector is essentially immutable.
    ///
    /// FIXME: We shouldn't need an explicit TargetTriple parameter here, and
    /// should instead pull the target out of the driver. This is currently
    /// necessary because the driver doesn't store the final version of the target
    /// triple.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::init">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1375,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1321,
     FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::init", NM="_ZN5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector4initERKN4llvm6TripleERKNS4_3opt7ArgListENS4_8ArrayRefISsEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector4initERKN4llvm6TripleERKNS4_3opt7ArgListENS4_8ArrayRefISsEE")
    //</editor-fold>
    public void init(/*const*/ Triple /*&*/ TargetTriple, /*const*/ ArgList /*&*/ Args) {
      init(TargetTriple, Args, 
        ArrayRef.<std.string>None());
    }
    public void init(/*const*/ Triple /*&*/ TargetTriple, /*const*/ ArgList /*&*/ Args, 
        ArrayRef<std.string> ExtraTripleAliases/*= None*/) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Triple BiarchVariantTriple = TargetTriple.isArch32Bit() ? TargetTriple.get64BitArchVariant() : TargetTriple.get32BitArchVariant();
        // The library directories which may contain GCC installations.
        SmallVector<StringRef> CandidateLibDirs/*J*/= new SmallVector<StringRef>(4, new StringRef()), CandidateBiarchLibDirs/*J*/= new SmallVector<StringRef>(4, new StringRef());
        // The compatible GCC triples for this particular architecture.
        SmallVector<StringRef> CandidateTripleAliases/*J*/= new SmallVector<StringRef>(16, new StringRef());
        SmallVector<StringRef> CandidateBiarchTripleAliases/*J*/= new SmallVector<StringRef>(16, new StringRef());
        CollectLibDirsAndTriples(TargetTriple, BiarchVariantTriple, CandidateLibDirs, 
            CandidateTripleAliases, CandidateBiarchLibDirs, 
            CandidateBiarchTripleAliases);
        
        // Compute the set of prefixes for our search.
        SmallVector<std.string> Prefixes/*J*/= new SmallVector<std.string>(8, D.PrefixDirs.begin(), 
            D.PrefixDirs.end(), new std.string());
        
        StringRef GCCToolchainDir = getGCCToolchainDir(Args);
        if ($noteq_StringRef(/*NO_COPY*/GCCToolchainDir, /*STRINGREF_STR*/"")) {
          if (GCCToolchainDir.back() == $$SLASH) {
            GCCToolchainDir.$assignMove(GCCToolchainDir.drop_back()); // remove the /
          }
          
          Prefixes.push_back(GCCToolchainDir.$string());
        } else {
          // If we have a SysRoot, try that first.
          if (!D.SysRoot.empty()) {
            Prefixes.push_back(D.SysRoot);
            Prefixes.push_back($add_string$C_T(D.SysRoot, /*KEEP_STR*/"/usr"));
          }
          
          // Then look for gcc installed alongside clang.
          Prefixes.push_back($add_string$C_T(D.InstalledDir, /*KEEP_STR*/"/.."));
          
          // Then look for distribution supplied gcc installations.
          if (D.SysRoot.empty()) {
            // Look for RHEL devtoolsets.
            Prefixes.push_back(new std.string(/*KEEP_STR*/"/opt/rh/devtoolset-4/root/usr"));
            Prefixes.push_back(new std.string(/*KEEP_STR*/"/opt/rh/devtoolset-3/root/usr"));
            Prefixes.push_back(new std.string(/*KEEP_STR*/"/opt/rh/devtoolset-2/root/usr"));
            Prefixes.push_back(new std.string(/*KEEP_STR*/"/opt/rh/devtoolset-1.1/root/usr"));
            Prefixes.push_back(new std.string(/*KEEP_STR*/"/opt/rh/devtoolset-1.0/root/usr"));
            // And finally in /usr.
            Prefixes.push_back(new std.string(/*KEEP_STR*/"/usr"));
          }
        }
        
        // Loop over the various components which exist and select the best GCC
        // installation available. GCC installs are ranked by version number.
        $c$.clean(Version.$assignMove($c$.track(GCCVersion.Parse(new StringRef(/*KEEP_STR*/"0.0.0")))));
        for (/*const*/std.string/*&*/ Prefix : Prefixes) {
          if (!D.getVFS().exists(new Twine(Prefix))) {
            continue;
          }
          for (StringRef Suffix : CandidateLibDirs) {
            /*const*/std.string LibDir = $add_string$C_string(Prefix, Suffix.str());
            if (!D.getVFS().exists(new Twine(LibDir))) {
              continue;
            }
            for (std.string Candidate : ExtraTripleAliases)  { // Try these first.
              ScanLibDirForGCCTriple(TargetTriple, Args, LibDir, new StringRef(Candidate));
            }
            for (StringRef Candidate : CandidateTripleAliases)  {
              ScanLibDirForGCCTriple(TargetTriple, Args, LibDir, new StringRef(Candidate));
            }
          }
          for (StringRef Suffix : CandidateBiarchLibDirs) {
            /*const*/std.string LibDir = $add_string$C_string(Prefix, Suffix.str());
            if (!D.getVFS().exists(new Twine(LibDir))) {
              continue;
            }
            for (StringRef Candidate : CandidateBiarchTripleAliases)  {
              ScanLibDirForGCCTriple(TargetTriple, Args, LibDir, new StringRef(Candidate), 
                  /*NeedsBiarchSuffix=*/ true);
            }
          }
        }
      } finally {
        $c$.$destroy();
      }
    }

    
    /// \brief Check whether we detected a valid GCC install.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::isValid">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 110,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 108,
     FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::isValid", NM="_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector7isValidEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector7isValidEv")
    //</editor-fold>
    public boolean isValid() /*const*/ {
      return IsValid;
    }

    
    /// \brief Get the GCC triple for the detected install.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::getTriple">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 113,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 111,
     FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::getTriple", NM="_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector9getTripleEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector9getTripleEv")
    //</editor-fold>
    public /*const*/ Triple /*&*/ getTriple() /*const*/ {
      return GCCTriple;
    }

    
    /// \brief Get the detected GCC installation path.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::getInstallPath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 116,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 114,
     FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::getInstallPath", NM="_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector14getInstallPathEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector14getInstallPathEv")
    //</editor-fold>
    public StringRef getInstallPath() /*const*/ {
      return new StringRef(GCCInstallPath);
    }

    
    /// \brief Get the detected GCC parent lib path.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::getParentLibPath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 119,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 117,
     FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::getParentLibPath", NM="_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector16getParentLibPathEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector16getParentLibPathEv")
    //</editor-fold>
    public StringRef getParentLibPath() /*const*/ {
      return new StringRef(GCCParentLibPath);
    }

    
    /// \brief Get the detected Multilib
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::getMultilib">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 122,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 120,
     FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::getMultilib", NM="_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector11getMultilibEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector11getMultilibEv")
    //</editor-fold>
    public /*const*/ Multilib /*&*/ getMultilib() /*const*/ {
      return SelectedMultilib;
    }

    
    /// \brief Get the whole MultilibSet
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::getMultilibs">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 125,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 123,
     FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::getMultilibs", NM="_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector12getMultilibsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector12getMultilibsEv")
    //</editor-fold>
    public /*const*/ MultilibSet /*&*/ getMultilibs() /*const*/ {
      return Multilibs;
    }

    
    /// Get the biarch sibling multilib (if it exists).
    /// \return true iff such a sibling exists
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::getBiarchSibling">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1463,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1401,
     FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::getBiarchSibling", NM="_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector16getBiarchSiblingERNS0_8MultilibE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector16getBiarchSiblingERNS0_8MultilibE")
    //</editor-fold>
    public boolean getBiarchSibling(Multilib /*&*/ M) /*const*/ {
      if (BiarchSibling.hasValue()) {
        M.$assign(BiarchSibling.getValue());
        return true;
      }
      return false;
    }

    
    /// \brief Get the detected GCC version string.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::getVersion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 132,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 130,
     FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::getVersion", NM="_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector10getVersionEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector10getVersionEv")
    //</editor-fold>
    public /*const*/ GCCVersion /*&*/ getVersion() /*const*/ {
      return Version;
    }

    
    /// \brief Print information about the detected GCC installation.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::print">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1449,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1387,
     FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::print", NM="_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector5printERN4llvm11raw_ostreamE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector5printERN4llvm11raw_ostreamE")
    //</editor-fold>
    public void print(raw_ostream /*&*/ OS) /*const*/ {
      for (/*const*/std.string/*&*/ InstallPath : CandidateGCCInstallPaths)  {
        OS.$out(/*KEEP_STR*/"Found candidate GCC installation: ").$out(InstallPath).$out(/*KEEP_STR*/$LF);
      }
      if (!GCCInstallPath.empty()) {
        OS.$out(/*KEEP_STR*/"Selected GCC installation: ").$out(GCCInstallPath).$out(/*KEEP_STR*/$LF);
      }
      
      for (/*const*/ Multilib /*&*/ Multilib : Multilibs)  {
        $out_raw_ostream_Multilib$C(OS.$out(/*KEEP_STR*/"Candidate multilib: "), Multilib).$out(/*KEEP_STR*/$LF);
      }
      if (Multilibs.size() != 0 || !SelectedMultilib.isDefault()) {
        $out_raw_ostream_Multilib$C(OS.$out(/*KEEP_STR*/"Selected multilib: "), SelectedMultilib).$out(/*KEEP_STR*/$LF);
      }
    }

  /*private:*/
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    private static final class CharPtrToStringRefConverter implements Converter<char$ptr, StringRef> {

      static final CharPtrToStringRefConverter INSTANCE = new CharPtrToStringRefConverter();

      @Override
      public Class<StringRef> getToClass() {
        return StringRef.class;
      }

      @Override
      public StringRef $call(char$ptr from) {
        return new StringRef(from);
      }

    }

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    private static type$iterator<?, StringRef> begin(char$ptr strings[]) {
      return new convert_iterator<char$ptr, StringRef, type$ptr<char$ptr>>(
              create_type$ptr(strings),
              CharPtrToStringRefConverter.INSTANCE
      );
    }

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    private static type$iterator<?, StringRef> end(char$ptr strings[]) {
      return new convert_iterator<char$ptr, StringRef, type$ptr<char$ptr>>(
              create_type$ptr(strings, strings.length),
              CharPtrToStringRefConverter.INSTANCE
      );
    }

    /*static*/
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::CollectLibDirsAndTriples">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1471,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1409,
     FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::CollectLibDirsAndTriples", NM="_ZN5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector24CollectLibDirsAndTriplesERKN4llvm6TripleES7_RNS4_15SmallVectorImplINS4_9StringRefEEESB_SB_SB_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector24CollectLibDirsAndTriplesERKN4llvm6TripleES7_RNS4_15SmallVectorImplINS4_9StringRefEEESB_SB_SB_")
    //</editor-fold>
    private static void CollectLibDirsAndTriples(/*const*/ Triple /*&*/ TargetTriple, /*const*/ Triple /*&*/ BiarchTriple, 
                            SmallVectorImpl<StringRef> /*&*/ LibDirs, 
                            SmallVectorImpl<StringRef> /*&*/ TripleAliases, 
                            SmallVectorImpl<StringRef> /*&*/ BiarchLibDirs, 
                            SmallVectorImpl<StringRef> /*&*/ BiarchTripleAliases) {
      // Declare a bunch of static data sets that we'll select between below. These
      // are specifically designed to always refer to string literals to avoid any
      // lifetime or initialization issues.
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ AArch64LibDirs[/*2*/] = CollectLibDirsAndTriples$$.AArch64LibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ AArch64Triples[/*4*/] = CollectLibDirsAndTriples$$.AArch64Triples;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ AArch64beLibDirs[/*1*/] = CollectLibDirsAndTriples$$.AArch64beLibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ AArch64beTriples[/*2*/] = CollectLibDirsAndTriples$$.AArch64beTriples;
      
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ ARMLibDirs[/*1*/] = CollectLibDirsAndTriples$$.ARMLibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ ARMTriples[/*2*/] = CollectLibDirsAndTriples$$.ARMTriples;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ ARMHFTriples[/*2*/] = CollectLibDirsAndTriples$$.ARMHFTriples;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ ARMebLibDirs[/*1*/] = CollectLibDirsAndTriples$$.ARMebLibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ ARMebTriples[/*2*/] = CollectLibDirsAndTriples$$.ARMebTriples;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ ARMebHFTriples[/*2*/] = CollectLibDirsAndTriples$$.ARMebHFTriples;
      
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ X86_64LibDirs[/*2*/] = CollectLibDirsAndTriples$$.X86_64LibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ X86_64Triples[/*11*/] = CollectLibDirsAndTriples$$.X86_64Triples;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ X32LibDirs[/*1*/] = CollectLibDirsAndTriples$$.X32LibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ X86LibDirs[/*2*/] = CollectLibDirsAndTriples$$.X86LibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ X86Triples[/*13*/] = CollectLibDirsAndTriples$$.X86Triples;
      
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPSLibDirs[/*1*/] = CollectLibDirsAndTriples$$.MIPSLibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPSTriples[/*4*/] = CollectLibDirsAndTriples$$.MIPSTriples;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPSELLibDirs[/*1*/] = CollectLibDirsAndTriples$$.MIPSELLibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPSELTriples[/*3*/] = CollectLibDirsAndTriples$$.MIPSELTriples;
      
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPS64LibDirs[/*2*/] = CollectLibDirsAndTriples$$.MIPS64LibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPS64Triples[/*4*/] = CollectLibDirsAndTriples$$.MIPS64Triples;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPS64ELLibDirs[/*2*/] = CollectLibDirsAndTriples$$.MIPS64ELLibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPS64ELTriples[/*5*/] = CollectLibDirsAndTriples$$.MIPS64ELTriples;
      
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ PPCLibDirs[/*2*/] = CollectLibDirsAndTriples$$.PPCLibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ PPCTriples[/*5*/] = CollectLibDirsAndTriples$$.PPCTriples;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ PPC64LibDirs[/*2*/] = CollectLibDirsAndTriples$$.PPC64LibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ PPC64Triples[/*4*/] = CollectLibDirsAndTriples$$.PPC64Triples;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ PPC64LELibDirs[/*2*/] = CollectLibDirsAndTriples$$.PPC64LELibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ PPC64LETriples[/*4*/] = CollectLibDirsAndTriples$$.PPC64LETriples;
      
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ SPARCv8LibDirs[/*2*/] = CollectLibDirsAndTriples$$.SPARCv8LibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ SPARCv8Triples[/*2*/] = CollectLibDirsAndTriples$$.SPARCv8Triples;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ SPARCv9LibDirs[/*2*/] = CollectLibDirsAndTriples$$.SPARCv9LibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ SPARCv9Triples[/*2*/] = CollectLibDirsAndTriples$$.SPARCv9Triples;
      
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ SystemZLibDirs[/*2*/] = CollectLibDirsAndTriples$$.SystemZLibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ SystemZTriples[/*5*/] = CollectLibDirsAndTriples$$.SystemZTriples;
      
      // Solaris.
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ SolarisSPARCLibDirs[/*1*/] = CollectLibDirsAndTriples$$.SolarisSPARCLibDirs;
      final/*static*/ /*const*/char$ptr/*char P*//*const*/ SolarisSPARCTriples[/*2*/] = CollectLibDirsAndTriples$$.SolarisSPARCTriples;
      
      //JAVA: using std::begin;
      //JAVA: using std::end;
      if (TargetTriple.getOS() == Triple.OSType.Solaris) {
        LibDirs.append_T(begin(SolarisSPARCLibDirs), end(SolarisSPARCLibDirs));
        TripleAliases.append_T(begin(SolarisSPARCTriples), end(SolarisSPARCTriples));
        return;
      }
      switch (TargetTriple.getArch()) {
       case aarch64:
        LibDirs.append_T(begin(AArch64LibDirs), end(AArch64LibDirs));
        TripleAliases.append_T(begin(AArch64Triples), end(AArch64Triples));
        BiarchLibDirs.append_T(begin(AArch64LibDirs), end(AArch64LibDirs));
        BiarchTripleAliases.append_T(begin(AArch64Triples), end(AArch64Triples));
        break;
       case aarch64_be:
        LibDirs.append_T(begin(AArch64beLibDirs), end(AArch64beLibDirs));
        TripleAliases.append_T(begin(AArch64beTriples), end(AArch64beTriples));
        BiarchLibDirs.append_T(begin(AArch64beLibDirs), end(AArch64beLibDirs));
        BiarchTripleAliases.append_T(begin(AArch64beTriples), end(AArch64beTriples));
        break;
       case arm:
       case thumb:
        LibDirs.append_T(begin(ARMLibDirs), end(ARMLibDirs));
        if (TargetTriple.getEnvironment() == Triple.EnvironmentType.GNUEABIHF) {
          TripleAliases.append_T(begin(ARMHFTriples), end(ARMHFTriples));
        } else {
          TripleAliases.append_T(begin(ARMTriples), end(ARMTriples));
        }
        break;
       case armeb:
       case thumbeb:
        LibDirs.append_T(begin(ARMebLibDirs), end(ARMebLibDirs));
        if (TargetTriple.getEnvironment() == Triple.EnvironmentType.GNUEABIHF) {
          TripleAliases.append_T(begin(ARMebHFTriples), end(ARMebHFTriples));
        } else {
          TripleAliases.append_T(begin(ARMebTriples), end(ARMebTriples));
        }
        break;
       case x86_64:
        LibDirs.append_T(begin(X86_64LibDirs), end(X86_64LibDirs));
        TripleAliases.append_T(begin(X86_64Triples), end(X86_64Triples));
        // x32 is always available when x86_64 is available, so adding it as
        // secondary arch with x86_64 triples
        if (TargetTriple.getEnvironment() == Triple.EnvironmentType.GNUX32) {
          BiarchLibDirs.append_T(begin(X32LibDirs), end(X32LibDirs));
          BiarchTripleAliases.append_T(begin(X86_64Triples), end(X86_64Triples));
        } else {
          BiarchLibDirs.append_T(begin(X86LibDirs), end(X86LibDirs));
          BiarchTripleAliases.append_T(begin(X86Triples), end(X86Triples));
        }
        break;
       case x86:
        LibDirs.append_T(begin(X86LibDirs), end(X86LibDirs));
        // MCU toolchain is 32 bit only and its triple alias is TargetTriple
        // itself, which will be appended below.
        if (!TargetTriple.isOSIAMCU()) {
          TripleAliases.append_T(begin(X86Triples), end(X86Triples));
          BiarchLibDirs.append_T(begin(X86_64LibDirs), end(X86_64LibDirs));
          BiarchTripleAliases.append_T(begin(X86_64Triples), end(X86_64Triples));
        }
        break;
       case mips:
        LibDirs.append_T(begin(MIPSLibDirs), end(MIPSLibDirs));
        TripleAliases.append_T(begin(MIPSTriples), end(MIPSTriples));
        BiarchLibDirs.append_T(begin(MIPS64LibDirs), end(MIPS64LibDirs));
        BiarchTripleAliases.append_T(begin(MIPS64Triples), end(MIPS64Triples));
        break;
       case mipsel:
        LibDirs.append_T(begin(MIPSELLibDirs), end(MIPSELLibDirs));
        TripleAliases.append_T(begin(MIPSELTriples), end(MIPSELTriples));
        TripleAliases.append_T(begin(MIPSTriples), end(MIPSTriples));
        BiarchLibDirs.append_T(begin(MIPS64ELLibDirs), end(MIPS64ELLibDirs));
        BiarchTripleAliases.append_T(begin(MIPS64ELTriples), end(MIPS64ELTriples));
        break;
       case mips64:
        LibDirs.append_T(begin(MIPS64LibDirs), end(MIPS64LibDirs));
        TripleAliases.append_T(begin(MIPS64Triples), end(MIPS64Triples));
        BiarchLibDirs.append_T(begin(MIPSLibDirs), end(MIPSLibDirs));
        BiarchTripleAliases.append_T(begin(MIPSTriples), end(MIPSTriples));
        break;
       case mips64el:
        LibDirs.append_T(begin(MIPS64ELLibDirs), end(MIPS64ELLibDirs));
        TripleAliases.append_T(begin(MIPS64ELTriples), end(MIPS64ELTriples));
        BiarchLibDirs.append_T(begin(MIPSELLibDirs), end(MIPSELLibDirs));
        BiarchTripleAliases.append_T(begin(MIPSELTriples), end(MIPSELTriples));
        BiarchTripleAliases.append_T(begin(MIPSTriples), end(MIPSTriples));
        break;
       case ppc:
        LibDirs.append_T(begin(PPCLibDirs), end(PPCLibDirs));
        TripleAliases.append_T(begin(PPCTriples), end(PPCTriples));
        BiarchLibDirs.append_T(begin(PPC64LibDirs), end(PPC64LibDirs));
        BiarchTripleAliases.append_T(begin(PPC64Triples), end(PPC64Triples));
        break;
       case ppc64:
        LibDirs.append_T(begin(PPC64LibDirs), end(PPC64LibDirs));
        TripleAliases.append_T(begin(PPC64Triples), end(PPC64Triples));
        BiarchLibDirs.append_T(begin(PPCLibDirs), end(PPCLibDirs));
        BiarchTripleAliases.append_T(begin(PPCTriples), end(PPCTriples));
        break;
       case ppc64le:
        LibDirs.append_T(begin(PPC64LELibDirs), end(PPC64LELibDirs));
        TripleAliases.append_T(begin(PPC64LETriples), end(PPC64LETriples));
        break;
       case sparc:
       case sparcel:
        LibDirs.append_T(begin(SPARCv8LibDirs), end(SPARCv8LibDirs));
        TripleAliases.append_T(begin(SPARCv8Triples), end(SPARCv8Triples));
        BiarchLibDirs.append_T(begin(SPARCv9LibDirs), end(SPARCv9LibDirs));
        BiarchTripleAliases.append_T(begin(SPARCv9Triples), end(SPARCv9Triples));
        break;
       case sparcv9:
        LibDirs.append_T(begin(SPARCv9LibDirs), end(SPARCv9LibDirs));
        TripleAliases.append_T(begin(SPARCv9Triples), end(SPARCv9Triples));
        BiarchLibDirs.append_T(begin(SPARCv8LibDirs), end(SPARCv8LibDirs));
        BiarchTripleAliases.append_T(begin(SPARCv8Triples), end(SPARCv8Triples));
        break;
       case systemz:
        LibDirs.append_T(begin(SystemZLibDirs), end(SystemZLibDirs));
        TripleAliases.append_T(begin(SystemZTriples), end(SystemZTriples));
        break;
       default:
        // By default, just rely on the standard lib directories and the original
        // triple.
        break;
      }
      
      // Always append the drivers target triple to the end, in case it doesn't
      // match any of our aliases.
      TripleAliases.push_back(new StringRef(TargetTriple.str()));
      
      // Also include the multiarch variant if it's different.
      if ($noteq_string$C(TargetTriple.str(), BiarchTriple.str())) {
        BiarchTripleAliases.push_back(new StringRef(BiarchTriple.str()));
      }
    }
    private static final class CollectLibDirsAndTriples$$ {
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ AArch64LibDirs[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("/lib64"), $("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ AArch64Triples[/*4*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*4*/] {
  $("aarch64-none-linux-gnu"), $("aarch64-linux-gnu"), $("aarch64-linux-android"), 
  $("aarch64-redhat-linux")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ AArch64beLibDirs[/*1*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*1*/] {$("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ AArch64beTriples[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {
  $("aarch64_be-none-linux-gnu"), 
  $("aarch64_be-linux-gnu")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ ARMLibDirs[/*1*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*1*/] {$("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ ARMTriples[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {
  $("arm-linux-gnueabi"), 
  $("arm-linux-androideabi")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ ARMHFTriples[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {
  $("arm-linux-gnueabihf"), 
  $("armv7hl-redhat-linux-gnueabi")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ ARMebLibDirs[/*1*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*1*/] {$("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ ARMebTriples[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {
  $("armeb-linux-gnueabi"), 
  $("armeb-linux-androideabi")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ ARMebHFTriples[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("armeb-linux-gnueabihf"), $("armebv7hl-redhat-linux-gnueabi")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ X86_64LibDirs[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("/lib64"), $("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ X86_64Triples[/*11*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*11*/] {
  $("x86_64-linux-gnu"), $("x86_64-unknown-linux-gnu"), 
  $("x86_64-pc-linux-gnu"), $("x86_64-redhat-linux6E"), 
  $("x86_64-redhat-linux"), $("x86_64-suse-linux"), 
  $("x86_64-manbo-linux-gnu"), $("x86_64-linux-gnu"), 
  $("x86_64-slackware-linux"), $("x86_64-linux-android"), 
  $("x86_64-unknown-linux")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ X32LibDirs[/*1*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*1*/] {$("/libx32")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ X86LibDirs[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("/lib32"), $("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ X86Triples[/*13*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*13*/] {
  $("i686-linux-gnu"), $("i686-pc-linux-gnu"), $("i486-linux-gnu"), 
  $("i386-linux-gnu"), $("i386-redhat-linux6E"), $("i686-redhat-linux"), 
  $("i586-redhat-linux"), $("i386-redhat-linux"), $("i586-suse-linux"), 
  $("i486-slackware-linux"), $("i686-montavista-linux"), $("i686-linux-android"), 
  $("i586-linux-gnu")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPSLibDirs[/*1*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*1*/] {$("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPSTriples[/*4*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*4*/] {
  $("mips-linux-gnu"), $("mips-mti-linux"), 
  $("mips-mti-linux-gnu"), 
  $("mips-img-linux-gnu")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPSELLibDirs[/*1*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*1*/] {$("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPSELTriples[/*3*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*3*/] {$("mipsel-linux-gnu"), $("mipsel-linux-android"), $("mips-img-linux-gnu")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPS64LibDirs[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("/lib64"), $("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPS64Triples[/*4*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*4*/] {
  $("mips64-linux-gnu"), $("mips-mti-linux-gnu"), $("mips-img-linux-gnu"), 
  $("mips64-linux-gnuabi64")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPS64ELLibDirs[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("/lib64"), $("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ MIPS64ELTriples[/*5*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {
  $("mips64el-linux-gnu"), $("mips-mti-linux-gnu"), $("mips-img-linux-gnu"), 
  $("mips64el-linux-android"), $("mips64el-linux-gnuabi64")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ PPCLibDirs[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("/lib32"), $("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ PPCTriples[/*5*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {
  $("powerpc-linux-gnu"), $("powerpc-unknown-linux-gnu"), $("powerpc-linux-gnuspe"), 
  $("powerpc-suse-linux"), $("powerpc-montavista-linuxspe")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ PPC64LibDirs[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("/lib64"), $("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ PPC64Triples[/*4*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*4*/] {
  $("powerpc64-linux-gnu"), $("powerpc64-unknown-linux-gnu"), 
  $("powerpc64-suse-linux"), $("ppc64-redhat-linux")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ PPC64LELibDirs[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("/lib64"), $("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ PPC64LETriples[/*4*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*4*/] {
  $("powerpc64le-linux-gnu"), $("powerpc64le-unknown-linux-gnu"), 
  $("powerpc64le-suse-linux"), $("ppc64le-redhat-linux")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ SPARCv8LibDirs[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("/lib32"), $("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ SPARCv8Triples[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {
  $("sparc-linux-gnu"), 
  $("sparcv8-linux-gnu")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ SPARCv9LibDirs[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("/lib64"), $("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ SPARCv9Triples[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {
  $("sparc64-linux-gnu"), 
  $("sparcv9-linux-gnu")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ SystemZLibDirs[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("/lib64"), $("/lib")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ SystemZTriples[/*5*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {
  $("s390x-linux-gnu"), $("s390x-unknown-linux-gnu"), $("s390x-ibm-linux-gnu"), 
  $("s390x-suse-linux"), $("s390x-redhat-linux")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ SolarisSPARCLibDirs[/*1*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*1*/] {$("/gcc")});
      static final/*static*/ /*const*/char$ptr/*char P*//*const*/ SolarisSPARCTriples[/*2*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {
  $("sparc-sun-solaris2.11"), 
  $("i386-pc-solaris2.11")});
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::ScanLibDirForGCCTriple">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2549,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2231,
     FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::ScanLibDirForGCCTriple", NM="_ZN5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector22ScanLibDirForGCCTripleERKN4llvm6TripleERKNS4_3opt7ArgListERKSsNS4_9StringRefEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector22ScanLibDirForGCCTripleERKN4llvm6TripleERKNS4_3opt7ArgListERKSsNS4_9StringRefEb")
    //</editor-fold>
    private void ScanLibDirForGCCTriple(/*const*/ Triple /*&*/ TargetTriple, /*const*/ ArgList /*&*/ Args, 
                          /*const*/std.string/*&*/ LibDir, StringRef CandidateTriple) {
      ScanLibDirForGCCTriple(TargetTriple, Args, 
                          LibDir, CandidateTriple, 
                          false);
    }
    private void ScanLibDirForGCCTriple(/*const*/ Triple /*&*/ TargetTriple, /*const*/ ArgList /*&*/ Args, 
                          /*const*/std.string/*&*/ LibDir, StringRef CandidateTriple, 
                          boolean NeedsBiarchSuffix/*= false*/) {
      Triple.ArchType TargetArch = TargetTriple.getArch();
      // There are various different suffixes involving the triple we
      // check for. We also record what is necessary to walk from each back
      // up to the lib directory. Specifically, the number of "up" steps
      // in the second half of each row is 1 + the number of path separators
      // in the first half.
      /*const*/std.string LibAndInstallSuffixes[/*5*/][/*2*/] = new /*const*/std.string [/*5*/][/*2*/] {
        new /*const*/std.string [/*2*/] {$add_T_string(/*KEEP_STR*/"/gcc/", CandidateTriple.str()), new std.string("/../../..")}, 
        
        // Debian puts cross-compilers in gcc-cross
        new /*const*/std.string [/*2*/] {$add_T_string(/*KEEP_STR*/"/gcc-cross/", CandidateTriple.str()), new std.string("/../../..")}, 
        new /*const*/std.string [/*2*/] {
          $add_string($add_string_T($add_T_string(/*KEEP_STR*/"/", CandidateTriple.str()), /*KEEP_STR*/"/gcc/"), CandidateTriple.str()), 
          new std.string("/../../../..")}, 
        
        // The Freescale PPC SDK has the gcc libraries in
        // <sysroot>/usr/lib/<triple>/x.y.z so have a look there as well.
        new /*const*/std.string [/*2*/] {$add_T_string(/*KEEP_STR*/"/", CandidateTriple.str()), new std.string("/../..")}, 
        
        // Ubuntu has a strange mis-matched pair of triples that this happens to
        // match.
        // FIXME: It may be worthwhile to generalize this and look for a second
        // triple.
        new /*const*/std.string [/*2*/] {$add_T_string(/*KEEP_STR*/"/i386-linux-gnu/gcc/", CandidateTriple.str()), new std.string("/../../../..")}};
      if (TargetTriple.getOS() == Triple.OSType.Solaris) {
        scanLibDirForGCCTripleSolaris(TargetTriple, Args, LibDir, new StringRef(CandidateTriple), 
            NeedsBiarchSuffix);
        return;
      }
      
      // Only look at the final, weird Ubuntu suffix for i386-linux-gnu.
      /*const*//*uint*/int NumLibSuffixes = (llvm.array_lengthof(LibAndInstallSuffixes)
         - ((TargetArch != Triple.ArchType.x86) ? 1 : 0));
      for (/*uint*/int i = 0; $less_uint(i, NumLibSuffixes); ++i) {
        StringRef LibSuffix = new StringRef(LibAndInstallSuffixes[i][0]);
        std.error_code EC/*J*/= new std.error_code();
        for (directory_iterator LI = D.getVFS().dir_begin($add_Twine(new Twine(LibDir), new Twine(LibSuffix)), EC), 
            LE/*J*/= new directory_iterator();
             !EC.$bool() && LI.$noteq(LE); LI.$assign(LI.increment(EC))) {
          GCCVersion CandidateVersion = null;
          DetectedMultilibs Detected = null;
          try {
            StringRef VersionText = path.filename(LI.$arrow().getName());
            CandidateVersion = GCCVersion.Parse(new StringRef(VersionText));
            if (CandidateVersion.Major != -1) { // Filter obviously bad entries.
              if (!CandidateGCCInstallPaths.insert(LI.$arrow().getName().$string()).second) {
                continue; // Saw this path before; no need to look at it again.
              }
            }
            if (CandidateVersion.isOlderThan(4, 1, 1)) {
              continue;
            }
            if (CandidateVersion.$lesseq(Version)) {
              continue;
            }
            
            Detected/*J*/= new DetectedMultilibs();
            
            // Android standalone toolchain could have multilibs for ARM and Thumb.
            // Debian mips multilibs behave more like the rest of the biarch ones,
            // so handle them there
            if (isArmOrThumbArch(TargetArch) && TargetTriple.isAndroid()) {
              // It should also work without multilibs in a simplified toolchain.
              findAndroidArmMultilibs(D, TargetTriple, LI.$arrow().getName(), Args, Detected);
            } else if (isMipsArch(TargetArch)) {
              if (!findMIPSMultilibs(D, TargetTriple, LI.$arrow().getName(), Args, Detected)) {
                continue;
              }
            } else if (!findBiarchMultilibs(D, TargetTriple, LI.$arrow().getName(), Args, 
                NeedsBiarchSuffix, Detected)) {
              continue;
            }
            
            Multilibs.$assign(Detected.Multilibs);
            SelectedMultilib.$assign(Detected.SelectedMultilib);
            BiarchSibling.$assign(Detected.BiarchSibling);
            Version.$assign(CandidateVersion);
            GCCTriple.setTriple(new Twine(CandidateTriple));
            // FIXME: We hack together the directory name here instead of
            // using LI to ensure stable path separators across Windows and
            // Linux.
            GCCInstallPath.$assignMove($add_string($add_string_T($add_string$C(LibDir, LibAndInstallSuffixes[i][0]), /*KEEP_STR*/"/"), VersionText.str()));
            GCCParentLibPath.$assignMove($add_string$C(GCCInstallPath, LibAndInstallSuffixes[i][1]));
            IsValid = true;
          } finally {
            if (Detected != null) { Detected.$destroy(); }
            if (CandidateVersion != null) { CandidateVersion.$destroy(); }
          }
        }
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::scanLibDirForGCCTripleSolaris">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2499,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2181,
     FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::scanLibDirForGCCTripleSolaris", NM="_ZN5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector29scanLibDirForGCCTripleSolarisERKN4llvm6TripleERKNS4_3opt7ArgListERKSsNS4_9StringRefEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC23GCCInstallationDetector29scanLibDirForGCCTripleSolarisERKN4llvm6TripleERKNS4_3opt7ArgListERKSsNS4_9StringRefEb")
    //</editor-fold>
    private void scanLibDirForGCCTripleSolaris(/*const*/ Triple /*&*/ TargetArch, /*const*/ ArgList /*&*/ Args, 
                                 /*const*/std.string/*&*/ LibDir, StringRef CandidateTriple) {
      scanLibDirForGCCTripleSolaris(TargetArch, Args, 
                                 LibDir, CandidateTriple, 
                                 false);
    }
    private void scanLibDirForGCCTripleSolaris(/*const*/ Triple /*&*/ TargetArch, /*const*/ ArgList /*&*/ Args, 
                                 /*const*/std.string/*&*/ LibDir, StringRef CandidateTriple, 
                                 boolean NeedsBiarchSuffix/*= false*/) {
      // Solaris is a special case. The GCC installation is under
      // /usr/gcc/<major>.<minor>/lib/gcc/<triple>/<major>.<minor>.<patch>/, so we
      // need to iterate twice.
      std.error_code EC/*J*/= new std.error_code();
      for (directory_iterator LI = D.getVFS().dir_begin(new Twine(LibDir), EC), LE/*J*/= new directory_iterator();
           !EC.$bool() && LI.$noteq(LE); LI.$assign(LI.increment(EC))) {
        GCCVersion CandidateVersion = null;
        try {
          StringRef VersionText = path.filename(LI.$arrow().getName());
          CandidateVersion = GCCVersion.Parse(new StringRef(VersionText));
          if (CandidateVersion.Major != -1) { // Filter obviously bad entries.
            if (!CandidateGCCInstallPaths.insert(LI.$arrow().getName().$string()).second) {
              continue; // Saw this path before; no need to look at it again.
            }
          }
          if (CandidateVersion.isOlderThan(4, 1, 1)) {
            continue;
          }
          if (CandidateVersion.$lesseq(Version)) {
            continue;
          }
          
          GCCInstallPath.$assignMove($add_string($add_string_T($add_string($add_string$C_T(LibDir, /*KEEP_STR*/"/"), VersionText.str()), /*KEEP_STR*/"/lib/gcc/"), CandidateTriple.str()));
          if (!D.getVFS().exists(new Twine(GCCInstallPath))) {
            continue;
          }
          
          // If we make it here there has to be at least one GCC version, let's just
          // use the latest one.
          std.error_code EEC/*J*/= new std.error_code();
          for (directory_iterator LLI = D.getVFS().dir_begin(new Twine(GCCInstallPath), EEC), 
              LLE/*J*/= new directory_iterator();
               !EEC.$bool() && LLI.$noteq(LLE); LLI.$assign(LLI.increment(EEC))) {
            GCCVersion CandidateSubVersion = null;
            try {
              
              StringRef SubVersionText = path.filename(LLI.$arrow().getName());
              CandidateSubVersion = GCCVersion.Parse(new StringRef(SubVersionText));
              if (CandidateSubVersion.$greater(Version)) {
                Version.$assign(CandidateSubVersion);
              }
            } finally {
              if (CandidateSubVersion != null) { CandidateSubVersion.$destroy(); }
            }
          }
          
          GCCTriple.setTriple(new Twine(CandidateTriple));
          
          GCCInstallPath.$addassign($add_T_string$C(/*KEEP_STR*/"/", Version.Text));
          GCCParentLibPath.$assignMove($add_string$C_T(GCCInstallPath, /*KEEP_STR*/"/../../../../"));
          
          IsValid = true;
        } finally {
          if (CandidateVersion != null) { CandidateVersion.$destroy(); }
        }
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::~GCCInstallationDetector">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 80,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 78,
     FQN="clang::driver::toolchains::Generic_GCC::GCCInstallationDetector::~GCCInstallationDetector", NM="_ZN5clang6driver10toolchains11Generic_GCC23GCCInstallationDetectorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC23GCCInstallationDetectorD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Multilibs.$destroy();
      CandidateGCCInstallPaths.$destroy();
      Version.$destroy();
      BiarchSibling.$destroy();
      SelectedMultilib.$destroy();
      GCCParentLibPath.$destroy();
      GCCInstallPath.$destroy();
      GCCTriple.$destroy();
      //END JDestroy
    }

    
    public String toString() {
      return "" + "IsValid=" + IsValid // NOI18N
                + ", GCCTriple=" + GCCTriple // NOI18N
                + ", D=" + D // NOI18N
                + ", GCCInstallPath=" + GCCInstallPath // NOI18N
                + ", GCCParentLibPath=" + GCCParentLibPath // NOI18N
                + ", SelectedMultilib=" + SelectedMultilib // NOI18N
                + ", BiarchSibling=" + BiarchSibling // NOI18N
                + ", Version=" + Version // NOI18N
                + ", CandidateGCCInstallPaths=" + CandidateGCCInstallPaths // NOI18N
                + ", Multilibs=" + Multilibs; // NOI18N
    }
  };
/*protected:*/
  protected GCCInstallationDetector GCCInstallation;
  
  // \brief A class to find a viable CUDA installation
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 163,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 162,
   FQN="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector", NM="_ZN5clang6driver10toolchains11Generic_GCC24CudaInstallationDetectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC24CudaInstallationDetectorE")
  //</editor-fold>
  public static class CudaInstallationDetector implements Destructors.ClassWithDestructor {
  /*private:*/
    private /*const*/ Driver /*&*/ D;
    private boolean IsValid/* = false*/;
    private CudaVersion Version/* = CudaVersion::UNKNOWN*/;
    private std.string InstallPath;
    private std.string BinPath;
    private std.string LibPath;
    private std.string LibDevicePath;
    private std.string IncludePath;
    private StringMap<std.string> LibDeviceMap;
    
    // CUDA architectures for which we have raised an error in
    // CheckCudaVersionSupportsArch.
    private /*mutable */SmallSet<CudaArch> ArchsWithVersionTooLowErrors;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::CudaInstallationDetector">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 180,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 172,
     FQN="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::CudaInstallationDetector", NM="_ZN5clang6driver10toolchains11Generic_GCC24CudaInstallationDetectorC1ERKNS0_6DriverE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC24CudaInstallationDetectorC1ERKNS0_6DriverE")
    //</editor-fold>
    public CudaInstallationDetector(/*const*/ Driver /*&*/ D) {
      /* : D(D), IsValid(false), Version(CudaVersion::UNKNOWN), InstallPath(), BinPath(), LibPath(), LibDevicePath(), IncludePath(), LibDeviceMap(), ArchsWithVersionTooLowErrors()*/ 
      //START JInit
      this./*&*/D=/*&*/D;
      /*InClass*/this.IsValid = false;
      /*InClass*/this.Version = CudaVersion.UNKNOWN;
      this.InstallPath = new std.string();
      this.BinPath = new std.string();
      this.LibPath = new std.string();
      this.LibDevicePath = new std.string();
      this.IncludePath = new std.string();
      this.LibDeviceMap = new StringMap<std.string>(std.string.EMPTY);
      this.ArchsWithVersionTooLowErrors = new SmallSet<CudaArch>(4, CudaArch.valueOf(0), CUDA_ARCH_COMPARATOR);
      //END JInit
    }

    
    // \brief -- try common CUDA installation paths looking for files we need for
    // CUDA compilation.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::init">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1727,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1637,
     FQN="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::init", NM="_ZN5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector4initERKN4llvm6TripleERKNS4_3opt7ArgListE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector4initERKN4llvm6TripleERKNS4_3opt7ArgListE")
    //</editor-fold>
    public void init(/*const*/ Triple /*&*/ TargetTriple, /*const*/ ArgList /*&*/ Args) {
      SmallVector<std.string> CudaPathCandidates/*J*/= new SmallVector<std.string>(4, new std.string());
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_cuda_path_EQ.getValue()))) {
        CudaPathCandidates.push_back(Args.getLastArgValue(new OptSpecifier(options.ID.OPT_cuda_path_EQ.getValue())).$string());
      } else {
        CudaPathCandidates.push_back($add_string$C_T(D.SysRoot, /*KEEP_STR*/"/usr/local/cuda"));
        // FIXME: Uncomment this once we can compile the cuda 8 headers.
        // CudaPathCandidates.push_back(D.SysRoot + "/usr/local/cuda-8.0");
        CudaPathCandidates.push_back($add_string$C_T(D.SysRoot, /*KEEP_STR*/"/usr/local/cuda-7.5"));
        CudaPathCandidates.push_back($add_string$C_T(D.SysRoot, /*KEEP_STR*/"/usr/local/cuda-7.0"));
      }
      
      for (/*const*/std.string/*&*/ CudaPath : CudaPathCandidates) {
        ErrorOr<std.unique_ptr<MemoryBuffer> > VersionFile = null;
        try {
          if (CudaPath.empty() || !D.getVFS().exists(new Twine(CudaPath))) {
            continue;
          }
          
          InstallPath.$assign(CudaPath);
          BinPath.$assignMove($add_string$C_T(CudaPath, /*KEEP_STR*/"/bin"));
          IncludePath.$assignMove($add_string$C_T(InstallPath, /*KEEP_STR*/"/include"));
          LibDevicePath.$assignMove($add_string$C_T(InstallPath, /*KEEP_STR*/"/nvvm/libdevice"));
          LibPath.$assignMove($add_string$C_T(InstallPath, (TargetTriple.isArch64Bit() ? $("/lib64") : $("/lib"))));
          
          FileSystem /*&*/ FS = D.getVFS();
          if (!(FS.exists(new Twine(IncludePath)) && FS.exists(new Twine(BinPath)) && FS.exists(new Twine(LibPath))
             && FS.exists(new Twine(LibDevicePath)))) {
            continue;
          }
          
          std.error_code EC/*J*/= new std.error_code();
          fs.directory_iterator LI = null;
          fs.directory_iterator LE = null;
          try {
            for (LI/*J*/= new fs.directory_iterator(new Twine(LibDevicePath), EC), LE/*J*/= new fs.directory_iterator();
                 !EC.$bool() && LI.$noteq(LE); LI.$assign(LI.increment(EC))) {
              StringRef FilePath = new StringRef(LI.$arrow().getPath());
              StringRef FileName = path.filename(/*NO_COPY*/FilePath);
              // Process all bitcode filenames that look like libdevice.compute_XX.YY.bc
              /*const*/ StringRef LibDeviceName = new StringRef(/*KEEP_STR*/"libdevice.");
              if (!(FileName.startswith(/*NO_COPY*/LibDeviceName) && FileName.endswith(/*STRINGREF_STR*/".bc"))) {
                continue;
              }
              StringRef GpuArch = FileName.slice(LibDeviceName.size(), FileName.find($$DOT, LibDeviceName.size()));
              LibDeviceMap.$at(/*NO_COPY*/GpuArch).$assignMove(FilePath.str());
              // Insert map entries for specifc devices with this compute capability.
              if ($eq_StringRef(/*NO_COPY*/GpuArch, /*STRINGREF_STR*/"compute_20")) {
                LibDeviceMap.$at(/*STRINGREF_STR*/"sm_20").$assignMove(FilePath.$string());
                LibDeviceMap.$at(/*STRINGREF_STR*/"sm_21").$assignMove(FilePath.$string());
              } else if ($eq_StringRef(/*NO_COPY*/GpuArch, /*STRINGREF_STR*/"compute_30")) {
                LibDeviceMap.$at(/*STRINGREF_STR*/"sm_30").$assignMove(FilePath.$string());
                LibDeviceMap.$at(/*STRINGREF_STR*/"sm_32").$assignMove(FilePath.$string());
              } else if ($eq_StringRef(/*NO_COPY*/GpuArch, /*STRINGREF_STR*/"compute_35")) {
                LibDeviceMap.$at(/*STRINGREF_STR*/"sm_35").$assignMove(FilePath.$string());
                LibDeviceMap.$at(/*STRINGREF_STR*/"sm_37").$assignMove(FilePath.$string());
              } else if ($eq_StringRef(/*NO_COPY*/GpuArch, /*STRINGREF_STR*/"compute_50")) {
                LibDeviceMap.$at(/*STRINGREF_STR*/"sm_50").$assignMove(FilePath.$string());
                LibDeviceMap.$at(/*STRINGREF_STR*/"sm_52").$assignMove(FilePath.$string());
                LibDeviceMap.$at(/*STRINGREF_STR*/"sm_53").$assignMove(FilePath.$string());
                LibDeviceMap.$at(/*STRINGREF_STR*/"sm_60").$assignMove(FilePath.$string());
                LibDeviceMap.$at(/*STRINGREF_STR*/"sm_61").$assignMove(FilePath.$string());
                LibDeviceMap.$at(/*STRINGREF_STR*/"sm_62").$assignMove(FilePath.$string());
              }
            }
          } finally {
            if (LE != null) { LE.$destroy(); }
            if (LI != null) { LI.$destroy(); }
          }
          
          VersionFile = FS.getBufferForFile(new Twine($add_string$C_T(InstallPath, /*KEEP_STR*/"/version.txt")));
          if (!VersionFile.$bool()) {
            // CUDA 7.0 doesn't have a version.txt, so guess that's our version if
            // version.txt isn't present.
            Version = CudaVersion.CUDA_70;
          } else {
            Version = ParseCudaVersionFile((VersionFile.$star()).$arrow().getBuffer());
          }
          
          IsValid = true;
          break;
        } finally {
          if (VersionFile != null) { VersionFile.$destroy(); }
        }
      }
    }

    
    /// \brief Emit an error if Version does not support the given Arch.
    ///
    /// If either Version or Arch is unknown, does not emit an error.  Emits at
    /// most one error per Arch.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::CheckCudaVersionSupportsArch">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1804,
     FQN="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::CheckCudaVersionSupportsArch", NM="_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector28CheckCudaVersionSupportsArchENS_8CudaArchE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector28CheckCudaVersionSupportsArchENS_8CudaArchE")
    //</editor-fold>
    public void CheckCudaVersionSupportsArch(CudaArch Arch) /*const*/ {
      if (Arch == CudaArch.UNKNOWN || Version == CudaVersion.UNKNOWN
         || $greater_uint(ArchsWithVersionTooLowErrors.count(Arch), 0)) {
        return;
      }
      
      CudaVersion RequiredVersion = MinVersionForCudaArch(Arch);
      if (Version.$less(RequiredVersion)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          ArchsWithVersionTooLowErrors.insert(Arch);
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_cuda_version_too_low)), 
                          new StringRef(InstallPath)), CudaArchToString(Arch)), CudaVersionToString(Version)), 
              CudaVersionToString(RequiredVersion)));
        } finally {
          $c$.$destroy();
        }
      }
    }

    
    /// \brief Check whether we detected a valid Cuda install.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::isValid">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 190,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 176,
     FQN="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::isValid", NM="_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector7isValidEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector7isValidEv")
    //</editor-fold>
    public boolean isValid() /*const*/ {
      return IsValid;
    }

    /// \brief Print information about the detected CUDA installation.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::print">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1819,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1695,
     FQN="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::print", NM="_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector5printERN4llvm11raw_ostreamE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector5printERN4llvm11raw_ostreamE")
    //</editor-fold>
    public void print(raw_ostream /*&*/ OS) /*const*/ {
      if (isValid()) {
        OS.$out(/*KEEP_STR*/"Found CUDA installation: ").$out(InstallPath).$out(/*KEEP_STR*/", version ").$out(CudaVersionToString(Version)).$out(/*KEEP_STR*/$LF);
      }
    }

    
    /// \brief Get the deteced Cuda install's version.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::version">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 195,
     FQN="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::version", NM="_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector7versionEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector7versionEv")
    //</editor-fold>
    public CudaVersion version() /*const*/ {
      return Version;
    }

    /// \brief Get the detected Cuda installation path.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::getInstallPath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 197,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 181,
     FQN="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::getInstallPath", NM="_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector14getInstallPathEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector14getInstallPathEv")
    //</editor-fold>
    public StringRef getInstallPath() /*const*/ {
      return new StringRef(InstallPath);
    }

    /// \brief Get the detected path to Cuda's bin directory.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::getBinPath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 199,
     FQN="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::getBinPath", NM="_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector10getBinPathEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector10getBinPathEv")
    //</editor-fold>
    public StringRef getBinPath() /*const*/ {
      return new StringRef(BinPath);
    }

    /// \brief Get the detected Cuda Include path.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::getIncludePath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 201,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 183,
     FQN="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::getIncludePath", NM="_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector14getIncludePathEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector14getIncludePathEv")
    //</editor-fold>
    public StringRef getIncludePath() /*const*/ {
      return new StringRef(IncludePath);
    }

    /// \brief Get the detected Cuda library path.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::getLibPath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 203,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 185,
     FQN="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::getLibPath", NM="_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector10getLibPathEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector10getLibPathEv")
    //</editor-fold>
    public StringRef getLibPath() /*const*/ {
      return new StringRef(LibPath);
    }

    /// \brief Get the detected Cuda device library path.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::getLibDevicePath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 205,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 187,
     FQN="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::getLibDevicePath", NM="_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector16getLibDevicePathEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector16getLibDevicePathEv")
    //</editor-fold>
    public StringRef getLibDevicePath() /*const*/ {
      return new StringRef(LibDevicePath);
    }

    /// \brief Get libdevice file for given architecture
    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::getLibDeviceFile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 207,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 189,
     FQN="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::getLibDeviceFile", NM="_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector16getLibDeviceFileEN4llvm9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC24CudaInstallationDetector16getLibDeviceFileEN4llvm9StringRefE")
    //</editor-fold>
    public std.string getLibDeviceFile(StringRef Gpu) /*const*/ {
      return LibDeviceMap.lookup(new StringRef(Gpu));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::~CudaInstallationDetector">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 163,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 162,
     FQN="clang::driver::toolchains::Generic_GCC::CudaInstallationDetector::~CudaInstallationDetector", NM="_ZN5clang6driver10toolchains11Generic_GCC24CudaInstallationDetectorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCC24CudaInstallationDetectorD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      ArchsWithVersionTooLowErrors.$destroy();
      LibDeviceMap.$destroy();
      IncludePath.$destroy();
      LibDevicePath.$destroy();
      LibPath.$destroy();
      BinPath.$destroy();
      InstallPath.$destroy();
      //END JDestroy
    }

    
    public String toString() {
      return "" + "D=" + D // NOI18N
                + ", IsValid=" + IsValid // NOI18N
                + ", Version=" + Version // NOI18N
                + ", InstallPath=" + InstallPath // NOI18N
                + ", BinPath=" + BinPath // NOI18N
                + ", LibPath=" + LibPath // NOI18N
                + ", LibDevicePath=" + LibDevicePath // NOI18N
                + ", IncludePath=" + IncludePath // NOI18N
                + ", LibDeviceMap=" + LibDeviceMap // NOI18N
                + ", ArchsWithVersionTooLowErrors=" + ArchsWithVersionTooLowErrors; // NOI18N
    }
  };
  
  protected CudaInstallationDetector CudaInstallation;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::Generic_GCC">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2636,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2314,
   FQN="clang::driver::toolchains::Generic_GCC::Generic_GCC", NM="_ZN5clang6driver10toolchains11Generic_GCCC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCCC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public Generic_GCC(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple, 
      /*const*/ ArgList /*&*/ Args) {
    /* : ToolChain(D, Triple, Args), GCCInstallation(D), CudaInstallation(D), Preprocess(), Compile()*/ 
    //START JInit
    super(D, Triple, Args);
    this.GCCInstallation = new GCCInstallationDetector(D);
    this.CudaInstallation = new CudaInstallationDetector(D);
    this.Preprocess = new std.unique_ptr<GccStatics.Preprocessor>();
    this.Compile = new std.unique_ptr<GccStatics.Compiler>();
    //END JInit
    getProgramPaths().push_back(new std.string(getDriver().getInstalledDir()));
    if ($noteq_T_string$C(getDriver().getInstalledDir(), getDriver().Dir)) {
      getProgramPaths().push_back(getDriver().Dir);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::~Generic_GCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2644,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2322,
   FQN="clang::driver::toolchains::Generic_GCC::~Generic_GCC", NM="_ZN5clang6driver10toolchains11Generic_GCCD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11Generic_GCCD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    Compile.$destroy();
    Preprocess.$destroy();
    CudaInstallation.$destroy();
    GCCInstallation.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::printVerboseInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2667,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2345,
   FQN="clang::driver::toolchains::Generic_GCC::printVerboseInfo", NM="_ZNK5clang6driver10toolchains11Generic_GCC16printVerboseInfoERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC16printVerboseInfoERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void printVerboseInfo(raw_ostream /*&*/ OS) /*const*//* override*/ {
    // Print the information about how we detected the GCC installation.
    GCCInstallation.print(OS);
    CudaInstallation.print(OS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::IsUnwindTablesDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2673,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2351,
   FQN="clang::driver::toolchains::Generic_GCC::IsUnwindTablesDefault", NM="_ZNK5clang6driver10toolchains11Generic_GCC21IsUnwindTablesDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC21IsUnwindTablesDefaultEv")
  //</editor-fold>
  @Override public boolean IsUnwindTablesDefault() /*const*//* override*/ {
    return getArch() == Triple.ArchType.x86_64;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::isPICDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2677,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2355,
   FQN="clang::driver::toolchains::Generic_GCC::isPICDefault", NM="_ZNK5clang6driver10toolchains11Generic_GCC12isPICDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC12isPICDefaultEv")
  //</editor-fold>
  @Override public boolean isPICDefault() /*const*//* override*/ {
    return getArch() == Triple.ArchType.x86_64 && getTriple().isOSWindows();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::isPIEDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2681,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2359,
   FQN="clang::driver::toolchains::Generic_GCC::isPIEDefault", NM="_ZNK5clang6driver10toolchains11Generic_GCC12isPIEDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC12isPIEDefaultEv")
  //</editor-fold>
  @Override public boolean isPIEDefault() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::isPICDefaultForced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2683,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2361,
   FQN="clang::driver::toolchains::Generic_GCC::isPICDefaultForced", NM="_ZNK5clang6driver10toolchains11Generic_GCC18isPICDefaultForcedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC18isPICDefaultForcedEv")
  //</editor-fold>
  @Override public boolean isPICDefaultForced() /*const*//* override*/ {
    return getArch() == Triple.ArchType.x86_64 && getTriple().isOSWindows();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::IsIntegratedAssemblerDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2687,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2365,
   FQN="clang::driver::toolchains::Generic_GCC::IsIntegratedAssemblerDefault", NM="_ZNK5clang6driver10toolchains11Generic_GCC28IsIntegratedAssemblerDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC28IsIntegratedAssemblerDefaultEv")
  //</editor-fold>
  @Override public boolean IsIntegratedAssemblerDefault() /*const*//* override*/ {
    switch (getTriple().getArch()) {
     case x86:
     case x86_64:
     case aarch64:
     case aarch64_be:
     case arm:
     case armeb:
     case bpfel:
     case bpfeb:
     case thumb:
     case thumbeb:
     case ppc:
     case ppc64:
     case ppc64le:
     case systemz:
     case mips:
     case mipsel:
      return true;
     default:
      return false;
    }
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::getTool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2646,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2324,
   FQN="clang::driver::toolchains::Generic_GCC::getTool", NM="_ZNK5clang6driver10toolchains11Generic_GCC7getToolENS0_6Action11ActionClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC7getToolENS0_6Action11ActionClassE")
  //</editor-fold>
  @Override protected Tool /*P*/ getTool(Action.ActionClass AC) /*const*//* override*/ {
    switch (AC) {
     case PreprocessJobClass:
      if (!Preprocess.$bool()) {
        Preprocess.reset(new GccStatics.Preprocessor(/*Deref*/this));
      }
      return Preprocess.get();
     case CompileJobClass:
      if (!Compile.$bool()) {
        Compile.reset(new GccStatics.Compiler(/*Deref*/this));
      }
      return Compile.get();
     default:
      return super.getTool(AC);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::buildAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2661,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2339,
   FQN="clang::driver::toolchains::Generic_GCC::buildAssembler", NM="_ZNK5clang6driver10toolchains11Generic_GCC14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC14buildAssemblerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildAssembler() /*const*//* override*/ {
    return new GnutoolsStatics.Assembler(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::buildLinker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2665,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2343,
   FQN="clang::driver::toolchains::Generic_GCC::buildLinker", NM="_ZNK5clang6driver10toolchains11Generic_GCC11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new GccStatics.Linker(/*Deref*/this);
  }

  
  /// \name ToolChain Implementation Helper Functions
  /// @{
  
  /// \brief Check whether the target triple's architecture is 64-bits.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::isTarget64Bit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 236,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 218,
   FQN="clang::driver::toolchains::Generic_GCC::isTarget64Bit", NM="_ZNK5clang6driver10toolchains11Generic_GCC13isTarget64BitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC13isTarget64BitEv")
  //</editor-fold>
  protected boolean isTarget64Bit() /*const*/ {
    return getTriple().isArch64Bit();
  }

  
  /// \brief Check whether the target triple's architecture is 32-bits.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::isTarget32Bit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 239,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 221,
   FQN="clang::driver::toolchains::Generic_GCC::isTarget32Bit", NM="_ZNK5clang6driver10toolchains11Generic_GCC13isTarget32BitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC13isTarget32BitEv")
  //</editor-fold>
  protected boolean isTarget32Bit() /*const*/ {
    return getTriple().isArch32Bit();
  }

  
  
  /// \brief Helper to add the variant paths of a libstdc++ installation.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Generic_GCC::addLibStdCXXIncludePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2712,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2388,
   FQN="clang::driver::toolchains::Generic_GCC::addLibStdCXXIncludePaths", NM="_ZNK5clang6driver10toolchains11Generic_GCC24addLibStdCXXIncludePathsEN4llvm5TwineES4_NS3_9StringRefES5_S5_S4_RKNS3_3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11Generic_GCC24addLibStdCXXIncludePathsEN4llvm5TwineES4_NS3_9StringRefES5_S5_S4_RKNS3_3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  protected boolean addLibStdCXXIncludePaths(Twine Base, Twine Suffix, StringRef GCCTriple, StringRef GCCMultiarchTriple, 
                          StringRef TargetMultiarchTriple, Twine IncludeSuffix, 
                          /*const*/ ArgList /*&*/ DriverArgs, ArgStringList/*&*/ CC1Args) /*const*/ {
    if (!getVFS().exists($add_Twine(Base, Suffix))) {
      return false;
    }
    
    addSystemInclude(DriverArgs, CC1Args, $add_Twine(Base, Suffix));
    
    // The vanilla GCC layout of libstdc++ headers uses a triple subdirectory. If
    // that path exists or we have neither a GCC nor target multiarch triple, use
    // this vanilla search path.
    if ((GCCMultiarchTriple.empty() && TargetMultiarchTriple.empty())
       || getVFS().exists($add_Twine($add_Twine($add_Twine($add_Twine(Base, Suffix), new Twine(/*KEEP_STR*/$SLASH)), new Twine(GCCTriple)), IncludeSuffix))) {
      addSystemInclude(DriverArgs, CC1Args, 
          $add_Twine($add_Twine($add_Twine($add_Twine(Base, Suffix), new Twine(/*KEEP_STR*/$SLASH)), new Twine(GCCTriple)), IncludeSuffix));
    } else {
      // Otherwise try to use multiarch naming schemes which have normalized the
      // triples and put the triple before the suffix.
      //
      // GCC surprisingly uses *both* the GCC triple with a multilib suffix and
      // the target triple, so we support that here.
      addSystemInclude(DriverArgs, CC1Args, 
          $add_Twine($add_Twine($add_Twine($add_Twine(Base, new Twine(/*KEEP_STR*/$SLASH)), new Twine(GCCMultiarchTriple)), Suffix), IncludeSuffix));
      addSystemInclude(DriverArgs, CC1Args, 
          $add_Twine($add_Twine($add_Twine(Base, new Twine(/*KEEP_STR*/$SLASH)), new Twine(TargetMultiarchTriple)), Suffix));
    }
    
    addSystemInclude(DriverArgs, CC1Args, $add_Twine($add_Twine(Base, Suffix), new Twine(/*KEEP_STR*/"/backward")));
    return true;
  }


  /// @}
  /*private:*/
  private /*mutable */std.unique_ptr<GccStatics.Preprocessor> Preprocess;
  private /*mutable */std.unique_ptr<GccStatics.Compiler> Compile;
  
  public String toString() {
    return "" + "GCCInstallation=" + GCCInstallation // NOI18N
              + ", CudaInstallation=" + CudaInstallation // NOI18N
              + ", Preprocess=" + Preprocess // NOI18N
              + ", Compile=" + Compile // NOI18N
              + super.toString(); // NOI18N
  }
}
