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

package org.clang.basic;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.VersionTuple.*;


/// \brief The basic abstraction for the target Objective-C runtime.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, // needed to generate some functions using 2nd TU
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 25,
 FQN="clang::ObjCRuntime", NM="_ZN5clang11ObjCRuntimeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang11ObjCRuntimeE")
//</editor-fold>
public class ObjCRuntime {
/*public:*/
  /// \brief The basic Objective-C runtimes that we know about.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 28,
   FQN="clang::ObjCRuntime::Kind", NM="_ZN5clang11ObjCRuntime4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang11ObjCRuntime4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    /// 'macosx' is the Apple-provided NeXT-derived runtime on Mac OS
    /// X platforms that use the non-fragile ABI; the version is a
    /// release of that OS.
    MacOSX(0),
    
    /// 'macosx-fragile' is the Apple-provided NeXT-derived runtime on
    /// Mac OS X platforms that use the fragile ABI; the version is a
    /// release of that OS.
    FragileMacOSX(MacOSX.getValue() + 1),
    
    /// 'ios' is the Apple-provided NeXT-derived runtime on iOS or the iOS
    /// simulator;  it is always non-fragile.  The version is a release
    /// version of iOS.
    iOS(FragileMacOSX.getValue() + 1),
    
    /// 'watchos' is a variant of iOS for Apple's watchOS. The version
    /// is a release version of watchOS.
    WatchOS(iOS.getValue() + 1),
    
    /// 'gcc' is the Objective-C runtime shipped with GCC, implementing a
    /// fragile Objective-C ABI
    GCC(WatchOS.getValue() + 1),
    
    /// 'gnustep' is the modern non-fragile GNUstep runtime.
    GNUstep(GCC.getValue() + 1),
    
