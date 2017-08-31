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

package org.clang.driver.impl;

import org.clank.support.*;
import org.clang.driver.impl.*;


/// Distribution (very bare-bones at the moment).
//<editor-fold defaultstate="collapsed" desc="Distro">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3714,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3373,
 FQN="Distro", NM="_Z6Distro",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_Z6Distro")
//</editor-fold>
public enum Distro implements Native.ComparableLower {
  // NB: Releases of a particular Linux distro should be kept together
  // in this enum, because some tests are done by integer comparison against
  // the first and last known member in the family, e.g. IsRedHat().
  ArchLinux(0),
  DebianLenny(ArchLinux.getValue() + 1),
  DebianSqueeze(DebianLenny.getValue() + 1),
  DebianWheezy(DebianSqueeze.getValue() + 1),
  DebianJessie(DebianWheezy.getValue() + 1),
  DebianStretch(DebianJessie.getValue() + 1),
  Exherbo(DebianStretch.getValue() + 1),
  RHEL5(Exherbo.getValue() + 1),
  RHEL6(RHEL5.getValue() + 1),
  RHEL7(RHEL6.getValue() + 1),
  Fedora(RHEL7.getValue() + 1),
  OpenSUSE(Fedora.getValue() + 1),
  UbuntuHardy(OpenSUSE.getValue() + 1),
  UbuntuIntrepid(UbuntuHardy.getValue() + 1),
  UbuntuJaunty(UbuntuIntrepid.getValue() + 1),
  UbuntuKarmic(UbuntuJaunty.getValue() + 1),
  UbuntuLucid(UbuntuKarmic.getValue() + 1),
  UbuntuMaverick(UbuntuLucid.getValue() + 1),
  UbuntuNatty(UbuntuMaverick.getValue() + 1),
  UbuntuOneiric(UbuntuNatty.getValue() + 1),
  UbuntuPrecise(UbuntuOneiric.getValue() + 1),
  UbuntuQuantal(UbuntuPrecise.getValue() + 1),
  UbuntuRaring(UbuntuQuantal.getValue() + 1),
  UbuntuSaucy(UbuntuRaring.getValue() + 1),
  UbuntuTrusty(UbuntuSaucy.getValue() + 1),
  UbuntuUtopic(UbuntuTrusty.getValue() + 1),
  UbuntuVivid(UbuntuUtopic.getValue() + 1),
  UbuntuWily(UbuntuVivid.getValue() + 1),
  UbuntuXenial(UbuntuWily.getValue() + 1),
  UnknownDistro(UbuntuXenial.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static Distro valueOf(int val) {
    Distro out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final Distro[] VALUES;
    private static final Distro[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (Distro kind : Distro.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new Distro[min < 0 ? (1-min) : 0];
      VALUES = new Distro[max >= 0 ? (1+max) : 0];
      for (Distro kind : Distro.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private Distro(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Distro)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Distro)obj).value);}
  //</editor-fold>
}
