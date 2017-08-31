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

package org.llvm.mc.yaml;

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;

/// \brief Specialized YAMLIO scalar type for representing a binary blob.
///
/// A typical use case would be to represent the content of a section in a
/// binary file.
/// This class has custom YAMLIO traits for convenient reading and writing.
/// It renders as a string of hex digits in a YAML file.
/// For example, it might render as `DEADBEEFCAFEBABE` (YAML does not
/// require the quotation marks, so for simplicity when outputting they are
/// omitted).
/// When reading, any string whose content is an even number of hex digits
/// will be accepted.
/// For example, all of the following are acceptable:
/// `DEADBEEF`, `"DeADbEeF"`, `"\x44EADBEEF"` (Note: '\x44' == 'D')
///
/// A significant advantage of using this class is that it never allocates
/// temporary strings or buffers for any of its functionality.
///
/// Example:
///
/// The YAML mapping:
/// \code
/// Foo: DEADBEEFCAFEBABE
/// \endcode
///
/// Could be modeled in YAMLIO by the struct:
/// \code
/// struct FooHolder {
///   BinaryRef Foo;
/// };
/// namespace llvm {
/// namespace yaml {
/// template <>
/// struct MappingTraits<FooHolder> {
///   static void mapping(IO &IO, FooHolder &FH) {
///     IO.mapRequired("Foo", FH.Foo);
///   }
/// };
/// } // end namespace yaml
/// } // end namespace llvm
/// \endcode
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::BinaryRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/YAML.h", line = 48,
 FQN="llvm::yaml::BinaryRef", NM="_ZN4llvm4yaml9BinaryRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/YAML.cpp -nm=_ZN4llvm4yaml9BinaryRefE")
//</editor-fold>
public class BinaryRef {
  /*friend bool operator==(const BinaryRef &LHS, const BinaryRef &RHS)*/
  /// \brief Either raw binary data, or a string of hex bytes (must always
  /// be an even number of characters).
  private ArrayRefUChar Data;
  /// \brief Discriminator between the two states of the `Data` member.
  private boolean DataIsHexString;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::BinaryRef::BinaryRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/YAML.h", line = 57,
   FQN="llvm::yaml::BinaryRef::BinaryRef", NM="_ZN4llvm4yaml9BinaryRefC1ENS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/YAML.cpp -nm=_ZN4llvm4yaml9BinaryRefC1ENS_8ArrayRefIhEE")
  //</editor-fold>
  public BinaryRef(ArrayRefUChar Data) {
    /* : Data(Data), DataIsHexString(false)*/ 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::BinaryRef::BinaryRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/YAML.h", line = 58,
   FQN="llvm::yaml::BinaryRef::BinaryRef", NM="_ZN4llvm4yaml9BinaryRefC1ENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/YAML.cpp -nm=_ZN4llvm4yaml9BinaryRefC1ENS_9StringRefE")
  //</editor-fold>
  public BinaryRef(StringRef Data) {
    /* : Data(reinterpret_cast<const uint8_t * >(Data.data()), Data.size()), DataIsHexString(true)*/ 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::BinaryRef::BinaryRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/YAML.h", line = 61,
   FQN="llvm::yaml::BinaryRef::BinaryRef", NM="_ZN4llvm4yaml9BinaryRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/YAML.cpp -nm=_ZN4llvm4yaml9BinaryRefC1Ev")
  //</editor-fold>
  public BinaryRef() {
    /* : Data(), DataIsHexString(true)*/ 
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// \brief The number of bytes that are represented by this BinaryRef.
  /// This is the number of bytes that writeAsBinary() will write.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::BinaryRef::binary_size">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/YAML.h", line = 64,
   FQN="llvm::yaml::BinaryRef::binary_size", NM="_ZNK4llvm4yaml9BinaryRef11binary_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/YAML.cpp -nm=_ZNK4llvm4yaml9BinaryRef11binary_sizeEv")
  //</editor-fold>
  public /*size_t*/int binary_size() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// \brief Write the contents (regardless of whether it is binary or a
  /// hex string) as binary to the given raw_ostream.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::BinaryRef::writeAsBinary">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/MC/YAML.cpp", line = 40,
   FQN="llvm::yaml::BinaryRef::writeAsBinary", NM="_ZNK4llvm4yaml9BinaryRef13writeAsBinaryERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/YAML.cpp -nm=_ZNK4llvm4yaml9BinaryRef13writeAsBinaryERNS_11raw_ostreamE")
  //</editor-fold>
  public void writeAsBinary(raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// \brief Write the contents (regardless of whether it is binary or a
  /// hex string) as hex to the given raw_ostream.
  ///
  /// For example, a possible output could be `DEADBEEFCAFEBABE`.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::BinaryRef::writeAsHex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/MC/YAML.cpp", line = 52,
   FQN="llvm::yaml::BinaryRef::writeAsHex", NM="_ZNK4llvm4yaml9BinaryRef10writeAsHexERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/YAML.cpp -nm=_ZNK4llvm4yaml9BinaryRef10writeAsHexERNS_11raw_ostreamE")
  //</editor-fold>
  public void writeAsHex(raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::BinaryRef::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/YAML.h", line = 48,
   FQN="llvm::yaml::BinaryRef::operator=", NM="_ZN4llvm4yaml9BinaryRefaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/YAML.cpp -nm=_ZN4llvm4yaml9BinaryRefaSEOS1_")
  //</editor-fold>
  public /*inline*/ BinaryRef /*&*/ $assignMove(BinaryRef /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  public String toString() {
    return "" + "Data=" + Data // NOI18N
              + ", DataIsHexString=" + DataIsHexString; // NOI18N
  }
}