    /// 'objfw' is the Objective-C runtime included in ObjFW
    ObjFW(GNUstep.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private Kind TheKind;
  private VersionTuple Version;
/*public:*/
  /// A bogus initialization of the runtime.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::ObjCRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 65,
   FQN="clang::ObjCRuntime::ObjCRuntime", NM="_ZN5clang11ObjCRuntimeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang11ObjCRuntimeC1Ev")
  //</editor-fold>
  public ObjCRuntime() {
    /* : TheKind(MacOSX), Version()*/ 
    //START JInit
    this.TheKind = Kind.MacOSX;
    this.Version = new VersionTuple();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::ObjCRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 67,
   FQN="clang::ObjCRuntime::ObjCRuntime", NM="_ZN5clang11ObjCRuntimeC1ENS0_4KindERKNS_12VersionTupleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang11ObjCRuntimeC1ENS0_4KindERKNS_12VersionTupleE")
  //</editor-fold>
  public ObjCRuntime(Kind kind, /*const*/ VersionTuple /*&*/ version) {
    /* : TheKind(kind), Version(version)*/ 
    //START JInit
    this.TheKind = kind;
    this.Version = new VersionTuple(version);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::set">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 70,
   FQN="clang::ObjCRuntime::set", NM="_ZN5clang11ObjCRuntime3setENS0_4KindENS_12VersionTupleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang11ObjCRuntime3setENS0_4KindENS_12VersionTupleE")
  //</editor-fold>
  public void set(Kind kind, VersionTuple version) {
    TheKind = kind;
    Version.$assign(version);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 75,
   FQN="clang::ObjCRuntime::getKind", NM="_ZNK5clang11ObjCRuntime7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return TheKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::getVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 76,
   FQN="clang::ObjCRuntime::getVersion", NM="_ZNK5clang11ObjCRuntime10getVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime10getVersionEv")
  //</editor-fold>
  public /*const*/ VersionTuple /*&*/ getVersion() /*const*/ {
    return Version;
  }

  
  /// \brief Does this runtime follow the set of implied behaviors for a
  /// "non-fragile" ABI?
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::isNonFragile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 80,
   FQN="clang::ObjCRuntime::isNonFragile", NM="_ZNK5clang11ObjCRuntime12isNonFragileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime12isNonFragileEv")
  //</editor-fold>
  public boolean isNonFragile() /*const*/ {
    switch (getKind()) {
     case FragileMacOSX:
      return false;
     case GCC:
      return false;
     case MacOSX:
      return true;
     case GNUstep:
      return true;
     case ObjFW:
      return true;
     case iOS:
      return true;
     case WatchOS:
      return true;
    }
    throw new llvm_unreachable("bad kind");
  }

  
  /// The inverse of isNonFragile():  does this runtime follow the set of
  /// implied behaviors for a "fragile" ABI?
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::isFragile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 95,
   FQN="clang::ObjCRuntime::isFragile", NM="_ZNK5clang11ObjCRuntime9isFragileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime9isFragileEv")
  //</editor-fold>
  public boolean isFragile() /*const*/ {
    return !isNonFragile();
  }

  
  /// The default dispatch mechanism to use for the specified architecture
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::isLegacyDispatchDefaultForArch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 98,
   FQN="clang::ObjCRuntime::isLegacyDispatchDefaultForArch", NM="_ZN5clang11ObjCRuntime30isLegacyDispatchDefaultForArchEN4llvm6Triple8ArchTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang11ObjCRuntime30isLegacyDispatchDefaultForArchEN4llvm6Triple8ArchTypeE")
  //</editor-fold>
  public boolean isLegacyDispatchDefaultForArch(Triple.ArchType Arch) {
    // The GNUstep runtime uses a newer dispatch method by default from
    // version 1.6 onwards
    if (getKind() == Kind.GNUstep && $greatereq_VersionTuple$C(getVersion(), new VersionTuple(1, 6))) {
      if (Arch == Triple.ArchType.arm
         || Arch == Triple.ArchType.x86
         || Arch == Triple.ArchType.x86_64) {
        return false;
      }
    } else if ((getKind() == Kind.MacOSX) && isNonFragile()
       && ($greatereq_VersionTuple$C(getVersion(), new VersionTuple(10, 0)))
       && ($less_VersionTuple$C(getVersion(), new VersionTuple(10, 6)))) {
      return Arch != Triple.ArchType.x86_64;
    }
    // Except for deployment target of 10.5 or less,
    // Mac runtimes use legacy dispatch everywhere now.
    return true;
  }

  
  /// \brief Is this runtime basically of the GNU family of runtimes?
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::isGNUFamily">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 117,
   FQN="clang::ObjCRuntime::isGNUFamily", NM="_ZNK5clang11ObjCRuntime11isGNUFamilyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime11isGNUFamilyEv")
  //</editor-fold>
  public boolean isGNUFamily() /*const*/ {
    switch (getKind()) {
     case FragileMacOSX:
     case MacOSX:
     case iOS:
     case WatchOS:
      return false;
     case GCC:
     case GNUstep:
     case ObjFW:
      return true;
    }
    throw new llvm_unreachable("bad kind");
  }

  
  /// \brief Is this runtime basically of the NeXT family of runtimes?
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::isNeXTFamily">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 133,
   FQN="clang::ObjCRuntime::isNeXTFamily", NM="_ZNK5clang11ObjCRuntime12isNeXTFamilyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime12isNeXTFamilyEv")
  //</editor-fold>
  public boolean isNeXTFamily() /*const*/ {
    // For now, this is just the inverse of isGNUFamily(), but that's
    // not inherently true.
    return !isGNUFamily();
  }

  
  /// \brief Does this runtime allow ARC at all?
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::allowsARC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 140,
   FQN="clang::ObjCRuntime::allowsARC", NM="_ZNK5clang11ObjCRuntime9allowsARCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime9allowsARCEv")
  //</editor-fold>
  public boolean allowsARC() /*const*/ {
    switch (getKind()) {
     case FragileMacOSX:
      // No stub library for the fragile runtime.
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(10, 7));
     case MacOSX:
      return true;
     case iOS:
      return true;
     case WatchOS:
      return true;
     case GCC:
      return false;
     case GNUstep:
      return true;
     case ObjFW:
      return true;
    }
    throw new llvm_unreachable("bad kind");
  }

  
  /// \brief Does this runtime natively provide the ARC entrypoints? 
  ///
  /// ARC cannot be directly supported on a platform that does not provide
  /// these entrypoints, although it may be supportable via a stub
  /// library.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::hasNativeARC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 160,
   FQN="clang::ObjCRuntime::hasNativeARC", NM="_ZNK5clang11ObjCRuntime12hasNativeARCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime12hasNativeARCEv")
  //</editor-fold>
  public boolean hasNativeARC() /*const*/ {
    switch (getKind()) {
     case FragileMacOSX:
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(10, 7));
     case MacOSX:
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(10, 7));
     case iOS:
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(5));
     case WatchOS:
      return true;
     case GCC:
      return false;
     case GNUstep:
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(1, 6));
     case ObjFW:
      return true;
    }
    throw new llvm_unreachable("bad kind");
  }

  
  /// \brief Does this runtime supports optimized setter entrypoints?
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::hasOptimizedSetter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 175,
   FQN="clang::ObjCRuntime::hasOptimizedSetter", NM="_ZNK5clang11ObjCRuntime18hasOptimizedSetterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime18hasOptimizedSetterEv")
  //</editor-fold>
  public boolean hasOptimizedSetter() /*const*/ {
    switch (getKind()) {
     case MacOSX:
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(10, 8));
     case iOS:
      return ($greatereq_VersionTuple$C(getVersion(), new VersionTuple(6)));
     case WatchOS:
      return true;
     case GNUstep:
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(1, 7));
     default:
      return false;
    }
  }

  
  /// Does this runtime allow the use of __weak?
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::allowsWeak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 192,
   FQN="clang::ObjCRuntime::allowsWeak", NM="_ZNK5clang11ObjCRuntime10allowsWeakEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime10allowsWeakEv")
  //</editor-fold>
  public boolean allowsWeak() /*const*/ {
    return hasNativeWeak();
  }

  
  /// \brief Does this runtime natively provide ARC-compliant 'weak'
  /// entrypoints?
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::hasNativeWeak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 198,
   FQN="clang::ObjCRuntime::hasNativeWeak", NM="_ZNK5clang11ObjCRuntime13hasNativeWeakEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime13hasNativeWeakEv")
  //</editor-fold>
  public boolean hasNativeWeak() /*const*/ {
    // Right now, this is always equivalent to whether the runtime
    // natively supports ARC decision.
    return hasNativeARC();
  }

  
  /// \brief Does this runtime directly support the subscripting methods?
  ///
  /// This is really a property of the library, not the runtime.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::hasSubscripting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 207,
   FQN="clang::ObjCRuntime::hasSubscripting", NM="_ZNK5clang11ObjCRuntime15hasSubscriptingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime15hasSubscriptingEv")
  //</editor-fold>
  public boolean hasSubscripting() /*const*/ {
    switch (getKind()) {
     case FragileMacOSX:
      return false;
     case MacOSX:
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(10, 8));
     case iOS:
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(6));
     case WatchOS:
      return true;
     case GCC:
      
      // This is really a lie, because some implementations and versions
      // of the runtime do not support ARC.  Probably -fgnu-runtime
      // should imply a "maximal" runtime or something?
      return true;
     case GNUstep:
      return true;
     case ObjFW:
      return true;
    }
    throw new llvm_unreachable("bad kind");
  }

  
  /// \brief Does this runtime allow sizeof or alignof on object types?
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::allowsSizeofAlignof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 225,
   FQN="clang::ObjCRuntime::allowsSizeofAlignof", NM="_ZNK5clang11ObjCRuntime19allowsSizeofAlignofEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime19allowsSizeofAlignofEv")
  //</editor-fold>
  public boolean allowsSizeofAlignof() /*const*/ {
    return isFragile();
  }

  
  /// \brief Does this runtime allow pointer arithmetic on objects?
  ///
  /// This covers +, -, ++, --, and (if isSubscriptPointerArithmetic()
  /// yields true) [].
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::allowsPointerArithmetic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 233,
   FQN="clang::ObjCRuntime::allowsPointerArithmetic", NM="_ZNK5clang11ObjCRuntime23allowsPointerArithmeticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime23allowsPointerArithmeticEv")
  //</editor-fold>
  public boolean allowsPointerArithmetic() /*const*/ {
    switch (getKind()) {
     case FragileMacOSX:
     case GCC:
      return true;
     case MacOSX:
     case iOS:
     case WatchOS:
     case GNUstep:
     case ObjFW:
      return false;
    }
    throw new llvm_unreachable("bad kind");
  }

  
  /// \brief Is subscripting pointer arithmetic?
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::isSubscriptPointerArithmetic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 249,
   FQN="clang::ObjCRuntime::isSubscriptPointerArithmetic", NM="_ZNK5clang11ObjCRuntime28isSubscriptPointerArithmeticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime28isSubscriptPointerArithmeticEv")
  //</editor-fold>
  public boolean isSubscriptPointerArithmetic() /*const*/ {
    return allowsPointerArithmetic();
  }

  
  /// \brief Does this runtime provide an objc_terminate function?
  ///
  /// This is used in handlers for exceptions during the unwind process;
  /// without it, abort() must be used in pure ObjC files.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::hasTerminate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 257,
   FQN="clang::ObjCRuntime::hasTerminate", NM="_ZNK5clang11ObjCRuntime12hasTerminateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime12hasTerminateEv")
  //</editor-fold>
  public boolean hasTerminate() /*const*/ {
    switch (getKind()) {
     case FragileMacOSX:
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(10, 8));
     case MacOSX:
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(10, 8));
     case iOS:
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(5));
     case WatchOS:
      return true;
     case GCC:
      return false;
     case GNUstep:
      return false;
     case ObjFW:
      return false;
    }
    throw new llvm_unreachable("bad kind");
  }

  
  /// \brief Does this runtime support weakly importing classes?
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::hasWeakClassImport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 271,
   FQN="clang::ObjCRuntime::hasWeakClassImport", NM="_ZNK5clang11ObjCRuntime18hasWeakClassImportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime18hasWeakClassImportEv")
  //</editor-fold>
  public boolean hasWeakClassImport() /*const*/ {
    switch (getKind()) {
     case MacOSX:
      return true;
     case iOS:
      return true;
     case WatchOS:
      return true;
     case FragileMacOSX:
      return false;
     case GCC:
      return true;
     case GNUstep:
      return true;
     case ObjFW:
      return true;
    }
    throw new llvm_unreachable("bad kind");
  }

  
  /// \brief Does this runtime use zero-cost exceptions?
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::hasUnwindExceptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 285,
   FQN="clang::ObjCRuntime::hasUnwindExceptions", NM="_ZNK5clang11ObjCRuntime19hasUnwindExceptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime19hasUnwindExceptionsEv")
  //</editor-fold>
  public boolean hasUnwindExceptions() /*const*/ {
    switch (getKind()) {
     case MacOSX:
      return true;
     case iOS:
      return true;
     case WatchOS:
      return true;
     case FragileMacOSX:
      return false;
     case GCC:
      return true;
     case GNUstep:
      return true;
     case ObjFW:
      return true;
    }
    throw new llvm_unreachable("bad kind");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::hasAtomicCopyHelper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 298,
   FQN="clang::ObjCRuntime::hasAtomicCopyHelper", NM="_ZNK5clang11ObjCRuntime19hasAtomicCopyHelperEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime19hasAtomicCopyHelperEv")
  //</editor-fold>
  public boolean hasAtomicCopyHelper() /*const*/ {
    switch (getKind()) {
     case FragileMacOSX:
     case MacOSX:
     case iOS:
     case WatchOS:
      return true;
     case GNUstep:
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(1, 7));
     default:
      return false;
    }
  }

  
  /// Is objc_unsafeClaimAutoreleasedReturnValue available?
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::hasARCUnsafeClaimAutoreleasedReturnValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 312,
   FQN="clang::ObjCRuntime::hasARCUnsafeClaimAutoreleasedReturnValue", NM="_ZNK5clang11ObjCRuntime40hasARCUnsafeClaimAutoreleasedReturnValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang11ObjCRuntime40hasARCUnsafeClaimAutoreleasedReturnValueEv")
  //</editor-fold>
  public boolean hasARCUnsafeClaimAutoreleasedReturnValue() /*const*/ {
    switch (getKind()) {
     case MacOSX:
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(10, 11));
     case iOS:
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(9));
     case WatchOS:
      return $greatereq_VersionTuple$C(getVersion(), new VersionTuple(2));
     case GNUstep:
      return false;
     default:
      return false;
    }
  }
  
  
  /// \brief Try to parse an Objective-C runtime specification from the given
  /// string.
  ///
  /// \return true on error.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::tryParse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/ObjCRuntime.cpp", line = 44,
   FQN="clang::ObjCRuntime::tryParse", NM="_ZN5clang11ObjCRuntime8tryParseEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/ObjCRuntime.cpp -nm=_ZN5clang11ObjCRuntime8tryParseEN4llvm9StringRefE")
  //</editor-fold>
  public boolean tryParse(StringRef input) {
    // Look for the last dash.
    /*uint*/int dash = input.rfind($$MINUS);
    
    // We permit dashes in the runtime name, and we also permit the
    // version to be omitted, so if we see a dash not followed by a
    // digit then we need to ignore it.
    if (dash != StringRef.npos && dash + 1 != input.size()
       && (input.$at(dash + 1) < $$0 || input.$at(dash + 1) > $$9)) {
      dash = StringRef.npos;
    }
    
    // Everything prior to that must be a valid string name.
    Kind kind;
    StringRef runtimeName = input.substr(0, dash);
    Version.$assignMove(new VersionTuple(0));
    if ($eq_StringRef(/*NO_COPY*/runtimeName, /*STRINGREF_STR*/"macosx")) {
      kind = ObjCRuntime.Kind.MacOSX;
    } else if ($eq_StringRef(/*NO_COPY*/runtimeName, /*STRINGREF_STR*/"macosx-fragile")) {
      kind = ObjCRuntime.Kind.FragileMacOSX;
    } else if ($eq_StringRef(/*NO_COPY*/runtimeName, /*STRINGREF_STR*/"ios")) {
      kind = ObjCRuntime.Kind.iOS;
    } else if ($eq_StringRef(/*NO_COPY*/runtimeName, /*STRINGREF_STR*/"watchos")) {
      kind = ObjCRuntime.Kind.WatchOS;
    } else if ($eq_StringRef(/*NO_COPY*/runtimeName, /*STRINGREF_STR*/"gnustep")) {
      // If no version is specified then default to the most recent one that we
      // know about.
      Version.$assignMove(new VersionTuple(1, 6));
      kind = ObjCRuntime.Kind.GNUstep;
    } else if ($eq_StringRef(/*NO_COPY*/runtimeName, /*STRINGREF_STR*/"gcc")) {
      kind = ObjCRuntime.Kind.GCC;
    } else if ($eq_StringRef(/*NO_COPY*/runtimeName, /*STRINGREF_STR*/"objfw")) {
      kind = ObjCRuntime.Kind.ObjFW;
      Version.$assignMove(new VersionTuple(0, 8));
    } else {
      return true;
    }
    TheKind = kind;
    if (dash != StringRef.npos) {
      StringRef verString = input.substr(dash + 1);
      if (Version.tryParse(/*NO_COPY*/verString)) {
        return true;
      }
    }
    if (kind == ObjCRuntime.Kind.ObjFW && $greater_VersionTuple$C(Version, new VersionTuple(0, 8))) {
      Version.$assignMove(new VersionTuple(0, 8));
    }
    
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/ObjCRuntime.cpp", line = 19,
   FQN="clang::ObjCRuntime::getAsString", NM="_ZNK5clang11ObjCRuntime11getAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/ObjCRuntime.cpp -nm=_ZNK5clang11ObjCRuntime11getAsStringEv")
  //</editor-fold>
  public std.string getAsString() /*const*/ {
    std.string Result/*J*/= new std.string();
    {
      raw_string_ostream Out = null;
      try {
        Out/*J*/= new raw_string_ostream(Result);
        $out_raw_ostream_ObjCRuntime$C(Out, /*Deref*/this);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    return Result;
  }


  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 336,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", old_line = 319,
   FQN="clang::operator==", NM="_ZN5clangeqERKNS_11ObjCRuntimeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clangeqERKNS_11ObjCRuntimeES2_")
  //</editor-fold>
  public static boolean $eq_ObjCRuntime$C(/*const*/ ObjCRuntime /*&*/ left, /*const*/ ObjCRuntime /*&*/ right) {
    return left.getKind() == right.getKind()
       && $eq_VersionTuple$C(left.getVersion(), right.getVersion());
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 341,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", old_line = 324,
   FQN="clang::operator!=", NM="_ZN5clangneERKNS_11ObjCRuntimeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clangneERKNS_11ObjCRuntimeES2_")
  //</editor-fold>
  public static boolean $noteq_ObjCRuntime$C(/*const*/ ObjCRuntime /*&*/ left, /*const*/ ObjCRuntime /*&*/ right) {
    return !($eq_ObjCRuntime$C(left, right));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::ObjCRuntime">
  @Converted(kind = Converted.Kind.AUTO, 
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 25,
   FQN="clang::ObjCRuntime::ObjCRuntime", NM="_ZN5clang11ObjCRuntimeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang11ObjCRuntimeC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ObjCRuntime(/*const*/ ObjCRuntime /*&*/ $Prm0) {
    /* : TheKind(.TheKind), Version(.Version)*/ 
    //START JInit
    this.TheKind = $Prm0.TheKind;
    this.Version = new VersionTuple($Prm0.Version);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::ObjCRuntime">
  @Converted(kind = Converted.Kind.AUTO, 
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 25,
   FQN="clang::ObjCRuntime::ObjCRuntime", NM="_ZN5clang11ObjCRuntimeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang11ObjCRuntimeC1EOS0_")
  //</editor-fold>
  public /*inline*/ ObjCRuntime(JD$Move _dparam, ObjCRuntime /*&&*/$Prm0) {
    /* : TheKind(static_cast<ObjCRuntime &&>().TheKind), Version(static_cast<ObjCRuntime &&>().Version)*/ 
    //START JInit
    this.TheKind = $Prm0.TheKind;
    this.Version = new VersionTuple(JD$Move.INSTANCE, $Prm0.Version);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::operator=">
  @Converted(kind = Converted.Kind.AUTO, 
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 25,
   FQN="clang::ObjCRuntime::operator=", NM="_ZN5clang11ObjCRuntimeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang11ObjCRuntimeaSERKS0_")
  //</editor-fold>
  public /*inline*/ ObjCRuntime /*&*/ $assign(/*const*/ ObjCRuntime /*&*/ $Prm0) {
    this.TheKind = $Prm0.TheKind;
    this.Version.$assign($Prm0.Version);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntime::operator=">
  @Converted(kind = Converted.Kind.AUTO, 
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ObjCRuntime.h", line = 25,
   FQN="clang::ObjCRuntime::operator=", NM="_ZN5clang11ObjCRuntimeaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang11ObjCRuntimeaSEOS0_")
  //</editor-fold>
  public /*inline*/ ObjCRuntime /*&*/ $assignMove(ObjCRuntime /*&&*/$Prm0) {
    this.TheKind = $Prm0.TheKind;
    this.Version.$assignMove($Prm0.Version);
    return /*Deref*/this;
  }

  
  public String toString() {
    return "" + "TheKind=" + TheKind // NOI18N
              + ", Version=" + Version; // NOI18N
  }
}
