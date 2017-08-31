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

package org.clang.sema;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;


/// \brief Represents a C++11 virt-specifier-seq.
//<editor-fold defaultstate="collapsed" desc="clang::VirtSpecifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2276,
 FQN="clang::VirtSpecifiers", NM="_ZN5clang14VirtSpecifiersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang14VirtSpecifiersE")
//</editor-fold>
public class VirtSpecifiers {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::VirtSpecifiers::Specifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2278,
   FQN="clang::VirtSpecifiers::Specifier", NM="_ZN5clang14VirtSpecifiers9SpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang14VirtSpecifiers9SpecifierE")
  //</editor-fold>
  public enum Specifier implements Native.ComparableLower {
    VS_None(0),
    VS_Override(1),
    VS_Final(2),
    VS_Sealed(4);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Specifier valueOf(int val) {
      Specifier out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Specifier[] VALUES;
      private static final Specifier[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Specifier kind : Specifier.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Specifier[min < 0 ? (1-min) : 0];
        VALUES = new Specifier[max >= 0 ? (1+max) : 0];
        for (Specifier kind : Specifier.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Specifier(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Specifier)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Specifier)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::VirtSpecifiers::VirtSpecifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2285,
   FQN="clang::VirtSpecifiers::VirtSpecifiers", NM="_ZN5clang14VirtSpecifiersC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang14VirtSpecifiersC1Ev")
  //</editor-fold>
  public VirtSpecifiers() {
    // : Specifiers(0), LastSpecifier(VS_None), VS_overrideLoc(), VS_finalLoc(), FirstLocation(), LastLocation() 
    //START JInit
    this.Specifiers = 0;
    this.LastSpecifier = Specifier.VS_None;
    this.VS_overrideLoc = new SourceLocation();
    this.VS_finalLoc = new SourceLocation();
    this.FirstLocation = new SourceLocation();
    this.LastLocation = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VirtSpecifiers::SetSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 1253,
   FQN="clang::VirtSpecifiers::SetSpecifier", NM="_ZN5clang14VirtSpecifiers12SetSpecifierENS0_9SpecifierENS_14SourceLocationERPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang14VirtSpecifiers12SetSpecifierENS0_9SpecifierENS_14SourceLocationERPKc")
  //</editor-fold>
  public boolean SetSpecifier(Specifier VS, SourceLocation Loc, 
              final char$ptr/*const char P &*/ PrevSpec) {
    if (!FirstLocation.isValid()) {
      FirstLocation.$assign(Loc);
    }
    LastLocation.$assign(Loc);
    LastSpecifier = VS;
    if (((Specifiers & VS.getValue()) != 0)) {
      PrevSpec.$assign(getSpecifierName(VS));
      return true;
    }
    
    Specifiers |= VS.getValue();
    switch (VS) {
     default:
      throw new llvm_unreachable("Unknown specifier!");
     case VS_Override:
      VS_overrideLoc.$assign(Loc);
      break;
     case VS_Sealed:
     case VS_Final:
      VS_finalLoc.$assign(Loc);
      break;
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VirtSpecifiers::isUnset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2290,
   FQN="clang::VirtSpecifiers::isUnset", NM="_ZNK5clang14VirtSpecifiers7isUnsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang14VirtSpecifiers7isUnsetEv")
  //</editor-fold>
  public boolean isUnset() /*const*/ {
    return Specifiers == 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VirtSpecifiers::isOverrideSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2292,
   FQN="clang::VirtSpecifiers::isOverrideSpecified", NM="_ZNK5clang14VirtSpecifiers19isOverrideSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang14VirtSpecifiers19isOverrideSpecifiedEv")
  //</editor-fold>
  public boolean isOverrideSpecified() /*const*/ {
    return ((Specifiers & Specifier.VS_Override.getValue()) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VirtSpecifiers::getOverrideLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2293,
   FQN="clang::VirtSpecifiers::getOverrideLoc", NM="_ZNK5clang14VirtSpecifiers14getOverrideLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang14VirtSpecifiers14getOverrideLocEv")
  //</editor-fold>
  public SourceLocation getOverrideLoc() /*const*/ {
    return new SourceLocation(VS_overrideLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VirtSpecifiers::isFinalSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2295,
   FQN="clang::VirtSpecifiers::isFinalSpecified", NM="_ZNK5clang14VirtSpecifiers16isFinalSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang14VirtSpecifiers16isFinalSpecifiedEv")
  //</editor-fold>
  public boolean isFinalSpecified() /*const*/ {
    return ((Specifiers & (Specifier.VS_Final.getValue() | Specifier.VS_Sealed.getValue())) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VirtSpecifiers::isFinalSpelledSealed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2296,
   FQN="clang::VirtSpecifiers::isFinalSpelledSealed", NM="_ZNK5clang14VirtSpecifiers20isFinalSpelledSealedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang14VirtSpecifiers20isFinalSpelledSealedEv")
  //</editor-fold>
  public boolean isFinalSpelledSealed() /*const*/ {
    return ((Specifiers & Specifier.VS_Sealed.getValue()) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VirtSpecifiers::getFinalLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2297,
   FQN="clang::VirtSpecifiers::getFinalLoc", NM="_ZNK5clang14VirtSpecifiers11getFinalLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang14VirtSpecifiers11getFinalLocEv")
  //</editor-fold>
  public SourceLocation getFinalLoc() /*const*/ {
    return new SourceLocation(VS_finalLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VirtSpecifiers::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2299,
   FQN="clang::VirtSpecifiers::clear", NM="_ZN5clang14VirtSpecifiers5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang14VirtSpecifiers5clearEv")
  //</editor-fold>
  public void clear() {
    Specifiers = 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VirtSpecifiers::getSpecifierName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 1277,
   FQN="clang::VirtSpecifiers::getSpecifierName", NM="_ZN5clang14VirtSpecifiers16getSpecifierNameENS0_9SpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang14VirtSpecifiers16getSpecifierNameENS0_9SpecifierE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getSpecifierName(Specifier VS) {
    switch (VS) {
     default:
      throw new llvm_unreachable("Unknown specifier");
     case VS_Override:
      return $("override");
     case VS_Final:
      return $("final");
     case VS_Sealed:
      return $("sealed");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VirtSpecifiers::getFirstLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2303,
   FQN="clang::VirtSpecifiers::getFirstLocation", NM="_ZNK5clang14VirtSpecifiers16getFirstLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang14VirtSpecifiers16getFirstLocationEv")
  //</editor-fold>
  public SourceLocation getFirstLocation() /*const*/ {
    return new SourceLocation(FirstLocation);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VirtSpecifiers::getLastLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2304,
   FQN="clang::VirtSpecifiers::getLastLocation", NM="_ZNK5clang14VirtSpecifiers15getLastLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang14VirtSpecifiers15getLastLocationEv")
  //</editor-fold>
  public SourceLocation getLastLocation() /*const*/ {
    return new SourceLocation(LastLocation);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VirtSpecifiers::getLastSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 2305,
   FQN="clang::VirtSpecifiers::getLastSpecifier", NM="_ZNK5clang14VirtSpecifiers16getLastSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang14VirtSpecifiers16getLastSpecifierEv")
  //</editor-fold>
  public Specifier getLastSpecifier() /*const*/ {
    return LastSpecifier;
  }

/*private:*/
  private /*uint*/int Specifiers;
  private Specifier LastSpecifier;
  
  private SourceLocation VS_overrideLoc;
  
  private SourceLocation VS_finalLoc;
  private SourceLocation FirstLocation;
  private SourceLocation LastLocation;
  
  @Override public String toString() {
    return "" + "Specifiers=" + Specifiers // NOI18N
              + ", LastSpecifier=" + LastSpecifier // NOI18N
              + ", VS_overrideLoc=" + VS_overrideLoc // NOI18N
              + ", VS_finalLoc=" + VS_finalLoc // NOI18N
              + ", FirstLocation=" + FirstLocation // NOI18N
              + ", LastLocation=" + LastLocation; // NOI18N
  }
}
